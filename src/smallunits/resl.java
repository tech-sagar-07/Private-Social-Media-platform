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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class resl extends JFrame {

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
					resl frame = new resl();
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
	
	
	
	public resl()
	{
		
	}
	
	
	public resl(String username) throws IOException, SQLException  {
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
				resl.this.setLocation(x-xx,y-xy);
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
		
		JLabel lblNewLabel_1 = new JLabel(" Details of Result..!!");
		lblNewLabel_1.setIcon(new ImageIcon(fshow.class.getResource("/smallunits/Img/login.png")));
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 19));
		lblNewLabel_1.setBounds(51, 47, 773, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_18 = new JLabel("Semester 1 :");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_18.setBounds(176, 232, 117, 36);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_18_1 = new JLabel("Semester 2 :");
		lblNewLabel_18_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_18_1.setBounds(176, 279, 117, 36);
		contentPane.add(lblNewLabel_18_1);
		
		JLabel lblNewLabel_18_2 = new JLabel("Semester 3 :");
		lblNewLabel_18_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_18_2.setBounds(176, 326, 117, 36);
		contentPane.add(lblNewLabel_18_2);
		
		JLabel lblNewLabel_18_3 = new JLabel("Semester 4 :");
		lblNewLabel_18_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_18_3.setBounds(176, 369, 117, 36);
		contentPane.add(lblNewLabel_18_3);
		
		JLabel lblNewLabel_18_4 = new JLabel("Semester 5 :");
		lblNewLabel_18_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_18_4.setBounds(176, 412, 117, 36);
		contentPane.add(lblNewLabel_18_4);
		
		JLabel lblNewLabel_18_5 = new JLabel("Semester 6 :");
		lblNewLabel_18_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_18_5.setBounds(176, 457, 117, 36);
		contentPane.add(lblNewLabel_18_5);
		
		JLabel lblNewLabel_17_2 = new JLabel("");
		lblNewLabel_17_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_17_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "- MARKS -", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_17_2.setBounds(145, 198, 550, 336);
		contentPane.add(lblNewLabel_17_2);
		
		JLabel lblNewLabel = new JLabel("Status :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(421, 321, 68, 47);
		contentPane.add(lblNewLabel);
		
		JLabel se = new JLabel("");
		se.setBorder(new LineBorder(new Color(0, 0, 0)));
		se.setHorizontalAlignment(SwingConstants.CENTER);
		se.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se.setBounds(505, 326, 117, 36);
		contentPane.add(se);
		
		JLabel se1 = new JLabel("");
		se1.setHorizontalAlignment(SwingConstants.CENTER);
		se1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se1.setBorder(new LineBorder(new Color(0, 0, 0)));
		se1.setBounds(303, 232, 117, 36);
		contentPane.add(se1);
		
		JLabel se2 = new JLabel("");
		se2.setHorizontalAlignment(SwingConstants.CENTER);
		se2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se2.setBorder(new LineBorder(new Color(0, 0, 0)));
		se2.setBounds(303, 279, 117, 36);
		contentPane.add(se2);
		
		JLabel se3 = new JLabel("");
		se3.setHorizontalAlignment(SwingConstants.CENTER);
		se3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se3.setBorder(new LineBorder(new Color(0, 0, 0)));
		se3.setBounds(303, 326, 117, 36);
		contentPane.add(se3);
		
		JLabel se4 = new JLabel("");
		se4.setHorizontalAlignment(SwingConstants.CENTER);
		se4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se4.setBorder(new LineBorder(new Color(0, 0, 0)));
		se4.setBounds(303, 369, 117, 36);
		contentPane.add(se4);
		
		JLabel se5 = new JLabel("");
		se5.setHorizontalAlignment(SwingConstants.CENTER);
		se5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se5.setBorder(new LineBorder(new Color(0, 0, 0)));
		se5.setBounds(303, 412, 117, 36);
		contentPane.add(se5);
		
		JLabel se6 = new JLabel("");
		se6.setHorizontalAlignment(SwingConstants.CENTER);
		se6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se6.setBorder(new LineBorder(new Color(0, 0, 0)));
		se6.setBounds(303, 457, 117, 36);
		contentPane.add(se6);
		
		try {  
        	
        	
            String str = username,s1,s2,s3,s4,s5,s6;  
            
            String url = "jdbc:mysql://localhost:3306/poolin";
    	    String userid = "root";
    	    String password = "";
    	    String sql = "SELECT * FROM marks";
            
    	    
    	    //------------------------------------------------------------------------------------record db---------------
             
            Connection con = DriverManager.getConnection(url, userid, password);  
            PreparedStatement st = con.prepareStatement("SELECT * FROM marks where username=?");  
            st.setString(1, str);  
            //Excuting Query  
            ResultSet rs = st.executeQuery();  
          
           
            if (rs.next()) {  
                //String s = rs.getString(1);  
                s1 = rs.getString(2);
                s2 = rs.getString(3);
                s3 = rs.getString(4);
                s4 = rs.getString(5);
                s5 = rs.getString(6);
                s6 = rs.getString(7);
                  
  
                //Sets Records in TextFields.    
                se1.setText(s1);  
                se2.setText(s2);
                se3.setText(s3);
                se4.setText(s4);  
                se5.setText(s5);
                se6.setText(s6);
            } 
            
            
            st = con.prepareStatement("SELECT * FROM record where username=?");  
            st.setString(1, str);  
            //Excuting Query  
            rs = st.executeQuery();  
          
           
            if (rs.next()) {  
                //String s = rs.getString(1);  
                s1 = rs.getString(2);
                
                  
  
                //Sets Records in TextFields.    
                se.setText(s1);  
                
            } 
            
            //Create Exception Handler  
         } catch (Exception ex) {  
            System.out.println(ex);  
         }
		
		
		
	}
}



