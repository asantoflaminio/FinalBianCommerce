package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Product;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class ChangeStock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	

	/**
	 * Create the frame.
	 */
	public ChangeStock(Product p) {
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(151, 145, 159, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnConfimar = new JButton("Confimar");
		btnConfimar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String stock = textField.getText();
				if(!stock.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(new JFrame(), "Stock solo admite numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					p.setStock(Integer.parseInt(stock));
					try {
						Window.writeProducts();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(new JFrame(), "Stock actualizado", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					dispose();
				}
				
			}
		});
		btnConfimar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnConfimar.setBounds(138, 215, 183, 36);
		contentPane.add(btnConfimar);
		
		
		
		JTextPane txtpnIngreseNuevoStock = new JTextPane();
		txtpnIngreseNuevoStock.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnIngreseNuevoStock.setEditable(false);
		txtpnIngreseNuevoStock.setText("Ingrese nuevo stock");
		txtpnIngreseNuevoStock.setBounds(119, 87, 242, 30);
		contentPane.add(txtpnIngreseNuevoStock);
		
		
	}
}
