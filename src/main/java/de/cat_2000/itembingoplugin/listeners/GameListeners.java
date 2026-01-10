package main.java.de.cat_2000.itembingoplugin.listeners;


import main.java.de.cat_2000.itembingoplugin.Grid;
import main.java.de.cat_2000.itembingoplugin.Team;
import main.java.de.cat_2000.itembingoplugin.TeamHandler;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MenuType;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class GameListeners implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Block b = e.getBlock();
		Material m = b.getType();
		if (m != Material.SPAWNER && m != Material.REINFORCED_DEEPSLATE) {
			return;
		}
		ItemStack tool = e.getPlayer().getInventory().getItemInMainHand();
		Material toolM = tool.getType();
		if (toolM != Material.IRON_PICKAXE && toolM != Material.DIAMOND_PICKAXE && toolM != Material.NETHERITE_PICKAXE) {
			return;
		}
		if (!tool.hasItemMeta()) {
			return;
		}
		if (!tool.getItemMeta().getEnchants().keySet().contains(Enchantment.SILK_TOUCH)) {
			return;
		}
		e.setExpToDrop(0);
		b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(m));
	}
	@EventHandler(priority = EventPriority.LOWEST)
	public void onInventoryClick(InventoryClickEvent e) {
		if (!(e.getWhoClicked() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getWhoClicked();
		if (e.getView().getTitle().contains(String.valueOf(Grid.GUI_IDENTIFIER_KEY))) {
			if (e.getClick() == ClickType.LEFT) {
				TeamHandler.down(p);
			}
			if (e.getClick() == ClickType.RIGHT) {
				TeamHandler.up(p);
			}
			e.setCancelled(true);
			return;
		}
		if (e.getCurrentItem() == null) {
			return;
		}
		if (e.getCurrentItem().hasItemMeta() && (e.getCurrentItem().getItemMeta().getPersistentDataContainer().has(Team.backpackIdentifierKey) || e.getCurrentItem().getItemMeta().getPersistentDataContainer().has(Team.craftingIdentifierKey) || e.getCurrentItem().getItemMeta().getPersistentDataContainer().has(Team.pickaxeIdentifierKey) || e.getCurrentItem().getItemMeta().getPersistentDataContainer().has(Grid.mapIdentifierKey)) || e.getCursor().hasItemMeta() && (e.getCursor().getItemMeta().getPersistentDataContainer().has(Team.backpackIdentifierKey) || e.getCursor().getItemMeta().getPersistentDataContainer().has(Team.craftingIdentifierKey) || e.getCursor().getItemMeta().getPersistentDataContainer().has(Team.pickaxeIdentifierKey) || e.getCursor().getItemMeta().getPersistentDataContainer().has(Grid.mapIdentifierKey))) {
			if (e.getClick() != ClickType.LEFT) {
				e.setCancelled(true);
			}
			if (e.getClickedInventory().getType() != InventoryType.PLAYER && (e.getCursor().hasItemMeta() && (e.getCursor().getItemMeta().getPersistentDataContainer().has(Team.backpackIdentifierKey) || e.getCursor().getItemMeta().getPersistentDataContainer().has(Team.craftingIdentifierKey) || e.getCursor().getItemMeta().getPersistentDataContainer().has(Team.pickaxeIdentifierKey) || e.getCursor().getItemMeta().getPersistentDataContainer().has(Grid.mapIdentifierKey)))) {
				e.setCancelled(true);
			}
			return;
		}
		TeamHandler.checkItem((Player) e.getWhoClicked(), e.getCurrentItem());
	}
	@EventHandler
	public void onPlayerPickupItem(EntityPickupItemEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		ItemStack item = e.getItem().getItemStack();
		if (item.hasItemMeta() && (item.getItemMeta().getPersistentDataContainer().has(Team.craftingIdentifierKey) || item.getItemMeta().getPersistentDataContainer().has(Team.pickaxeIdentifierKey))) {
			return;
		}
		TeamHandler.checkItem((Player) e.getEntity(), e.getItem().getItemStack());
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if (a != Action.RIGHT_CLICK_AIR && a != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		ItemStack item = p.getInventory().getItemInMainHand();
		if (!item.hasItemMeta()) {
			return;
		}
		if (!TeamHandler.inTeam(p.getUniqueId())) {
			return;
		}
		ItemMeta meta = item.getItemMeta();
		if (meta.getPersistentDataContainer().has(Grid.mapIdentifierKey, PersistentDataType.BYTE)) {
			TeamHandler.reset(p);
			p.openInventory(TeamHandler.getInventory(p));
			e.setCancelled(true);
		}
		if (meta.getPersistentDataContainer().has(Team.backpackIdentifierKey, PersistentDataType.BYTE)) {
			p.openInventory(TeamHandler.getBackpack(p));
			e.setCancelled(true);
		}
		if (meta.getPersistentDataContainer().has(Team.craftingIdentifierKey, PersistentDataType.BYTE)) {
			p.openInventory(MenuType.Typed.CRAFTING.builder().title("Crafting").build(p));
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent e) {
		ItemStack item = e.getItemDrop().getItemStack();
		if (!item.hasItemMeta()) {
			return;
		}
		ItemMeta meta = item.getItemMeta();
		if (!meta.getPersistentDataContainer().has(Grid.mapIdentifierKey, PersistentDataType.BYTE) && !meta.getPersistentDataContainer().has(Team.backpackIdentifierKey)) {
			return;
		}
		e.setCancelled(true);
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		TeamHandler.handlePending(p);
		if (!TeamHandler.inTeam(p.getUniqueId())) {
			return;
		}
		p.setPlayerListName(TeamHandler.getColor(p) + p.getPlayerListName());
	}
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		TeamHandler.addPending(e.getPlayer().getUniqueId());
	}
	@EventHandler
	public void onHunger(FoodLevelChangeEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!TeamHandler.inTeam(((Player)e.getEntity()).getUniqueId())) {
			return;
		}
		e.setFoodLevel(20);
	}
}
