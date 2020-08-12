//Author Alex Shea - Graphical User Interface Authentication Program
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI implements ActionListener {
    //Create variables store user input, user variables verify user input.
    String userName = "";
    String userPassword = "";
    String createName = "";
    String createPassword = "";
    //initializes user labels, password labels, action label, user text fields, password fields, and creation/login buttons.
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton createButton;
    private static JLabel success;
    private static JButton loginButton;
    private static JLabel authenticationApology;
    private static JLabel welcomeMessage;
    private static JLabel userOptions;
    private static JLabel emptyMessage;

    boolean authenticateName = false;
    boolean authenticatePassword = false; //initialized booleans for authentication.
    boolean test = false;

    public static void main(String[] args) throws IOException {
        JPanel panel = new JPanel(); //Creates Panel Object
        JFrame frame = new JFrame(); //Creates Frame Object

        //Frame methods
        frame.setSize(600, 400); //sets the window's size.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets what happens when the frame is closed.
        frame.setTitle("Shea Technology Login Interface");
        frame.add(panel); //adds panel to the frame.





        //Panel methods
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); //panel dimensions
        panel.setLayout(null);




        userOptions = new JLabel("Hello!, Welcome to Shea Technologies! Please Login. Don't have an account? Select Create Account.");
        userOptions.setBounds(50, 20, 750, 50);
        panel.add(userOptions);

        userLabel = new JLabel("Create Username: "); //Creates Label object for creating username.
        userLabel.setBounds(75, 150, 125, 25); //sets label parameters for username
        panel.add(userLabel); //adds label to panel.

        userText = new JTextField(20); //Creates Text Field object and sets length of text field for username.
        userText.setBounds(200, 150, 165, 25); //sets text field parameters for username.
        panel.add(userText); //adds the text field to the panel.




        passwordLabel = new JLabel("Create Password: "); //Creates Label object for creating password.
        passwordLabel.setBounds(75, 175, 125, 25); //sets label parameters for password.
        panel.add(passwordLabel); //adds password label to panel.

        passwordText = new JPasswordField(); //Creates Password Field object and sets length of field for password.
        passwordText.setBounds(200, 175, 165, 25); //sets password field parameters for password.
        panel.add(passwordText); //adds the password text field to the panel.

        createButton = new JButton("Create Account"); //Creates button to create account.
        createButton.setBounds(142, 80, 125, 25); //sets parameters of the size of the button.
        panel.add(createButton);
        createButton.addActionListener(new GUI()); //adds an action to the create account button from implemented action lister.

        loginButton = new JButton("Login"); //creates login button.
        loginButton.setBounds(300, 80, 125, 25);
        panel.add(loginButton);
        loginButton.addActionListener(new GUI());



        success = new JLabel(""); //creates label after action listener button if statement is successful (Below).
        success.setBounds(75, 250, 400, 25);
        panel.add(success);


        welcomeMessage = new JLabel(""); //successful login message, left empty to call conditional method later.
        welcomeMessage.setBounds(75, 250, 400, 25);
        panel.add(welcomeMessage);


         


        authenticationApology = new JLabel(""); //failed login message, left empty to cal conditional method later.
        authenticationApology.setBounds(10, 110, 400, 25);
        panel.add(authenticationApology);



        frame.setVisible(true); //makes the frame visible and within focus.
    }

    @Override //Action Listener for "Create Account" button, what happens when the button is clicked.
    public void actionPerformed(ActionEvent e) {
        JPanel panel = new JPanel(); //new panel
        JFrame frame = new JFrame(); //new frame


        createName = userText.getText(); //gets user input text from user text field to create user.
        createPassword = passwordText.getText(); //gets user input from password field to create password.



            success.setText("Welcome to Shea Technology " + createName + ", you may now login.");
            userLabel.setText("Enter Username: "); //changes user label text to enter username.
            passwordLabel.setText("Enter Password: "); //changes password label text to enter password.
            userText.setText(""); //clears text field.
            passwordText.setText(""); //clears password field.
            createButton.setVisible(true); //hides creation button rather than changing the button text alone.
            loginButton.setVisible(true);  //separate login button appears if created credentials match themselves.

        //Action Listener for the "Login" button, what happens when the button is clicked.
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                userName = userText.getText(); //stores usertext field in userName to be verified later.
                userPassword = passwordText.getText(); //stores password field in userPassword to be verified later.
                authenticateName = userName.equals(createName); //verifies if the login username matches the created username.
                authenticatePassword = userPassword.equals(createPassword); //verifies if the login password matches the created password.

                if (!authenticateName || !authenticatePassword) { //conditional AND If * If username and password are both incorrect then:

                    authenticationApology.setText("Sorry, Incorrect Username or Password, try again!"); //apology label.
                    success.setVisible(false); //hides the welcome message from creating the account.
                    userText.setText(""); //clears the text field
                    passwordText.setText(""); //clears the text field.

                } else { //hide the entire Login interface and display the welcome message after being authorized.
                    userText.setText("");
                    passwordText.setText("");
                    success.setVisible(false);
                    authenticationApology.setVisible(false);
                    welcomeMessage.setText("Welcome " + (createName) + ", to Shea Technology's Login Server!");

                }

                }


        });

    }
}

