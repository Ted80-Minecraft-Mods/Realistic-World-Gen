package rwg;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;

import rwg.biomes.base.BaseBiomes;
import rwg.commands.RwgBugInfoCommand;
import rwg.commands.RwgNoiseCommand;
import rwg.config.ConfigRWG;
import rwg.data.VillageMaterials;
import rwg.handlers.LoginHandler;
import rwg.support.Support;
import rwg.world.WorldTypeRealistic;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = "RWG", name = "RealisticWorldGen", version = "GRADLETOKEN_VERSION", acceptableRemoteVersions = "*")
public class RWG {

    @Instance("RWG")
    public static RWG instance;

    public static final WorldTypeRealistic worldtype = (new WorldTypeRealistic("RWG"));

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        instance = this;

        ConfigRWG.init(event);
        BaseBiomes.load();

        MinecraftForge.TERRAIN_GEN_BUS.register(new VillageMaterials());

        FMLCommonHandler.instance().bus().register(new LoginHandler());
        // MinecraftForge.TERRAIN_GEN_BUS.register(new TreeReplacement());
    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {}

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Support.init();
    }

    @EventHandler
    public void serverStart(FMLServerStartingEvent event) {
        MinecraftServer server = event.getServer();
        ICommandManager command = server.getCommandManager();
        ServerCommandManager manager = (ServerCommandManager) command;

        manager.registerCommand(new RwgNoiseCommand());
        manager.registerCommand(new RwgBugInfoCommand());
    }
}
