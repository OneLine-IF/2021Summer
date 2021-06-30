package android.example.assignment2;

public class BookInfo {
    public String title;
    public String writer;

    public BookInfo(){

    }

    public BookInfo(String title, String writer){
        this.title=title;
        this.writer=writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
