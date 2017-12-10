package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Category;
import Model.ShoppingCart;
import Model.User;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	

	/**
	 * Create the frame.
	 */
	public UserMenu(User usr) {
		ShoppingCart shp = new ShoppingCart();
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField.setBounds(127, 72, 280, 61);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String search = textField.getText();
				SearchTable st = new SearchTable(search, shp);
				st.setResizable(false);
				st.setVisible(true);
				st.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBounds(419, 79, 150, 43);
		contentPane.add(btnNewButton);
		
		JTextPane txtpnIngreseElNombre = new JTextPane();
		txtpnIngreseElNombre.setEditable(false);
		txtpnIngreseElNombre.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtpnIngreseElNombre.setText("Ingrese el nombre del articulo a buscar o seleccione una categoria");
		txtpnIngreseElNombre.setBounds(111, 12, 552, 31);
		contentPane.add(txtpnIngreseElNombre);
		
		JTextPane txtpnCategor = new JTextPane();
		txtpnCategor.setFont(new Font("Dialog", Font.PLAIN, 26));
		txtpnCategor.setText("Categorías");
		txtpnCategor.setBounds(306, 165, 156, 38);
		contentPane.add(txtpnCategor);
		
		JTextPane txtpnCelulares = new JTextPane();
		txtpnCelulares.setEditable(false);
		txtpnCelulares.setText("Celulares");
		txtpnCelulares.setBounds(121, 348, 99, 21);
		contentPane.add(txtpnCelulares);
		
		JTextPane txtpnNotebooks = new JTextPane();
		txtpnNotebooks.setText("Notebooks");
		txtpnNotebooks.setEditable(false);
		txtpnNotebooks.setBounds(361, 348, 99, 21);
		contentPane.add(txtpnNotebooks);
		
		JTextPane txtpnTelevisores = new JTextPane();
		txtpnTelevisores.setText("Televisores");
		txtpnTelevisores.setEditable(false);
		txtpnTelevisores.setBounds(564, 348, 99, 21);
		contentPane.add(txtpnTelevisores);
		
		JTextPane txtpnAuriculares = new JTextPane();
		txtpnAuriculares.setText("Auriculares");
		txtpnAuriculares.setEditable(false);
		txtpnAuriculares.setBounds(119, 511, 90, 21);
		contentPane.add(txtpnAuriculares);
		
		JTextPane txtpnTablets = new JTextPane();
		txtpnTablets.setText("Tablets");
		txtpnTablets.setEditable(false);
		txtpnTablets.setBounds(361, 511, 99, 21);
		contentPane.add(txtpnTablets);
		
		JTextPane txtpnCamaras = new JTextPane();
		txtpnCamaras.setText("Cámaras");
		txtpnCamaras.setEditable(false);
		txtpnCamaras.setBounds(569, 511, 99, 21);
		contentPane.add(txtpnCamaras);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/cell-phone-icon-7447.png")).getImage();
		Image img2 = getScaledImage(img, 115, 115);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Category c = new Category("Celulares", "Telefonos moviles", img2);
				ProductTable pt= new ProductTable(c, shp);
				pt.setResizable(false);
				pt.setVisible(true);
				pt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		lblNewLabel.setBounds(94, 221, 115, 115);
		lblNewLabel.setIcon(new ImageIcon(img2));
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/laptop.png")).getImage();
		Image img4 = getScaledImage(img3, 192, 115);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Category c = new Category("Notebooks", "Computadoras portatiles", img4);
				ProductTable pt= new ProductTable(c, shp);
				pt.setVisible(true);
				pt.setResizable(false);
				pt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		label.setBounds(295, 221, 192, 115);
		
		label.setIcon(new ImageIcon(img4));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/tvicon.png")).getImage();
		Image img6 = getScaledImage(img5, 115, 115);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Category c = new Category("Televisores", "LEDS, LCD", img6);
				ProductTable pt= new ProductTable(c, shp);
				pt.setResizable(false);
				pt.setVisible(true);
				pt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		label_1.setBounds(553, 221, 115, 115);
		
		label_1.setIcon(new ImageIcon(img6));
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/headphone-icon.png")).getImage();
		Image img8 = getScaledImage(img7, 115, 115);
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Category c = new Category("Auriculares", "Audiofonos", img8);
				ProductTable pt= new ProductTable(c, shp);
				pt.setResizable(false);
				pt.setVisible(true);
				pt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		label_2.setBounds(94, 384, 115, 115);
		label_2.setIcon(new ImageIcon(img8));
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		Image img9 = new ImageIcon(this.getClass().getResource("/Tablet-512.png")).getImage();
		Image img10 = getScaledImage(img9, 115, 115);
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Category c = new Category("Tablets", "iPads y tablets android", img10);
				ProductTable pt= new ProductTable(c, shp);
				pt.setResizable(false);
				pt.setVisible(true);
				pt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		label_3.setBounds(326, 384, 115, 115);
		label_3.setIcon(new ImageIcon(img10));
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		Image img11 = new ImageIcon(this.getClass().getResource("/camera.png")).getImage();
		Image img12 = getScaledImage(img11, 153, 115);
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Category c = new Category("Camaras", "Camaras profesionales reflex y semireflex", img12);
				ProductTable pt= new ProductTable(c, shp);
				pt.setResizable(false);
				pt.setVisible(true);
				pt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		label_4.setBounds(526, 384, 115, 115);
	
		label_4.setIcon(new ImageIcon(img12));
		contentPane.add(label_4);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				try {
					Window w = new Window();
					w.frame.setResizable(false);
					w.frame.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalir.setBounds(12, 12, 65, 25);
		contentPane.add(btnSalir);
		
		JButton btnCarroDeCompras = new JButton("Carro de compras");
		btnCarroDeCompras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(shp.getProducts().keySet().size() == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "No hay elementos en su carrito" , "Carro vacio", JOptionPane.INFORMATION_MESSAGE);
				}else {
					ShoppingCartFrame shpcart = new ShoppingCartFrame(usr, shp);
					shpcart.setVisible(true);
					shpcart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				
			}
		});
		btnCarroDeCompras.setBackground(UIManager.getColor("Desktop.background"));
		btnCarroDeCompras.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCarroDeCompras.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCarroDeCompras.setBounds(611, 44, 156, 134);
		Image carro = new ImageIcon(this.getClass().getResource("/shopping_cart.png")).getImage();
		carro = getScaledImage(carro, 98, 98);
		btnCarroDeCompras.setIcon(new ImageIcon(carro));
		contentPane.add(btnCarroDeCompras);
		
		JTextPane txtpnUsuario = new JTextPane();
		txtpnUsuario.setEditable(false);
		txtpnUsuario.setText("Usuario: "+usr.getName());
		txtpnUsuario.setBounds(22, 45, 93, 50);
		contentPane.add(txtpnUsuario);
		
		JButton btnNewButton_1 = new JButton("Editar usuario");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 9));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(shp.getProducts().keySet().size() > 0) {
					MessageShpLost msp = new MessageShpLost(usr);
					msp.setVisible(true);
					msp.setResizable(false);
					msp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}else {
					EditUser eu = new EditUser(usr);
					eu.setResizable(false);
					eu.setVisible(true);
					eu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setVisible(false);
				}
				
				
			}
		});
		btnNewButton_1.setBounds(12, 118, 103, 25);
		contentPane.add(btnNewButton_1);
		
	}
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
}
