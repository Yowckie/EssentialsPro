package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnBan
implements CommandExecutor {
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public UnBan(Main plugin) {
        Bukkit.getPluginCommand((String)"unban").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        if (cmd.getName().equalsIgnoreCase("unban")) {
            if (!sender.hasPermission("ep.unban")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Please specify a player name!");
                return true;
            }
            if (!this.plugin.getplayers().getBoolean(String.valueOf(args[0]) + ".banned")) {
                sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Player " + args[0] + " is not banned!");
                return true;
            }
            this.plugin.getplayers().set(String.valueOf(args[0]) + ".banned", (Object)false);
            this.plugin.saveYamls();
            sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GREEN + "Unbaned " + args[0] + "!");
        }
        return true;
    }
}

