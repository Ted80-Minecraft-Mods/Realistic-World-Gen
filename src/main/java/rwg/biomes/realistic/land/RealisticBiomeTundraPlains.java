package rwg.biomes.realistic.land;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenerator;

import rwg.api.RWGBiomes;
import rwg.biomes.realistic.RealisticBiomeBase;
import rwg.deco.DecoBlob;
import rwg.deco.DecoFlowers;
import rwg.deco.DecoGrass;
import rwg.deco.trees.DecoShrub;
import rwg.deco.trees.DecoSmallPine;
import rwg.deco.trees.DecoSmallSpruce;
import rwg.surface.SurfaceBase;
import rwg.surface.SurfaceTundra;
import rwg.terrain.TerrainBase;
import rwg.terrain.TerrainFlatLakes;
import rwg.util.CellNoise;
import rwg.util.NoiseGenerator;

public class RealisticBiomeTundraPlains extends RealisticBiomeBase {

    private TerrainBase terrain;
    private SurfaceBase surface;

    public RealisticBiomeTundraPlains() {
        super(0, RWGBiomes.baseColdPlains, RealisticBiomeBase.coastDunes, RWGBiomes.baseRiverCold);

        terrain = new TerrainFlatLakes();
        surface = new SurfaceTundra(Blocks.grass, Blocks.dirt);
    }

    @Override
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, NoiseGenerator perlin, CellNoise cell,
            float strength, float river) {
        if (rand.nextInt((int) (15f / strength)) == 0) {
            int i2 = chunkX + rand.nextInt(16) + 8;
            int i8 = chunkY + rand.nextInt(16) + 8;
            int l4 = world.getHeightValue(i2, i8);
            if (l4 > 63 && l4 < 105) {
                (new WorldGenLakes(Blocks.water)).generate(world, rand, i2, l4, i8);
            }
        }

        for (int l = 0; l < 3f * strength; ++l) {
            int i1 = chunkX + rand.nextInt(16) + 8;
            int j1 = chunkY + rand.nextInt(16) + 8;
            int k1 = world.getHeightValue(i1, j1);
            if (k1 < 85 && (k1 < 64 || rand.nextInt(5) == 0)) {
                (new DecoBlob(Blocks.cobblestone, 0)).generate(world, rand, i1, k1, j1);
            }
        }

        if (rand.nextInt((int) (2f / strength)) == 0) {
            int j6 = chunkX + rand.nextInt(16) + 8;
            int k10 = chunkY + rand.nextInt(16) + 8;
            int z52 = world.getHeightValue(j6, k10);
            WorldGenerator worldgenerator = rand.nextInt(7) == 0 ? new DecoSmallSpruce(0 + rand.nextInt(2))
                    : new DecoSmallPine(2 + rand.nextInt(3), 4 + rand.nextInt(4), rand.nextInt(2));
            worldgenerator.setScale(1.0D, 1.0D, 1.0D);
            worldgenerator.generate(world, rand, j6, z52, k10);
        }

        if (rand.nextInt((int) (1f / strength)) == 0) {
            int i1 = chunkX + rand.nextInt(16) + 8;
            int j1 = chunkY + rand.nextInt(16) + 8;
            int k1 = world.getHeightValue(i1, j1);
            if (k1 < 90) {
                (new DecoShrub(rand.nextInt(4) + 1, rand.nextInt(2), rand.nextInt(2)))
                        .generate(world, rand, i1, k1, j1);
            }
        }

        if (rand.nextInt((int) (25f / strength)) == 0) {
            int j16 = chunkX + rand.nextInt(16) + 8;
            int j18 = rand.nextInt(100);
            int j21 = chunkY + rand.nextInt(16) + 8;
            (new WorldGenPumpkin()).generate(world, rand, j16, j18, j21);
        }

        for (int f23 = 0; f23 < 2f * strength; f23++) {
            int j15 = chunkX + rand.nextInt(16) + 8;
            int j17 = rand.nextInt(128);
            int j20 = chunkY + rand.nextInt(16) + 8;
            (new DecoFlowers(new int[] { 0 })).generate(world, rand, j15, j17, j20);
        }

        for (int l14 = 0; l14 < 4f * strength; l14++) {
            int l19 = chunkX + rand.nextInt(16) + 8;
            int k22 = rand.nextInt(128);
            int j24 = chunkY + rand.nextInt(16) + 8;
            (new DecoGrass(Blocks.tallgrass, 1)).generate(world, rand, l19, k22, j24);
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
