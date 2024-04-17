package ru.onewearf.aquape.module.main.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import ru.onewearf.aquape.utils.Utils;

public class TestCommand extends Command {

    public TestCommand(){
        super("test", "Проверка команды");
    }
    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        Player player = (Player) commandSender;
        new Utils().createNBT(player.getLocation(), "Тест", 1);
        return false;
    }
}
