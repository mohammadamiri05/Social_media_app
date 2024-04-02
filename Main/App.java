package Main;
import Account.*;
import User.*;

public class App {

    private User[] users;
    private Post[] top_post;
    public static Authentication authentication = new Authentication();
    public static Menu menu = new Menu();



    public App( int nUser , int nPost ){
        this.users = new User[nUser];
        this.top_post = new Post[nPost];
    }


    //________________________________________ S & G :(

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

    public void addUser(User user){

        for (int i = 0; i < this.users.length; i++) {
            if (users[i] == null){
                this.users[i] = user;
                break;
            }
        }
    }

    public void searchUser(String id , App app){
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i] != null && this.users[i].getId().equals(id)){
                App.menu.showPage(app , this.users[i]);
                return;
            }
        }
    }





}
