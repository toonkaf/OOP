public class Main {
 public static void main(String[] args) {
 Pigeous p1 = new Pigeous("Alex",8);
 Pigeous p2 = new Pigeous("John",6);
 System.out.println(p1);
 System.out.println(p2);
 p2.wingAttack(p1, 5);
 System.out.println(p1.toString());
 System.out.println(p2.toString());
 p1.fly();
 }
}