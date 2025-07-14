import javax.security.auth.login.CredentialException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.util.ArrayList;
//import java.util.logging.FileHandler;

public class Dashboard extends JFrame {
    private DefaultListModel<String> model;
    private JList<String> list;
    private ArrayList<Credential> credentials;

    public Dashboard(){
        setTitle("RAKA the pasword manager");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        credentials = FileHandler.loadCredentials();
        model = new DefaultListModel<>();

        for (Credential c : credentials){
            model.addElement(c.getWebsite() + " | " + c.getUsername() + " | " + c.getPassword());
        }

        list = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(list);
        add(scrollPane, BorderLayout.CENTER);

        JButton addBtn = new JButton("Add Credential");
        add(addBtn,BorderLayout.SOUTH);

        addBtn.addActionListener(e ->{
            new AddcredentialDialog(this);
        });
        setVisible(true);
    }
    public void addCredential(Credential credential){
        credentials.add(credential);
        FileHandler.saveCredentials(credentials);
        model.addElement(credential.getWebsite() + " | " + credential.getUsername() + " | " + credential.getPassword());

    }
}
