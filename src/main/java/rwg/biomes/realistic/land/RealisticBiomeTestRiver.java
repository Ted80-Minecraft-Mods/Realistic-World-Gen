package rwg.biomes.realistic.land;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import rwg.api.RWGBiomes;
import rwg.biomes.realistic.RealisticBiomeBase;
import rwg.surface.SurfaceBase;
import rwg.surface.SurfaceMountainStoneMix1;
import rwg.terrain.TerrainBase;
import rwg.terrain.TerrainHilly;
import rwg.util.CellNoise;
import rwg.util.NoiseGenerator;

public class RealisticBiomeTestRiver extends RealisticBiomeBase {

    private CellNoise celltest;
    private TerrainBase terrain;
    private SurfaceBase surface;

    public RealisticBiomeTestRiver() {
        super(0, RWGBiomes.baseHotPlains);

        celltest = new CellNoise(0, (short) 0);
        // celltest.setUseDistance(true);

        terrain = new TerrainHilly(230f, 120f, 0f);
        surface = new SurfaceMountainStoneMix1(
                Blocks.grass,
                Blocks.dirt,
                false,
                null,
                0f,
                1.5f,
                60f,
                65f,
                1.5f,
                Blocks.stone,
                0.08f);
    }

    @Override
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, NoiseGenerator perlin, CellNoise cell,
            float strength, float river) {}

    @Override
    public float rNoise(NoiseGenerator perlin, CellNoise cell, int x, int y, float ocean, float border, float river) {
        /*
         * float pX = x + (perlin.noise1(y / 240f) * 220f); float pY = y + (perlin.noise1(x / 240f) * 220f); float p =
         * cell.border(pX / 1250D, pY / 1250D, 50D / 2300D, 1f); float st = cell.border(pX / 1250D, pY / 1250D, 50D /
         * 400D, 1f); return ((generateNoise(perlin, cell, x, y, st + 1f)) * (p + 1f)) + ((57f + perlin.noise2(x / 15f,
         * y / 15f) * 3f + perlin.noise2(x / 8f, y / 8f) * 1.5f) * (-p));
         */
        return 64.1f;
    }

    public float generateNoise(NoiseGenerator perlin, CellNoise cell, int x, int y, float river) {
        float h = perlin.noise2(x / 20f, y / 20f) * 2;
        h += perlin.noise2(x / 7f, y / 7f) * 0.8f;

        float m = perlin.noise2(x / 230f, y / 230f) * 120f * river;
        m *= m / 35f;
        m = m > 70f ? 70f + (m - 70f) / 2.5f : m;

        float st = m * 0.7f;
        st = st > 20f ? 20f : st;
        float c = cell.noise(x / 30f, y / 30f, 1D) * (5f + st);

        float sm = perlin.noise2(x / 30f, y / 30f) * 8f + perlin.noise2(x / 8f, y / 8f);
        sm *= (m + 10f) / 20f > 2.5f ? 2.5f : (m + 10f) / 20f;
        m += sm;

        m += c;

        float l = perlin.noise2(x / 260f, y / 260f) * 0f;
        l *= l / 25f;
        l = l < -8f ? -8f : l;

        return 67f + h + m - l;
    }
}
