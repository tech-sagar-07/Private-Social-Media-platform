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
import java.sql.Statement;

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
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Feescheck extends JFrame implements ActionListener  {

	private JPanel contentPane;
	int xx,xy;
	private JTable table;
	private JTextField tf;
	private JButton search;
	private JTextField tf5;
	private JTextField se1;
	private JTextField tf6;
	private JTextField tf7;
	private JTextField tf8;
	private JButton update;
	private JButton add;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feescheck frame = new Feescheck();
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
	
	
	public Feescheck () {
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
				Feescheck.this.setLocation(x-xx,y-xy);
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
		lblNewLabel.setIcon(new ImageIcon(Feescheck.class.getResource("/smallunits/you.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 229, 224);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dashboard");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(71, 245, 112, 48);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				admin ah = null;
				try {
					ah = new admin();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ah.setUndecorated(true);
	            ah.setVisible(true);
				
			}
		});
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Feescheck.class.getResource("/smallunits/Img/icons8-dashboard-50.png")));
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
		lblNewLabel_6.setIcon(new ImageIcon(Feescheck.class.getResource("/smallunits/Img/icons8-read-50.png")));
		lblNewLabel_6.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(20, 294, 46, 48);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Feescheck.class.getResource("/smallunits/Img/icons8-magazine-50.png")));
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
		lblNewLabel_12.setIcon(new ImageIcon(Feescheck.class.getResource("/smallunits/Img/icons8-account-50.png")));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setBounds(20, 487, 46, 48);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setIcon(new ImageIcon(Feescheck.class.getResource("/smallunits/Img/icons8-shutdown-50.png")));
		lblNewLabel_13.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setBounds(20, 535, 46, 48);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setIcon(new ImageIcon(Feescheck.class.getResource("/smallunits/Img/icons8-help-50.png")));
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
		
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon(Feescheck.class.getResource("/smallunits/Img/icons8-events-50(1).png")));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_20.setBounds(20, 390, 46, 48);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon(Feescheck.class.getResource("/smallunits/Img/icons8-payment-64(1).png")));
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_23.setBounds(20, 439, 46, 48);
		panel.add(lblNewLabel_23);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBounds(430, 11, 150, 48);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setIcon(new ImageIcon(Feescheck.class.getResource("/smallunits/Img/pool(3).jpg")));
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
		lblNewLabel_4.setBounds(213, 136, 90, 31);
		contentPane.add(lblNewLabel_4);
		
		search = new JButton("");
		search.setFocusable(false);
		search.setIcon(new ImageIcon(Feescheck.class.getResource("/smallunits/Img/search.png")));
		search.setBackground(Color.WHITE);
		search.setBounds(527, 138, 36, 31);
		contentPane.add(search);
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ran=0;
		    	String str="";
		    	String s="",s1="",s2="",s3="",s4="",s5="",s6="",s7="";
		        
		    	if(e.getSource()==search)
		    	{
		    	try {  
		        	
		        	ran=1;
		            str = tf5.getText();  
		            
		            String url = "jdbc:mysql://localhost:3306/poolin";
		    	    String userid = "root";
		    	    String password = "";
		    	    String sql = " ";
		            
		    	    
		    	    //------------------------------------------------------------------------------------record db---------------
		             
		            Connection con = DriverManager.getConnection(url, userid, password);  
		            PreparedStatement st = con.prepareStatement("SELECT * FROM record where username=?");  
		            st.setString(1, str);  
		            //Excuting Query  
		            ResultSet rs = st.executeQuery();  
		            
		            
		          //------------------------------------------------------------------------------------Feescheck db---------------
		            
		            
		            sql = "SELECT * FROM userinfo";
		            
		            st = con.prepareStatement("SELECT * FROM userinfo where username=?");  
		            st.setString(1, str); 
		           
		            //Excuting Query  
		            rs = st.executeQuery();
		            
		            if (rs.next()) {  
		                //String s = rs.getString(1);  
		                s1 = rs.getString(2);
		                s2 = rs.getString(3);
		                  
		  
		                //Sets Records in TextFields.    
		                tf6.setText(s1);  
		                tf8.setText(s2);
		            } else {  
		                JOptionPane.showMessageDialog(null, "Name not Found");  
		            }
		            
		            
		     
		            
		          //------------------------------------------------------------------------------------fees db---------------
		            
		            sql = "SELECT * FROM fees";
		            
		            st = con.prepareStatement("SELECT * FROM fees where username=?");  
		            st.setString(1, str); 
		           
		            //Excuting Query  
		            rs = st.executeQuery();
		            
		            if (rs.next()) {  
		                s = rs.getString(2);  
		                s1 = rs.getString(3);  
		  
		                //Sets Records in TextFields.
		                tf7.setText(s1);
		                se1.setText(s);    
		                  
		            } else {  
		                JOptionPane.showMessageDialog(null, "Name not Found");  
		            }
		            
		            
		            
		            
		            
		            //Create Exception Handler  
		         } catch (Exception ex) {  
		            System.out.println(ex);  
		         }
		    	}
		    //----------------------------------------------------------------------------------------Seach End
		    	
		  
				
			}
			
		});
		
		tf5 = new JTextField(20);
		tf5.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		tf5.setBounds(310, 138, 215, 31);
		contentPane.add(tf5);
		
		JLabel lblNewLabel_18 = new JLabel("Semester : ");
		lblNewLabel_18.setBounds(513, 286, 90, 36);
		contentPane.add(lblNewLabel_18);
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		se1 = new JTextField();
		se1.setBounds(617, 287, 86, 36);
		contentPane.add(se1);
		se1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se1.setColumns(10);
		
		update = new JButton("UPDATE");
		update.setFocusable(false);
		update.setBounds(347, 557, 233, 41);
		contentPane.add(update);
		update.setFont(new Font("Tahoma", Font.PLAIN, 15));
		update.setBackground(new Color(204, 204, 255));
		update.setForeground(Color.RED);
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String userName = tf5.getText();
				String Username=tf5.getText();
                //String Semester = tf2.getText();
                //String Fees = tf3.getText();
                //String Current = tf4.getText();
                String status=tf7.getText();
                String Name=tf6.getText(),Branch=tf8.getText();
                String sem1=se1.getText();
                int x=0;
                String query="";
                
				
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poolin", "root", "");
                    
                    
                  //-----------------Marks db----------------------------
                    query="UPDATE `fees` SET `semester`='"+sem1+"',`status`='"+status+"' WHERE username='"+userName+"'";
                    //query="UPDATE `marks` SET `username`='"+userName+"',`sem 1`='"+sem1+"',`sem 2`='"+sem2+"',`sem 3`='"+sem3+"',`sem 4`='"+sem4+"',`sem 5`='"+sem5+"',`sem 6`='"+sem6+"' WHERE username='"+Username+"'";
      
                    
                    Statement sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                  
                    
                    
                    if (x == 0) {
                        JOptionPane.showMessageDialog(update, "This is alredy exist");
                    } 
                   
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

				
				
			}
			
		});
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setBounds(312, 438, 304, 194);
		contentPane.add(lblNewLabel_21);
		lblNewLabel_21.setBorder(new TitledBorder(null, "-OPERATION-", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_17_2 = new JLabel("");
		lblNewLabel_17_2.setBounds(504, 253, 246, 111);
		contentPane.add(lblNewLabel_17_2);
		lblNewLabel_17_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "- FEES -", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_17_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setBounds(203, 209, 290, 189);
		contentPane.add(lblNewLabel_22);
		lblNewLabel_22.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "-USER-", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblNewLabel_17_1 = new JLabel("BRANCH :");
		lblNewLabel_17_1.setBounds(206, 335, 94, 36);
		contentPane.add(lblNewLabel_17_1);
		lblNewLabel_17_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_17 = new JLabel("STATUS :");
		lblNewLabel_17.setBounds(207, 282, 93, 36);
		contentPane.add(lblNewLabel_17);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_7 = new JLabel("Name :");
		lblNewLabel_7.setBounds(207, 235, 93, 36);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tf6 = new JTextField();
		tf6.setBounds(310, 235, 173, 36);
		contentPane.add(tf6);
		tf6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf6.setColumns(10);
		
		tf7 = new JTextField();
		tf7.setBounds(312, 282, 173, 36);
		contentPane.add(tf7);
		tf7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf7.setColumns(10);
		
		tf8 = new JTextField();
		tf8.setBounds(312, 336, 173, 36);
		contentPane.add(tf8);
		tf8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf8.setColumns(10);
		
		add = new JButton("ADD");
		add.setForeground(Color.RED);
		add.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add.setFocusable(false);
		add.setBackground(new Color(204, 204, 255));
		add.setBounds(347, 488, 233, 41);
		contentPane.add(add);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userName = tf5.getText();
				String Username=tf5.getText();
                //String Semester = tf2.getText();
                //String Fees = tf3.getText();
                //String Current = tf4.getText();
                String status=tf7.getText();
                String Name=tf6.getText(),Branch=tf8.getText();
                String sem1=se1.getText();
                int x=0;
                String query="";
                
				
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poolin", "root", "");
                    
                    
                  //-----------------Marks db----------------------------
                    query="INSERT INTO `fees`(`username`, `semester`, `status`) VALUES ('"+userName+"','"+sem1+"','"+status+"')";
                    
                    
                    Statement sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                  
                    
                    
                    if (x == 0) {
                        JOptionPane.showMessageDialog(update, "This is alredy exist");
                    } 
                   
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
			}
			
		});
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFocusable(false);
		btnNewButton.setIcon(new ImageIcon(Feescheck.class.getResource("/smallunits/Img/search.png")));
		btnNewButton.setBounds(522, 156, 31, 31);
		
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}  
}
		
		

