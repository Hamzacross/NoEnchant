package me.noenchant.utils;

import org.bukkit.enchantments.Enchantment;

public class EnchantUtils {

    public static Enchantment getEnchantment(String name) {
        for (Enchantment enchant : Enchantment.values()) {
            if (enchant.getKey().getKey().equalsIgnoreCase(name)) {
                return enchant;
            }
        }
        return null;
    }
}
