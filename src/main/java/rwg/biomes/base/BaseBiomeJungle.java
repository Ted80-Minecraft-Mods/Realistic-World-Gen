package rwg.biomes.base;

import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.biome.BiomeGenBase;

public class BaseBiomeJungle extends BiomeGenBase {

    public BaseBiomeJungle(int id, String bn) {
        super(id);
        setTemperatureRainfall(0.9f, 0.9f);
        setBiomeName(bn);

        spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityOcelot.class, 2, 1, 1));
    }
}
