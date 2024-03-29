package Main;
import Account.*;
import User.*;

public class App {

    private User[] users;
    private Post[] top_post;
    private User activeUser;
    private Authentication authentication;


    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
}
