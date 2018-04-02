

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableTest {

	public static void main(String[] args) {
	    new TableTest();
	  }

	  public TableTest() {
	    startUI();
	  }

	  public void startUI() {
	    EventQueue.invokeLater(new Runnable() {
	      @Override
	      public void run() {
	    	  
	    	  JFrame frame = new JFrame("Student Fees");
		        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    	  JPanel panelR = new JPanel();
		   

	        MyTableModel model = new MyTableModel();
	        model.addRow(new Object[]{"Sharhea Bell", "BHX669", false});
	        model.addRow(new Object[]{"J'tia Williamson", "******", false});
	        model.addRow(new Object[]{"Chelsea Merriman", "******", true});
	        model.addRow(new Object[]{"Izzy A", "******", false});
	        JTable table = new JTable(model);
	        
	       
	        frame.add(new JScrollPane(table));
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        //frame.setSize(600,600);
	        frame.setVisible(true);
	        
	        
	    	table.add(panelR);
	  
	    	JButton print = new JButton("Print ");
			print.setSize(print.getPreferredSize());
			print.setLocation(90,150);
			table.add(print);
			
		
			
			print.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == print){
					JOptionPane.showMessageDialog(null, "This report has been saved");
		}
	}
});
	      
   }
	    });
	  }

	  public class MyTableModel extends DefaultTableModel {

	    public MyTableModel() {
	      super(new String[]{"Name", "UTC ID", "Fees"}, 0);
	    }

	    @Override
	    public Class<?> getColumnClass(int columnIndex) {
	      Class clazz = String.class;
	      switch (columnIndex) {
	        case 0:
	          clazz = Integer.class;
	          break;
	        case 2:
	          clazz = Boolean.class;
	          break;
	      }
	      return clazz;
	    }

	    @Override
	    public boolean isCellEditable(int row, int column) {
	      return column == 2;
	    }

	    @Override
	    public void setValueAt(Object aValue, int row, int column) {
	      if (aValue instanceof Boolean && column == 2) {
	        //System.out.println(aValue);
	        Vector rowData = (Vector)getDataVector().get(row);
	        rowData.set(2, (boolean)aValue);
	        fireTableCellUpdated(row, column);
	      }
	    }

	  }

	}
