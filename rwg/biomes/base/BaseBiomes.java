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
		RWGBiomes.baseRiverIce = new BaseBiomeRiver(ConfigRWG.biomeIDs[0], 0, "rwg_riverIce");
		RWGBiomes.baseRiverCold = new BaseBiomeRiver(ConfigRWG.biomeIDs[1], 1, "rwg_riverCold");
		RWGBiomes.baseRiverTemperate = new BaseBiomeRiver(ConfigRWG.biomeIDs[2], 2, "rwg_riverTemperate");
		RWGBiomes.baseRiverHot = new BaseBiomeRiver(ConfigRWG.biomeIDs[3], 3, "rwg_riverHot");
		RWGBiomes.baseRiverWet = new BaseBiomeRiver(ConfigRWG.biomeIDs[4], 4, "rwg_riverWet");
		RWGBiomes.baseRiverOasis = new BaseBiomeRiver(ConfigRWG.biomeIDs[5], 5, "rwg_riverOasis");
		
		RWGBiomes.baseOceanIce = new BaseBiomeOcean(ConfigRWG.biomeIDs[6], 0, "rwg_oceanIce");
		RWGBiomes.baseOceanCold = new BaseBiomeOcean(ConfigRWG.biomeIDs[7], 1, "rwg_oceanCold");
		RWGBiomes.baseOceanTemperate = new BaseBiomeOcean(ConfigRWG.biomeIDs[8], 2, "rwg_oceanTemperate");
		RWGBiomes.baseOceanHot = new BaseBiomeOcean(ConfigRWG.biomeIDs[9], 3, "rwg_oceanHot");
		RWGBiomes.baseOceanWet = new BaseBiomeOcean(ConfigRWG.biomeIDs[10], 4, "rwg_oceanWet");
		RWGBiomes.baseOceanOasis = new BaseBiomeOcean(ConfigRWG.biomeIDs[11], 5, "rwg_oceanOasis");
		
		RWGBiomes.baseSnowDesert = new BaseBiomeSnowDesert(ConfigRWG.biomeIDs[12], "rwg_snowDesert");
		RWGBiomes.baseSnowForest = new BaseBiomeSnowForest(ConfigRWG.biomeIDs[13], "rwg_snowForest");
		RWGBiomes.baseColdPlains = new BaseBiomeColdPlains(ConfigRWG.biomeIDs[14], "rwg_coldPlains");
		RWGBiomes.baseColdForest = new BaseBiomeColdForest(ConfigRWG.biomeIDs[15], "rwg_coldForest");
		RWGBiomes.baseHotPlains = new BaseBiomeHotPlains(ConfigRWG.biomeIDs[16], "rwg_hotPlains");
		RWGBiomes.baseHotForest = new BaseBiomeHotForest(ConfigRWG.biomeIDs[17], "rwg_hotForest");
		RWGBiomes.baseHotDesert = new BaseBiomeHotDesert(ConfigRWG.biomeIDs[18], "rwg_hotDesert");
		RWGBiomes.basePlains = new BaseBiomePlains(ConfigRWG.biomeIDs[19], "rwg_plains");
		RWGBiomes.baseTropicalIsland = new BaseBiomeTropicalIsland(ConfigRWG.biomeIDs[20], "rwg_tropical");
		RWGBiomes.baseRedwood = new BaseBiomeRedwood(ConfigRWG.biomeIDs[21], "rwg_redwood");
		RWGBiomes.baseJungle = new BaseBiomeJungle(ConfigRWG.biomeIDs[22], "rwg_jungle");
		RWGBiomes.baseOasis = new BaseBiomeRiver(ConfigRWG.biomeIDs[23], 5, "rwg_oasis");
		RWGBiomes.baseTemperateForest = new BaseBiomeTemperateForest(ConfigRWG.biomeIDs[24], "rwg_temperateForest");

		//RIVER
		BiomeDictionary.registerBiomeType(RWGBiomes.baseRiverIce,		Type.RIVER, Type.COLD, Type.SNOWY);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseRiverCold,		Type.RIVER, Type.COLD, Type.CONIFEROUS, Type.FOREST);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseRiverTemperate,	Type.RIVER, Type.COLD, Type.FOREST);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseRiverHot,		Type.RIVER, Type.HOT, Type.DRY, Type.SANDY);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseRiverWet,		Type.RIVER, Type.HOT, Type.WET, Type.JUNGLE);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseRiverOasis,		Type.RIVER, Type.HOT, Type.WET, Type.JUNGLE);
		
		//OCEAN
		BiomeDictionary.registerBiomeType(RWGBiomes.baseOceanIce,		Type.OCEAN, Type.BEACH, Type.COLD, Type.SNOWY);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseOceanCold,		Type.OCEAN, Type.BEACH, Type.COLD, Type.CONIFEROUS, Type.FOREST);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseOceanTemperate,	Type.OCEAN, Type.BEACH, Type.COLD, Type.FOREST);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseOceanHot,		Type.OCEAN, Type.BEACH, Type.HOT, Type.DRY, Type.SANDY);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseOceanWet,		Type.OCEAN, Type.BEACH, Type.HOT, Type.WET, Type.JUNGLE);
		BiomeDictionary.registerBiomeType(RWGBiomes.baseOceanOasis,		Type.OCEAN, Type.BEACH, Type.HOT, Type.WET, Type.JUNGLE);
		
		//LAND
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
		BiomeDictionary.registerBiomeType(RWGBiomes.baseColdForest, Type.FOREST, Type.DENSE, Type.HILLS);
	}
}
