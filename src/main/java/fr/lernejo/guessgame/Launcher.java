package fr.lernejo.guessgame;
import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("-interactive")) {
            Simulation simulation = new Simulation(new HumanPlayer());
            simulation.initialize(new SecureRandom().nextInt(100));
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }

        else if (args.length > 1 && args[0].equals("-auto") && args[1].matches("-?\\d+(\\.\\d+)?")) {
            Simulation simulation = new Simulation(new ComputerPlayer(Long.parseLong(args[1])));
            simulation.initialize(new SecureRandom().nextLong(Long.parseLong(args[1])));
            simulation.loopUntilPlayerSucceed(1000);
        }

        else {
            System.out.println("""
                Veuillez entrer un argument :
                 -Pour jouer, taper '-interactive'\s
                 -Pour laisser l'ordinateur jouer, taper '-auto' et un nombre positif qu'il devra deviner.""");
        }
    }
}
