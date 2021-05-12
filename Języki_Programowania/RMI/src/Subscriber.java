import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;

public class Subscriber {

    private static IPublisher publisher;
    private static ArrayList<STYLE> genres;
    private static ArrayList<Book> books;

    public  void getBook(Book book){
        books.add(book);
    }
    public  ArrayList<STYLE> getGenres(){
        return genres;
    }

    public void getAll(){
        for(int i = 0; i  < books.size(); i++){
            System.out.println(books.get(i).toString());
        }
    }


    Subscriber() throws RemoteException {
        publisher.register(this);
        books = new ArrayList<Book>();
        genres = new ArrayList<STYLE>();
        genres.add(STYLE.Naukowa);
        genres.add(STYLE.Piekna);
        genres.add(STYLE.Pulicystyczna);
    }

     public static void main(String args[]) throws RemoteException, NotBoundException, MalformedURLException, NamingException {
         Context context = new InitialContext();

         Enumeration<NameClassPair> e = context.list("rmi://localhost/");
         while (e.hasMoreElements()) {
             System.out.println(e.nextElement().getName());
         }

         Subscriber subscriber = new Subscriber();
         publisher  = (IPublisher)context.lookup("rmi://localhost/ipub");
         ArrayList<String> a = new ArrayList<String>();
         a.add("adam");
         publisher.register(subscriber);
         publisher.createBook("word", a, 100, STYLE.Naukowa);

         subscriber.getAll();

    }







}
