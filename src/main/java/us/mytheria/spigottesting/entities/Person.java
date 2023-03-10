package us.mytheria.spigottesting.entities;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class Person implements ConfigurationSerializable {
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Worldwidely hated MD5");
        map.put("age", 100);
        
        return map;
    }
 
    public static Person deserialize(Map<String, Object> map) {
        System.out.println("deserialized the most hated person on Spigot.");
        
        return new Person();
    }
}