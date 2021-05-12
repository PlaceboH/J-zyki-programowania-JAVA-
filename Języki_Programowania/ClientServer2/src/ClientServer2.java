import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ClientServer2 {

    static HashMap<String, String>  passwords = new HashMap<String, String>();

    private static void addPassword(String nr, String pass){
        passwords.put(nr, pass);
    }

    public static void main(String args[]) throws IOException {

        ServerSocket ss = new ServerSocket( 4999);
        Socket s = ss.accept();

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("cs1: " + str);

        PrintWriter pr = new PrintWriter(s.getOutputStream());

            pr.println("wpisz hasło: ");
            String ps = bf.readLine();
            pr.flush();

            pr.println("podaj numer: ");
            String nr = bf.readLine();
            pr.flush();

            addPassword(ps, nr);





    }


}
