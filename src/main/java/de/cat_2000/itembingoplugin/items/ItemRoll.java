package main.java.de.cat_2000.itembingoplugin.items;

import java.util.Random;

import org.bukkit.inventory.ItemStack;

public class ItemRoll {
	private final ItemStack item;
	private final Random rd = new Random();
	private double probability;
	
	public ItemRoll(ItemStack i, double p) {
		if (i == null) {
			throw new IllegalArgumentException("Item cannot be null");
		}
		if (p < 0.0 || p > 1.0) {
			throw new IllegalArgumentException("Invalid probability, must be in range [0,1], but was " + p);
		}
		item = i;
		probability = p;
	}
	public ItemStack roll() {
		double random = rd.nextDouble();
		if (random < probability) {
			return this.item;
		}
		return null;
	}
}
