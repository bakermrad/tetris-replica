package LinkedList;

import java.io.Serializable;

/**
 *
 * @author baker mrad
 */
public class Node implements Serializable {

    private String UserName, Password;
    Node next;

    public Node(String UserName, String Password) {
        this.Password = Password;
        this.UserName = UserName;
    }
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }

}
