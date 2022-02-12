package rwg;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import rwg.biomes.base.BaseBiomes;
import rwg.config.ConfigRWG;
import rwg.data.TreeReplacement;
import rwg.data.VillageMaterials;
import rwg.support.Support;
import rwg.world.WorldTypeRealistic;

@Mod(modid="RWG", name="RealisticWorldGen", version="Alpha 1.3.2", acceptableRemoteVersions="*")
public class RWG
{	
	@Instance("RWG")
	public static RWG instance;
	
	public static final WorldTypeRealistic worldtype = (new WorldTypeRealistic("RWG"));  
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		instance = this;
		
		ConfigRWG.init(event);
		BaseBiomes.load();
		
		MinecraftForge.TERRAIN_GEN_BUS.register(new VillageMaterials());
		//MinecraftForge.TERRAIN_GEN_BUS.register(new TreeReplacement());
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{
		Support.init();
	}
}