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
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModifySelectedProduct extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public ModifySelectedProduct(Product p) {
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEliminarProducto = new JButton("Eliminar producto");
		btnEliminarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Window.users.remove(p);
				JOptionPane.showMessageDialog(new JFrame(), "Producto eliminado", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				dispose();
			}
		});
		btnEliminarProducto.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEliminarProducto.setBounds(96, 164, 259, 61);
		contentPane.add(btnEliminarProducto);
		
		JButton btnNewButton = new JButton("Cambiar stock");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ChangeStock cs = new ChangeStock(p);
				cs.setResizable(false);
				cs.setVisible(true);
				cs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);	
				dispose();
				
			}
		});
		btnNewButton.setBounds(32, 93, 156, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cambiar precio");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePrice cp = new ChangePrice(p);
				cp.setVisible(true);
				cp.setResizable(false);
				cp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);	
				dispose();
			}
		});
		btnNewButton_1.setBounds(245, 93, 156, 25);
		contentPane.add(btnNewButton_1);
		
		JTextPane txtpnStockActual = new JTextPane();
		txtpnStockActual.setEditable(false);
		txtpnStockActual.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		txtpnStockActual.setText("Stock actual: " + p.getStock());
		txtpnStockActual.setBounds(47, 27, 138, 25);
		contentPane.add(txtpnStockActual);
		
		JTextPane txtpnPrecioActual = new JTextPane();
		txtpnPrecioActual.setEditable(false);
		txtpnPrecioActual.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		txtpnPrecioActual.setText("Precio actual: " +p.getPrice());
		txtpnPrecioActual.setBounds(235, 27, 166, 25);
		contentPane.add(txtpnPrecioActual);
	}
}
