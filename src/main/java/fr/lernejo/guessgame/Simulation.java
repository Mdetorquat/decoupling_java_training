package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long nombre = player.askNextGuess();

        if (nombre == numberToGuess) {
            logger.log("Bonne Réponse !!!\n");
            return true;
        }

        else if (nombre < numberToGuess) {
            player.respond(true);
        }

        else {
            player.respond(false);
        }
        return false;
    }

    public void loopUntilPlayerSucceed() {

        long time = System.currentTimeMillis();
        boolean echec = false;

        while (!echec) {
            echec = nextRound();
        }
    }
}
