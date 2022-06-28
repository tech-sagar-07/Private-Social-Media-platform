package smallunits;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class edit_profile extends JFrame implements ActionListener {

	private JPanel contentPane;
	int xx,xy;
	private JLabel filesizenote;
	private JLabel filesize;
	private JLabel filename;
	private File file ;
	private String imagepath = "/smallunits/Img/new member.png" ;
	private JLabel profile;
	private JButton upload;
	private JButton Update;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_profile frame = new edit_profile();
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
	edit_profile()
	{
		
	}
	
	
	public edit_profile(String username) throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 250);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
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
				edit_profile.this.setLocation(x-xx,y-xy);
			}
		});
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_9 = new JLabel("X");
		lblNewLabel_9.setBounds(308, 17, 24, 37);
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
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_1 = new JLabel("Upload Profile");
		lblNewLabel_1.setBounds(10, 11, 160, 47);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon(edit_profile.class.getResource("/smallunits/Img/login.png")));
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 19));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(51, 233, 144, 47);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2);
		
		profile = new JLabel("");
		profile.setBounds(51, 69, 85, 128);
		profile.setIcon(new ImageIcon(edit_profile.class.getResource(imagepath)));
		profile.setBorder(new LineBorder(new Color(0, 0, 0)));
		profile.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(profile);
		
		filesizenote = new JLabel("Image size  <  1024 KB");
		filesizenote.setBounds(156, 96, 174, 32);
		filesizenote.setForeground(Color.WHITE);
		filesizenote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(filesizenote);

		filesize = new JLabel("");
		filesize.setBounds(97, 259, 169, 32);
		filesize.setForeground(Color.WHITE);
		filesize.setToolTipText("Image Size");
		filesize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(filesize);

		filename = new JLabel("No file choosen");
		filename.setBounds(51, 207, 194, 32);
		filename.setForeground(Color.WHITE);
		filename.setToolTipText("File Name");
		filename.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(filename);
		
		upload = new JButton("Upload");
		upload.setFocusable(false);
		upload.setForeground(Color.WHITE);
		upload.setBackground(Color.DARK_GRAY);
		upload.setBounds(156, 139, 89, 23);
		upload.addActionListener(this);
		contentPane.add(upload);
		
		Update = new JButton("Update");
		Update.addActionListener(this);
		Update.setForeground(Color.WHITE);
		Update.setBackground(Color.RED);
		Update.setBounds(187, 199, 89, 23);
		contentPane.add(Update);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == upload)
		{

			FileDialog fd = new FileDialog(this, "Choose a Profile pic", FileDialog.LOAD);
			fd.setDirectory(".\\Students Profile pic");
			fd.setFile("*.jpeg;*.jpg;*.png;*.tiff;*.tif;*.gif;");
			fd.setLocationRelativeTo(null);
			fd.setVisible(true);
			String strfilename = fd.getFile();
			imagepath = fd.getDirectory() + strfilename;
		

			if(fd.getFile()!=null) 
			{
				file = new File(imagepath);
				long bytes = file.length();
				if (bytes < 1048576) {

					try 
					{
						filesize.setText(bytes / 1024 + " KB");
						filesizenote.setForeground(new Color(46, 139, 27));
						filesizenote.setText("Image size < 1024 KB");
						Image image = ImageIO.read(file).getScaledInstance(100, 120, Image.SCALE_SMOOTH);
						profile.setIcon(new ImageIcon(image));
						filename.setText(file.getName());	
					} 
					catch (IOException ex) {
						file = null;
						filename.setText("No file Choosen");
						filesize.setText("");
						filesizenote.setForeground(Color.red);
						filesizenote.setText("Image Not supported");
						ex.printStackTrace();
					}
				} 
				else {
					file = null;
					filename.setText("No File Choosen");
					filesize.setText("");
					filesizenote.setForeground(Color.red);
					filesizenote.setText("Image size is greater than 1 MB");
				}
			}
		}
		
		if(e.getSource()== Update)
		{
			dispose();
			try {
				new acoount(imagepath);
			} catch (IOException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
