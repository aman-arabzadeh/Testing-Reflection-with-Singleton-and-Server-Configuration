package config;

import java.net.InetSocketAddress;

public class Serverkonfiguration {

    private static Serverkonfiguration instans;
    private final InetSocketAddress adress;
    private final String meddelande;

    private Serverkonfiguration(int port, String meddelande) {
        this.meddelande = meddelande;
        this.adress = new InetSocketAddress("localhost", port);
    }

    public static Serverkonfiguration getInstans() {
        if (instans == null) {
            throw new IllegalStateException("Serverkonfiguration är inte initierad.");
        }
        return instans;
    }

    public static void sattInstans(Serverkonfiguration konfiguration) {
        if (instans == null) {
            instans = konfiguration;
        }
    }

    public InetSocketAddress hamtaAdress() {
        return adress;
    }

    public String hamtaMeddelande() {
        return meddelande;
    }
}
