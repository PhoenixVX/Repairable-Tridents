
package io.github.PhoenixVX.TridentFixer.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
abstract class FixerMixin {
    @Inject(method="canRepair", at=@At("HEAD"), cancellable=true)
    public void repair(ItemStack tridentItem, ItemStack repairItem, CallbackInfoReturnable<Boolean> info) {
        if (tridentItem.getItem() == Items.TRIDENT && repairItem.getItem() == Items.PRISMARINE_SHARD || repairItem.getItem() == Items.PRISMARINE_CRYSTALS) {
            info.setReturnValue(true);
        }
    }
}
