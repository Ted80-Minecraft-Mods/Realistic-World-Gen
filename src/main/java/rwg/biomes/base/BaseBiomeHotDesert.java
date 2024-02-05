package rwg.biomes.base;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import rwg.data.VillageMaterialData;
import rwg.data.VillageMaterials;

public class BaseBiomeHotDesert extends BiomeGenBase {

    public BaseBiomeHotDesert(int id, String bn) {
        super(id);
        setTemperatureRainfall(1f, 0f);
        setBiomeName(bn);
        setDisableRain();
        spawnableCreatureList.clear();

        VillageMaterialData vmd = new VillageMaterialData(this);
        vmd.plankBlock = Blocks.sandstone;
        vmd.plankBlockMeta = 0;
        vmd.logBlock = Blocks.sandstone;
        vmd.logBlockMeta = 0;
        vmd.pathBlock = Blocks.sandstone;
        vmd.stairsWoodBlock = Blocks.sandstone_stairs;
        vmd.slabsBlock = Blocks.fence;
        vmd.cobbleBlock = Blocks.sandstone;
        VillageMaterials.registerVillageMaterial(vmd);
    }
}
