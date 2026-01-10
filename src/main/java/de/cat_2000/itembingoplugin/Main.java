package main.java.de.cat_2000.itembingoplugin;

import main.java.de.cat_2000.itembingoplugin.commands.CancelCommandHandler;
import main.java.de.cat_2000.itembingoplugin.commands.StartCommandHandler;
import main.java.de.cat_2000.itembingoplugin.commands.TeamsCommandHandler;
import main.java.de.cat_2000.itembingoplugin.items.ItemProvider;
import main.java.de.cat_2000.itembingoplugin.listeners.GameListeners;
import main.java.de.cat_2000.itembingoplugin.listeners.NoHungerListener;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main instance;
	
	public static boolean running = false;
	
	private static final GameListeners gameListener = new GameListeners();
	private static final NoHungerListener hungerListener = new NoHungerListener();
	
	@Override
	public void onEnable() {
		instance = this;
		
		getCommand("start").setExecutor(new StartCommandHandler());
		getCommand("cancel").setExecutor(new CancelCommandHandler());
		getCommand("teams").setExecutor(new TeamsCommandHandler());
		
		ItemProvider.init();
	}
	
	@Override
	public void onDisable() {

	}
	
	public static void registerGameListeners() {
		Bukkit.getPluginManager().registerEvents(gameListener, instance);
	}
	
	public static void unregisterGameListeners() {
		HandlerList.unregisterAll(gameListener);
	}

	public static void registerHungerListener() {
		Bukkit.getPluginManager().registerEvents(hungerListener, instance);
	}

	public static void unregisterHungerListener() {
		HandlerList.unregisterAll(hungerListener);
	}
}
