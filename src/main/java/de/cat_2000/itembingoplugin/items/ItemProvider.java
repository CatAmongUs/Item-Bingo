package main.java.de.cat_2000.itembingoplugin.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.OminousBottleMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;
import org.bukkit.potion.PotionType;

@SuppressWarnings("deprecation")
public class ItemProvider {
	
	private static final List<ItemStack> itemList = new ArrayList<ItemStack>();
	private static final List<PotionType> potionList = asList(PotionType.values());
	private static final Map<ItemStack, Enchantment[]> possibleEnchantments = new HashMap<ItemStack, Enchantment[]>(); 
	private static final List<TrimMaterial> trimMaterials = new ArrayList<TrimMaterial>();
	private static final List<TrimPattern> trimPatterns = new ArrayList<TrimPattern>();
	private static final List<Material> armors = new ArrayList<Material>();
	
	private static final List<ItemRoll> rolls = new ArrayList<ItemRoll>();
	
	private static final List<String> loreSilkTouch = new ArrayList<String>();
	private static final ItemMeta metaSpawner = Bukkit.getItemFactory().getItemMeta(Material.SPAWNER);
	private static final ItemMeta metaDeepslate = Bukkit.getItemFactory().getItemMeta(Material.REINFORCED_DEEPSLATE);
	
	private static int itemListLength;
	private static int potionListLength;
	private static int trimMaterialListLength;
	private static int trimPatternListLength;

	
	private static final Random rd = new Random();
	
	
	public static void init(){
		final List<Enchantment> enchantmentList = asList(Enchantment.values());
		List<Material> materialList = asList(Material.values());

		ArrayList<Material> materialListCopy = new ArrayList<Material>();
		for (Material m : materialList) {
			if (m.toString().contains("SPAWN_EGG")) {
				continue;
			}
			materialListCopy.add(m);
		}
		materialList = (List<Material>) materialListCopy.clone();
		materialList.remove(Material.AIR);
		materialList.remove(Material.BEDROCK);
		materialList.remove(Material.SUSPICIOUS_SAND);
		materialList.remove(Material.SUSPICIOUS_GRAVEL);
		materialList.remove(Material.BUDDING_AMETHYST);
		materialList.remove(Material.PETRIFIED_OAK_SLAB);
		materialList.remove(Material.FARMLAND);
		materialList.remove(Material.INFESTED_STONE);
		materialList.remove(Material.INFESTED_COBBLESTONE);
		materialList.remove(Material.INFESTED_STONE_BRICKS);
		materialList.remove(Material.INFESTED_MOSSY_STONE_BRICKS);
		materialList.remove(Material.INFESTED_CRACKED_STONE_BRICKS);
		materialList.remove(Material.INFESTED_CHISELED_STONE_BRICKS);
		materialList.remove(Material.INFESTED_DEEPSLATE);
		materialList.remove(Material.END_PORTAL_FRAME);
		materialList.remove(Material.COMMAND_BLOCK);
		materialList.remove(Material.CHIPPED_ANVIL);
		materialList.remove(Material.DAMAGED_ANVIL);
		materialList.remove(Material.BARRIER);
		materialList.remove(Material.LIGHT);
		materialList.remove(Material.DIRT_PATH);
		materialList.remove(Material.TALL_GRASS);
		materialList.remove(Material.LARGE_FERN);
		materialList.remove(Material.REPEATING_COMMAND_BLOCK);
		materialList.remove(Material.CHAIN_COMMAND_BLOCK);
		materialList.remove(Material.STRUCTURE_VOID);
		materialList.remove(Material.STRUCTURE_BLOCK);
		materialList.remove(Material.JIGSAW);
		materialList.remove(Material.BUNDLE);
		materialList.remove(Material.FILLED_MAP);
		materialList.remove(Material.WRITTEN_BOOK);
		materialList.remove(Material.PLAYER_HEAD);
		materialList.remove(Material.COMMAND_BLOCK_MINECART);
		materialList.remove(Material.KNOWLEDGE_BOOK);
		materialList.remove(Material.DEBUG_STICK);
		materialList.remove(Material.FROGSPAWN);
		materialList.remove(Material.WATER);
		materialList.remove(Material.LAVA);
		materialList.remove(Material.TALL_SEAGRASS);
		materialList.remove(Material.PISTON_HEAD);
		materialList.remove(Material.MOVING_PISTON);
		materialList.remove(Material.WALL_TORCH);
		materialList.remove(Material.FIRE);
		materialList.remove(Material.SOUL_FIRE);
		materialList.remove(Material.TEST_BLOCK);
		materialList.remove(Material.TEST_INSTANCE_BLOCK);
		materialList.remove(Material.REDSTONE_WIRE);
		materialList.remove(Material.OAK_WALL_SIGN);
		materialList.remove(Material.SPRUCE_WALL_SIGN);
		materialList.remove(Material.BIRCH_WALL_SIGN);
		materialList.remove(Material.ACACIA_WALL_SIGN);
		materialList.remove(Material.CHERRY_WALL_SIGN);
		materialList.remove(Material.JUNGLE_WALL_SIGN);
		materialList.remove(Material.DARK_OAK_WALL_SIGN);
		materialList.remove(Material.MANGROVE_WALL_SIGN);
		materialList.remove(Material.BAMBOO_WALL_SIGN);
		materialList.remove(Material.OAK_WALL_HANGING_SIGN);
		materialList.remove(Material.SPRUCE_WALL_HANGING_SIGN);
		materialList.remove(Material.BIRCH_WALL_HANGING_SIGN);
		materialList.remove(Material.ACACIA_WALL_HANGING_SIGN);
		materialList.remove(Material.CHERRY_WALL_HANGING_SIGN);
		materialList.remove(Material.JUNGLE_WALL_HANGING_SIGN);
		materialList.remove(Material.DARK_OAK_WALL_HANGING_SIGN);
		materialList.remove(Material.MANGROVE_WALL_HANGING_SIGN);
		materialList.remove(Material.CRIMSON_WALL_HANGING_SIGN);
		materialList.remove(Material.WARPED_WALL_HANGING_SIGN);
		materialList.remove(Material.BAMBOO_WALL_HANGING_SIGN);
		materialList.remove(Material.REDSTONE_WALL_TORCH);
		materialList.remove(Material.SOUL_WALL_TORCH);
		materialList.remove(Material.NETHER_PORTAL);
		materialList.remove(Material.ATTACHED_PUMPKIN_STEM);
		materialList.remove(Material.ATTACHED_MELON_STEM);
		materialList.remove(Material.PUMPKIN_STEM);
		materialList.remove(Material.MELON_STEM);
		materialList.remove(Material.WATER_CAULDRON);
		materialList.remove(Material.LAVA_CAULDRON);
		materialList.remove(Material.POWDER_SNOW_CAULDRON);
		materialList.remove(Material.END_PORTAL);
		materialList.remove(Material.COCOA);
		materialList.remove(Material.TRIPWIRE);
		materialList.remove(Material.POTTED_TORCHFLOWER);
		materialList.remove(Material.POTTED_OAK_SAPLING);
		materialList.remove(Material.POTTED_SPRUCE_SAPLING);
		materialList.remove(Material.POTTED_BIRCH_SAPLING);
		materialList.remove(Material.POTTED_JUNGLE_SAPLING);
		materialList.remove(Material.POTTED_ACACIA_SAPLING);
		materialList.remove(Material.POTTED_CHERRY_SAPLING);
		materialList.remove(Material.POTTED_DARK_OAK_SAPLING);
		materialList.remove(Material.POTTED_MANGROVE_PROPAGULE);
		materialList.remove(Material.POTTED_FERN);
		materialList.remove(Material.POTTED_DANDELION);
		materialList.remove(Material.POTTED_POPPY);
		materialList.remove(Material.POTTED_BLUE_ORCHID);
		materialList.remove(Material.POTTED_ALLIUM);
		materialList.remove(Material.POTTED_AZURE_BLUET);
		materialList.remove(Material.POTTED_RED_TULIP);
		materialList.remove(Material.POTTED_ORANGE_TULIP);
		materialList.remove(Material.POTTED_WHITE_TULIP);
		materialList.remove(Material.POTTED_PINK_TULIP);
		materialList.remove(Material.POTTED_OXEYE_DAISY);
		materialList.remove(Material.POTTED_CORNFLOWER);
		materialList.remove(Material.POTTED_LILY_OF_THE_VALLEY);
		materialList.remove(Material.POTTED_WITHER_ROSE);
		materialList.remove(Material.POTTED_RED_MUSHROOM);
		materialList.remove(Material.POTTED_BROWN_MUSHROOM);
		materialList.remove(Material.POTTED_DEAD_BUSH);
		materialList.remove(Material.POTTED_CACTUS);
		materialList.remove(Material.CARROTS);
		materialList.remove(Material.POTATOES);
		materialList.remove(Material.SKELETON_WALL_SKULL);
		materialList.remove(Material.WITHER_SKELETON_WALL_SKULL);
		materialList.remove(Material.ZOMBIE_WALL_HEAD);
		materialList.remove(Material.PLAYER_WALL_HEAD);
		materialList.remove(Material.CREEPER_WALL_HEAD);
		materialList.remove(Material.DRAGON_WALL_HEAD);
		materialList.remove(Material.PIGLIN_WALL_HEAD);
		materialList.remove(Material.WHITE_WALL_BANNER);
		materialList.remove(Material.ORANGE_WALL_BANNER);
		materialList.remove(Material.MAGENTA_WALL_BANNER);
		materialList.remove(Material.LIGHT_BLUE_WALL_BANNER);
		materialList.remove(Material.YELLOW_WALL_BANNER);
		materialList.remove(Material.LIME_WALL_BANNER);
		materialList.remove(Material.PINK_WALL_BANNER);
		materialList.remove(Material.GRAY_WALL_BANNER);
		materialList.remove(Material.LIGHT_GRAY_WALL_BANNER);
		materialList.remove(Material.CYAN_WALL_BANNER);
		materialList.remove(Material.PURPLE_WALL_BANNER);
		materialList.remove(Material.BLUE_WALL_BANNER);
		materialList.remove(Material.BROWN_WALL_BANNER);
		materialList.remove(Material.GREEN_WALL_BANNER);
		materialList.remove(Material.RED_WALL_BANNER);
		materialList.remove(Material.BLACK_WALL_BANNER);
		materialList.remove(Material.TORCHFLOWER_CROP);
		materialList.remove(Material.PITCHER_CROP);
		materialList.remove(Material.BEETROOTS);
		materialList.remove(Material.END_GATEWAY);
		materialList.remove(Material.FROSTED_ICE);
		materialList.remove(Material.KELP_PLANT);
		materialList.remove(Material.DEAD_TUBE_CORAL_WALL_FAN);
		materialList.remove(Material.DEAD_BRAIN_CORAL_WALL_FAN);
		materialList.remove(Material.DEAD_BUBBLE_CORAL_WALL_FAN);
		materialList.remove(Material.DEAD_FIRE_CORAL_WALL_FAN);
		materialList.remove(Material.DEAD_HORN_CORAL_WALL_FAN);
		materialList.remove(Material.TUBE_CORAL_WALL_FAN);
		materialList.remove(Material.BRAIN_CORAL_WALL_FAN);
		materialList.remove(Material.BUBBLE_CORAL_WALL_FAN);
		materialList.remove(Material.FIRE_CORAL_WALL_FAN);
		materialList.remove(Material.HORN_CORAL_WALL_FAN);
		materialList.remove(Material.BAMBOO_SAPLING);
		materialList.remove(Material.POTTED_BAMBOO);
		materialList.remove(Material.VOID_AIR);
		materialList.remove(Material.CAVE_AIR);
		materialList.remove(Material.BUBBLE_COLUMN);
		materialList.remove(Material.SWEET_BERRY_BUSH);
		materialList.remove(Material.WEEPING_VINES_PLANT);
		materialList.remove(Material.TWISTING_VINES_PLANT);
		materialList.remove(Material.CRIMSON_WALL_SIGN);
		materialList.remove(Material.WARPED_WALL_SIGN);
		materialList.remove(Material.POTTED_CRIMSON_FUNGUS);
		materialList.remove(Material.POTTED_WARPED_FUNGUS);
		materialList.remove(Material.POTTED_CRIMSON_ROOTS);
		materialList.remove(Material.POTTED_WARPED_ROOTS);
		materialList.remove(Material.CANDLE_CAKE);
		materialList.remove(Material.WHITE_CANDLE_CAKE);
		materialList.remove(Material.ORANGE_CANDLE_CAKE);
		materialList.remove(Material.MAGENTA_CANDLE_CAKE);
		materialList.remove(Material.LIGHT_BLUE_CANDLE_CAKE);
		materialList.remove(Material.YELLOW_CANDLE_CAKE);
		materialList.remove(Material.LIME_CANDLE_CAKE);
		materialList.remove(Material.PINK_CANDLE_CAKE);
		materialList.remove(Material.GRAY_CANDLE_CAKE);
		materialList.remove(Material.LIGHT_GRAY_CANDLE_CAKE);
		materialList.remove(Material.CYAN_CANDLE_CAKE);
		materialList.remove(Material.PURPLE_CANDLE_CAKE);
		materialList.remove(Material.BLUE_CANDLE_CAKE);
		materialList.remove(Material.BROWN_CANDLE_CAKE);
		materialList.remove(Material.GREEN_CANDLE_CAKE);
		materialList.remove(Material.RED_CANDLE_CAKE);
		materialList.remove(Material.BLACK_CANDLE_CAKE);
		materialList.remove(Material.POWDER_SNOW);
		materialList.remove(Material.CAVE_VINES);
		materialList.remove(Material.CAVE_VINES_PLANT);
		materialList.remove(Material.BIG_DRIPLEAF_STEM);
		materialList.remove(Material.POTTED_AZALEA_BUSH);
		materialList.remove(Material.POTTED_FLOWERING_AZALEA_BUSH);
		materialList.remove(Material.LEGACY_AIR);
		materialList.remove(Material.LEGACY_STONE);
		materialList.remove(Material.LEGACY_GRASS);
		materialList.remove(Material.LEGACY_DIRT);
		materialList.remove(Material.LEGACY_COBBLESTONE);
		materialList.remove(Material.LEGACY_WOOD);
		materialList.remove(Material.LEGACY_SAPLING);
		materialList.remove(Material.LEGACY_BEDROCK);
		materialList.remove(Material.LEGACY_WATER);
		materialList.remove(Material.LEGACY_STATIONARY_WATER);
		materialList.remove(Material.LEGACY_LAVA);
		materialList.remove(Material.LEGACY_STATIONARY_LAVA);
		materialList.remove(Material.LEGACY_SAND);
		materialList.remove(Material.LEGACY_GRAVEL);
		materialList.remove(Material.LEGACY_GOLD_ORE);
		materialList.remove(Material.LEGACY_IRON_ORE);
		materialList.remove(Material.LEGACY_COAL_ORE);
		materialList.remove(Material.LEGACY_LOG);
		materialList.remove(Material.LEGACY_LEAVES);
		materialList.remove(Material.LEGACY_SPONGE);
		materialList.remove(Material.LEGACY_GLASS);
		materialList.remove(Material.LEGACY_LAPIS_ORE);
		materialList.remove(Material.LEGACY_LAPIS_BLOCK);
		materialList.remove(Material.LEGACY_DISPENSER);
		materialList.remove(Material.LEGACY_SANDSTONE);
		materialList.remove(Material.LEGACY_NOTE_BLOCK);
		materialList.remove(Material.LEGACY_BED_BLOCK);
		materialList.remove(Material.LEGACY_POWERED_RAIL);
		materialList.remove(Material.LEGACY_DETECTOR_RAIL);
		materialList.remove(Material.LEGACY_PISTON_STICKY_BASE);
		materialList.remove(Material.LEGACY_WEB);
		materialList.remove(Material.LEGACY_LONG_GRASS);
		materialList.remove(Material.LEGACY_DEAD_BUSH);
		materialList.remove(Material.LEGACY_PISTON_BASE);
		materialList.remove(Material.LEGACY_PISTON_EXTENSION);
		materialList.remove(Material.LEGACY_WOOL);
		materialList.remove(Material.LEGACY_PISTON_MOVING_PIECE);
		materialList.remove(Material.LEGACY_YELLOW_FLOWER);
		materialList.remove(Material.LEGACY_RED_ROSE);
		materialList.remove(Material.LEGACY_BROWN_MUSHROOM);
		materialList.remove(Material.LEGACY_RED_MUSHROOM);
		materialList.remove(Material.LEGACY_GOLD_BLOCK);
		materialList.remove(Material.LEGACY_IRON_BLOCK);
		materialList.remove(Material.LEGACY_DOUBLE_STEP);
		materialList.remove(Material.LEGACY_STEP);
		materialList.remove(Material.LEGACY_BRICK);
		materialList.remove(Material.LEGACY_TNT);
		materialList.remove(Material.LEGACY_BOOKSHELF);
		materialList.remove(Material.LEGACY_MOSSY_COBBLESTONE);
		materialList.remove(Material.LEGACY_OBSIDIAN);
		materialList.remove(Material.LEGACY_TORCH);
		materialList.remove(Material.LEGACY_FIRE);
		materialList.remove(Material.LEGACY_MOB_SPAWNER);
		materialList.remove(Material.LEGACY_WOOD_STAIRS);
		materialList.remove(Material.LEGACY_CHEST);
		materialList.remove(Material.LEGACY_REDSTONE_WIRE);
		materialList.remove(Material.LEGACY_DIAMOND_ORE);
		materialList.remove(Material.LEGACY_DIAMOND_BLOCK);
		materialList.remove(Material.LEGACY_WORKBENCH);
		materialList.remove(Material.LEGACY_CROPS);
		materialList.remove(Material.LEGACY_SOIL);
		materialList.remove(Material.LEGACY_FURNACE);
		materialList.remove(Material.LEGACY_BURNING_FURNACE);
		materialList.remove(Material.LEGACY_SIGN_POST);
		materialList.remove(Material.LEGACY_WOODEN_DOOR);
		materialList.remove(Material.LEGACY_LADDER);
		materialList.remove(Material.LEGACY_RAILS);
		materialList.remove(Material.LEGACY_COBBLESTONE_STAIRS);
		materialList.remove(Material.LEGACY_WALL_SIGN);
		materialList.remove(Material.LEGACY_LEVER);
		materialList.remove(Material.LEGACY_STONE_PLATE);
		materialList.remove(Material.LEGACY_IRON_DOOR_BLOCK);
		materialList.remove(Material.LEGACY_WOOD_PLATE);
		materialList.remove(Material.LEGACY_REDSTONE_ORE);
		materialList.remove(Material.LEGACY_GLOWING_REDSTONE_ORE);
		materialList.remove(Material.LEGACY_REDSTONE_TORCH_OFF);
		materialList.remove(Material.LEGACY_REDSTONE_TORCH_ON);
		materialList.remove(Material.LEGACY_STONE_BUTTON);
		materialList.remove(Material.LEGACY_SNOW);
		materialList.remove(Material.LEGACY_ICE);
		materialList.remove(Material.LEGACY_SNOW_BLOCK);
		materialList.remove(Material.LEGACY_CACTUS);
		materialList.remove(Material.LEGACY_CLAY);
		materialList.remove(Material.LEGACY_SUGAR_CANE_BLOCK);
		materialList.remove(Material.LEGACY_JUKEBOX);
		materialList.remove(Material.LEGACY_FENCE);
		materialList.remove(Material.LEGACY_PUMPKIN);
		materialList.remove(Material.LEGACY_NETHERRACK);
		materialList.remove(Material.LEGACY_SOUL_SAND);
		materialList.remove(Material.LEGACY_GLOWSTONE);
		materialList.remove(Material.LEGACY_PORTAL);
		materialList.remove(Material.LEGACY_JACK_O_LANTERN);
		materialList.remove(Material.LEGACY_CAKE_BLOCK);
		materialList.remove(Material.LEGACY_DIODE_BLOCK_OFF);
		materialList.remove(Material.LEGACY_DIODE_BLOCK_ON);
		materialList.remove(Material.LEGACY_STAINED_GLASS);
		materialList.remove(Material.LEGACY_TRAP_DOOR);
		materialList.remove(Material.LEGACY_MONSTER_EGGS);
		materialList.remove(Material.LEGACY_SMOOTH_BRICK);
		materialList.remove(Material.LEGACY_HUGE_MUSHROOM_1);
		materialList.remove(Material.LEGACY_HUGE_MUSHROOM_2);
		materialList.remove(Material.LEGACY_IRON_FENCE);
		materialList.remove(Material.LEGACY_THIN_GLASS);
		materialList.remove(Material.LEGACY_MELON_BLOCK);
		materialList.remove(Material.LEGACY_PUMPKIN_STEM);
		materialList.remove(Material.LEGACY_MELON_STEM);
		materialList.remove(Material.LEGACY_VINE);
		materialList.remove(Material.LEGACY_FENCE_GATE);
		materialList.remove(Material.LEGACY_BRICK_STAIRS);
		materialList.remove(Material.LEGACY_SMOOTH_STAIRS);
		materialList.remove(Material.LEGACY_MYCEL);
		materialList.remove(Material.LEGACY_WATER_LILY);
		materialList.remove(Material.LEGACY_NETHER_BRICK);
		materialList.remove(Material.LEGACY_NETHER_FENCE);
		materialList.remove(Material.LEGACY_NETHER_BRICK_STAIRS);
		materialList.remove(Material.LEGACY_NETHER_WARTS);
		materialList.remove(Material.LEGACY_ENCHANTMENT_TABLE);
		materialList.remove(Material.LEGACY_BREWING_STAND);
		materialList.remove(Material.LEGACY_CAULDRON);
		materialList.remove(Material.LEGACY_ENDER_PORTAL);
		materialList.remove(Material.LEGACY_ENDER_PORTAL_FRAME);
		materialList.remove(Material.LEGACY_ENDER_STONE);
		materialList.remove(Material.LEGACY_DRAGON_EGG);
		materialList.remove(Material.LEGACY_REDSTONE_LAMP_OFF);
		materialList.remove(Material.LEGACY_REDSTONE_LAMP_ON);
		materialList.remove(Material.LEGACY_WOOD_DOUBLE_STEP);
		materialList.remove(Material.LEGACY_WOOD_STEP);
		materialList.remove(Material.LEGACY_COCOA);
		materialList.remove(Material.LEGACY_SANDSTONE_STAIRS);
		materialList.remove(Material.LEGACY_EMERALD_ORE);
		materialList.remove(Material.LEGACY_ENDER_CHEST);
		materialList.remove(Material.LEGACY_TRIPWIRE_HOOK);
		materialList.remove(Material.LEGACY_TRIPWIRE);
		materialList.remove(Material.LEGACY_EMERALD_BLOCK);
		materialList.remove(Material.LEGACY_SPRUCE_WOOD_STAIRS);
		materialList.remove(Material.LEGACY_BIRCH_WOOD_STAIRS);
		materialList.remove(Material.LEGACY_JUNGLE_WOOD_STAIRS);
		materialList.remove(Material.LEGACY_COMMAND);
		materialList.remove(Material.LEGACY_BEACON);
		materialList.remove(Material.LEGACY_COBBLE_WALL);
		materialList.remove(Material.LEGACY_FLOWER_POT);
		materialList.remove(Material.LEGACY_CARROT);
		materialList.remove(Material.LEGACY_POTATO);
		materialList.remove(Material.LEGACY_WOOD_BUTTON);
		materialList.remove(Material.LEGACY_SKULL);
		materialList.remove(Material.LEGACY_ANVIL);
		materialList.remove(Material.LEGACY_TRAPPED_CHEST);
		materialList.remove(Material.LEGACY_GOLD_PLATE);
		materialList.remove(Material.LEGACY_IRON_PLATE);
		materialList.remove(Material.LEGACY_REDSTONE_COMPARATOR_OFF);
		materialList.remove(Material.LEGACY_REDSTONE_COMPARATOR_ON);
		materialList.remove(Material.LEGACY_DAYLIGHT_DETECTOR);
		materialList.remove(Material.LEGACY_REDSTONE_BLOCK);
		materialList.remove(Material.LEGACY_QUARTZ_ORE);
		materialList.remove(Material.LEGACY_HOPPER);
		materialList.remove(Material.LEGACY_QUARTZ_BLOCK);
		materialList.remove(Material.LEGACY_QUARTZ_STAIRS);
		materialList.remove(Material.LEGACY_ACTIVATOR_RAIL);
		materialList.remove(Material.LEGACY_DROPPER);
		materialList.remove(Material.LEGACY_STAINED_CLAY);
		materialList.remove(Material.LEGACY_STAINED_GLASS_PANE);
		materialList.remove(Material.LEGACY_LEAVES_2);
		materialList.remove(Material.LEGACY_LOG_2);
		materialList.remove(Material.LEGACY_ACACIA_STAIRS);
		materialList.remove(Material.LEGACY_DARK_OAK_STAIRS);
		materialList.remove(Material.LEGACY_SLIME_BLOCK);
		materialList.remove(Material.LEGACY_BARRIER);
		materialList.remove(Material.LEGACY_IRON_TRAPDOOR);
		materialList.remove(Material.LEGACY_PRISMARINE);
		materialList.remove(Material.LEGACY_SEA_LANTERN);
		materialList.remove(Material.LEGACY_HAY_BLOCK);
		materialList.remove(Material.LEGACY_CARPET);
		materialList.remove(Material.LEGACY_HARD_CLAY);
		materialList.remove(Material.LEGACY_COAL_BLOCK);
		materialList.remove(Material.LEGACY_PACKED_ICE);
		materialList.remove(Material.LEGACY_DOUBLE_PLANT);
		materialList.remove(Material.LEGACY_STANDING_BANNER);
		materialList.remove(Material.LEGACY_WALL_BANNER);
		materialList.remove(Material.LEGACY_DAYLIGHT_DETECTOR_INVERTED);
		materialList.remove(Material.LEGACY_RED_SANDSTONE);
		materialList.remove(Material.LEGACY_RED_SANDSTONE_STAIRS);
		materialList.remove(Material.LEGACY_DOUBLE_STONE_SLAB2);
		materialList.remove(Material.LEGACY_STONE_SLAB2);
		materialList.remove(Material.LEGACY_SPRUCE_FENCE_GATE);
		materialList.remove(Material.LEGACY_BIRCH_FENCE_GATE);
		materialList.remove(Material.LEGACY_JUNGLE_FENCE_GATE);
		materialList.remove(Material.LEGACY_DARK_OAK_FENCE_GATE);
		materialList.remove(Material.LEGACY_ACACIA_FENCE_GATE);
		materialList.remove(Material.LEGACY_SPRUCE_FENCE);
		materialList.remove(Material.LEGACY_BIRCH_FENCE);
		materialList.remove(Material.LEGACY_JUNGLE_FENCE);
		materialList.remove(Material.LEGACY_DARK_OAK_FENCE);
		materialList.remove(Material.LEGACY_ACACIA_FENCE);
		materialList.remove(Material.LEGACY_SPRUCE_DOOR);
		materialList.remove(Material.LEGACY_BIRCH_DOOR);
		materialList.remove(Material.LEGACY_JUNGLE_DOOR);
		materialList.remove(Material.LEGACY_ACACIA_DOOR);
		materialList.remove(Material.LEGACY_DARK_OAK_DOOR);
		materialList.remove(Material.LEGACY_END_ROD);
		materialList.remove(Material.LEGACY_CHORUS_PLANT);
		materialList.remove(Material.LEGACY_CHORUS_FLOWER);
		materialList.remove(Material.LEGACY_PURPUR_BLOCK);
		materialList.remove(Material.LEGACY_PURPUR_PILLAR);
		materialList.remove(Material.LEGACY_PURPUR_STAIRS);
		materialList.remove(Material.LEGACY_PURPUR_DOUBLE_SLAB);
		materialList.remove(Material.LEGACY_PURPUR_SLAB);
		materialList.remove(Material.LEGACY_END_BRICKS);
		materialList.remove(Material.LEGACY_BEETROOT_BLOCK);
		materialList.remove(Material.LEGACY_GRASS_PATH);
		materialList.remove(Material.LEGACY_END_GATEWAY);
		materialList.remove(Material.LEGACY_COMMAND_REPEATING);
		materialList.remove(Material.LEGACY_COMMAND_CHAIN);
		materialList.remove(Material.LEGACY_FROSTED_ICE);
		materialList.remove(Material.LEGACY_MAGMA);
		materialList.remove(Material.LEGACY_NETHER_WART_BLOCK);
		materialList.remove(Material.LEGACY_RED_NETHER_BRICK);
		materialList.remove(Material.LEGACY_BONE_BLOCK);
		materialList.remove(Material.LEGACY_STRUCTURE_VOID);
		materialList.remove(Material.LEGACY_OBSERVER);
		materialList.remove(Material.LEGACY_WHITE_SHULKER_BOX);
		materialList.remove(Material.LEGACY_ORANGE_SHULKER_BOX);
		materialList.remove(Material.LEGACY_MAGENTA_SHULKER_BOX);
		materialList.remove(Material.LEGACY_LIGHT_BLUE_SHULKER_BOX);
		materialList.remove(Material.LEGACY_YELLOW_SHULKER_BOX);
		materialList.remove(Material.LEGACY_LIME_SHULKER_BOX);
		materialList.remove(Material.LEGACY_PINK_SHULKER_BOX);
		materialList.remove(Material.LEGACY_GRAY_SHULKER_BOX);
		materialList.remove(Material.LEGACY_SILVER_SHULKER_BOX);
		materialList.remove(Material.LEGACY_CYAN_SHULKER_BOX);
		materialList.remove(Material.LEGACY_PURPLE_SHULKER_BOX);
		materialList.remove(Material.LEGACY_BLUE_SHULKER_BOX);
		materialList.remove(Material.LEGACY_BROWN_SHULKER_BOX);
		materialList.remove(Material.LEGACY_GREEN_SHULKER_BOX);
		materialList.remove(Material.LEGACY_RED_SHULKER_BOX);
		materialList.remove(Material.LEGACY_BLACK_SHULKER_BOX);
		materialList.remove(Material.LEGACY_WHITE_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_ORANGE_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_MAGENTA_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_LIGHT_BLUE_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_YELLOW_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_LIME_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_PINK_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_GRAY_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_SILVER_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_CYAN_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_PURPLE_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_BLUE_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_BROWN_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_GREEN_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_RED_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_BLACK_GLAZED_TERRACOTTA);
		materialList.remove(Material.LEGACY_CONCRETE);
		materialList.remove(Material.LEGACY_CONCRETE_POWDER);
		materialList.remove(Material.LEGACY_STRUCTURE_BLOCK);
		materialList.remove(Material.LEGACY_IRON_SPADE);
		materialList.remove(Material.LEGACY_IRON_PICKAXE);
		materialList.remove(Material.LEGACY_IRON_AXE);
		materialList.remove(Material.LEGACY_FLINT_AND_STEEL);
		materialList.remove(Material.LEGACY_APPLE);
		materialList.remove(Material.LEGACY_BOW);
		materialList.remove(Material.LEGACY_ARROW);
		materialList.remove(Material.LEGACY_COAL);
		materialList.remove(Material.LEGACY_DIAMOND);
		materialList.remove(Material.LEGACY_IRON_INGOT);
		materialList.remove(Material.LEGACY_GOLD_INGOT);
		materialList.remove(Material.LEGACY_IRON_SWORD);
		materialList.remove(Material.LEGACY_WOOD_SWORD);
		materialList.remove(Material.LEGACY_WOOD_SPADE);
		materialList.remove(Material.LEGACY_WOOD_PICKAXE);
		materialList.remove(Material.LEGACY_WOOD_AXE);
		materialList.remove(Material.LEGACY_STONE_SWORD);
		materialList.remove(Material.LEGACY_STONE_SPADE);
		materialList.remove(Material.LEGACY_STONE_PICKAXE);
		materialList.remove(Material.LEGACY_STONE_AXE);
		materialList.remove(Material.LEGACY_DIAMOND_SWORD);
		materialList.remove(Material.LEGACY_DIAMOND_SPADE);
		materialList.remove(Material.LEGACY_DIAMOND_PICKAXE);
		materialList.remove(Material.LEGACY_DIAMOND_AXE);
		materialList.remove(Material.LEGACY_STICK);
		materialList.remove(Material.LEGACY_BOWL);
		materialList.remove(Material.LEGACY_MUSHROOM_SOUP);
		materialList.remove(Material.LEGACY_GOLD_SWORD);
		materialList.remove(Material.LEGACY_GOLD_SPADE);
		materialList.remove(Material.LEGACY_GOLD_PICKAXE);
		materialList.remove(Material.LEGACY_GOLD_AXE);
		materialList.remove(Material.LEGACY_STRING);
		materialList.remove(Material.LEGACY_FEATHER);
		materialList.remove(Material.LEGACY_SULPHUR);
		materialList.remove(Material.LEGACY_WOOD_HOE);
		materialList.remove(Material.LEGACY_STONE_HOE);
		materialList.remove(Material.LEGACY_IRON_HOE);
		materialList.remove(Material.LEGACY_DIAMOND_HOE);
		materialList.remove(Material.LEGACY_GOLD_HOE);
		materialList.remove(Material.LEGACY_SEEDS);
		materialList.remove(Material.LEGACY_WHEAT);
		materialList.remove(Material.LEGACY_BREAD);
		materialList.remove(Material.LEGACY_LEATHER_HELMET);
		materialList.remove(Material.LEGACY_LEATHER_CHESTPLATE);
		materialList.remove(Material.LEGACY_LEATHER_LEGGINGS);
		materialList.remove(Material.LEGACY_LEATHER_BOOTS);
		materialList.remove(Material.LEGACY_CHAINMAIL_HELMET);
		materialList.remove(Material.LEGACY_CHAINMAIL_CHESTPLATE);
		materialList.remove(Material.LEGACY_CHAINMAIL_LEGGINGS);
		materialList.remove(Material.LEGACY_CHAINMAIL_BOOTS);
		materialList.remove(Material.LEGACY_IRON_HELMET);
		materialList.remove(Material.LEGACY_IRON_CHESTPLATE);
		materialList.remove(Material.LEGACY_IRON_LEGGINGS);
		materialList.remove(Material.LEGACY_IRON_BOOTS);
		materialList.remove(Material.LEGACY_DIAMOND_HELMET);
		materialList.remove(Material.LEGACY_DIAMOND_CHESTPLATE);
		materialList.remove(Material.LEGACY_DIAMOND_LEGGINGS);
		materialList.remove(Material.LEGACY_DIAMOND_BOOTS);
		materialList.remove(Material.LEGACY_GOLD_HELMET);
		materialList.remove(Material.LEGACY_GOLD_CHESTPLATE);
		materialList.remove(Material.LEGACY_GOLD_LEGGINGS);
		materialList.remove(Material.LEGACY_GOLD_BOOTS);
		materialList.remove(Material.LEGACY_FLINT);
		materialList.remove(Material.LEGACY_PORK);
		materialList.remove(Material.LEGACY_GRILLED_PORK);
		materialList.remove(Material.LEGACY_PAINTING);
		materialList.remove(Material.LEGACY_GOLDEN_APPLE);
		materialList.remove(Material.LEGACY_SIGN);
		materialList.remove(Material.LEGACY_WOOD_DOOR);
		materialList.remove(Material.LEGACY_BUCKET);
		materialList.remove(Material.LEGACY_WATER_BUCKET);
		materialList.remove(Material.LEGACY_LAVA_BUCKET);
		materialList.remove(Material.LEGACY_MINECART);
		materialList.remove(Material.LEGACY_SADDLE);
		materialList.remove(Material.LEGACY_IRON_DOOR);
		materialList.remove(Material.LEGACY_REDSTONE);
		materialList.remove(Material.LEGACY_SNOW_BALL);
		materialList.remove(Material.LEGACY_BOAT);
		materialList.remove(Material.LEGACY_LEATHER);
		materialList.remove(Material.LEGACY_MILK_BUCKET);
		materialList.remove(Material.LEGACY_CLAY_BRICK);
		materialList.remove(Material.LEGACY_CLAY_BALL);
		materialList.remove(Material.LEGACY_SUGAR_CANE);
		materialList.remove(Material.LEGACY_PAPER);
		materialList.remove(Material.LEGACY_BOOK);
		materialList.remove(Material.LEGACY_SLIME_BALL);
		materialList.remove(Material.LEGACY_STORAGE_MINECART);
		materialList.remove(Material.LEGACY_POWERED_MINECART);
		materialList.remove(Material.LEGACY_EGG);
		materialList.remove(Material.LEGACY_COMPASS);
		materialList.remove(Material.LEGACY_FISHING_ROD);
		materialList.remove(Material.LEGACY_WATCH);
		materialList.remove(Material.LEGACY_GLOWSTONE_DUST);
		materialList.remove(Material.LEGACY_RAW_FISH);
		materialList.remove(Material.LEGACY_COOKED_FISH);
		materialList.remove(Material.LEGACY_INK_SACK);
		materialList.remove(Material.LEGACY_BONE);
		materialList.remove(Material.LEGACY_SUGAR);
		materialList.remove(Material.LEGACY_CAKE);
		materialList.remove(Material.LEGACY_BED);
		materialList.remove(Material.LEGACY_DIODE);
		materialList.remove(Material.LEGACY_COOKIE);
		materialList.remove(Material.LEGACY_MAP);
		materialList.remove(Material.LEGACY_SHEARS);
		materialList.remove(Material.LEGACY_MELON);
		materialList.remove(Material.LEGACY_PUMPKIN_SEEDS);
		materialList.remove(Material.LEGACY_MELON_SEEDS);
		materialList.remove(Material.LEGACY_RAW_BEEF);
		materialList.remove(Material.LEGACY_COOKED_BEEF);
		materialList.remove(Material.LEGACY_RAW_CHICKEN);
		materialList.remove(Material.LEGACY_COOKED_CHICKEN);
		materialList.remove(Material.LEGACY_ROTTEN_FLESH);
		materialList.remove(Material.LEGACY_ENDER_PEARL);
		materialList.remove(Material.LEGACY_BLAZE_ROD);
		materialList.remove(Material.LEGACY_GHAST_TEAR);
		materialList.remove(Material.LEGACY_GOLD_NUGGET);
		materialList.remove(Material.LEGACY_NETHER_STALK);
		materialList.remove(Material.LEGACY_POTION);
		materialList.remove(Material.LEGACY_GLASS_BOTTLE);
		materialList.remove(Material.LEGACY_SPIDER_EYE);
		materialList.remove(Material.LEGACY_FERMENTED_SPIDER_EYE);
		materialList.remove(Material.LEGACY_BLAZE_POWDER);
		materialList.remove(Material.LEGACY_MAGMA_CREAM);
		materialList.remove(Material.LEGACY_BREWING_STAND_ITEM);
		materialList.remove(Material.LEGACY_CAULDRON_ITEM);
		materialList.remove(Material.LEGACY_EYE_OF_ENDER);
		materialList.remove(Material.LEGACY_SPECKLED_MELON);
		materialList.remove(Material.LEGACY_MONSTER_EGG);
		materialList.remove(Material.LEGACY_EXP_BOTTLE);
		materialList.remove(Material.LEGACY_FIREBALL);
		materialList.remove(Material.LEGACY_BOOK_AND_QUILL);
		materialList.remove(Material.LEGACY_WRITTEN_BOOK);
		materialList.remove(Material.LEGACY_EMERALD);
		materialList.remove(Material.LEGACY_ITEM_FRAME);
		materialList.remove(Material.LEGACY_FLOWER_POT_ITEM);
		materialList.remove(Material.LEGACY_CARROT_ITEM);
		materialList.remove(Material.LEGACY_POTATO_ITEM);
		materialList.remove(Material.LEGACY_BAKED_POTATO);
		materialList.remove(Material.LEGACY_POISONOUS_POTATO);
		materialList.remove(Material.LEGACY_EMPTY_MAP);
		materialList.remove(Material.LEGACY_GOLDEN_CARROT);
		materialList.remove(Material.LEGACY_SKULL_ITEM);
		materialList.remove(Material.LEGACY_CARROT_STICK);
		materialList.remove(Material.LEGACY_NETHER_STAR);
		materialList.remove(Material.LEGACY_PUMPKIN_PIE);
		materialList.remove(Material.LEGACY_FIREWORK);
		materialList.remove(Material.LEGACY_FIREWORK_CHARGE);
		materialList.remove(Material.LEGACY_ENCHANTED_BOOK);
		materialList.remove(Material.LEGACY_REDSTONE_COMPARATOR);
		materialList.remove(Material.LEGACY_NETHER_BRICK_ITEM);
		materialList.remove(Material.LEGACY_QUARTZ);
		materialList.remove(Material.LEGACY_EXPLOSIVE_MINECART);
		materialList.remove(Material.LEGACY_HOPPER_MINECART);
		materialList.remove(Material.LEGACY_PRISMARINE_SHARD);
		materialList.remove(Material.LEGACY_PRISMARINE_CRYSTALS);
		materialList.remove(Material.LEGACY_RABBIT);
		materialList.remove(Material.LEGACY_COOKED_RABBIT);
		materialList.remove(Material.LEGACY_RABBIT_STEW);
		materialList.remove(Material.LEGACY_RABBIT_FOOT);
		materialList.remove(Material.LEGACY_RABBIT_HIDE);
		materialList.remove(Material.LEGACY_ARMOR_STAND);
		materialList.remove(Material.LEGACY_IRON_BARDING);
		materialList.remove(Material.LEGACY_GOLD_BARDING);
		materialList.remove(Material.LEGACY_DIAMOND_BARDING);
		materialList.remove(Material.LEGACY_LEASH);
		materialList.remove(Material.LEGACY_NAME_TAG);
		materialList.remove(Material.LEGACY_COMMAND_MINECART);
		materialList.remove(Material.LEGACY_MUTTON);
		materialList.remove(Material.LEGACY_COOKED_MUTTON);
		materialList.remove(Material.LEGACY_BANNER);
		materialList.remove(Material.LEGACY_END_CRYSTAL);
		materialList.remove(Material.LEGACY_SPRUCE_DOOR_ITEM);
		materialList.remove(Material.LEGACY_BIRCH_DOOR_ITEM);
		materialList.remove(Material.LEGACY_JUNGLE_DOOR_ITEM);
		materialList.remove(Material.LEGACY_ACACIA_DOOR_ITEM);
		materialList.remove(Material.LEGACY_DARK_OAK_DOOR_ITEM);
		materialList.remove(Material.LEGACY_CHORUS_FRUIT);
		materialList.remove(Material.LEGACY_CHORUS_FRUIT_POPPED);
		materialList.remove(Material.LEGACY_BEETROOT);
		materialList.remove(Material.LEGACY_BEETROOT_SEEDS);
		materialList.remove(Material.LEGACY_BEETROOT_SOUP);
		materialList.remove(Material.LEGACY_DRAGONS_BREATH);
		materialList.remove(Material.LEGACY_SPLASH_POTION);
		materialList.remove(Material.LEGACY_SPECTRAL_ARROW);
		materialList.remove(Material.LEGACY_TIPPED_ARROW);
		materialList.remove(Material.LEGACY_LINGERING_POTION);
		materialList.remove(Material.LEGACY_SHIELD);
		materialList.remove(Material.LEGACY_ELYTRA);
		materialList.remove(Material.LEGACY_BOAT_SPRUCE);
		materialList.remove(Material.LEGACY_BOAT_BIRCH);
		materialList.remove(Material.LEGACY_BOAT_JUNGLE);
		materialList.remove(Material.LEGACY_BOAT_ACACIA);
		materialList.remove(Material.LEGACY_BOAT_DARK_OAK);
		materialList.remove(Material.LEGACY_TOTEM);
		materialList.remove(Material.LEGACY_SHULKER_SHELL);
		materialList.remove(Material.LEGACY_IRON_NUGGET);
		materialList.remove(Material.LEGACY_KNOWLEDGE_BOOK);
		materialList.remove(Material.LEGACY_GOLD_RECORD);
		materialList.remove(Material.LEGACY_GREEN_RECORD);
		materialList.remove(Material.LEGACY_RECORD_3);
		materialList.remove(Material.LEGACY_RECORD_4);
		materialList.remove(Material.LEGACY_RECORD_5);
		materialList.remove(Material.LEGACY_RECORD_6);
		materialList.remove(Material.LEGACY_RECORD_7);
		materialList.remove(Material.LEGACY_RECORD_8);
		materialList.remove(Material.LEGACY_RECORD_9);
		materialList.remove(Material.LEGACY_RECORD_10);
		materialList.remove(Material.LEGACY_RECORD_11);
		materialList.remove(Material.LEGACY_RECORD_12);
		materialList.remove(Material.ENCHANTED_BOOK);
		materialList.remove(Material.POTION);
		materialList.remove(Material.SPLASH_POTION);
		materialList.remove(Material.LINGERING_POTION);
		materialList.remove(Material.SHORT_GRASS);
		materialList.remove(Material.BREEZE_SPAWN_EGG);
		materialList.remove(Material.TRIAL_SPAWNER);
		materialList.remove(Material.VAULT);
		materialList.remove(Material.OMINOUS_BOTTLE);
		materialList.remove(Material.TIPPED_ARROW);

		potionList.remove(PotionType.LUCK);

		possibleEnchantments.put(new ItemStack(Material.TURTLE_HELMET), new Enchantment[] {Enchantment.AQUA_AFFINITY, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.RESPIRATION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.BOW), new Enchantment[] {Enchantment.FLAME, Enchantment.PUNCH, Enchantment.POWER, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.INFINITY, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.WOODEN_SWORD), new Enchantment[] {Enchantment.LOOTING, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.FIRE_ASPECT, Enchantment.KNOCKBACK, Enchantment.SWEEPING_EDGE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.WOODEN_SHOVEL), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.WOODEN_PICKAXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.WOODEN_AXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.WOODEN_HOE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.STONE_SWORD), new Enchantment[] {Enchantment.LOOTING, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.FIRE_ASPECT, Enchantment.KNOCKBACK, Enchantment.SWEEPING_EDGE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.STONE_SHOVEL), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.STONE_PICKAXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.STONE_AXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.STONE_HOE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.GOLDEN_SWORD), new Enchantment[] {Enchantment.LOOTING, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.FIRE_ASPECT, Enchantment.KNOCKBACK, Enchantment.SWEEPING_EDGE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.GOLDEN_SHOVEL), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.GOLDEN_PICKAXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.GOLDEN_AXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.GOLDEN_HOE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.IRON_SWORD), new Enchantment[] {Enchantment.LOOTING, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.FIRE_ASPECT, Enchantment.KNOCKBACK, Enchantment.SWEEPING_EDGE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.IRON_SHOVEL), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.IRON_PICKAXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.IRON_AXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.IRON_HOE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.COPPER_SWORD), new Enchantment[] {Enchantment.LOOTING, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.FIRE_ASPECT, Enchantment.KNOCKBACK, Enchantment.SWEEPING_EDGE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.COPPER_SHOVEL), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.COPPER_PICKAXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.COPPER_AXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.COPPER_HOE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.DIAMOND_SWORD), new Enchantment[] {Enchantment.LOOTING, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.FIRE_ASPECT, Enchantment.KNOCKBACK, Enchantment.SWEEPING_EDGE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.DIAMOND_SHOVEL), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.DIAMOND_PICKAXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.DIAMOND_AXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.DIAMOND_HOE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.NETHERITE_SWORD), new Enchantment[] {Enchantment.LOOTING, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.FIRE_ASPECT, Enchantment.KNOCKBACK, Enchantment.SWEEPING_EDGE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.NETHERITE_SHOVEL), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.NETHERITE_PICKAXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.NETHERITE_AXE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.SHARPNESS, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.SMITE, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS});
		possibleEnchantments.put(new ItemStack(Material.NETHERITE_HOE), new Enchantment[] {Enchantment.EFFICIENCY, Enchantment.SILK_TOUCH, Enchantment.FORTUNE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.LEATHER_HELMET), new Enchantment[] {Enchantment.AQUA_AFFINITY, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.RESPIRATION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.LEATHER_CHESTPLATE), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.LEATHER_LEGGINGS), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.SWIFT_SNEAK, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.LEATHER_BOOTS), new Enchantment[] {Enchantment.SOUL_SPEED, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FROST_WALKER, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.FEATHER_FALLING, Enchantment.UNBREAKING, Enchantment.DEPTH_STRIDER, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.CHAINMAIL_HELMET), new Enchantment[] {Enchantment.AQUA_AFFINITY, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.RESPIRATION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.CHAINMAIL_CHESTPLATE), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.CHAINMAIL_LEGGINGS), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.SWIFT_SNEAK, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.CHAINMAIL_BOOTS), new Enchantment[] {Enchantment.SOUL_SPEED, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FROST_WALKER, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.FEATHER_FALLING, Enchantment.UNBREAKING, Enchantment.DEPTH_STRIDER, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.IRON_HELMET), new Enchantment[] {Enchantment.AQUA_AFFINITY, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.RESPIRATION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.IRON_CHESTPLATE), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.IRON_LEGGINGS), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.SWIFT_SNEAK, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.IRON_BOOTS), new Enchantment[] {Enchantment.SOUL_SPEED, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FROST_WALKER, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.FEATHER_FALLING, Enchantment.UNBREAKING, Enchantment.DEPTH_STRIDER, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.COPPER_HELMET), new Enchantment[] {Enchantment.AQUA_AFFINITY, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.RESPIRATION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.COPPER_CHESTPLATE), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.COPPER_LEGGINGS), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.SWIFT_SNEAK, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.COPPER_BOOTS), new Enchantment[] {Enchantment.SOUL_SPEED, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FROST_WALKER, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.FEATHER_FALLING, Enchantment.UNBREAKING, Enchantment.DEPTH_STRIDER, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.DIAMOND_HELMET), new Enchantment[] {Enchantment.AQUA_AFFINITY, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.RESPIRATION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.DIAMOND_CHESTPLATE), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.DIAMOND_LEGGINGS), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.SWIFT_SNEAK, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.DIAMOND_BOOTS), new Enchantment[] {Enchantment.SOUL_SPEED, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FROST_WALKER, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.FEATHER_FALLING, Enchantment.UNBREAKING, Enchantment.DEPTH_STRIDER, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.GOLDEN_HELMET), new Enchantment[] {Enchantment.AQUA_AFFINITY, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.RESPIRATION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.GOLDEN_CHESTPLATE), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.GOLDEN_LEGGINGS), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.SWIFT_SNEAK, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.GOLDEN_BOOTS), new Enchantment[] {Enchantment.SOUL_SPEED, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FROST_WALKER, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.FEATHER_FALLING, Enchantment.UNBREAKING, Enchantment.DEPTH_STRIDER, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.NETHERITE_HELMET), new Enchantment[] {Enchantment.AQUA_AFFINITY, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.RESPIRATION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.NETHERITE_CHESTPLATE), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.NETHERITE_LEGGINGS), new Enchantment[] {Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.SWIFT_SNEAK, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.NETHERITE_BOOTS), new Enchantment[] {Enchantment.SOUL_SPEED, Enchantment.BINDING_CURSE, Enchantment.PROJECTILE_PROTECTION, Enchantment.FROST_WALKER, Enchantment.FIRE_PROTECTION, Enchantment.PROTECTION, Enchantment.MENDING, Enchantment.FEATHER_FALLING, Enchantment.UNBREAKING, Enchantment.DEPTH_STRIDER, Enchantment.VANISHING_CURSE, Enchantment.BLAST_PROTECTION, Enchantment.THORNS});
		possibleEnchantments.put(new ItemStack(Material.FISHING_ROD), new Enchantment[] {Enchantment.LUCK_OF_THE_SEA, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.LURE, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.TRIDENT), new Enchantment[] {Enchantment.CHANNELING, Enchantment.LOYALTY, Enchantment.IMPALING, Enchantment.RIPTIDE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.CROSSBOW), new Enchantment[] {Enchantment.QUICK_CHARGE, Enchantment.MULTISHOT, Enchantment.MENDING, Enchantment.PIERCING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.MACE), new Enchantment[] {Enchantment.BREACH, Enchantment.DENSITY, Enchantment.WIND_BURST, Enchantment.UNBREAKING, Enchantment.MENDING, Enchantment.VANISHING_CURSE, Enchantment.BANE_OF_ARTHROPODS, Enchantment.SMITE, Enchantment.FIRE_ASPECT});
		possibleEnchantments.put(new ItemStack(Material.WOODEN_SPEAR), new Enchantment[] {Enchantment.SHARPNESS, Enchantment.SMITE, Enchantment.BANE_OF_ARTHROPODS, Enchantment.LOOTING, Enchantment.KNOCKBACK, Enchantment.FIRE_ASPECT, Enchantment.LUNGE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.STONE_SPEAR), new Enchantment[] {Enchantment.SHARPNESS, Enchantment.SMITE, Enchantment.BANE_OF_ARTHROPODS, Enchantment.LOOTING, Enchantment.KNOCKBACK, Enchantment.FIRE_ASPECT, Enchantment.LUNGE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.IRON_SPEAR), new Enchantment[] {Enchantment.SHARPNESS, Enchantment.SMITE, Enchantment.BANE_OF_ARTHROPODS, Enchantment.LOOTING, Enchantment.KNOCKBACK, Enchantment.FIRE_ASPECT, Enchantment.LUNGE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.COPPER_SPEAR), new Enchantment[] {Enchantment.SHARPNESS, Enchantment.SMITE, Enchantment.BANE_OF_ARTHROPODS, Enchantment.LOOTING, Enchantment.KNOCKBACK, Enchantment.FIRE_ASPECT, Enchantment.LUNGE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.GOLDEN_SPEAR), new Enchantment[] {Enchantment.SHARPNESS, Enchantment.SMITE, Enchantment.BANE_OF_ARTHROPODS, Enchantment.LOOTING, Enchantment.KNOCKBACK, Enchantment.FIRE_ASPECT, Enchantment.LUNGE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.DIAMOND_SPEAR), new Enchantment[] {Enchantment.SHARPNESS, Enchantment.SMITE, Enchantment.BANE_OF_ARTHROPODS, Enchantment.LOOTING, Enchantment.KNOCKBACK, Enchantment.FIRE_ASPECT, Enchantment.LUNGE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});
		possibleEnchantments.put(new ItemStack(Material.NETHERITE_SPEAR), new Enchantment[] {Enchantment.SHARPNESS, Enchantment.SMITE, Enchantment.BANE_OF_ARTHROPODS, Enchantment.LOOTING, Enchantment.KNOCKBACK, Enchantment.FIRE_ASPECT, Enchantment.LUNGE, Enchantment.MENDING, Enchantment.UNBREAKING, Enchantment.VANISHING_CURSE});

		
		trimMaterials.add(TrimMaterial.AMETHYST);
		trimMaterials.add(TrimMaterial.COPPER);
		trimMaterials.add(TrimMaterial.DIAMOND);
		trimMaterials.add(TrimMaterial.EMERALD);
		trimMaterials.add(TrimMaterial.GOLD);
		trimMaterials.add(TrimMaterial.IRON);
		trimMaterials.add(TrimMaterial.LAPIS);
		trimMaterials.add(TrimMaterial.NETHERITE);
		trimMaterials.add(TrimMaterial.QUARTZ);
		trimMaterials.add(TrimMaterial.REDSTONE);
		
		trimPatterns.add(TrimPattern.COAST);
		trimPatterns.add(TrimPattern.DUNE);
		trimPatterns.add(TrimPattern.EYE);
		trimPatterns.add(TrimPattern.HOST);
		trimPatterns.add(TrimPattern.RAISER);
		trimPatterns.add(TrimPattern.RIB);
		trimPatterns.add(TrimPattern.SENTRY);
		trimPatterns.add(TrimPattern.SHAPER);
		trimPatterns.add(TrimPattern.SILENCE);
		trimPatterns.add(TrimPattern.SNOUT);
		trimPatterns.add(TrimPattern.SPIRE);
		trimPatterns.add(TrimPattern.TIDE);
		trimPatterns.add(TrimPattern.VEX);
		trimPatterns.add(TrimPattern.WARD);
		trimPatterns.add(TrimPattern.WAYFINDER);
		trimPatterns.add(TrimPattern.WILD);
		
		armors.add(Material.CHAINMAIL_HELMET);
		armors.add(Material.CHAINMAIL_CHESTPLATE);
		armors.add(Material.CHAINMAIL_LEGGINGS);
		armors.add(Material.CHAINMAIL_BOOTS);
		armors.add(Material.IRON_HELMET);
		armors.add(Material.IRON_CHESTPLATE);
		armors.add(Material.IRON_LEGGINGS);
		armors.add(Material.IRON_BOOTS);
		armors.add(Material.DIAMOND_HELMET);
		armors.add(Material.DIAMOND_CHESTPLATE);
		armors.add(Material.DIAMOND_LEGGINGS);
		armors.add(Material.DIAMOND_BOOTS);
		armors.add(Material.NETHERITE_HELMET);
		armors.add(Material.NETHERITE_CHESTPLATE);
		armors.add(Material.NETHERITE_LEGGINGS);
		armors.add(Material.NETHERITE_BOOTS);
		armors.add(Material.GOLDEN_HELMET);
		armors.add(Material.GOLDEN_CHESTPLATE);
		armors.add(Material.GOLDEN_LEGGINGS);
		armors.add(Material.GOLDEN_BOOTS);
		
		potionListLength = potionList.size();	
		trimMaterialListLength = trimMaterials.size();
		trimPatternListLength = trimPatterns.size();

		loreSilkTouch.add(ChatColor.GREEN + "Obtainable with Silk Touch!");
		metaSpawner.setLore(loreSilkTouch);
		metaDeepslate.setLore(loreSilkTouch);

		for (Material m : materialList) {
			ItemStack item = new ItemStack(m);
			if (m == Material.REINFORCED_DEEPSLATE) {
				item.setItemMeta(metaDeepslate);
			}
			if (m == Material.SPAWNER) {
				item.setItemMeta(metaSpawner);
			}
			itemList.add(item);
		}
		//enchanted books
		for (Enchantment e : enchantmentList) {
			for (int i = 1; i <= e.getMaxLevel(); i++) {
				ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
				ItemMeta meta = item.getItemMeta();
				meta.addEnchant(e, i, false);
				item.setItemMeta(meta);
				itemList.add(item);
			}
		}
		//enchantment permutations for enchantable items
		for (ItemStack item : possibleEnchantments.keySet()) {
			Enchantment[] enchs = possibleEnchantments.get(item);
			List<ItemStack> enchantedVariations = new ArrayList<ItemStack>();
			int variationsCount = 1;
			for (int i = 0; i < enchs.length; i++) {
				variationsCount *= enchs[i].getMaxLevel();
			}
			//Bukkit.getLogger().info("Enchantment permutations for " + item.getType() + ": " + String.valueOf(variationsCount));
			for (int i = 1; i < variationsCount; i++) {
				ItemStack current = item.clone();
				ItemMeta meta = current.getItemMeta();
				int prevPermutations = 1;
				for (int j = 0; j < enchs.length; j++) {
					int currentLevel = (i / prevPermutations) % (enchs[j].getMaxLevel() + 1);
					prevPermutations *= (enchs[j].getMaxLevel() + 1);
					if (currentLevel == 0) {
						continue;
					}
					meta.addEnchant(enchs[j], currentLevel, false);
				}
				current.setItemMeta(meta);
				enchantedVariations.add(current);
			}
			itemloop:
			for (ItemStack i : enchantedVariations) {
				List<Enchantment> ees = new ArrayList<Enchantment>(i.getItemMeta().getEnchants().keySet()); 
				for (int x = 0; x < ees.size(); x++) {
					for (int y = x + 1; y < ees.size(); y++) {
						if (ees.get(x).conflictsWith(ees.get(y))) {
							continue itemloop;
						}
					}
				}
				itemList.add(i);
			}
		}
		// armor trims with differnet patterns and materials
		List<ItemStack> trimsToAdd = new ArrayList<ItemStack>();
		for (Material m : armors) {
			ItemStack item = new ItemStack(m);
			for (TrimPattern pattern : trimPatterns) {
				for (TrimMaterial material : trimMaterials) {
					ItemStack current = item.clone();
					ArmorMeta meta = (ArmorMeta) current.getItemMeta();
					meta.setTrim(new ArmorTrim(material, pattern));
					current.setItemMeta(meta);
					trimsToAdd.add(current);
				}
			}
		}
		for (ItemStack i : trimsToAdd) {
			itemList.add(i);
			//Bukkit.getLogger().info(i.getItemMeta().getAsComponentString());
		}
		//potions (normal, splash, lingering) and tipped arrows
		for (PotionType p : potionList) {
			ItemStack pot = new ItemStack(Material.POTION);
			ItemStack splash = new ItemStack(Material.SPLASH_POTION);
			ItemStack lingering = new ItemStack(Material.LINGERING_POTION);
			ItemStack arrow = new ItemStack(Material.TIPPED_ARROW);
			PotionMeta potMeta = (PotionMeta) pot.getItemMeta();
			potMeta.setBasePotionType(p);
			pot.setItemMeta(potMeta);
			splash.setItemMeta(potMeta);
			lingering.setItemMeta(potMeta);
			arrow.setItemMeta(potMeta);
			itemList.add(pot);
			itemList.add(splash);
			itemList.add(lingering);
			itemList.add(arrow);
		}
		//ominous bottle, including different ominous bottle amplifiers
		for (int i = 0; i < 5; i++) {
			ItemStack bottle = new ItemStack(Material.OMINOUS_BOTTLE);
			OminousBottleMeta bottleMeta = (OminousBottleMeta) bottle.getItemMeta();
			bottleMeta.setAmplifier(i);
			bottle.setItemMeta(bottleMeta);
			itemList.add(bottle);
		}
		
		itemListLength = itemList.size();
		
		adjustWeights(materialList);
	}
	private static void adjustWeights(List<Material> materials) {
		Material current = itemList.get(0).getType();
		int currentAppearances = 0;
		List<ItemStack> similarItems = new ArrayList<ItemStack>();
		for (ItemStack stack : itemList) {
			if (stack.getType() != current) {
				for (ItemStack s : similarItems) {
					ItemRoll r = new ItemRoll(s, 1.0 / ((double) currentAppearances) * 0.75);
					rolls.add(r);
				}
				currentAppearances = 1;
				similarItems.clear();
				similarItems.add(stack);
				current = stack.getType();
				continue;
			}
			currentAppearances++;
			similarItems.add(stack);
		}
		for (ItemStack s : similarItems) {
			ItemRoll r = new ItemRoll(s, 1.0 / ((double) currentAppearances * 0.75));
			rolls.add(r);
		}
	}
	public static ItemStack getRandomItem(List<Integer> blacklist) {
		int randomIndex = 0;
		ItemStack item = null;
		while (blacklist.contains(randomIndex) || item == null) {
			randomIndex = rd.nextInt(itemListLength);
			item = rolls.get(randomIndex).roll();
		}
		blacklist.add(randomIndex);
		return item;
	}
	public static boolean itemsEqual(ItemStack a, ItemStack b) {
		if (a.getType() != b.getType()) {
			return false;
		}
		ItemMeta aMeta = a.getItemMeta();
		ItemMeta bMeta = b.getItemMeta();
		if (nullOrEmpty(bMeta)) {
			return true;
		}
		if (nullOrEmpty(aMeta)) {
			return false;
		}
		return tagsEqual(aMeta.serialize(), bMeta.serialize());
	}
	private static boolean nullOrEmpty(ItemMeta meta) {
		return meta == null || meta.getAsString().contentEquals("{}");
	}
	@SuppressWarnings("unchecked")
	private static boolean tagsEqual(Map<String, Object> tags1, Map<String, Object> tags2) {
		Set<String> keySet2 = tags2.keySet();
		if (!tags1.keySet().containsAll(keySet2)) {
			return false;
		}
		for (String s : keySet2) {
			Object value2 = tags2.get(s);
			Object value1 = tags1.get(s);
			if (contentEquals(value1, value2)) {
				continue;
			}
			if (!(value2 instanceof Map && value1 instanceof Map)) {
				return false;
			}
			if (!tagsEqual((Map<String, Object>) value1, (Map<String, Object>) value2)) {
				return false;
			}
		}
		return true;
	}
	private static <T> ArrayList<T> asList(T[] in) {
		ArrayList<T> list = new ArrayList<T>();
		for (T t : in) {
			list.add(t);
		}
		return list;
	}
	private static boolean contentEquals(Object obj1, Object obj2) {
		Class<?> class1 = obj1.getClass();
		if (class1 != obj2.getClass()) {
			return false;
		}
		if (class1 == String.class) {
			return ((String) obj2).contentEquals((String) obj1);
		}
		if (obj1.getClass().isArray()) {
			return arraysEqual((Object[]) obj1, (Object[]) obj2);
		}
		return obj1 == obj2;
	}
	private static boolean arraysEqual(Object[] a, Object[] b) {
		if (a.length < b.length) {
			return false;
		}
		List<Object> bList = new ArrayList<Object>();
		for (Object o : b) {
			bList.add(o);
		}
		for (Object p : a) {
			bList.remove(p);
		}
		return bList.isEmpty();
	}
}
