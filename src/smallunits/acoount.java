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
import java.awt.Image;

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
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class acoount extends JFrame  {

	private JPanel contentPane;
	int xx,xy;
	private JTable table;
	private JButton edit_profile,cshow,fshow,eshow;
	private JLabel profile;
	private String Imagepath="/smallunits/Img/new member.png";
	private File file;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acoount frame = new acoount();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	private void addIcon(String imagepath){
		Imagepath=imagepath;
		//image path is fetched from user 
		
	}

	public acoount()
	{
		
	}
	
	
	public acoount(String username) throws IOException, SQLException {
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
				acoount.this.setLocation(x-xx,y-xy);
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
		lblNewLabel.setIcon(new ImageIcon(acoount.class.getResource("/smallunits/you.jpg")));
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
				setVisible(false);
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
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(acoount.class.getResource("/smallunits/Img/icons8-dashboard-50.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(20, 245, 46, 48);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Books");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(71, 294, 112, 48);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				books ah = null;
				try {
					ah = new books(username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ah.setUndecorated(true);
                ah.setVisible(true);
			}
		});
		
		lblNewLabel_5 = new JLabel("Notes");
		lblNewLabel_5.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(71, 342, 112, 48);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				notes ah = null;
				try {
					ah = new notes(username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ah.setUndecorated(true);
                ah.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setIcon(new ImageIcon(acoount.class.getResource("/smallunits/Img/icons8-read-50.png")));
		lblNewLabel_6.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(20, 294, 46, 48);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(acoount.class.getResource("/smallunits/Img/icons8-magazine-50.png")));
		lblNewLabel_8.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(20, 342, 46, 48);
		panel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Logout");
		lblNewLabel_9.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(71, 535, 112, 48);
		panel.add(lblNewLabel_9);
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
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
		
		lblNewLabel_11 = new JLabel("Account");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_11.setBounds(71, 487, 112, 48);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(acoount.class.getResource("/smallunits/Img/icons8-account-50.png")));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setBounds(20, 487, 46, 48);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setIcon(new ImageIcon(acoount.class.getResource("/smallunits/Img/icons8-shutdown-50.png")));
		lblNewLabel_13.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setBounds(20, 535, 46, 48);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setIcon(new ImageIcon(acoount.class.getResource("/smallunits/Img/icons8-help-50.png")));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setBounds(20, 583, 46, 48);
		panel.add(lblNewLabel_14);
		
		lblNewLabel_16 = new JLabel("Events");
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_16.setBounds(71, 390, 112, 48);
		panel.add(lblNewLabel_16);
		lblNewLabel_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				event ah = null;
				try {
					ah = new event(username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ah.setUndecorated(true);
                ah.setVisible(true);
			}
		});
		
		lblNewLabel_19 = new JLabel("Payment");
		lblNewLabel_19.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_19.setForeground(Color.WHITE);
		lblNewLabel_19.setBounds(71, 439, 112, 48);
		panel.add(lblNewLabel_19);
		lblNewLabel_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				payment ah = null;
				try {
					ah = new payment(username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ah.setUndecorated(true);
                ah.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon(acoount.class.getResource("/smallunits/Img/icons8-events-50(1).png")));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_20.setBounds(20, 390, 46, 48);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon(acoount.class.getResource("/smallunits/Img/icons8-payment-64(1).png")));
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_23.setBounds(20, 439, 46, 48);
		panel.add(lblNewLabel_23);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBounds(430, 11, 150, 48);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setIcon(new ImageIcon(acoount.class.getResource("/smallunits/Img/pool(3).jpg")));
		lblNewLabel_15.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_15);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(203, 164, 292, 242);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		profile = new JLabel("");
		profile.setIcon(new ImageIcon(acoount.class.getResource(Imagepath)));
		profile.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		profile.setHorizontalAlignment(SwingConstants.CENTER);
		profile.setBounds(10, 58, 100, 120);
		panel_1.add(profile);
		
		
		String Name="",Branch="";
		PreparedStatement st;
		
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/poolin","root", "");

        st = (PreparedStatement) connection
            .prepareStatement("Select * from userinfo where username=?");  
        
        
        st.setString(1, username);
        ResultSet rs = st.executeQuery();
        if(rs.next())
        {
        Name=rs.getString("name"); 
        Branch=rs.getString("branch"); 
        }
		
		
		
		
		JLabel lblNewLabel_25 = new JLabel("Name : ");
		lblNewLabel_25.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_25.setBounds(108, 77, 56, 25);
		panel_1.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel(Name);
		lblNewLabel_26.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_26.setBounds(174, 77, 108, 25);
		panel_1.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Branch : ");
		lblNewLabel_27.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_27.setBounds(108, 115, 56, 25);
		panel_1.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel(Branch);
		lblNewLabel_28.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_28.setBounds(174, 114, 108, 27);
		panel_1.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("PRN No : ");
		lblNewLabel_29.setFont(new Font("Cambria Math", Font.PLAIN, 12));
		lblNewLabel_29.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_29.setBounds(107, 151, 57, 25);
		panel_1.add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel(username);
		lblNewLabel_30.setFont(new Font("Cambria Math", Font.PLAIN, 12));
		lblNewLabel_30.setBounds(174, 149, 108, 29);
		panel_1.add(lblNewLabel_30);
		
		edit_profile = new JButton("Edit");
		edit_profile.setFont(new Font("Cambria Math", Font.PLAIN, 11));
		edit_profile.setBorder(null);
		edit_profile.setBounds(249, 11, 33, 23);
		panel_1.add(edit_profile);
		edit_profile.setFocusable(false);
		edit_profile.setBackground(Color.WHITE);
		edit_profile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				edit_profile ah = null;
				try {
					ah = new edit_profile(username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ah.setUndecorated(true);
	            ah.setVisible(true);
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(505, 164, 292, 242);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("COMPLETED..!");
		lblNewLabel_4.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(76, 182, 131, 49);
		panel_2.add(lblNewLabel_4);
		
		fshow = new JButton("Track");
		fshow.setFont(new Font("Cambria Math", Font.PLAIN, 11));
		fshow.setFocusable(false);
		fshow.setBorder(null);
		fshow.setBackground(Color.WHITE);
		fshow.setBounds(231, 208, 51, 23);
		panel_2.add(fshow);
		fshow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				fshow ah = null;
				try {
					ah = new fshow(username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ah.setUndecorated(true);
	            ah.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(acoount.class.getResource("/smallunits/Img/feesclg(1).jpg")));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(31, 11, 214, 160);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_31 = new JLabel("Fees");
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_31.setBounds(115, 217, 46, 14);
		panel_2.add(lblNewLabel_31);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(203, 417, 292, 242);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(Color.WHITE);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_21 = new JLabel("Contribution..!");
		lblNewLabel_21.setForeground(Color.BLACK);
		lblNewLabel_21.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setBounds(82, 187, 123, 28);
		panel_3.add(lblNewLabel_21);
		
		cshow = new JButton("Track");
		cshow.setFont(new Font("Cambria Math", Font.PLAIN, 11));
		cshow.setFocusable(false);
		cshow.setBorder(null);
		cshow.setBackground(Color.WHITE);
		cshow.setBounds(231, 208, 51, 23);
		panel_3.add(cshow);
		cshow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				cshow ah = null;
				try {
					ah = new cshow(username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ah.setUndecorated(true);
	            ah.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon(acoount.class.getResource("/smallunits/Img/contri(1).jpg")));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setBounds(38, 16, 214, 160);
		panel_3.add(lblNewLabel_7_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(505, 417, 292, 242);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_4.setBackground(Color.WHITE);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_17 = new JLabel("Extra-Curriculum");
		lblNewLabel_17.setBackground(Color.WHITE);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setForeground(Color.BLACK);
		lblNewLabel_17.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		lblNewLabel_17.setBounds(63, 179, 148, 40);
		panel_4.add(lblNewLabel_17);
		
		eshow = new JButton("Track");
		eshow.setFont(new Font("Cambria Math", Font.PLAIN, 11));
		eshow.setFocusable(false);
		eshow.setBorder(null);
		eshow.setBackground(Color.WHITE);
		eshow.setBounds(231, 208, 51, 23);
		panel_4.add(eshow);
		eshow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				eshow ah = null;
				try {
					ah = new eshow(username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ah.setUndecorated(true);
	            ah.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_7_1_1 = new JLabel("");
		lblNewLabel_7_1_1.setIcon(new ImageIcon(acoount.class.getResource("/smallunits/Img/icons8-success-100.png")));
		lblNewLabel_7_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_1.setBounds(34, 11, 214, 160);
		panel_4.add(lblNewLabel_7_1_1);
		
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
		
		
	}




}
