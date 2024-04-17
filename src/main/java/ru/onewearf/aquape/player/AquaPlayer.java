package ru.onewearf.aquape.player;

import cn.nukkit.network.SourceInterface;

import java.net.InetSocketAddress;

public class AquaPlayer extends cn.nukkit.Player {

    public AquaPlayer(SourceInterface interfaz, Long clientID, InetSocketAddress socketAddress) {
        super(interfaz, clientID, socketAddress);
    }
}
