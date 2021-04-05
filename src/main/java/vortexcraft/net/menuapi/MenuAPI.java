package vortexcraft.net.menuapi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;
import vortexcraft.net.menuapi.listener.MenuListener;
import vortexcraft.net.menuapi.menu.Menu;
import vortexcraft.net.menuapi.menu.PaginatedMenu;
import vortexcraft.net.menuapi.menu.PlayerMenuUtility;

import java.util.HashMap;

public final class MenuAPI extends JavaPlugin {
    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();

    public Menu menu;
    public PaginatedMenu paginatedMenu;
    public PlayerMenuUtility utility;
    Player p;


    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
        menu = new Menu(utility) {
            @Override
            public String getMenuName() {
                return null;
            }

            @Override
            public int getSlots() {
                return 0;
            }

            @Override
            public void handleMenu(InventoryClickEvent e) {

            }

            @Override
            public void setMenuItems() {

            }
        };

        paginatedMenu = new PaginatedMenu(utility) {
            @Override
            public String getMenuName() {
                return null;
            }

            @Override
            public int getSlots() {
                return 0;
            }

            @Override
            public void handleMenu(InventoryClickEvent e) {

            }

            @Override
            public void setMenuItems() {

            }
        };

        utility = new PlayerMenuUtility(p);




    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static PlayerMenuUtility getPlayerMenuUtility(Player p) {
        PlayerMenuUtility playerMenuUtility;
        if (!(playerMenuUtilityMap.containsKey(p))) { //See if the player has a playermenuutility "saved" for them

            //This player doesn't. Make one for them add add it to the hashmap
            playerMenuUtility = new PlayerMenuUtility(p);
            playerMenuUtilityMap.put(p, playerMenuUtility);

            return playerMenuUtility;
        } else {
            return playerMenuUtilityMap.get(p); //Return the object by using the provided player
        }
    }
}
