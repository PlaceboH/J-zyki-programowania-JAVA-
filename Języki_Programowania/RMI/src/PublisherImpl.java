import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class PublisherImpl extends UnicastRemoteObject implements IPublisher {

    private ArrayList<Subscriber> sub;
    private ArrayList<Book> books;



    protected PublisherImpl() throws RemoteException {
        sub = new ArrayList<Subscriber>();
        books = new ArrayList<Book>();

    }

    @Override
    public boolean register(Subscriber subscriber) {
        this.sub.add(subscriber);
        return true;
    }

    @Override
    public boolean unregister(Subscriber subscriber) {
        sub.remove(subscriber);
        return true;
    }

    @Override
    public void createBook(String title, ArrayList<String> authors, int pages, STYLE g) {
        Book b = new Book(title, authors, pages, g);
        books.add(b);
        publish(b);
    }


    @Override
    public void publish(Book book) {
        for(int i= 0; i < sub.size(); i ++){
            Subscriber s = sub.get(i);
            ArrayList<STYLE> styles = s.getGenres();
            for(int j= 0; j < styles.size(); j++){
                if(styles.get(j) == book.style){
                    s.getBook(book);
                }
            }
        }
    }
}
