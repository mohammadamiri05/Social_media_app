package User;
import Main.App;
import Main.Menu;

public class Authentication {

    private String activeId;
    private User activeUser;

    private String collectID;
    private User collectUser;

    //____________________________________ G & S :(
    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
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
                    this.activeUser = app.getUsers()[i];
                    App.menu.home(app);
                    return;
                }
            }
        }
        System.err.println("[ERROR]:Incorrect Password or Id!");
        App.menu.start(app);

    }

    public void signUp(App app){

        User user1;
        System.out.println("Please complete the information below.");
        System.out.print("name: ");
        String name = Menu.input.next();
        System.out.print("\nlast name: ");
        String lastName = Menu.input.next();
        System.out.print("\nId: ");
        String id = Menu.input.next();
        System.out.print("\npassword: ");
        String password = Menu.input.next();
        System.out.print("\nyour email address: ");
        String email = Menu.input.next();
        user1 = new User(name,lastName,id,password,email);
        app.addUser(user1);
        App.menu.start(app);

    }

}
