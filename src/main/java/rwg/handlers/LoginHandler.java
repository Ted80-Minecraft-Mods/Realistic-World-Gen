package rwg.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class LoginHandler {
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        // TODO: Figure out how to save&detect a brand new world vs. an upgraded world, and display a message
        // conditional on that:

        /*
        if (RwgWorldSavedData.getNoiseImplementation() == NoiseImplementation.UNKNOWN) {
            event.player.addChatMessage(new ChatComponentText(RED
                    + "WARNING: Unable to detect worldgen version for this world. This can cause chunk border mismatch if not corrected. Please run "
                    + GOLD + "/rwg_buginfo" + WHITE + " for info on how to fix."));
        }
         */
    }
}
