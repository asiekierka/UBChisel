package pl.asie.ubchisel;

import com.cricketcraft.chisel.block.BlockCarvable;
import com.cricketcraft.chisel.carving.Carving;
import com.cricketcraft.chisel.init.ChiselTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import exterminatorJeff.undergroundBiomes.api.UBIDs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class ModuleUBC extends Module {

    public static final String[] UBC_STONES_FULL = {
            "andesite", "basalt", "blackGranite", "blueschist", "dacite",
            "eclogite", "gabbro", "gneiss", "greenschist", "komatiite",
            "marble", "migmatite", "quartzite", "redGranite", "rhyolite",
            "soapstone"
    };

    public static final String[] UBC_STONES_FULL_BLOCKNAMES = {
            "i3", "i5", "i1", "m4", "i7", "m1", "i4", "m0",
            "m5", "i6", "m2", "m7", "m3", "i0", "i2",
            "m6"
    };

    public static final String[] UBC_STONES_BASIC = {
            "chalk", "chert", "dolomite", "greywacke", "lignite", "limestone", "shale", "siltstone"
    };

    public static final String[] UBC_STONES_BASIC_BLOCKNAMES = {
            "s1", "s7", "s5", "s6", "s4", "s0", "s2", "s3"
    };

    private String getPrefix(String tb) {
        char bp = tb.charAt(0);
        return bp == 'i' ? "igneous" : (bp == 's' ? "sedimentary" : "metamorphic");
    }

    private String getName(String tb) {
        return tb.equals("lignite") ? "ligniteBlock" : tb;
    }

    private void addStoneBrick(String s, String tb) {
        BlockCarvable stonebricksmooth = (BlockCarvable)(new BlockUBCarvable(Material.rock)).setCreativeTab(ChiselTabs.tabStoneChiselBlocks).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone);
        stonebricksmooth.carverHelper.addVariation("tile.stonebricksmooth.4.desc", 4, "ubc/" + s + "/stonebrick/smallbricks", "ubchisel");
        stonebricksmooth.carverHelper.addVariation("tile.stonebricksmooth.5.desc", 5, "ubc/" + s + "/stonebrick/largebricks", "ubchisel");
        stonebricksmooth.carverHelper.addVariation("tile.stonebricksmooth.6.desc", 6, "ubc/" + s + "/stonebrick/smallchaotic", "ubchisel");
        stonebricksmooth.carverHelper.addVariation("tile.stonebricksmooth.7.desc", 7, "ubc/" + s + "/stonebrick/chaoticbricks", "ubchisel");
        stonebricksmooth.carverHelper.addVariation("tile.stonebricksmooth.8.desc", 8, "ubc/" + s + "/stonebrick/chaotic", "ubchisel");
        stonebricksmooth.carverHelper.addVariation("tile.stonebricksmooth.9.desc", 9, "ubc/" + s + "/stonebrick/fancy", "ubchisel");
        stonebricksmooth.carverHelper.addVariation("tile.stonebricksmooth.10.desc", 10, "ubc/" + s + "/stonebrick/ornate", "ubchisel");
        stonebricksmooth.carverHelper.addVariation("tile.stonebricksmooth.11.desc", 11, "ubc/" + s + "/stonebrick/largeornate", "ubchisel");
        stonebricksmooth.carverHelper.addVariation("tile.stonebricksmooth.12.desc", 12, "ubc/" + s + "/stonebrick/panel-hard", "ubchisel");
        stonebricksmooth.carverHelper.addVariation("tile.stonebricksmooth.13.desc", 13, "ubc/" + s + "/stonebrick/sunken", "ubchisel");
        stonebricksmooth.carverHelper.addVariation("tile.stonebricksmooth.14.desc", 14, "ubc/" + s + "/stonebrick/ornatepanel", "ubchisel");
        stonebricksmooth.carverHelper.addVariation("tile.stonebricksmooth.15.desc", 15, "ubc/" + s + "/stonebrick/poison", "ubchisel");
        AwesomeRegistry.register(stonebricksmooth, s + "_stonebrick");
        SplendidRegistry.put(stonebricksmooth, "tile." + getPrefix(tb) + "StoneBrick." + getName(s) + ".name");
    }

    private void addStoneBrickInit(String s, String tb) {
        char bp = tb.charAt(0);
        Block other = bp == 'i' ? UBIDs.igneousStoneBrickName.block() : UBIDs.metamorphicStoneBrickName.block();
        int meta = Integer.parseInt(tb.substring(1));
        Carving.chisel.addVariation(s + "_stonebrick", other, meta, 0);
    }

    private void addStone(String s, String tb) {
        BlockCarvable marble = (BlockCarvable)(new BlockUBCarvable(Material.rock)).setCreativeTab(ChiselTabs.tabStoneChiselBlocks).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone);
        marble.carverHelper.addVariation("tile.marble.1.desc", 1, "ubc/" + s + "/stone/a1-stoneornamental-marblebrick", "ubchisel");
        marble.carverHelper.addVariation("tile.marble.2.desc", 2, "ubc/" + s + "/stone/a1-stoneornamental-marbleclassicpanel", "ubchisel");
        marble.carverHelper.addVariation("tile.marble.4.desc", 4, "ubc/" + s + "/stone/panel", "ubchisel");
        marble.carverHelper.addVariation("tile.marble.5.desc", 5, "ubc/" + s + "/stone/block", "ubchisel");
        marble.carverHelper.addVariation("tile.marble.8.desc", 8, "ubc/" + s + "/stone/a1-stoneornamental-marblecarved", "ubchisel");
        marble.carverHelper.addVariation("tile.marble.9.desc", 9, "ubc/" + s + "/stone/a1-stoneornamental-marblecarvedradial", "ubchisel");
        marble.carverHelper.addVariation("tile.marble.10.desc", 10, "ubc/" + s + "/stone/terrain-pistonback-marbledent", "ubchisel");
        marble.carverHelper.addVariation("tile.marble.11.desc", 11, "ubc/" + s + "/stone/terrain-pistonback-marbledent-small", "ubchisel");
        marble.carverHelper.addVariation("tile.marble.12.desc", 12, "ubc/" + s + "/stone/marble-bricks", "ubchisel");
        marble.carverHelper.addVariation("tile.marble.13.desc", 13, "ubc/" + s + "/stone/marble-arranged-bricks", "ubchisel");
        marble.carverHelper.addVariation("tile.marble.14.desc", 14, "ubc/" + s + "/stone/marble-fancy-bricks", "ubchisel");
        marble.carverHelper.addVariation("tile.marble.15.desc", 15, "ubc/" + s + "/stone/marble-blocks", "ubchisel");
        AwesomeRegistry.register(marble, s + "_stone");
        SplendidRegistry.put(marble, "tile." + getPrefix(tb) + "Stone." + getName(s) + ".name");
    }

    private void addStoneInit(String s, String tb) {
        char bp = tb.charAt(0);
        Block other = bp == 'i' ? UBIDs.igneousStoneName.block() : (bp == 's' ? UBIDs.sedimentaryStoneName.block() : UBIDs.metamorphicStoneName.block());
        int meta = Integer.parseInt(tb.substring(1));
        Carving.chisel.addVariation(s + "_stone", other, meta, 0);
    }

    private void addPillarInit(String s, String tb) {
        char bp = tb.charAt(0);
        Block other = bp == 'i' ? UBIDs.igneousStoneName.block() : (bp == 's' ? UBIDs.sedimentaryStoneName.block() : UBIDs.metamorphicStoneName.block());
        int meta = Integer.parseInt(tb.substring(1));
        GameRegistry.addShapedRecipe(new ItemStack(AwesomeRegistry.get(s + "_pillar"), 6, 0), "aa", "aa", "aa", 'a', new ItemStack(other, 1, meta));
    }

    private void addPillar(String s, String tb) {
        BlockCarvable marble_pillar = (BlockCarvable)(new BlockUBCarvablePillar(Material.rock)).setCreativeTab(ChiselTabs.tabStoneChiselBlocks).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone);
        marble_pillar.carverHelper.addVariation("tile.marblePillar.0.desc", 0, "ubc/" + s + "/pillar/pillar", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.1.desc", 1, "ubc/" + s + "/pillar/default", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.2.desc", 2, "ubc/" + s + "/pillar/simple", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.3.desc", 3, "ubc/" + s + "/pillar/convex", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.4.desc", 4, "ubc/" + s + "/pillar/rough", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.5.desc", 5, "ubc/" + s + "/pillar/greekdecor", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.6.desc", 6, "ubc/" + s + "/pillar/greekgreek", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.7.desc", 7, "ubc/" + s + "/pillar/greekplain", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.8.desc", 8, "ubc/" + s + "/pillar/plaindecor", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.9.desc", 9, "ubc/" + s + "/pillar/plaingreek", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.10.desc", 10, "ubc/" + s + "/pillar/plainplain", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.11.desc", 11, "ubc/" + s + "/pillar/widedecor", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.12.desc", 12, "ubc/" + s + "/pillar/widegreek", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.13.desc", 13, "ubc/" + s + "/pillar/wideplain", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.14.desc", 14, "ubc/" + s + "/pillar/carved", "ubchisel");
        marble_pillar.carverHelper.addVariation("tile.marblePillar.15.desc", 15, "ubc/" + s + "/pillar/ornamental", "ubchisel");
        AwesomeRegistry.register(marble_pillar, s + "_pillar");
        SplendidRegistry.put(marble_pillar, "tile." + getPrefix(tb) + "Stone." + getName(s) + ".name");
    }

    private void addCobblestone(String s, String tb) {
        BlockCarvable cobblestone = (BlockCarvable) (new BlockUBCarvable(Material.rock)).setCreativeTab(ChiselTabs.tabStoneChiselBlocks).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone);
        cobblestone.carverHelper.addVariation("tile.cobblestone.0.desc", 1, "ubc/" + s + "/cobblestone/terrain-cobb-brickaligned", "ubchisel");
        cobblestone.carverHelper.addVariation("tile.cobblestone.1.desc", 2, "ubc/" + s + "/cobblestone/terrain-cob-detailedbrick", "ubchisel");
        cobblestone.carverHelper.addVariation("tile.cobblestone.2.desc", 3, "ubc/" + s + "/cobblestone/terrain-cob-smallbrick", "ubchisel");
        cobblestone.carverHelper.addVariation("tile.cobblestone.3.desc", 4, "ubc/" + s + "/cobblestone/terrain-cobblargetiledark", "ubchisel");
        cobblestone.carverHelper.addVariation("tile.cobblestone.4.desc", 5, "ubc/" + s + "/cobblestone/terrain-cobbsmalltile", "ubchisel");
        cobblestone.carverHelper.addVariation("tile.cobblestone.5.desc", 6, "ubc/" + s + "/cobblestone/terrain-cob-french", "ubchisel");
        cobblestone.carverHelper.addVariation("tile.cobblestone.6.desc", 7, "ubc/" + s + "/cobblestone/terrain-cob-french2", "ubchisel");
        cobblestone.carverHelper.addVariation("tile.cobblestone.8.desc", 9, "ubc/" + s + "/cobblestone/terrain-mossysmalltiledark", "ubchisel");
        cobblestone.carverHelper.addVariation("tile.cobblestone.9.desc", 10, "ubc/" + s + "/cobblestone/terrain-pistonback-dungeontile", "ubchisel");
        cobblestone.carverHelper.addVariation("tile.cobblestone.11.desc", 12, "ubc/" + s + "/cobblestone/terrain-pistonback-darkdent", "ubchisel");
        cobblestone.carverHelper.addVariation("tile.cobblestone.12.desc", 13, "ubc/" + s + "/cobblestone/terrain-pistonback-darkemboss", "ubchisel");
        cobblestone.carverHelper.addVariation("tile.cobblestone.14.desc", 15, "ubc/" + s + "/cobblestone/terrain-pistonback-darkpanel", "ubchisel");
        AwesomeRegistry.register(cobblestone, s + "_cobblestone");
        SplendidRegistry.put(cobblestone, "tile." + getPrefix(tb) + "Cobblestone." + getName(s) + ".name");
    }

    private void addCobblestoneInit(String s, String tb) {
        char bp = tb.charAt(0);
        Block other = bp == 'i' ? UBIDs.igneousCobblestoneName.block() : UBIDs.metamorphicCobblestoneName.block();
        int meta = Integer.parseInt(tb.substring(1));
        Carving.chisel.addVariation(s + "_cobblestone", other, meta, 0);
    }

    @Override
    public String modid() {
        return "UndergroundBiomes";
    }

    @Override
    public void preInit() {
        for (int i = 0; i < UBC_STONES_FULL.length; i++) {
            String s = UBC_STONES_FULL[i];
            String tb = UBC_STONES_FULL_BLOCKNAMES[i];
            addStoneBrick(s, tb);
            addCobblestone(s, tb);
            addStone(s, tb);
            addPillar(s, tb);
        }
        for (int i = 0; i < UBC_STONES_BASIC.length; i++) {
            String s = UBC_STONES_BASIC[i];
            String tb = UBC_STONES_BASIC_BLOCKNAMES[i];
            addStone(s, tb);
            addPillar(s, tb);
        }
    }

    @Override
    public void init() {
        for (int i = 0; i < UBC_STONES_FULL.length; i++) {
            String s = UBC_STONES_FULL[i];
            String tb = UBC_STONES_FULL_BLOCKNAMES[i];
            addStoneBrickInit(s, tb);
            addCobblestoneInit(s, tb);
            addStoneInit(s, tb);
            addPillarInit(s, tb);
        }
        for (int i = 0; i < UBC_STONES_BASIC.length; i++) {
            String s = UBC_STONES_BASIC[i];
            String tb = UBC_STONES_BASIC_BLOCKNAMES[i];
            addStoneInit(s, tb);
            addPillarInit(s, tb);
        }
    }
}
