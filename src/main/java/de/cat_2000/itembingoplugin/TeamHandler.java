package main.java.de.cat_2000.itembingoplugin;

import java.util.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TeamHandler {
	private static final HashMap<UUID, Team> playerGridMap = new HashMap<>();
	private static final HashMap<UUID, Team> pendingPlayers = new HashMap<>();
	private static final List<Team> teams = new ArrayList<Team>();
	
	private static final List<ChatColor> teamColors = new ArrayList<ChatColor>(Arrays.asList(ChatColor.values()));
	
	private static byte gridSize = 0;
	
	private static List<List<UUID>> proposedTeams = null;
	
	static {
		teamColors.remove(ChatColor.BLACK);
		teamColors.remove(ChatColor.MAGIC);
		teamColors.remove(ChatColor.BOLD);
		teamColors.remove(ChatColor.ITALIC);
		teamColors.remove(ChatColor.UNDERLINE);
		teamColors.remove(ChatColor.STRIKETHROUGH);
	}

	public static void setTeams(List<List<UUID>> teamData) {
		proposedTeams = teamData;
 	}

	public static void startDifferentMap(int backpackSize, boolean withPickaxe, boolean withCraftingTable, boolean noHunger, boolean keepInventory) {
		for (int i = 0; i < proposedTeams.size(); i++) {
			List<UUID> players = proposedTeams.get(i);
			Team t = new Team(players, teamColors.get(i), backpackSize, withPickaxe, withCraftingTable);
			for (UUID player : players) {
				playerGridMap.put(player, t);
			}
			teams.add(t);
		}
		//keep inventory
		if (keepInventory) {
			for (World w : Bukkit.getServer().getWorlds()) {
				w.setGameRule(GameRule.KEEP_INVENTORY, true);
			}
		}
		Main.running = true;
		//hunger
		if (noHunger) {
			Main.registerHungerListener();
		}
		Main.registerGameListeners();
		proposedTeams = null;
	}
	public static void startSameMap(int backpackSize, boolean withPickaxe, boolean withCraftingTable, boolean noHunger, boolean keepInventory) {
		Grid g = new Grid(gridSize, new ArrayList<Player>());
		for (int i = 0; i < proposedTeams.size(); i++) {
			List<UUID> players = proposedTeams.get(i);
			Team t = new Team(players, teamColors.get(i), backpackSize, withPickaxe, withCraftingTable);
			t.setGrid(new Grid(g));
			for (UUID player : players) {
				playerGridMap.put(player, t);
				t.getGrid().addPlayer(Bukkit.getPlayer(player));
			}
			teams.add(t);
		}
		//keep inventory
		if (keepInventory) {
			for (World w : Bukkit.getServer().getWorlds()) {
				w.setGameRule(GameRule.KEEP_INVENTORY, true);
			}
		}
		Main.running = true;
		//hunger
		if (noHunger) {
			Main.registerHungerListener();
		}
		Main.registerGameListeners();
		proposedTeams = null;
	}
	public static boolean ready() {
		return proposedTeams != null;
	}
	public static boolean inTeam(UUID player) {
		return playerGridMap.get(player) != null;
	}
	public static void checkItem(Player p, ItemStack item) {
		if (!playerGridMap.get(p.getUniqueId()).getGrid().checkItem(item, p)) {
			return;
		}
		endGame(p);
	}
	public static ChatColor getColor(Player p) {
		return playerGridMap.get(p.getUniqueId()).getColor();
	}
	public static Inventory getInventory(Player p) {
		return playerGridMap.get(p.getUniqueId()).getGrid().getInventory(p);
	}
	
	public static Inventory getBackpack(Player p) {
		return playerGridMap.get(p.getUniqueId()).getBackpack();
	}
	
	public static void down(Player p) {
		playerGridMap.get(p.getUniqueId()).getGrid().down(p);
	}
	public static void up(Player p) {
		playerGridMap.get(p.getUniqueId()).getGrid().up(p);
	}
	public static void reset(Player p) {
		playerGridMap.get(p.getUniqueId()).getGrid().reset(p);
	}
	public static void endGame(Player winner) {
		Main.running = false;
		Main.unregisterHungerListener();
		Main.unregisterGameListeners();
		for (World w : Bukkit.getServer().getWorlds()) {
			w.setGameRule(GameRule.KEEP_INVENTORY, false);
		}
		//reset names
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.setPlayerListName(null);
		}
		//win actions
		String winners = "";
		for (Player p : playerGridMap.get(winner.getUniqueId()).getPlayers()) {
			winners += p.getName() + ",";
		}
		winners = winners.substring(0, winners.length() - 1);
		Bukkit.getServer().broadcastMessage(ChatColor.YELLOW.toString() + ChatColor.MAGIC + "#" + ChatColor.WHITE + " [" + ChatColor.DARK_AQUA + winners + ChatColor.WHITE + "] won Bingo ! " + ChatColor.YELLOW + ChatColor.MAGIC.toString() + "#");
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, (float) 1.0, (float) 1.0);
		}
		//drop backpack items
		outerloop:
		for (Team t : teams) {
			for (UUID player : playerGridMap.keySet()) {
				for (ItemStack item : t.getBackpack()) {
					if (item == null) {
						continue;
					}
					Bukkit.getPlayer(player).getWorld().dropItemNaturally(Bukkit.getPlayer(player).getLocation(), item);
				}
				continue outerloop;
			}
		}
		//maps and bundles are kept but removed at the start of the next game
		//clear maps and lists
		teams.clear();
		pendingPlayers.clear();
		playerGridMap.clear();
	}
	public static void cancelGame() {
		Main.running = false;
		Main.unregisterGameListeners();
		Main.unregisterHungerListener();
		for (World w : Bukkit.getServer().getWorlds()) {
			w.setGameRule(GameRule.KEEP_INVENTORY, false);
		}
		//reset names
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.setPlayerListName(null);
		}
		//drop backpack items
		outerloop:
		for (Team t : teams) {
			for (UUID player : playerGridMap.keySet()) {
				for (ItemStack item : t.getBackpack()) {
					if (item == null) {
						continue;
					}
					Bukkit.getPlayer(player).getWorld().dropItemNaturally(Bukkit.getPlayer(player).getLocation(), item);
				}
				continue outerloop;
			}
		}
		//maps and bundles are kept but removed at the start of the next game
		//clear maps and lists
		teams.clear();
		pendingPlayers.clear();
		playerGridMap.clear();
	}
	public static void addPending(UUID player) {
		if (!inTeam(player)) {
			return;
		}
		pendingPlayers.put(player, playerGridMap.get(player));
		playerGridMap.remove(player);
	}
	public static void handlePending(Player p) {
		if (inTeam(p.getUniqueId())) {
			return;
		}
		playerGridMap.put(p.getUniqueId(), pendingPlayers.get(p.getUniqueId()));
		pendingPlayers.get(p.getUniqueId()).addPlayer(p);
		pendingPlayers.remove(p.getUniqueId());
	}
	
	private static String[] leftshift(String[] in) {
		int newLength = in.length - 1;
		String[] result = new String[newLength];
		for (int i = 0; i < newLength; i++) {
			result[i] = in[i + 1];
		}
		return result;
	}
	
	public static byte getSize() {
		return gridSize;
	}
	
	public static void setSize(byte s) {
		gridSize = s;
	}
}
