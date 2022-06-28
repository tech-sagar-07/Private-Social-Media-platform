package smallunits;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import java.awt.List;
import java.awt.Window;

import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.border.TitledBorder;

public class admin extends JFrame implements ActionListener  {

	private JPanel contentPane;
	int xx,xy;
	private JTable table;
	private JTextField tf;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JButton btn;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField tf7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	
	
	public admin () throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 770);
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
				admin.this.setLocation(x-xx,y-xy);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 193, 889);
		panel.setBackground(Color.DARK_GRAY);
		panel.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(admin.class.getResource("/smallunits/you.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 229, 224);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dashboard");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(71, 245, 112, 48);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(admin.class.getResource("/smallunits/Img/icons8-dashboard-50.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(20, 245, 46, 48);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Books & Notes");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(71, 294, 112, 48);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				booknotecheck ah = new booknotecheck();
				ah.setUndecorated(true);
	            ah.setVisible(true);
				
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("Result");
		lblNewLabel_5.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(71, 342, 112, 48);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				resultcheck ah = new resultcheck();
				ah.setUndecorated(true);
	            ah.setVisible(true);
				
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setIcon(new ImageIcon(admin.class.getResource("/smallunits/Img/icons8-read-50.png")));
		lblNewLabel_6.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(20, 294, 46, 48);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(admin.class.getResource("/smallunits/Img/icons8-magazine-50.png")));
		lblNewLabel_8.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(20, 342, 46, 48);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Logout");
		lblNewLabel_9.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(71, 535, 112, 48);
		panel.add(lblNewLabel_9);
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				loginUI ah = new loginUI();
				ah.setUndecorated(true);
                ah.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_10 = new JLabel("Help");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_10.setBounds(71, 583, 112, 48);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("User Info");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_11.setBounds(71, 487, 112, 48);
		panel.add(lblNewLabel_11);
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				userInfo ah = new userInfo();
				ah.setUndecorated(true);
	            ah.setVisible(true);
				
			}
		});
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(admin.class.getResource("/smallunits/Img/icons8-account-50.png")));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setBounds(20, 487, 46, 48);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setIcon(new ImageIcon(admin.class.getResource("/smallunits/Img/icons8-shutdown-50.png")));
		lblNewLabel_13.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setBounds(20, 535, 46, 48);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setIcon(new ImageIcon(admin.class.getResource("/smallunits/Img/icons8-help-50.png")));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setBounds(20, 583, 46, 48);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_16 = new JLabel("Events");
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_16.setBounds(71, 390, 112, 48);
		panel.add(lblNewLabel_16);
		lblNewLabel_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				eventcheck ah = new eventcheck();
				ah.setUndecorated(true);
	            ah.setVisible(true);
				
			
			}
		});
		
		JLabel lblNewLabel_19 = new JLabel("Fees Check");
		lblNewLabel_19.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_19.setForeground(Color.WHITE);
		lblNewLabel_19.setBounds(71, 439, 112, 48);
		panel.add(lblNewLabel_19);
		lblNewLabel_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Feescheck ah = new Feescheck();
				ah.setUndecorated(true);
	            ah.setVisible(true);
				
			}
		});
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon(admin.class.getResource("/smallunits/Img/icons8-events-50(1).png")));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_20.setBounds(20, 390, 46, 48);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon(admin.class.getResource("/smallunits/Img/icons8-payment-64(1).png")));
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_23.setBounds(20, 439, 46, 48);
		panel.add(lblNewLabel_23);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBounds(430, 11, 150, 48);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setIcon(new ImageIcon(admin.class.getResource("/smallunits/Img/pool(3).jpg")));
		lblNewLabel_15.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_15);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.setBounds(808, 11, 46, 22);
		contentPane.add(lbl_close);
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lbl_close.setFont(new Font("Arial", Font.PLAIN, 19));
		lbl_close.setHorizontalTextPosition(SwingConstants.RIGHT);
		lbl_close.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_close.setForeground(new Color(255, 0, 0));
		lbl_close.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_4 = new JLabel("Username : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(232, 156, 90, 31);
		contentPane.add(lblNewLabel_4);
		
		btn = new JButton("");
		btn.setFocusable(false);
		btn.setIcon(new ImageIcon(admin.class.getResource("/smallunits/Img/search.png")));
		btn.setBackground(Color.WHITE);
		btn.setBounds(544, 156, 36, 31);
		contentPane.add(btn);
		
		tf5 = new JTextField(20);
		tf5.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		tf5.setBounds(319, 156, 215, 31);
		contentPane.add(tf5);
		
		tf4 = new JTextField(50);
		tf4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf4.setBounds(375, 581, 212, 46);
		contentPane.add(tf4);
		tf4.setBackground(Color.WHITE);
		tf4.setFocusable(false);
		
		JLabel lb4 = new JLabel("Current Sem :");
		lb4.setBounds(216, 582, 149, 45);
		contentPane.add(lb4);
		lb4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lb3 = new JLabel("FEES TILL-DATE :");
		lb3.setBounds(new Rectangle(0, 0, 0, 46));
		lb3.setBounds(216, 523, 149, 47);
		contentPane.add(lb3);
		lb3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tf3 = new JTextField(50);
		tf3.setBounds(new Rectangle(0, 0, 0, 46));
		tf3.setBounds(375, 521, 212, 49);
		contentPane.add(tf3);
		tf3.setBackground(Color.WHITE);
		tf3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf3.setEditable(false);
		
		tf2 = new JTextField(100);
		tf2.setBounds(new Rectangle(0, 0, 0, 46));
		tf2.setBounds(375, 460, 212, 52);
		contentPane.add(tf2);
		tf2.setBackground(Color.WHITE);
		tf2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf2.setFocusable(false);
		
		JLabel lb2 = new JLabel("SEMESTER :");
		lb2.setBounds(new Rectangle(0, 0, 0, 46));
		lb2.setBounds(216, 460, 146, 52);
		contentPane.add(lb2);
		lb2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lb1 = new JLabel("PRN NUMBER :");
		lb1.setBounds(216, 395, 146, 54);
		contentPane.add(lb1);
		lb1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tf1 = new JTextField(50);
		tf1.setBounds(375, 395, 212, 54);
		contentPane.add(tf1);
		tf1.setBackground(Color.WHITE);
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf1.setEditable(false);
		
		JLabel lblNewLabel_7 = new JLabel("Name :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(213, 280, 149, 46);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_17 = new JLabel("Branch :");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_17.setBounds(213, 337, 149, 47);
		contentPane.add(lblNewLabel_17);
		
		tf6 = new JTextField();
		tf6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf6.setBounds(375, 280, 212, 46);
		contentPane.add(tf6);
		tf6.setColumns(10);
		
		tf7 = new JTextField();
		tf7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf7.setBounds(375, 337, 212, 47);
		contentPane.add(tf7);
		tf7.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setBorder(new TitledBorder(null, "UserInfo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		lblNewLabel_18.setBounds(203, 253, 399, 393);
		contentPane.add(lblNewLabel_18);
		btn.addActionListener(this);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFocusable(false);
		btnNewButton.setIcon(new ImageIcon(admin.class.getResource("/smallunits/Img/search.png")));
		btnNewButton.setBounds(522, 156, 31, 31);
		
    }  
    public void actionPerformed(ActionEvent e) {  
        //Create DataBase Coonection and Fetching Records  
        try {  
            String str = tf5.getText();  
            
            String url = "jdbc:mysql://localhost:3306/poolin";
    	    String userid = "root";
    	    String password = "";
    	    String sql = "SELECT * FROM record";
            
    	    
    	    
            
            //Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con = DriverManager.getConnection(url, userid, password);  
            PreparedStatement st = con.prepareStatement("SELECT * FROM record where username=?");  
            st.setString(1, str);  
            //Excuting Query  
            ResultSet rs = st.executeQuery();  
            if (rs.next()) {  
                String s = rs.getString(1);  
                String s1 = rs.getString(2);  
                String s2 = rs.getString(3);  
                String s3 = rs.getString(4);  
                //Sets Records in TextFields.  
                tf1.setText(s);  
                tf2.setText(s1);  
                tf3.setText(s2);  
                tf4.setText(s3);  
            } else {  
                JOptionPane.showMessageDialog(null, "Name not Found");  
            } 
            
             
            st = con.prepareStatement("SELECT * FROM userinfo where username=?");  
            st.setString(1, str);  
            //Excuting Query  
            rs = st.executeQuery();  
            if (rs.next()) {  
                 
                String s1 = rs.getString(2);  
                String s2 = rs.getString(3);  
                  
                //Sets Records in TextFields.  
                 
                tf6.setText(s1);  
                tf7.setText(s2);  
                 
            }
            
            //Create Exception Handler  
        } catch (Exception ex) {  
            System.out.println(ex);  
        }  
    }
}
		
		

