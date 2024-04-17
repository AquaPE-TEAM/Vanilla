package ru.onewearf.aquape.module.main.listener;

import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerCreationEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import me.iwareq.scoreboard.Scoreboard;
import ru.onewearf.aquape.player.AquaPlayer;
import ru.onewearf.aquape.utils.Utils;
import net.lldv.llamaeconomy.LlamaEconomy;

import static me.iwareq.scoreboard.packet.data.DisplaySlot.SIDEBAR;

public class EventListener implements Listener {

    @EventHandler
    public void hasPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage("");
        new Utils().handleToast(event.getPlayer(), "\uE100\uE101\uE102\uE103 \uE104\uE105", "§7Добро пожаловать на сервер - §c" + event.getPlayer().getName());
        Scoreboard scoreboard = new Scoreboard("§g§aмопсикдаун", SIDEBAR, 20);
        scoreboard.setHandler(plc -> {
            scoreboard.addLine("§7Ник: §b" + plc.getName());
            scoreboard.addLine("§7Онлайн: §b" + Server.getInstance().getOnlinePlayers().size());
            scoreboard.addLine("§7Баланс: §a" + LlamaEconomy.getAPI().getMoney(event.getPlayer()));
        });
        scoreboard.show(event.getPlayer());

        if(!event.getPlayer().hasPlayedBefore()) {
            event.getPlayer().setSpawn(new Utils().rtp());
            event.getPlayer().teleport(new Utils().rtp());
        }

        if(!event.getPlayer().getLoginChainData().isXboxAuthed()){
            event.getPlayer().kick("§7Для игры на сервере вам необходимо быть авторизованым в §aXBOX LIVE", false);
        }
    }

    @EventHandler
    public void hasPlayerCreation(PlayerCreationEvent event){
        event.setPlayerClass(AquaPlayer.class);
    }
}
