import java.util.Scanner;

public class Test2 {
     static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        getIntegerInput();
    }

    public static int getIntegerInput() {
        int number;
        try{
            number = sc.nextInt();
        }   catch (Exception e){
            System.out.println("whatttttt?");
            sc.nextLine();
            number = getIntegerInput();
        }
        return number;

    }
}
