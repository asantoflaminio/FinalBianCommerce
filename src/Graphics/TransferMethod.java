package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Product;
import Model.ShoppingCart;
import Model.User;

import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class TransferMethod extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public TransferMethod(User u, ShoppingCart cart) {
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Envío a domicilio ");
		rdbtnNewRadioButton.setFont(new Font("Dialog", Font.BOLD, 14));
		rdbtnNewRadioButton.setBackground(UIManager.getColor("Desktop.background"));
		rdbtnNewRadioButton.setBounds(114, 61, 219, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Retiro en nuestro local");
		rdbtnNewRadioButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
		rdbtnNewRadioButton_1.setBackground(UIManager.getColor("Desktop.background"));
		rdbtnNewRadioButton_1.setBounds(114, 169, 238, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton);
		
		JTextPane txtpnSeleccioneUnaOpcion = new JTextPane();
		txtpnSeleccioneUnaOpcion.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtpnSeleccioneUnaOpcion.setEditable(false);
		txtpnSeleccioneUnaOpcion.setText("Seleccione una opcion");
		txtpnSeleccioneUnaOpcion.setBounds(12, 32, 200, 21);
		contentPane.add(txtpnSeleccioneUnaOpcion);
		
		double subtotal = 0;
		for(Product p: cart.getProducts().keySet()) {
			subtotal = subtotal + p.getPrice()*cart.getProducts().get(p);
		}
		
		JTextPane txtpnTotal = new JTextPane();
		txtpnTotal.setEditable(false);
		txtpnTotal.setFont(new Font("Dialog", Font.PLAIN, 23));
		txtpnTotal.setForeground(new Color(255, 0, 0));
		txtpnTotal.setText("Total: $" + subtotal);
		txtpnTotal.setBounds(25, 200, 219, 41);
		contentPane.add(txtpnTotal);
		
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
		btnVolver.setBounds(12, 0, 101, 20);
		contentPane.add(btnVolver);
		
		JButton btnConfirmarCompra = new JButton("Confirmar compra");
		btnConfirmarCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(group.getSelection() == null) {
					JOptionPane.showMessageDialog(new JFrame(), "Seleccione tipo de envío", "Error", JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(new JFrame(), "Compra confirmada. Factura enviada a " + u.getMail() , "Gracias por su compra", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			
			}
		});
		btnConfirmarCompra.setFont(new Font("Dialog", Font.BOLD, 22));
		btnConfirmarCompra.setBounds(25, 341, 400, 97);
		contentPane.add(btnConfirmarCompra);
		
		JTextPane txtpnSeEnviaraUna = new JTextPane();
		txtpnSeEnviaraUna.setEditable(false);
		txtpnSeEnviaraUna.setFont(new Font("Dialog", Font.BOLD, 12));
		txtpnSeEnviaraUna.setText("Se enviara una factura a " + u.getMail() + ".");
		txtpnSeEnviaraUna.setBounds(32, 253, 301, 21);
		contentPane.add(txtpnSeEnviaraUna);
		
		JTextPane txtpnSePuedePagar = new JTextPane();
		txtpnSePuedePagar.setEditable(false);
		txtpnSePuedePagar.setFont(new Font("Dialog", Font.BOLD, 12));
		txtpnSePuedePagar.setText("Se puede pagar desde homebanking o cajero automático.");
		txtpnSePuedePagar.setBounds(31, 289, 403, 21);
		contentPane.add(txtpnSePuedePagar);
		
		JTextPane txtpnSeEnviar = new JTextPane();
		txtpnSeEnviar.setEditable(false);
		txtpnSeEnviar.setText("Se enviará a: " + u.getCalle() + " " + u.getAltura() + ", " + u.getLocalidad() + ", " + u.getProvincia() 
		+ ", " + u.getPais()+ " CP: " + u.getCp() +  ".");
		txtpnSeEnviar.setBounds(144, 82, 255, 79);
		contentPane.add(txtpnSeEnviar);
	}
}
