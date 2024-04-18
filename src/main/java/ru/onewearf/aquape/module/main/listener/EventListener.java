package ru.onewearf.aquape.module.main.listener;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.*;
import cn.nukkit.level.GameRule;
import cn.nukkit.level.GameRules;
import cn.nukkit.network.protocol.GameRulesChangedPacket;
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

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static cn.nukkit.level.GameRule.*;
import static me.iwareq.scoreboard.packet.data.DisplaySlot.SIDEBAR;

public class EventListener implements Listener {

    private final Main main;

    private final Map<UUID, Long> chatCooldown = new HashMap<>();

    public EventListener(Main main){
        this.main = main;
    }

    @EventHandler
    public void hasPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage("");
        new Utils().handleToast(event.getPlayer(), "\uE100\uE101\uE102\uE103 \uE104\uE105", "§7Добро пожаловать на сервер - §c" + event.getPlayer().getName());
        Scoreboard scoreboard = getScoreboard(event);
        scoreboard.show(event.getPlayer());

        event.getPlayer().getLevel().getGameRules().setGameRule(SHOW_COORDINATES, true);

        if(!event.getPlayer().hasPlayedBefore()) {
            event.getPlayer().setSpawn(new Utils().rtp());
            event.getPlayer().teleport(new Utils().rtp());
        }

        event.getPlayer().setNameTag(this.main.getPrefix(event.getPlayer()) + " §7" + event.getPlayer().getName());

        if(!event.getPlayer().getLoginChainData().isXboxAuthed()){
            event.getPlayer().kick("§7Для игры на сервере вам необходимо быть авторизованым в §aXBOX LIVE", false);
        }
    }

    private Scoreboard getScoreboard(PlayerJoinEvent event) {
        Scoreboard scoreboard = new Scoreboard("§g§aмопсикдаун", SIDEBAR, 20);
        scoreboard.setHandler(plc -> {
            scoreboard.addLine("§7Ник: §b" + plc.getName());
            scoreboard.addLine("§7Ранг: §a" + this.main.getPrefix(event.getPlayer()));
            scoreboard.addLine("§7Онлайн: §b" + Server.getInstance().getOnlinePlayers().size());
            scoreboard.addLine("§7Баланс: §a" + LlamaEconomy.getAPI().getMoneyFormat().format(LlamaEconomy.getAPI().getMoney(plc.getName())));
        });
        return scoreboard;
    }

    @EventHandler
    public void hasPlayerLocallyInitialized(PlayerLocallyInitializedEvent event) {
        DummyBossBar.Builder builder = new DummyBossBar.Builder(event.getPlayer());
        builder.color(BossBarColor.BLUE);
        event.getPlayer().createBossBar(builder.text("\uE100\uE101\uE102\uE103 \uE104\uE105").length((float) 100).build());
    }

    @EventHandler
    public void hasPlayerChat(PlayerChatEvent event) {
        event.setCancelled();

        if (chatCooldown.containsKey(event.getPlayer().getUniqueId())) {
            long cooldownTime = 3000;
            long lastMessageTime = chatCooldown.get(event.getPlayer().getUniqueId());
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastMessageTime < cooldownTime) {
                event.getPlayer().sendMessage("§eЧат §7• §fПожалуйста, подождите 3 секунды перед отправкой следующего сообщения.");
                return;
            }
        }

        chatCooldown.put(event.getPlayer().getUniqueId(), System.currentTimeMillis());

        if (event.getMessage().charAt(0) == '!') { // global
            for (Player players : main.getServer().getOnlinePlayers().values()) {
                players.sendMessage("§7[§cGLOBAL§7] " + this.main.getPrefix(event.getPlayer()) + " §7" + event.getPlayer().getName() + ": §e" + event.getMessage().replaceFirst("!", ""));
                main.getServer().getLogger().info("§7[§cGLOBAL§7] " + this.main.getGroup(event.getPlayer()) + " §7" + event.getPlayer().getName() + ": §e" + event.getMessage());
            }
        } else {
            for (Player players : main.getServer().getOnlinePlayers().values()) { // local
                if (event.getPlayer().distance(players) <= 50) {

                    if(!(event.getPlayer().distance(players) <= 50)){
                        event.getPlayer().sendTitle("§aВаше сообщение никто не увидел!", "§7Для того чтобы все увидели, добавьте ! перед сообщением");
                        return;
                    }

                    players.sendMessage("§7[§aLOCAL§7] " + this.main.getPrefix(event.getPlayer()) + " §7" + event.getPlayer().getName() + ": §e" + event.getMessage());
                    main.getServer().getLogger().info("§7[§aLOCAL§7] " + this.main.getGroup(event.getPlayer()) + " §7" + event.getPlayer().getName() + ": §e" + event.getMessage());
                }
            }
        }
    }

    @EventHandler
    public void hasPlayerQuit(PlayerQuitEvent event){
        event.setQuitMessage("");
    }

    @EventHandler
    public void hasPlayerCreation(PlayerCreationEvent event){
        event.setPlayerClass(AquaPlayer.class);
    }
}
