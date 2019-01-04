package me.thedoffman.essentialspro.commands;

import java.util.ArrayList;
import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class Vanish
implements CommandExecutor,
Listener {
    private Main plugin = (Main)Main.getPlugin(Main.class);
    private ArrayList<Player> vanished = new ArrayList<Player>();

    public Vanish(Main plugin) {
        Bukkit.getPluginCommand((String)"vanish").setExecutor((CommandExecutor)this);
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }

    @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        if (!(sender instanceof Player)) {
            sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "You cannot vanish!");
            return true;
        }
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("vanish")) {
            if (!sender.hasPermission("ep.vanish")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (!this.vanished.contains((Object)p)) {
                for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                    pl.hidePlayer(p);
                }
                this.vanished.add(p);
                p.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GREEN + "POOF! You have been vanished!");
                return true;
            }
            for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                pl.showPlayer(p);
            }
            this.vanished.remove((Object)p);
            p.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GREEN + "POOF! You have been unvanished!");
            return true;
        }
        return true;
    }

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        for (Player p : this.vanished) {
            e.getPlayer().hidePlayer(p);
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        this.vanished.remove((Object)e.getPlayer());
    }
}

