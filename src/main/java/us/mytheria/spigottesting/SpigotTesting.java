package us.mytheria.spigottesting;

import com.google.common.base.Charsets;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;
import us.mytheria.spigottesting.entities.Person;

import javax.annotation.Nullable;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class SpigotTesting extends JavaPlugin {
    private FileConfiguration newConfig;

    @Override
    public void onEnable() {
        ConfigurationSerialization.registerClass(Person.class);

        FileConfiguration fileConfiguration = getConfig();
        if (fileConfiguration != null){
            print("&c" + fileConfiguration.getString("Message"));
        }
    }

    private static void print(String message) {
        Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', message));
    }

    @Override
    public FileConfiguration getConfig(){
        if (newConfig == null) {
            customReloadConfig();
        }
        return newConfig;
    }

    private void customReloadConfig(){
        newConfig = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "config.yml"));
        print("&3YamlConfiguration#loadConfiguration");
        final InputStream defConfigStream = getResource("config.yml");
        if (defConfigStream == null) {
            return;
        }
        newConfig.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
        print("&3setDefaults");
    }
}
