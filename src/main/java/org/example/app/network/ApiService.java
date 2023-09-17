package org.example.app.network;

import org.example.app.entity.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import java.util.List;

public interface ApiService {
    @GET("posts/")
    Call<List<Post>> getAllPosts();

    @GET("posts/{id}")
    Call<Post> getUserIdPost(@Path("id") int id);
}
