package smallunits;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class cshow extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	private JTextField bookn;
	private JTextField sb;
	private JTextField notesn;
	private JTextField sn;
	private JButton btnNewButton;
	private JTextField bb;
	private JTextField bn;
	private JTextField semib;
	private JTextField semn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cshow frame = new cshow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	
	public cshow()
	{
		
	}
	
	
	public cshow(String username) throws IOException, SQLException {
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
				cshow.this.setLocation(x-xx,y-xy);
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
		lblNewLabel_9.setBounds(836, 11, 24, 37);
		contentPane.add(lblNewLabel_9);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(51, 105, 773, 267);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOOKS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 55, 22);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("Book Name :");
		lblNewLabel_2.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(20, 44, 108, 27);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Subject Name:");
		lblNewLabel_3.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(20, 82, 108, 27);
		panel.add(lblNewLabel_3);
		
		bookn = new JTextField();
		bookn.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		bookn.setBounds(137, 46, 192, 20);
		panel.add(bookn);
		bookn.setColumns(10);
		
		sb = new JTextField();
		sb.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		sb.setText("");
		sb.setBounds(138, 84, 191, 20);
		panel.add(sb);
		sb.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(cshow.class.getResource("/smallunits/Img/bookm.png")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(30, 120, 66, 100);
		panel.add(lblNewLabel_4);
		
		btnNewButton = new JButton("Add Pic");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setBounds(20, 222, 89, 23);
		panel.add(btnNewButton);
		
		JButton bookadd = new JButton("Contribute");
		bookadd.setFocusable(false);
		bookadd.setBackground(Color.RED);
		bookadd.setForeground(Color.WHITE);
		bookadd.setBounds(137, 177, 127, 23);
		panel.add(bookadd);
		bookadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String Branchb=bb.getText();
				String bname=bookn.getText();
				String semb=semib.getText();
				String subb=sb.getText();
				
                int x=0;
                String query="";
                
				
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poolin", "root", "");
                    
                    //-----------------semi book db----------------
                    
                    query="INSERT INTO `semib`(`semester`, `book_name`, `branch`) VALUES ('"+semb+"','"+bname+"','"+Branchb+"')";


                    Statement sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    

                   
                    
                  //-----------------Subject book db----------------------------
                    
                    query="INSERT INTO `subb`(`subject`, `book_name`, `branch`) VALUES ('"+subb+"','"+bname+"','"+Branchb+"')";
                    
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                  
                    
                    if (x == 0) {
                        JOptionPane.showMessageDialog(bookadd, "This is alredy exist");
                    } 
                   
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
				
			}});
		
		JLabel lblNewLabel_6 = new JLabel("Branch :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(361, 44, 89, 33);
		panel.add(lblNewLabel_6);
		
		bb = new JTextField();
		bb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bb.setBounds(460, 46, 169, 31);
		panel.add(bb);
		bb.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Semester :");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(361, 87, 89, 35);
		panel.add(lblNewLabel_7);
		
		semib = new JTextField();
		semib.setFont(new Font("Tahoma", Font.PLAIN, 15));
		semib.setBounds(460, 89, 169, 33);
		panel.add(semib);
		semib.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(51, 383, 773, 267);
		contentPane.add(panel_1);
		
		JLabel lblNotes = new JLabel("NOTES");
		lblNotes.setForeground(Color.WHITE);
		lblNotes.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		lblNotes.setBounds(10, 11, 55, 22);
		panel_1.add(lblNotes);
		
		JLabel lblNewLabel_2_1 = new JLabel("Notes Name :");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(20, 44, 108, 27);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Subject Name:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(20, 82, 108, 27);
		panel_1.add(lblNewLabel_3_1);
		
		notesn = new JTextField();
		notesn.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		notesn.setColumns(10);
		notesn.setBounds(137, 46, 192, 20);
		panel_1.add(notesn);
		
		sn = new JTextField();
		sn.setText("");
		sn.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		sn.setColumns(10);
		sn.setBounds(138, 84, 191, 20);
		panel_1.add(sn);
		
		JButton btnNewButton_2 = new JButton("Add Pic");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setBounds(20, 222, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(cshow.class.getResource("/smallunits/Img/notesm.png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(30, 120, 66, 102);
		panel_1.add(lblNewLabel_5);
		
		JButton notesadd = new JButton("Contribute");
		notesadd.setFocusable(false);
		notesadd.setForeground(Color.WHITE);
		notesadd.setBackground(Color.RED);
		notesadd.setBounds(137, 183, 128, 23);
		panel_1.add(notesadd);
		notesadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String Branchb=bn.getText();
				String bname=notesn.getText();
				String semb=semn.getText();
				String subb=sn.getText();
				
                int x=0;
                String query="";
                
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poolin", "root", "");
                    

                    //-----------------semi notes db----------------------------
                    
                    query="INSERT INTO `semin`(`semester`, `notes_name`, `branch`) VALUES ('"+semb+"','"+bname+"','"+Branchb+"')";


                    Statement sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                 
                    
                  //-----------------Subject Notes db----------------------------
                    
                    query="INSERT INTO `subn`(`subject`, `notes_name`, `branch`) VALUES ('"+subb+"','"+bname+"','"+Branchb+"')";
                    
                    sta = connection.createStatement();
                    x = sta.executeUpdate(query);
                    
                  
                    
                    if (x == 0) {
                        JOptionPane.showMessageDialog(notesadd, "This is alredy exist");
                    } 
                   
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
				
			}});
		
		JLabel lblNewLabel_6_1 = new JLabel("Branch :");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1.setBounds(373, 44, 89, 33);
		panel_1.add(lblNewLabel_6_1);
		
		bn = new JTextField();
		bn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bn.setColumns(10);
		bn.setBounds(472, 46, 169, 31);
		panel_1.add(bn);
		
		JLabel lblNewLabel_7_1 = new JLabel("Semester :");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1.setBounds(373, 88, 89, 35);
		panel_1.add(lblNewLabel_7_1);
		
		semn = new JTextField();
		semn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		semn.setColumns(10);
		semn.setBounds(472, 90, 169, 33);
		panel_1.add(semn);
		
		JLabel lblNewLabel_1 = new JLabel(" Thank You For Contributions..!!");
		lblNewLabel_1.setIcon(new ImageIcon(cshow.class.getResource("/smallunits/Img/login.png")));
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 19));
		lblNewLabel_1.setBounds(51, 47, 773, 47);
		contentPane.add(lblNewLabel_1);
	}
}
