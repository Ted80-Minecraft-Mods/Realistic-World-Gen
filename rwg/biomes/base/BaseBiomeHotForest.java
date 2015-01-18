package rwg.biomes.base;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;

public class BaseBiomeHotForest extends BiomeGenBase
{
	public BaseBiomeHotForest(int id, String bn) 
	{
		super(id);
		setTemperatureRainfall(0.8f, 0.2f);
		setBiomeName(bn);
		setDisableRain();
	}
	
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int i, int dont, int care)
    {
        return ColorizerGrass.getGrassColor(1f, 0f);
    }

    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor(int i, int dont, int care)
    {
        return ColorizerFoliage.getFoliageColor(0.8f, 0.2f);
    }
}
