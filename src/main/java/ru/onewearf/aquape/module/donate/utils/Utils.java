package ru.onewearf.aquape.module.donate.utils;

import cn.nukkit.Player;
import cn.nukkit.inventory.InventoryType;
import cn.nukkit.item.Item;
import me.iwareq.fakeinventories.FakeInventory;
import ru.onewearf.aquape.module.donate.Donate;

public class Utils {

    public void openShop(Player player, Donate coins){
        FakeInventory inventory = new FakeInventory(InventoryType.DOUBLE_CHEST, "\uE128\uE129\uE12A\uE12B");

        inventory.setDefaultItemHandler((item, event) -> {
            event.setCancelled(true);
        });

        inventory.setItem(0, Item.get(742).setCustomName("§r§7Предмет: §cНезеритовый слиток\n§r§7Цена: §e85 §r§7коинов\n§r§7Кол-во: §e1"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(coins.seeCoin(player.getName()) < 85){
                target.sendMessage("\uE128\uE129\uE12A\uE12B - §fУ вас §cнедостаточно §fсредств для покупки §eданного §fпредмета!");
                inventory.close(player);
                return;
            }

            coins.reduceCoin(player.getName(), 85);
            target.getInventory().addItem(Item.get(742, 0, 1));
        });

        inventory.setItem(1, Item.get(Item.ANCIENT_DEBRIS).setCustomName("§r§7Предмет: §cДревний обломок\n§r§7Цена: §e35 §r§7коинов\n§r§7Кол-во: §e1"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(coins.seeCoin(player.getName()) < 35){
                target.sendMessage("\uE128\uE129\uE12A\uE12B - §fУ вас §cнедостаточно §fсредств для покупки §eданного §fпредмета!");
                inventory.close(player);
                return;
            }

            coins.reduceCoin(player.getName(), 35);
            target.getInventory().addItem(Item.get(526, 0, 1));
        });

        inventory.setItem(2, Item.get(52).setCustomName("§r§7Предмет: §cСпавнер монстров\n§r§7Цена: §e35 §r§7коинов\n§r§7Кол-во: §e1"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(coins.seeCoin(player.getName()) < 35){
                target.sendMessage("\uE128\uE129\uE12A\uE12B - §fУ вас §cнедостаточно §fсредств для покупки §eданного §fпредмета!");
                inventory.close(player);
                return;
            }

            coins.reduceCoin(player.getName(), 35);
            target.getInventory().addItem(Item.get(52, 0, 1));
        });

        inventory.setItem(3, Item.get(383, 11, 1).setCustomName("§r§7Предмет: §cЯйцо коровы\n§r§7Цена: §e45 §r§7коинов\n§r§7Кол-во: §e1"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(coins.seeCoin(player.getName()) < 45){
                target.sendMessage("\uE128\uE129\uE12A\uE12B - §fУ вас §cнедостаточно §fсредств для покупки §eданного §fпредмета!");
                inventory.close(player);
                return;
            }

            coins.reduceCoin(player.getName(), 45);
            target.getInventory().addItem(Item.get(383, 11, 1));
        });

        inventory.setItem(4, Item.get(426).setCustomName("§r§7Предмет: §cEND_CRYSTAL\n§r§7Цена: §e15 §r§7коинов\n§r§7Кол-во: §e1"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(coins.seeCoin(player.getName()) < 15){
                target.sendMessage("\uE128\uE129\uE12A\uE12B - §fУ вас §cнедостаточно §fсредств для покупки §eданного §fпредмета!");
                inventory.close(player);
                return;
            }

            coins.reduceCoin(player.getName(), 15);
            target.getInventory().addItem(Item.get(426, 0, 1));
        });

        inventory.setItem(5, Item.get(450).setCustomName("§r§7Предмет: §cТотем бессмертия\n§r§7Цена: §e35 §r§7коинов\n§r§7Кол-во: §e1"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(coins.seeCoin(player.getName()) < 35){
                target.sendMessage("\uE128\uE129\uE12A\uE12B - §fУ вас §cнедостаточно §fсредств для покупки §eданного §fпредмета!");
                inventory.close(player);
                return;
            }

            coins.reduceCoin(player.getName(), 35);
            target.getInventory().addItem(Item.get(450, 0, 1));
        });

        inventory.setItem(6, Item.get(264).setCustomName("§r§7Предмет: §cАлмаз\n§r§7Цена: §e10 §r§7коинов\n§r§7Кол-во: §e1"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(coins.seeCoin(player.getName()) < 10){
                target.sendMessage("\uE128\uE129\uE12A\uE12B - §fУ вас §cнедостаточно §fсредств для покупки §eданного §fпредмета!");
                inventory.close(player);
                return;
            }

            coins.reduceCoin(player.getName(), 10);
            target.getInventory().addItem(Item.get(264, 0, 1));
        });

        inventory.setItem(7, Item.get(Item.TNT).setCustomName("§r§7Предмет: §cДинамит\n§r§7Цена: §e20 §r§7коинов\n§r§7Кол-во: §e1"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(coins.seeCoin(player.getName()) < 20){
                target.sendMessage("\uE128\uE129\uE12A\uE12B - §fУ вас §cнедостаточно §fсредств для покупки §eданного §fпредмета!");
                inventory.close(player);
                return;
            }

            coins.reduceCoin(player.getName(), 20);
            target.getInventory().addItem(Item.get(Item.TNT, 0, 1));
        });

        inventory.setItem(8, Item.get(Item.ELYTRA).setCustomName("§r§7Предмет: §cELYTRA\n§r§7Цена: §e70 §r§7коинов\n§r§7Кол-во: §e1"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(coins.seeCoin(player.getName()) < 70){
                target.sendMessage("\uE128\uE129\uE12A\uE12B - §fУ вас §cнедостаточно §fсредств для покупки §eданного §fпредмета!");
                inventory.close(player);
                return;
            }

            coins.reduceCoin(player.getName(), 70);
            target.getInventory().addItem(Item.get(Item.ELYTRA, 0, 1));
        });

        inventory.setItem(53, Item.get(339).setCustomName("§r§7Ваш баланс: §a" + coins.seeCoin(player.getName())), (item, event) -> {event.setCancelled(true);});

        player.addWindow(inventory);
    }
}
