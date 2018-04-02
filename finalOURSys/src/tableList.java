import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;

	
	public class tableList extends JFrame{
		JTable table;
		JButton add1;
		JButton delete;
		JButton save1;
		
		public tableList(){
			setLayout(new FlowLayout());
			
			
	
				
	            
			
				
	}
		
		

		
		public static void main(String args[]){
			tableList list1 = new tableList();
			list1.setSize(1000,370);
			list1.setVisible(true);
			list1.setTitle("2017 Spring Courses");
			
			//button add
			JButton add1 = new JButton("Add Course ");
			add1.setSize(add1.getPreferredSize());
			add1.setLocation(200,280);
			list1.add(add1);
			

			//button delete
			JButton delete = new JButton("Delete Course ");
			delete.setSize(delete.getPreferredSize());
			delete.setLocation(355, 280);
			list1.add(delete);
			
			//button Save
			JButton save1 = new JButton("Save Course ");
			save1.setSize(114,25);
			save1.setLocation(520, 280);
			list1.add(save1);
			
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
			
	           JCheckBox[]ch=new JCheckBox[columnName.length];
            
				JTable table = new JTable(courseList,columnName);
				table.setPreferredScrollableViewportSize(new Dimension(900,250));
				table.setFillsViewportHeight(true);
			
			
			
				
				JScrollPane scroll1 = new JScrollPane(table);
				table.add(scroll1);
				

	            final DefaultListModel model = new DefaultListModel();

	            JList list=new JList(model);
	            list.setCellRenderer(new CheckListRenderer());
	            for (int i = 0; i < columnName.length; i++) {
	                //ch[i]=new JCheckBox("CheckBox"+i);
	                model.addElement(new CheckListItem("CheckBox"+i));
	            }
	            JScrollPane pane=new JScrollPane(list);
	            list.addMouseListener(new MouseAdapter()
	            {
	                 public void mouseClicked(MouseEvent event)
	                 {
	                    JList list = (JList) event.getSource();
	                    // Get index of item clicked
	                    int index = list.locationToIndex(event.getPoint());
	                    CheckListItem item = (CheckListItem)
	                       list.getModel().getElementAt(index);
	                    // Toggle selected state
	                    item.setSelected(! item.isSelected());
	                    // Repaint cell
	                    list.repaint(list.getCellBounds(index, index));
	                 }
	            }); 
	            list1.add(pane);
	            list1.pack();
	            list1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            list1.setVisible(true);

			
		}
		
}
	class CheckListItem
    {
        private String  label;
        private boolean isSelected = false;

        public CheckListItem(String label)
        {
            this.label = label;
        }
        public boolean isSelected()
        {
            return isSelected;
        } 
        public void setSelected(boolean isSelected)
        {
            this.isSelected = isSelected;
        }
        public String toString()
        {
            return label;
        }
    }

    class CheckListRenderer extends JCheckBox implements ListCellRenderer
    {
        public Component getListCellRendererComponent(JList list, Object value, int index,boolean isSelected, boolean hasFocus)
        {
            setEnabled(list.isEnabled());
            setSelected(((CheckListItem)value).isSelected());
            setFont(list.getFont());
            setBackground(list.getBackground());
            setForeground(list.getForeground());
            setText(value.toString());
            return this;
        }
    }



