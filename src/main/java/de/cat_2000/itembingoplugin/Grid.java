package main.java.de.cat_2000.itembingoplugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.de.cat_2000.itembingoplugin.items.ItemProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.persistence.PersistentDataType;

public class Grid {
	
	private ItemStack[][] itemGrid;
	private boolean[][] foundGrid;
	private byte size = 0;
	private Map<Player, Display> displays = new HashMap<Player, Display>();
	private int longestRow = 0;
	
	public static final NamespacedKey mapIdentifierKey = new NamespacedKey("ib", "map");
	public static final char GUI_IDENTIFIER_KEY = ChatColor.COLOR_CHAR;
	
	private final ItemStack boundary = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
	private final ItemStack map = new ItemStack(Material.FILLED_MAP);
	
	public Grid(byte s, List<Player> players) {
		MapMeta mapMeta = (MapMeta) map.getItemMeta();
		mapMeta.setDisplayName("Open Bingo Card");
		mapMeta.getPersistentDataContainer().set(mapIdentifierKey, PersistentDataType.BYTE, (byte) 1);
		this.size = s;
		itemGrid = new ItemStack[size][size];
		foundGrid = new boolean[size][size];
		List<Integer> usedIndices = new ArrayList<Integer>();
		for (byte row = 0; row < size; row++) {
			for (byte column = 0; column < size; column++) {
				ItemStack random = ItemProvider.getRandomItem(usedIndices);
				itemGrid[row][column] = random;
				foundGrid[row][column] = false;
			}
		}
		map.setItemMeta(mapMeta);
		for (Player p : players) {
			displays.put(p, new Display(this.size));
		}
	}
	public Grid(Grid another) {
		MapMeta mapMeta = (MapMeta) map.getItemMeta();
		mapMeta.setDisplayName("Open Bingo Card");
		mapMeta.getPersistentDataContainer().set(mapIdentifierKey, PersistentDataType.BYTE, (byte) 1);
		this.size = another.size;
		this.itemGrid = new ItemStack[size][size];
		this.foundGrid = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				itemGrid[i][j] = another.itemGrid[i][j].clone();
				foundGrid[i][j] = another.foundGrid[i][j];
			}
		}
		map.setItemMeta(mapMeta);
	}

	public void addPlayer(Player p) {
        displays.remove(p);
		displays.put(p, new Display(this.size));
	}
	public ItemStack getMap() {
		return map;
	}
	public Inventory getInventory(Player p) {
		return displays.get(p).getInventory();
	}

	public void down(Player p) {
		displays.get(p).down();
	}
	public void up(Player p) {
		displays.get(p).up();
	}
	public void reset(Player p) {
		displays.get(p).reset();
	}
	public boolean checkItem(ItemStack item, Player player) {
		for (byte i = 0; i < size; i++) {
			for (byte j = 0; j < size; j++) {
				if (foundGrid[i][j]) {
					continue;
				}
				if (ItemProvider.itemsEqual(item, itemGrid[i][j])) {
					foundGrid[i][j] = true;
					longestRow = getLongest();
					for (Player p : Bukkit.getOnlinePlayers()) {
						if (displays.containsKey(p)) {
							p.playSound(p.getLocation(), Sound.BLOCK_RESPAWN_ANCHOR_CHARGE, (float)1.0, (float)1.0);
						} else {
							p.playSound(p.getLocation(), Sound.BLOCK_BAMBOO_WOOD_BUTTON_CLICK_ON, (float)1.0, (float)1.0);
						}
						p.sendMessage(ChatColor.WHITE + "[" + TeamHandler.getColor(player) + player.getName() + ChatColor.WHITE + "] found " + ChatColor.DARK_GREEN + itemToString(itemGrid[i][j]) + ChatColor.WHITE + " (" + longestRow + "/" + ChatColor.YELLOW + this.size + ChatColor.WHITE + ")");
						displays.get(p).update();
					}
					return checkForLine(i, j);
				}
			}
		}
		return false;
	}
	private int getLongest() {
		int longest = 0;
		for (int i = 0; i < this.size; i++) {
			longest = Math.max(longest, getLongestInRow((byte) i));
		}
		for (int i = 0; i < this.size; i++) {
			longest = Math.max(longest, getLongestInColumn((byte) i));
		}
		return Math.max(longest, getLongestDiagonally());
	}
	private int getLongestInRow(byte row) {
		int longest = 0;
		for(int i = 0; i < this.size; i++) {
			if (!foundGrid[row][i]) {
				continue;
			}
			longest++;
		}
		return longest;
	}
	private int getLongestInColumn(byte column) {
		int longest = 0;
		for(int i = 0; i < this.size; i++) {
			if (!foundGrid[i][column]) {
				continue;
			}
			longest++;
		}
		return longest;
	}
	private int getLongestDiagonally() {
		int topDown = 0;
		for (int i = 0; i < this.size; i++) {
			if (!foundGrid[i][i]) {
				continue;
			}
			topDown++;
		}
		int bottomUp = 0;
		for (int i = 0; i < this.size; i++) {
			if (!foundGrid[this.size - i - 1][i]) {
				continue;
			}
			bottomUp++;
		}
		return Math.max(topDown, bottomUp);
	}
	private boolean checkForLine(byte i, byte j) {
		return checkHorizontal(i) || checkVertical(j) || checkDiagonal(i, j);
	}
	private boolean checkHorizontal(byte row) {
		for (byte x = 0; x < size; x++) {
			if (!foundGrid[row][x]) {
				return false;
			}
		}
		return true;
	}
	private boolean checkVertical(byte column) {
		for (byte y = 0; y < size; y++) {
			if (!foundGrid[y][column]) {
				return false;
			}
		}
		return true;
	}
	private boolean checkDiagonal(byte i, byte j) {
		if (i != j && i + j != size - 1) {
			return false;
		}
		boolean topDown = true;
		boolean bottomUp = true;
		for (byte x = 0; x < size; x++) {
			topDown = topDown && foundGrid[x][x];
		}
		for (byte y = 0; y < size; y++) {
			bottomUp = bottomUp && foundGrid[size-y-1][y]; 
		}
		return topDown || bottomUp;
	}
	private class Display {
		private Inventory inventory;
		private byte size;
		private short itemOffset;
		private short displayRow = 0;
		
		public Display(byte size) {
			this.size = size;
			this.itemOffset = (short)((9 - size) / 2);
			String controlExplanationTitle = (this.size > 6) ? " Left click " + "\u2193" + " Right c. " + "\u2191" : "";
			inventory = Bukkit.createInventory(null, Math.min(54, this.size*9), String.valueOf(Grid.GUI_IDENTIFIER_KEY) + "0"/*to make title black, as ColorChar is used to identify gui*/ + "Bingo " + String.valueOf(this.size) + "x" + String.valueOf(this.size) + controlExplanationTitle);
			outerloop:
			for (int i = 0; i < this.size; i++) {
				for (int j = 0; j < this.size; j++) {
					int index = i*9 + itemOffset + j;
					ItemStack current = itemGrid[i][j].clone();
					if (index > 53) {
						break outerloop;
					}
					updateItemCount(current, foundGrid[i][j]);
					inventory.setItem(index, current);
				}
			}
			for (int i = 0; i < inventory.getSize(); i++) {
				if (inventory.getItem(i) == null || inventory.getItem(i).getType() == Material.AIR) {
					inventory.setItem(i, boundary);
				}
			}
		}
		public Inventory getInventory() {
			return inventory;
		}
		public void up() {
			if (size <= 6) {
				return;
			}
			if (displayRow <= 0) {
				return;
			}
			displayRow--;
			update();
		}
		public void down() {
			if (size <= 6) {
				return;
			}
			if (displayRow >= this.size - 6) {
				return;
			}
			displayRow++;
			update();
		}
		public void reset() {
			displayRow = 0;
			update();
		}
		public void update() {
			inventory.clear();
			outerloop:
			for (int i = displayRow; i < this.size; i++) {
				for (int j = 0; j < this.size; j++) {
					int index = (i-displayRow)*9 + itemOffset + j;
					ItemStack current = itemGrid[i][j].clone();
					if (index > 53) {
						break outerloop;
					}
					updateItemCount(current, foundGrid[i][j]);
;					inventory.setItem(index, current);
				}
			}
			for (int i = 0; i < inventory.getSize(); i++) {
				if (inventory.getItem(i) == null || inventory.getItem(i).getType() == Material.AIR) {
					inventory.setItem(i, boundary);
				}
			}
			for (HumanEntity entity : inventory.getViewers()) {
				if (!(entity instanceof Player)) {
					continue;
				}
				Player p = (Player) entity;
				p.openInventory(inventory);
			}
		}
	}
	private void updateItemCount(ItemStack item, boolean found) {
		ItemMeta meta = item.getItemMeta();
		meta.setMaxStackSize(64);
		item.setItemMeta(meta);
		if (found) {
			item.setAmount(64);
		} else {
			item.setAmount(1);
		}
	}
	private String itemToString(ItemStack item) {
		String toReturn = item.getType().toString().toLowerCase().replaceAll("_", " ");
		if (item.getItemMeta() == null) {
			return toReturn;
		}
		if (item.getItemMeta().hasEnchants()) {
			toReturn += " [";
			for (Enchantment e : item.getItemMeta().getEnchants().keySet()) {
				toReturn += e.getName().toLowerCase() + " " + item.getItemMeta().getEnchants().get(e) + ",";
			}
			toReturn = toReturn.substring(0, toReturn.length() - 1);
			toReturn += "]";
		}
		if (item.getItemMeta() instanceof ArmorMeta && ((ArmorMeta)item.getItemMeta()).getTrim() != null) {
			toReturn += " [" + ((ArmorMeta)item.getItemMeta()).getTrim().getPattern().getKeyOrNull().getKey() + "," + ((ArmorMeta)item.getItemMeta()).getTrim().getMaterial().getKeyOrNull().getKey() + "]";
		}
		if (item.getItemMeta() instanceof PotionMeta) {
			toReturn += " [" + String.valueOf(((PotionMeta)item.getItemMeta()).getBasePotionType()).toLowerCase().replaceAll("_", " ") + "]";
		}
		if (item.getItemMeta() instanceof OminousBottleMeta) {
			toReturn += "[Amplifier: " + ((OminousBottleMeta)item.getItemMeta()).getAmplifier() + "]";
		}
		return toReturn;
	}
}