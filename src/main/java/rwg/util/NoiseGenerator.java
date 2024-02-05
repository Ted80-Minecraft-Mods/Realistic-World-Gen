package rwg.util;

public interface NoiseGenerator {

    /**
     * Computes noise function for three dimensions at the point (x,y,z).
     *
     * @param x x dimension parameter
     * @param y y dimension parameter
     * @param z z dimension parameter
     * @return the noise value at the point (x, y, z)
     */
    double improvedNoise(double x, double y, double z);

    /**
     * 1-D noise generation function.
     *
     * @param x Seed for the noise function
     * @return The noisy output
     */
    float noise1(float x);

    /**
     * Create noise in a 2D space.
     *
     * @param x The X coordinate of the location to sample
     * @param y The Y coordinate of the location to sample
     * @return A noisy value at the given position
     */
    float noise2(float x, float y);

    /**
     * Create noise in a 3D space.
     *
     * @param x The X coordinate of the location to sample
     * @param y The Y coordinate of the location to sample
     * @param z The Z coordinate of the location to sample
     * @return A noisy value at the given position
     */
    float noise3(float x, float y, float z);
}
