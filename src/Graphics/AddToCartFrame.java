package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Product;
import Model.ShoppingCart;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddToCartFrame extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public AddToCartFrame(Product p, ShoppingCart shp) {
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgregarAlCarrito = new JButton("Agregar al carrito");
		btnAgregarAlCarrito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				shp.add(p);
				JOptionPane.showMessageDialog(new JFrame(), "Articulo agregado", "Agregado", JOptionPane.PLAIN_MESSAGE);
				setVisible(false);
				dispose();
			}
		});
		btnAgregarAlCarrito.setBounds(99, 226, 236, 25);
		contentPane.add(btnAgregarAlCarrito);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(249, 36, 156, 125);
		if(this.getClass().getResource(p.getPhotoPath()) == null) {
			Image img = new ImageIcon(this.getClass().getResource("/noimage.jpeg")).getImage();
			lblNewLabel.setIcon(new ImageIcon(img));
		}else {
			Image img = new ImageIcon(this.getClass().getResource(p.getPhotoPath())).getImage();
			lblNewLabel.setIcon(new ImageIcon(img));
		}
		
		contentPane.add(lblNewLabel);
		
		JTextPane txtpnH = new JTextPane();
		txtpnH.setEditable(false);
		txtpnH.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtpnH.setText(p.getName() + " " + p.getDescription());
		txtpnH.setBounds(30, 47, 212, 63);
		contentPane.add(txtpnH);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Dialog", Font.BOLD, 14));
		textPane.setText("$" + p.getPrice());
		textPane.setBounds(69, 138, 117, 37);
		contentPane.add(textPane);
	}
}
