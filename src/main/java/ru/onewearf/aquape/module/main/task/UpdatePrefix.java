package ru.onewearf.aquape.module.main.task;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.scheduler.Task;
import ru.onewearf.aquape.module.main.Main;

public class UpdatePrefix extends Task {

    private final Main main;

    public UpdatePrefix(Main main){
        this.main = main;
    }
    @Override
    public void onRun(int i) {
        for (Player player : Server.getInstance().getOnlinePlayers().values()){
            player.setNameTag(this.main.getPrefix(player) + " §7" + player.getName());
        }
    }
}
