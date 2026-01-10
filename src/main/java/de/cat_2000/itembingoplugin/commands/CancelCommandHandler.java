package main.java.de.cat_2000.itembingoplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import main.java.de.cat_2000.itembingoplugin.Main;
import main.java.de.cat_2000.itembingoplugin.TeamHandler;

public class CancelCommandHandler implements CommandExecutor {

	private final String syntaxErrorMessage = ChatColor.RED + "Syntax error! No arguments allowed";
	private final String runningErrorMessage = ChatColor.RED + "No active game to cancel";
	private final String cancelMessage = ChatColor.translateAlternateColorCodes('$', "$7$k# $cGame cancelled! $7$k#");;
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length != 0) {
			sender.sendMessage(syntaxErrorMessage);
			return false;
		}
		if (!Main.running) {
			sender.sendMessage(runningErrorMessage);
			return false;
		}
		TeamHandler.cancelGame();
		Bukkit.getServer().broadcastMessage(cancelMessage);
		return true;
	}

}
