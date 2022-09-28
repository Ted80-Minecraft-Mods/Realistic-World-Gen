package rwg;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import rwg.biomes.base.BaseBiomes;
import rwg.config.ConfigRWG;
import rwg.data.VillageMaterials;
import rwg.support.Support;
import rwg.world.WorldTypeRealistic;

@Mod(modid = "RWG", name = "RealisticWorldGen", version = "GRADLETOKEN_VERSION", acceptableRemoteVersions = "*")
public class RWG {
    @Instance("RWG")
    public static RWG instance;

    public static final WorldTypeRealistic worldtype = (new WorldTypeRealistic("RWG"));

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        instance = this;

        ConfigRWG.init(event);
        BaseBiomes.load();

        MinecraftForge.TERRAIN_GEN_BUS.register(new VillageMaterials());
        // MinecraftForge.TERRAIN_GEN_BUS.register(new TreeReplacement());
    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {}

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Support.init();
    }
}
