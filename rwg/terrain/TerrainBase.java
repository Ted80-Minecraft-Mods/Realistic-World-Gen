package rwg.terrain;

import rwg.util.CellNoise;
import rwg.util.PerlinNoise;

public class TerrainBase 
{
	public TerrainBase()
	{
	}
	
	public float generateNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
	{
		return 70f;
	}
}
