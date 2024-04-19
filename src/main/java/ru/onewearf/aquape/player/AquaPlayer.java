package ru.onewearf.aquape.player;

import cn.nukkit.command.Command;
import cn.nukkit.command.data.CommandDataVersions;
import cn.nukkit.command.defaults.VanillaCommand;
import cn.nukkit.network.SourceInterface;
import cn.nukkit.network.protocol.AvailableCommandsPacket;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AquaPlayer extends cn.nukkit.Player {

    public AquaPlayer(SourceInterface interfaz, Long clientID, InetSocketAddress socketAddress) {
        super(interfaz, clientID, socketAddress);
    }

    @Override
    public void sendCommandData() {
        AvailableCommandsPacket pk = new AvailableCommandsPacket();
        Map<String, CommandDataVersions> data = new HashMap<>();
        Iterator var3 = this.server.getCommandMap().getCommands().values().iterator();

        while (var3.hasNext()) {
            Command command = (Command) var3.next();
            if (command.isRegistered() && !"help".equals(command.getName())) {

                if (!this.isOp()) {
                    if (!(command instanceof VanillaCommand)) {
                        continue;
                    }
                }

                CommandDataVersions commandData = command.generateCustomCommandData(this);
                if (commandData != null) {
                    /*String description = command.getDescription();
                    String permission = command.getPermission();
                    if (permission != null && this.hasPermission(permission)) {
                        description = "§r§a" + description;
                    } else {
                        description = "§r§c" + description;
                    }
                    command.setDescription(description);*/
                    data.put(command.getName(), commandData);
                }
            }
        }

        if (!data.isEmpty()) {
            pk.commands = data;
            this.dataPacket(pk);
        }
    }
}
