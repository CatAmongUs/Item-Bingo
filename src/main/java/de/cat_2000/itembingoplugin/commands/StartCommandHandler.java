package main.java.de.cat_2000.itembingoplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import main.java.de.cat_2000.itembingoplugin.Main;
import main.java.de.cat_2000.itembingoplugin.TeamHandler;

public class StartCommandHandler implements CommandExecutor {
	
	private final String errorMessageSyntax = ChatColor.RED + "Syntax error!" + ChatColor.GRAY + " Command takes one size argument for the grid size and backpack size each: <grid size: 3-9> <backpack size: 1-6> and flags <withDifferentMaps> <withPickaxe> <withCraftingTable> <noHunger> <keepInventory>";
	private final String errorMessageRunning = ChatColor.RED + "The game is already running!";
	private final String startMessage = ChatColor.translateAlternateColorCodes('$', "$7$k# $aGame started! $7$k#");
	private final String errorMessageTeams = ChatColor.RED + "Cannot start, must create Teams first";
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (Main.running) {
			sender.sendMessage(errorMessageRunning);
			return false;
		}
		if (args.length != 7) {
			sender.sendMessage(errorMessageSyntax);
			return false;
		}
		String arg0 = args[0];
		if (!arg0.matches("\\d")) {
			sender.sendMessage(errorMessageSyntax);
			return false;
		}
		String arg1 = args[1];
		if (!arg0.matches("\\d")) {
			sender.sendMessage(errorMessageSyntax);
			return false;
		}
		String args2 = args[2];
		if (!(args2.contentEquals("false") || args2.contentEquals("true"))) {
			sender.sendMessage(errorMessageSyntax);
			return false;
		}
		String args3 = args[3];
		if (!(args3.contentEquals("false") || args3.contentEquals("true"))) {
			sender.sendMessage(errorMessageSyntax);
			return false;
		}
		String args4 = args[4];
		if (!(args4.contentEquals("false") || args4.contentEquals("true"))) {
			sender.sendMessage(errorMessageSyntax);
			return false;
		}
		String args5 = args[5];
		if (!(args5.contentEquals("false") || args5.contentEquals("true"))) {
			sender.sendMessage(errorMessageSyntax);
			return false;
		}
		String args6 = args[6];
		if (!(args6.contentEquals("false") || args6.contentEquals("true"))) {
			sender.sendMessage(errorMessageSyntax);
			return false;
		}
		byte gridSize = (byte) Integer.parseInt(arg0);
		int backpackSize = Integer.parseInt(arg1);
		if (gridSize < 3 || gridSize > 9) {
			sender.sendMessage(errorMessageSyntax);
			return false;
		}
		if (backpackSize < 1 || backpackSize > 6) {
			sender.sendMessage(errorMessageSyntax);
			return false;
		}
		if (!TeamHandler.ready()) {
			sender.sendMessage(errorMessageTeams);
			return false;
		}
		boolean sameMap = !Boolean.parseBoolean(args2);
		boolean withPickaxe = Boolean.parseBoolean(args3);
		boolean withCraftingTable = Boolean.parseBoolean(args4);
		boolean noHunger = Boolean.parseBoolean(args5);
		boolean keepInventory = Boolean.parseBoolean(args6);
		TeamHandler.setSize(gridSize);
		if (sameMap) {
			TeamHandler.startSameMap(backpackSize, withPickaxe, withCraftingTable, noHunger, keepInventory);
		} else {
			TeamHandler.startDifferentMap(backpackSize, withPickaxe, withCraftingTable, noHunger, keepInventory);
		}
		Bukkit.getServer().broadcastMessage(startMessage);
		return true;
	}

}
