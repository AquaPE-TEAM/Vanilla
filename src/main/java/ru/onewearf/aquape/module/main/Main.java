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
        getServer().getScheduler().scheduleDelayedRepeatingTask(new UpdatePrefix(this), 20, 1);
    }

    public String getGroup(Player player){
        return Objects.requireNonNull(LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId())).getPrimaryGroup();
    }

    public String getPrefix(Player player){
        String group = getGroup(player);

        playerGroup.put("default", "\uE16D\uE16E\uE16F");
        playerGroup.put("owner", "\uE167\uE168\uE169");

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
