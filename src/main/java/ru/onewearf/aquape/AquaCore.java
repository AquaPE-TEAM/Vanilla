package ru.onewearf.aquape;

import lombok.Getter;
import ru.onewearf.aquape.manager.ModuleManager;

public class AquaCore {

    @Getter
    public static AquaCore instance;
    public Loader loader;

    public void init(Loader loader){
        this.loader = loader;
        instance = this;
        this.onEnable();
    }

    public void onEnable(){
        new ModuleManager();
    }

    public Loader getLoader(){
        return this.loader;
    }
}
