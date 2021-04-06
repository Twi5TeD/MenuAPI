package vortexcraft.net.menuapi;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;
import vortexcraft.net.menuapi.menu.Menu;
import vortexcraft.net.menuapi.menu.PaginatedMenu;

import java.util.HashMap;

public final class MenuAPI extends JavaPlugin {

    public Menu menu;
    public PaginatedMenu paginatedMenu;


    Player p;



    @Override
    public void onEnable() {
        // Plugin startup logic
        menu = new Menu() {
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

        paginatedMenu = new PaginatedMenu() {
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





    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
