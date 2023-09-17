package org.example.app.model;

import org.example.app.entity.Post;
import org.example.app.network.ApiClient;
import org.example.app.network.ApiService;
import org.example.app.utils.Constants;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public class AllPostsModel {

    private Optional<Response<List<Post>>> getAllPosts() {
        ApiClient apiClient = new ApiClient();
        ApiService service = apiClient.getApiService();
        Call<List<Post>> allPosts = service.getAllPosts();
        Optional<Response<List<Post>>> optional;

        try {
            optional = Optional.of(allPosts.execute());
        } catch (IOException e) {
            optional = Optional.empty();
        }
        return optional;
    }

    public String showAllPosts() {
        Optional<Response<List<Post>>> allPosts = getAllPosts();
        StringBuilder sb = new StringBuilder();

        if (allPosts.isEmpty()) {
            return Constants.NO_DATA;
        } else {
            List<Post> postList = allPosts.get().body();
            if (postList != null) {
                for (Post p : postList) {
                    sb.append("ID: ")
                            .append(p.getId())
                            .append("\n")
                            .append("TITLE: ")
                            .append(p.getTitle())
                            .append(".")
                            .append("\n")
                            .append("BODY: ")
                            .append(p.getBody())
                            .append(".")
                            .append("\n");
                }
            }
            return sb.toString();
        }
    }

}
