import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Publisher {



   public static void main(String args[]) throws RemoteException, MalformedURLException, NamingException {

       Context context = new InitialContext();
       context.rebind("rmi://localhost:1099//ipub", new PublisherImpl());

//       PublisherImpl obj = new PublisherImpl();
//       Naming.rebind("Server", obj);
    }

}






