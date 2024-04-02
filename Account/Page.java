package Account;
import Main.*;
import User.*;

public class Page {

    private String bio;
    private Post[] posts;
    private User[] follower;
    private User[] following;
    private int n_post;
    private int n_follower;
    private int n_following;


    public Page( int nPost , int nFollower , int nFollowing ){
        this.posts = new Post[nPost];
        this.follower = new User[nFollower];
        this.following = new User[nFollowing];
    }



    //________________________________________ setter and getter :(

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

    public void showFollower( App app){
        System.out.println("Followers:");
        for (int i = 0; i < n_follower; i++) {
            System.out.printf("[%d]:%s\n",i+1,follower[i].getId());
        }
    }
    public void showFollowing( App app){
        System.out.println("Followings:");
        for (int i = 0; i < n_following; i++) {
            System.out.printf("[%d]:%s\n",i+1,following[i].getId());
        }
    }

    public void addPost(String text , boolean comments){
        for (int i = 0; i < this.posts.length; i++) {
            if (this.posts[i] == null ){
                posts[i] = new Post(text , comments);
                break;
            }
        }
    }

    public void showAllPost(){
        for (int i = 0; i < this.posts.length; i++) {
            if (this.posts[i] != null ){
                System.out.printf("[%d]:%s\n",(i+1),this.posts[i].getText());
                System.out.printf("Like:%s\t\tcomments:%s\n",posts[i].getLike(),posts[i].getN_comments());
                System.out.println("-----------------------------------------------");
            }
        }
    }



}
