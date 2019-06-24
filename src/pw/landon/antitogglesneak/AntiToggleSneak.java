package pw.landon.antitogglesneak;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiToggleSneak extends JavaPlugin {
    private static AntiToggleSneak instance;

    @Override
    public void onEnable() {
        instance = this;
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new InventoryEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new ChatEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new InteractEvent(this), this);
    }

    public static AntiToggleSneak getInstance() {return instance;}
}
