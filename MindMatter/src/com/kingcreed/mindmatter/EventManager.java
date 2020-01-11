package com.kingcreed.mindmatter;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EventManager implements Listener {

    MindMatter plugin;
    public EventManager(MindMatter mindmatter) { this.plugin = mindmatter; }


    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("mindmatter.use")) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() != Action.RIGHT_CLICK_BLOCK) {
                if (p.getInventory().getItemInMainHand().getType() == Material.TORCH) {
                    p.addPotionEffect((new PotionEffect(PotionEffectType.FAST_DIGGING, 12000, 10)));
                    p.addPotionEffect((new PotionEffect(PotionEffectType.GLOWING, 12000, 10)));
                    p.addPotionEffect((new PotionEffect(PotionEffectType.CONFUSION, 1200, 10)));
                }
            }
        } else {
            p.sendMessage(MindMatter.);
        }
    }
}
