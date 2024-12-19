import java.util.Scanner;
public class lab03_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input tower's height : ");
        int x = sc.nextInt();
        for (int i = 1; i <= x; i++){
            System.out.println("#-#-#-#-#");
        }
    }
}
