package rwg.terrain;

import rwg.util.CellNoise;
import rwg.util.NoiseGenerator;

public class TerrainGrasslandHills extends TerrainBase {

    private float hHeight;
    private float hWidth;
    private float vHeight;
    private float vWidth;
    private float lHeight;
    private float lWidth;
    private float bHeight;

    /*
     * hillHeight = 70f hillWidth = 180f varHeight = 7f varWidth = 100f lakeHeigth = 38f lakeWidth = 260f baseHeight =
     * 68f 70f, 180f, 7f, 100f, 38f, 260f, 68f
     */
    public TerrainGrasslandHills(float hillHeight, float hillWidth, float varHeight, float varWidth, float lakeHeight,
            float lakeWidth, float baseHeight) {
        hHeight = hillHeight;
        hWidth = hillWidth;

        vHeight = varHeight;
        vWidth = varWidth;

        lHeight = lakeHeight;
        lWidth = lakeWidth;

        bHeight = baseHeight;
    }

    @Override
    public float generateNoise(NoiseGenerator perlin, CellNoise cell, int x, int y, float ocean, float border,
            float river) {
        float h = perlin.noise2(x / vWidth, y / vWidth) * vHeight * river;
        h += perlin.noise2(x / 20f, y / 20f) * 2;

        float m = perlin.noise2(x / hWidth, y / hWidth) * hHeight * river;
        m *= m / 40f;

        float sm = perlin.noise2(x / 30f, y / 30f) * 8f;
        sm *= m / 20f > 3.75f ? 3.75f : m / 20f;
        m += sm;

        float cm = cell.noise(x / 25D, y / 25D, 1D) * 12f;
        cm *= m / 20f > 3.75f ? 3.75f : m / 20f;
        m += cm;

        float l = perlin.noise2(x / lWidth, y / lWidth) * lHeight;
        l *= l / 25f;
        l = l < 8f ? 8f : l;

        h += perlin.noise2(x / 12f, y / 12f) * 3f;
        h += perlin.noise2(x / 5f, y / 5f) * 1.5f;

        return bHeight + h + m - l;
    }
}
