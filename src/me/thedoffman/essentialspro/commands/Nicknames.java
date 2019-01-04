package me.thedoffman.essentialspro.commands;


import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class Nicknames
implements CommandExecutor,
Listener {
    private static Main plugin = (Main)Main.getPlugin(Main.class);

    public Nicknames(Main plugin) {
        Bukkit.getPluginCommand((String)"nickname").setExecutor((CommandExecutor)this);
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Nicknames.plugin.prefix = Nicknames.plugin.prefix.replaceAll("&", "§");
        if (!(sender instanceof Player)) {
            sender.sendMessage(String.valueOf(Nicknames.plugin.prefix) + (Object)ChatColor.RED + "Only a ingame player can run that command!");
            return true;
        }
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("nickname")) {
            if (!p.hasPermission("ep.nick.use")) {
                p.sendMessage(String.valueOf(Nicknames.plugin.prefix) + (Object)ChatColor.RED + "You do not have permission to use this command!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Nicknames.plugin.prefix) + (Object)ChatColor.RED + "Use: /nick <Nickname>");
                return true;
            }
            if (args[0].equalsIgnoreCase("off")) {
                plugin.getplayers().set(String.valueOf(p.getName()) + ".nickname", null);
                plugin.saveYamls();
                p.sendMessage(String.valueOf(Nicknames.plugin.prefix) + (Object)ChatColor.GREEN + "Nickname turned off!");
                return true;
            }
            for (String key : plugin.getplayers().getKeys(false)) {
                if (!plugin.getplayers().getString(key).equals(args[0])) continue;
                p.sendMessage(String.valueOf(Nicknames.plugin.prefix) + (Object)ChatColor.RED + "Someone else already has this nickname!");
                return true;
            }
            String nick = "";
            String[] arrstring = args;
            int n = arrstring.length;
            int n2 = 0;
            while (n2 < n) {
                String arg = arrstring[n2];
                nick = String.valueOf(nick) + (String)arg + " ";
                ++n2;
            }
            nick = nick.substring(0, nick.length() - 1);
            nick = nick.replaceAll("&", "\u00a7");
            plugin.getplayers().set(String.valueOf(p.getName()) + ".nickname", (Object)nick);
            plugin.saveYamls();
            p.sendMessage(String.valueOf(Nicknames.plugin.prefix) + (Object)ChatColor.GREEN + "Nickname changed!");
        }
        if (cmd.getName().equalsIgnoreCase("realname")) {
            if (!p.hasPermission("nick.realname")) {
                p.sendMessage(String.valueOf(Nicknames.plugin.prefix) + (Object)ChatColor.RED + "You do not have permission to use this command!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Nicknames.plugin.prefix) + (Object)ChatColor.RED + "Use: /nick <Nickname>");
                return true;
            }
            for (Player p2 : Bukkit.getOnlinePlayers()) {
                if (!plugin.getplayers().contains(String.valueOf(p2.getName()) + ".nickname") || !plugin.getplayers().getString(String.valueOf(p2.getName()) + ".nickname").equals(args[0])) continue;
                p.sendMessage(String.valueOf(Nicknames.plugin.prefix) + (Object)ChatColor.GREEN + args[0] + "'s real name " + (Object)ChatColor.DARK_AQUA + p2.getName());
                return true;
            }
            p.sendMessage(String.valueOf(Nicknames.plugin.prefix) + (Object)ChatColor.RED + "Nobody with that nickname found!");
        }
        return true;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (plugin.getplayers().contains(String.valueOf(e.getPlayer().getName()) + ".nickname")) {
            e.setCancelled(true);
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage("<" + plugin.getplayers().getString(new StringBuilder(String.valueOf(e.getPlayer().getName())).append(".nickname").toString()) + (Object)ChatColor.RESET + "> " + e.getMessage());
            }
        }
    }
}

