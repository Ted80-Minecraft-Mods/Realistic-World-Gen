package rwg.biomes.realistic;

import java.util.Random;

import rwg.biomes.realistic.land.*;
import rwg.surface.SurfaceBase;
import rwg.terrain.TerrainBase;
import rwg.util.CellNoise;
import rwg.util.PerlinNoise;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class RealisticBiomeBase
{
	private static final RealisticBiomeBase[] biomeList = new RealisticBiomeBase[256];
	private static int nextBiomeID = 0;
	
	public static RealisticBiomeBase test = new RealisticBiomeTest();
	public static RealisticBiomeBase river = new RealisticBiomeTestRiver();
	
	//SNOW 6 =========================================================================================
	public static RealisticBiomeBase polar = new RealisticBiomePolar();
	
	public static RealisticBiomeBase tundraHills = new RealisticBiomeTundraHills();
	public static RealisticBiomeBase tundraPlains = new RealisticBiomeTundraPlains();
	
	public static RealisticBiomeBase snowHills = new RealisticBiomeSnowHills();
	public static RealisticBiomeBase snowRivers = new RealisticBiomeSnowRivers();
	public static RealisticBiomeBase snowLakes = new RealisticBiomeSnowLakes();
	
	public static RealisticBiomeBase redwoodSnow = new RealisticBiomeRedwoodSnow();
	
	//COLD 3 =========================================================================================
	public static RealisticBiomeBase taigaHills = new RealisticBiomeTaigaHills();
	public static RealisticBiomeBase taigaPlains = new RealisticBiomeTaigaPlains();
	
	public static RealisticBiomeBase redwood = new RealisticBiomeRedwood();
	
	//WARM 8 =========================================================================================
	public static RealisticBiomeBase desert;
	public static RealisticBiomeBase desertMountains = new RealisticBiomeDesertMountains();
	
	public static RealisticBiomeBase dunes = new RealisticBiomeDunes();
	public static RealisticBiomeBase dunesForest = new RealisticBiomeDunesForest();
	
	public static RealisticBiomeBase stoneMountains = new RealisticBiomeStoneMountains();
	
	public static RealisticBiomeBase savanna = new RealisticBiomeSavanna();
	public static RealisticBiomeBase savannaForest = new RealisticBiomeSavannaForest();
	public static RealisticBiomeBase savannaDunes = new RealisticBiomeSavannaDunes();
	
	public static RealisticBiomeBase redDesert;
	
	public static RealisticBiomeBase canyon = new RealisticBiomeCanyon();
	public static RealisticBiomeBase canyonForest;
	public static RealisticBiomeBase mesa = new RealisticBiomeMesa();
	
	//WET 0 =========================================================================================
	public static RealisticBiomeBase rainForest;
	public static RealisticBiomeBase jungle;
	public static RealisticBiomeBase jungleFields;
	public static RealisticBiomeBase jungleHills = new RealisticBiomeJungleHills();
	public static RealisticBiomeBase jungleCanyon;
	
	public static RealisticBiomeBase redwoodJungle; //dutch note to self: minder stam meer bladeren en varens
	
	// ==============================================================================================
	
	public final int biomeID;
	public final int subID;
	public final BiomeGenBase baseBiome;
	
	public RealisticBiomeBase(int sub, BiomeGenBase biome)
	{
		biomeID = nextBiomeID;
		biomeList[biomeID] = this;
		nextBiomeID++;
		
		subID = sub;
		baseBiome = biome;
	}
	
	public static RealisticBiomeBase getBiome(int id)
	{
		return biomeList[id];
	}
	
	
	//======================================================================================================================================
	
	
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
    {
    }
    
    public float rNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
    {
    	return 63f;
    }
    
    public void rReplace(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
    {
    	Block b;
		for(int k = 255; k > -1; k--)
		{
			b = blocks[(y * 16 + x) * 256 + k];
            if(b == Blocks.air)
            {
            	depth = -1;
            }
            else if(b == Blocks.stone)
            {
            	depth++;

        		if(depth == 0)
        		{
    				if(k < 62)
    				{
    					blocks[(y * 16 + x) * 256 + k] = Blocks.dirt;
    				}
    				else
    				{
    					blocks[(y * 16 + x) * 256 + k] = Blocks.grass;
    				}
        		}
        		else if(depth < 6)
        		{
        			blocks[(y * 16 + x) * 256 + k] = Blocks.dirt;
        		}
            }
		}
    }
    
    public float r3Dnoise(float z)
    {
    	return 0f;
    }
}
