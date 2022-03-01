package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        Logger logger = Object::notifyAll;
        return logger;
    }
}
