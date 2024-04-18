package ru.onewearf.aquape.module.donate.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import ru.onewearf.aquape.module.donate.Donate;
import ru.onewearf.aquape.module.donate.utils.Utils;

public class DonateCommand extends Command {
    private final Donate coins;

    public DonateCommand(Donate donate) {
        super("donate", "§rОткрыть магазин за коины");
        this.coins = donate;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if(commandSender instanceof Player){
            new Utils().openShop((Player) commandSender, this.coins);
        }
        return false;
    }
}
