package Main;
import User.*;
import Account.*;

import java.io.Console;
import java.util.Scanner;

public class Menu {

    public  static Scanner input = new Scanner(System.in);
    private App app;
    private Authentication authentication;


    public Menu(App app , Authentication authentication){
        this.app = app;
        this.authentication = authentication;
    }


    public void start(){

        System.out.print("[0]:Exit.\n[1]:Sign in.\n[2]:Sign up.\nPlease enter your choice: ");
        try {
            switch (input.nextInt()){
                case 0:
                    System.exit(0);//we should test this
                case 1:
                    //Authentication.signIn
                case 2:
                    //Authentication.signUp
                default:
                    System.err.print("invalid argument! try again.\n");
                    start();
            }
        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! \n");
            start();
        }
    }

    public void printFooter(){
        System.out.print("[0]:Exit\t[-1]:Home\t[-2]:My page\t[-3]:Search\t[-4]Private chat\n");
    }

    public void footer( int choice ){
        try {
            switch (choice){
                case 0:
                    start();
                case -1:
                    //home
                    break;
                case -2:
                    //myPage
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
    public void home(){
        printFooter();
        //show 5 top post and footer

        System.out.print("Please enter your choice: ");
        try {
            int choice = input.nextInt();
            if(choice > 0 ){
                //show post [choice]
            }
            else {
                footer(choice);
            }
        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! \n");
            home();
        }
    }

    public void myPage(){
        System.out.print("[1] Follower: "+ app.getActiveUser().getPage().getN_follower() + "\t");
        System.out.println("[2] Following: "+ app.getActiveUser().getPage().getN_following());
        System.out.println("[3]:Change information\n[4]:Posts");

        try {
            switch (input.nextInt()){
                case 1:
                    //follower
                case 2:
                    //following
                case 3:
                    //change information
                case 4:
                    //show all post
                default:
                    System.err.print("invalid argument! try again.\n");
                    start();
            }
        }catch (Exception e){
            System.err.print("[ERROR]:check your input argument and try again! \n");
            start();
        }
    }






}
