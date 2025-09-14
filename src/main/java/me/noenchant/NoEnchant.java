package me.noenchant;

import me.noenchant.commands.NoEnchantCommand;
import me.noenchant.commands.NoEnchantTabCompleter;
import me.noenchant.listeners.*;
import me.noenchant.managers.EnchantManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NoEnchant extends JavaPlugin {

    private EnchantManager enchantManager;

    @Override
    public void onEnable() {
        // Save default config
        saveDefaultConfig();

        // Initialize EnchantManager
        enchantManager = new EnchantManager(this);
        enchantManager.loadEnchants();

        // Register command
        getCommand("noenchant").setExecutor(new NoEnchantCommand(this));
        getCommand("noenchant").setTabCompleter(new NoEnchantTabCompleter(this));

        // Register listeners
        getServer().getPluginManager().registerEvents(new AnvilListener(this), this);
        getServer().getPluginManager().registerEvents(new EnchantTableListener(this), this);
        getServer().getPluginManager().registerEvents(new LootListener(this), this);
        getServer().getPluginManager().registerEvents(new PickupListener(this), this);
        getServer().getPluginManager().registerEvents(new CommandBlockerListener(this), this);

        getLogger().info("NoEnchant enabled!");
    }

    @Override
    public void onDisable() {
        enchantManager.saveEnchants();
        getLogger().info("NoEnchant disabled!");
    }

    public EnchantManager getEnchantManager() {
        return enchantManager;
    }
}
