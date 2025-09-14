package me.noenchant.listeners;

import me.noenchant.NoEnchant;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.enchantments.Enchantment;

import java.util.Map;

public class EnchantTableListener implements Listener {

    private final NoEnchant plugin;

    public EnchantTableListener(NoEnchant plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEnchant(EnchantItemEvent event) {
        Map<Enchantment, Integer> enchants = event.getEnchantsToAdd();
        enchants.entrySet().removeIf(entry -> !plugin.getEnchantManager().isEnabled(entry.getKey()));
    }
}
