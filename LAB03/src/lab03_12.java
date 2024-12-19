import java.util.Scanner;
public class lab03_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please insert a number : ");
        int x = sc.nextInt();
        while (x > 0){
            for (int i = 1; x != 0 && i <= 5; i++ , x--){
                System.out.print("|");
            }
            System.out.println("");
        }
    }
}
