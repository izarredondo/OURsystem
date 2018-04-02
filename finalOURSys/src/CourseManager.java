///**
//import java.awt.BorderLayout;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.BoxLayout;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import javax.swing.JTable;
//import javax.swing.JLabel;
//import java.awt.Font;
//
//import javax.swing.SwingConstants;
//
//import javax.swing.table.DefaultTableModel;
//import javax.swing.JScrollBar;
//import java.awt.ScrollPane;
//import java.awt.BorderLayout;
//import javax.swing.JScrollPane;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import javax.swing.AbstractAction;
//import java.awt.event.ActionEvent;
//import javax.swing.Action;
//import java.awt.event.ComponentEvent;
//
//public class CourseManager extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField crnTxt;
//	private JTextField subTxt;
//	private JTextField numTxt;
//	private JTextField nameTxt;
//	private JTextField capTxt;
//	private JTextField daysTxt;
//	private JLabel lblSubject;
//	private JLabel lblCourseNumber;
//	private JLabel lblName;
//	private JLabel lblCapacity;
//	private JLabel lblInstructor;
//	private JTextField timeTxt;
//	private JTextField instrTxt;
//	DefaultTableModel dm;
//	private ScrollPane scrollPane;
//	//private final Action action = new SwingAction();
//	
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CourseManager frame = new CourseManager();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	**/
//
//	/**
//	 * Create the frame.
//	 */
//	public CourseManager() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 594, 396);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("CRN");
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
//		lblNewLabel.setBounds(477, 29, 61, 16);
//		contentPane.add(lblNewLabel);
//		
//		crnTxt = new JTextField();
//		crnTxt.setBounds(445, 6, 130, 26);
//		contentPane.add(crnTxt);
//		crnTxt.setColumns(10);
//		
//		lblSubject = new JLabel("Subject");
//		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
//		lblSubject.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
//		lblSubject.setBounds(477, 68, 61, 16);
//		contentPane.add(lblSubject);
//		
//		subTxt = new JTextField();
//		subTxt.setBounds(445, 44, 130, 26);
//		contentPane.add(subTxt);
//		subTxt.setColumns(10);
//		
//		lblCourseNumber = new JLabel("Course Number");
//		lblCourseNumber.setHorizontalAlignment(SwingConstants.CENTER);
//		lblCourseNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
//		lblCourseNumber.setBounds(473, 106, 81, 16);
//		contentPane.add(lblCourseNumber);
//		
//		numTxt = new JTextField();
//		numTxt.setBounds(445, 82, 130, 26);
//		contentPane.add(numTxt);
//		numTxt.setColumns(10);
//		
//		lblName = new JLabel("Name");
//		lblName.setHorizontalAlignment(SwingConstants.CENTER);
//		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
//		lblName.setBounds(477, 144, 61, 16);
//		contentPane.add(lblName);
//		
//		nameTxt = new JTextField();
//		nameTxt.setColumns(10);
//		nameTxt.setBounds(445, 120, 130, 26);
//		contentPane.add(nameTxt);
//		
//		lblCapacity = new JLabel("Capacity");
//		lblCapacity.setHorizontalAlignment(SwingConstants.CENTER);
//		lblCapacity.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
//		lblCapacity.setBounds(477, 182, 61, 16);
//		contentPane.add(lblCapacity);
//		
//		capTxt = new JTextField();
//		capTxt.setColumns(10);
//		capTxt.setBounds(445, 158, 130, 26);
//		contentPane.add(capTxt);
//		
//		lblInstructor = new JLabel("Days");
//		lblInstructor.setHorizontalAlignment(SwingConstants.CENTER);
//		lblInstructor.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
//		lblInstructor.setBounds(477, 220, 61, 16);
//		contentPane.add(lblInstructor);
//		
//		daysTxt = new JTextField();
//		daysTxt.setColumns(10);
//		daysTxt.setBounds(445, 196, 130, 26);
//		contentPane.add(daysTxt);
//		
//		JLabel lblTime = new JLabel("Time");
//		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
//		lblTime.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
//		lblTime.setBounds(477, 259, 61, 16);
//		contentPane.add(lblTime);
//		
//		timeTxt = new JTextField();
//		timeTxt.setColumns(10);
//		timeTxt.setBounds(445, 234, 130, 26);
//		contentPane.add(timeTxt);
//		
//		JLabel lblSchwab = new JLabel("Instructor");
//		lblSchwab.setHorizontalAlignment(SwingConstants.CENTER);
//		lblSchwab.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
//		lblSchwab.setBounds(477, 297, 61, 16);
//		contentPane.add(lblSchwab);
//		
//		instrTxt = new JTextField();
//		instrTxt.setColumns(10);
//		instrTxt.setBounds(445, 273, 130, 26);
//		contentPane.add(instrTxt);
//		
//		JButton btnNewButton = new JButton("Add");
//		btnNewButton.setBounds(232, 339, 117, 29);
//		contentPane.add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("Delete");
//		btnNewButton_1.setBounds(361, 339, 117, 29);
//		contentPane.add(btnNewButton_1);
//		
//		JButton button = new JButton("Update");
//		button.setBounds(103, 339, 117, 29);
//		contentPane.add(button);
//		
//		JTable table = new JTable(); 
//		Object[] columns = {"CRN"," Subject","Number","Name", "Capacity", "Days", "Time", "Instructor"};
//		DefaultTableModel dm = new DefaultTableModel();
//		dm.setColumnIdentifiers(columns);
//		table.setModel(dm);
//		contentPane.add(table);
//		
//		JScrollPane pane = new JScrollPane(table);
//        pane.setBounds(0, 0, 880, 200);
//        
//        frame.setLayout(null);
//        
//        frame.add(pane);
//		
//		//scrollPane = new ScrollPane();
//		//scrollPane.setBounds(10, 6, 429, 327);
//		//contentPane.add(scrollPane);
//		
//		//JScrollPane scrollPane = new JScrollPane(table);
//		//table.setFillsViewportHeight(true);
//		
//		//CreateColumns();
//		
//	}
//	
//	/*
//	private void CreateColumns()
//	{
//		//dm = (DefaultTableModel) table.getModel();
//		
//		// add cols
//		dm.addColumn("CRN");
//		dm.addColumn("Subject");
//		dm.addColumn("Course Number");
//		dm.addColumn("Name");
//		dm.addColumn("Capacity");
//		dm.addColumn("Days");
//		dm.addColumn("Time");
//		dm.addColumn("Instructor");
//		
//	}
//	*/
//	
//	private void Populate(String crn, String subj, String num, String name, String cap, String days, String time, String instr)
//	{
//		String[] rowData = {crn, subj, num, name, cap, days, time, instr};
//		dm.addRow(rowData);
//	}
//	
//	private void addRowsActionPerformed(java.awt.event.ActionEvent evt) 
//	{
//		Populate(crnTxt.getText(), subTxt.getText(), numTxt.getText(), nameTxt.getText(), capTxt.getText(), daysTxt.getText(), timeTxt.getText(), instrTxt.getText());
//		
//		// clear
//		crnTxt.setText("");
//		subTxt.setText("");
//		numTxt.setText("");
//		nameTxt.setText("");
//		capTxt.setText("");
//		daysTxt.setText("");
//		timeTxt.setText("");
//		instrTxt.setText("");
//		
//	}
//	
//	
//}
//
//	
//	**/
//	
//
//	
//
