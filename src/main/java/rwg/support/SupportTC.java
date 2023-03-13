package rwg.support;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import rwg.api.RWGBiomes;
import rwg.support.Support.BiomeCategory;
import rwg.surface.SurfaceGrassland;
import rwg.terrain.TerrainHighland;
import rwg.terrain.TerrainSmallSupport;

public class SupportTC {
    /*
     * THAUMCRAFT BIOMES 118: "Tainted Land" 119: "Magical Forest"
     */

    public static void init() {
        BiomeGenBase[] b = BiomeGenBase.getBiomeGenArray();

        for (int i = 0; i < 256; i++) {
            if (b[i] != null) {
                if (b[i].biomeName == "Tainted Land") {
                    Support.addBiome(
                            new RealisticBiomeSupport(
                                    b[i],
                                    RWGBiomes.baseRiverTemperate,
                                    new TerrainSmallSupport(),
                                    new SurfaceGrassland(
                                            b[i].topBlock,
                                            b[i].fillerBlock,
                                            Blocks.stone,
                                            Blocks.cobblestone)),
                            BiomeCategory.SMALL);
                }

                if (b[i].biomeName == "Magical Forest") {
                    Support.addBiome(
                            new RealisticBiomeSupport(
                                    b[i],
                                    RWGBiomes.baseTemperateForest,
                                    new TerrainHighland(6f, 120f, 65f, 150f),
                                    new SurfaceGrassland(
                                            b[i].topBlock,
                                            b[i].fillerBlock,
                                            Blocks.stone,
                                            Blocks.cobblestone)),
                            BiomeCategory.WET);
                }
            }
        }
    }
}
