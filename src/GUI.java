//Author Alex Shea - Graphical User Interface Authentication Program

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton createButton;
    private static JLabel success;
    private static JButton loginButton;
    private static JLabel authenticationApology;
    private static JLabel welcomeMessage;

    //Create variables store user input, user variables verify user input.
    String userName = "";
    String userPassword = "";
    String createName = "";
    String createPassword = "";


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
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.gray); //sets panel background color to gray.

        //Jpanel background
        JLabel panelBackground = new JLabel(new ImageIcon(ImageIO.read(GUI.class.getResource("Shelter.png"))));
        frame.setContentPane(panelBackground);




        //Text fields and Labels.

        JLabel userOptions = new JLabel("Hello!, Welcome to Shea Technologies! Please Login." + " Don't have an account? Select Create Account.");
        userOptions.setBounds(10, 20, 750, 50);
        panel.add(userOptions);

        userLabel = new JLabel("Create Username: "); //Creates Label object for creating username.
        userLabel.setBounds(125, 150, 125, 25); //sets label parameters for username
        frame.add(userLabel);

        userText = new JTextField(20); //Creates Text Field object and sets length of text field for username.
        userText.setBounds(250, 150, 165, 25); //sets text field parameters for username.
        frame.add(userText); //adds the text field to the panel.


        passwordLabel = new JLabel("Create Password: "); //Creates Label object for creating password.
        passwordLabel.setBounds(125, 175, 125, 25); //sets label parameters for password.
        frame.add(passwordLabel); //adds password label to panel.

        passwordText = new JPasswordField(); //Creates Password Field object and sets length of field for password.
        passwordText.setBounds(250, 175, 165, 25); //sets password field parameters for password.
        frame.add(passwordText); //adds the password text field to the panel.


        //Java Buttons

        createButton = new JButton("Create Account"); //Creates button to create account.
        createButton.setBounds(142, 80, 125, 25); //sets parameters of the size of the button.
        frame.add(createButton);

        createButton.addActionListener(new GUI()); //adds an action to the create account button from implemented action listener.
        createButton.setBackground(Color.darkGray);
        createButton.setForeground(Color.WHITE);


        loginButton = new JButton("Login"); //creates login button.
        loginButton.setBounds(300, 80, 125, 25);
        frame.add(loginButton);

        loginButton.addActionListener(new GUI()); //adds an action to the login account button from implemented action listener.
        loginButton.setBackground(Color.darkGray);
        loginButton.setForeground(Color.WHITE);


        success = new JLabel(""); //creates label after action listener button if statement is successful (Below).
        success.setBounds(75, 250, 400, 25);
        frame.add(success);


        welcomeMessage = new JLabel(""); //successful login message, left empty to call conditional method later.
        welcomeMessage.setBounds(75, 250, 400, 25);
        frame.add(welcomeMessage);


        authenticationApology = new JLabel(""); //failed login message, left empty to call conditional method later.
        authenticationApology.setBounds(10, 110, 400, 25);
        frame.add(authenticationApology);

        frame.setVisible(true); //makes the frame visible and within focus.
    }

     //Action Listener for "Create Account" button, what happens when the button is clicked.
    public void actionPerformed(ActionEvent e) {

        createName = userText.getText(); //gets user input text from user text field to create user.
        createPassword = passwordText.getText(); //gets user input from password field to create password.

        if (createName.length() == 0 || createPassword.length() == 0) { //Doesn't allow user to proceed if field is blank.
            return;
        }
        success.setText("Welcome to Shea Technology " + createName + ", you may now login.");
        userLabel.setText("Enter Username: "); //changes user label text to enter username.
        passwordLabel.setText("Enter Password: "); //changes password label text to enter password.
        userText.setText(""); //clears text field.
        passwordText.setText(""); //clears password field.
        createButton.setVisible(false); //hides creation button upon creating account info.
        loginButton.setVisible(true);  //separate login button appears if created credentials match themselves.

        //Action Listener for the "Login" button, what happens when the button is clicked.
        loginButton.addActionListener(e1 -> { //lambda
            //Authentication

            userName = userText.getText(); //stores userText field in userName to be verified later.
            userPassword = passwordText.getText(); //stores password field in userPassword to be verified later.

            boolean authenticateName = userName.equals(createName); //verifies if the login username matches the created username.
            boolean authenticatePassword = userPassword.equals(createPassword); //verifies if the login password matches the created password.

            if (!authenticateName || !authenticatePassword) { //conditional If username and password are both incorrect then:

                authenticationApology.setText("Sorry, Incorrect Username or Password, try again!"); //apology label.
                success.setVisible(false); //hides the welcome message from creating the account.
                userText.setText(""); //clears the text field
                passwordText.setText(""); //clears the text field.

            } else { //hide the entire Login interface and displays the welcome message after being authorized.
                userText.setText("");
                passwordText.setText("");
                success.setVisible(false);
                authenticationApology.setVisible(false);
                loginButton.setVisible(false);
                welcomeMessage.setText("Welcome " + (createName) + ", to Shea Technology's Login Server!");

            }

            });

    }
}

