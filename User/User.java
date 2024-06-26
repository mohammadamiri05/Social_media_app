package User;
import Account.*;
import Main.*;


public class User {

    private String name;
    private String last_name;
    private String id;
    private String password;
    private String email;

    private Page page;
    private PrivateChat[] chat_box;




    public User(String name, String last_name, String id, String password, String email) {
        this.name = name;
        this.last_name = last_name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.page = new Page();
    }

//________________________________________ setter and getter :(


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public PrivateChat[] getChat_box() {
        return chat_box;
    }

    public void setChat_box(PrivateChat[] chat_box) {
        this.chat_box = chat_box;
    }



    //_______________________________________ )


    public void showFollower(){
        page.showFollower();
    }
    public void showFollowing(){
        page.showFollowing();
    }

    public void changeName(){

        System.out.print("Enter your new name: ");
        this.name = Menu.input.next() ;
    }

    public void changeLastname(){
        System.out.print("Enter your new lastname: ");
        this.last_name = Menu.input.next();
    }

}
