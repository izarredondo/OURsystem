import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class tableList2 extends JFrame{

	JTable table;
	
	
	public tableList2(){
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
	public static void main(String args[]){
		tableList list1 = new tableList();
		list1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		list1.setSize(1000,370);
		list1.setVisible(true);
		list1.setTitle("2016 Fall Courses");
		
		
	}
	
}

