package Account;
import User.*;
import Setting.*;

public class Page {

    private String bio;
    private Post[] posts;
    private User[] follower;
    private User[] following;
    private int n_post;
    private int n_follower;
    private int n_following;


    public Page(){
        this.bio = Config.DEFAULT_BIO;
        this.posts = new Post[Config.MAX_POST];
        this.follower = new User[Config.MAX_FOLLOWER];
        this.following = new User[Config.MAX_FOLLOWING];
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

    public void showFollower(){
        System.out.println("Followers:");
        for (int i = 0; i < n_follower; i++) {
            if (follower[i] != null ){
                System.out.printf("[%d]:%s\n",i+1,follower[i].getId());
            }
        }
    }
    public void showFollowing(){
        System.out.println("Followings:");
        for (int i = 0; i < n_following; i++) {
            if (following[i] != null){
                System.out.printf("[%d]:%s\n",i+1,following[i].getId());
            }
        }
    }

    public void follow(User user){
        for (int i = 0; i < follower.length; i++) {
            if (follower[i] != null){
                if ( follower[i].getId().equals(Authentication.activeId)) {
                    System.out.println(Color.YELLOW +"you follow this page before!" + Color.RESET);
                    break;
                }
            }else {
                follower[n_follower] = Authentication.activeUser;
                n_follower++;
                Authentication.activeUser.getPage().following(user);
                System.out.println( Color.GREEN +"you follow page." + Color.RESET);
                break;
            }

        }
    }

    public void unfollow(User user){
        for (int i = 0; i < follower.length; i++) {
            if (follower[i] != null ) {
                if (follower[i].getId().equals(Authentication.activeId)) {
                    follower[i] = null;
                    n_follower--;
                    Authentication.activeUser.getPage().unFollowing(user);
                    System.out.println(Color.GREEN + "you unfollow page" + Color.RESET);
                    return;
                }
            }
        }
        System.out.println(Color.YELLOW + "you don not follow this page before" + Color.RESET);

    }

    public void following(User user){
        following[n_following] = user;
        n_following++;
    }
    public void unFollowing(User user){
        for (int i = 0; i < following.length; i++) {
            if (following[i] != null) {
                if (following[i].getId().equals(user.getId())) {
                    following[i] = null;
                    n_following--;
                    return;

                }
            }

        }
    }

    public void addPost(String text , boolean comments){
        this.posts[n_post] = new Post(text , comments);
        this.n_post++;

    }

    public void deletePost( int n_post){
        this.posts[n_post] = null;
        for (int i = n_post; i < posts.length - 1 ; i++) {
            if (posts[i+1] != null){
                posts[i] = posts[i+1];
                posts[ i+1 ] = null;
            }
        }
        System.out.println(Color.GREEN + "you delete post." + Color.RESET);
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
