// Code adapted from:
/******************************************************************************************
*    Title: JAVA - How To Insert Remove And Edit JTable Row
*    Author: 1BestCsharp blog
*    Date: May 2015
*    Avail.: http://1bestcsharp.blogspot.com/2015/05/java-jtable-add-delete-update-row.html
*******************************************************************************************/

import java.awt.Color;
import java.awt.Font;
//import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
//import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class CourseModify {

    //public static void main(String[] args){
	public CourseModify() {
        try{
        // create JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable(); 
        frame.setTitle("Modify Available Courses");
        
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
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        //table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,15);
        table.setFont(font);
        table.setRowHeight(30);
        
        // create JTextFields
        JTextField textCRN = new JTextField();
        JTextField textSub = new JTextField();
        JTextField textNum = new JTextField();
        JTextField textName = new JTextField();
        JTextField textCap = new JTextField();
        JTextField textDays = new JTextField();
        JTextField textTime = new JTextField();
        JTextField textInstr = new JTextField();
        
        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");
        JButton btnSave = new JButton("Save");
        
        textCRN.setBounds(10, 220, 100, 25);
        textSub.setBounds(120, 220, 100, 25);
        textNum.setBounds(230, 220, 100, 25);
        textName.setBounds(340, 220, 100, 25);
        textCap.setBounds(450, 220, 100, 25);
        textDays.setBounds(560, 220, 100, 25);
        textTime.setBounds(670, 220, 100, 25);
        textInstr.setBounds(780, 220, 100, 25);
        
        btnAdd.setBounds(200, 300, 100, 25);
        btnUpdate.setBounds(300, 300, 100, 25);
        btnDelete.setBounds(400, 300, 100, 25);
        btnSave.setBounds(500, 300, 100, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frame.setLayout(null);
        
        frame.add(pane);
        
        // add JTextFields to the jframe
        frame.add(textCRN);
        frame.add(textSub);
        frame.add(textNum);
        frame.add(textName);
        frame.add(textCap);
        frame.add(textDays);
        frame.add(textTime);
        frame.add(textInstr);
    
        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnSave);
        
        // create an array of course objects to set the row data
        Object[] course = new Object[8];
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	File courseFile = new File(textCRN.getText() + ".txt");
            	course[0] = textCRN.getText();
                course[1] = textSub.getText();
                course[2] = textNum.getText();
                course[3] = textName.getText();
                course[4] = textCap.getText();
                course[5] = textDays.getText();
                course[6] = textTime.getText();
                course[7] = textInstr.getText();
            	
                if(!courseFile.exists() && !courseFile.isDirectory()) { 
                	// add row to the model
                    model.addRow(course);
                    // clear fields
                    textCRN.setText("");
                    textSub.setText("");
                    textNum.setText("");
                    textName.setText("");
                    textCap.setText("");
                    textDays.setText("");
                    textTime.setText("");
                    textInstr.setText("");
                }
                else
                {
                	JOptionPane.showMessageDialog(null, "Course already exists or missing text fields.");
                	//System.out.println("File Exists");
                }
                
                // create course text file named after its CRN value
                try
                {
                	if(course[0] != ""){
                	PrintWriter out = new PrintWriter(course[0].toString() + ".txt");
                    out.println("CRN: " + course[0].toString());
                    out.println("Sub: " + course[1].toString());
                    out.println("Num: " + course[2].toString());
                    out.println("Name: " + course[3].toString());
                    out.println("Cap: " + course[4].toString());
                    out.println("Days: " + course[5].toString());
                    out.println("Time: " + course[6].toString());
                    out.println("Instr: " + course[7].toString());

                    out.close();
                	}
                }

                catch(Exception exception)
                {
                    exception.printStackTrace();
                	//System.out.println("File Not Found");
                }
                
                
               
                
            }
        });
        
        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                File course = new File (model.getValueAt(i, 0).toString() + ".txt");
                
                //remove course file
                course.delete();
                
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
                
                // clear fields
//                textCRN.setText("");
//                textSub.setText("");
//                textNum.setText("");
//                textName.setText("");
//                textCap.setText("");
//                textDays.setText("");
//                textTime.setText("");
//                textInstr.setText("");
                
            }
        });
        
        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
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
        
        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                // i = the index of the selected row
                int i = table.getSelectedRow();
                File course = new File (model.getValueAt(i, 0).toString() + ".txt");
                //remove old course file
                course.delete();
                
                if(i >= 0) 
                {
                   model.setValueAt(textCRN.getText(), i, 0);
                   model.setValueAt(textSub.getText(), i, 1);
                   model.setValueAt(textNum.getText(), i, 2);
                   model.setValueAt(textName.getText(), i, 3);
                   model.setValueAt(textCap.getText(), i, 4);
                   model.setValueAt(textDays.getText(), i, 5);
                   model.setValueAt(textTime.getText(), i, 6);
                   model.setValueAt(textInstr.getText(), i, 7);
                }
                else
                {
                    System.out.println("Update Error");
                }
                
                // create new course file
                try
                {
                    PrintWriter out = new PrintWriter(textCRN.getText() + ".txt");
                    out.println("CRN: " + textCRN.getText());
                    out.println("Sub: " + textSub.getText());
                    out.println("Num: " + textNum.getText());
                    out.println("Name: " + textName.getText());
                    out.println("Cap: " + textCap.getText());
                    out.println("Days: " + textDays.getText());
                    out.println("Time: " + textTime.getText());
                    out.println("Instr: " + textInstr.getText());

                    out.close();
                }

                catch(FileNotFoundException exception)
                {
                    System.out.println("File Not Found");
                }
                
                // clear fields
                textCRN.setText("");
                textSub.setText("");
                textNum.setText("");
                textName.setText("");
                textCap.setText("");
                textDays.setText("");
                textTime.setText("");
                textInstr.setText("");
            }
        });
        
     // button save list
        btnSave.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            	File cList = new File("Course_List.txt");
                //if the file not exist create one
                if(!cList.exists()){
                    cList.createNewFile();
                }
                
                FileWriter fw = new FileWriter(cList.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                
                //loop for jtable rows
                for(int i = 0; i < table.getRowCount(); i++){
                    //loop for jtable column
                    for(int j = 0; j < table.getColumnCount(); j++){
                        bw.write(table.getModel().getValueAt(i, j)+"\t");
                    }
                    //break line at the begin 
                    //break line at the end 
                    bw.write("\n");
                }
                
                JOptionPane.showMessageDialog(null, "Available Courses have been saved.");
                
                //close BufferedWriter
                bw.close();
                //close FileWriter 
                fw.close();
                //JOptionPane.showMessageDialog(null, "Data Exported");
                
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        
        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
      //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // window close prompt to save any changes
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame, 
                    "Did you save your work?\nIf not, your changes will be erased.", "Confirm Save", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    //System.exit(0);
                	frame.setVisible(false);
                }
            }
        });
            
        frame.setVisible(true);
        }
        
        catch (IOException ex) {}
    }
    
	public static void main(String[] args){
		new CourseModify();
		

	}
}

        
   
