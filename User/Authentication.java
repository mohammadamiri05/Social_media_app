package User;
import Main.App;
import Main.Menu;
import Setting.Color;

public class Authentication {

    public static String activeId;
    public static User activeUser ;


    //____________________________________ G & S :(
    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        Authentication.activeId = activeId;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        Authentication.activeUser = activeUser;
    }

    //________________________________________ )

    public void signIn(App app){

        try {
            System.out.print("Please enter your Username: ");
            String id = Menu.input.next();
            System.out.print("Please enter your password: ");
            String password = Menu.input.next();
            for (int i = 0; i < app.getUsers().length; i++) {
                if (app.getUsers()[i] != null && app.getUsers()[i].getId().equals(id) ){
                    if (app.getUsers()[i].getPassword().equals(password) ){
                        System.out.println(Color.GREEN + "your registration has been successful:)" + Color.RESET );
                        Authentication.activeId = id;
                        Authentication.activeUser = app.getUsers()[i];
                        App.menu.home(app);
                        return;
                    }
                }
            }
            System.out.println(Color.RED + "[ERROR]:Incorrect Password or Id!" + Color.RESET );

        }catch (Exception e){
            System.out.print(Color.RED + "[ERROR]:check your input argument and try again!\n" + Color.RESET);

        }finally {
            App.menu.start(app);
        }

    }

    public void signUp(App app){

        User user1;
        System.out.println("Please complete the information below.");
        System.out.print("name: ");
        String name = Menu.input.next();
        System.out.print("\nlast name: ");
        String lastName = Menu.input.next();
        System.out.print("\nUser name: ");
        String id = Menu.input.next();
        System.out.print("\npassword: ");
        String password = Menu.input.next();
        System.out.print("\nyour email address: ");
        String email = Menu.input.next();
        user1 = new User(name,lastName,id,password,email);
        app.addUser(user1);
        App.menu.start(app);

    }
    public void checkId(){

    }
    public void checkPassword(){

    }

    public void changPassword(App app){
        System.out.print("Enter your new password: ");
        String password1 = Menu.input.next();
        System.out.print("Enter your new password again: ");
        String password2 = Menu.input.next();
        if (password1.equals(password2)){
            this.getActiveUser().setPassword(password2);
            System.out.println(Color.GREEN + "your password changed." + Color.RESET );
        }
        else {
            System.out.println(Color.RED + "[ERROR]:your passwords not same! password do not change." + Color.RESET );
        }

    }
}
