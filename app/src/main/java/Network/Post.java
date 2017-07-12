package Network;

/**
 * Created by bhavyesharma on 11/07/17.
 */

public class Post {
    int userId;
    int id;
    String title;
    String body;

    public String getTitle() {
        return title;
    }

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
