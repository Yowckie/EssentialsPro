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
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public Gamemode(Main plugin) {
        Bukkit.getPluginCommand((String)"gamemode").setExecutor((CommandExecutor)this);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        if (cmd.getName().equalsIgnoreCase("gamemode") && !sender.hasPermission("ep.gamemode")) {
            sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
            return true;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Error: Command use only in game.");
            return true;
        }
        Player player = (Player)sender;
        if (args.length == 0) {
            player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.BLUE + "Gamemode " + (Object)ChatColor.GREEN + "0" + (Object)ChatColor.BLUE + ", " + (Object)ChatColor.GREEN + "1 " + (Object)ChatColor.BLUE + ", " + (Object)ChatColor.GREEN + "2 " + (Object)ChatColor.BLUE + "or " + (Object)ChatColor.GREEN + "3" + (Object)ChatColor.BLUE + ".");
            return true;
        }
        if (args.length != 1) return true;
        if (args[0].equalsIgnoreCase("0")) {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.BLUE + "GameMode set to" + (Object)ChatColor.GREEN + " Survival");
            return true;
        }
        if (args[0].equalsIgnoreCase("1")) {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.BLUE + "GameMode set to" + (Object)ChatColor.GREEN + " Creative");
            return true;
        }
        if (args[0].equalsIgnoreCase("2")) {
            player.setGameMode(GameMode.ADVENTURE);
            player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.BLUE + "GameMode set to" + (Object)ChatColor.GREEN + " Adventure");
            return true;
        }
        if (args[0].equalsIgnoreCase("3")) {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.BLUE + "GameMode set to" + (Object)ChatColor.GREEN + " Spectator");
            return true;
        }
        player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Usage: /gamemode [0:1:2:3]");
        return true;
    }
}

