package com.wasabi.ZombieTennisMod;

import com.ibm.icu.text.MessageFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.storage.loot.conditions.KilledByPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.message.MessageFormatMessage;

import javax.annotation.Nullable;

import java.util.HashMap;

import static jdk.nashorn.internal.objects.Global.print;


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

            BlockPos DiamondSpawnPos = new BlockPos(140.0,4.0,-55.0);
            BlockPos IronSpawnPos = new BlockPos(140.0,4.0,-55.0);
            BlockPos WoodSpawnPos = new BlockPos(140.0,4.0,-55.0);


//            HashMap<String,String> map = new HashMap<String,String>();
            if (itemNameString.contains("Diamond")) {
                String block_name = world.getBlockState(attacked_zombie.getPosition().add(0,-1,0)).toString();

                ITextComponent text = new StringTextComponent(block_name);
                attacker.sendMessage(text);
                for (int i = 0;i < 5 ; i++) {
                    ZombieEntity spawn_zombie = new ZombieEntity(EntityType.ZOMBIE,world);
                    spawn_zombie.setLocationAndAngles(
                            DiamondSpawnPos.getX(),
                            DiamondSpawnPos.getY(),
                            DiamondSpawnPos.getZ(),
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
                for (int i = 0;i < 2 ; i++) {
                    ZombieEntity spawn_zombie = new ZombieEntity(EntityType.ZOMBIE,world);

                    spawn_zombie.setAggroed(false);
                    spawn_zombie.setLocationAndAngles(
                            attacked_zombie.getPosX(),
                            attacked_zombie.getEntity().getPosY(),
                            attacked_zombie.getEntity().getPosZ(),
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
                for (int i = 0;i < 2 ; i++) {
                    ZombieEntity spawn_zombie = new ZombieEntity(EntityType.ZOMBIE,world);

                    spawn_zombie.setAggroed(false);
                    spawn_zombie.setLocationAndAngles(
                            attacked_zombie.getPosX(),
                            attacked_zombie.getEntity().getPosY(),
                            attacked_zombie.getEntity().getPosZ(),
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
