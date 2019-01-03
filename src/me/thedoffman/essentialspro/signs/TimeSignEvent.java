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
 
public class TimeSignEvent implements Listener {
	
    public TimeSignEvent(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
// Day ________________________________ 
        @EventHandler
        public void onSignChangeDay(SignChangeEvent e) {
        	if(e.getPlayer().hasPermission("ep.singtime")){
                if (e.getLine(0).equalsIgnoreCase("[Time]") && e.getLine(1).equalsIgnoreCase("Day")) {
                        	e.setLine(0, "§9[Time]");
                        	e.setLine(1, "§aDay");
                        	e.getPlayer().sendMessage(ChatColor.BLUE + "Sign created for time " + ChatColor.GREEN + "DAY" + ChatColor.BLUE + "!");
                }
        	}
        }
        @EventHandler
        public void onPlayerInteractDay(PlayerInteractEvent e) {
        	if(e.getPlayer().hasPermission("ep.singtimeuse")){
                if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
                if (e.getClickedBlock().getState() instanceof Sign) {
                        Sign s = (Sign) e.getClickedBlock().getState();
                        if (s.getLine(1).equalsIgnoreCase("§aDay")) {
                                e.getPlayer().getWorld().setTime(0);
                                e.getPlayer().sendMessage(ChatColor.GREEN + "Time set to Day!");
                        }
                }
        }
        }
// Night ________________________________
        @EventHandler
        public void onSignChangeNight(SignChangeEvent e) {
        	if(e.getPlayer().hasPermission("ep.singtime")){
                if (e.getLine(0).equalsIgnoreCase("[Time]") && e.getLine(1).equalsIgnoreCase("Night")) {
                        	e.setLine(0, "§9[Time]");
                        	e.setLine(1, "§aNight");
                        	e.getPlayer().sendMessage(ChatColor.BLUE + "Sign created for time " + ChatColor.GREEN + "NIGHT" + ChatColor.BLUE + "!");
                }
        	}
        }
        @EventHandler
        public void onPlayerInteractNight(PlayerInteractEvent e) {
        	if(e.getPlayer().hasPermission("ep.singtimeuse")){
                if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
                if (e.getClickedBlock().getState() instanceof Sign) {
                        Sign s = (Sign) e.getClickedBlock().getState();
                        if (s.getLine(1).equalsIgnoreCase("§aNight")) {
                                e.getPlayer().getWorld().setTime(14000);
                                e.getPlayer().sendMessage(ChatColor.GREEN + "Time set to Night!");
                        }
                }
        }
        }
// Noon _________________________________
        @EventHandler
        public void onSignChangeNoon(SignChangeEvent e) {
        	if(e.getPlayer().hasPermission("ep.singtime")){
                if (e.getLine(0).equalsIgnoreCase("[Time]") && e.getLine(1).equalsIgnoreCase("Noon")) {
                        	e.setLine(0, "§9[Time]");
                        	e.setLine(1, "§aNoon");
                        	e.getPlayer().sendMessage(ChatColor.BLUE + "Sign created for time " + ChatColor.GREEN + "NOON" + ChatColor.BLUE + "!");
                }
        	}
        }
        @EventHandler
        public void onPlayerInteractNoon(PlayerInteractEvent e) {
        	if(e.getPlayer().hasPermission("ep.singtimeuse")){
                if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
                if (e.getClickedBlock().getState() instanceof Sign) {
                        Sign s = (Sign) e.getClickedBlock().getState();
                        if (s.getLine(1).equalsIgnoreCase("§aNoon")) {
                                e.getPlayer().getWorld().setTime(6000);
                                e.getPlayer().sendMessage(ChatColor.GREEN + "Time set to Noon!");
                        }
                }
        }
        }
}