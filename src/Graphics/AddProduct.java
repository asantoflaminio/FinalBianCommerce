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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class AddProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
	/**
	 * Create the frame.
	 */
	public AddProduct() {
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pr = textField_1.getText();
				String stck = textField_4.getText();
				String name = textField.getText();
				String descp = textField_2.getText();
				String category = textField_5.getText();
				String photoPath = textField_3.getText();
				if(!pr.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(new JFrame(), "Precio solo admite numeros", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(!stck.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(new JFrame(), "Stock solo admite numeros", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(!category.equals("Celulares") && !category.equals("Televisores") && !category.equals("Auriculares") &&
						!category.equals("Camaras") && !category.equals("Notebooks") && !category.equals("Tablets")){
					JOptionPane.showMessageDialog(new JFrame(), "Categoria no encontrada (Recuerde primer letra en mayuscula)", "Error", JOptionPane.ERROR_MESSAGE);			
				}else {
					//El path de la foto no se chequea. Si luego no se encuentra se usa la imagen por default.
					Product p = new Product(name, descp, photoPath, Integer.parseInt(pr), Integer.parseInt(stck), category);
					try {
						Window.addProduct(p);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					setVisible(false); 
					dispose();
				}
			}
		});
		btnAgregar.setBounds(93, 326, 114, 25);
		contentPane.add(btnAgregar);
		
		textField = new JTextField();
		textField.setBounds(83, 28, 124, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(83, 73, 124, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setEditable(false);
		txtpnNombre.setText("Nombre");
		txtpnNombre.setBounds(110, 12, 66, 21);
		contentPane.add(txtpnNombre);
		
		JTextPane txtpnPrecio = new JTextPane();
		txtpnPrecio.setEditable(false);
		txtpnPrecio.setText("Precio");
		txtpnPrecio.setBounds(120, 50, 66, 21);
		contentPane.add(txtpnPrecio);
		
		JTextPane txtpnDescripcion = new JTextPane();
		txtpnDescripcion.setEditable(false);
		txtpnDescripcion.setText("Descripcion");
		txtpnDescripcion.setBounds(110, 134, 98, 21);
		contentPane.add(txtpnDescripcion);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(83, 158, 124, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(83, 114, 124, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JTextPane txtpnUbicacionDeImagen = new JTextPane();
		txtpnUbicacionDeImagen.setEditable(false);
		txtpnUbicacionDeImagen.setText("Ubicacion de imagen");
		txtpnUbicacionDeImagen.setBounds(78, 93, 149, 21);
		contentPane.add(txtpnUbicacionDeImagen);
		
		JTextPane txtpnStock = new JTextPane();
		txtpnStock.setEditable(false);
		txtpnStock.setText("Stock");
		txtpnStock.setBounds(120, 189, 66, 19);
		contentPane.add(txtpnStock);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(83, 213, 124, 19);
		contentPane.add(textField_4);
		
		JTextPane txtpnCategoria = new JTextPane();
		txtpnCategoria.setText("Categoria");
		txtpnCategoria.setEditable(false);
		txtpnCategoria.setBounds(109, 244, 98, 21);
		contentPane.add(txtpnCategoria);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(83, 277, 124, 19);
		contentPane.add(textField_5);
	}
}
