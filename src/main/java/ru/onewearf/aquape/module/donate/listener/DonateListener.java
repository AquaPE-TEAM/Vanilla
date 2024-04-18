package ru.onewearf.aquape.module.donate.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import ru.onewearf.aquape.module.donate.Donate;

public class DonateListener implements Listener {

    private final Donate donate;

    public DonateListener(Donate donate){
        this.donate = donate;
    }

    @EventHandler
    public void hasPlayerJoin(PlayerJoinEvent event) {
        if (this.donate.seeCoin(event.getPlayer().getName()) == -1) {
            this.donate.setCoin(event.getPlayer().getName(), 0);
        }
    }
}
