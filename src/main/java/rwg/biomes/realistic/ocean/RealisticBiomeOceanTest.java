package rwg.biomes.realistic.ocean;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import rwg.api.RWGBiomes;
import rwg.biomes.realistic.RealisticBiomeBase;
import rwg.util.CellNoise;
import rwg.util.NoiseGenerator;

public class RealisticBiomeOceanTest extends RealisticBiomeBase {
    public RealisticBiomeOceanTest() {
        super(0, RWGBiomes.baseColdPlains);
    }

    @Override
    public void rDecorate(
            World world,
            Random rand,
            int chunkX,
            int chunkY,
            NoiseGenerator perlin,
            CellNoise cell,
            float strength,
            float river) {}

    @Override
    public float rNoise(NoiseGenerator perlin, CellNoise cell, int x, int y, float ocean, float border, float river) {
        return 45f;
    }

    @Override
    public void rReplace(
            Block[] blocks,
            byte[] metadata,
            int i,
            int j,
            int x,
            int y,
            int depth,
            World world,
            Random rand,
            NoiseGenerator perlin,
            CellNoise cell,
            float[] noise,
            float river,
            BiomeGenBase[] base) {
        Block b;
        for (int k = 255; k > -1; k--) {
            b = blocks[(y * 16 + x) * 256 + k];
            if (b == Blocks.air) {
                depth = -1;
            } else if (b == Blocks.stone) {
                depth++;

                if (depth == 0) {
                    if (k < 62) {
                        blocks[(y * 16 + x) * 256 + k] = Blocks.sand;
                    } else {
                        blocks[(y * 16 + x) * 256 + k] = Blocks.sand;
                    }
                } else if (depth < 6) {
                    blocks[(y * 16 + x) * 256 + k] = Blocks.sand;
                }
            }
        }
    }
}
