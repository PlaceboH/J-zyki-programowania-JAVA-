import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

interface IPublisher extends Remote {
    void  createBook(String title, ArrayList<String> authors, int pages, STYLE g) throws RemoteException;
    boolean register(Subscriber subscriber)throws RemoteException;
    boolean unregister(Subscriber subscriber)throws RemoteException;
    void publish(Book book)throws RemoteException;
}