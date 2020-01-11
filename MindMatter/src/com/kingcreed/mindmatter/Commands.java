package com.kingcreed.mindmatter;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    String red = ChatColor.RED + "";
    String gray = ChatColor.GRAY + "";
    String mm = gray + "[" + red + "MindMatter" + gray + "]";


    MindMatter plugin;
    public Commands(MindMatter mindmatter) { this.plugin = mindmatter; }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if (sender instanceof Player) {
           Player p = (Player) sender;
           if (p.hasPermission("mindmatter.help")) {
               if (args.length > 0) {
                   p.sendMessage(plugin.getConfig().getString("error"));
               } else {
                   p.sendMessage(mm); p.sendMessage("/mindmatter " + gray + "main menu");
               }
            } else { p.sendMessage(plugin.getConfig().getString("noPermission")); }
        } else { sender.sendMessage(plugin.getConfig().getString("error")); }
        return true;
    }
}
