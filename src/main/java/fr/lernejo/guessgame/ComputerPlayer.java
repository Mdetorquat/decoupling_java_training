package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {

    Logger logger = LoggerFactory.getLogger(ComputerPlayer.class.getName());
    private long randomNumber;
    private long age_min;
    private long age_max;
    boolean plusGrand;

    public ComputerPlayer(long maxi) {
        age_max = maxi;
        age_min = -1;
        plusGrand = false;
    }

    @Override
    public long askNextGuess() {
        long prop = -1;
        if (age_min == -1l) {
            prop = age_max / 2;
            age_min = 0;
        }
        else
        {
            age_min = plusGrand ? randomNumber : age_min;
            age_max = !plusGrand ? randomNumber : age_max;
            prop = (age_min + age_max) / 2;
        }
        randomNumber = prop;
        logger.log("Computer propose " + prop);
        return prop;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        plusGrand = lowerOrGreater;
        logger.log("Value " + randomNumber + " is " + (lowerOrGreater ? "greater" : "lower" + " than guess"));
    }
}
