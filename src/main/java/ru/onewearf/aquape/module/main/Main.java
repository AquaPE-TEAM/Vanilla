package ru.onewearf.aquape.module.main;

import cn.nukkit.Player;
import cn.nukkit.scheduler.TaskHandler;
import net.luckperms.api.LuckPermsProvider;
import ru.onewearf.aquape.module.donate.Donate;
import ru.onewearf.aquape.module.main.listener.EventListener;
import ru.onewearf.aquape.module.Module;
import ru.onewearf.aquape.module.main.task.UpdatePrefix;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main extends Module {
    public Donate coins;

    Map<String, String> playerGroup = new HashMap<>();

    @Override
    public String getName() {
        return "Main";
    }

    @Override
    public void init() {
        this.coins = new Donate();
        getServer().getPluginManager().registerEvents(new EventListener(this), this.main.getLoader());
        getServer().getScheduler().scheduleRepeatingTask(new UpdatePrefix(this), 20, true);
    }

    public String getGroup(Player player){
        return Objects.requireNonNull(LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId())).getPrimaryGroup();
    }

    public String getPrefix(Player player){
        String group = getGroup(player);

        playerGroup.put("default", "\uE305");
        playerGroup.put("youtube", "\uE317");
        playerGroup.put("helper", "\uE30D");
        playerGroup.put("admin", "\uE308");
        playerGroup.put("sponsor", "\uE30E");
        playerGroup.put("owner", "\uE304");

        if(playerGroup.containsKey(group)){
            return playerGroup.get(group);
        }

        return group;
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
