package com.github.lunatrius.ingameinfo.core.entity;

import com.github.lunatrius.ingameinfo.core.util.vector.Vector3f;
import com.github.lunatrius.ingameinfo.core.util.vector.Vector3i;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EntityHelper {
    public final static int WILDMARK = -1;

    public static int getItemCountInInventory(final Inventory inventory, final Item item) {
        return getItemCountInInventory(inventory, item, WILDMARK);
    }

    public static int getItemCountInInventory(final Inventory inventory, final Item item, final int itemDamage) {
        final int inventorySize = inventory.getInvSize();
        int count = 0;

        for (int slot = 0; slot < inventorySize; slot++) {
            final ItemStack itemStack = inventory.getInvStack(slot);

            if (itemStack.getItem() == item && (itemDamage == WILDMARK || itemDamage == itemStack.getDamage())) {
                count += itemStack.getCount();
            }
        }

        return count;
    }

    public static Vector3f getVector3fFromEntity(final Entity entity) {
        return new Vector3f((float) entity.getPos().x, (float) entity.getPos().y, (float) entity.getPos().z);
    }

    public static Vector3f getVector3fFromEntity(final Entity entity, final Vector3f vec) {
        return vec.set((float) entity.getPos().x, (float) entity.getPos().y, (float) entity.getPos().z);
    }

    public static Vector3i getVector3iFromEntity(final Entity entity) {
        return new Vector3i((int) Math.floor(entity.getPos().x), (int) Math.floor(entity.getPos().y), (int) Math.floor(entity.getPos().z));
    }

    public static Vector3i getVector3iFromEntity(final Entity entity, final Vector3i vec) {
        return vec.set((int) Math.floor(entity.getPos().x), (int) Math.floor(entity.getPos().y), (int) Math.floor(entity.getPos().z));
    }
}
