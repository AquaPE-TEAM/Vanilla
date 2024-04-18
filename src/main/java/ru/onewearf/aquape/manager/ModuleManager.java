package ru.onewearf.aquape.manager;

import ru.onewearf.aquape.AquaCore;
import ru.onewearf.aquape.module.Module;
import ru.onewearf.aquape.module.buyer.Buyer;
import ru.onewearf.aquape.module.donate.Donate;
import ru.onewearf.aquape.module.main.Main;

import java.util.HashMap;
import java.util.Map;

public class ModuleManager {

    private final Map<String, Module> modules = new HashMap<>();

    public ModuleManager() {
        this.register(new Donate());
        this.register(new Main());
        this.register(new Buyer());
        this.getAll();
    }

    public void register(Module module) {
        this.modules.put(module.getName(), module);
        module.init();
    }

    public void getAll() {
        for (Module module : this.modules.values()) {
            AquaCore.getInstance().getLoader().getLogger().info("Module " + module.getName() + " load");
        }
    }

    public Module get(String name) {
        return this.modules.get(name);
    }

    public void callOnDisable() {
        for (Module module : this.modules.values()) {
            module.onDisable();
        }
    }
}
