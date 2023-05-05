package rwg.biomes.base;

import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;

public class BaseBiomeRedwood extends BiomeGenBase {

    public BaseBiomeRedwood(int id, String bn) {
        super(id);
        setTemperatureRainfall(0.7f, 0.6f);
        setBiomeName(bn);
        spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 8, 1, 2));
        spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityHorse.class, 3, 2, 3));
    }
}
