package main.java.de.cat_2000.itembingoplugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class Team {
	
	private Grid grid;
	private List<Player> members = new ArrayList<Player>();
	private Inventory backpack;
	private final ItemStack backpackItem = new ItemStack(Material.BUNDLE);
	private final ItemStack pickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
	private final ItemStack crafting = new ItemStack(Material.CRAFTING_TABLE);
	private ChatColor color;
	
	public static final NamespacedKey craftingIdentifierKey = new NamespacedKey("ib", "crafting");
	public static final NamespacedKey pickaxeIdentifierKey = new NamespacedKey("ib", "pickaxe");
	public static final NamespacedKey backpackIdentifierKey = new NamespacedKey("ib", "bundle");
	
	public Team(List<UUID> players, ChatColor c, int backpackSize, boolean withPickaxe, boolean withCraftingTable) {
		this.color = c;
		ItemMeta backpackMeta = backpackItem.getItemMeta();
		backpackMeta.setDisplayName("Open Backpack");
		backpackMeta.getPersistentDataContainer().set(backpackIdentifierKey, PersistentDataType.BYTE, (byte) 1);
		backpackItem.setItemMeta(backpackMeta);
		
		ItemMeta pickaxeMeta = pickaxe.getItemMeta();
		pickaxeMeta.addEnchant(Enchantment.EFFICIENCY, 5, false);
		pickaxeMeta.setUnbreakable(true);
		pickaxeMeta.getPersistentDataContainer().set(pickaxeIdentifierKey, PersistentDataType.BYTE, (byte) 1);
		pickaxe.setItemMeta(pickaxeMeta);
		
		ItemMeta craftingMeta = crafting.getItemMeta();
		craftingMeta.addEnchant(Enchantment.AQUA_AFFINITY, 1, false);
		craftingMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		craftingMeta.getPersistentDataContainer().set(craftingIdentifierKey, PersistentDataType.BYTE, (byte) 1);
		crafting.setItemMeta(craftingMeta);

		backpack = Bukkit.createInventory(null, backpackSize * 9, "Backpack");
		
		for (UUID player : players) {
			Player p = Bukkit.getPlayer(player);
			members.add(p);
			p.setPlayerListName(color + p.getPlayerListName());
		}
		grid = new Grid(TeamHandler.getSize(), members);
		for (Player p : members) {
			//remove old maps and bundles
			ItemStack[] inventoryContents = p.getInventory().getContents();
			for (int i = 0; i < inventoryContents.length; i++) {
				if (inventoryContents[i] == null) {
					continue;
				}
				if (!inventoryContents[i].hasItemMeta()) {
					continue;
				}
				ItemMeta meta = inventoryContents[i].getItemMeta();
				if (!meta.getPersistentDataContainer().has(Grid.mapIdentifierKey, PersistentDataType.BYTE) && !meta.getPersistentDataContainer().has(Team.backpackIdentifierKey, PersistentDataType.BYTE) && !meta.getPersistentDataContainer().has(Team.pickaxeIdentifierKey, PersistentDataType.BYTE) && !meta.getPersistentDataContainer().has(Team.craftingIdentifierKey, PersistentDataType.BYTE)) {
					continue;
				}
				p.getInventory().setItem(i, null);
			}
			if (p.getInventory().firstEmpty() == -1) {
				p.getWorld().dropItemNaturally(p.getLocation(), backpackItem);
				p.getWorld().dropItemNaturally(p.getLocation(), grid.getMap());
				if (withPickaxe) {
					p.getWorld().dropItemNaturally(p.getLocation(), pickaxe);
				}
				if (withCraftingTable) {
					p.getWorld().dropItemNaturally(p.getLocation(), crafting);
				}
			} else {
				p.getInventory().addItem(backpackItem);
				p.getInventory().addItem(grid.getMap());
				if (withPickaxe) {
					p.getInventory().addItem(pickaxe);
				}
				if (withCraftingTable) {
					p.getInventory().addItem(crafting);
				}
			}
		}
	}
	
	public void setGrid(Grid g) {
		this.grid = g;
	}
	
	public Grid getGrid() {
		return grid;
	}
	public Inventory getBackpack() {
		return backpack;
	}
	public ChatColor getColor() {
		return color;
	}
	public void addPlayer(Player p) {
		List<Player> membersNew = new ArrayList<Player>();
		for (Player pl : members) {
			if (pl.getUniqueId().equals(p.getUniqueId())) {
				continue;
			}
			membersNew.add(pl);
		}
		this.members = membersNew;
		p.setPlayerListName(color + p.getPlayerListName());
		this.members.add(p);
		this.grid.addPlayer(p);
	}
	public List<Player> getPlayers() {
		return members;
	}
}
