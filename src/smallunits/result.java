package smallunits;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
/*from   w w w.  j  a v a2  s.  c  om*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class result extends JFrame {
  public result() throws Exception {
  	getContentPane().setBackground(Color.WHITE);
  	setBackground(Color.WHITE);
    ArrayList columnNames = new ArrayList();
    ArrayList data = new ArrayList();
    String url = "jdbc:mysql://localhost:3306/poolin";
    String userid = "root";
    String password = "";
    String sql = "SELECT * FROM login";

    Connection connection = DriverManager.getConnection(url, userid, password);
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();
    for (int i = 1; i <= columns; i++) {
      columnNames.add(md.getColumnName(i));
    }
    while (rs.next()) {
      ArrayList row = new ArrayList(columns);
      for (int i = 1; i <= columns; i++) {
        row.add(rs.getObject(i));
      }
      data.add(row);
    }
    Vector columnNamesVector = new Vector();
    Vector dataVector = new Vector();
    for (int i = 0; i < data.size(); i++) {
      ArrayList subArray = (ArrayList) data.get(i);
      Vector subVector = new Vector();
      for (int j = 0; j < subArray.size(); j++) {
        subVector.add(subArray.get(j));
      }
      dataVector.add(subVector);
    }
    for (int i = 0; i < columnNames.size(); i++)
      columnNamesVector.add(columnNames.get(i));
    JTable table = new JTable(dataVector, columnNamesVector) {
      public Class getColumnClass(int column) {
        for (int row = 0; row < getRowCount(); row++) {
          Object o = getValueAt(row, column);
          if (o != null) {
            return o.getClass();
          }
        }
        return Object.class;
      }
    };
    table.setBackground(Color.WHITE);
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBackground(Color.WHITE);
    getContentPane().add(scrollPane);
    JPanel buttonPanel = new JPanel();
    getContentPane().add(buttonPanel, BorderLayout.SOUTH);
  }
  public static void main(String[] args) throws Exception {
    result frame = new result();
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}