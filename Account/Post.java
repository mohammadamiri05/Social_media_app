package Account;
import User.*;
import  Main.*;

public class Post {

    private String text;
    private int like;
    private String[] comments;
    private int n_comments;


    public Post(String text , boolean comments ){

        this.text = text;
        this.like = 0;
        this.n_comments = 0;
        if (comments){
            this.comments = new String[10];
        }else {
            this.comments = new String[0];
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
        System.out.println(user.getId());
        System.out.println(this.text);
        System.out.println("_________________________________________________");
        if (this.comments.length < 1){
            System.out.println("you could not send any comments for this post.");
            return;
        }
        for (int i = 0; i < this.comments.length; i++) {
            if (this.comments[i] != null ){
                System.out.println(this.comments[i]);
                System.out.println("-----------------------");
            }
        }
    }
}
