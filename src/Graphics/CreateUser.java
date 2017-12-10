package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.User;

import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class CreateUser extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CreateUser() {
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(33, 42, 147, 26);
		contentPane.add(formattedTextField);
		
		JTextPane txtpnNombreDeUsuario = new JTextPane();
		txtpnNombreDeUsuario.setBackground(UIManager.getColor("Desktop.background"));
		txtpnNombreDeUsuario.setText("Email");
		txtpnNombreDeUsuario.setEditable(false);
		txtpnNombreDeUsuario.setBounds(32, 12, 159, 30);
		contentPane.add(txtpnNombreDeUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(33, 128, 147, 26);
		contentPane.add(passwordField);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(UIManager.getColor("Desktop.background"));
		txtpnPassword.setText("Password");
		txtpnPassword.setBounds(33, 101, 130, 21);
		contentPane.add(txtpnPassword);
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setEditable(false);
		txtpnNombre.setText("Nombre");
		txtpnNombre.setBackground(UIManager.getColor("Desktop.background"));
		txtpnNombre.setBounds(33, 183, 130, 21);
		contentPane.add(txtpnNombre);
		
		JTextPane txtpnApellido = new JTextPane();
		txtpnApellido.setEditable(false);
		txtpnApellido.setText("Apellido");
		txtpnApellido.setBackground(UIManager.getColor("Desktop.background"));
		txtpnApellido.setBounds(33, 268, 130, 21);
		contentPane.add(txtpnApellido);
		
		textField = new JTextField();
		textField.setBounds(33, 214, 147, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(33, 295, 147, 26);
		contentPane.add(textField_1);
		
		JTextPane txtpnTipoDeDocumento = new JTextPane();
		txtpnTipoDeDocumento.setText("Tipo de documento");
		txtpnTipoDeDocumento.setEditable(false);
		txtpnTipoDeDocumento.setBackground(UIManager.getColor("Desktop.background"));
		txtpnTipoDeDocumento.setBounds(33, 342, 130, 21);
		contentPane.add(txtpnTipoDeDocumento);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"DNI", "Pasaporte", "CI"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("DNI\nPasaporte\nCI");
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(33, 370, 147, 51);
		contentPane.add(list);
		
		JTextPane txtpnNumeroDeDni = new JTextPane();
		txtpnNumeroDeDni.setText("Numero de DNI");
		txtpnNumeroDeDni.setEditable(false);
		txtpnNumeroDeDni.setBackground(UIManager.getColor("Desktop.background"));
		txtpnNumeroDeDni.setBounds(33, 440, 130, 21);
		contentPane.add(txtpnNumeroDeDni);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(33, 462, 147, 26);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField.getText() + " " + textField_1.getText();
				String mail = formattedTextField.getText();
				String dni = textField_2.getText();
				String phone = textField_9.getText();
				String password = new String(passwordField.getPassword());
				String pais = textField_3.getText();
				String provincia = textField_4.getText();
				String localidad = textField_5.getText();
				String calle = textField_6.getText();
				String altura = textField_7.getText();
				String cp = textField_8.getText();
				if(password.length() < 4 || password.length() > 8) {
					JOptionPane.showMessageDialog(new JFrame(), "Contraseña debe tener de 4 a 8 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(!cp.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(new JFrame(), "Codigo postal solo admite numeros", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(!phone.matches("[0-9]+")){
					JOptionPane.showMessageDialog(new JFrame(), "Formato del telefono erroneo", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(!name.matches("[a-zA-Z ]+") || !pais.matches("[a-zA-Z0-9 ]+") || !provincia.matches("[a-zA-Z0-9 ]+") || !localidad.matches("[a-zA-Z0-9 ]+") 
				|| !calle.matches("[a-zA-Z ]+") ){
					JOptionPane.showMessageDialog(new JFrame(), "Compruebe que pais, provincia, localidad y calle solo tienen letras o espacios", "Error", JOptionPane.ERROR_MESSAGE);		
				}else if(!altura.matches("[0-9]+")){
					JOptionPane.showMessageDialog(new JFrame(), "Altura de calle solo admite numeros", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(!isValidEmailAddress(mail)) {
					JOptionPane.showMessageDialog(new JFrame(), "Formato de correo invalido", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(!dni.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(new JFrame(), "Numero de DNI solo admite numeros", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(userFound(mail)){
					JOptionPane.showMessageDialog(new JFrame(), "Ya existe un usuario con ese correo", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
			
					try {
						Window.addUser(name, mail, dni, phone, password, pais, provincia, localidad, calle, altura, cp);
						setVisible(false); 
						dispose();
					} catch (FileNotFoundException | UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton.setBounds(607, 491, 167, 49);
		contentPane.add(btnNewButton);
		
		JTextPane txtpnPais = new JTextPane();
		txtpnPais.setText("Pais");
		txtpnPais.setEditable(false);
		txtpnPais.setBackground(UIManager.getColor("Desktop.background"));
		txtpnPais.setBounds(320, 21, 130, 21);
		contentPane.add(txtpnPais);
		
		JTextPane txtpnProvincia = new JTextPane();
		txtpnProvincia.setText("Provincia");
		txtpnProvincia.setEditable(false);
		txtpnProvincia.setBackground(UIManager.getColor("Desktop.background"));
		txtpnProvincia.setBounds(566, 12, 130, 21);
		contentPane.add(txtpnProvincia);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(320, 42, 147, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(565, 42, 147, 26);
		contentPane.add(textField_4);
		
		JTextPane txtpnLocalidad = new JTextPane();
		txtpnLocalidad.setText("Localidad");
		txtpnLocalidad.setEditable(false);
		txtpnLocalidad.setBackground(UIManager.getColor("Desktop.background"));
		txtpnLocalidad.setBounds(320, 101, 130, 21);
		contentPane.add(txtpnLocalidad);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(320, 128, 147, 26);
		contentPane.add(textField_5);
		
		JTextPane txtpnCalle = new JTextPane();
		txtpnCalle.setText("Calle");
		txtpnCalle.setEditable(false);
		txtpnCalle.setBackground(UIManager.getColor("Desktop.background"));
		txtpnCalle.setBounds(566, 101, 130, 21);
		contentPane.add(txtpnCalle);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(565, 131, 147, 26);
		contentPane.add(textField_6);
		
		JTextPane txtpnNumero = new JTextPane();
		txtpnNumero.setText("Numero");
		txtpnNumero.setEditable(false);
		txtpnNumero.setBackground(UIManager.getColor("Desktop.background"));
		txtpnNumero.setBounds(566, 169, 130, 21);
		contentPane.add(txtpnNumero);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(566, 202, 147, 26);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(320, 205, 147, 26);
		contentPane.add(textField_8);
		
		JTextPane txtpnCodigoPostal = new JTextPane();
		txtpnCodigoPostal.setText("Codigo postal");
		txtpnCodigoPostal.setEditable(false);
		txtpnCodigoPostal.setBackground(UIManager.getColor("Desktop.background"));
		txtpnCodigoPostal.setBounds(320, 183, 130, 21);
		contentPane.add(txtpnCodigoPostal);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(320, 283, 147, 26);
		contentPane.add(textField_9);
		
		JTextPane txtpnTelefono = new JTextPane();
		txtpnTelefono.setText("Telefono");
		txtpnTelefono.setEditable(false);
		txtpnTelefono.setBackground(UIManager.getColor("Desktop.background"));
		txtpnTelefono.setBounds(320, 255, 130, 21);
		contentPane.add(txtpnTelefono);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"Fijo", "Celular"}));
		spinner.setBounds(510, 278, 128, 35);
		contentPane.add(spinner);
	}
	
	protected boolean userFound(String mail) {
		for(User u: Window.users) {
			if(u.getMail().equals(mail)) {
				return true;
			}
		}
		return false;
	}

	public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }
}
