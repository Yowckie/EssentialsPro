package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ClearChat
implements CommandExecutor {
    private Main plugin = Main.getPlugin(Main.class);

    public ClearChat(Main plugin) {
        Bukkit.getPluginCommand("clearchat").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "\u00A7");
        if (cmd.getName().equalsIgnoreCase("clearchat")) {
            if (!sender.hasPermission("ep.clearchat")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            int i = 0;
            while (i < 100) {
                Bukkit.broadcastMessage("");
                ++i;
            }
        }
        Bukkit.broadcastMessage(plugin.getlang().getString(plugin.prefix + ChatColor.GREEN + "Chat has been cleared!"));
        return true;
    }
}

