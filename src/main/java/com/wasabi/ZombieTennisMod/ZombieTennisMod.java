package com.wasabi.ZombieTennisMod;


import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("zombie_tennis_mod")
public class ZombieTennisMod {
    public static final String MODID = "zombie_tennis_mod";
    public static final BlockPos DiamondSpawnPos = new BlockPos(92.0,7.0,-66.0);
    public static final BlockPos IronSpawnPos = new BlockPos(97.0,7.0,-50.0);
    public static final BlockPos WoodSpawnPos = new BlockPos(103.0,7.0,-58.0);


    public ZombieTennisMod() {
        MinecraftForge.EVENT_BUS.register(new spawnReinforcement());
    }


}
