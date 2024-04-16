package ru.onewearf.aquape.utils;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.math.Vector3;
import cn.nukkit.network.protocol.ToastRequestPacket;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.DoubleTag;
import cn.nukkit.nbt.tag.FloatTag;
import cn.nukkit.nbt.tag.ListTag;
import cn.nukkit.level.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public void handleToast(Player player, String title, String content) {
        ToastRequestPacket toastRequestPacket = new ToastRequestPacket();
        toastRequestPacket.title = title;
        toastRequestPacket.content = content;
        player.dataPacket(toastRequestPacket);
    }

    public void createNBT(Location p, String CustomName, int Scale) {
        new CompoundTag()
                .putList(new ListTag<>("Pos")
                        .add(new DoubleTag("", p.x))
                        .add(new DoubleTag("", p.y))
                        .add(new DoubleTag("", p.z)))
                .putList(new ListTag<DoubleTag>("Motion")
                        .add(new DoubleTag("", 0))
                        .add(new DoubleTag("", 0))
                        .add(new DoubleTag("", 0)))
                .putList(new ListTag<FloatTag>("Rotation")
                        .add(new FloatTag("", (float) p.yaw))
                        .add(new FloatTag("", (float) p.pitch)))
                .putBoolean("Invulnerable", true)
                .putString("NameTag", CustomName)
                .putInt("Profession", 0)
                .putBoolean("npc", true)
                .putInt("pr", 1)
                .putFloat("scale", Scale);
    }

    public Vector3 rtp(){
        int x, z;
        Vector3 location;

        do {
            x = ThreadLocalRandom.current().nextInt(-1000, 1000);
            z = ThreadLocalRandom.current().nextInt(-1000, 1000);
            location = new Vector3(x, Server.getInstance().getDefaultLevel().getHighestBlockAt(x, z), z);
        } while (location.y <= 0);

        return location;
    }
}
