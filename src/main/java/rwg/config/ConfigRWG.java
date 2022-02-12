package rwg.config;

import rwg.api.RWGBiomes;
import rwg.biomes.base.BaseBiomeColdForest;
import rwg.biomes.base.BaseBiomeColdPlains;
import rwg.biomes.base.BaseBiomeHotDesert;
import rwg.biomes.base.BaseBiomeHotForest;
import rwg.biomes.base.BaseBiomeHotPlains;
import rwg.biomes.base.BaseBiomeJungle;
import rwg.biomes.base.BaseBiomeOcean;
import rwg.biomes.base.BaseBiomePlains;
import rwg.biomes.base.BaseBiomeRedwood;
import rwg.biomes.base.BaseBiomeRiver;
import rwg.biomes.base.BaseBiomeSnowDesert;
import rwg.biomes.base.BaseBiomeSnowForest;
import rwg.biomes.base.BaseBiomeTropicalIsland;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigRWG 
{
	public static Configuration config;
	public static int[] biomeIDs = new int[25];

	public static boolean generateEmeralds = true;
	public static boolean enableCobblestoneBoulders = true;
	
	public static void init(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());

		for(int c = 0; c < biomeIDs.length; c++)
		{
			biomeIDs[c] = 200 + c;
		}
		
		try 
		{
			config.load();
			
			biomeIDs[0] = config.get("Biome IDs", "00 rwg_riverIce", 200).getInt();
			biomeIDs[1] = config.get("Biome IDs", "01 rwg_riverCold", 201).getInt();
			biomeIDs[2] = config.get("Biome IDs", "02 rwg_riverTemperate", 202).getInt();
			biomeIDs[3] = config.get("Biome IDs", "03 rwg_riverHot", 203).getInt();
			biomeIDs[4] = config.get("Biome IDs", "04 rwg_riverWet", 204).getInt();
			biomeIDs[5] = config.get("Biome IDs", "05 rwg_riverOasis", 205).getInt();
			
			biomeIDs[6] = config.get("Biome IDs", "06 rwg_oceanIce", 206).getInt();
			biomeIDs[7] = config.get("Biome IDs", "07 rwg_oceanCold", 207).getInt();
			biomeIDs[8] = config.get("Biome IDs", "08 rwg_oceanTemperate", 208).getInt();
			biomeIDs[9] = config.get("Biome IDs", "09 rwg_oceanHot", 209).getInt();
			biomeIDs[10] = config.get("Biome IDs", "10 rwg_oceanWet", 210).getInt();
			biomeIDs[11] = config.get("Biome IDs", "11 rwg_oceanOasis", 211).getInt();
			
			biomeIDs[12] = config.get("Biome IDs", "12 rwg_snowDesert", 212).getInt();
			biomeIDs[13] = config.get("Biome IDs", "13 rwg_snowForest", 213).getInt();
			biomeIDs[14] = config.get("Biome IDs", "14 rwg_coldPlains", 214).getInt();
			biomeIDs[15] = config.get("Biome IDs", "15 rwg_coldForest", 215).getInt();
			biomeIDs[16] = config.get("Biome IDs", "16 rwg_hotPlains", 216).getInt();
			biomeIDs[17] = config.get("Biome IDs", "17 rwg_hotForest", 217).getInt();
			biomeIDs[18] = config.get("Biome IDs", "18 rwg_hotDesert", 218).getInt();
			biomeIDs[19] = config.get("Biome IDs", "19 rwg_plains", 219).getInt();
			biomeIDs[20] = config.get("Biome IDs", "20 rwg_tropical", 220).getInt();
			biomeIDs[21] = config.get("Biome IDs", "21 rwg_redwood", 221).getInt();
			biomeIDs[22] = config.get("Biome IDs", "22 rwg_jungle", 222).getInt();
			biomeIDs[23] = config.get("Biome IDs", "23 rwg_oasis", 223).getInt();
			biomeIDs[24] = config.get("Biome IDs", "24 rwg_temperateForest", 224).getInt();

			generateEmeralds = config.getBoolean("Generate Emeralds", "Settings", true, "");
			enableCobblestoneBoulders = config.getBoolean("Enable Cobblestone Boulders", "Settings", true, "");
		}
		catch (Exception e) 
		{
			for(int c = 0; c < biomeIDs.length; c++)
			{
				biomeIDs[c] = 200 + c;
			}
		}
		finally 
		{
			if (config.hasChanged()) 
			{
				config.save();
			}
		}
	}
}
