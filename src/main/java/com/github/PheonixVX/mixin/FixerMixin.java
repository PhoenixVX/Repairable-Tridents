
package com.github.PheonixVX.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
abstract class TridentMixin {
    @Inject(method="canRepair", at=@At("HEAD"), cancellable=true)
    public void repair(ItemStack itemStack_1, ItemStack itemStack_2, CallbackInfoReturnable<Boolean> info) {
        if (itemStack_1.getItem() == Items.TRIDENT && itemStack_2.getItem() == Items.PRISMARINE_SHARD) {
            info.setReturnValue(true);
        }
    }
}
