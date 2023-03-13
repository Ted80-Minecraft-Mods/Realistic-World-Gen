package rwg.commands;

import java.util.Locale;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatComponentTranslation;

import rwg.util.NoiseGeneratorWrapper;
import rwg.util.NoiseImplementation;
import rwg.world.RwgWorldSavedData;

public class RwgNoiseCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "rwg_noise";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/rwg_noise get|opensimplex|perlin";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {

        if (args.length < 1) {
            throw new WrongUsageException(this.getCommandUsage(sender));
        }

        NoiseImplementation current = RwgWorldSavedData.getNoiseImplementation();

        if (args[0].equals("get")) {
            sender.addChatMessage(new ChatComponentTranslation("rwg.noise.current_type", current));
            return;
        }

        NoiseImplementation noiseImplementation = NoiseImplementation.valueOf(args[0].toUpperCase(Locale.ROOT));
        final boolean wasDynamic;
        switch (current) {
            case UNKNOWN:
            case DYNAMICPERLIN:
            case DYNAMICOPENSIMPLEX:
                wasDynamic = true;
                break;
            case PERLIN:
            case OPENSIMPLEX:
                wasDynamic = false;
                break;
            default:
                throw new IllegalStateException(
                        "Invalid current noise implementation value: " + noiseImplementation.toString());
        }

        if (current != noiseImplementation) {
            switch (noiseImplementation) {
                case UNKNOWN:
                    NoiseGeneratorWrapper.useOpenSimplex = false;
                    sender.addChatMessage(new ChatComponentTranslation("rwg.noise.was_set_to.unknown"));
                    break;
                case DYNAMICPERLIN:
                case PERLIN:
                    NoiseGeneratorWrapper.useOpenSimplex = false;
                    sender.addChatMessage(
                            new ChatComponentTranslation(
                                    "rwg.noise.was_set_to.generic",
                                    noiseImplementation.toString()));
                    break;
                case DYNAMICOPENSIMPLEX:
                case OPENSIMPLEX:
                    NoiseGeneratorWrapper.useOpenSimplex = true;
                    sender.addChatMessage(
                            new ChatComponentTranslation(
                                    "rwg.noise.was_set_to.generic",
                                    noiseImplementation.toString()));
                    break;
            }
            if (wasDynamic) {
                sender.addChatMessage(new ChatComponentTranslation("rwg.noise.instant_new_chunks"));
            } else {
                sender.addChatMessage(new ChatComponentTranslation("rwg.noise.needs_restart"));
            }
        } else {
            sender.addChatMessage(new ChatComponentTranslation("rwg.noise.unchanged"));
        }

        RwgWorldSavedData.setNoiseImplementation(noiseImplementation);
    }
}
