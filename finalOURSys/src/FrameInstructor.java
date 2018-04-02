import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;

public class FrameInstructor extends JFrame {

	
	JFrame instFrame; //the actual frame
	JPanel panel; // main panel
	
	public FrameInstructor(){
		instFrame = new JFrame("Instructor");
		//setting the size of the frame
		instFrame.setSize(300, 300);
		//center of screen
		instFrame.setLocationRelativeTo(null);
		
		panel = new JPanel();
		instFrame.add(panel);
		placeComponents(panel);
		//setting the panel visible 
		instFrame.setVisible(true);
		//closing window terminates program
		instFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}// constructor
	
	private void placeComponents(JPanel panel) {
		//setting the grid layout
		panel.setLayout(new GridLayout(4,4));
		
		//view reports button
		JButton viewC = new JButton("View Classes");
		//adding the view reports button to the panel
		panel.add(viewC, GridLayout.class);
		
		//course catalog button
		JButton viewE = new JButton("View Enrollment");
		//adding the course catalog button to the panel
		panel.add(viewE, GridLayout.class);
		
		//creating the print button
		JButton print = new JButton("Print");
		//adding the logout button to the panel
		panel.add(print, GridLayout.class);
				
		//creating the logout button
		JButton logout = new JButton("Logout");
		//adding the logout button to the panel
		panel.add(logout, GridLayout.class);
		
		
		//action for view classes button

		class ViewCourse implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == viewC){
					class tableList7 extends JFrame{
						JTable table;
						public tableList7(){
							setLayout(new FlowLayout());
							String[] columnName = {"CRN", "Subject", "Course Number", "Course Title", "Instructor"};
							Object[][] courseList = {
									{ "21083", "CPSC", "1000", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1001", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1002", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1003", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1004", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1005", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1006", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1007", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1008", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1009", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1010", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1011", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1012", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1013", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1014", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1015", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1016", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1017", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1018", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1019", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1020", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1021", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1022", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1023", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1024", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1025", "Intro to Computing", "Schwab"},
									{ "21083", "CPSC", "1026", "Intro to Computing", "Schwab"},
							}; 
								table = new JTable(courseList,columnName);
								table.setPreferredScrollableViewportSize(new Dimension(900,250));
								table.setFillsViewportHeight(true);
								JScrollPane scroll2 = new JScrollPane(table);
								add(scroll2);

					}
				}
					tableList7 list3 = new tableList7();
					//list1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					list3.setSize(1000,370);
					list3.setVisible(true);
					list3.setLocationRelativeTo(null);
					list3.setTitle("Courses");
					//button add
					JButton add1 = new JButton("Add Course ");
					add1.setSize(add1.getPreferredSize());
					add1.setLocation(200,280);
					list3.add(add1);
					//button delete
					JButton delete = new JButton("Delete Course ");
					delete.setSize(delete.getPreferredSize());
					delete.setLocation(355, 280);
					list3.add(delete);
					//button Save
					JButton save1 = new JButton("Save Courses ");
					save1.setSize(114,25);
					save1.setLocation(520, 280);
					list3.add(save1);
			}
		}
	}
		

		
		//action class for view enrollment button
		class Enrollment implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == viewE){
					String[] listE = {"Sharhea Bell", "J'Tia Williamson", "Alese Taylor", "Izabella Arredondo", "Chelsea Merriman", "Anthony Furguson",
							"David Lovins", "Bradley Sigman", "Justin Rankhom", "Benjamin Pingy", "Javier Martinez", "Timothy Harness",
							"Jakob Becklehimer", "Seth Allen", "Wesley Cordero", "Connor Woods", "Zachary Cradick", "Nicholas Snavely", "James Lyon"};
					
					JList eList = new JList(listE);
					
					JFrame listFrame = new JFrame("Enrollment");
					//JScrollPane scroll = new JScrollPane(eList);
					listFrame.add(eList);

					listFrame.setSize(600,400);
					listFrame.setVisible(true);
					//getContentPane().add(scroll, BorderLayout.CENTER);
					listFrame.setLocationRelativeTo(null);
				
					//add scroll pane

					
					
				}		
			}	
		}
		//action class for print button
		class printB implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == print){
					JOptionPane.showMessageDialog(null, "Documents Printed");
					//System.exit(0);
				}
		}
	}
		//action class for logout button
		class logoutReport implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == logout){
				LoginFrame log = new LoginFrame();
				instFrame.setVisible(false);
				
				}
			}
		}
		
		
		viewC.addActionListener(new ViewCourse());
		viewE.addActionListener(new Enrollment());
		print.addActionListener(new printB());
		logout.addActionListener(new logoutReport());
}
	public static void main(String[] args)
	{
		new FrameInstructor();
	}
}
