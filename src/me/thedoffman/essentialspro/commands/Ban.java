package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ban
implements CommandExecutor {
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public Ban(Main plugin) {
        Bukkit.getPluginCommand((String)"ban").setExecutor((CommandExecutor)this);
    }

    @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        if (label.equalsIgnoreCase("ban")) {
            if (!sender.hasPermission("ep.ban")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Please specify a player and reason!");
            } else if (args.length == 1) {
                sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Please specify a reason!");
            } else {
                StringBuilder x = new StringBuilder();
                int i = 1;
                while (i < args.length) {
                    x.append(String.valueOf(args[i]) + " ");
                    ++i;
                }
                String banner = sender.getName();
                if (sender instanceof Player) {
                    banner = sender.getName();
                }
				Player target = Bukkit.getPlayer((String)args[0]);
                this.plugin.getplayers().set(String.valueOf(args[0]) + ".banned", (Object)true);
                this.plugin.getplayers().set(String.valueOf(args[0]) + ".reason", (Object)x.toString());
                this.plugin.getplayers().set(String.valueOf(args[0]) + ".banner", (Object)banner);
                this.plugin.saveYamls();
                Bukkit.getOfflinePlayer((String)args[0]).isBanned();
                target.kickPlayer((Object)ChatColor.RED + "You have been banned from the server!\nBy: " + banner + "\nReason: " + x.toString());
                Bukkit.broadcastMessage((String)(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GREEN + args[0] + (Object)ChatColor.BLUE + " was banned from the server!"));
                sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.BLUE + "Successfully banned: " + (Object)ChatColor.GREEN + (Object)target);
                return true;
            }
        }
        return true;
    }
}

