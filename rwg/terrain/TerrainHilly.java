package rwg.terrain;

import rwg.util.CellNoise;
import rwg.util.PerlinNoise;

public class TerrainHilly extends TerrainBase
{
	private float width;
	private float strength;
	private float lakeDepth;
	
	/*
	 * width = 230f
	 * strength = 120f
	 * lake = 50f;
	 */
	public TerrainHilly(float mountainWidth, float mountainStrength, float lake)
	{
		width = mountainWidth;
		strength = mountainStrength;
		lakeDepth = lake;
	}
	
	@Override
	public float generateNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
	{
		float h = perlin.noise2(x / 20f, y / 20f) * 2;
		h += perlin.noise2(x / 7f, y / 7f) * 0.8f;
		
		float m = perlin.noise2(x / width, y / width) * strength * river;
		m *= m / 35f;
		m = m > 70f ? 70f + (m - 70f) / 2.5f : m;
		
		float st = m * 0.7f;
		st = st > 20f ? 20f : st;
		float c = cell.noise(x / 30f, y / 30f, 1D) * (5f + st);
		
		float sm = perlin.noise2(x / 30f, y / 30f) * 8f + perlin.noise2(x / 8f, y / 8f);
		sm *= (m + 10f) / 20f > 2.5f ? 2.5f : (m + 10f) / 20f;
		m += sm;
		
		m += c;
		
		float l = perlin.noise2(x / 260f, y / 260f) * lakeDepth;
		l *= l / 25f;
		l = l < -8f ? -8f : l;
		
		return 68f + h + m - l;
	}
}
