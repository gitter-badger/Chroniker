package com.chroniker.client.main;

import com.chroniker.client.gui.MainFrame;
import javafx.application.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger log = LogManager.getLogger(Main.class.getName());

    public Main(String[] args) {

        MainFrame mainFrame = new MainFrame();
        Application.launch(mainFrame.getClass(), args);

    }

    public static void main(String[] args) {
        Main main = new Main(args);
    }

}
