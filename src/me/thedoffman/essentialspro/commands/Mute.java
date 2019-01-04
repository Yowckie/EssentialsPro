package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Mute
implements CommandExecutor {
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public Mute(Main plugin) {
        Bukkit.getPluginCommand((String)"mute").setExecutor((CommandExecutor)this);
        Bukkit.getPluginCommand((String)"unmute").setExecutor((CommandExecutor)this);
    }

    @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player target;
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        if (label.equalsIgnoreCase("mute")) {
            if (!sender.hasPermission("ep.mute")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Please specify a player!");
            } else {
                target = Bukkit.getPlayer((String)args[0]);
                if (target == null) {
                    sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + args[0] + " is not online!");
                    return true;
                }
                Bukkit.broadcastMessage((String)(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GREEN + target.getName() + (Object)ChatColor.RED + " was muted!"));
                this.plugin.getplayers().set(String.valueOf(args[0]) + ".mute", (Object)true);
                this.plugin.saveYamls();
            }
        }
        if (label.equalsIgnoreCase("unmute")) {
            if (!sender.hasPermission("ep.unmute")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Please specify a player!");
            } else {
                target = Bukkit.getPlayer((String)args[0]);
                if (target == null) {
                    sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + args[0] + " is not online!");
                    return true;
                }
                Bukkit.broadcastMessage((String)(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GREEN + target.getName() + (Object)ChatColor.RED + " was unmuted!"));
                this.plugin.getplayers().set(String.valueOf(args[0]) + ".mute", (Object)false);
                this.plugin.saveYamls();
            }
        }
        return false;
    }
}

