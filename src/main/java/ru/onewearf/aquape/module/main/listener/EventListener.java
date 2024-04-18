package ru.onewearf.aquape.module.main.listener;

import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.player.PlayerCreationEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerLocallyInitializedEvent;
import cn.nukkit.utils.BossBarColor;
import cn.nukkit.utils.DummyBossBar;
import me.iwareq.scoreboard.Scoreboard;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import ru.onewearf.aquape.module.donate.Donate;
import ru.onewearf.aquape.module.main.Main;
import ru.onewearf.aquape.player.AquaPlayer;
import ru.onewearf.aquape.utils.Utils;
import net.lldv.llamaeconomy.LlamaEconomy;

import static me.iwareq.scoreboard.packet.data.DisplaySlot.SIDEBAR;

public class EventListener implements Listener {

    private final Main main;

    public EventListener(Main main){
        this.main = main;
    }

    @EventHandler
    public void hasPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage("");
        double money = LlamaEconomy.getAPI().getMoney(event.getPlayer().getName());
        new Utils().handleToast(event.getPlayer(), "\uE100\uE101\uE102\uE103 \uE104\uE105", "§7Добро пожаловать на сервер - §c" + event.getPlayer().getName());
        Scoreboard scoreboard = new Scoreboard("§g§aмопсикдаун", SIDEBAR, 20);
        scoreboard.setHandler(plc -> {
            scoreboard.addLine("§7Ник: §b" + plc.getName());
            scoreboard.addLine("§7Ранг: §a" + this.main.getPrefix(event.getPlayer()));
            scoreboard.addLine("§7Онлайн: §b" + Server.getInstance().getOnlinePlayers().size());
            scoreboard.addLine("§7Баланс: §a" + LlamaEconomy.getAPI().getMoneyFormat().format(money));
        });
        scoreboard.show(event.getPlayer());

        if(!event.getPlayer().hasPlayedBefore()) {
            event.getPlayer().setSpawn(new Utils().rtp());
            event.getPlayer().teleport(new Utils().rtp());
        }

        event.getPlayer().setNameTag(this.main.getPrefix(event.getPlayer()) + " §7" + event.getPlayer().getName());

        if(!event.getPlayer().getLoginChainData().isXboxAuthed()){
            event.getPlayer().kick("§7Для игры на сервере вам необходимо быть авторизованым в §aXBOX LIVE", false);
        }
    }

    @EventHandler
    public void hasPlayerLocallyInitialized(PlayerLocallyInitializedEvent event) {
        DummyBossBar.Builder builder = new DummyBossBar.Builder(event.getPlayer());
        builder.color(BossBarColor.BLUE);
        event.getPlayer().createBossBar(builder.text("\uE100\uE101\uE102\uE103 \uE104\uE105").length((float) 100).build());
    }

    @EventHandler
    public void hasPlayerChat(PlayerChatEvent event){
        event.setFormat(this.main.getPrefix(event.getPlayer()) + " §7" + event.getPlayer().getName() + ": §e" + event.getMessage());
    }

    @EventHandler
    public void hasPlayerCreation(PlayerCreationEvent event){
        event.setPlayerClass(AquaPlayer.class);
    }
}
