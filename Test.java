import Account.*;
import Main.*;
import User.*;
import Setting.*;

public class Test {

    public static void main(String[] args) {

        App app = new App(10,10);
        app.addUser(new User("mohammad","amiri","ma","12345","amiri@gmail.com"));
        app.addUser(new User("ali","amiri","ali","123","ali@gmail.com"));
        App.menu.start(app);




    }

}
