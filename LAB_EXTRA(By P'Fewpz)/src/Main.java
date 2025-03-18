public class Main {
    public static void main(String[] args) {
        ClientAChat cA = new ClientAChat();
        ClientBChat cB = new ClientBChat();
        cA.setcliB(cB);
        cB.setcliA(cA);
    }
}
