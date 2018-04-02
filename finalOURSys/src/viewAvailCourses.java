import java.awt.Color;
import java.awt.Font;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class viewAvailCourses {
	public viewAvailCourses(){
		try{
					JFrame availCourseFrame = new JFrame();
					JTable courseTable = new JTable();
					availCourseFrame.setTitle("View Available Courses");

					// create a table model and set a Column Identifiers to this model 
					Object[] columns = {"CRN","Subject","Number","Name", "Capacity", "Days", "Time", "Instructor"};
					DefaultTableModel model = new DefaultTableModel();
					model.setColumnIdentifiers(columns);

					String readLine = null;
					File courseIn = new File("Course_List.txt");
					if(!courseIn.exists()) {
						courseIn.createNewFile();
					}
					FileReader reader = new FileReader(courseIn);
					BufferedReader bufReader = new BufferedReader(reader);

					// import courses from course list file
					ArrayList<Course> courseList = new ArrayList<Course>();
					while((readLine = bufReader.readLine()) != null) {
						String[] splitData = readLine.split("\t");

						Course course = new Course();
						//course.setCRN(splitData[0]);

						courseList.add(course);
						model.addRow(splitData);
					}
					reader.close();

					// set the model to the table
					courseTable.setModel(model);

					// Change A JTable Background Color, Font Size, Font Color, Row Height
					//table.setBackground(Color.LIGHT_GRAY);
					courseTable.setForeground(Color.black);
					Font font = new Font("",1,15);
					courseTable.setFont(font);
					courseTable.setRowHeight(30);

					// create JButtons
					JButton btnAdd = new JButton("Add");
					btnAdd.setBounds(200, 300, 100, 25);
					JButton btnSchd = new JButton("View Schedule");
					//btnSchd.setBounds(300, 300, 200, 25);
					btnSchd.setBounds(300, 300, 150, 25);
					

					// add JButtons to the jframe
					availCourseFrame.add(btnAdd);
					//availCourseFrame.add(btnDel);
					availCourseFrame.add(btnSchd);
					


					// create JTextFields
					JTextField textCRN = new JTextField();
					JTextField textSub = new JTextField();
					JTextField textNum = new JTextField();
					JTextField textName = new JTextField();
					JTextField textCap = new JTextField();
					JTextField textDays = new JTextField();
					JTextField textTime = new JTextField();
					JTextField textInstr = new JTextField();

					textCRN.setEditable(false);
					textSub.setEditable(false);
					textNum.setEditable(false);
					textName.setEditable(false);
					textCap.setEditable(false);
					textDays.setEditable(false);
					textTime.setEditable(false);
					textInstr.setEditable(false);

					textCRN.setBounds(10, 220, 100, 25);
					textSub.setBounds(120, 220, 100, 25);
					textNum.setBounds(230, 220, 100, 25);
					textName.setBounds(340, 220, 100, 25);
					textCap.setBounds(450, 220, 100, 25);
					textDays.setBounds(560, 220, 100, 25);
					textTime.setBounds(670, 220, 100, 25);
					textInstr.setBounds(780, 220, 100, 25);

					// add JTextFields to the jframe
					availCourseFrame.add(textCRN);
					availCourseFrame.add(textSub);
					availCourseFrame.add(textNum);
					availCourseFrame.add(textName);
					availCourseFrame.add(textCap);
					availCourseFrame.add(textDays);
					availCourseFrame.add(textTime);
					availCourseFrame.add(textInstr);

					// create JScrollPane
					JScrollPane acPane = new JScrollPane(courseTable);
					acPane.setBounds(0, 0, 880, 200);

					availCourseFrame.setLayout(null);

					availCourseFrame.add(acPane);

					availCourseFrame.setSize(900,400);
					availCourseFrame.setLocationRelativeTo(null);
					//availCourseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					availCourseFrame.setVisible(true);

					// get selected row data From table to textfields 
					courseTable.addMouseListener(new MouseAdapter(){

						@Override
						public void mouseClicked(MouseEvent e){

							// i = the index of the selected row
							int i = courseTable.getSelectedRow();

							textCRN.setText(model.getValueAt(i, 0).toString());
							textSub.setText(model.getValueAt(i, 1).toString());
							textNum.setText(model.getValueAt(i, 2).toString());
							textName.setText(model.getValueAt(i, 3).toString());
							textCap.setText(model.getValueAt(i, 4).toString());
							textDays.setText(model.getValueAt(i, 5).toString());
							textTime.setText(model.getValueAt(i, 6).toString());
							textInstr.setText(model.getValueAt(i, 7).toString());
						}
					});


					// view student schedule
					btnSchd.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
						new ViewSchedS1();

						}
					});

					// button add course to schedule
					btnAdd.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								File schedFile = new File("s1_Schedule.txt");
								File courseFile = new File("std1_" + model.getValueAt(courseTable.getSelectedRow(), 0) + ".txt");
								//if the file does not exist, create one
								if(!schedFile.exists()){
									schedFile.createNewFile();
								}
								
								if(!courseFile.exists()){

								FileWriter fw = new FileWriter(schedFile.getAbsoluteFile(),true);
								BufferedWriter bw = new BufferedWriter(fw);
								PrintWriter out = new PrintWriter(bw);

								//out.println();
								for(int i=0; i < courseTable.getColumnCount(); i++){
									out.print(model.getValueAt(courseTable.getSelectedRow(), i) + "\t");
								}
								out.print("\n");

								out.close();
								//close BufferedWriter
								bw.close();
								//close FileWriter 
								fw.close();
								//JOptionPane.showMessageDialog(null, "Data Exported");
								}
								else
								{
									JOptionPane.showMessageDialog(null, "You are already registered for that course.");
								}

							}
							catch(Exception ex){
								ex.printStackTrace();
							}
							
							  // create course text file named after its CRN value
			                try
			                {
			                	int r = courseTable.getSelectedRow();
			                	PrintWriter out = new PrintWriter("std1_"+ model.getValueAt(r, 0) + ".txt");
			                    out.println("CRN: " + model.getValueAt(r, 0));
			                    out.println("Sub: " + model.getValueAt(r, 1));
			                    out.println("Num: " + model.getValueAt(r, 2));
			                    out.println("Name: " + model.getValueAt(r, 3));
			                    out.println("Cap: " + model.getValueAt(r, 4));
			                    out.println("Days: " + model.getValueAt(r, 5));
			                    out.println("Time: " + model.getValueAt(r, 6));
			                    out.println("Instr: " + model.getValueAt(r, 7));

			                    out.close();
			                	
			                }

			                catch(Exception exception)
			                {
			                    exception.printStackTrace();
			                	//System.out.println("File Not Found");
			                }
			                
			                //JOptionPane.showMessageDialog(null, "Course added to schedule.");
							//open schedule frame
							//new ViewSchedS1();
						}
					});
				}

				catch (IOException ex) {}
				}
}
				
				