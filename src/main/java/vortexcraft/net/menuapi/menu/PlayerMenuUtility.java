package vortexcraft.net.menuapi.menu;
/*
  Copyright © JustReddy 2021 | All Rights Reserved
  File | PlayerMenuUtility
*/

import org.bukkit.entity.Player;

public class PlayerMenuUtility {
    private final Player owner;

    public PlayerMenuUtility(Player p) {
        this.owner = p;
    }



    public Player getOwner() {
        return owner;
    }



    public void close(Player p){
        p.closeInventory();
    }
}
