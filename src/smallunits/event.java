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

public class event extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	private JTable table;
	private JButton sevent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					event frame = new event();
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
	event()
	{
		
	}
	
	
	public event(String username) throws IOException {
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
				event.this.setLocation(x-xx,y-xy);
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
		lblNewLabel.setIcon(new ImageIcon(notes.class.getResource("/smallunits/you.jpg")));
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
		lblNewLabel_2.setIcon(new ImageIcon(notes.class.getResource("/smallunits/Img/icons8-dashboard-50.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(20, 245, 46, 48);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Notes");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(71, 294, 112, 48);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
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
		
		JLabel lblNewLabel_5 = new JLabel("Books");
		lblNewLabel_5.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(71, 342, 112, 48);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
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
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setIcon(new ImageIcon(notes.class.getResource("/smallunits/Img/icons8-read-50.png")));
		lblNewLabel_6.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(20, 294, 46, 48);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(notes.class.getResource("/smallunits/Img/icons8-magazine-50.png")));
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
		lblNewLabel_12.setIcon(new ImageIcon(notes.class.getResource("/smallunits/Img/icons8-account-50.png")));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setBounds(20, 487, 46, 48);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setIcon(new ImageIcon(notes.class.getResource("/smallunits/Img/icons8-shutdown-50.png")));
		lblNewLabel_13.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setBounds(20, 535, 46, 48);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setIcon(new ImageIcon(notes.class.getResource("/smallunits/Img/icons8-help-50.png")));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setBounds(20, 583, 46, 48);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_16 = new JLabel("Events");
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		lblNewLabel_16.setBounds(71, 390, 112, 48);
		panel.add(lblNewLabel_16);
		
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
		lblNewLabel_20.setIcon(new ImageIcon(notes.class.getResource("/smallunits/Img/icons8-events-50(1).png")));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_20.setBounds(20, 390, 46, 48);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon(notes.class.getResource("/smallunits/Img/icons8-payment-64(1).png")));
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_23.setBounds(20, 439, 46, 48);
		panel.add(lblNewLabel_23);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBounds(430, 11, 150, 48);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setIcon(new ImageIcon(notes.class.getResource("/smallunits/Img/pool(3).jpg")));
		lblNewLabel_15.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_15);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setLayout(null);
		panel_1_5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1_5.setBackground(Color.DARK_GRAY);
		panel_1_5.setBounds(203, 283, 569, 242);
		contentPane.add(panel_1_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 11, 274, 220);
		panel_1_5.add(panel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Events Updates");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Cambria Math", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(32, 78, 215, 68);
		panel_1.add(lblNewLabel_4);
		
		sevent = new JButton("Show Events");
		sevent.setFocusable(false);
		sevent.setForeground(Color.RED);
		sevent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sevent.setBounds(345, 95, 145, 36);
		panel_1_5.add(sevent);
		sevent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				eventshow ah = null;
				try {
					ah = new eventshow(username);
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
		
		
		
	}

}
