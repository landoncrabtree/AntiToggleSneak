package pw.landon.antitogglesneak;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class InventoryEvent implements Listener {
    private AntiToggleSneak main;
    public InventoryEvent(AntiToggleSneak main) {this.main = main;}

    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent event) {
        Player player = Bukkit.getPlayer(event.getPlayer().getName());
        if (player.isSneaking()) {
            String mode = main.getConfig().getString("mode");
            String verbalMessage = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("verbal"));
            String kickCommand = main.getConfig().getString("kick").replace("%player%", player.getName());
            String banCommand = main.getConfig().getString("ban").replace("%player%", player.getName());
            if (mode.equalsIgnoreCase("silent")) {
                event.setCancelled(true);
            } else if (mode.equalsIgnoreCase("verbal")) {
                event.setCancelled(true);
                player.sendMessage(verbalMessage);
            } else if (mode.equalsIgnoreCase("kick")) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), kickCommand);
            } else if (mode.equalsIgnoreCase("ban")) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), banCommand);
            } else {
                return;
            }
        }
    }
}
