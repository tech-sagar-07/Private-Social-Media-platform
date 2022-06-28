package smallunits;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import javax.swing.border.TitledBorder;

public class pay extends JFrame {
	
	private JPanel contentPane;
	int xx,xy;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	
	
	
	public pay()
	{
		
	}
	
	
	public pay(String username) throws IOException, SQLException{
  	
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
				pay.this.setLocation(x-xx,y-xy);
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
				payment ah = null;
				try {
					ah = new payment(username);
				} catch (IOException | SQLException e1) {
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
		
		JLabel lblNewLabel_1 = new JLabel(" Details Of Payment");
		lblNewLabel_1.setIcon(new ImageIcon(fshow.class.getResource("/smallunits/Img/login.png")));
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 19));
		lblNewLabel_1.setBounds(51, 47, 773, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("PRN :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(141, 231, 144, 47);
		contentPane.add(lblNewLabel);
		
		JLabel prn = new JLabel("");
		prn.setHorizontalAlignment(SwingConstants.CENTER);
		prn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		prn.setBounds(295, 231, 217, 47);
		contentPane.add(prn);
		
		JLabel sem = new JLabel("");
		sem.setHorizontalAlignment(SwingConstants.CENTER);
		sem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sem.setBounds(295, 286, 217, 47);
		contentPane.add(sem);
		
		JLabel lblSemester = new JLabel("Semester :");
		lblSemester.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSemester.setBounds(141, 286, 144, 47);
		contentPane.add(lblSemester);
		
		JLabel su = new JLabel("");
		su.setHorizontalAlignment(SwingConstants.CENTER);
		su.setFont(new Font("Tahoma", Font.PLAIN, 18));
		su.setBounds(295, 344, 217, 47);
		contentPane.add(su);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus.setBounds(141, 344, 144, 47);
		contentPane.add(lblStatus);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new TitledBorder(null, "-INFO-", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_2.setBounds(111, 206, 531, 214);
		contentPane.add(lblNewLabel_2);
		
		try {  
        	
            String str = username,s,s1,s2;  
            
            String url = "jdbc:mysql://localhost:3306/poolin";
    	    String userid = "root";
    	    String password = "";
    	    String sql = "SELECT * FROM fees";
            
    	    
    	    //------------------------------------------------------------------------------------record db---------------
             
            Connection con = DriverManager.getConnection(url, userid, password);  
            PreparedStatement st = con.prepareStatement("SELECT * FROM fees where username=?");  
            st.setString(1, str);  
            //Excuting Query  
            ResultSet rs = st.executeQuery();  
          
           
            if (rs.next()) {  
                //String s = rs.getString(1);  
                s = rs.getString(1);
                s1 = rs.getString(2);
                s2 = rs.getString(3);
                
                  
  
                //Sets Records in TextFields.    
                prn.setText(s); 
                sem.setText(s1);
                su.setText(s2);
                
            } 
            
            
             
            
            //Create Exception Handler  
         } catch (Exception ex) {  
            System.out.println(ex);  
         }
		
		
        
  }
  
	public static void main(String[] args) throws Exception {
		pay frame = new pay();
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	
  }
}