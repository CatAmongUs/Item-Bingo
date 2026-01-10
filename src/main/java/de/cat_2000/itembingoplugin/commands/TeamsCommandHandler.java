package main.java.de.cat_2000.itembingoplugin.commands;

import java.util.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import main.java.de.cat_2000.itembingoplugin.Main;
import main.java.de.cat_2000.itembingoplugin.TeamHandler;

public class TeamsCommandHandler implements CommandExecutor {

	private final String errorMessageSender = ChatColor.RED + "Can only perform as a player";
	private final String errorMessageFormat = ChatColor.RED + "Usage: /teams [player1team1,player2team1][player1team2,player2team2]";
	private final String errorMessageRunning = ChatColor.RED + "Cannot modify teams while a game is running!";
	private final String errorDuplicatePlayer = ChatColor.RED + "Any player can only be in one team at a time!";
	private final String successMessage = ChatColor.GREEN + "Teams have been set";
	private final String errorPlayerNotFound = ChatColor.RED + "A listed player is not online!";
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(errorMessageSender);
			return false;
		}
		if (Main.running) {
			sender.sendMessage(errorMessageRunning);
			return false;
		}
		if (args.length != 1) {
			sender.sendMessage(errorMessageFormat);
			return false;
		}
		String arg0 = args[0];
		if (!arg0.matches("(\\[([a-zA-Z0-9_]+,)+[a-zA-Z0-9_]+\\])+")) {
			sender.sendMessage(errorMessageFormat);
			return false;
		}
		List<List<String>> players = createTeamLists(arg0);
		List<List<UUID>> teamUUIDList = new ArrayList<>();
		HashMap<UUID, Boolean> seen = new HashMap<UUID, Boolean>();
		for (List<String> team : players) {
			List<UUID> currentTeamUUIDs = new ArrayList<>();
			for (String name : team) {
				if (Bukkit.getPlayerExact(name) == null || !stringsEqual(name, Bukkit.getPlayerExact(name).getName())) {
					sender.sendMessage(errorPlayerNotFound);
					return false;
				}
				if (seen.containsKey(Bukkit.getPlayerExact(name).getUniqueId())) {
					sender.sendMessage(errorDuplicatePlayer);
					return false;
				}
				seen.put(Bukkit.getPlayerExact(name).getUniqueId(), true);
				currentTeamUUIDs.add(Bukkit.getPlayerExact(name).getUniqueId());
			}
			teamUUIDList.add(currentTeamUUIDs);
		}
		players.clear();
		TeamHandler.setTeams(teamUUIDList);
		sender.sendMessage(successMessage);
		return true;
	}
	private List<List<String>> createTeamLists(String rawTeams) {
		List<List<String>> toReturn = new ArrayList<>();
		for (String s : leftshift(rawTeams.split("[\\[\\]]{1,2}"))) {
			List<String> currentTeam = Arrays.asList(s.split(","));
			toReturn.add(currentTeam);
		}
		return toReturn;
	}
	private String[] leftshift(String[] in) {
		int newLength = in.length - 1;
		String[] result = new String[newLength];
		for (int i = 0; i < newLength; i++) {
			result[i] = in[i + 1];
		}
		return result;
	}
	private boolean stringsEqual(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();
		for (int i = 0; i < charA.length; i++) {
			if (charA[i] != charB[i]) {
				return false;
			}
		}
		return true;
	}
}
