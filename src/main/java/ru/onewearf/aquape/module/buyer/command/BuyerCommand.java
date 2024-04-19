package ru.onewearf.aquape.module.buyer.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import ru.onewearf.aquape.module.buyer.forms.MainForm;
import ru.onewearf.aquape.module.buyer.utils.Utils;

public class BuyerCommand extends Command {
    public BuyerCommand() {
        super("buyer", "§r§aОткрыть скупщика");
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if(commandSender instanceof Player){
            new MainForm().mainForm((Player) commandSender);
            return false;
        }
        return false;
    }
}
