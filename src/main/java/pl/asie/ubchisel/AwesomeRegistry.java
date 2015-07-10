package pl.asie.ubchisel;

import com.cricketcraft.chisel.block.BlockCarvable;
import com.cricketcraft.chisel.item.ItemCarvable;
import net.minecraft.block.Block;

import java.util.HashMap;

public class AwesomeRegistry {
    private static HashMap<String, Block> r = new HashMap<String, Block>();
    private AwesomeRegistry() {

    }

    public static Block get(String s) {
        return r.get(s);
    }

    public static void put(String s, Block b) {
        r.put(s, b);
    }

    public static void register(BlockCarvable b, String s) {
        b.carverHelper.registerAll(b, s, ItemUBCarvable.class);
        r.put(s, b);
    }

    public static void register(BlockCarvable b, String s, Class<? extends ItemCarvable> itemClass) {
        b.carverHelper.registerAll(b, s, itemClass);
        r.put(s, b);
    }
}
