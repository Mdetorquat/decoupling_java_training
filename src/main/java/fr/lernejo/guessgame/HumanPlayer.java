package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    Logger logger = LoggerFactory.getLogger(HumanPlayer.class.getName());
    Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        long number = -1;
        while (number == -1) {
            try {
                number = Long.parseLong(scanner.nextLine());
            } catch (Exception e) {
                logger.log("Une erreur est survenue. Message : " + e.getMessage());
            }
        }

        logger.log("Le joueur a donné le nombre " + number);
        return number;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("C'est plus !\n");
        }
        else {
            logger.log("C'est moins !\n");
        }
    }
}
