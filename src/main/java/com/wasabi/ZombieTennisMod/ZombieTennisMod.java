package com.wasabi.ZombieTennisMod;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("zombie_tennis_mod")
public class ZombieTennisMod {
    public static final String MODID = "zombie_tennis_mod";

    public ZombieTennisMod() {
        MinecraftForge.EVENT_BUS.register(new spawnReinforcement());
    }


}
