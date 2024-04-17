package ru.onewearf.aquape.module.buyer;

import ru.onewearf.aquape.module.Module;
import ru.onewearf.aquape.module.buyer.command.BuyerCommand;

public class Buyer extends Module {
    @Override
    public String getName() {
        return "Buyer";
    }

    @Override
    public void init() {
        getServer().getCommandMap().register("buyer", new BuyerCommand());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
