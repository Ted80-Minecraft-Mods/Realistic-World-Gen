package rwg.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class RwgBugInfoCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "rwg_buginfo";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/rwg_buginfo";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) {
        for (int line = 1; line <= 5; line++) {
            iCommandSender.addChatMessage(new ChatComponentTranslation("rwg.buginfo.line" + line));
        }

        iCommandSender.addChatMessage(new ChatComponentText("/rwg_noise perlin")
                .setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD))
                .appendSibling(new ChatComponentTranslation("rwg.buginfo.perlin")
                        .setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RESET))));
        iCommandSender.addChatMessage(new ChatComponentText("/rwg_noise opensimplex")
                .setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD))
                .appendSibling(new ChatComponentTranslation("rwg.buginfo.opensimplex")
                        .setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RESET))));
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
