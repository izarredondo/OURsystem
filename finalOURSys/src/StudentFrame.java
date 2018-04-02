
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentFrame extends JFrame {

	JFrame studentFrame;
	JPanel panel;
	String[] splitData = null;
	String name = splitData[3].toString();

	public StudentFrame(){
		
		try{
			String readLine = null;
			File studentFile = new File("student1.txt");

			FileReader reader = new FileReader(studentFile);
			BufferedReader bufReader = new BufferedReader(reader);
			
			// import courses from course list file
			//ArrayList studentInfo = new ArrayList();
			while((readLine = bufReader.readLine()) != null) {
				splitData = readLine.split("\t");
				

			}
			//JOptionPane.showMessageDialog(null, splitData[1].toString());

			
			
			reader.close();

		//JFrame studentFrame = new JFrame("Student");
		studentFrame = new JFrame("Welcome " + name + "!" );	// this fixed the logout button problem
		//setting the size of the frame
		studentFrame.setSize(400, 400);
		//center of screen
		studentFrame.setLocationRelativeTo(null);

		panel = new JPanel();
		studentFrame.add(panel);
		placeComponents(panel);
		studentFrame.setVisible(true);
		//closing window terminates program
		studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		catch (IOException ex) {}

	}// constructor

	private void placeComponents(JPanel panel) {
		//setting the grid layout
		panel.setLayout(new GridLayout(2,2));

		//creating a view schedule button
		JButton viewSchd = new JButton("View Schedule");
		//adding the view schedule button to the panel
		panel.add(viewSchd, GridLayout.class);


		//creating a view available courses button
		JButton viewAvailCourses = new JButton("View Available Courses");
		//adding the view available courses button to the panel
		panel.add(viewAvailCourses, GridLayout.class);

		//creating a print schedule button 
		JButton printSchd = new JButton("Print Schedule");
		//adding the print schedule button the panel
		panel.add(printSchd, GridLayout.class);


		//creating the logout button
		JButton logout = new JButton("Logout");
		//adding the logout button to the panel
		panel.add(logout, GridLayout.class);

		//add button
		JButton add3 = new JButton("Add Courses");
		add3.setSize(add3.getPreferredSize());
		add3.setLocation(200,280);

		//action for logout
		//action class for logout button
		class logoutReport implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == logout){
					LoginFrame log = new LoginFrame();
					studentFrame.setVisible(false);

				}
			}
		} // end logoutReport

		class printS implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == printSchd){
					JOptionPane.showMessageDialog(null, "This report has been printed");
					//System.exit(0);
				}

			}
		} // end printS		

		class viewS implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == viewSchd){

					new ViewSchedS1();
				}
			}
		}// end view schedule action listener

		//view available courses 
		class viewC implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				new viewAvailCourses();
			}
		}//view courses action listener


		viewAvailCourses.addActionListener(new viewC());
		add3.addActionListener(new viewC());
		viewSchd.addActionListener(new viewS());
		logout.addActionListener(new logoutReport());
		printSchd.addActionListener(new printS());

	} //place components

	public static void main(String[] args){
		new StudentFrame();


	}
}
