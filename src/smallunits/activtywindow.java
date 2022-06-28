
package smallunits;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class activtywindow extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					activtywindow frame = new activtywindow();
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
	 */
	public activtywindow() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 750);
		contentPane = new JPanel();
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
				activtywindow.this.setLocation(x-xx,y-xy);
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(376, 41, 375, 750);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setIcon(new ImageIcon(loginUI.class.getResource("/smallunits/images/light.jpg")));
		lblNewLabel_2.setBounds(0, 0, 375, 446);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fill in ,And Get Help...");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(152, 554, 165, 42);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Caught Up With SignUp..!");
		lblNewLabel_4.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(84, 518, 209, 42);
		panel.add(lblNewLabel_4);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.setBounds(715, 11, 19, 33);
		contentPane.add(lbl_close);
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lbl_close.setFont(new Font("Arial", Font.PLAIN, 18));
		lbl_close.setHorizontalTextPosition(SwingConstants.RIGHT);
		lbl_close.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_close.setForeground(new Color(255, 0, 0));
		lbl_close.setBackground(new Color(255, 255, 255));
		
		JLabel lbl_log = new JLabel("Back");
		lbl_log.setHorizontalTextPosition(SwingConstants.RIGHT);
		lbl_log.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_log.setForeground(Color.BLACK);
		lbl_log.setFont(new Font("Arial", Font.PLAIN, 18));
		lbl_log.setBackground(Color.WHITE);
		lbl_log.setBounds(640, 11, 65, 33);
		contentPane.add(lbl_log);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(-13, 41, 764, 1);
		contentPane.add(panel_2);
		
		JLabel lblPrnNumber = new JLabel("PRN Number");
		lblPrnNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrnNumber.setBounds(48, 185, 95, 42);
		contentPane.add(lblPrnNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBounds(48, 238, 266, 42);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Branch(Course)");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(51, 291, 125, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnSumit = new JButton("Sumit");
		btnSumit.setForeground(Color.WHITE);
		btnSumit.setFont(new Font("Arial", Font.PLAIN, 17));
		btnSumit.setBackground(Color.RED);
		btnSumit.setBounds(48, 427, 266, 42);
		contentPane.add(btnSumit);
        
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(48, 334, 266, 42);
		comboBox.addItem("");
		comboBox.addItem("BCA");
		comboBox.addItem("BBA");
		comboBox.addItem("MBA");
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(84, 21, 150, 48);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(activtywindow.class.getResource("/smallunits/Img/pool(3).jpg")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_log.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				loginUI ah = new loginUI();
				ah.setUndecorated(true);
                ah.setVisible(true);
			}
		});
		
		
		btnSumit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = (String) comboBox.getSelectedItem();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/poolin","root", "");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select * from fpassword where username=? and course=?");  
                    
                    
                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        //dispose();
                        /*UHome ah = new UHome(userName);
                        ah.setTitle("Welcome");
                        ah.setVisible(true); */
                    	String  c=rs.getString("coordinator"), h=rs.getString("Hod"); 
                    	long cp=rs.getLong("Ph No1"), ch=rs.getLong("phno2");
                        //JOptionPane.showMessageDialog(btnSumit, "\n\nCoordinator: "+c+"\tPhone Number: "+cp+"\nHod: "+h+"\tPhone Number: "+ch);
                    	detailbar ah = new detailbar(c,cp,h,ch);
                        ah.setUndecorated(true);
                        ah.setVisible(true);	
                    	
                    } else {
                        JOptionPane.showMessageDialog(btnSumit, "Please enter valid details..!");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });
	}
}
