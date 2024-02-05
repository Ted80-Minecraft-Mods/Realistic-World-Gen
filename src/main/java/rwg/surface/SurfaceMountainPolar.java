package rwg.surface;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import rwg.util.CellNoise;
import rwg.util.NoiseGenerator;

public class SurfaceMountainPolar extends SurfaceBase {

    private boolean beach;
    private Block beachBlock;
    private float min;

    public SurfaceMountainPolar(Block top, Block fill, boolean genBeach, Block genBeachBlock, float minCliff) {
        super(top, fill);
        beach = genBeach;
        beachBlock = genBeachBlock;
        min = minCliff;
    }

    @Override
    public void paintTerrain(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world,
            Random rand, NoiseGenerator perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base) {}
}
