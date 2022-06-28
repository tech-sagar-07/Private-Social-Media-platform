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

public class userInfo extends JFrame implements ActionListener  {

	private JPanel contentPane;
	int xx,xy;
	private JTable table;
	private JTextField tf;
	private JButton search;
	private JTextField tf5;
	private JTextField se1;
	private JTextField se2;
	private JTextField se3;
	private JTextField se4;
	private JTextField se5;
	private JTextField se6;
	private JTextField tf6;
	private JTextField tf7;
	private JTextField tf8;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JButton update;
	private JButton add;
	private JButton delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userInfo frame = new userInfo();
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
	
	
	public userInfo () {
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
				userInfo.this.setLocation(x-xx,y-xy);
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
		lblNewLabel.setIcon(new ImageIcon(userInfo.class.getResource("/smallunits/you.jpg")));
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
		lblNewLabel_2.setIcon(new ImageIcon(userInfo.class.getResource("/smallunits/Img/icons8-dashboard-50.png")));
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
		lblNewLabel_6.setIcon(new ImageIcon(userInfo.class.getResource("/smallunits/Img/icons8-read-50.png")));
		lblNewLabel_6.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(20, 294, 46, 48);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(userInfo.class.getResource("/smallunits/Img/icons8-magazine-50.png")));
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
		
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(userInfo.class.getResource("/smallunits/Img/icons8-account-50.png")));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setBounds(20, 487, 46, 48);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setIcon(new ImageIcon(userInfo.class.getResource("/smallunits/Img/icons8-shutdown-50.png")));
		lblNewLabel_13.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setBounds(20, 535, 46, 48);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setIcon(new ImageIcon(userInfo.class.getResource("/smallunits/Img/icons8-help-50.png")));
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
		lblNewLabel_20.setIcon(new ImageIcon(userInfo.class.getResource("/smallunits/Img/icons8-events-50(1).png")));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_20.setBounds(20, 390, 46, 48);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon(userInfo.class.getResource("/smallunits/Img/icons8-payment-64(1).png")));
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_23.setBounds(20, 439, 46, 48);
		panel.add(lblNewLabel_23);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBounds(430, 11, 150, 48);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setIcon(new ImageIcon(userInfo.class.getResource("/smallunits/Img/pool(3).jpg")));
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
		search.setIcon(new ImageIcon(userInfo.class.getResource("/smallunits/Img/search.png")));
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
		    	    String sql = "SELECT * FROM record";
		            
		    	    
		    	    //------------------------------------------------------------------------------------record db---------------
		             
		            Connection con = DriverManager.getConnection(url, userid, password);  
		            PreparedStatement st = con.prepareStatement("SELECT * FROM record where username=?");  
		            st.setString(1, str);  
		            //Excuting Query  
		            ResultSet rs = st.executeQuery();  
		            if (rs.next()) {  
		                s = rs.getString(1);  
		                s1 = rs.getString(2);  
		                s2 = rs.getString(3);  
		                s3 = rs.getString(4);  
		                //Sets Records in TextFields.  
		                tf1.setText(s);  
		                tf2.setText(s1);  
		                tf3.setText(s2);  
		                tf4.setText(s3);  
		            } else {  
		                JOptionPane.showMessageDialog(null, "Name not Found");  
		            }  
		            
		            
		          //------------------------------------------------------------------------------------userinfo db---------------
		            
		            
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
		            
		            
		            
		          //------------------------------------------------------------------------------------Login db---------------
		            
		            
		            sql = "SELECT * FROM login";
		  
		            st = con.prepareStatement("SELECT * FROM login where username=?");  
		            st.setString(1, str); 
		           
		            //Excuting Query  
		            rs = st.executeQuery();
		            
		            if (rs.next()) {  
		                //String s = rs.getString(1);  
		                //String s1 = rs.getString(2);  
		                s2 = rs.getString(3);  
		  
		                //Sets Records in TextFields.    
		                tf7.setText(s2);    
		            } else {  
		                JOptionPane.showMessageDialog(null, "Name not Found");  
		            }
		            
		            
		     
		            
		          //------------------------------------------------------------------------------------marks db---------------
		            
		            sql = "SELECT * FROM marks";
		            
		            st = con.prepareStatement("SELECT * FROM marks where username=?");  
		            st.setString(1, str); 
		           
		            //Excuting Query  
		            rs = st.executeQuery();
		            
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
		
		JLabel lb1 = new JLabel("PRN NUMBER :");
		lb1.setBounds(499, 250, 123, 36);
		contentPane.add(lb1);
		lb1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lb2 = new JLabel("SEMESTER :");
		lb2.setBounds(499, 297, 123, 36);
		contentPane.add(lb2);
		lb2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lb3 = new JLabel("FEES TILL-DATE :");
		lb3.setBounds(499, 353, 123, 30);
		contentPane.add(lb3);
		lb3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lb4 = new JLabel("STATUS :");
		lb4.setBounds(509, 403, 113, 30);
		contentPane.add(lb4);
		lb4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_18 = new JLabel("Semi 1: ");
		lblNewLabel_18.setBounds(223, 423, 75, 36);
		contentPane.add(lblNewLabel_18);
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		se1 = new JTextField();
		se1.setBounds(312, 424, 86, 36);
		contentPane.add(se1);
		se1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se1.setColumns(10);
		
		update = new JButton("UPDATE");
		update.setFocusable(false);
		update.setBounds(547, 504, 233, 41);
		contentPane.add(update);
		update.setFont(new Font("Tahoma", Font.PLAIN, 15));
		update.setBackground(new Color(204, 204, 255));
		update.setForeground(Color.RED);
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String userName = tf1.getText(),Username=tf5.getText();
                String Semester = tf2.getText();
                String Fees = tf3.getText();
                String Current = tf4.getText();
                String password=tf7.getText();
                String Name=tf6.getText(),Branch=tf8.getText();
                String sem1=se1.getText(),sem2=se2.getText(),sem3=se3.getText(),sem4=se4.getText(),sem5=se5.getText(),sem6=se6.getText();
                int x=0;
                String query="";
                
				
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poolin", "root", "");
                    
                    //-----------------record db----------------
                    
                    query="UPDATE `record` SET `username`='"+userName+"',`semister`='"+Semester+"',`fees`='"+Fees+"',`current_semister`='"+Current+"' WHERE username='"+Username+"'";
                  

                    Statement sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    

                    //-----------------login db----------------------------
                    
                    query="UPDATE `login` SET `username`='"+userName+"',`password`='"+password+"' WHERE username='"+Username+"'";


                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                    
                  //-----------------Marks db----------------------------
                    query="UPDATE `marks` SET `username`='"+userName+"',`sem 1`='"+sem1+"',`sem 2`='"+sem2+"',`sem 3`='"+sem3+"',`sem 4`='"+sem4+"',`sem 5`='"+sem5+"',`sem 6`='"+sem6+"' WHERE username='"+Username+"'";
      
                    
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                  //-----------------userinfo db----------------------------
                    
                    query="UPDATE `userinfo` SET `username`='"+userName+"',`name`='"+Name+"',`branch`='"+Branch+"' WHERE username='"+Username+"'";
                    
                    sta = connection.createStatement();
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
		
		add = new JButton("ADD");
		add.setFocusable(false);
		add.setBounds(547, 559, 233, 39);
		contentPane.add(add);
		add.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add.setBackground(new Color(204, 204, 255));
		add.setForeground(Color.RED);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = tf1.getText();
                String Semester = tf2.getText();
                String Fees = tf3.getText();
                String Current = tf4.getText();
                String password=tf7.getText();
                String Name=tf6.getText(),Branch=tf8.getText();
                String sem1=se1.getText(),sem2=se2.getText(),sem3=se3.getText(),sem4=se4.getText(),sem5=se5.getText(),sem6=se6.getText();
                int x=0;
                String query="";
                
				
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poolin", "root", "");
                    
                    //-----------------record db----------------
                    
                    query="INSERT INTO `record`(`username`, `semister`, `fees`, `current_semister`) VALUES ('"+userName+"','"+Semester+"','"+Fees+"','"+Current+"')";


                    Statement sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    

                    //-----------------login db----------------------------
                    
                    query="INSERT INTO `login`( `username`, `password`) VALUES ('"+userName+"','"+password+"')";


                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                    
                  //-----------------Marks db----------------------------
                    
                    query="INSERT INTO `marks`(`username`, `sem 1`, `sem 2`, `sem 3`, `sem 4`, `sem 5`, `sem 6`) VALUES ('"+userName+"','"+sem1+"','"+sem2+"','"+sem3+"','"+sem4+"','"+sem5+"','"+sem6+"')";
                    
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                  //-----------------userinfo db----------------------------
                    
                    query="INSERT INTO `userinfo`(`username`, `name`, `branch`) VALUES ('"+userName+"','"+Name+"','"+Branch+"')";
                    
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                    
                    if (x == 0) {
                        JOptionPane.showMessageDialog(add, "This is alredy exist");
                    } 
                   
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
				
			}});
		
		delete = new JButton("DELETE");
		delete.setFocusable(false);
		delete.setBounds(547, 620, 233, 36);
		contentPane.add(delete);
		delete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delete.setBackground(new Color(204, 204, 255));
		delete.setForeground(Color.RED);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String Username=tf5.getText();

                int x=0;
                String query="";
                
				
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poolin", "root", "");
                    
                    //-----------------record db----------------
                    query="DELETE FROM `record` WHERE username='"+Username+"'";
                   

                    Statement sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    

                    //-----------------login db----------------------------
                    query="DELETE FROM `login` WHERE username='"+Username+"'";


                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                    
                  //-----------------Marks db----------------------------
                    query="DELETE FROM `marks` WHERE username='"+Username+"'";
                     
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                  //-----------------userinfo db----------------------------
                    query="DELETE FROM `userinfo` WHERE username='"+Username+"'";
                   
                    
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                    
                    if (x == 0) {
                        JOptionPane.showMessageDialog(delete, "This is alredy exist");
                    } 
                   
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

				
				
			}
			
		});
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setBounds(509, 467, 304, 217);
		contentPane.add(lblNewLabel_21);
		lblNewLabel_21.setBorder(new TitledBorder(null, "-OPERATION-", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_18_1 = new JLabel("Semi 2: ");
		lblNewLabel_18_1.setBounds(223, 470, 75, 36);
		contentPane.add(lblNewLabel_18_1);
		lblNewLabel_18_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_18_2 = new JLabel("Semi 3: ");
		lblNewLabel_18_2.setBounds(223, 517, 75, 36);
		contentPane.add(lblNewLabel_18_2);
		lblNewLabel_18_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_18_3 = new JLabel("Semi 4: ");
		lblNewLabel_18_3.setBounds(223, 560, 75, 36);
		contentPane.add(lblNewLabel_18_3);
		lblNewLabel_18_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_18_4 = new JLabel("Semi 5: ");
		lblNewLabel_18_4.setBounds(223, 603, 75, 36);
		contentPane.add(lblNewLabel_18_4);
		lblNewLabel_18_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_18_5 = new JLabel("Semi 6: ");
		lblNewLabel_18_5.setBounds(223, 648, 75, 36);
		contentPane.add(lblNewLabel_18_5);
		lblNewLabel_18_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		se2 = new JTextField();
		se2.setBounds(312, 471, 86, 36);
		contentPane.add(se2);
		se2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se2.setColumns(10);
		
		se3 = new JTextField();
		se3.setBounds(312, 518, 86, 36);
		contentPane.add(se3);
		se3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se3.setColumns(10);
		
		se4 = new JTextField();
		se4.setBounds(312, 561, 86, 36);
		contentPane.add(se4);
		se4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se4.setColumns(10);
		
		se5 = new JTextField();
		se5.setBounds(312, 604, 86, 36);
		contentPane.add(se5);
		se5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se5.setColumns(10);
		
		se6 = new JTextField();
		se6.setBounds(312, 651, 86, 36);
		contentPane.add(se6);
		se6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		se6.setColumns(10);
		
		JLabel lblNewLabel_17_2 = new JLabel("");
		lblNewLabel_17_2.setBounds(213, 408, 246, 301);
		contentPane.add(lblNewLabel_17_2);
		lblNewLabel_17_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "- MARKS -", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_17_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setBounds(203, 209, 290, 189);
		contentPane.add(lblNewLabel_22);
		lblNewLabel_22.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "-USER-", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblNewLabel_24 = new JLabel("");
		lblNewLabel_24.setBounds(493, 209, 361, 250);
		contentPane.add(lblNewLabel_24);
		lblNewLabel_24.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "-Profile status-", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblNewLabel_17_1 = new JLabel("BRANCH :");
		lblNewLabel_17_1.setBounds(206, 335, 94, 36);
		contentPane.add(lblNewLabel_17_1);
		lblNewLabel_17_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_17 = new JLabel("PASSWORD :");
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
		
		tf1 = new JTextField();
		tf1.setBounds(632, 245, 212, 41);
		contentPane.add(tf1);
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(632, 297, 212, 36);
		contentPane.add(tf2);
		tf2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setBounds(632, 353, 212, 36);
		contentPane.add(tf3);
		tf3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf3.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setBounds(632, 401, 212, 36);
		contentPane.add(tf4);
		tf4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf4.setColumns(10);
		search.addActionListener(this);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFocusable(false);
		btnNewButton.setIcon(new ImageIcon(userInfo.class.getResource("/smallunits/Img/search.png")));
		btnNewButton.setBounds(522, 156, 31, 31);
		
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}  
}
		
		

