package Main;
import User.*;
import Setting.*;

import java.util.Scanner;

public class Menu {

    public  static Scanner input = new Scanner(System.in);



    //______________________________________________________

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

        System.out.print( Color.CYAN);
        System.out.println("------------------------------------------------------------------------");
        System.out.print("|  [0]:Exit\t[-1]:Home\t[-2]:My page\t[-3]:Search\t[-4]:Private chat  |\n");
        System.out.println("------------------------------------------------------------------------");
        System.out.print(Color.RESET);
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
                    searchUser(app);
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

        System.out.print("Please enter your choice: ");
        try {
            int choice = input.nextInt();
            if(choice > 0 ){
                app.showTopPost();
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
        System.out.print(Color.YELLOW);
        System.out.println("[1] Follower: "+ Authentication.activeUser.getPage().getN_follower());
        System.out.println("[2] Following: "+ Authentication.activeUser.getPage().getN_following());
        System.out.println("[3]:Change information\n[4]:My Posts\n[5]:Add new post");
        System.out.print(Color.RESET);
        try {
            int choice = input.nextInt();
            if (choice <= 0 ){
                footer(choice,app);
                return;
            }
            switch (choice){
                case 1:
                    Authentication.activeUser.getPage().showFollower(app);
                    break;
                case 2:
                    Authentication.activeUser.getPage().showFollowing(app);
                    break;
                case 3:
                    information(app);
                    break;
                case 4:
                    showPage(app , Authentication.activeUser);
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

    public void searchUser(App app){
        try {
            System.out.print("Please enter that page id: ");
            app.searchUser(input.next() , app);

        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! SEARCH\n");
            home(app);
        }
    }

    public void addPost(){
        System.out.print("enter your text:\n");
        input.nextLine();
        String text = input.nextLine();

        System.out.print("[0]:Back\t\t[1]:comments ON\t\t[2]:comments OFF\n chose:");
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

    public void showPage(App app , User user){
        printFooter();
        System.out.print(Color.RED);
        System.out.println(user.getId());
        System.out.println(user.getPage().getBio());

        System.out.print(Color.GREEN);
        if (user.getId().equals(Authentication.activeId)) {

        }else {
            System.out.print("-------- [-5]:Follow -------- [-6]:Unfollow -------- ");
        }
        System.out.printf("[-7]:Follower: %d -------- [-8]:following: %d-------- \n",user.getPage().getN_follower(),user.getPage().getN_following());
        System.out.print(Color.RESET);

        System.out.print(Color.BLUE);
        user.getPage().showAllPost();
        System.out.print(Color.RESET);

        try {
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            if(choice > 0 ){
                exitFromPost(choice - 1 , user , app );
            }
            else {
                footer(choice , app);
                if (choice == -5){
                    user.getPage().follow(user);
                    showPage(app,user);
                }
                if (choice == -6 ){
                    user.getPage().unfollow();
                    showPage(app,user);
                }
            }
        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! HOME\n");
            home(app);
        }
    }
    public void exitFromPost(int choice , User user, App app){
        printFooter();
        user.getPage().getPosts()[choice].showPost(user);
        try {
            System.out.print("Enter your choice: ");
            int choice1 = input.nextInt();
            footer(choice1 , app);

        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! HOME\n");
            home(app);
        }
    }

    public void information(App app) {

        printFooter();
        System.out.print(Color.PURPLE);
        System.out.printf("[1]:%s\n",Authentication.activeUser.getName());
        System.out.printf("[2]:%s\n[3]:change password\n",Authentication.activeUser.getLast_name());
        System.out.printf("[4]:%s\n",Authentication.activeUser.getEmail());
        System.out.printf("[5]:%s\n",Authentication.activeUser.getPage().getBio());
        System.out.print(Color.RESET);
        System.out.print("Please enter your choice: ");

        try {
            int choice = input.nextInt();
            if (choice <= 0 ){
                footer(choice,app);
                return;
            }
            switch (choice){
                case 1:
                    System.out.print("Enter your new name: ");
                    Authentication.activeUser.setName(input.next());
                    break;
                case 2:
                    System.out.print("Enter your new lastname: ");
                    Authentication.activeUser.setLast_name(input.next());
                    break;
                case 3:
                    App.authentication.changPassword(app);
                    break;
                case 4:
                    System.out.print("Enter your new email address: ");
                    Authentication.activeUser.setEmail(input.next());
                    break;
                case 5:
                    System.out.println("Enter your bio: ");
                    input.nextLine();
                    Authentication.activeUser.getPage().setBio(input.nextLine());
                    break;
                default:
                    System.err.print("invalid argument! try again.\n");
                    information(app);
                    break;
            }
            information(app);

        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! MYPAGE\n");
            home(app);
        }

    }



}
