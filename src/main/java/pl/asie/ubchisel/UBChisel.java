package pl.asie.ubchisel;

import com.cricketcraft.chisel.block.BlockCarvable;
import com.cricketcraft.chisel.block.BlockCarvablePillar;
import com.cricketcraft.chisel.carving.Carving;
import com.cricketcraft.chisel.config.Configurations;
import com.cricketcraft.chisel.init.ChiselTabs;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import exterminatorJeff.undergroundBiomes.api.UBIDs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

@Mod(modid = UBChisel.MODID, name = "Unlimited Boundaries Chisel", version = UBChisel.VERSION, dependencies = "required-after:chisel;after:Forestry")
public class UBChisel {
    public static final String MODID = "ubchisel";
    public static final String VERSION = "0.0.1";
    public static Configuration config;

    private final List<Module> modules = new ArrayList<Module>();

    private void offerModule(Module m) {
        if (Loader.isModLoaded(m.modid())) {
            if (config.getBoolean(m.modid(), "modules", true, "")) {
                modules.add(m);
            }
        }
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        offerModule(new ModuleUBC());
        offerModule(new ModuleForestry());

        for (Module m : modules) {
            m.preInit();
        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        for (Module m : modules) {
            m.init();
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        for (Module m : modules) {
            m.postInit();
        }
    }
}
