import java.util.Scanner;
public class lab03_10 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x,e=0,o=0;
    while (true){
        x = sc.nextInt();
        if (x == -1){
            break;
        }
        if (x % 2 == 0){
            e += 1;
        }
        else{
            o += 1;
        }
    }
        System.out.println("Odd number = "+o+" and Even number = "+e);
    }
}
