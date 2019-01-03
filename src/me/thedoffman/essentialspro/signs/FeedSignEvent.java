package me.thedoffman.essentialspro.signs;
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.thedoffman.essentialspro.main.Main;
 
public class FeedSignEvent implements Listener {
	
    public FeedSignEvent(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
	
 
        @EventHandler
        public void onSignChange(SignChangeEvent e) {
        	if(e.getPlayer().hasPermission("ep.singfeed")){
                if (e.getLine(0).equalsIgnoreCase("[Feed]")) {
                        e.setLine(0, "§9[Feed]");
                        e.setLine(1, "§aClick here");
                        e.setLine(2, "§ato get Food!");
                }
        	}
        }
       
        @EventHandler
        public void onPlayerInteract(PlayerInteractEvent e) {
        	if(e.getPlayer().hasPermission("ep.signfeeduse")){

                if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
                if (e.getClickedBlock().getState() instanceof Sign) {
                        Sign s = (Sign) e.getClickedBlock().getState();
                        if (s.getLine(0).equalsIgnoreCase("§9[Feed]")) {
                                e.getPlayer().setFoodLevel(20);;
                                e.getPlayer().sendMessage(ChatColor.GREEN + "You were Fed!");
                        }
                }
        	}
        }
}