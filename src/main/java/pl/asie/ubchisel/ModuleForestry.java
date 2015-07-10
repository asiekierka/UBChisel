package pl.asie.ubchisel;

import com.cricketcraft.chisel.block.BlockCarvable;
import com.cricketcraft.chisel.carving.Carving;
import com.cricketcraft.chisel.init.ChiselBlocks;
import com.cricketcraft.chisel.init.ChiselTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.StatCollector;

/**
 * Created by asie on 3/28/15.
 */
public class ModuleForestry extends Module {
    private String[] PLANK_TYPES = {
            "larch", "teak", "acacia", "lime", "chestnut", "wenge", "baobab", "sequoia",
            "kapok", "ebony", "mahogany", "balsa", "willow", "walnut", "greenheart", "cherry",
            "mahoe", "poplar", "palm", "papaya", "pine", "plum", "maple", "citrus", "giganteum", "ipe", "padauk", "cocobolo", "zebrawood"
    };

    private void configPlank(BlockCarvable plank, String n, String woodName, String registerName) {
        String l = n.toLowerCase();
        plank.carverHelper.setChiselBlockName(n + " Wood Planks");
        plank.carverHelper.addVariation("Smooth " + l + " wood planks", 1, "forestry/" + woodName + "/planks/clean", "ubchisel");
        plank.carverHelper.addVariation("Short " + l + " wood planks", 2, "forestry/" + woodName + "/planks/short", "ubchisel");
        plank.carverHelper.addVariation("Fancy " + l + " wood plank arrangement", 6, "forestry/" + woodName + "/planks/fancy", "ubchisel");
        plank.carverHelper.addVariation(n + " wood panel", 8, "forestry/" + woodName + "/planks/panel-nails", "ubchisel");
        plank.carverHelper.addVariation(n + " wood double slab", 9, "forestry/" + woodName + "/planks/double", "ubchisel");
        plank.carverHelper.addVariation(n + " wood crate", 10, "forestry/" + woodName + "/planks/crate", "ubchisel");
        plank.carverHelper.addVariation("Fancy " + l + " wood crate", 11, "forestry/" + woodName + "/planks/crate-fancy", "ubchisel");
        plank.carverHelper.addVariation("Large long " + l + " wood planks", 13, "forestry/" + woodName + "/planks/large", "ubchisel");
        plank.carverHelper.addVariation("Vertical " + l + " wood planks", 3, "forestry/" + woodName + "/planks/vertical", "ubchisel");
        plank.carverHelper.addVariation("Vertical uneven " + l + " wood planks", 4, "forestry/" + woodName + "/planks/vertical-uneven", "ubchisel");
        plank.carverHelper.addVariation(n + " wood parquet", 5, "forestry/" + woodName + "/planks/parquet", "ubchisel");
        plank.carverHelper.addVariation(n + " wood plank blinds", 7, "forestry/" + woodName + "/planks/blinds", "ubchisel");
        plank.carverHelper.addVariation(n + " wood scaffold", 12, "forestry/" + woodName + "/planks/crateex", "ubchisel");
        plank.carverHelper.addVariation(n + " wood planks in disarray", 14, "forestry/" + woodName + "/planks/chaotic-hor", "ubchisel");
        plank.carverHelper.addVariation("Vertical " + l + " wood planks in disarray", 15, "forestry/" + woodName + "/planks/chaotic", "ubchisel");
        AwesomeRegistry.register(plank, registerName + "_planks");
        SplendidRegistry.put(plank, "for.trees.woodType." + woodName);
        plank.setHarvestLevel("axe", 0);
        Carving.chisel.registerOre(registerName + "_planks", "wood");
        Carving.chisel.setVariationSound(registerName + "_planks", "chisel:chisel.wood");
    }

    private void addPlank(String woodName) {
        String n = woodName.substring(0, 1).toUpperCase() + woodName.substring(1);
        BlockCarvable plank = (BlockCarvable)(new BlockUBCarvable(Material.wood) {
            @Override
            public String getLocalizedName() {
                return StatCollector.translateToLocal("for.planks.grammar").replaceAll("%TYPE", super.getLocalizedName());
            }
        }).setCreativeTab(ChiselTabs.tabWoodChiselBlocks).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood);
        configPlank(plank, n, woodName, woodName);

        plank = (BlockCarvable)(new BlockUBCarvableFireproof(Material.wood) {
            @Override
            public String getLocalizedName() {
                String tmp = StatCollector.translateToLocal("for.planks.grammar").replaceAll("%TYPE", super.getLocalizedName());
                return StatCollector.translateToLocalFormatted("tile.for.fireproof", tmp);
            }
        }).setCreativeTab(ChiselTabs.tabWoodChiselBlocks).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood);
        configPlank(plank, n, woodName, woodName + "_fireproof");

    }

    @Override
    public String modid() {
        return "Forestry";
    }

    @Override
    public void preInit() {
        for (int i = 0; i < PLANK_TYPES.length; i++) {
            addPlank(PLANK_TYPES[i]);
        }
    }

    @Override
    public void postInit() {
        for (int i = 0; i < PLANK_TYPES.length; i++) {
            int m = i >> 4;
            String blockName = "Forestry:planks" + (m > 0 ? ("" + (m + 1)) : "");
            String woodName = PLANK_TYPES[i];
            Block base = Block.getBlockFromName(blockName);
            Carving.chisel.addVariation(woodName + "_planks", base, i & 15, 0);
            Block fireproofBase = Block.getBlockFromName("Forestry:fireproofPlanks" + (m + 1));
            Carving.chisel.addVariation(woodName + "_fireproof_planks", fireproofBase, i & 15, 0);
        }
    }
}
