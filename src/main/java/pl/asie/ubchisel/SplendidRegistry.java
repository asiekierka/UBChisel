package pl.asie.ubchisel;

import net.minecraft.block.Block;

import java.util.HashMap;

/**
 * Created by asie on 3/29/15.
 */
public class SplendidRegistry {
    private static final HashMap<Block, String> blockNames = new HashMap<Block, String>();

    private SplendidRegistry() {

    }

    public static String get(Block b) {
        if (!blockNames.containsKey(b)) {
            return "unknown";
        }
        return blockNames.get(b);
    }

    public static void put(Block b, String s) {
        blockNames.put(b, s);
    }
}
