package rwg.surface;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import rwg.util.CellNoise;
import rwg.util.NoiseGenerator;

public class SurfaceBase {

    protected Block topBlock;
    protected Block fillerBlock;

    public SurfaceBase(Block top, Block fill) {
        topBlock = top;
        fillerBlock = fill;
    }

    public void paintTerrain(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world,
            Random rand, NoiseGenerator perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base) {}
}
