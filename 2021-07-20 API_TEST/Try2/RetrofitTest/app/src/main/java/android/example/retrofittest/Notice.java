package android.example.retrofittest;

import com.google.gson.annotations.SerializedName;

public class Notice {
    String title;
    String content;

    public Notice(String title, String content){
        this.title=title;
        this.content=content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public class Post{
        @SerializedName("title")
        private String title;
        @SerializedName("content")
        private String content;
    }
}

