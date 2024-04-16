package ru.onewearf.aquape;

import cn.nukkit.plugin.PluginBase;
import ru.onewearf.aquape.command.TestCommand;
import ru.onewearf.aquape.listener.EventListener;

public class Loader extends PluginBase {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        getServer().getCommandMap().register("test", new TestCommand());
    }

    @Override
    public void onDisable(){}
}
