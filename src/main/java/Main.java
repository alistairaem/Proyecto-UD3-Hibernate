import controller.MenuControlador;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        LogManager.getLogManager().reset();
        Logger globalLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        globalLogger.setLevel(java.util.logging.Level.OFF);
        MenuControlador menuControlador = new MenuControlador();
        menuControlador.controladorMenuPrincipal();
    }
}