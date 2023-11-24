package rwg.biomes.base;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import rwg.api.RWGBiomes;
import rwg.config.ConfigRWG;

public class BaseBiomes {

    public static void load() {
        RWGBiomes.baseRiverIce = new BaseBiomeRiver(ConfigRWG.biomeIDs[0], 0, "Ice River");
        RWGBiomes.baseRiverCold = new BaseBiomeRiver(ConfigRWG.biomeIDs[1], 1, "Cold River");
        RWGBiomes.baseRiverTemperate = new BaseBiomeRiver(ConfigRWG.biomeIDs[2], 2, "Temperate River");
        RWGBiomes.baseRiverHot = new BaseBiomeRiver(ConfigRWG.biomeIDs[3], 3, "Hot River");
        RWGBiomes.baseRiverWet = new BaseBiomeRiver(ConfigRWG.biomeIDs[4], 4, "Wet River");
        RWGBiomes.baseRiverOasis = new BaseBiomeRiver(ConfigRWG.biomeIDs[5], 5, "River Oasis");

        RWGBiomes.baseOceanIce = new BaseBiomeOcean(ConfigRWG.biomeIDs[6], 0, "Ice Ocean");
        RWGBiomes.baseOceanCold = new BaseBiomeOcean(ConfigRWG.biomeIDs[7], 1, "Cold Ocean");
        RWGBiomes.baseOceanTemperate = new BaseBiomeOcean(ConfigRWG.biomeIDs[8], 2, "Temperate Ocean");
        RWGBiomes.baseOceanHot = new BaseBiomeOcean(ConfigRWG.biomeIDs[9], 3, "Hot Ocean");
        RWGBiomes.baseOceanWet = new BaseBiomeOcean(ConfigRWG.biomeIDs[10], 4, "Wet Ocean");
        RWGBiomes.baseOceanOasis = new BaseBiomeOcean(ConfigRWG.biomeIDs[11], 5, "Ocean Oasis");

        RWGBiomes.baseSnowDesert = new BaseBiomeSnowDesert(ConfigRWG.biomeIDs[12], "Snow Desert");
        RWGBiomes.baseSnowForest = new BaseBiomeSnowForest(ConfigRWG.biomeIDs[13], "Snow Forest");
        RWGBiomes.baseColdPlains = new BaseBiomeColdPlains(ConfigRWG.biomeIDs[14], "Cold Plains");
        RWGBiomes.baseColdForest = new BaseBiomeColdForest(ConfigRWG.biomeIDs[15], "Cold Forest");
        RWGBiomes.baseHotPlains = new BaseBiomeHotPlains(ConfigRWG.biomeIDs[16], "Hot Plains");
        RWGBiomes.baseHotForest = new BaseBiomeHotForest(ConfigRWG.biomeIDs[17], "Hot Forest");
        RWGBiomes.baseHotDesert = new BaseBiomeHotDesert(ConfigRWG.biomeIDs[18], "Hot Desert");
        RWGBiomes.basePlains = new BaseBiomePlains(ConfigRWG.biomeIDs[19], "Plains (RWG)");
        RWGBiomes.baseTropicalIsland = new BaseBiomeTropicalIsland(ConfigRWG.biomeIDs[20], "Tropical Island");
        RWGBiomes.baseRedwood = new BaseBiomeRedwood(ConfigRWG.biomeIDs[21], "Redwood");
        RWGBiomes.baseJungle = new BaseBiomeJungle(ConfigRWG.biomeIDs[22], "Jungle (RWG)");
        RWGBiomes.baseOasis = new BaseBiomeRiver(ConfigRWG.biomeIDs[23], 5, "Oasis");
        RWGBiomes.baseTemperateForest = new BaseBiomeTemperateForest(ConfigRWG.biomeIDs[24], "Temperate Forest");

        // RIVER
        BiomeDictionary.registerBiomeType(RWGBiomes.baseRiverIce, Type.RIVER, Type.COLD, Type.SNOWY);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseRiverCold, Type.RIVER, Type.COLD, Type.CONIFEROUS, Type.FOREST);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseRiverTemperate, Type.RIVER, Type.COLD, Type.FOREST);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseRiverHot, Type.RIVER, Type.HOT, Type.DRY, Type.SANDY);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseRiverWet, Type.RIVER, Type.HOT, Type.WET, Type.JUNGLE);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseRiverOasis, Type.RIVER, Type.HOT, Type.WET, Type.JUNGLE);

        // OCEAN
        BiomeDictionary.registerBiomeType(RWGBiomes.baseOceanIce, Type.OCEAN, Type.BEACH, Type.COLD, Type.SNOWY);
        BiomeDictionary.registerBiomeType(
                RWGBiomes.baseOceanCold,
                Type.OCEAN,
                Type.BEACH,
                Type.COLD,
                Type.CONIFEROUS,
                Type.FOREST);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseOceanTemperate, Type.OCEAN, Type.BEACH, Type.COLD, Type.FOREST);
        BiomeDictionary
                .registerBiomeType(RWGBiomes.baseOceanHot, Type.OCEAN, Type.BEACH, Type.HOT, Type.DRY, Type.SANDY);
        BiomeDictionary
                .registerBiomeType(RWGBiomes.baseOceanWet, Type.OCEAN, Type.BEACH, Type.HOT, Type.WET, Type.JUNGLE);
        BiomeDictionary
                .registerBiomeType(RWGBiomes.baseOceanOasis, Type.OCEAN, Type.BEACH, Type.HOT, Type.WET, Type.JUNGLE);

        // LAND
        BiomeDictionary.registerBiomeType(RWGBiomes.baseSnowDesert, Type.COLD, Type.SNOWY, Type.WASTELAND);
        BiomeDictionary
                .registerBiomeType(RWGBiomes.baseSnowForest, Type.COLD, Type.SNOWY, Type.CONIFEROUS, Type.FOREST);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseColdPlains, Type.COLD, Type.WASTELAND);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseColdForest, Type.COLD, Type.CONIFEROUS, Type.FOREST);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseHotPlains, Type.HOT, Type.SAVANNA, Type.PLAINS, Type.SPARSE);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseHotForest, Type.HOT, Type.SAVANNA, Type.PLAINS, Type.SPARSE);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseHotDesert, Type.HOT, Type.DRY, Type.SANDY);
        BiomeDictionary.registerBiomeType(RWGBiomes.basePlains, Type.PLAINS);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseTropicalIsland, Type.HOT, Type.WET, Type.JUNGLE);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseRedwood, Type.COLD, Type.CONIFEROUS, Type.FOREST);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseJungle, Type.HOT, Type.WET, Type.JUNGLE);
        BiomeDictionary.registerBiomeType(RWGBiomes.baseColdForest, Type.FOREST, Type.DENSE, Type.HILLS);
    }
}
