package me.noenchant.listeners;

import me.noenchant.NoEnchant;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.enchantments.Enchantment;

import java.util.Map;

public class AnvilListener implements Listener {

    private final NoEnchant plugin;

    public AnvilListener(NoEnchant plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAnvilPrepare(PrepareAnvilEvent event) {
        ItemStack result = event.getResult();
        if (result == null) return;

        Map<Enchantment, Integer> enchants = result.getEnchantments();
        for (Enchantment enchant : enchants.keySet()) {
            if (!plugin.getEnchantManager().isEnabled(enchant)) {
                result.removeEnchantment(enchant);
            }
        }

        event.setResult(result);
    }
}
