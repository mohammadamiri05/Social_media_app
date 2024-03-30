package Main;
import Account.*;
import User.*;

public class App {

    private User[] users;
    private Post[] top_post;
    private User activeUser;
    public static Authentication authentication = new Authentication();
    public static Menu menu = new Menu();



    //________________________________________ S & G :(
    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Post[] getTop_post() {
        return top_post;
    }

    public void setTop_post(Post[] top_post) {
        this.top_post = top_post;
    }

    //____________________________________________________ )





}
