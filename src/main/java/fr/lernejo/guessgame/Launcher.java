package fr.lernejo.guessgame;
import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {

        if (args.length > 0 && args[0].equals("-interactive")) {
            Simulation simulation = new Simulation(new HumanPlayer());
            SecureRandom secureRandom = new SecureRandom();
            long randomNumber = secureRandom.nextInt(100);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }

        else if (args.length > 1 && args[0].equals("-auto") && args[1].matches("-?\\d+(\\.\\d+)?")) {
            int iter = Integer.parseInt(args[1]);
            Simulation simulation = new Simulation(new ComputerPlayer());
            SecureRandom secureRandom = new SecureRandom();
            long number = secureRandom.nextInt(100);
            simulation.initialize(number);
            simulation.loopUntilPlayerSucceed(iter);
        }

        else {
            System.out.println("Veuillez entrer un argument :\n" +
                " -Pour jouer, taper '-interactive'; \n" +
                " -Pour laisser l'ordinateur jouer, taper '-auto' et un nombre positif qu'il devra deviner.");
        }
    }
}
