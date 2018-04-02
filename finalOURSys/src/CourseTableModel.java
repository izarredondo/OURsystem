import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CourseTableModel extends AbstractTableModel{
	private List<Course> list = new ArrayList<Course>();
    private String[] columnNames = {"CRN","Subject","Number","Name", "Capacity", "Days", "Time", "Instructor"};

    public void setList(List<Course> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
        case 0:
            return list.get(rowIndex).getCRN();
        case 1:
            return list.get(rowIndex).getSubj();
        default:
            return null;
        }
    }
}
