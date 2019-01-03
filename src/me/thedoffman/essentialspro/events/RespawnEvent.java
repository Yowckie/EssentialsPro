package me.thedoffman.essentialspro.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;

import me.thedoffman.essentialspro.main.Main;

public class RespawnEvent implements Listener {
	
    public RespawnEvent(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        Player player = e.getPlayer();
       Bukkit.	getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
        	public void run() {
                player.teleport(player.getWorld().getSpawnLocation());
        	}
        	}, 2L);

    }
}
