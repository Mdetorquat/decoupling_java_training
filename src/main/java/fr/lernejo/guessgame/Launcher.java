package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        Simulation simulation = new Simulation(new HumanPlayer());

        SecureRandom secureRandom = new SecureRandom();
        long randomNumber = secureRandom.nextInt(100);

        simulation.initialize(randomNumber);

        simulation.loopUntilPlayerSucceed();

    }
}
