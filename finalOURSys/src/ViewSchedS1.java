import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewSchedS1 {
	public ViewSchedS1(){
	try{
		// create JFrame and JTable
		JFrame schedFrame = new JFrame();
		JTable schedTable = new JTable(); 
		schedFrame.setTitle("View Schedule");
		// create a table model and set a Column Identifiers to this model 
		Object[] columns = {"CRN","Subject","Number","Name", "Capacity", "Days", "Time", "Instructor"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		
		JButton btnDel = new JButton("Delete");
		btnDel.setBounds(300, 300, 100, 25);
		schedFrame.add(btnDel);
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(200, 300, 100, 25);
		schedFrame.add(btnAdd);
		
		// button remove row
		btnDel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				// i = the index of the selected row
				int i = schedTable.getSelectedRow();
				File course = new File ("std1_" + model.getValueAt(i, 0) + ".txt");

				//remove course file
				course.delete();
				
				//remove row
				 if(i >= 0){
	                    // remove a row from jtable
	                    model.removeRow(i);
	                }
	                else{
	                    System.out.println("Delete Error");
	                }
				
				//JOptionPane.showMessageDialog(null, "Course removed from schedule.");
			}
		});

		btnAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new viewAvailCourses();
			}
		});
	

		String readLine = null;
		File courseIn = new File("s1_Schedule.txt");
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
		schedTable.setModel(model);

		// Change A JTable Background Color, Font Size, Font Color, Row Height
		//table.setBackground(Color.LIGHT_GRAY);
		schedTable.setForeground(Color.black);
		Font font = new Font("",1,15);
		schedTable.setFont(font);
		schedTable.setRowHeight(30);

		// create JScrollPane
		JScrollPane pane = new JScrollPane(schedTable);
		pane.setBounds(0, 0, 880, 200);

		schedFrame.setLayout(null);

		schedFrame.add(pane);
		schedFrame.setSize(900,400);
		schedFrame.setLocationRelativeTo(null);
		//schedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		schedFrame.setVisible(true);
	}

	catch (IOException ex) {}
}
}
