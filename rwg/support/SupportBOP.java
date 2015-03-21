package rwg.support;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import rwg.api.RWGBiomes;
import rwg.support.edit.*;
import rwg.surface.*;
import rwg.surface.river.SurfaceRiverOasis;
import rwg.terrain.*;
import biomesoplenty.api.content.BOPCBiomes;
import rwg.support.Support.BiomeCategory;

public class SupportBOP 
{
	public static void init()
	{
		//ALPS
		/*Support.biomes_snow.add(
			new RealisticBiomeSupport(
				BOPCBiomes.alps,
				new TerrainMountainRiver(),
				new SurfaceMountainSnow(Blocks.grass, Blocks.dirt, false, null, 0.45f)
			)
		);*/
		
		//ARCTIC
		/*Support.biomes_snow.add(
			new RealisticBiomeSupport(
				BOPCBiomes.arctic,
				new TerrainMountainRiver(),
				new SurfaceMountainSnow(Blocks.grass, Blocks.dirt, false, null, 0.45f)
			)
		);*/
		
		//BAMBOO FOREST
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.bambooForest, RWGBiomes.baseRiverWet,
				new TerrainSwampMountain(135f, 300f),
				new SurfaceMountainStone(BOPCBiomes.bambooForest.topBlock, BOPCBiomes.bambooForest.fillerBlock, false, null, 0.95f)
			),
			BiomeCategory.WET
		);
		
		//BAYOU
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.bayou, RWGBiomes.baseRiverWet,
				new TerrainSwampRiver(),
				new SurfaceGrassland(BOPCBiomes.bayou.topBlock, BOPCBiomes.bayou.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.WET
		);
		
		//BOG
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.bog, RWGBiomes.baseRiverHot,
				new TerrainMarsh(),
				new SurfaceGrassland(BOPCBiomes.bog.topBlock, BOPCBiomes.bog.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.HOT
		);
		
		//BOREAL FOREST
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.borealForest, RWGBiomes.baseRiverCold,
				new TerrainMountainSpikes(),
				new SurfaceMountainSnow(BOPCBiomes.borealForest.topBlock, BOPCBiomes.borealForest.fillerBlock, true, Blocks.sand, 0.45f, 1.5f, 60f, 65f, 0.4f, 130f, 50f, 1.5f)
			),
			BiomeCategory.COLD
		);
		
		//BRUSHLAND
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.brushland, RWGBiomes.baseRiverHot,
				new TerrainGrasslandHills(90f, 180f, 13f, 100f, 38f, 260f, 71f),
				new SurfaceGrasslandMix1(BOPCBiomes.brushland.topBlock, BOPCBiomes.brushland.fillerBlock, Blocks.sand, Blocks.stone, Blocks.cobblestone, 13f, 0.27f)
			),
			BiomeCategory.HOT
		);
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.brushland, RWGBiomes.baseRiverOasis,
				new TerrainDuneValley(300f),
				new SurfaceBase[]{
					new SurfaceDuneValley(BOPCBiomes.brushland.topBlock, BOPCBiomes.brushland.fillerBlock, 300f, false, true),
					new SurfaceRiverOasis(),
				},
				new EditBase[]{
					new EditRiverOasis()
				}
			),
			BiomeCategory.HOT
		);
		
		//CANYON
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.canyon, RWGBiomes.baseRiverHot,
				new TerrainCanyon(true, 35f, 160f, 60f, 40f, 69f),
				new SurfaceCanyon(BOPCBiomes.canyon.topBlock, BOPCBiomes.canyon.fillerBlock, (byte)0, 0)
			),
			BiomeCategory.HOT
		);
		
		//CHAPARRAL
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.chaparral, RWGBiomes.baseRiverHot,
				new TerrainGrasslandHills(90f, 180f, 13f, 100f, 38f, 260f, 71f),
				new SurfaceGrasslandMix1(BOPCBiomes.chaparral.topBlock, BOPCBiomes.chaparral.fillerBlock, Blocks.sand, Blocks.stone, Blocks.cobblestone, 26f, 0.35f)
			),
			BiomeCategory.HOT
		);
		
		//CHERRYBLOSSOM GROVE
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.cherryBlossomGrove, RWGBiomes.baseRiverTemperate,
				new TerrainHighland(6f, 120f, 65f, 200f),
				new SurfaceMountainStone(BOPCBiomes.borealForest.topBlock, BOPCBiomes.borealForest.fillerBlock, true, Blocks.sand, 0.45f, 1.5f, 60f, 65f, 1.5f)
			),
			BiomeCategory.COLD
		);
		
		//CONIFEROUS FOREST
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.coniferousForest, RWGBiomes.baseRiverCold,
				new TerrainMountainRiver(),
				new SurfaceMountainSnow(Blocks.grass, Blocks.dirt, false, null, 0.45f)
			),
			BiomeCategory.COLD
		);
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.snowyConiferousForest, RWGBiomes.baseRiverIce,
				new TerrainMountainRiver(),
				new SurfaceMountainSnow(Blocks.grass, Blocks.dirt, false, null, 0.45f, 1.5f, 50f, 60f, 0.4f, 100f, 50f, 1.5f)
			),
			BiomeCategory.SNOW
		);
		
		//CRAG
		/*Support.biomes_cold.add(
			new RealisticBiomeSupport(
				BOPCBiomes.crag,
				new TerrainCanyon(false, new float[]{2.0f, 0.5f, 6.5f, 0.5f, 14.0f, 0.5f, 19.0f, 0.5f}, 35f, 80f, 60f, 40f, 69f),
				new SurfaceGrassland(BOPCBiomes.crag.topBlock, BOPCBiomes.crag.fillerBlock, Blocks.stone, Blocks.cobblestone)
			)
		);*/
		
		//DEAD FOREST
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.deadForest, RWGBiomes.baseRiverTemperate,
				new TerrainGrasslandHills(50f, 180f, 13f, 100f, 28f, 260f, 70f),
				new SurfaceGrassland(BOPCBiomes.deadForest.topBlock, BOPCBiomes.deadForest.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.COLD
		);
		
		//DEAD SWAMP
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.deadSwamp, RWGBiomes.baseRiverWet,
				new TerrainMarsh(),
				new SurfaceGrassland(BOPCBiomes.deadSwamp.topBlock, BOPCBiomes.deadSwamp.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.WET
		);
		
		//DECIDUOUS FOREST
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.deciduousForest, RWGBiomes.baseRiverHot,
				new TerrainHighland(0f, 140f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.deciduousForest.topBlock, BOPCBiomes.deciduousForest.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.HOT
		);
		
		//FEN
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.fen, RWGBiomes.baseRiverHot,
				new TerrainHighland(0f, 140f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.fen.topBlock, BOPCBiomes.fen.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.HOT
		);
		
		//FLOWER FIELD
		/*Support.biomes_hot.add(
			new RealisticBiomeSupport(
				BOPCBiomes.flowerField,
				new TerrainGrasslandHills(40f, 180f, 13f, 100f, 28f, 260f, 70f),
				new SurfaceGrassland(BOPCBiomes.flowerField.topBlock, BOPCBiomes.flowerField.fillerBlock, Blocks.stone, Blocks.cobblestone)
			)
		);*/
		
		//FROST FOREST
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.frostForest, RWGBiomes.baseRiverIce,
				new TerrainHighland(0f, 140f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.frostForest.topBlock, BOPCBiomes.frostForest.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.SNOW
		);
		
		//FUNGI FOREST
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.fungiForest, RWGBiomes.baseRiverWet,
				new TerrainSwampMountain(135f, 300f),
				new SurfaceMountainStone(BOPCBiomes.fungiForest.topBlock, BOPCBiomes.fungiForest.fillerBlock, false, null, 0.95f)
			),
			BiomeCategory.WET
		);
		
		//GARDEN
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.garden, RWGBiomes.baseRiverTemperate,
				new TerrainMountainSpikes(),
				new SurfaceMountainSnow(BOPCBiomes.garden.topBlock, BOPCBiomes.garden.fillerBlock, true, Blocks.sand, 0.45f, 1.5f, 60f, 65f, 0.4f, 130f, 50f, 1.5f)
			),
			BiomeCategory.COLD
		);
		
		//GRASSLAND
		/*Support.biomes_cold.add(
			new RealisticBiomeSupport(
				BOPCBiomes.grassland,
				new TerrainGrasslandHills(47f, 180f, 13f, 100f, 28f, 260f, 70f),
				new SurfaceGrassland(BOPCBiomes.grassland.topBlock, BOPCBiomes.grassland.fillerBlock, Blocks.stone, Blocks.cobblestone)
			)
		);*/
		
		//GROVE
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.grove, RWGBiomes.baseRiverTemperate,
				new TerrainHighland(0f, 140f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.grove.topBlock, BOPCBiomes.grove.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.COLD
		);
		
		//HEATHLAND
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.heathland, RWGBiomes.baseRiverOasis,
				new TerrainDuneValley(300f),
				new SurfaceBase[]{
					new SurfaceDuneValley(BOPCBiomes.brushland.topBlock, BOPCBiomes.brushland.fillerBlock, 300f, false, true) ,
					new SurfaceRiverOasis(),
				},
				new EditBase[]{
					new EditRiverOasis()
				}
			),
			BiomeCategory.HOT
		);
		
		//HIGHLAND
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.highland, RWGBiomes.baseRiverTemperate,
				new TerrainHighland(0f, 140f, 68f, 150f),
				new SurfaceMountainStone(BOPCBiomes.highland.topBlock, BOPCBiomes.highland.fillerBlock, false, null, 1f, 1.5f, 85f, 20f, 4f)
			),
			BiomeCategory.COLD
		);
		
		//JADE CLIFFS
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.jadeCliffs, RWGBiomes.baseRiverHot,
				new TerrainHilly(230f, 120f, 0f),
				new SurfaceMountainStone(BOPCBiomes.jadeCliffs.topBlock, BOPCBiomes.jadeCliffs.fillerBlock, false, null, 0.95f)
			),
			BiomeCategory.HOT
		);
		
		//LAVENDER FIELDS
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.lavenderFields, RWGBiomes.baseRiverTemperate,
				new TerrainMountainSpikes(),
				new SurfaceMountainStone(BOPCBiomes.lavenderFields.topBlock, BOPCBiomes.lavenderFields.fillerBlock, false, null, 1.2f)
			),
			BiomeCategory.COLD
		);
		
		//LUSH DESERT
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.lushDesert, RWGBiomes.baseRiverHot,
				new TerrainGrasslandHills(90f, 180f, 13f, 100f, 38f, 260f, 71f),
				new SurfaceGrassland(BOPCBiomes.lushDesert.topBlock, BOPCBiomes.lushDesert.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.HOT
		);
		
		//LUSH SWAMP
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.lushSwamp, RWGBiomes.baseRiverWet,
				new TerrainSwampRiver(),
				new SurfaceGrassland(BOPCBiomes.lushSwamp.topBlock, BOPCBiomes.lushSwamp.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.WET
		);
		
		//MAPLE WOODS
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.mapleWoods, RWGBiomes.baseRiverTemperate,
				new TerrainHighland(0f, 140f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.mapleWoods.topBlock, BOPCBiomes.mapleWoods.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.COLD
		);
		
		//MARSH
		/*Support.biomes_cold.add(
			new RealisticBiomeSupport(
				BOPCBiomes.marsh,
				new TerrainMarsh(),
				new SurfaceGrassland(BOPCBiomes.marsh.topBlock, BOPCBiomes.marsh.fillerBlock, Blocks.stone, Blocks.cobblestone)
			)
		);*/
		
		//MEADOW
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.meadow, RWGBiomes.baseRiverTemperate,
				new TerrainMountainSpikes(),
				new SurfaceMountainStone(BOPCBiomes.meadow.topBlock, BOPCBiomes.meadow.fillerBlock, false, null, 1.2f)
			),
			BiomeCategory.COLD
		);
		
		//MOOR
		/*Support.biomes_wet.add(
			new RealisticBiomeSupport(
				BOPCBiomes.moor,
				new TerrainHighland(0f, 70f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.moor.topBlock, BOPCBiomes.moor.fillerBlock, Blocks.stone, Blocks.cobblestone)
			)
		);*/
		
		//MOUNTAIN
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.mountain, RWGBiomes.baseRiverHot,
				new TerrainMountainRiver(),
				new SurfaceMountainStone(BOPCBiomes.mountain.topBlock, BOPCBiomes.mountain.fillerBlock, true, Blocks.sand, 0.75f)
			),
			BiomeCategory.HOT
		);
		
		//MYSTIC GROVE
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.mysticGrove, RWGBiomes.baseRiverWet,
				new TerrainHighland(0f, 140f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.mysticGrove.topBlock, BOPCBiomes.mysticGrove.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.WET
		);
		
		//OMINOUS WOODS
		/*Support.biomes_cold.add(
			new RealisticBiomeSupport(
				BOPCBiomes.ominousWoods,
				new TerrainHighland(0f, 140f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.ominousWoods.topBlock, BOPCBiomes.ominousWoods.fillerBlock, Blocks.stone, Blocks.cobblestone)
			)
		);*/
		
		//ORIGIN VALLEY
		/*Support.biomes_cold.add(
			new RealisticBiomeSupport(
				BOPCBiomes.originValley,
				new TerrainHighland(10f, 80f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.originValley.topBlock, BOPCBiomes.originValley.fillerBlock, Blocks.stone, Blocks.cobblestone)
			)
		);*/
		
		//OUTBACK
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.outback, RWGBiomes.baseRiverOasis,
				new TerrainDuneValley(300f),
				new SurfaceBase[]{
					new SurfaceDuneValley(BOPCBiomes.outback.topBlock, BOPCBiomes.outback.fillerBlock, 300f, false, false),
					new SurfaceRiverOasis(),
				},
				new EditBase[]{
					new EditRiverOasis()
				}
			),
			BiomeCategory.HOT
		);
		
		//PRAIRIE
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.prairie, RWGBiomes.baseRiverHot,
				new TerrainGrasslandHills(90f, 180f, 13f, 100f, 38f, 260f, 71f),
				new SurfaceGrassland(BOPCBiomes.prairie.topBlock, BOPCBiomes.prairie.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.HOT
		);
		
		//RAINFOREST
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.rainforest, RWGBiomes.baseRiverWet,
				new TerrainSwampMountain(120f, 300f),
				new SurfaceMountainStone(BOPCBiomes.rainforest.topBlock, BOPCBiomes.rainforest.fillerBlock, false, null, 1.3f)
			),
			BiomeCategory.WET
		);
		
		//REDWOOD FOREST
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.redwoodForest, RWGBiomes.baseRiverTemperate,
				new TerrainGrasslandHills(80f, 180f, 13f, 100f, 38f, 260f, 71f),
				new SurfaceMountainStone(BOPCBiomes.redwoodForest.topBlock, BOPCBiomes.redwoodForest.fillerBlock, false, null, 0.4f)
			),
			BiomeCategory.COLD
		);
		
		//SACRED SPRINGS
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.sacredSprings, RWGBiomes.baseRiverWet,
				new TerrainHighland(0f, 120f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.sacredSprings.topBlock, BOPCBiomes.sacredSprings.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.WET
		);
		
		//SEASONAL FOREST
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.seasonalForest, RWGBiomes.baseRiverTemperate,
				new TerrainHighland(0f, 140f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.seasonalForest.topBlock, BOPCBiomes.seasonalForest.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.COLD
		);
		
		//SHIELD
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.shield, RWGBiomes.baseRiverCold,
				new TerrainGrasslandHills(90f, 180f, 13f, 100f, 38f, 260f, 71f),
				new SurfaceGrassland(BOPCBiomes.shield.topBlock, BOPCBiomes.shield.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.COLD
		);
		
		//SHRUBLAND
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.shrubland, RWGBiomes.baseRiverHot,
				new TerrainGrasslandHills(90f, 180f, 13f, 100f, 38f, 260f, 71f),
				new SurfaceGrassland(BOPCBiomes.shrubland.topBlock, BOPCBiomes.shrubland.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.HOT
		);
		
		//SLUDGEPIT
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.sludgepit, RWGBiomes.baseRiverWet,
				new TerrainMarsh(),
				new SurfaceGrassland(BOPCBiomes.sludgepit.topBlock, BOPCBiomes.sludgepit.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.WET
		);
		
		//STEPPE
		/*Support.biomes_hot.add(
			new RealisticBiomeSupport(
				BOPCBiomes.steppe,
				new TerrainGrasslandHills(70f, 180f, 13f, 100f, 38f, 260f, 71f),
				new SurfaceGrassland(BOPCBiomes.steppe.topBlock, BOPCBiomes.steppe.fillerBlock, Blocks.stone, Blocks.cobblestone)
			)
		);*/
		
		//TEMPERATE RAINFOREST
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.temperateRainforest, RWGBiomes.baseRiverWet,
				new TerrainMountainRiver(),
				new SurfaceMountainStone(BOPCBiomes.temperateRainforest.topBlock, BOPCBiomes.temperateRainforest.fillerBlock, false, null, 0.45f)
			),
			BiomeCategory.WET
		);
		
		//THICKET
		/*Support.biomes_hot.add(
			new RealisticBiomeSupport(
				BOPCBiomes.thicket,
				new TerrainGrasslandHills(70f, 180f, 13f, 100f, 38f, 260f, 71f),
				new SurfaceGrassland(BOPCBiomes.thicket.topBlock, BOPCBiomes.thicket.fillerBlock, Blocks.stone, Blocks.cobblestone)
			)
		);*/
		
		//TROPICAL RAINFOREST
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.tropicalRainforest, RWGBiomes.baseRiverWet,
				new TerrainHighland(0f, 140f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.tropicalRainforest.topBlock, BOPCBiomes.tropicalRainforest.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.WET
		);
		
		//TUNDRA
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.tundra, RWGBiomes.baseRiverIce,
				new TerrainGrasslandHills(90f, 180f, 13f, 100f, 38f, 260f, 71f),
				new SurfaceGrassland(BOPCBiomes.tundra.topBlock, BOPCBiomes.tundra.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.SNOW
		);
		
		//WASTELAND
		/*Support.biomes_hot.add(
			new RealisticBiomeSupport(
				BOPCBiomes.wasteland,
				new TerrainHighland(10f, 80f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.wasteland.topBlock, BOPCBiomes.wasteland.fillerBlock, Blocks.stone, Blocks.cobblestone)
			)
		);*/
		
		//WETLAND
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.wetland, RWGBiomes.baseRiverWet,
				new TerrainMarsh(),
				new SurfaceGrassland(BOPCBiomes.wetland.topBlock, BOPCBiomes.wetland.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.WET
		);
		
		//WOODLAND
		Support.addBiome(
			new RealisticBiomeSupport(
				BOPCBiomes.woodland, RWGBiomes.baseRiverTemperate,
				new TerrainHighland(0f, 140f, 68f, 200f),
				new SurfaceGrassland(BOPCBiomes.woodland.topBlock, BOPCBiomes.woodland.fillerBlock, Blocks.stone, Blocks.cobblestone)
			),
			BiomeCategory.COLD
		);
	}
}
