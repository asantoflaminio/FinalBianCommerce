package Graphics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import Model.Product;
import Model.User;

import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JPanel;
import java.awt.Label;

public class Window {

	public JFrame frame;
	private JTextField txtElectroStore;
	private JPasswordField passwordField;
	private JTextField txtHoagegee;
	public static HashSet<User> users;
	public static HashSet<Product> products;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Window() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBackground(UIManager.getColor("Desktop.background"));
		frame.getContentPane().setBackground(UIManager.getColor("Desktop.background"));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JTextPane txtpnUsuario = new JTextPane();
		txtpnUsuario.setEditable(false);
		txtpnUsuario.setFont(new Font("Carlito", Font.BOLD, 18));
		txtpnUsuario.setBackground(UIManager.getColor("Desktop.background"));
		txtpnUsuario.setText("Correo");
		txtpnUsuario.setBounds(122, 98, 172, 21);
		frame.getContentPane().add(txtpnUsuario);
		
		
		JTextPane txtpnContrase = new JTextPane();
		txtpnContrase.setEditable(false);
		txtpnContrase.setText("Contraseña");
		txtpnContrase.setFont(new Font("Carlito", Font.BOLD, 18));
		txtpnContrase.setBackground(UIManager.getColor("Desktop.background"));
		txtpnContrase.setBounds(122, 234, 172, 21);
		frame.getContentPane().add(txtpnContrase);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(122, 267, 252, 33);
		frame.getContentPane().add(passwordField);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(122, 131, 252, 33);
		frame.getContentPane().add(formattedTextField);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				boolean found = false;
				for(User u: users) {
					if(u.getMail().equals(formattedTextField.getText())) {
						found = true;
						String passText = new String(passwordField.getPassword());
						if(u.getPassword().equals(passText)) {
							JFrame frameUserMenu = new UserMenu(u);
							frameUserMenu.setResizable(false);
							frameUserMenu.setVisible(true);
							frame.setVisible(false);
							frameUserMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
						}else {
							JOptionPane.showMessageDialog(new JFrame(), "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				if(found == false) {
					JOptionPane.showMessageDialog(new JFrame(), "No existe un usuario con ese correo", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Carlito", Font.BOLD, 18));
		btnNewButton.setBounds(494, 223, 166, 86);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane txtpnEcommercePlatformBy = new JTextPane();
		txtpnEcommercePlatformBy.setBackground(UIManager.getColor("Desktop.background"));
		txtpnEcommercePlatformBy.setEditable(false);
		txtpnEcommercePlatformBy.setText("e-Commerce Platform by");
		txtpnEcommercePlatformBy.setBounds(12, 415, 257, 33);
		frame.getContentPane().add(txtpnEcommercePlatformBy);
		
		JTextPane txtpnNoEsUsuario = new JTextPane();
		txtpnNoEsUsuario.setFont(new Font("Carlito", Font.BOLD, 16));
		txtpnNoEsUsuario.setBackground(UIManager.getColor("Desktop.background"));
		txtpnNoEsUsuario.setText("¿No es usuario?");
		txtpnNoEsUsuario.setBounds(498, 337, 134, 21);
		frame.getContentPane().add(txtpnNoEsUsuario);
		
		
		
		JTextPane txtpnElectroStore = new JTextPane();
		txtpnElectroStore.setEditable(false);
		txtpnElectroStore.setBackground(UIManager.getColor("Desktop.background"));
		txtpnElectroStore.setFont(new Font("Carlito", Font.BOLD, 34));
		txtpnElectroStore.setText("ELECTRO STORE");
		txtpnElectroStore.setBounds(286, 12, 269, 48);
		frame.getContentPane().add(txtpnElectroStore);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/BianCommerce1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(22, 437, 269, 114);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(22, 443, 257, 108);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		
		txtElectroStore = new JTextField();
		txtElectroStore.setText("ELECTRO STORE");
		txtElectroStore.setColumns(10);
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//frame.setVisible(false);
				CreateUser cu = new CreateUser();
				cu.setResizable(false);
				cu.setBounds(100, 100, 800, 600);
				cu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				cu.getContentPane().setLayout(null);
				cu.setVisible(true);
				
			}
		});
		btnCrearCuenta.setBounds(492, 370, 172, 25);
		frame.getContentPane().add(btnCrearCuenta);
		
		JButton btnAltaDeAdmin = new JButton("Acceso Admin");
		btnAltaDeAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame framePass = new AdminPassword();
				framePass.setVisible(true);
				framePass.setResizable(false);
				framePass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
			}
		});
		btnAltaDeAdmin.setBounds(639, 526, 149, 25);
		frame.getContentPane().add(btnAltaDeAdmin);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(602, 0, 186, 107);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(496, 56, 231, 134);
		frame.getContentPane().add(lblNewLabel_3);
		Image img2 = new ImageIcon(this.getClass().getResource("/tv2.jpg")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img2));
		
	
		
		String strLine;
		users = new HashSet<User>(); 
		products = new HashSet<Product>(); 

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("users.txt")));
		
			while ((strLine = br.readLine()) != null) {
				String[] str = strLine.split("#");
				if (str.length == 11) {
					User u = new User(str[0],str[1], Integer.parseInt(str[2]), str[3], str[4], str[5], str[6], str[7], str[8], Integer.parseInt(str[9]), Integer.parseInt(str[10]));
					users.add(u);
				}
			}
			
		String strLine2;
		BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("products.txt")));
			
			while ((strLine2 = br2.readLine()) != null) {
				String[] str = strLine2.split("#");
				if (str.length == 6) {
					Product p = new Product(str[0],str[1], str[2], Double.parseDouble(str[3]) ,Integer.parseInt( str[4]), str[5]);
					products.add(p);
				}
			}
		
		
		
		
		
		
		
		
	
	}
	
	/**
	 * Antes de llamar a addUser se hacen los chequeos.
	 * @param name
	 * @param mail
	 * @param dni
	 * @param phone
	 * @param password
	 * @param pais
	 * @param provincia
	 * @param localidad
	 * @param calle
	 * @param altura
	 * @param cp
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public static void addUser(String name, String mail, String dni, String phone, String password, String pais,
			String provincia, String localidad, String calle, String altura, String cp) throws FileNotFoundException, UnsupportedEncodingException {
		User u = new User(name, mail, Integer.parseInt(dni), phone, password, pais, provincia, localidad, calle, Integer.parseInt(altura), Integer.parseInt(cp));
		users.add(u);
		writeUsers();
		
		
	}

	public static void writeUsers() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("users.txt", "UTF-8");
			for(User e: users) {
				writer.println(e.getName()+ "#" + e.getMail() + "#" + e.getDni() + "#" + e.getCellphone() + "#" + e.getPassword() + "#" + e.getPais() + "#" + e.getProvincia() + "#" +
			e.getLocalidad() + "#" + e.getCalle() + "#" + e.getAltura() + "#" + e.getCp());
			}
			writer.close();
			
	}

	public static FileInputStream checkFile(String file) {
		String PATTERN_FILE = "^[a-zA-Z0-9]+.txt$";
		Pattern pattern = Pattern.compile(PATTERN_FILE);

		Matcher matcher = pattern.matcher(file);
		if (matcher.matches()) {
			FileInputStream fstream;
			try {
				fstream = new FileInputStream(file);
				return fstream;
			} catch (FileNotFoundException e) {
				System.out.println("The file does not exist");
			}

		}

		return null;

	}

	public static void addProduct(Product p) throws FileNotFoundException, UnsupportedEncodingException {
		products.add(p);
		writeProducts();
		
	}

	public static void writeProducts() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("products.txt", "UTF-8");
		for(Product p: products) {
			writer.println(p.getName()+ "#" + p.getDescription() + "#" + p.getPhotoPath() + "#" + p.getPrice() + "#" + p.getStock() + "#" + p.getCategory());
		}
		writer.close();
		
	}
}
