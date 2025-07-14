import javax.swing.*;
import java.awt.*;

public class AddcredentialDialog extends JDialog {
    public AddcredentialDialog(Dashboard dashboard){
        setTitle("Add new credential");
        setSize(300,200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4,2));


        JTextField siteField = new JTextField();
        JTextField userField = new JTextField();
        JTextField passField = new JTextField();

        add(new JLabel("Website:"));
        add(siteField);
        add(new JLabel("Username:"));
        add(userField);
        add(new JLabel("Password:"));
        add(passField);

        JButton saveBtn = new JButton("Save");
        add(saveBtn);

        saveBtn.addActionListener(e -> {
            String site = siteField.getText();
            String user = userField.getText();
            String pass = Encryptor.encrypt(passField.getText());
            /* in this encrptor.encrypt is use covert the password
            so it can not read by hacker.
             */


            Credential credential = new Credential(site, user, pass);
            dashboard.addCredential(credential);
            dispose();
        });

        setVisible(true);


    }
}
