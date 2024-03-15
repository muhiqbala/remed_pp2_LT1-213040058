package view.main;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainController.showMainFrame();
            }
        });
    }
}
