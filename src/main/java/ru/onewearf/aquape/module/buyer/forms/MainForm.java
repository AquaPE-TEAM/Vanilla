package ru.onewearf.aquape.module.buyer.forms;

import cn.nukkit.Player;
import ru.contentforge.formconstructor.form.SimpleForm;
import ru.onewearf.aquape.module.buyer.utils.Utils;

public class MainForm{

    public void mainForm(Player player){
        SimpleForm form = new SimpleForm("\uE12C\uE12D\uE12E\uE12F");
        form.addContent("§aДеньги§r - самое §aпривлекательное§r, что существует на этой планете... Уже давно пора уйти в заслуженный отдых старому человеку, ведь он проработал здесь очень долгое время...");
        form.addButton("Скупщик\nНажми чтобы перейти.", (pl, b) -> {
            new Utils().openBuyer(player);
        });
        form.addButton("Информация для начинающих:", (pl, b) -> {
            this.infoForm(player);
        });
        form.send(player);
    }

    public void infoForm(Player player){
        SimpleForm form = new SimpleForm("\uE12C\uE12D\uE12E\uE12F");
        form.addContent("§rПриветствую тебя, §cпутник приключений!\n" +
                "\n" +
                "\uE110 §rХочешь увеличить свой §eфинансовый статус§r? У меня есть для тебя предложение по §aвыгодным сделкам§r на товары, которые я позже §cперепродаю§r. Ты можешь быть уверен, что с этим предложением ты не останешься без средств, §gэто гарантировано§r!\n" +
                "\n" +
                "\uE114 §rЕсли ты желаешь работать со мной на регулярной основе и получать больше прибыли, то заключай все сделки, и мы достигнем нового §gуровня§r!\n" +
                "\n" +
                "\uE117 §rКстати, я в поисках некоторых §gуникальных артефактов§r. Говорят, что их можно получить, одолевая §cМонстров§r. Если принесешь мне такой, я ответствую взамен.");
        form.addButton("⨟ §0Назад", (pl, b) -> {
            this.mainForm(player);
        });
        form.send(player);
    }
}
