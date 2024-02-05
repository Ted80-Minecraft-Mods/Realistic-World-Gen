package rwg.terrain;

import rwg.util.CellNoise;
import rwg.util.NoiseGenerator;

public class TerrainSmallSupport extends TerrainBase {

    public TerrainSmallSupport() {}

    @Override
    public float generateNoise(NoiseGenerator perlin, CellNoise cell, int x, int y, float ocean, float border,
            float river) {
        float h = perlin.noise2(x / 100f, y / 100f) * 8;
        h += perlin.noise2(x / 30f, y / 30f) * 4;
        h += perlin.noise2(x / 15f, y / 15f) * 2;
        h += perlin.noise2(x / 7f, y / 7f);

        return 70f + (20f * river) + h;
    }
}
