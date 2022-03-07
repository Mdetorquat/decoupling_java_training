package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.DateFormat;
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

        int nbLoop = 0;
        long startTime = System.currentTimeMillis();

        do {
            if (nextRound()) {
                break;
            }
        } while (nbLoop++ <= nbMax);

        long endTime = System.currentTimeMillis();
        Date duration = new Date(endTime - startTime);
        DateFormat simpleDateFormat = new SimpleDateFormat("mm:ss.SSS");

        if (nbLoop >= nbMax) {
            logger.log("Le joueur a trouvé le nombre en " + nbLoop + " coup(s) et " + simpleDateFormat.format(duration));
            System.out.println("Vous avez trouvé en " + simpleDateFormat.format(duration));
        }
        else {
            logger.log("Le joueur n'a pas trouvé le nombre en " + nbLoop + " coup(s) et " + simpleDateFormat.format(duration));
            System.out.println("Vous n'avez pas trouvé le nombre en " + simpleDateFormat.format(duration));
        }
    }
}
