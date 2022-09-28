package rwg.biomes.base;

import net.minecraft.world.biome.BiomeGenBase;

public class BaseBiomeTropicalIsland extends BiomeGenBase {
    public BaseBiomeTropicalIsland(int id, String bn) {
        super(id);
        setTemperatureRainfall(0.8f, 0.8f);
        setBiomeName(bn);
    }
}
