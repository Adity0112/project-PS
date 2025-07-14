import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class loginclass  extends JFrame {
    private  JTextField usernameField;
    private JPasswordField passwordField;

    public loginclass(){
        setTitle("LOGIN");
        setSize(300,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //  it close the operation
        setLocationRelativeTo(null);  // it help to center the window on screen

        JPanel panel = new JPanel(new GridLayout(3,2)); // its like a blank box

        panel.add(new JLabel("User Name"));
        usernameField = new JTextField(); /* (Makes an input box where the
                                              user can type their name.) */
        panel.add(usernameField); // Saves it in usernameField,


        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginbtn = new JButton("login");
        panel.add(loginbtn);

        add(panel);

        loginbtn.addActionListener(e->{
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("1234")){
                dispose(); // close the curent login window
                new Dashboard(); // new class open
            }else {
                JOptionPane.showMessageDialog(this,"Galat H");
                // JOptionPane ek class h or showMessageDialog ek method
            }

        });

        setVisible(true);

    }

}
