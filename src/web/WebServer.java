package web;

import com.sun.net.httpserver.HttpServer;
import config.Serverkonfiguration;
import java.io.IOException;
import java.io.OutputStream;

public class WebServer {

    public void startServer() throws IOException {
        Serverkonfiguration konfiguration = Serverkonfiguration.getInstans();

        // Skapa server på specificerad port
        HttpServer server = HttpServer.create(konfiguration.hamtaAdress(), 0);

        // Skapa en context för "/greeting"
        server.createContext("/greeting", exchange -> {
            String svarMeddelande = konfiguration.hamtaMeddelande();
            exchange.sendResponseHeaders(200, svarMeddelande.length());

            // Skicka tillbaka svaret
            OutputStream os = exchange.getResponseBody();
            os.write(svarMeddelande.getBytes());
            os.flush();
            os.close();
        });

        // Starta servern
        System.out.printf("Servern startades på %s:%d%n",
                konfiguration.hamtaAdress().getHostName(),
                konfiguration.hamtaAdress().getPort());
        server.start();
    }
}
