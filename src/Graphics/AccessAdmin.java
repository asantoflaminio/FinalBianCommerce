package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Product;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class AccessAdmin extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public AccessAdmin() {
		setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Eliminar usuario");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemoveUser ru = new RemoveUser();
				ru.setVisible(true);
				ru.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBounds(73, 45, 291, 123);
		contentPane.add(btnNewButton);
		
		JButton btnCargarProductos = new JButton("Cargar productos");
		btnCargarProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddProduct ap = new AddProduct();
				ap.setVisible(true);
				ap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnCargarProductos.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCargarProductos.setBounds(416, 45, 291, 123);
		contentPane.add(btnCargarProductos);
		
		JButton btnEditarProductos = new JButton("Editar productos");
		btnEditarProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModifyProducts mp = new ModifyProducts();
				mp.setVisible(true);
				mp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditarProductos.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEditarProductos.setBounds(416, 202, 291, 123);
		contentPane.add(btnEditarProductos);
		
		JTextPane txtpnCantidadDeUsuarios = new JTextPane();
		txtpnCantidadDeUsuarios.setEditable(false);
		txtpnCantidadDeUsuarios.setBackground(UIManager.getColor("Desktop.background"));
		txtpnCantidadDeUsuarios.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtpnCantidadDeUsuarios.setText("Cantidad de Usuarios:" + " " + Window.users.size());
		txtpnCantidadDeUsuarios.setBounds(91, 366, 251, 30);
		contentPane.add(txtpnCantidadDeUsuarios);
		
		JTextPane txtpnCantidadDeProductos = new JTextPane();
		txtpnCantidadDeProductos.setEditable(false);
		txtpnCantidadDeProductos.setText("Cantidad de Productos: " + Window.products.size());
		txtpnCantidadDeProductos.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtpnCantidadDeProductos.setBackground(UIManager.getColor("Desktop.background"));
		txtpnCantidadDeProductos.setBounds(91, 406, 251, 30);
		contentPane.add(txtpnCantidadDeProductos);
		
		JTextPane txtpnProductosSinStock = new JTextPane();
		txtpnProductosSinStock.setEditable(false);
		txtpnProductosSinStock.setBackground(UIManager.getColor("Desktop.background"));
		txtpnProductosSinStock.setFont(new Font("Dialog", Font.BOLD, 14));
		int sinStock = 0;
		for(Product p: Window.products) {
			if(p.getStock() == 0) {
				sinStock++;
			}
		}
		txtpnProductosSinStock.setText("Productos sin stock: " + sinStock);
		txtpnProductosSinStock.setBounds(91, 448, 211, 30);
		contentPane.add(txtpnProductosSinStock);
		
		JButton btnVerUsuarios = new JButton("Ver usuarios");
		btnVerUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UsersTable ut= new UsersTable();
				ut.setVisible(true);
				ut.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		btnVerUsuarios.setFont(new Font("Dialog", Font.BOLD, 20));
		btnVerUsuarios.setBounds(73, 202, 291, 123);
		contentPane.add(btnVerUsuarios);
		
		JButton btnActualizarValores = new JButton("Actualizar valores");
		btnActualizarValores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				txtpnCantidadDeUsuarios.setText("Cantidad de Usuarios:" + " " + Window.users.size());
				txtpnCantidadDeProductos.setText("Cantidad de Productos: " + Window.products.size());
				int noStock = 0;
				for(Product p: Window.products) {
					if(p.getStock() == 0) {
						noStock++;
					}
				}
				txtpnProductosSinStock.setText("Productos sin stock: " + noStock);
				setVisible(true);
			}
		});
		btnActualizarValores.setBounds(91, 490, 181, 30);
		contentPane.add(btnActualizarValores);
	}

}
