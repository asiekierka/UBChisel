package pl.asie.ubchisel;

import com.cricketcraft.chisel.item.ItemCarvable;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemUBCarvable extends ItemCarvable {
    private final Block base;

    public ItemUBCarvable(Block block) {
        super(block);
        this.base = block;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return base.getLocalizedName().trim();
    }
}
