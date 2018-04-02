import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class DStaffFrame extends JFrame {
	
		JFrame dsFrame; //the actual frame
		JPanel panel; // main panel
		
		public DStaffFrame(){
			
			dsFrame = new JFrame("Department Staff");
			//setting the size of the frame
			dsFrame.setSize(300, 300);
			//center of screen
			dsFrame.setLocationRelativeTo(null);
			
			panel = new JPanel();
			dsFrame.add(panel);
			placeComponents(panel);
			//setting the panel visible 
			dsFrame.setVisible(true);
			//closing window terminates program
			dsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}// constructor

		private void placeComponents(JPanel panel) {
			//setting the grid layout
			panel.setLayout(new GridLayout(4,4));
			
			//view reports button
			JButton viewR = new JButton("View Reports");
			//adding the view reports button to the panel
			panel.add(viewR, GridLayout.class);
			
			//course catalog button
			JButton courseCat = new JButton("Course Catalog");
			//adding the course catalog button to the panel
			panel.add(courseCat, GridLayout.class);
			
			//save button 
			JButton save = new JButton("Save");
			//adding the save button to the panel
			panel.add(save, GridLayout.class);
			
			//creating the logout button
			JButton logout = new JButton("Logout");
			//adding the logout button to the panel
			panel.add(logout, GridLayout.class);
		
			JButton avaiable = new JButton("Available Courses");
			
		class viewReports implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == viewR){
					JFrame reports = new JFrame("View Reports");
					reports.setSize(300, 300);
					reports.setVisible(true);
					//reports.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					reports.setLocationRelativeTo(null);
					
					JPanel panelReports = new JPanel();
					reports.add(panelReports);
					panelReports.setLayout(new GridLayout(3,3));
					
					
					panelReports.add(avaiable);
					avaiable.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent a){
							if (a.getSource() == avaiable){
								reports.setVisible(true);
								CourseModify modFrame = new CourseModify();
							}
						}
					});
					
					
//								class tableList4 extends JFrame{
//
//									JTable table1;
//									
//									public tableList4(){
//										setLayout(new FlowLayout());
//										
//										String[] columnName = {"CRN", "Subject", "Course Number", "Course Title", "Instructor"};
//										Object[][] courseList = {
//												{ "21083", "CPSC", "1000", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1001", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1002", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1003", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1004", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1005", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1006", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1007", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1008", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1009", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1010", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1011", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1012", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1013", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1014", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1015", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1016", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1017", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1018", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1019", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1020", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1021", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1022", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1023", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1024", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1025", "Intro to Computing", "Schwab"},
//												{ "21083", "CPSC", "1026", "Intro to Computing", "Schwab"},
//										}; 
//											JTable table = new JTable(courseList,columnName);
//											table.setPreferredScrollableViewportSize(new Dimension(900,250));
//											table.setFillsViewportHeight(true);		
//											
//											JScrollPane scroll2 = new JScrollPane(table);
//											add(scroll2);
//
//
//								}
//							}
//								tableList4 list4 = new tableList4();
//								//list1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//								list4.setSize(1000,370);
//								list4.setVisible(true);
//								list4.setTitle("Fall 2016");
//								list4.setLocationRelativeTo(null);
////								//button add
////								JButton add3 = new JButton("Add Course ");
////								add3.setSize(add3.getPreferredSize());
////								add3.setLocation(200,280);
////								list4.add(add3);
////								
////
////								//button delete
////								JButton delete = new JButton("Delete Course ");
////								delete.setSize(delete.getPreferredSize());
////								delete.setLocation(355, 280);
////								list4.add(delete);
////								
////								//button Save
////								JButton save3 = new JButton("Save Courses ");
////								save3.setSize(114,25);
////								save3.setLocation(520, 280);
////								list4.add(save3);
//						}
//							
//					}
//				});
				
					
					JButton registered = new JButton("Registered Students");
					panelReports.add(registered);
					registered.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == registered){
							String[] listE = {"Sharhea Bell", "J'Tia Williamson", "Alese Taylor", "Izabella Arredondo", "Chelsea Merriman", "Anthony Furguson",
									"David Lovins", "Bradley Sigman", "Justin Rankhom", "Benjamin Pingy", "Javier Martinez", "Timothy Harness",
									"Jakob Becklehimer", "Seth Allen", "Wesley Cordero", "Connor Woods", "Zachary Cradick", "Nicholas Snavely", "James Lyon"};
							
							JList eList = new JList(listE);
							
							JFrame listFrame = new JFrame("Enrollment");
							//JScrollPane scroll = new JScrollPane(eList);
							listFrame.add(eList);

							listFrame.setSize(600,400);
							listFrame.setVisible(true);
							listFrame.setLocationRelativeTo(null);
						}
					}
				});
					
					
					JButton fees = new JButton("Student Fees");
					panelReports.add(fees);
					fees.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							if(e.getSource() == fees){
								TableTest test1 = new TableTest();
								
					
					
					
				}		
			}	
		});
					
				}
				
			}
		}
				
	class catalog implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == courseCat){
				dsFrame.setVisible(true);
				CourseModify modFrame = new CourseModify();
				
			}
		}
	}
					
//							class tableList4 extends JFrame{
//
//								JTable table1;
//								
//								public tableList4(){
//									setLayout(new FlowLayout());
//									
//									String[] columnName = {"CRN", "Subject", "Course Number", "Course Title", "Instructor"};
//									Object[][] courseList = {
//											{ "21083", "CPSC", "1000", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1001", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1002", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1003", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1004", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1005", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1006", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1007", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1008", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1009", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1010", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1011", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1012", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1013", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1014", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1015", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1016", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1017", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1018", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1019", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1020", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1021", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1022", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1023", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1024", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1025", "Intro to Computing", "Schwab"},
//											{ "21083", "CPSC", "1026", "Intro to Computing", "Schwab"},
//									}; 
//										JTable table = new JTable(courseList,columnName);
//										table.setPreferredScrollableViewportSize(new Dimension(900,250));
//										table.setFillsViewportHeight(true);		
//										
//										JScrollPane scroll2 = new JScrollPane(table);
//										add(scroll2);

//
//							}
//						}
//							tableList4 list4 = new tableList4();
//							//list1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//							list4.setSize(1000,370);
//							list4.setVisible(true);
//							list4.setTitle("Course Catalog");
//							list4.setLocationRelativeTo(null);
							
							
//							//button add
//							JButton add3 = new JButton("Add Course ");
//							add3.setSize(add3.getPreferredSize());
//							add3.setLocation(200,280);
//							list4.add(add3);
//							
//
//							//button delete
//							JButton delete = new JButton("Delete Course ");
//							delete.setSize(delete.getPreferredSize());
//							delete.setLocation(355, 280);
//							list4.add(delete);
//							
//							//button Save
//							JButton save3 = new JButton("Save Courses ");
//							save3.setSize(114,25);
//							save3.setLocation(520, 280);
//							list4.add(save3);
//					}
						
//				}
//			}
			
				

	class saveReport implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == save){
				JOptionPane.showMessageDialog(null, "This report has been saved");
				//System.exit(0);
			}
		
	}
}
	class logoutReport implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == logout){
		LoginFrame log = new LoginFrame();
		dsFrame.setVisible(false);
		}
	}
}
		
	viewR.addActionListener(new viewReports());
	courseCat.addActionListener(new catalog());	
	save.addActionListener(new saveReport());
	logout.addActionListener(new logoutReport());
		
		}
		
		
	
	public static void main(String[] args)
	{
		new DStaffFrame();
		
		
	}
}