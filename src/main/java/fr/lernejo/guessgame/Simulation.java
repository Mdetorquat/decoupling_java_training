package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        if (nombre == this.numberToGuess) {
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

    public void loopUntilPlayerSucceed(long nbMax) {

        int nbLoop = 1;
        long startTime = System.currentTimeMillis();
        boolean fin = false;

        while (!nextRound()) {
            nbLoop++;

            if (nbLoop == nbMax) {
                logger.log("Vous n'avez plus d'essai(s)\n");
                fin = true;
                break;
            }
            logger.log("Essayez encore !\n");
        }

        if (!fin) {
            logger.log("Félicitations, vous avez trouvé en " + nbLoop + "tour(s) !\n");
        }
        else
            logger.log("Dommage, le nombre était " + numberToGuess +" !\n");

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss.SSS");
        Date date = new Date(duration);
        String dure = simpleDateFormat.format(date);
        logger.log("La partie a duré " + duration + "\n");
    }
}
