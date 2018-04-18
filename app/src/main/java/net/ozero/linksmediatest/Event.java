package net.ozero.linksmediatest;

import java.util.ArrayList;

public class Event {

    String title;
    String coefficient;
    String time;
    String place;
    String preview;
    String article;

    public Event(String title, String coefficient, String time, String place, String preview, String article) {
        this.title = title;
        this.coefficient = coefficient;
        this.time = time;
        this.place = place;
        this.preview = preview;
        this.article = article;
    }

    public Event(boolean isFakeEvent) {
        if (isFakeEvent) {
            title = "«Жирона» – «Леганес»: как закончится игра?";
            coefficient = "1.98 Коэффициент ";
            time = "Время: Завтра в 23:00 МСК";
            place = "Турнир: Испания. Примера";
            preview = "В стартовом матче 24-го тура испанской Примеры«Жирона» сыграет с «Леганесом». В первом круге соперники сыграли вничью 0:0. Будет ли определен победитель в этой встрече? Предлагаем наш прогноз. ";
            article = "/2018/02/15/zhirona-leganes-prognoz-na-ispanskuju-la-ligu-16-02-2018";
        }
    }

    public static ArrayList<Event> createFakeEvents() {

        ArrayList<Event> events = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            events.add(new Event(true));
        }

        return events;
    }

}
