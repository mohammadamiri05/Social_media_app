package Account;

import User.*;

public class Page {

    private String bio;
    private Post[] posts;
    private User[] follower;
    private User[] following;
    private int n_post;
    private int n_follower;
    private int n_following;



    //________________________________________-setter and getter :(

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Post[] getPosts() {
        return posts;
    }

    public void setPosts(Post[] posts) {
        this.posts = posts;
    }

    public User[] getFollower() {
        return follower;
    }

    public void setFollower(User[] follower) {
        this.follower = follower;
    }

    public User[] getFollowing() {
        return following;
    }

    public void setFollowing(User[] following) {
        this.following = following;
    }

    public int getN_post() {
        return n_post;
    }

    public void setN_post(int n_post) {
        this.n_post = n_post;
    }

    public int getN_follower() {
        return n_follower;
    }

    public void setN_follower(int n_follower) {
        this.n_follower = n_follower;
    }

    public int getN_following() {
        return n_following;
    }

    public void setN_following(int n_following) {
        this.n_following = n_following;
    }


    //________________________________________ )

}
