import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;

public class ViewDialog {

    public static String getSomeText() {
        String text ="";
        JFrame jfrm0 = new JFrame("Enter some chars");

        do {
            text = JOptionPane.showInputDialog(jfrm0, "Input some chars below: ", new String("Not longer than" +
                    Permutation.MAX_CHARS + " symbols"));
            if(text == null) {
                return null;
            }
        } while (text.isEmpty() || (text.length() > Permutation.MAX_CHARS));
        return text;
    }

    public static void showInfo(String msg, String result){
        JFrame jfrm0 = new JFrame(msg);
        JOptionPane.showMessageDialog(jfrm0, result);
    }

    public void viewData(List<String> msg) {

//        int columnFreeSpace = 20;
        final int frameWidth = 200;
        final int frameHeigth = 800;
        JFrame jfrm = new JFrame("");
        jfrm.setSize(frameWidth, frameHeigth);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
        contentPane.setLayout(new BorderLayout(0, 0));

        String[] fields = new String[]{"Permutations"};
        TableModel MyTableModel = new TableModel(fields);
        JTable table = new JTable(MyTableModel);

        TableRowSorter<TableModel> sorter = new TableRowSorter(MyTableModel);
        table.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(table);

        table.setAutoCreateRowSorter(true);
        table.setGridColor(new Color(0x66, 0x66, 0x66, 0x66));
        table.setShowVerticalLines(false);
        table.setIntercellSpacing(new Dimension(0, 1));

        jfrm.add(contentPane);

        String[] s = new String[1];
        for (String dh : msg) {
//            System.out.println(dh);
            s[0] = dh;
            MyTableModel.addRow(s);
        }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

        jfrm.setVisible(true);
    }

    public class TableModel extends DefaultTableModel {

        private static final long serialVersionUID = 1L;

        public TableModel (String[] fields){

            for(String field : fields) this.addColumn(field);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 0) return false;
            return true;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0: return String.class;
//                case 1: return BigDecimal.class;
//                case 2: return BigDecimal.class;
//                case 3: return String.class;
//                case 4: return String.class;
//                case 5: return String.class;
//                case 6: return String.class;
//                case 7: return BigDecimal.class;
            }
            return null;
        }
    }
}