package rwg.support;

import rwg.api.RWGBiomes;
import rwg.biomes.realistic.RealisticBiomeBase;
import rwg.surface.SurfaceGrassland;
import rwg.terrain.TerrainSmallSupport;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rwg.support.Support.BiomeCategory;

public class SupportTC 
{
	/*
	THAUMCRAFT BIOMES
	
	118: "Tainted Land"
	119: "Magical Forest"
	*/
	
	public static void init()
	{
		BiomeGenBase[] b = BiomeGenBase.getBiomeGenArray();
		
		for(int i = 0; i < 256; i++)
		{
			if(b[i] != null)
			{
				if(b[i].biomeName == "Tainted Land" || b[i].biomeName == "Magical Forest")
				{
					Support.addBiome(
						new RealisticBiomeSupport(
							b[i], RWGBiomes.baseRiverTemperate,
							new TerrainSmallSupport(),
							new SurfaceGrassland(b[i].topBlock, b[i].fillerBlock, Blocks.stone, Blocks.cobblestone)
						),
						BiomeCategory.SMALL
					);
				}
			}
		}
	}
}
