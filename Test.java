import Account.*;
import Main.*;
import User.*;

public class Test {

    public static void main(String[] args) {

        App app = new App(10,10);
        app.addUser(new User("mohammad","amiri","ma","12345","amiri@gmail.com"));
        App.menu.start(app);



    }

}
