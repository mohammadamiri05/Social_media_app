import Main.*;
import User.*;
import Setting.*;

public class Test {

    public static void main(String[] args) {

        App app = new App(Config.MAX_USER,Config.MAX_TOP_POST);
        app.addUser(new User("mohammad","amiri","mohammad05","12345","amiri@gmail.com"));
        app.addUser(new User("ali","amiri","ali","123","ali@gmail.com"));
        App.menu.start(app);



    }

}
