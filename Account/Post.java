package Account;
import User.*;
import Setting.*;

public class Post {

    private String text;
    private int like;
    private String[] personLikePost;
    private String[] comments;
    private int n_comments;
    boolean isValidComment;


    public Post(String text , boolean comments ){

        this.personLikePost = new String[100];
        this.text = text;
        this.like = 0;
        this.n_comments = 0;
        this.isValidComment = comments;
        if (comments){
            this.comments = new String[10];
        }else {
            this.comments = new String[1];
        }
    }

    //_____________________________________________ S&G :(

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public int getN_comments() {
        return n_comments;
    }

    public void setN_comments(int n_comments) {
        this.n_comments = n_comments;
    }

    //_____________________________________________________ )


    public void showPost(User user){
        System.out.print(Color.RED);
        System.out.println(user.getId());
        System.out.print(Color.BLUE);
        System.out.println(this.text);
        System.out.print(Color.YELLOW);
        System.out.println("_________________________________________________");
        if (this.comments.length < 3 ){
            System.out.println("you could not send any comments for this post.");
            return;
        }
        for (int i = 0; i < this.comments.length; i++) {
            if (this.comments[i] != null ){
                System.out.println(this.comments[i]);
                System.out.println("-----------------------");
            }
        }
        System.out.print(Color.RESET);
    }

    public void likePost(){

        for (int i = 0; i < this.personLikePost.length ; i++) {
            if (personLikePost[i] != null && personLikePost[i].equals(Authentication.activeId)){
                System.out.println("you liked this post before.");
                return;
            }
        }
        this.like++;
        for (int i = 0; i < personLikePost.length; i++) {
            if (personLikePost[i] == null){
                personLikePost[i] = Authentication.activeId;
                System.out.println("you like this post.");
                return;
            }
        }

    }

    public void comment(String comment){
        for (int i = 0; i < this.comments.length; i++) {
            if (this.comments[i] == null){
                this.comments[i] = comment;
                this.n_comments++;
                System.out.println("your comment added.");
                return;
            }
        }
        System.err.println("your comment not added.");
    }
}
