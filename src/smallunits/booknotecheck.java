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

public class booknotecheck extends JFrame implements ActionListener  {

	private JPanel contentPane;
	int xx,xy;
	private JTable table;
	private JTextField tf;
	private JTextField tf5;
	private JButton update;
	private JButton add;
	private JButton delete;
	private JTextField sub;
	private JTextField b1;
	private JTextField b2;
	private JTextField n2;
	private JTextField n1;
	private JTextField sun;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booknotecheck frame = new booknotecheck();
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
	
	
	public booknotecheck () {
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
				booknotecheck.this.setLocation(x-xx,y-xy);
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
		lblNewLabel.setIcon(new ImageIcon(booknotecheck.class.getResource("/smallunits/you.jpg")));
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
		lblNewLabel_2.setIcon(new ImageIcon(booknotecheck.class.getResource("/smallunits/Img/icons8-dashboard-50.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(20, 245, 46, 48);
		panel.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Books & Notes");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(71, 294, 112, 48);
		panel.add(lblNewLabel_3);
		
		
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
		lblNewLabel_6.setIcon(new ImageIcon(booknotecheck.class.getResource("/smallunits/Img/icons8-read-50.png")));
		lblNewLabel_6.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(20, 294, 46, 48);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(booknotecheck.class.getResource("/smallunits/Img/icons8-magazine-50.png")));
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
		lblNewLabel_12.setIcon(new ImageIcon(booknotecheck.class.getResource("/smallunits/Img/icons8-account-50.png")));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setBounds(20, 487, 46, 48);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setIcon(new ImageIcon(booknotecheck.class.getResource("/smallunits/Img/icons8-shutdown-50.png")));
		lblNewLabel_13.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setBounds(20, 535, 46, 48);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setIcon(new ImageIcon(booknotecheck.class.getResource("/smallunits/Img/icons8-help-50.png")));
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
		lblNewLabel_20.setIcon(new ImageIcon(booknotecheck.class.getResource("/smallunits/Img/icons8-events-50(1).png")));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_20.setBounds(20, 390, 46, 48);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon(booknotecheck.class.getResource("/smallunits/Img/icons8-payment-64(1).png")));
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_23.setBounds(20, 439, 46, 48);
		panel.add(lblNewLabel_23);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBounds(430, 11, 150, 48);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setIcon(new ImageIcon(booknotecheck.class.getResource("/smallunits/Img/pool(3).jpg")));
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
		
		JLabel lblNewLabel_4 = new JLabel("Branch :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(213, 136, 90, 31);
		contentPane.add(lblNewLabel_4);
		
		tf5 = new JTextField(20);
		tf5.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		tf5.setBounds(310, 138, 215, 31);
		contentPane.add(tf5);
		
		update = new JButton("UPDATE");
		update.setBorder(new LineBorder(new Color(0, 0, 0)));
		update.setFocusable(false);
		update.setBounds(352, 568, 285, 41);
		contentPane.add(update);
		update.setFont(new Font("Tahoma", Font.PLAIN, 15));
		update.setBackground(new Color(204, 204, 255));
		update.setForeground(Color.RED);
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String Branch=tf5.getText();
				String bname=b1.getText();
				String nname=n1.getText();
				String semb=b2.getText();
				String semin=n2.getText();
				String subb=sub.getText();
				String subn=sun.getText();
				
                int x=0;
                String query="";
                
				
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poolin", "root", "");
                    
                    //-----------------semi book db----------------
                    
                    query="UPDATE `semib` SET `semester`='"+semb+"',`book_name`='"+bname+"',`branch`='"+Branch+"' WHERE book_name='"+bname+"'";
                    
                    
                    Statement sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    

                    //-----------------semi notes db----------------------------
                    
                    query="UPDATE `semin` SET `semester`='"+semin+"',`notes_name`='"+nname+"',`branch`='"+Branch+"' WHERE notes_name='"+nname+"'";
                   
                    
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                    
                  //-----------------Subject book db----------------------------
                    
                    query="UPDATE `subb` SET `subject`='"+subb+"',`book_name`='"+bname+"',`branch`='"+Branch+"' WHERE book_name='"+bname+"'";
                    
                    
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                  //-----------------Subject Notes db----------------------------
                    
                    query="UPDATE `subn` SET `subject`='"+subn+"',`notes_name`='"+nname+"',`branch`='"+Branch+"' WHERE notes_name='"+nname+"'";
                    
                    
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                    
                    if (x == 0) {
                        JOptionPane.showMessageDialog(add, "This is alredy exist");
                    } 
                   
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
				
				
			}
			
		});
		
		add = new JButton("ADD");
		add.setBorder(new LineBorder(new Color(0, 0, 0)));
		add.setFocusable(false);
		add.setBounds(352, 620, 285, 39);
		contentPane.add(add);
		add.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add.setBackground(new Color(204, 204, 255));
		add.setForeground(Color.RED);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String Branch=tf5.getText();
				String bname=b1.getText();
				String nname=n1.getText();
				String semb=b2.getText();
				String semin=n2.getText();
				String subb=sub.getText();
				String subn=sun.getText();
				
                int x=0;
                String query="";
                
				
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poolin", "root", "");
                    
                    //-----------------semi book db----------------
                    
                    query="INSERT INTO `semib`(`semester`, `book_name`, `branch`) VALUES ('"+semb+"','"+bname+"','"+Branch+"')";


                    Statement sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    

                    //-----------------semi notes db----------------------------
                    
                    query="INSERT INTO `semin`(`semester`, `notes_name`, `branch`) VALUES ('"+semin+"','"+nname+"','"+Branch+"')";


                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                    
                  //-----------------Subject book db----------------------------
                    
                    query="INSERT INTO `subb`(`subject`, `book_name`, `branch`) VALUES ('"+subb+"','"+bname+"','"+Branch+"')";
                    
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                  //-----------------Subject Notes db----------------------------
                    
                    query="INSERT INTO `subn`(`subject`, `notes_name`, `branch`) VALUES ('"+subn+"','"+nname+"','"+Branch+"')";
                    
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
		delete.setBorder(new LineBorder(new Color(0, 0, 0)));
		delete.setFocusable(false);
		delete.setBounds(352, 670, 285, 36);
		contentPane.add(delete);
		delete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delete.setBackground(new Color(204, 204, 255));
		delete.setForeground(Color.RED);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String Branch=tf5.getText();
				String bname=b1.getText();
				String nname=n1.getText();
				String semb=b2.getText();
				String semin=n2.getText();
				String subb=sub.getText();
				String subn=sun.getText();
				
                int x=0;
                String query="";
                
				
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poolin", "root", "");
                    
                    //-----------------semi book db----------------
                    
                    query="DELETE FROM `semib` WHERE book_name='"+bname+"'";
                    
                    
                    Statement sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    

                    //-----------------semi notes db----------------------------
                    
                    query="DELETE FROM `semin` WHERE notes_name='"+nname+"'";
                    
                    
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                    
                  //-----------------Subject book db----------------------------
                    
                    query="DELETE FROM `subb` WHERE book_name='"+bname+"'";
                    
                    
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                  //-----------------Subject Notes db----------------------------
                    
                    query="DELETE FROM `subn` WHERE notes_name='"+nname+"'";
                    
                    
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                    
                    if (x == 0) {
                        JOptionPane.showMessageDialog(add, "This is alredy exist");
                    } 
                   
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
				


				
				
			}
			
		});
		
		JLabel lblNewLabel_7 = new JLabel("Subject :");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(213, 248, 81, 31);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_17 = new JLabel("Name :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17.setBounds(213, 290, 81, 31);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Semester :");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_18.setBounds(213, 331, 81, 31);
		contentPane.add(lblNewLabel_18);
		
		sub = new JTextField();
		sub.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sub.setBounds(297, 248, 481, 31);
		contentPane.add(sub);
		sub.setColumns(10);
		
		b1 = new JTextField();
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b1.setColumns(10);
		b1.setBounds(297, 290, 481, 31);
		contentPane.add(b1);
		
		b2 = new JTextField();
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b2.setColumns(10);
		b2.setBounds(297, 332, 481, 31);
		contentPane.add(b2);
		
		n2 = new JTextField();
		n2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		n2.setColumns(10);
		n2.setBounds(297, 481, 481, 31);
		contentPane.add(n2);
		
		JLabel lblNewLabel_18_1 = new JLabel("Semester :");
		lblNewLabel_18_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_18_1.setBounds(213, 480, 81, 31);
		contentPane.add(lblNewLabel_18_1);
		
		JLabel lblNewLabel_17_1 = new JLabel("Name :");
		lblNewLabel_17_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_17_1.setBounds(213, 439, 81, 31);
		contentPane.add(lblNewLabel_17_1);
		
		n1 = new JTextField();
		n1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		n1.setColumns(10);
		n1.setBounds(297, 439, 481, 31);
		contentPane.add(n1);
		
		sun = new JTextField();
		sun.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sun.setColumns(10);
		sun.setBounds(297, 397, 481, 31);
		contentPane.add(sun);
		
		JLabel lblNewLabel_7_1 = new JLabel("Subject :");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1.setBounds(213, 397, 81, 31);
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_22_1 = new JLabel("");
		lblNewLabel_22_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "-NOTES-", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_22_1.setBounds(213, 380, 577, 146);
		contentPane.add(lblNewLabel_22_1);
		
		JLabel lblNewLabel_22_1_1 = new JLabel("");
		lblNewLabel_22_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "-BOOKS-", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_22_1_1.setBounds(213, 230, 577, 146);
		contentPane.add(lblNewLabel_22_1_1);
		
		JLabel lblNewLabel_22_1_2 = new JLabel("");
		lblNewLabel_22_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "-NOTES-", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_22_1_2.setBounds(213, 544, 577, 176);
		contentPane.add(lblNewLabel_22_1_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFocusable(false);
		btnNewButton.setIcon(new ImageIcon(booknotecheck.class.getResource("/smallunits/Img/search.png")));
		btnNewButton.setBounds(522, 156, 31, 31);
		
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}  
}
		
		

