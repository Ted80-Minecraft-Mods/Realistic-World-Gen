package rwg.biomes.base;

import net.minecraft.world.biome.BiomeGenBase;

public class BaseBiomeOasis extends BiomeGenBase
{
	public BaseBiomeOasis(int id, String bn) 
	{
		super(id);
		setTemperatureRainfall(0.9f, 0.9f);
		setBiomeName(bn);
	}
}
