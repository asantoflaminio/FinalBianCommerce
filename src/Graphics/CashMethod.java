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
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class CashMethod extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public CashMethod(User u, ShoppingCart cart) {
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfirmarCompra = new JButton("Confirmar compra");
		btnConfirmarCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				try {
					Window.writeProducts();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(new JFrame(), "Compra confirmada. Correo enviado a " + u.getMail(), "Gracias por su compra", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		btnConfirmarCompra.setFont(new Font("Dialog", Font.BOLD, 22));
		btnConfirmarCompra.setBounds(59, 365, 316, 86);
		contentPane.add(btnConfirmarCompra);
		
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
		
		double subtotal = 0;
		for(Product p: cart.getProducts().keySet()) {
			subtotal = subtotal + p.getPrice()*cart.getProducts().get(p);
		}
		
		JTextPane txtpnTotal = new JTextPane();
		txtpnTotal.setEditable(false);
		txtpnTotal.setFont(new Font("Dialog", Font.PLAIN, 23));
		txtpnTotal.setForeground(Color.RED);
		txtpnTotal.setText("Total: $" + subtotal);
		txtpnTotal.setBounds(66, 316, 285, 37);
		contentPane.add(txtpnTotal);
		
		JTextPane txtpnPagoYRetiro = new JTextPane();
		txtpnPagoYRetiro.setEditable(false);
		txtpnPagoYRetiro.setFont(new Font("Dialog", Font.PLAIN, 22));
		txtpnPagoYRetiro.setText("Pago y retiro en nuestro local. ");
		txtpnPagoYRetiro.setBounds(59, 80, 358, 37);
		contentPane.add(txtpnPagoYRetiro);
		
		JTextPane txtpnPara = new JTextPane();
		txtpnPara.setEditable(false);
		txtpnPara.setFont(new Font("Dialog", Font.PLAIN, 22));
		txtpnPara.setText("Para envíos a domicilio utilizar otros medios de pago.");
		txtpnPara.setBounds(59, 116, 358, 92);
		contentPane.add(txtpnPara);
		
		JTextPane txtpnRetira = new JTextPane();
		txtpnRetira.setEditable(false);
		txtpnRetira.setFont(new Font("Dialog", Font.BOLD, 16));
		txtpnRetira.setForeground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		txtpnRetira.setText("Retira "+ u.getName() + " con documento numero " + u.getDni());
		txtpnRetira.setBounds(59, 209, 336, 86);
		contentPane.add(txtpnRetira);
	}
}
