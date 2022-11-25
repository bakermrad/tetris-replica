package tetris;

import LinkedList.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Signup extends javax.swing.JFrame {
    userLinkedList ll = new userLinkedList();
    
    public Signup() {
        initComponents();
        wrongpassword.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JButton();
        signup = new javax.swing.JButton();
        wrongpassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        signup.setText("Sign up");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });

        wrongpassword.setForeground(new java.awt.Color(255, 51, 51));
        wrongpassword.setText("wrong password or email");
        wrongpassword.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wrongpassword))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(wrongpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        this.setVisible(false);
        try {
            read();
            ll.display();
        } catch (IOException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
        String username = JOptionPane.showInputDialog("username");
        String password = JOptionPane.showInputDialog("password");
        
        boolean b = ll.checklogin(username, password);
        if (b == true) {
            Tetris.showStartup();
        } else {
            this.setVisible(true);
            wrongpassword.setVisible(true);

        }
    }//GEN-LAST:event_loginActionPerformed
    

    
    
    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        String username = JOptionPane.showInputDialog("username");
        String password = JOptionPane.showInputDialog("password");
        if(username == null || password == null){
            return;
        }
        else{
            try { 
                read();
            } catch (IOException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }
        ll.insert(username, password);
        ll.display();
        try {
            write(ll);
        } catch (IOException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_signupActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }
    
    public void write(userLinkedList myList) throws FileNotFoundException, IOException{
    FileOutputStream fileout = new FileOutputStream("tmp.ser");
    ObjectOutputStream out = new ObjectOutputStream(fileout);
    out.writeObject(myList);
    out.close();
    fileout.close();
        System.out.println("object info saved");
    }
    
    public void read() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream filein = new FileInputStream("tmp.ser");
        ObjectInputStream in = new ObjectInputStream(filein);
        ll = (userLinkedList) in.readObject();
        in.close();
        filein.close();
        
    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton login;
    private javax.swing.JButton signup;
    private javax.swing.JLabel wrongpassword;
    // End of variables declaration//GEN-END:variables
}
