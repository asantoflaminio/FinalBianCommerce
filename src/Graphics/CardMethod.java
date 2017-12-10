package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Product;
import Model.ShoppingCart;
import Model.User;

import javax.swing.UIManager;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class CardMethod extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


	/**
	 * Create the frame.
	 */
	public CardMethod(User u, ShoppingCart cart) {
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		double subtotal = 0;
		for(Product p: cart.getProducts().keySet()) {
			subtotal = subtotal + p.getPrice()*cart.getProducts().get(p);
		}
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShoppingCartFrame shp = new ShoppingCartFrame(u, cart);
				setVisible(false);
				dispose();
				shp.setVisible(true);
				shp.setResizable(false);
				shp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVolver.setBounds(12, 12, 114, 25);
		contentPane.add(btnVolver);
		
		JRadioButton radioButton = new JRadioButton("Envío a domicilio ");
		radioButton.setFont(new Font("Dialog", Font.BOLD, 14));
		radioButton.setBackground(Color.WHITE);
		radioButton.setBounds(24, 223, 219, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Retiro en nuestro local");
		radioButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(304, 223, 238, 23);
		contentPane.add(radioButton_1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("Se enviará a: " + u.getCalle() + " " + u.getAltura() + ", " + u.getLocalidad() + ", " + u.getProvincia() 
		+ ", " + u.getPais()+ " CP: " + u.getCp() +  ".");
		textPane.setBounds(34, 243, 255, 51);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setText("Total: $" + subtotal);
		textPane_1.setForeground(Color.RED);
		textPane_1.setFont(new Font("Dialog", Font.PLAIN, 23));
		textPane_1.setBounds(44, 314, 199, 28);
		contentPane.add(textPane_1);
		
		
	
		
		textField = new JTextField();
		textField.setBounds(24, 72, 313, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(424, 72, 133, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(24, 149, 133, 25);
		contentPane.add(textField_2);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/expiry.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(175, 114, 107, 60);
		contentPane.add(label);
		
		JTextPane txtpnNumeroDeTarjeta = new JTextPane();
		txtpnNumeroDeTarjeta.setEditable(false);
		txtpnNumeroDeTarjeta.setText("Numero de tarjeta (sin espacios)");
		txtpnNumeroDeTarjeta.setBounds(24, 49, 265, 21);
		contentPane.add(txtpnNumeroDeTarjeta);
		
		JTextPane txtpnCodigoDeSeguridad = new JTextPane();
		txtpnCodigoDeSeguridad.setEditable(false);
		txtpnCodigoDeSeguridad.setText("Codigo de seguridad");
		txtpnCodigoDeSeguridad.setBounds(24, 126, 265, 21);
		contentPane.add(txtpnCodigoDeSeguridad);
		
		JTextPane txtpnVencimiento = new JTextPane();
		txtpnVencimiento.setEditable(false);
		txtpnVencimiento.setText("Vencimiento (MM/YY)");
		txtpnVencimiento.setBounds(412, 49, 176, 21);
		contentPane.add(txtpnVencimiento);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(304, 152, 284, 25);
		contentPane.add(textField_3);
		
		JTextPane txtpnNombreDelTitular = new JTextPane();
		txtpnNombreDelTitular.setEditable(false);
		txtpnNombreDelTitular.setText("Nombre del titular");
		txtpnNombreDelTitular.setBounds(307, 128, 265, 21);
		contentPane.add(txtpnNombreDelTitular);
		
		JRadioButton rdbtnVisa = new JRadioButton("VISA");
		rdbtnVisa.setBackground(UIManager.getColor("Desktop.background"));
		rdbtnVisa.setBounds(174, 8, 56, 23);
		contentPane.add(rdbtnVisa);
		
		JRadioButton rdbtnMastercard = new JRadioButton("MASTERCARD");
		rdbtnMastercard.setBackground(Color.WHITE);
		rdbtnMastercard.setBounds(258, 8, 133, 23);
		contentPane.add(rdbtnMastercard);
		
		JRadioButton rdbtnAmericanExpress = new JRadioButton("AMERICAN EXPRESS");
		rdbtnAmericanExpress.setBackground(Color.WHITE);
		rdbtnAmericanExpress.setBounds(395, 8, 162, 23);
		contentPane.add(rdbtnAmericanExpress);
		
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rdbtnVisa);
		group2.add(rdbtnMastercard);
		group2.add(rdbtnAmericanExpress);
		
		JButton button = new JButton("Confirmar compra");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(group2.getSelection() == null) {
					JOptionPane.showMessageDialog(new JFrame(), "Seleccione tipo de tarjeta", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(group.getSelection() == null) {
					JOptionPane.showMessageDialog(new JFrame(), "Seleccione tipo de envío", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					String cardNumber = textField.getText();
					String expiry = textField_1.getText();
					String securityCode = textField_2.getText();
					String personName = textField_3.getText();
					String cardType = "tarjeta";
					String last4 = cardNumber.substring(cardNumber.length() - 4);
					
					if (rdbtnVisa.isSelected() == true) cardType = "VISA";
					 if (rdbtnMastercard.isSelected() == true) cardType = "MASTERCARD";
					 if (rdbtnAmericanExpress.isSelected() == true) cardType = "AMEX";
					    
					if(!cardNumber.matches("[0-9]{13,16}")) {
						JOptionPane.showMessageDialog(new JFrame(), "Numero de tarjeta invalido", "Error", JOptionPane.ERROR_MESSAGE);
					}else if(!expiry.matches("[0-9]{2}/[0-9]{2}") ) {
						JOptionPane.showMessageDialog(new JFrame(), "Fecha invalida", "Error", JOptionPane.ERROR_MESSAGE);
					}else if(!securityCode.matches("[0-9]{3}")) {
						JOptionPane.showMessageDialog(new JFrame(), "Codigo de seguridad invalido", "Error", JOptionPane.ERROR_MESSAGE);
					}else if(!personName.matches("[a-zA-Z ]+")) {
						JOptionPane.showMessageDialog(new JFrame(), "Error en el nombre del titular", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						
						try {
							Window.writeProducts();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
						JOptionPane.showMessageDialog(new JFrame(), "Abonado con " + cardType + " terminada en " + last4 + ". Comprobante de pago enviado a " + u.getMail() , "Gracias por su compra", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
						
					}
				}
				
				
				
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 22));
		button.setBounds(107, 354, 400, 97);
		contentPane.add(button);
	}
}
