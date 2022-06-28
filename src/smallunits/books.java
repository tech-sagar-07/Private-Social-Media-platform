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
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class books extends JFrame implements ActionListener {

	private JPanel contentPane;
	int xx,xy;
	private JTable table;
	private String Imagepath="/smallunits/Img/new member.png";
	private File file;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					books frame = new books();
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
		System.out.println(Imagepath);
		
	}

	books()
	{
		
	}
	
	
	public books(String username) throws IOException {
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
				books.this.setLocation(x-xx,y-xy);
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
		lblNewLabel.setIcon(new ImageIcon(books.class.getResource("/smallunits/you.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 229, 224);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dashboard");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(71, 246, 112, 48);
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
		lblNewLabel_2.setIcon(new ImageIcon(books.class.getResource("/smallunits/Img/icons8-dashboard-50.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(20, 246, 46, 48);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Books");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(71, 295, 112, 48);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Notes");
		lblNewLabel_5.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(71, 343, 112, 48);
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
		lblNewLabel_6.setIcon(new ImageIcon(books.class.getResource("/smallunits/Img/icons8-read-50.png")));
		lblNewLabel_6.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(20, 295, 46, 48);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(books.class.getResource("/smallunits/Img/icons8-magazine-50.png")));
		lblNewLabel_8.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(20, 343, 46, 48);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Logout");
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
		
		JLabel lblNewLabel_11 = new JLabel("Account");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_11.setBounds(71, 487, 112, 48);
		panel.add(lblNewLabel_11);
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
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
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(books.class.getResource("/smallunits/Img/icons8-account-50.png")));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setBounds(20, 487, 46, 48);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setIcon(new ImageIcon(books.class.getResource("/smallunits/Img/icons8-shutdown-50.png")));
		lblNewLabel_13.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setBounds(20, 535, 46, 48);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setIcon(new ImageIcon(books.class.getResource("/smallunits/Img/icons8-help-50.png")));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setBounds(20, 583, 46, 48);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_16 = new JLabel("Events");
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_16.setBounds(71, 391, 112, 48);
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
		
		
		
		JLabel lblNewLabel_19 = new JLabel("Payment");
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
		lblNewLabel_20.setIcon(new ImageIcon(books.class.getResource("/smallunits/Img/icons8-events-50(1).png")));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_20.setBounds(20, 391, 46, 48);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon(books.class.getResource("/smallunits/Img/icons8-payment-64(1).png")));
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_23.setBounds(20, 439, 46, 48);
		panel.add(lblNewLabel_23);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBounds(430, 11, 150, 48);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setIcon(new ImageIcon(books.class.getResource("/smallunits/Img/pool(3).jpg")));
		lblNewLabel_15.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_15);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setLayout(null);
		panel_1_5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1_5.setBackground(Color.DARK_GRAY);
		panel_1_5.setBounds(203, 222, 569, 242);
		contentPane.add(panel_1_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 11, 271, 220);
		panel_1_5.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Semester Wise");
		lblNewLabel_4.setBounds(53, 158, 141, 51);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(books.class.getResource("/smallunits/Img/{85E28809-6CF1-4572-A6A5-D68FCCD.jpg")));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(33, 22, 189, 125);
		panel_1.add(lblNewLabel_7);
		
		btnNewButton = new JButton("View");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				semib ah = null;
				try {
					ah = new semib(username);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ah.setUndecorated(true);
                ah.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(355, 114, 150, 42);
		panel_1_5.add(btnNewButton);
		
		JPanel panel_1_5_1 = new JPanel();
		panel_1_5_1.setLayout(null);
		panel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1_5_1.setBackground(Color.DARK_GRAY);
		panel_1_5_1.setBounds(203, 474, 569, 242);
		contentPane.add(panel_1_5_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(280, 11, 279, 220);
		panel_1_5_1.add(panel_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Subject Wise");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.RED);
		lblNewLabel_4_1.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_4_1.setBounds(67, 147, 141, 51);
		panel_1_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon(books.class.getResource("/smallunits/Img/topic-selection-person-in-charge(1).png")));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setBounds(47, 11, 189, 125);
		panel_1_1.add(lblNewLabel_7_1);
		
		btnNewButton_1 = new JButton("View");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				subb ah = null;
				try {
					ah = new subb(username);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ah.setUndecorated(true);
                ah.setVisible(true);
				
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(63, 97, 150, 42);
		panel_1_5_1.add(btnNewButton_1);
		
		System.out.println(Imagepath);
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
