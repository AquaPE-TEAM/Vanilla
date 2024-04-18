package ru.onewearf.aquape.module.donate.command.economy;

import cn.nukkit.Nukkit;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import ru.onewearf.aquape.module.donate.Donate;

public class giveCoinsCommand extends Command {

    private final Donate donate;
    public giveCoinsCommand(Donate donate) {
        super("givecoins", "§rПосмотреть баланс коинов.");
        this.setPermission("admin.givecoins");
        this.setPermissionMessage("§aКоины §7• §fУ вас недостаточно прав для использования данной команды");
        this.donate = donate;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if(!this.testPermissionSilent(commandSender)){
            return false;
        }

        if (commandSender instanceof Player) {
            int rubCount = Integer.parseInt(strings[1]);
            if (rubCount < 1) {
                commandSender.sendMessage("§aКоины §7• §fКоинов не может быть меньше 1");
                return false;
            }
            if (this.donate.addCoin(strings[0], rubCount)) {
                commandSender.sendMessage("§aКоины §7• §fИгроку §b" + strings[0] + " §7добавлено §b" + rubCount + " §bCoins§f!");
                return false;
            }
            return false;
        }
        return true;
    }
}
