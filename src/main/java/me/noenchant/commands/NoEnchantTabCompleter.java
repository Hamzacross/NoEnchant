package me.noenchant.commands;

import me.noenchant.NoEnchant;
import me.noenchant.utils.EnchantUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;

import java.util.ArrayList;
import java.util.List;

public class NoEnchantTabCompleter implements TabCompleter {

    private final NoEnchant plugin;

    public NoEnchantTabCompleter(NoEnchant plugin) {
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            // Suggest enchantments
            for (Enchantment enchant : Enchantment.values()) {
                if (enchant != null && enchant.getKey() != null) {
                    if (enchant.getKey().getKey().toLowerCase().startsWith(args[0].toLowerCase())) {
                        completions.add(enchant.getKey().getKey().toLowerCase());
                    }
                }
            }
        } else if (args.length == 2) {
            // Suggest on/off
            if ("on".startsWith(args[1].toLowerCase())) completions.add("on");
            if ("off".startsWith(args[1].toLowerCase())) completions.add("off");
        }

        return completions;
    }
}
