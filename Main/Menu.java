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
                case 2:
                    App.authentication.signUp(app);
                default:
                    System.err.print("invalid argument! try again.\n");
                    start(app);
            }
        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! \n");
            start(app);
        }
    }

    public void printFooter(){
        System.out.print("[0]:Exit\t[-1]:Home\t[-2]:My page\t[-3]:Search\t[-4]Private chat\n");
    }
    public void footer( int choice , App app){
        try {
            switch (choice){
                case 0:
                    start(app);
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
            System.err.print("[ERROR]:check your input argument and try again! \n");
            //home
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
            System.err.print("[ERROR]:check your input argument and try again! \n");
            home(app);
        }
    }

    public void myPage(App app){
        System.out.print("[1] Follower: "+ app.getActiveUser().getPage().getN_follower() + "\t");
        System.out.println("[2] Following: "+ app.getActiveUser().getPage().getN_following());
        System.out.println("[3]:Change information\n[4]:Posts");

        try {
            switch (input.nextInt()){
                case 1:
                    App.authentication.getActiveUser().getPage().showFollower(app);
                case 2:
                    //following
                case 3:
                    //change information
                case 4:
                    //show all post
                default:
                    System.err.print("invalid argument! try again.\n");
                    home(app);
            }
        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! \n");
            home(app);
        }
    }

    public void follower(App app){

    }




}
