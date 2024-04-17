package ru.onewearf.aquape;

import cn.nukkit.plugin.PluginBase;
import ru.onewearf.aquape.manager.ModuleManager;

public class Loader extends PluginBase {

    @Override
    public void onEnable() {
        new AquaCore().init(this);
    }

    @Override
    public void onDisable(){
        new ModuleManager().callOnDisable();
    }

}
