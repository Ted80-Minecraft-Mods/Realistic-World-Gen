package rwg.biomes.base;

import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.init.Blocks;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import rwg.data.VillageMaterialData;
import rwg.data.VillageMaterials;

public class BaseBiomeHotPlains extends BiomeGenBase {

    public BaseBiomeHotPlains(int id, String bn) {
        super(id);
        setTemperatureRainfall(0.9f, 0.1f);
        setBiomeName(bn);
        setDisableRain();
        spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityHorse.class, 5, 2, 3));

        VillageMaterialData vmd = new VillageMaterialData(this);
        vmd.plankBlock = Blocks.planks;
        vmd.plankBlockMeta = 4;
        vmd.logBlock = Blocks.log2;
        vmd.logBlockMeta = 0;
        vmd.pathBlock = Blocks.cobblestone;
        vmd.stairsWoodBlock = Blocks.acacia_stairs;
        vmd.slabsBlock = Blocks.fence;
        VillageMaterials.registerVillageMaterial(vmd);
    }

    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int i, int dont, int care) {
        return ColorizerGrass.getGrassColor(1f, 0f);
    }

    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor(int i, int dont, int care) {
        return ColorizerFoliage.getFoliageColor(0.9f, 0.1f);
    }
}
