package Main;
import java.util.Scanner;

public class Menu {

    public  static Scanner input = new Scanner(System.in);


    public void start(App app){

        System.out.print("[0]:Exit.\n[1]:Sign in.\n[2]:Sign up.\nPlease enter your choice: ");
        try {
            switch (input.nextInt()){
                case 0:
                    System.exit(0);//we should test this
                case 1:
                    App.authentication.signIn(app);
                    break;
                case 2:
                    App.authentication.signUp(app);
                    break;
                default:
                    System.err.print("invalid argument! try again.\n");
                    start(app);
                    break;
            }
        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! \n");
            start(app);
        }
    }

    public void printFooter(){
        System.out.print("[0]:Exit\t[-1]:Home\t[-2]:My page\t[-3]:Search\t[-4]Private chat\n");
        System.out.println("------------------------------------------------");
    }
    public void footer( int choice , App app){
        try {
            switch (choice){
                case 0:
                    start(app);
                    break;
                case -1:
                    home(app);
                    break;
                case -2:
                    myPage(app);
                    break;
                case -3:
                    //search
                    break;
                case -4:
                    //privateChat
                    break;

            }
        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! FOOTER\n");
            home(app);
        }
    }

    public void home(App app){
        printFooter();
        //show 5 top post and footer

        System.out.print("Please enter your choice: ");
        try {
            int choice = input.nextInt();
            if(choice > 0 ){
                //show post [choice]
            }
            else {
                footer(choice , app);
            }
        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! HOME\n");
            home(app);
        }
    }

    public void myPage(App app){
        printFooter();
        System.out.println("[1] Follower: "+ App.authentication.getActiveUser().getPage().getN_follower());
        System.out.println("[2] Following: "+ App.authentication.getActiveUser().getPage().getN_following());
        System.out.println("[3]:Change information\n[4]:My Posts\n[5]:Add new post");

        try {
            int choice = input.nextInt();
            if (choice <= 0 ){
                footer(choice,app);
                return;
            }
            switch (choice){
                case 1:
                    App.authentication.getActiveUser().getPage().showFollower(app);
                    break;
                case 2:
                    App.authentication.getActiveUser().getPage().showFollowing(app);
                    break;
                case 3:
                    //change information
                    break;
                case 4:
                    showPosts(app);
                    break;
                case 5:
                    addPost();
                    myPage(app);
                    break;
                default:
                    System.err.print("invalid argument! try again.\n");
                    home(app);
                    break;
            }
        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! MYPAGE\n");
            home(app);
        }
    }

    public void addPost(){
        System.out.print("enter your text:\n");
        input.nextLine();
        String text = input.nextLine();

        System.out.println("[0]:Back\n[1]:comments ON\t\t[2]:comments OFF");
        int comment = input.nextInt();
        if (comment == 0 ){
            System.err.println("Post not added!");
        }
        else if(comment == 1 ){
            App.authentication.getActiveUser().getPage().addPost(text,true);
            System.out.println("Post added");
        }
        else {
            App.authentication.getActiveUser().getPage().addPost(text,false);
            System.out.println("Post added");
        }
    }

    public void showPosts(App app){
        printFooter();
        App.authentication.getActiveUser().getPage().showAllPost();
        System.out.print("Enter your choice: ");

        try {
            int choice = input.nextInt();
            if(choice > 0 ){
                collectPost(choice - 1 , app );
            }
            else {
                footer(choice , app);
            }
        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! HOME\n");
            home(app);
        }
    }
    public void collectPost(int choice , App app){
        printFooter();
        App.authentication.getActiveUser().getPage().getPosts()[choice].showPost(App.authentication.getActiveUser());
        try {
            System.out.print("Enter your choice: ");
            int choice1 = input.nextInt();
            footer(choice , app);

        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! HOME\n");
            home(app);
        }
    }




}
