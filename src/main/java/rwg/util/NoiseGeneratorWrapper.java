package rwg.util;

public class NoiseGeneratorWrapper implements NoiseGenerator {

    NoiseGenerator innerPerlin, innerOpenSimplex;
    public static boolean useOpenSimplex;

    public NoiseGeneratorWrapper(long seed) {
        innerPerlin = new PerlinNoise(seed);
        innerOpenSimplex = new OpenSimplexNoise(seed);
    }

    @Override
    public double improvedNoise(double x, double y, double z) {
        if (useOpenSimplex) return innerOpenSimplex.improvedNoise(x, y, z);
        return innerPerlin.improvedNoise(x, y, z);
    }

    @Override
    public float noise1(float x) {
        if (useOpenSimplex) return innerOpenSimplex.noise1(x);
        return innerPerlin.noise1(x);
    }

    @Override
    public float noise2(float x, float y) {
        if (useOpenSimplex) return innerOpenSimplex.noise2(x, y);
        return innerPerlin.noise2(x, y);
    }

    @Override
    public float noise3(float x, float y, float z) {
        if (useOpenSimplex) return innerOpenSimplex.noise3(x, y, z);
        return innerPerlin.noise3(x, y, z);
    }
}
