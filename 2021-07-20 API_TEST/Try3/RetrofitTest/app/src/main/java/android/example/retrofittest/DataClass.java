package android.example.retrofittest;

import com.google.gson.annotations.SerializedName;

public class DataClass {
    // @SerializedName으로 일치시켜 주지않을 경우엔 클래스 변수명이 일치해야함
    @SerializedName("title")
    public String title;

    @SerializedName("content")
    public String content;


    // toString()을 Override 해주지 않으면 객체 주소값을 출력함
    @Override
    public String toString() {
        return "PostResult{" +
                "name=" + title +
                ", content=" + content + '\'' +
                '}';
    }
}
