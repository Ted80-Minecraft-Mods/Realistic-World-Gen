package rwg.biomes.base;

import rwg.api.RWGBiomes;
import rwg.config.ConfigRWG;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BaseBiomes 
{
	public static void load()
	{
		RWGBiomes.baseSnowDesert = new BaseBiomeSnowDesert(ConfigRWG.biomeIDs[0], "rwg_snowDesert");
		RWGBiomes.baseSnowForest = new BaseBiomeSnowForest(ConfigRWG.biomeIDs[1], "rwg_snowForest");
		RWGBiomes.baseColdPlains = new BaseBiomeColdPlains(ConfigRWG.biomeIDs[2], "rwg_coldPlains");
		RWGBiomes.baseColdForest = new BaseBiomeColdForest(ConfigRWG.biomeIDs[3], "rwg_coldForest");
		RWGBiomes.baseHotPlains = new BaseBiomeHotPlains(ConfigRWG.biomeIDs[4], "rwg_hotPlains");
		RWGBiomes.baseHotForest = new BaseBiomeHotForest(ConfigRWG.biomeIDs[5], "rwg_hotForest");
		RWGBiomes.baseHotDesert = new BaseBiomeHotDesert(ConfigRWG.biomeIDs[6], "rwg_hotDesert");
		RWGBiomes.basePlains = new BaseBiomePlains(ConfigRWG.biomeIDs[7], "rwg_plains");
		RWGBiomes.baseTropicalIsland = new BaseBiomeTropicalIsland(ConfigRWG.biomeIDs[8], "rwg_tropical");
		RWGBiomes.baseRedwood = new BaseBiomeRedwood(ConfigRWG.biomeIDs[9], "rwg_redwood");
		RWGBiomes.baseJungle = new BaseBiomeJungle(ConfigRWG.biomeIDs[10], "rwg_jungle");
		RWGBiomes.baseOasis = new BaseBiomeOasis(ConfigRWG.biomeIDs[11], "rwg_oasis");
		
		BiomeDictionary.registerBiomeType(RWGBiomes.baseSnowDesert, Type.COLD, Type.SNOWY, Type.WASTELAND);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseSnowForest, Type.COLD, Type.SNOWY, Type.CONIFEROUS, Type.FOREST);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseColdPlains, Type.COLD, Type.WASTELAND);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseColdForest, Type.COLD, Type.CONIFEROUS, Type.FOREST);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseHotPlains, Type.HOT, Type.SAVANNA, Type.PLAINS, Type.SPARSE);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseHotForest, Type.HOT, Type.SAVANNA, Type.PLAINS, Type.SPARSE);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseHotDesert, Type.HOT, Type.DRY, Type.SANDY );
		BiomeDictionary.registerBiomeType(RWGBiomes.basePlains, Type.PLAINS);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseTropicalIsland, Type.HOT, Type.WET, Type.JUNGLE);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseRedwood, Type.COLD, Type.CONIFEROUS, Type.FOREST);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseJungle, Type.HOT, Type.WET, Type.JUNGLE);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseOasis, Type.HOT, Type.WET, Type.JUNGLE, Type.RIVER);
	}
}
