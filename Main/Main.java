package Main;
import Setting.Config;


public class Main {

    public static void main(String[] args) {

        App app = new App(Config.MAX_USER,Config.MAX_TOP_POST);
        App.menu.start(app);


    }
}