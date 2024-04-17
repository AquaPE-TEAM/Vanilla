package ru.onewearf.aquape.module.buyer.utils;

import cn.nukkit.Player;
import cn.nukkit.inventory.InventoryType;
import cn.nukkit.item.Item;
import me.iwareq.fakeinventories.FakeInventory;
import net.lldv.llamaeconomy.LlamaEconomy;

public class Utils {

    public void openBuyer(Player player){
        FakeInventory inventory = new FakeInventory(InventoryType.DOUBLE_CHEST, "\uE12C\uE12D\uE12E\uE12F");

        inventory.setDefaultItemHandler((item, event) -> {
            event.setCancelled(true);
        });

        inventory.setItem(2, Item.get(392).setCustomName("§r§7Предмет: §cКартофель\n§r§7Цена: §e1.03\n§r§7Редкость: §aНизкая"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(!target.getInventory().contains(Item.get(392))){
                target.sendMessage("\uE12C\uE12D\uE12E\uE12F - §fУ вас нет данного предмета.");
                inventory.onClose(player);
                return;
            }

            target.getInventory().removeItem(Item.get(392));
            LlamaEconomy.getAPI().addMoney(player, 1.03);
        });

        inventory.setItem(3, Item.get(391).setCustomName("§r§7Предмет: §cМорковь\n§r§7Цена: §e2.1\n§r§7Редкость: §aНизкая"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(!target.getInventory().contains(Item.get(391))){
                target.sendMessage("\uE12C\uE12D\uE12E\uE12F - §fУ вас нет данного предмета.");
                inventory.onClose(player);
                return;
            }

            target.getInventory().removeItem(Item.get(391));
            LlamaEconomy.getAPI().addMoney(player, 2.1);
        });

        inventory.setItem(4, Item.get(457).setCustomName("§r§7Предмет: §cСвекла\n§r§7Цена: §e3.13\n§r§7Редкость: §aНизкая"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(!target.getInventory().contains(Item.get(457))){
                target.sendMessage("\uE12C\uE12D\uE12E\uE12F - §fУ вас нет данного предмета.");
                inventory.onClose(player);
                return;
            }

            target.getInventory().removeItem(Item.get(457));
            LlamaEconomy.getAPI().addMoney(player, 3.13);
        });

        inventory.setItem(5, Item.get(477).setCustomName("§r§7Предмет: §cЯгоды\n§r§7Цена: §e0.30\n§r§7Редкость: §aНизкая"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(!target.getInventory().contains(Item.get(477))){
                target.sendMessage("\uE12C\uE12D\uE12E\uE12F - §fУ вас нет данного предмета.");
                inventory.onClose(player);
                return;
            }

            target.getInventory().removeItem(Item.get(477));
            LlamaEconomy.getAPI().addMoney(player, 0.30);
        });

        inventory.setItem(6, Item.get(351).setCustomName("§r§7Предмет: §cЧернила\n§r§7Цена: §e5.18\n§r§7Редкость: §aНизкая"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(!target.getInventory().contains(Item.get(351))){
                target.sendMessage("\uE12C\uE12D\uE12E\uE12F - §fУ вас нет данного предмета.");
                inventory.onClose(player);
                return;
            }

            target.getInventory().removeItem(Item.get(351));
            LlamaEconomy.getAPI().addMoney(player, 5.18);
        });

        inventory.setItem(21, Item.get(432).setCustomName("§r§7Предмет: §cХорус\n§r§7Цена: §e30.1\n§r§7Редкость: §5Мифическая"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(!target.getInventory().contains(Item.get(432))){
                target.sendMessage("\uE12C\uE12D\uE12E\uE12F - §fУ вас нет данного предмета.");
                inventory.onClose(player);
                return;
            }

            target.getInventory().removeItem(Item.get(432));
            LlamaEconomy.getAPI().addMoney(player, 30.1);
        });

        inventory.setItem(22, Item.get(334).setCustomName("§r§7Предмет: §cКожа\n§r§7Цена: §e31.40\n§r§7Редкость: §5Мифическая"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(!target.getInventory().contains(Item.get(334))){
                target.sendMessage("\uE12C\uE12D\uE12E\uE12F - §fУ вас нет данного предмета.");
                inventory.onClose(player);
                return;
            }

            target.getInventory().removeItem(Item.get(334));
            LlamaEconomy.getAPI().addMoney(player, 31.40);
        });

        inventory.setItem(23, Item.get(46).setCustomName("§r§7Предмет: §cДинамит\n§r§7Цена: §e40.2\n§r§7Редкость: §5Мифическая"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(!target.getInventory().contains(Item.get(46))){
                target.sendMessage("\uE12C\uE12D\uE12E\uE12F - §fУ вас нет данного предмета.");
                inventory.onClose(player);
                return;
            }

            target.getInventory().removeItem(Item.get(46));
            LlamaEconomy.getAPI().addMoney(player, 40.2);
        });

        inventory.setItem(40, Item.get(397, 5).setCustomName("§r§7Предмет: §cГолова дракона\n§r§7Цена: §e503.21\n§r§7Редкость: §eЛегендарная"), (item, event) -> {
            event.setCancelled(true);

            Player target = event.getTransaction().getSource();

            if(!target.getInventory().contains(Item.get(397, 5))){
                target.sendMessage("\uE12C\uE12D\uE12E\uE12F - §fУ вас нет данного предмета.");
                inventory.onClose(player);
                return;
            }

            target.getInventory().removeItem(Item.get(397, 5));
            LlamaEconomy.getAPI().addMoney(player, 503.21);
        });

        player.addWindow(inventory);
    }
}
