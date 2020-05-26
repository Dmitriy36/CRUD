import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.*;

public class asdf {
    private JButton button1;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel addressLabel;
    private JLabel DOBLabel;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField addressField;
    private JTextField dobField;
    private JPanel MainForm;

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String DOB;
    private String address;

//    public static void main(String[] args) {
//
//    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Data Entry");
        frame.setContentPane(new asdf().MainForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(1000,1000);
        frame.pack();
        frame.setVisible(true);
    }

    public asdf() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstName = firstNameField.getText();
                lastName = lastNameField.getText();
                phone = phoneField.getText();
                email = emailField.getText();
                DOB = dobField.getText();
                address = addressField.getText();

                String url = "jdbc:sqlserver://localhost;databaseName=CRUD_Connection_Demo_DB";
                String user = "CRUD_User";
                String password = "1234_Snrub";

                try {
//                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection conn = DriverManager.getConnection(url, user, password);
                    Statement stmt = conn.createStatement();
//                    String sql = "EXEC dbo.Inserter " + firstName + ", " + lastName + ", " + phone + ", " + email + ", " + DOB + ", " + address + ";";
                    String sql = "INSERT INTO Customer (FirstName) VALUES ('" + firstName + "')";
                    stmt.execute(sql);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }

                showMessageDialog(null,
                        "First Name: " + firstName + "\n" +
                                "Last Name: " + lastName + "\n"
                );
            }
        });
    }
}
