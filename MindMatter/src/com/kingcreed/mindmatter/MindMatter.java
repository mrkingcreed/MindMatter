package com.kingcreed.mindmatter;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class MindMatter extends JavaPlugin implements CommandExecutor {

    public String getConfig(String string) {
        return getConfig().getString(string);
    }

    public static String red = ChatColor.RED + "";

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getLogger().info("has been enabled.");
        this.getCommand("mindmatter").setExecutor(new Commands(this));
        getServer().getPluginManager().registerEvents(new EventManager(this),this);
    }

    @Override
    public void onDisable()
    {
        getLogger().info("has been disabled.");
        super.onDisable();
    }
}
