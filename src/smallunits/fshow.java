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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class fshow extends JFrame {

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
					fshow frame = new fshow();
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
	
	
	public fshow()
	{
		
	}
	
	
	public fshow(String username) throws IOException, SQLException {
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
				fshow.this.setLocation(x-xx,y-xy);
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
				acoount ah = null;
				try {
					ah = new acoount(username);
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
		lblNewLabel_9.setBounds(834, 11, 24, 37);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_1 = new JLabel(" Details Of Fees");
		lblNewLabel_1.setIcon(new ImageIcon(fshow.class.getResource("/smallunits/Img/login.png")));
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 19));
		lblNewLabel_1.setBounds(51, 47, 773, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Status :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(98, 209, 153, 85);
		contentPane.add(lblNewLabel);
		
		JLabel status = new JLabel("");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setFont(new Font("Tahoma", Font.PLAIN, 21));
		status.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		status.setBounds(278, 209, 290, 85);
		contentPane.add(status);
		
		JLabel lblPrn = new JLabel("PRN :");
		lblPrn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrn.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblPrn.setBounds(98, 329, 153, 85);
		contentPane.add(lblPrn);
		
		JLabel prn = new JLabel("");
		prn.setHorizontalAlignment(SwingConstants.CENTER);
		prn.setFont(new Font("Tahoma", Font.PLAIN, 21));
		prn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		prn.setBounds(278, 329, 290, 85);
		contentPane.add(prn);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBorder(new TitledBorder(null, "-FEES-", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_4.setBounds(98, 167, 515, 311);
		contentPane.add(lblNewLabel_4);
		
		try {  
        	
        	
            String str = username,s1,s2,s3,s4,s5,s6;  
            
            String url = "jdbc:mysql://localhost:3306/poolin";
    	    String userid = "root";
    	    String password = "";
    	    String sql = "SELECT * FROM fshow";
            
    	    
    	    //------------------------------------------------------------------------------------record db---------------
             
            Connection con = DriverManager.getConnection(url, userid, password);  
            PreparedStatement st = con.prepareStatement("SELECT * FROM fshow where username=?");  
            st.setString(1, str);  
            //Excuting Query  
            ResultSet rs = st.executeQuery();  
          
           
            if (rs.next()) {  
                //String s = rs.getString(1);  
                s1 = rs.getString(1);
                s2 = rs.getString(2);
                
                  
  
                //Sets Records in TextFields.    
                status.setText(s1);  
                prn.setText(s2);
                
            } 
            
            
             
            
            //Create Exception Handler  
         } catch (Exception ex) {  
            System.out.println(ex);  
         }
	
		
        
		
	}
}



