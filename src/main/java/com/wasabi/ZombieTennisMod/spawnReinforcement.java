package com.wasabi.ZombieTennisMod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class spawnReinforcement {
    @SubscribeEvent
    public void spawnReinforcement(LivingDeathEvent event) {
        if ((event.getEntity() instanceof ZombieEntity) && event.getSource().getTrueSource() instanceof PlayerEntity) {


            PlayerEntity attacker = (PlayerEntity) event.getSource().getTrueSource();
            ZombieEntity attacked_zombie = (ZombieEntity) event.getEntity();
            World world = attacker.getEntityWorld();
            ItemStack heldItem = attacker.getHeldItem(Hand.MAIN_HAND);
            String itemNameString =  heldItem.getItem().getName().getString();
            ITextComponent itemName = heldItem.getItem().getName();


//            BlockPos DiamondSpawnPos = new BlockPos(92.0,7.0,-66.0);
//            BlockPos IronSpawnPos = new BlockPos(97.0,7.0,-50.0);
//            BlockPos WoodSpawnPos = new BlockPos(103.0,7.0,-58.0);


//            HashMap<String,String> map = new HashMap<String,String>();
            if (itemNameString.contains("Diamond")) {
                String block_name = world.getBlockState(attacked_zombie.getPosition().add(0,-1,0)).toString();

                ITextComponent text = new StringTextComponent(block_name);
                attacker.sendMessage(text);
                for (int i = 0;i < 1 ; i++) {
                    ZombieEntity spawn_zombie = new ZombieEntity(EntityType.ZOMBIE,world);
                    spawn_zombie.setLocationAndAngles(
                            ZombieTennisMod.DiamondSpawnPos.getX(),
                            ZombieTennisMod.DiamondSpawnPos.getY(),
                            ZombieTennisMod.DiamondSpawnPos.getZ(),
                            0,
                            0
                    );
                    if (!event.getEntity().getEntityWorld().isRemote) {
                        event.getEntity().getEntityWorld().addEntity(spawn_zombie);
                    }
                }
            }
            else if (itemNameString.contains("Iron")) {
                attacker.sendMessage(itemName);
                for (int i = 0;i < 1 ; i++) {
                    ZombieEntity spawn_zombie = new ZombieEntity(EntityType.ZOMBIE,world);

                    spawn_zombie.setAggroed(false);
                    spawn_zombie.setLocationAndAngles(
                            ZombieTennisMod.IronSpawnPos.getX(),
                            ZombieTennisMod.IronSpawnPos.getY(),
                            ZombieTennisMod.IronSpawnPos.getZ(),
                            0,
                            0
                    );

                    if (!event.getEntity().getEntityWorld().isRemote) {
                        event.getEntity().getEntityWorld().addEntity(spawn_zombie);
                    }
                }
            }
            else if (itemNameString.contains("Wooden")) {
                attacker.sendMessage(itemName);
                for (int i = 0;i < 1 ; i++) {
                    ZombieEntity spawn_zombie = new ZombieEntity(EntityType.ZOMBIE,world);

                    spawn_zombie.setAggroed(false);
                    spawn_zombie.setLocationAndAngles(
                            ZombieTennisMod.WoodSpawnPos.getX(),
                            ZombieTennisMod.WoodSpawnPos.getY(),
                            ZombieTennisMod.WoodSpawnPos.getZ(),
                            0,
                            0
                    );

                    if (!event.getEntity().getEntityWorld().isRemote) {
                        event.getEntity().getEntityWorld().addEntity(spawn_zombie);
                    }
                }
            }
        }
    }
}
