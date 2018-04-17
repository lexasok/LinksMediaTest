package net.ozero.linksmediatest;

import java.util.ArrayList;

public class ItemArticle {
    String team1;
    String team2;
    String time;
    String tournament;
    String place;
    ArrayList<Article> articles;
    String prediction;

    public ItemArticle(boolean isFake) {
        if (isFake) {
            articles = Article.createFakeArticles();
            team1 = "«Жирона» ";
            team2 = "«Леганес»";
            time = "Завтра в 23:00 МСК";
            tournament = "Испания. Примера";
            place = "Стадион \"Монтиливи\", Жирона";
            prediction = " «Жирона» в родных стенах редко теряла очки в последнее время  " +
                    "– четыре победы и одна ничья в шести последних встречах, причем  и " +
                    "пропустили в пяти предыдущих домашних поединках каталонцы только дважды. " +
                    "«Леганес» слабо играет в гостях, к тому ни разу в истории не удалось " +
                    "обыграть «жиронцев» на их поле.";
        }
    }

}
