package ru.onewearf.aquape.module;

import cn.nukkit.Server;
import lombok.Getter;
import ru.onewearf.aquape.AquaCore;

import java.io.File;

public abstract class Module {

    protected AquaCore main;
    @Getter
    protected Server server;

    public Module() {
        this.main = AquaCore.getInstance();
        this.server = Server.getInstance();
    }

    public abstract String getName();

    public abstract void init();

    public void onDisable() {
        //TODO
    }

    public File getDataFolder() {
        return main.getLoader().getDataFolder();
    }

    public AquaCore getOwner() {
        return main;
    }
}
