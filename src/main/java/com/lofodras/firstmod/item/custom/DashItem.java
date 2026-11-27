package com.lofodras.firstmod.item.custom;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class DashItem extends Item {
    public DashItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (user.isOnGround()) {
            user.addVelocity(0, 5.0, 0);
            user.velocityModified = true;
            user.playSound(SoundEvents.ENTITY_WIND_CHARGE_THROW, 1.0F, 1.0F);
        }
        else {
            Vec3d look = user.getRotationVector();
            user.setVelocity(look.x * 2.0, look.y * 0.5 + 0.3, look.z * 2.0);
            user.velocityModified = true;
            if (!world.isClient) {
                world.playSound(
                        null,
                        user.getX(),
                        user.getY(),
                        user.getZ(),
                        SoundEvents.ENTITY_BREEZE_JUMP,
                        SoundCategory.PLAYERS,
                        1.0F,
                        1.0F
                );
            }
            user.getItemCooldownManager().set(this, 20);
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (selected && entity instanceof PlayerEntity player) {
            player.onLanding();
        }
    }
}
