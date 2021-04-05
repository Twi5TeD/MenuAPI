# MenuAPI
Hey there! This is my MenuAPI API! I created this api because creating menu's that support 1.8.8 - 1.16.5 was a bit difficult for me.
I won't go into much detail but, here are some examples on how u can use it: ( It doesn't work with gradle, only maven ) 

First, install it in your pom.xml:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.github.JustReddy7397</groupId>
        <artifactId>MenuAPI</artifactId>
        <version>28d0476628</version>
    </dependency>
</dependencies>
```

So, here are some basic examples:

In your main class you wanna do:

```java
package vortexcraft.net;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import vortexcraft.net.menuapi.listener.MenuListener;

public final class Tutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this); // U want to register this Listener

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
```

To create a menu **whitout** pages you wanna do:
```java
import vortexcraft.net;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import vortexcraft.net.menuapi.menu.Menu;
import vortexcraft.net.menuapi.menu.PlayerMenuUtility;
public class TutorialMenu extends Menu {
    public TutorialMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Title Here";
    }

    @Override
    public int getSlots() {
        return 9; // Can be 9, 18, 27, 36, 45, 54
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        // Here u handle the click events, this is why its important to register the MenuListener in the main class
        if(e.getCurrentItem().getType().equals(Material.GLASS)){
            e.getWhoClicked().sendMessage("Hey there, this works!");
        }
    }

    @Override
    public void setMenuItems() {
        setFillerGlass(); // Will set all empty slots with black stained glass! NOTE: It works on 1.8.8 - 1.16.5 and its not require to put it in here
        ItemStack tutorial = new ItemStack(Material.GLASS); // If you know how to use XMaterial, you can also use that
        inventory.setItem(0, tutorial); // the inventory is very important, this will allow u to set an item in the gui
    }
}
```

Creating with pages coming soon!  ( very soon )

To open a menu **outside** a class that extends menu you wanna do:
```java
package vortexcraft.net;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import vortexcraft.net.menuapi.MenuAPI;

public class TutorialCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            
            new TutorialMenu(MenuAPI.getPlayerMenuUtility(p)).open();
            
        }
        return true;
    }
}
```

To open a menu **inside** a menu you wanna do:
```java
import vortexcraft.net

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import vortexcraft.net.menuapi.menu.Menu;
import vortexcraft.net.menuapi.menu.PlayerMenuUtility;

public class TutorialMenu extends Menu {
    public TutorialMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Title Here";
    }

    @Override
    public int getSlots() {
        return 9; // Can be 9, 18, 27, 36, 45, 54
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        // Here u handle the click events, this is why its important to register the MenuListener in the main class
        if(e.getCurrentItem().getType().equals(Material.GLASS)){
            e.getWhoClicked().sendMessage("Hey there, this works!");
            new AnotherMenu(playerMenuUtility).open(); // Replace AnotherMenu with any other menu name :)
        }
    }

    @Override
    public void setMenuItems() {
        setFillerGlass(); // Will set all empty slots with black stained glass! NOTE: It works on 1.8.8 - 1.16.5 and its not require to put it in here
        ItemStack tutorial = new ItemStack(Material.GLASS); // If you know how to use XMaterial, you can also use that
        inventory.setItem(0, tutorial); // the inventory is very important, this will allow u to set an item in the gui
    }
}
```

Outcomes:
**Without** pages:
![nopage](https://user-images.githubusercontent.com/70798725/113622851-cd92b180-965d-11eb-9d74-39f6f35c1330.png)

