package main.java.de.cat_2000.itembingoplugin.listeners;

import main.java.de.cat_2000.itembingoplugin.TeamHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class NoHungerListener implements Listener {
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
