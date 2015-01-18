package rwg.api;

import net.minecraft.world.biome.BiomeGenBase;

public class RWGBiomes 
{
	/*
	 * These biomes are used for grass/foliage color and entity spawning
	 */
	public static BiomeGenBase baseSnowDesert;
	public static BiomeGenBase baseSnowForest;
	public static BiomeGenBase baseColdPlains;
	public static BiomeGenBase baseColdForest;
	public static BiomeGenBase baseHotPlains;
	public static BiomeGenBase baseHotForest;
	public static BiomeGenBase baseHotDesert;
	public static BiomeGenBase basePlains;
	public static BiomeGenBase baseTropicalIsland;
	public static BiomeGenBase baseRedwood;
	public static BiomeGenBase baseJungle;
	public static BiomeGenBase baseOasis;
	
	/*
	 * This function will never break. use this instead of the above.
	 */
	public static BiomeGenBase[] getAllBaseBiomes()
	{
		return new BiomeGenBase[]{
			baseSnowDesert,
			baseSnowForest,
			baseColdPlains,
			baseColdForest,
			baseHotPlains,
			baseHotForest,
			baseHotDesert,
			basePlains,
			baseTropicalIsland,
			baseRedwood,
			baseJungle,
			baseOasis
		};
	}
}
