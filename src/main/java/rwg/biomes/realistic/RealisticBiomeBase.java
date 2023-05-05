package rwg.biomes.realistic;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import rwg.api.RWGBiomes;
import rwg.biomes.realistic.coast.*;
import rwg.biomes.realistic.desert.RealisticBiomeDesert;
import rwg.biomes.realistic.desert.RealisticBiomeDesertMountains;
import rwg.biomes.realistic.desert.RealisticBiomeDuneValley;
import rwg.biomes.realistic.desert.RealisticBiomeOasis;
import rwg.biomes.realistic.forest.RealisticBiomeDarkRedwood;
import rwg.biomes.realistic.forest.RealisticBiomeDarkRedwoodPlains;
import rwg.biomes.realistic.forest.RealisticBiomeWoodHills;
import rwg.biomes.realistic.forest.RealisticBiomeWoodMountains;
import rwg.biomes.realistic.land.*;
import rwg.biomes.realistic.ocean.*;
import rwg.biomes.realistic.red.RealisticBiomeCanyon;
import rwg.biomes.realistic.red.RealisticBiomeMesa;
import rwg.biomes.realistic.red.RealisticBiomeRedDesertMountains;
import rwg.biomes.realistic.red.RealisticBiomeRedOasis;
import rwg.biomes.realistic.savanna.RealisticBiomeCanyonForest;
import rwg.biomes.realistic.savanna.RealisticBiomeDuneValleyForest;
import rwg.biomes.realistic.savanna.RealisticBiomeHotForest;
import rwg.biomes.realistic.savanna.RealisticBiomeMesaPlains;
import rwg.biomes.realistic.savanna.RealisticBiomeSavanna;
import rwg.biomes.realistic.savanna.RealisticBiomeSavannaDunes;
import rwg.biomes.realistic.savanna.RealisticBiomeSavannaForest;
import rwg.biomes.realistic.savanna.RealisticBiomeStoneMountains;
import rwg.biomes.realistic.savanna.RealisticBiomeStoneMountainsCactus;
import rwg.util.CellNoise;
import rwg.util.NoiseGenerator;
import rwg.world.ChunkManagerRealistic;

public class RealisticBiomeBase {

    private static final RealisticBiomeBase[] biomeList = new RealisticBiomeBase[256];
    private static int nextBiomeID = 0;

    public static RealisticBiomeBase test = new RealisticBiomeTest();
    public static RealisticBiomeBase river = new RealisticBiomeTestRiver();

    public static RealisticBiomeBase ocean = new RealisticBiomeOceanTest();
    public static RealisticBiomeBase coast = new RealisticBiomeCoastTest();

    // POLAR =========================================================================================
    public static RealisticBiomeBase polar = new RealisticBiomePolar();

    // SNOW ==========================================================================================
    public static RealisticBiomeBase snowHills = new RealisticBiomeSnowHills();
    public static RealisticBiomeBase snowRivers = new RealisticBiomeSnowRivers();
    public static RealisticBiomeBase snowLakes = new RealisticBiomeSnowLakes();
    public static RealisticBiomeBase redwoodSnow = new RealisticBiomeRedwoodSnow();

    // PINE ===========================================================================================
    public static RealisticBiomeBase tundraHills = new RealisticBiomeTundraHills();
    public static RealisticBiomeBase tundraPlains = new RealisticBiomeTundraPlains();
    public static RealisticBiomeBase taigaHills = new RealisticBiomeTaigaHills();
    public static RealisticBiomeBase taigaPlains = new RealisticBiomeTaigaPlains();

    // FOREST =========================================================================================
    public static RealisticBiomeBase redwood = new RealisticBiomeRedwood();
    public static RealisticBiomeBase darkRedwood = new RealisticBiomeDarkRedwood();
    public static RealisticBiomeBase darkRedwoodPlains = new RealisticBiomeDarkRedwoodPlains();
    public static RealisticBiomeBase woodhills = new RealisticBiomeWoodHills();
    public static RealisticBiomeBase woodmountains = new RealisticBiomeWoodMountains();

    // SAVANNA ========================================================================================
    public static RealisticBiomeBase duneValleyForest = new RealisticBiomeDuneValleyForest();
    public static RealisticBiomeBase savanna = new RealisticBiomeSavanna();
    public static RealisticBiomeBase savannaForest = new RealisticBiomeSavannaForest();
    public static RealisticBiomeBase savannaDunes = new RealisticBiomeSavannaDunes();
    public static RealisticBiomeBase stoneMountains = new RealisticBiomeStoneMountains();
    public static RealisticBiomeBase stoneMountainsCactus = new RealisticBiomeStoneMountainsCactus();
    public static RealisticBiomeBase hotForest = new RealisticBiomeHotForest();
    public static RealisticBiomeBase hotRedwood = new RealisticBiomeHotRedwood();
    public static RealisticBiomeBase canyonForest = new RealisticBiomeCanyonForest();
    public static RealisticBiomeBase mesaPlains = new RealisticBiomeMesaPlains();

    // DESERT =========================================================================================
    public static RealisticBiomeBase desert = new RealisticBiomeDesert();
    public static RealisticBiomeBase desertMountains = new RealisticBiomeDesertMountains();
    public static RealisticBiomeBase duneValley = new RealisticBiomeDuneValley();
    public static RealisticBiomeBase oasis = new RealisticBiomeOasis();

    // RED ============================================================================================
    public static RealisticBiomeBase redDesertMountains = new RealisticBiomeRedDesertMountains();
    public static RealisticBiomeBase redDesertOasis = new RealisticBiomeRedOasis();
    public static RealisticBiomeBase canyon = new RealisticBiomeCanyon();
    public static RealisticBiomeBase mesa = new RealisticBiomeMesa();

    // SWAMP ==========================================================================================

    // TROPICAL =======================================================================================

    // JUNGLE =========================================================================================
    public static RealisticBiomeBase rainForestHigh = new RealisticBiomeHighRainforest();
    public static RealisticBiomeBase jungleHills = new RealisticBiomeJungleHills();
    public static RealisticBiomeBase jungleCanyon = new RealisticBiomeJungleCanyon();
    public static RealisticBiomeBase redwoodJungle = new RealisticBiomeRedwoodJungle();

    // COAST =========================================================================================
    public static RealisticBiomeBase coastIce = new RealisticBiomeCoastIce();

    public static RealisticBiomeBase coastColdSlope = new RealisticBiomeCoastColdSlope();
    public static RealisticBiomeBase coastColdCliff = new RealisticBiomeCoastColdCliff();
    public static RealisticBiomeBase coastDunes = new RealisticBiomeCoastDunes();

    public static RealisticBiomeBase coastMangrove = new RealisticBiomeCoastMangrove();
    public static RealisticBiomeBase coastOasis = new RealisticBiomeCoastOasis();

    // OCEAN =========================================================================================
    public static RealisticBiomeBase islandTropical = new RealisticBiomeIslandTropical();

    // ==============================================================================================

    public final int biomeID;
    public final int subID;
    public final BiomeGenBase baseBiome;
    public final RealisticBiomeBase beachBiome;
    public final BiomeGenBase riverBiome;

    public RealisticBiomeBase(int sub, BiomeGenBase biome) {
        this(sub, biome, coastIce, RWGBiomes.baseRiverTemperate);
    }

    public RealisticBiomeBase(int sub, BiomeGenBase biome, RealisticBiomeBase coast, BiomeGenBase river) {
        biomeID = nextBiomeID;
        biomeList[biomeID] = this;
        nextBiomeID++;

        subID = sub;
        baseBiome = biome;
        beachBiome = coast;
        riverBiome = river;
    }

    public static RealisticBiomeBase getBiome(int id) {
        return biomeList[id];
    }

    // ======================================================================================================================================

    public void rDecorate(World world, Random rand, int chunkX, int chunkY, NoiseGenerator perlin, CellNoise cell,
            float strength, float river) {}

    public void generateMapGen(Block[] blocks, byte[] metadata, Long seed, World world, ChunkManagerRealistic cmr,
            Random mapRand, int chunkX, int chunkY, NoiseGenerator perlin, CellNoise cell, float noise[]) {
        int k = 5;
        mapRand.setSeed(seed);
        long l = (mapRand.nextLong() / 2L) * 2L + 1L;
        long l1 = (mapRand.nextLong() / 2L) * 2L + 1L;
        for (int baseX = chunkX - k; baseX <= chunkX + k; baseX++) {
            for (int baseY = chunkY - k; baseY <= chunkY + k; baseY++) {
                mapRand.setSeed((long) baseX * l + (long) baseY * l1 ^ seed);
                rMapGen(blocks, metadata, world, cmr, mapRand, baseX, baseY, chunkX, chunkY, perlin, cell, noise);
            }
        }
    }

    public void rMapGen(Block[] blocks, byte[] metadata, World world, ChunkManagerRealistic cmr, Random mapRand,
            int chunkX, int chunkY, int baseX, int baseY, NoiseGenerator perlin, CellNoise cell, float noise[]) {}

    public float rNoise(NoiseGenerator perlin, CellNoise cell, int x, int y, float ocean, float border, float river) {
        return 63f;
    }

    public void rReplace(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world,
            Random rand, NoiseGenerator perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base) {
        Block b;
        for (int k = 255; k > -1; k--) {
            b = blocks[(y * 16 + x) * 256 + k];
            if (b == Blocks.air) {
                depth = -1;
            } else if (b == Blocks.stone) {
                depth++;

                if (depth == 0) {
                    if (k < 62) {
                        blocks[(y * 16 + x) * 256 + k] = Blocks.dirt;
                    } else {
                        blocks[(y * 16 + x) * 256 + k] = Blocks.grass;
                    }
                } else if (depth < 6) {
                    blocks[(y * 16 + x) * 256 + k] = Blocks.dirt;
                }
            }
        }
    }

    public float r3Dnoise(float z) {
        return 0f;
    }
}
