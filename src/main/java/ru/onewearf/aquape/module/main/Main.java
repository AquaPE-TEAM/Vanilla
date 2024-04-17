package ru.onewearf.aquape.module.main;

import ru.onewearf.aquape.module.main.command.TestCommand;
import ru.onewearf.aquape.module.main.listener.EventListener;
import ru.onewearf.aquape.module.Module;

public class Main extends Module {
    @Override
    public String getName() {
        return "Main";
    }

    @Override
    public void init() {
        getServer().getPluginManager().registerEvents(new EventListener(), this.main.getLoader());
        getServer().getCommandMap().register("test", new TestCommand());
    }
}
