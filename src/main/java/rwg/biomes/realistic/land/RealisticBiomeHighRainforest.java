package rwg.biomes.realistic.land;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import rwg.api.RWGBiomes;
import rwg.biomes.realistic.RealisticBiomeBase;
import rwg.deco.trees.DecoJungleFat;
import rwg.surface.SurfaceBase;
import rwg.surface.SurfaceGrassland;
import rwg.terrain.TerrainBase;
import rwg.terrain.TerrainHighland;
import rwg.util.CellNoise;
import rwg.util.PerlinNoise;

public class RealisticBiomeHighRainforest extends RealisticBiomeBase
{
	private TerrainBase terrain;
	private SurfaceBase surface;
	
	public RealisticBiomeHighRainforest()
	{
		super(0, RWGBiomes.baseJungle);
		
		terrain = new TerrainHighland(0f, 140f, 68f, 200f);
		surface = new SurfaceGrassland(Blocks.grass, Blocks.dirt, Blocks.stone, Blocks.cobblestone);
	}


    public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
    {
    	if(rand.nextInt((int)(1f / strength)) == 0) 
		{
			int j6 = chunkX + 8;//12 + rand.nextInt(8);
			int k10 = chunkY + 8;//12 + rand.nextInt(8);
			int z52 = world.getHeightValue(j6, k10);
	
			WorldGenerator worldgenerator = new DecoJungleFat(Blocks.log, 3, Blocks.sponge, 7, 15 + rand.nextInt(15), 4 + rand.nextInt(2), 14f, 3, 0.2f, 0.25f);
			worldgenerator.setScale(1.0D, 1.0D, 1.0D);
			worldgenerator.generate(world, rand, j6, z52, k10);
		}
    }
    
    public float rNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
    {
    	return terrain.generateNoise(perlin, cell, x, y, ocean, border, river);
    }
    
    public void rReplace(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
    {
    	surface.paintTerrain(blocks, metadata, i, j, x, y, depth, world, rand, perlin, cell, noise, river, base);
    }
}
