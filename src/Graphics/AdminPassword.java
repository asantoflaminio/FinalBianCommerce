package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	
	/**
	 * Create the frame.
	 */
	public AdminPassword() {
		setBackground(UIManager.getColor("ComboBox.disabledForeground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnIngreseLaContrase = new JTextPane();
		txtpnIngreseLaContrase.setEditable(false);
		txtpnIngreseLaContrase.setBackground(UIManager.getColor("Desktop.background"));
		txtpnIngreseLaContrase.setFont(new Font("Carlito", Font.BOLD, 15));
		txtpnIngreseLaContrase.setText("Ingrese la contraseña");
		txtpnIngreseLaContrase.setBounds(71, 53, 233, 42);
		contentPane.add(txtpnIngreseLaContrase);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(71, 107, 233, 32);
		contentPane.add(passwordField);
		
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Esta password se configura en funcion del cliente*/
				String passText = new String(passwordField.getPassword());
				if(passText.equals("123456")) {
					AccessAdmin alta= new AccessAdmin();
					alta.setVisible(true);
					setVisible(false);
					alta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnIngresar.setBounds(297, 165, 114, 25);
		contentPane.add(btnIngresar);
	}
}
