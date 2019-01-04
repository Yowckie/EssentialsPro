package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast
implements CommandExecutor {
    private static Main plugin = (Main)Main.getPlugin(Main.class);

    public Broadcast(Main plugin) {
        Bukkit.getPluginCommand((String)"broadcast").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Broadcast.plugin.prefix = Broadcast.plugin.prefix.replaceAll("&", "§");
        if (cmd.getName().equalsIgnoreCase("broadcast") && sender instanceof Player) {
            if (!sender.hasPermission("ep.broadcast")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(String.valueOf(Broadcast.plugin.prefix) + (Object)ChatColor.RED + " You must have a message to broadcast, silly!");
            }
            if (args.length > 0) {
                String broadcast = "";
                String[] arrstring = args;
                int n = arrstring.length;
                int n2 = 0;
                while (n2 < n) {
                    String message = arrstring[n2];
                    broadcast = String.valueOf(broadcast) + message + " ";
                    ++n2;
                }
                Bukkit.getServer().broadcastMessage((Object)ChatColor.DARK_BLUE + "[" + (Object)ChatColor.GREEN + "Broadcast" + (Object)ChatColor.DARK_BLUE + "] " + (Object)ChatColor.GRAY + broadcast);
            }
        }
        return false;
    }
}

