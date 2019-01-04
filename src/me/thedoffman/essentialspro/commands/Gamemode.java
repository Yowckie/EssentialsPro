package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode
implements CommandExecutor {
    private Main plugin = Main.getPlugin(Main.class);

    public Gamemode(Main plugin) {
        Bukkit.getPluginCommand("gamemode").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        if (cmd.getName().equalsIgnoreCase("gamemode") && !sender.hasPermission("ep.gamemode")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
            return true;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.prefix + ChatColor.RED + "Error: Command use only in game.");
            return true;
        }
        Player player = (Player)sender;
        if (args.length == 0) {
            player.sendMessage(plugin.prefix + ChatColor.BLUE + "Gamemode " + ChatColor.GREEN + "0" + ChatColor.BLUE + ", " + ChatColor.GREEN + "1 " + ChatColor.BLUE + ", " + ChatColor.GREEN + "2 " + ChatColor.BLUE + "or " + ChatColor.GREEN + "3" + ChatColor.BLUE + ".");
            return true;
        }
        if (args.length != 1) return true;
        if (args[0].equalsIgnoreCase("0")) {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(plugin.prefix + ChatColor.BLUE + "GameMode set to" + ChatColor.GREEN + " Survival");
            return true;
        }
        if (args[0].equalsIgnoreCase("1")) {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(plugin.prefix + ChatColor.BLUE + "GameMode set to" + ChatColor.GREEN + " Creative");
            return true;
        }
        if (args[0].equalsIgnoreCase("2")) {
            player.setGameMode(GameMode.ADVENTURE);
            player.sendMessage(plugin.prefix + ChatColor.BLUE + "GameMode set to" + ChatColor.GREEN + " Adventure");
            return true;
        }
        if (args[0].equalsIgnoreCase("3")) {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage(plugin.prefix + ChatColor.BLUE + "GameMode set to" + ChatColor.GREEN + " Spectator");
            return true;
        }
        player.sendMessage(plugin.prefix + ChatColor.RED + "Usage: /gamemode [0:1:2:3]");
        return true;
    }
}

