import web.WebServer;
import config.Serverkonfiguration;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, IOException {
        String citat = hamtaFilosofisktCitat(); // Hämta ett citat
        initKonfiguration(8000, citat);
        WebServer server = new WebServer();
        server.startServer();
    }
    // Reflektionsexempel
    public static void initKonfiguration(int port, String meddelande) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<Serverkonfiguration> constructor = Serverkonfiguration.class.getDeclaredConstructor(int.class, String.class);
        constructor.setAccessible(true);
        Serverkonfiguration instans = constructor.newInstance(port, meddelande);
        Serverkonfiguration.sattInstans(instans);
    }

    // Metod för att slumpa ett filosofiskt citat
    public static String hamtaFilosofisktCitat() {
        String[] quotes = {
                "The only true wisdom is in knowing you know nothing. - Socrates",
                "Happiness depends upon ourselves. - Aristotle",
                "He who opens a school door, closes a prison. - Victor Hugo",
                "Do what you can, with what you have, where you are. - Theodore Roosevelt",
                "Freedom is nothing else but a chance to be better. - Albert Camus"
        };

        Random random = new Random();
        return quotes[random.nextInt(quotes.length)];
    }
}
