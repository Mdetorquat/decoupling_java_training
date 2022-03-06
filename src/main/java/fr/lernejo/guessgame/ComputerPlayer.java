package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class ComputerPlayer implements Player {

    Logger logger = LoggerFactory.getLogger("computer");
    private long randomNumber;
    private long min = 0;
    private long max = Long.MAX_VALUE;

    @Override
    public long askNextGuess() {
        return this.randomNumber = (this.max + this.min) / 2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            System.out.println("Le numéro de l'ordinateur est plus petit que le numéro à trouver !\n");
            this.min = this.randomNumber;
        }
        else {
            System.out.println("Le numéro de l'ordinateur est plus grand que le numéro à trouver !\n");
            this.max = this.randomNumber;
        }

        logger.log(this.randomNumber + "\n");
    }
}
