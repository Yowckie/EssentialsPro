package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn
implements CommandExecutor {
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public SetSpawn(Main plugin) {
        Bukkit.getPluginCommand((String)"setspawn").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        if (cmd.getName().equalsIgnoreCase("setspawn")) {
            if (!sender.hasPermission("ep.setspawn")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Error: Only players can set spawn!");
                return true;
            }
        }
        if (sender instanceof Player) {
            String Spawn2 = this.plugin.getlang().getString("Messages.SpawnSet");
            Spawn2 = Spawn2.replaceAll("&", "§");
            Player p = (Player)sender;
            World world = p.getWorld();
            Location loc = p.getLocation();
            world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
            p.sendMessage(String.valueOf(this.plugin.prefix) + Spawn2);
        }
        return false;
    }
}

