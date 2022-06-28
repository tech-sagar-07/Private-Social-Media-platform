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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class recl extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JLabel sem;
	private JLabel fe;
	private JLabel cu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recl frame = new recl();
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
	
	
	public recl()
	{
		
	}
	
	
	public recl(String username) throws IOException, SQLException {
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
				recl.this.setLocation(x-xx,y-xy);
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
		
		JLabel lblNewLabel = new JLabel("Semester :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(213, 254, 136, 47);
		contentPane.add(lblNewLabel);
		
		sem = new JLabel("");
		sem.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		sem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sem.setHorizontalAlignment(SwingConstants.CENTER);
		sem.setBounds(373, 254, 237, 47);
		contentPane.add(sem);
		
		JLabel lblFees = new JLabel("Fees :");
		lblFees.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFees.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFees.setBounds(213, 325, 136, 47);
		contentPane.add(lblFees);
		
		fe = new JLabel("");
		fe.setHorizontalAlignment(SwingConstants.CENTER);
		fe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		fe.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		fe.setBounds(373, 325, 237, 47);
		contentPane.add(fe);
		
		JLabel lblCurrentSemi = new JLabel("Current Semi:");
		lblCurrentSemi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurrentSemi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCurrentSemi.setBounds(213, 395, 136, 47);
		contentPane.add(lblCurrentSemi);
		
		cu = new JLabel("");
		cu.setHorizontalAlignment(SwingConstants.CENTER);
		cu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cu.setBounds(373, 395, 237, 47);
		contentPane.add(cu);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new TitledBorder(null, "-Result Check-", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_2.setBounds(133, 180, 555, 347);
		contentPane.add(lblNewLabel_2);
		
		
		try {  
        	
            String str = username,s1,s2,s3;  
            
            String url = "jdbc:mysql://localhost:3306/poolin";
    	    String userid = "root";
    	    String password = "";
    	    String sql = "SELECT * FROM record";
            
    	    
    	    //------------------------------------------------------------------------------------record db---------------
             
            Connection con = DriverManager.getConnection(url, userid, password);  
            PreparedStatement st = con.prepareStatement("SELECT * FROM record where username=?");  
            st.setString(1, str);  
            //Excuting Query  
            ResultSet rs = st.executeQuery();  
          
           
            if (rs.next()) {  
                //String s = rs.getString(1);  
                s1 = rs.getString(2);
                s2 = rs.getString(3);
                s3 = rs.getString(4);
                  
  
                //Sets Records in TextFields.    
                sem.setText(s1);  
                fe.setText(s2);
                cu.setText(s3);
            } else {  
                JOptionPane.showMessageDialog(null, "Name not Found");  
            }
          
            
            //Create Exception Handler  
         } catch (Exception ex) {  
            System.out.println(ex);  
         }
    	
            
            
    	
    
    	

		
		
		
		      
		}
	}




