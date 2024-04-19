package Main;
import Account.*;
import User.*;
import Setting.*;

import java.util.Scanner;

public class Menu {

    public  static Scanner input = new Scanner(System.in);


    //______________________________________________________

    public void printWarning(){
        String str ="invalid argument! try again.";
        System.out.println(Color.YELLOW + str + Color.RESET);
    }

    public static void printError(){
        String str = "[ERROR]:check your input argument and try again!";
        System.out.println(Color.RED + str + Color.RESET);
    }


    public void start(App app){

        try {
            System.out.print("[0]:Exit.\n[1]:Sign in.\n[2]:Sign up.\nPlease enter your choice: ");
            switch (input.nextInt()){
                case 0:
                    System.exit(0);
                case 1:
                    App.authentication.signIn(app);
                    break;
                case 2:
                    App.authentication.signUp(app);
                    break;
                default:
                    printWarning();
                    start(app);
                    break;
            }
        }catch (Exception e){
            printError();
            input.nextLine();
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
            printError();
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
            printError();
            home(app);
        }
    }

    public void printMyPage(){
        System.out.print(Color.GREEN);
        System.out.println("[1] Follower: "+ Authentication.activeUser.getPage().getN_follower());
        System.out.println("[2] Following: "+ Authentication.activeUser.getPage().getN_following());
        System.out.println("[3]:Change information\n[4]:My Posts\n[5]:Add new post");
        System.out.print(Color.RESET);
    }

    public void myPage(App app){
        printFooter();
        printMyPage();

        try {
            int choice = input.nextInt();
            if (choice <= 0 ){
                footer(choice,app);
                return;
            }
            switch (choice){
                case 1:
                    Authentication.activeUser.getPage().showFollower();
                    break;
                case 2:
                    Authentication.activeUser.getPage().showFollowing();
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
                    printWarning();
                    home(app);
                    break;
            }
        }catch (Exception e){
            printError();
            home(app);
        }
    }

    public void searchUser(App app){
        try {
            System.out.print("Please enter that page id: ");
            app.searchUser(input.next() , app);

        }catch (Exception e){
            printError();
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

    public void headerPage(int choice , App app , User user){
        switch (choice){
            case -5:
                user.getPage().follow(user);
                showPage(app,user);
                break;
            case -6:
                user.getPage().unfollow();
                showPage(app,user);
                break;
            case -7:
                user.showFollower();
                selectFollower(app,user);
                break;
            case -8:
                user.showFollowing();
                break;
        }
    }

    public void printHeaderPage(User user){
        System.out.print(Color.RED);
        System.out.println(user.getId());
        System.out.println(user.getPage().getBio());

        System.out.print(Color.GREEN);
        if (!user.getId().equals(Authentication.activeId)) {
            System.out.print("-------- [-5]:Follow -------- [-6]:Unfollow -------- ");
        }
        System.out.printf("[-7]:Follower: %d -------- [-8]:following: %d -------- \n"
                ,user.getPage().getN_follower(),user.getPage().getN_following());
        System.out.print(Color.RESET);
    }

    public void showPage(App app , User user){
        printFooter();
        printHeaderPage(user);

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
                if (choice < -8 ){
                    printWarning();
                    home(app);
                }
                else {
                    footer(choice,app);
                    headerPage(choice,app,user);
                }
            }
        }catch (Exception e){
            printError();
            home(app);
        }
    }
    public void exitFromPost(int choice , User user, App app) {

        Post post = user.getPage().getPosts()[choice];

        printFooter();
        post.showPost(user);

        System.out.print(Color.PURPLE);
        System.out.printf("[1]:like:%d\t",post.getLike());
        System.out.printf("[2]:comments:%d\n",post.getN_comments());
        System.out.print(Color.RESET);

        try {
            System.out.print("Enter your choice: ");
            int choice1 = input.nextInt();
            if (choice1 > 0 ){
                if (choice1 == 1){
                    user.getPage().getPosts()[choice].likePost();
                    exitFromPost(choice,user,app);
                } else if (choice1 == 2) {
                    comment(post,app);
                    exitFromPost(choice,user,app);
                }
            }else {
                footer(choice1 , app);
            }

        }catch (Exception e){
            printError();
            home(app);
        }
    }

    public void printInformation(){
        System.out.print(Color.PURPLE);
        System.out.printf("[1]:%s\n",Authentication.activeUser.getName());
        System.out.printf("[2]:%s\n[3]:change password\n",Authentication.activeUser.getLast_name());
        System.out.printf("[4]:%s\n",Authentication.activeUser.getEmail());
        System.out.printf("[5]:%s\n",Authentication.activeUser.getPage().getBio());
        System.out.print(Color.RESET);
    }

    public void information(App app) {
        printFooter();
        printInformation();
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
                    printWarning();
                    information(app);
                    break;
            }
            information(app);

        }catch (Exception e){
            printError();
            home(app);
        }

    }

    public void comment(Post post , App app){

        System.out.print("Please enter your comment:\n");
        try{
            input.nextLine();
            String comment = input.nextLine();
            post.comment(comment);

        }catch (Exception e){
            printError();
            home(app);
        }



    }

    public void selectFollower(App app , User user){
        System.out.println("please enter your choice: ");
        try {
            int choice = input.nextInt();
            if (choice > 0 ){
                showPage(app , user.getPage().getFollower()[choice - 1]);
            }
            else {
                showPage(app,user);
            }

        }catch (Exception e){
            printError();
            home(app);
        }


    }

    public void selectFollowing(App app , User user){
        System.out.println("please enter your choice: ");
        try {
            int choice = input.nextInt();
            if (choice > 0 ){
                if (user.getPage().getFollowing()[choice - 1 ] != null){
                    showPage(app , user.getPage().getFollowing()[choice - 1]);
                }else {
                    printWarning();
                }
            }
            else {
                showPage(app,user);
            }

        }catch (Exception e){
            printError();
            home(app);
        }


    }



}
