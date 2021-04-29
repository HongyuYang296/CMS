import java.util.*;
/**
 * Write a description of class user here.
 *
 * @author team56
 * @version 1.0 (28 Apr 2021)
 */
public class User{
    private   int userid;
    private   String userName;

    /**
     * Constructor for objects of class Borrower
     */


    public User(int userid, String userName) {
        this.userid = userid;
        this.userName = userName;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", userName='" + userName + '\'' +
                '}';
    }

    public static void main(String[] args) {

    }
}


