package rwg.biomes.realistic.land;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

import rwg.api.RWGBiomes;
import rwg.biomes.realistic.RealisticBiomeBase;
import rwg.deco.DecoGrass;
import rwg.surface.SurfaceBase;
import rwg.surface.SurfaceMountainStone;
import rwg.terrain.TerrainBase;
import rwg.terrain.TerrainHilly;
import rwg.util.CellNoise;
import rwg.util.NoiseGenerator;

public class RealisticBiomeJungleHills extends RealisticBiomeBase {

    private TerrainBase terrain;
    private SurfaceBase surface;

    public RealisticBiomeJungleHills() {
        super(0, RWGBiomes.baseJungle);
        terrain = new TerrainHilly(230f, 120f, 50f);
        surface = new SurfaceMountainStone(Blocks.grass, Blocks.dirt, false, null, 1f, 1.5f, 60f, 65f, 1.5f);
    }

    @Override
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, NoiseGenerator perlin, CellNoise cell,
            float strength, float river) {
        for (int b33 = 0; b33 < 2; b33++) {
            int j6 = chunkX + rand.nextInt(16) + 8;
            int k10 = chunkY + rand.nextInt(16) + 8;
            int z52 = world.getHeightValue(j6, k10);

            if (z52 < 100 || rand.nextInt(3) == 0) {
                WorldGenerator worldgenerator = rand.nextInt(5) == 0 ? new WorldGenShrub(0, 0)
                        : rand.nextInt(3) == 0 ? new WorldGenMegaJungle(false, 5, 10, 3, 3)
                                : new WorldGenTrees(false, 3 + rand.nextInt(5), 3, 3, true);
                worldgenerator.setScale(1.0D, 1.0D, 1.0D);
                worldgenerator.generate(world, rand, j6, z52, k10);
            }
        }

        for (int l14 = 0; l14 < 15; l14++) {
            int l19 = chunkX + rand.nextInt(16) + 8;
            int k22 = rand.nextInt(128);
            int j24 = chunkY + rand.nextInt(16) + 8;

            if (rand.nextInt(6) == 0) {
                (new DecoGrass(Blocks.double_plant, 2)).generate(world, rand, l19, k22, j24);
            } else {
                (new DecoGrass(Blocks.tallgrass, 1)).generate(world, rand, l19, k22, j24);
            }
        }
    }

    public float rNoise(NoiseGenerator perlin, CellNoise cell, int x, int y, float ocean, float border, float river) {
        return terrain.generateNoise(perlin, cell, x, y, ocean, border, river);
    }

    public void rReplace(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world,
            Random rand, NoiseGenerator perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base) {
        surface.paintTerrain(blocks, metadata, i, j, x, y, depth, world, rand, perlin, cell, noise, river, base);
    }
}
