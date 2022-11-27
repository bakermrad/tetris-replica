package LinkedList;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class userLinkedList implements Serializable {

    Node top;

    public userLinkedList() {
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void insert(String name, String pass) {
        final String secretKey = "bau";

        AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
        String encryptedname = aesEncryptionDecryption.encrypt(name, secretKey);
        String encryptedpassword = aesEncryptionDecryption.encrypt(pass, secretKey);

        Node newUser = new Node(encryptedname, encryptedpassword);
        if (isEmpty()) {
            top = newUser;
            return;
        } else {
            Node temp = top;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public void display() {
        Node n = top;
        while (n != null) {
            System.out.println(n.getUserName());
            n = n.next;
        }

    }

    public boolean checklogin(String name, String pass) {
        if (isEmpty()) {
            return false;
        } else {
            Node temp = top;
            while (temp != null) {
                final String secretKey = "bau";

                AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
                String password = aesEncryptionDecryption.decrypt(temp.getPassword(), secretKey);
                String user = aesEncryptionDecryption.decrypt(temp.getUserName(), secretKey);
                if (password.equals(pass) && user.equals(name)) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }

}
