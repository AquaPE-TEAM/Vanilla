package ru.onewearf.aquape.module.donate.command.economy;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import ru.onewearf.aquape.module.donate.Donate;

public class CoinsCommand extends Command {
    private final Donate donate;

    public CoinsCommand(Donate donate) {
        super("coins", "§r§aПосмотреть баланс коинов");
        this.donate = donate;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (commandSender instanceof Player) {
            int result = this.donate.seeCoin(commandSender.getName());
            if (result == -1) {
                commandSender.sendMessage("§aКоины §7• §fК сожалению, у тебя нет §aКоинов§f!");
                commandSender.sendMessage("§aКоины §7• §fКупить можно их нашем сайте: shop.aqua-pe.ru");
            } else {
                commandSender.sendMessage("§aКоины §7• §fВаш баланс: " + this.donate.seeCoin(commandSender.getName()));
            }
            return false;
        }
        return true;
    }
}
