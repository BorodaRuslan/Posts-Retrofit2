package org.example.app.model;

import org.example.app.entity.Post;
import org.example.app.network.ApiClient;
import org.example.app.network.ApiService;
import org.example.app.utils.Constants;
import retrofit2.Call;
import retrofit2.Response;
import java.io.IOException;
import java.util.Optional;

public class PostByIdModel {

    private Optional<Response<Post>> getPostForId(int id) {
        ApiClient apiClient = new ApiClient();
        ApiService apiService = apiClient.getApiService();
        Call<Post> listPosts = apiService.getUserIdPost(id);
        Optional<Response<Post>> optional;

        try {
            optional = Optional.of(listPosts.execute());
        } catch (IOException e) {
            optional = Optional.empty();
        }
        return optional;
    }

    public String showPostForId(int id) {
        Optional<Response<Post>> optional = getPostForId(id);
        StringBuilder sb = new StringBuilder();

        if (optional.isEmpty()) {
            return Constants.NO_DATA;
        } else {
            Post post = optional.get().body();
            if (post != null) {
                sb.append("ID: ")
                        .append(post.getId())
                        .append("\n")
                        .append("TITLE: ")
                        .append(post.getTitle())
                        .append(".")
                        .append("\n")
                        .append("BODY: ")
                        .append(post.getBody())
                        .append(".");
            }
        }
        return sb.toString();
    }
}
