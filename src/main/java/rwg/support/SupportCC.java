package rwg.support;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import rwg.api.RWGBiomes;
import rwg.support.Support.BiomeCategory;
import rwg.surface.SurfaceGrassland;
import rwg.terrain.TerrainHighland;
import rwg.terrain.TerrainHilly;

public class SupportCC {
    /*
     * ChromatiCraft BIOMES 46: "Ender Forest" 47: "Rainbow Forest" 48: "Luminous Cliffs" 49: "Luminous Cliffs Edge"
     */

    public static void init() {
        BiomeGenBase[] b = BiomeGenBase.getBiomeGenArray();

        for (int i = 0; i < 256; i++) {
            if (b[i] != null) {
                if (b[i].biomeName == "Ender Forest" || b[i].biomeName == "Rainbow Forest") {
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
                            BiomeCategory.HOT);
                }

                if (b[i].biomeName == "Luminous Cliffs" || b[i].biomeName == "Luminous Cliffs Shores") {
                    Support.addBiome(
                            new RealisticBiomeSupport(
                                    b[i],
                                    RWGBiomes.baseOceanTemperate,
                                    new TerrainHilly(100f, 120f, 0f),
                                    new SurfaceGrassland(
                                            b[i].topBlock,
                                            b[i].fillerBlock,
                                            Blocks.stone,
                                            Blocks.cobblestone)),
                            BiomeCategory.HOT);
                }
            }
        }
    }
}
