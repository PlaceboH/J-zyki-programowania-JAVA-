import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sockets {
    private static int port1;
    private static int port2;
    private static int port3;
    private static int port4;
    public static List lista = new ArrayList<String>();


    public static void main(String[] args) throws IOException {
        GreetServer s1 = new GreetServer();
        GreetServer s2 = new GreetServer();

        GreetClient c1 = new GreetClient();
        GreetClient c2 = new GreetClient();


        Scanner in = new Scanner(System.in);
        System.out.println("port1");
        port1 = Integer.parseInt(in.nextLine());
        System.out.println("port2");
        port2 = Integer.parseInt(in.nextLine());
        System.out.println("port3");
        port3 = Integer.parseInt(in.nextLine());
        System.out.println("port4");
        port4 = Integer.parseInt(in.nextLine());

        Runnable run1 = () -> {
            try {
                s1.start(port1, lista);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Runnable run2 = () -> {
            try {
                s2.start(port2, lista);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Thread thr1 = new Thread(run1);
        Thread thr2 = new Thread(run2);

        thr1.start();
        thr2.start();

        c1.startConnection("localhost", port3);
        c1.startConnection("localhost", port4);

        while(true) {
            System.out.println("input pass n - 0/t - 1");

            int ans = Integer.parseInt(in.nextLine());
            if(ans == 1){
                System.out.println("Podaj pass:");
                String pass = in.nextLine();
                int len = pass.length() / 3;
                String pass1 = pass.substring(0, len);
                String pass2 = pass.substring(len, 2 * len);
                String pass3 = pass.substring(2 * len, 3 * len);

               // c1.startConnection("localhost", port1);
                c1.sendMessage(pass1);

               // c1.startConnection("localhost", port2);
                c2.sendMessage(pass2);

                lista.add(pass3);
            }
            System.out.println("get pass n - 0/t - 1");

            ans = Integer.parseInt(in.nextLine());
            if(ans == 1){

               System.out.println("Podaj id: ");
               int id = Integer.parseInt(in.nextLine());
               //c1.startConnection("localhost", port1);
               String pass1 = c1.sendMessage(id);
               //c1.startConnection("localhost", port2);
               String pass2 = c2.sendMessage(id);

               System.out.print(pass1);
               System.out.print(pass2);
               System.out.print(lista.get(id));
               System.out.println("");
            }
        }
    }
}
