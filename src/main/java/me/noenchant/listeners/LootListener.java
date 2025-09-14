package me.noenchant.listeners;

import me.noenchant.NoEnchant;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.enchantments.Enchantment;

import java.util.Map;

public class LootListener implements Listener {

    private final NoEnchant plugin;

    public LootListener(NoEnchant plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLootGenerate(LootGenerateEvent event) {
        for (ItemStack item : event.getLoot()) {
            if (item == null) continue;

            Map<Enchantment, Integer> enchants = item.getEnchantments();
            for (Enchantment enchant : enchants.keySet()) {
                if (!plugin.getEnchantManager().isEnabled(enchant)) {
                    item.removeEnchantment(enchant);
                }
            }
        }
    }
}
