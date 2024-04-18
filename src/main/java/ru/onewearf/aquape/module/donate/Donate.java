package ru.onewearf.aquape.module.donate;

import cn.nukkit.utils.Config;
import ru.onewearf.aquape.module.Module;
import ru.onewearf.aquape.module.donate.command.DonateCommand;
import ru.onewearf.aquape.module.donate.command.economy.CoinsCommand;
import ru.onewearf.aquape.module.donate.command.economy.giveCoinsCommand;
import ru.onewearf.aquape.module.donate.listener.DonateListener;

import java.util.List;

public class Donate extends Module {

    public Config coins;
    @Override
    public String getName() {
        return "Donate";
    }

    @Override
    public void init() {
        this.coins = new Config(getDataFolder() + "/resources/coins.yml", Config.YAML);

        getServer().getCommandMap().registerAll("coins", List.of(
                new CoinsCommand(this),
                new giveCoinsCommand(this),
                new DonateCommand(this)
        ));
        getServer().getPluginManager().registerEvents(new DonateListener(this), getOwner().getLoader());
    }

    public boolean addCoin(String playerName, int count) {
        playerName = playerName.toLowerCase();
        Integer oldCount = (Integer) this.coins.get(playerName);
        if (oldCount == null) {
            this.coins.set(playerName, count);
        } else {
            this.coins.set(playerName, oldCount + count);
        }
        this.coins.save();
        return true;
    }

    public boolean reduceCoin(String playerName, int count) {
        playerName = playerName.toLowerCase();
        Integer oldCount = (Integer) this.coins.get(playerName);
        if (oldCount == null) {
            this.coins.set(playerName, 0);
            this.coins.save();
        }

        if (oldCount < count) {
            return false;
        } else {
            this.coins.set(playerName, oldCount - count);
            this.coins.save();
            return true;
        }
    }

    public void setCoin(String playerName, int count) {
        playerName = playerName.toLowerCase();
        this.coins.set(playerName, count);
        this.coins.save();
    }

    public int seeCoin(String playerName) {
        playerName = playerName.toLowerCase();
        Object coinsObj = this.coins.get(playerName);

        if(this.coins == null){
            return Integer.parseInt("Ошибка");
        }

        if (coinsObj == null) {
            return -1;
        }

        return ((Number) coinsObj).intValue();
    }
}
