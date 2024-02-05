package rwg.config;

import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigRWG {

    public static Configuration config;
    public static int[] biomeIDs = new int[25];

    public static boolean generateEmeralds = true;
    public static boolean enableCobblestoneBoulders = true;
    public static boolean generateCaves = true;
    public static boolean generateMineshafts = true;
    public static boolean generateVillages = true;
    public static boolean generateUndergroundLakes = true;
    public static boolean generateUndergroundLavaLakes = true;

    public static void init(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        for (int c = 0; c < biomeIDs.length; c++) {
            biomeIDs[c] = 200 + c;
        }

        try {
            config.load();
            renameOldProperties();
            biomeIDs[0] = config.get("biome ids", "00 Ice River", 200, "Ice River").getInt();
            biomeIDs[1] = config.get("biome ids", "01 Cold River", 201, "Cold River").getInt();
            biomeIDs[2] = config.get("biome ids", "02 Temperate River", 202, "Temperate River").getInt();
            biomeIDs[3] = config.get("biome ids", "03 Hot River", 203, "Hot River").getInt();
            biomeIDs[4] = config.get("biome ids", "04 Wet River", 204, "Wet River").getInt();
            biomeIDs[5] = config.get("biome ids", "05 River Oasis", 205, "River Oasis").getInt();
            biomeIDs[6] = config.get("biome ids", "06 Ice Ocean", 206, "Ice Ocean").getInt();
            biomeIDs[7] = config.get("biome ids", "07 Cold Ocean", 207, "Cold Ocean").getInt();
            biomeIDs[8] = config.get("biome ids", "08 Temperate Ocean", 208, "Temperate Ocean").getInt();
            biomeIDs[9] = config.get("biome ids", "09 Hot Ocean", 209, "Hot Ocean").getInt();
            biomeIDs[10] = config.get("biome ids", "10 Wet Ocean", 210, "Wet Ocean").getInt();
            biomeIDs[11] = config.get("biome ids", "11 Ocean Oasis", 211, "Ocean Oasis").getInt();
            biomeIDs[12] = config.get("biome ids", "12 Snow Desert", 212, "Snow Desert").getInt();
            biomeIDs[13] = config.get("biome ids", "13 Snow Forest", 213, "Snow Forest").getInt();
            biomeIDs[14] = config.get("biome ids", "14 Cold Plains", 214, "Cold Plains").getInt();
            biomeIDs[15] = config.get("biome ids", "15 Cold Forest", 215, "Cold Forest").getInt();
            biomeIDs[16] = config.get("biome ids", "16 Hot Plains", 216, "Hot Plains").getInt();
            biomeIDs[17] = config.get("biome ids", "17 Hot Forest", 217, "Hot Forest").getInt();
            biomeIDs[18] = config.get("biome ids", "18 Hot Desert", 218, "Hot Desert").getInt();
            biomeIDs[19] = config.get("biome ids", "19 Plains (RWG)", 219, "Plains").getInt();
            biomeIDs[20] = config.get("biome ids", "20 Tropical Island", 220, "Tropical Island").getInt();
            biomeIDs[21] = config.get("biome ids", "21 Redwood", 221, "Redwood").getInt();
            biomeIDs[22] = config.get("biome ids", "22 Jungle (RWG)", 222, "Jungle").getInt();
            biomeIDs[23] = config.get("biome ids", "23 Oasis", 223, "Oasis").getInt();
            biomeIDs[24] = config.get("biome ids", "24 Temperate Forest", 224, "Temperate Forest").getInt();

            generateEmeralds = config.getBoolean("Generate Emeralds", "Settings", true, "");
            enableCobblestoneBoulders = config.getBoolean("Enable Cobblestone Boulders", "Settings", true, "");
            generateCaves = config.getBoolean("Generate Caves", "Settings", true, "");
            generateMineshafts = config.getBoolean("Generate Mineshafts", "Settings", true, "");
            generateVillages = config.getBoolean("Generate Villages", "Settings", true, "");
            generateUndergroundLakes = config.getBoolean("Generate Underground Lakes", "Settings", true, "");
            generateUndergroundLavaLakes = config.getBoolean("Generate Underground Lava Lakes", "Settings", true, "");

        } catch (Exception e) {
            for (int c = 0; c < biomeIDs.length; c++) {
                biomeIDs[c] = 200 + c;
            }
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }

    private static void renameOldProperties() {
        config.renameProperty("biome ids", "00 rwg_riverIce", "00 Ice River");
        config.renameProperty("biome ids", "01 rwg_riverCold", "01 Cold River");
        config.renameProperty("biome ids", "02 rwg_riverTemperate", "02 Temperate River");
        config.renameProperty("biome ids", "03 rwg_riverHot", "03 Hot River");
        config.renameProperty("biome ids", "04 rwg_riverWet", "04 Wet River");
        config.renameProperty("biome ids", "05 rwg_riverOasis", "05 River Oasis");
        config.renameProperty("biome ids", "06 rwg_oceanIce", "06 Ice Ocean");
        config.renameProperty("biome ids", "07 rwg_oceanCold", "07 Cold Ocean");
        config.renameProperty("biome ids", "08 rwg_oceanTemperate", "08 Temperate Ocean");
        config.renameProperty("biome ids", "09 rwg_oceanHot", "09 Hot Ocean");
        config.renameProperty("biome ids", "10 rwg_oceanWet", "10 Wet Ocean");
        config.renameProperty("biome ids", "11 rwg_oceanOasis", "11 Ocean Oasis");
        config.renameProperty("biome ids", "12 rwg_snowDesert", "12 Snow Desert");
        config.renameProperty("biome ids", "13 rwg_snowForest", "13 Snow Forest");
        config.renameProperty("biome ids", "14 rwg_coldPlains", "14 Cold Plains");
        config.renameProperty("biome ids", "15 rwg_coldForest", "15 Cold Forest");
        config.renameProperty("biome ids", "16 rwg_hotPlains", "16 Hot Plains");
        config.renameProperty("biome ids", "17 rwg_hotForest", "17 Hot Forest");
        config.renameProperty("biome ids", "18 rwg_hotDesert", "18 Hot Desert");
        config.renameProperty("biome ids", "19 rwg_plains", "19 Plains (RWG)");
        config.renameProperty("biome ids", "20 rwg_tropical", "20 Tropical Island");
        config.renameProperty("biome ids", "21 rwg_redwood", "21 Redwood");
        config.renameProperty("biome ids", "22 rwg_jungle", "22 Jungle (RWG)");
        config.renameProperty("biome ids", "23 rwg_oasis", "23 Oasis");
        config.renameProperty("biome ids", "24 rwg_temperateForest", "24 Temperate Forest");
    }
}
