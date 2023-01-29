package rwg.world;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.MapStorage;
import net.minecraftforge.common.DimensionManager;

import rwg.util.NoiseImplementation;

public class RwgWorldSavedData extends WorldSavedData {

    private static RwgWorldSavedData INSTANCE = null;
    private static final String DATA_NAME = "rwg_data";
    private NoiseImplementation noiseImplementation = rwg.util.NoiseImplementation.UNKNOWN;

    public RwgWorldSavedData() {
        super(DATA_NAME);
    }

    public RwgWorldSavedData(String s) {
        super(s);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        String noiseImplementation = nbtTagCompound.getString("noiseImplementation");

        System.out.println("RWG LOADING DATA - NOISE STRING: " + noiseImplementation);
        try {
            this.noiseImplementation = NoiseImplementation.valueOf(noiseImplementation);
        } catch (IllegalArgumentException e) {
            System.out.println("RWG ERROR LOADING DATA - NOISE IS: " + this.noiseImplementation);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        String noiseString = noiseImplementation.toString();

        System.out.println("RWG SAVING DATA DATA - NOISE: " + noiseImplementation);
        System.out.println("RWG SAVING DATA DATA - NOISE: " + noiseString);
        try {
            nbtTagCompound.setString("noiseImplementation", noiseString);
        } catch (Exception e) {
            System.out.println("RWG ERROR SAVING DATA - NOISE IS: " + this.noiseImplementation);
        }
    }

    static void loadInstance() {
        if (INSTANCE == null) {
            WorldServer world = DimensionManager.getWorld(0);
            if (world == null) return;

            MapStorage storage = world.mapStorage;
            if (storage == null) return;

            INSTANCE = (RwgWorldSavedData) storage.loadData(RwgWorldSavedData.class, DATA_NAME);
            if (INSTANCE == null) {
                INSTANCE = new RwgWorldSavedData();
                storage.setData(DATA_NAME, INSTANCE);
            }
        }
        INSTANCE.markDirty();
    }

    public static void setNoiseImplementation(NoiseImplementation ni) {
        loadInstance();

        System.out.println("RWG SETTING NOISE: " + ni);
        INSTANCE.noiseImplementation = ni;
    }

    public static NoiseImplementation getNoiseImplementation() {
        loadInstance();
        if (INSTANCE == null) {
            System.out.println("RWG COULD NOT LOAD GENERATION DATA - RETURNING UNKNOWN");
            return NoiseImplementation.UNKNOWN;
        }

        return INSTANCE.noiseImplementation;
    }
}
