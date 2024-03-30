package User;
import Main.App;
import Main.Menu;

public class Authentication {

    private String activeId;
    private User user;

    //____________________________________ G & S :(
    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //________________________________________ )

    public void signIn(App app){

        System.out.print("Please enter your Id: ");
        String id = Menu.input.next();
        System.out.print("Please enter your password: ");
        String password = Menu.input.next();
        for (int i = 0; i < app.getUsers().length; i++) {
            if (app.getUsers()[i] != null && app.getUsers()[i].getId().equals(id) ){
                if (app.getUsers()[i].getPassword().equals(password) ){
                    System.out.println("your registration has been successful:)");
                    this.activeId = id;
                    this.user = app.getUsers()[i];
                    App.menu.home(app);
                    return;
                }
            }
        }
        System.err.println("[ERROR]:Incorrect Password or Id!");
        App.menu.start(app);

    }

}
