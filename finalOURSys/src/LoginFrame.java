

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class LoginFrame extends JFrame {
	JFrame frame; //the actual frame
	JTextField username; // text for user name
	JLabel name;
	JTextField password;
	JLabel pw;
	JButton buttonL;
	JButton cancel;
	JPanel login;
	String uName;
	String pwd;
	JPanel panel;


	public LoginFrame(){

		//main frame
		frame = new JFrame("System Login");
		frame.setSize(500,200);
		//frame.setLocation(300, 200);
		frame.setLocationRelativeTo(null);	//center of screen
		frame.setLayout(null);
		//closing window terminates program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//username label/fields
		name = new JLabel("Username: ");
		name.setLocation(10,10);
		name.setSize(name.getPreferredSize());
		frame.add(name);

		username = new JTextField();
		username.setColumns(15);
		username.setSize(username.getPreferredSize());
		username.setLocation(150,10);
		frame.add(username);

		//password label/field
		pw = new JLabel("Password: ");
		pw.setLocation(10,40);
		pw.setSize(pw.getPreferredSize());
		frame.add(pw);

		password = new JPasswordField();
		password.setColumns(15);
		password.setSize(password.getPreferredSize());
		password.setLocation(150,40);
		frame.add(password);
		password.addActionListener(new ContinueLogin());

		//login button
		buttonL = new JButton("Login ");
		buttonL.setSize(buttonL.getPreferredSize());
		buttonL.setLocation(155,80);
		frame.add(buttonL);

		//cancel button
		cancel = new JButton("Cancel ");
		cancel.setSize(cancel.getPreferredSize());
		cancel.setLocation(240, 80);
		frame.add(cancel);

		//actions for login and cancel
		buttonL.addActionListener(new ContinueLogin());		//login button click	
		cancel.addActionListener(new CancelLog());			//cancel button click
		frame.getRootPane().setDefaultButton(buttonL);		//"enter" key press = login button click

		frame.setVisible(true);
	}//constructor

	//action listener class to login will direct to window depending on user type
	class ContinueLogin implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == buttonL) {
				uName = username.getText();
				pwd = password.getText();

				if(uName.equals("student1")) {
					try{
						String readLine = null;
						File studentFile = new File("student1.txt");

						FileReader reader = new FileReader(studentFile);
						BufferedReader bufReader = new BufferedReader(reader);
						String[] splitData = null;
						// import courses from course list file
						//ArrayList studentInfo = new ArrayList();
						while((readLine = bufReader.readLine()) != null) {
							splitData = readLine.split("\t");

						}
						//JOptionPane.showMessageDialog(null, splitData[1].toString());

						if (pwd.equals(splitData[1].toString())){
							new StudentFrame();
							frame.setVisible(false);
						}
						else{
							JOptionPane.showMessageDialog(null, "Incorrect Password");
						}
						reader.close();


					}
					catch (IOException ex) {}



					//System.out.println(pWord);// -- prints password entered
					//JOptionPane.showMessageDialog(null, "Welcome to UTC!");
					//System.exit(0);
				}
				else if(uName.equals("instructor")){
					new FrameInstructor();
					frame.setVisible(false);
				}
				else if(uName.equals("staff")){
					new DStaffFrame();
					frame.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Username not found.");
				}

			}

		}
	}

	// action listener class to cancel will close out window
	class CancelLog implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cancel){
				System.exit(0);
			}

		}
	}

	public static void main(String[] args) {
		new LoginFrame();

	}


}



