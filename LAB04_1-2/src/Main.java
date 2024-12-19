import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyAdd2 obj = new MyAdd2();
        
        System.out.println("Please insert number1 : ");
        int x = sc.nextInt();
        System.out.println("Please insert number2 : ");
        int num = sc.nextInt();
        
        int result = obj.AddTwo(x);
        System.out.println("The result#1 is "+result);
        
        result = obj.AddNum(x+5,num);
        System.out.println("The result#2 is "+result);
        
        result = obj.AddTwo(x*3+2);
        System.out.println("The result#3 is "+result);
    }
}




/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyAdd cm = new MyAdd();
        
        System.out.println("Please insert number : ");
        int x = sc.nextInt();
        int num = cm.AddTwo(x);
        System.out.println("The result#1 is "+num);
        
        num = cm.AddTwo(x+5);
        System.out.println("The result#2 is "+num);
        
        num = cm.AddTwo(x*3+2);
        System.out.println("The result#3 is "+num);
    }
}*/