package smallunits;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Component;

public class eventl extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eventl frame = new eventl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings("unchecked")
	eventl()
	{
		
	}
	
	
	public eventl(String username) throws IOException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 720);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				xx=e.getX();
				xy=e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				eventl.this.setLocation(x-xx,y-xy);
			}
		});
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_9 = new JLabel("X");
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				mwindow ah = null;
				try {
					ah = new mwindow(username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ah.setUndecorated(true);
                ah.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		lblNewLabel_9.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setBounds(836, 11, 24, 37);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_1 = new JLabel(" Details Of Events");
		lblNewLabel_1.setIcon(new ImageIcon(fshow.class.getResource("/smallunits/Img/login.png")));
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 19));
		lblNewLabel_1.setBounds(51, 47, 773, 47);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(62, 121, 759, 507);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 739, 491);
		panel.add(scrollPane);
		
		
		ArrayList columnNames = new ArrayList();
	    ArrayList data = new ArrayList();
	    
	    String url = "jdbc:mysql://localhost:3306/poolin";
	    String userid = "root";
	    String password = "";
	    String sql = "SELECT * FROM eventl";

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
		
	    
		scrollPane.setViewportView(table);
		
	}
}



