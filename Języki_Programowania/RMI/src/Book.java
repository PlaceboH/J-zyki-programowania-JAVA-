import java.util.ArrayList;

public class Book{
    String title;
    ArrayList<String> authors = new ArrayList<>();
    int pages;
    STYLE style;

    Book(String title, ArrayList<String> authors, int pages, STYLE style){
        this.title = title;
        this.authors = authors;
        this.pages = pages;
        this.style = style;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", pages=" + pages +
                ", style=" + style +
                '}';
    }
}
