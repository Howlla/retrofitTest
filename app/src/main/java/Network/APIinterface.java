package Network;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by bhavyesharma on 11/07/17.
 */

public interface APIinterface {
    @GET("posts")
    Call<ArrayList<Post>> getPosts();
}
