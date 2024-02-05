package rwg.terrain;

import rwg.util.CellNoise;
import rwg.util.NoiseGenerator;

public class TerrainGrasslandFlats extends TerrainBase {

    public TerrainGrasslandFlats() {}

    @Override
    public float generateNoise(NoiseGenerator perlin, CellNoise cell, int x, int y, float ocean, float border,
            float river) {
        float h = perlin.noise2(x / 100f, y / 100f) * 7;
        h += perlin.noise2(x / 20f, y / 20f) * 2;

        float m = perlin.noise2(x / 180f, y / 180f) * 70f * river;
        m *= m / 40f;

        float sm = perlin.noise2(x / 30f, y / 30f) * 8f;
        sm *= m / 20f > 3.75f ? 3.75f : m / 20f;
        m += sm;

        float l = perlin.noise2(x / 260f, y / 260f) * 38f;
        l *= l / 25f;
        l = l < -8f ? -8f : l;

        return 68f + h + m - l;
    }
}
