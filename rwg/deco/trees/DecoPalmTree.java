package rwg.deco.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DecoPalmTree extends WorldGenerator
{
	private static int leavesLength = 133;
	private static int[] leaves = new int[]{
		1, 0, 0,
		2, 0, 0,
		3, -1, 0,
		3, -2, 0,
		-1, 0, 0,
		-2, 0, 0,
		-3, -1, 0,
		-3, -2, 0,
		0, 0, 1,
		0, 0, 2,
		0, -1, 3,
		0, -2, 3,	
		0, 0, -1,
		0, 0, -2,
		0, -1, -3,
		0, -2, -3,	
		0, 1, 0,
		1, 1, 1,
		-1, 1, -1,
		-1, 1, 1,
		1, 1, -1,
		1, 2, 0,
		-1, 2, 0,
		0, 2, 1, 
		0, 2, -1,
		2, 3, 0,
		3, 3, 0,
		4, 2, 0, 
		-2, 3, 0,
		-3, 3, 0,
		-4, 2, 0, 
		0, 3, 2,
		0, 3, 3,
		0, 2, 4, 
		0, 3, -2,
		0, 3, -3,
		0, 2, -4, 
		2, 2, -2,
		-2, 2, 2,
		-2, 2, -2, 
		2, 2, 2,
		3, 2, -3,
		-3, 2, 3,
		-3, 2, -3, 
		3, 2, 3
	};

	private static int cocoasLength = 16;
	private static int[] cocoas = new int[]{
		2, 0, -2, 1,
		1, 1, -2, 0,
		0, 0, -2, -1,
		3, -1, -2, 0
	};
	
	private int height;
	private boolean sand;
	
	public DecoPalmTree(int h)
	{
		this(h, true);
	}
	
	public DecoPalmTree(int h, boolean s)
	{
		height = h;
		sand = s;
	}

    public boolean generate(World world, Random rand, int x, int y, int z)
    {
    	Block b = world.getBlock(x, y - 1, z);
    	if((b != Blocks.grass && b != Blocks.dirt && b != Blocks.sand) || (b == Blocks.sand && !sand))
    	{
    		return false;
    	}
    	
    	createTrunk(world, rand, x, y, z);
    	for(int i = 0; i <= height; i++)
    	{
    		world.setBlock(x, y + i, z, Blocks.log, 3, 0);
    	}
    	
    	for(int j = 0; j < leavesLength; j+=3)
    	{
    		world.setBlock(x + leaves[j], y + height + leaves[j + 1], z + leaves[j + 2], Blocks.leaves, 3, 0);
    	}
    	
    	for(int k = 0; k < cocoasLength; k+=4)
    	{
    		if(rand.nextInt(20) == 0)
    		{
    			world.setBlock(x + cocoas[k + 1], y + height + cocoas[k + 2], z + cocoas[k + 3], Blocks.cocoa, cocoas[k + 0] + 8, 0);
    		}
    	}
    	
        return true;
    }
    
    private void createTrunk(World world, Random rand, int x, int y, int z)
    {
    	int[] pos = new int[]{0,0, 1,0, 0,1, -1,0, 0,-1};
    	int sh;
    	for(int t = 0; t < 5; t++)
    	{    	
    		sh = rand.nextInt(3) + y;
    		while(sh > y - 3)
    		{
    			if(world.getBlock(x + pos[t * 2], sh, z + pos[t * 2 + 1]) == Blocks.dirt)
    			{
    				break;
    			}
    			world.setBlock(x + pos[t * 2], sh, z + pos[t * 2 + 1], Blocks.log, 15, 0);
    			sh--;
    		}
    	}
    }
}