package rwg.config;

import rwg.api.RWGBiomes;
import rwg.biomes.base.BaseBiomeColdForest;
import rwg.biomes.base.BaseBiomeColdPlains;
import rwg.biomes.base.BaseBiomeHotDesert;
import rwg.biomes.base.BaseBiomeHotForest;
import rwg.biomes.base.BaseBiomeHotPlains;
import rwg.biomes.base.BaseBiomeJungle;
import rwg.biomes.base.BaseBiomePlains;
import rwg.biomes.base.BaseBiomeRedwood;
import rwg.biomes.base.BaseBiomeSnowDesert;
import rwg.biomes.base.BaseBiomeSnowForest;
import rwg.biomes.base.BaseBiomeTropicalIsland;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigRWG 
{
	public static Configuration config;
	public static int[] biomeIDs = new int[12];
	
	public static void init(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		
		for(int c = 0; c < biomeIDs.length; c++)
		{
			biomeIDs[c] = 230 + c;
		}
		
		try 
		{
			config.load();
			
			biomeIDs[0] = config.get("Biome IDs", "00 rwg_snowDesert", 230).getInt();
			biomeIDs[1] = config.get("Biome IDs", "01 rwg_snowForest", 231).getInt();
			biomeIDs[2] = config.get("Biome IDs", "02 rwg_coldPlains", 232).getInt();
			biomeIDs[3] = config.get("Biome IDs", "03 rwg_coldForest", 233).getInt();
			biomeIDs[4] = config.get("Biome IDs", "04 rwg_hotPlains", 234).getInt();
			biomeIDs[5] = config.get("Biome IDs", "05 rwg_hotForest", 235).getInt();
			biomeIDs[6] = config.get("Biome IDs", "06 rwg_hotDesert", 236).getInt();
			biomeIDs[7] = config.get("Biome IDs", "07 rwg_plains", 237).getInt();
			biomeIDs[8] = config.get("Biome IDs", "08 rwg_tropical", 238).getInt();
			biomeIDs[9] = config.get("Biome IDs", "09 rwg_redwood", 239).getInt();
			biomeIDs[10] = config.get("Biome IDs", "10 rwg_jungle", 240).getInt();
			biomeIDs[11] = config.get("Biome IDs", "11 rwg_oasis", 241).getInt();
		}
		catch (Exception e) 
		{
			for(int c = 0; c < biomeIDs.length; c++)
			{
				biomeIDs[c] = 230 + c;
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
