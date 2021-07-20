package android.example.retrofittest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {
    @GET("api/v1/posts/list")
    Call<ArrayList<Notice>> findAll();

    //@FormUrlEncoded
    @POST("api/v1/posts")
    Call<Void> createUser(@Body Notice notice);
    //Call<Notice> createUser(@Field("title") String title, @Field("content") String content);

    @PUT("api/v1/posts/{id}")
    Call<Notice> putNotice(@Path("id") String id, @Body Notice notice);

    @DELETE("api/v1/posts/{id}")
    Call<Void> deleteNotice(@Path("id") String id);

    @DELETE("api/v1/posts/all")
    Call<Void> deleteNotice();
}

