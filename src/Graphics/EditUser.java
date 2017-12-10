package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.Font;
	

	
	public class EditUser extends JFrame {

		private JPanel contentPane;
		private JTextField txtHola;
		private JTextField txtHola_1;
		private JTextField txtHola_2;
		private JTextField txtHola_3;
		private JTextField txtHola_4;
		private JTextField txtHolacalle;
		private JTextField txtHolaaltura;
		private JTextField txtHolacp;
		private JTextField txtHolatelefono;

		
		

		/**
		 * Create the frame.
		 */
		public EditUser(User usr) {
			setBackground(UIManager.getColor("Desktop.background"));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 800, 408);
			contentPane = new JPanel();
			contentPane.setBackground(UIManager.getColor("Desktop.background"));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JTextPane txtpnNombre = new JTextPane();
			txtpnNombre.setEditable(false);
			txtpnNombre.setText("Nombre");
			txtpnNombre.setBackground(UIManager.getColor("Desktop.background"));
			txtpnNombre.setBounds(51, 21, 130, 21);
			contentPane.add(txtpnNombre);
			
			JTextPane txtpnApellido = new JTextPane();
			txtpnApellido.setEditable(false);
			txtpnApellido.setText("Apellido");
			txtpnApellido.setBackground(UIManager.getColor("Desktop.background"));
			txtpnApellido.setBounds(51, 101, 130, 21);
			contentPane.add(txtpnApellido);
			
			String[] str = usr.getName().split(" ");
			String firstName = new String();
			for(int i=0; i < (str.length - 1); i++) {
				firstName = firstName + str[i];
			}
			
			txtHola = new JTextField();
			txtHola.setText(firstName);
			txtHola.setBounds(34, 42, 147, 26);
			contentPane.add(txtHola);
			txtHola.setColumns(10);
			
			txtHola_1 = new JTextField();
			txtHola_1.setText(str[str.length-1]);
			txtHola_1.setColumns(10);
			txtHola_1.setBounds(34, 128, 147, 26);
			contentPane.add(txtHola_1);
			
			JButton btnNewButton = new JButton("Confirmar datos");
			btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String name = txtHola.getText() + " " + txtHola_1.getText();
					String phone = txtHolatelefono.getText();
					String pais = txtHola_2.getText();
					String provincia = txtHola_3.getText();
					String localidad = txtHola_4.getText();
					String calle = txtHolacalle.getText();
					String altura = txtHolaaltura.getText();
					String cp = txtHolacp.getText();
					if(!cp.matches("[0-9]+")) {
						JOptionPane.showMessageDialog(new JFrame(), "Codigo postal solo admite numeros", "Error", JOptionPane.ERROR_MESSAGE);
					}else if(!phone.matches("[0-9]+")){
						JOptionPane.showMessageDialog(new JFrame(), "Formato del telefono erroneo", "Error", JOptionPane.ERROR_MESSAGE);
					}else if(!name.matches("[a-zA-Z ]+") || !pais.matches("[a-zA-Z0-9 ]+") || !provincia.matches("[a-zA-Z0-9 ]+") || !localidad.matches("[a-zA-Z0-9 ]+") 
					|| !calle.matches("[a-zA-Z ]+") ){
						JOptionPane.showMessageDialog(new JFrame(), "Compruebe que pais, provincia, localidad y calle solo tienen letras o espacios", "Error", JOptionPane.ERROR_MESSAGE);		
					}else if(!altura.matches("[0-9]+")){
						JOptionPane.showMessageDialog(new JFrame(), "Altura de calle solo admite numeros", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
							for(User u: Window.users) {
								if(u.getMail().equals(usr.getMail())) {
									u.setAltura(Integer.parseInt(altura));
									u.setName(name);
									u.setCalle(calle);
									u.setCellphone(phone);
									u.setPais(pais);
									u.setProvincia(provincia);
									u.setLocalidad(localidad);
									u.setCp(Integer.parseInt(cp));
								}
							}
							try {
								Window.writeUsers();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (UnsupportedEncodingException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							setVisible(false);
							dispose();
							UserMenu um = new UserMenu(usr);
							um.setResizable(false);
							um.setVisible(true);
							um.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
					}
					
				}
			});
			btnNewButton.setBounds(30, 248, 209, 94);
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
			
			txtHola_2 = new JTextField();
			txtHola_2.setText(usr.getPais());
			txtHola_2.setColumns(10);
			txtHola_2.setBounds(320, 42, 147, 26);
			contentPane.add(txtHola_2);
			
			txtHola_3 = new JTextField();
			txtHola_3.setText(usr.getProvincia());
			txtHola_3.setColumns(10);
			txtHola_3.setBounds(565, 42, 147, 26);
			contentPane.add(txtHola_3);
			
			JTextPane txtpnLocalidad = new JTextPane();
			txtpnLocalidad.setText("Localidad");
			txtpnLocalidad.setEditable(false);
			txtpnLocalidad.setBackground(UIManager.getColor("Desktop.background"));
			txtpnLocalidad.setBounds(320, 101, 130, 21);
			contentPane.add(txtpnLocalidad);
			
			txtHola_4 = new JTextField();
			txtHola_4.setText(usr.getLocalidad());
			txtHola_4.setColumns(10);
			txtHola_4.setBounds(320, 128, 147, 26);
			contentPane.add(txtHola_4);
			
			JTextPane txtpnCalle = new JTextPane();
			txtpnCalle.setText("Calle");
			txtpnCalle.setEditable(false);
			txtpnCalle.setBackground(UIManager.getColor("Desktop.background"));
			txtpnCalle.setBounds(566, 101, 130, 21);
			contentPane.add(txtpnCalle);
			
			txtHolacalle = new JTextField();
			txtHolacalle.setText(usr.getCalle());
			txtHolacalle.setColumns(10);
			txtHolacalle.setBounds(565, 131, 147, 26);
			contentPane.add(txtHolacalle);
			
			JTextPane txtpnNumero = new JTextPane();
			txtpnNumero.setText("Numero");
			txtpnNumero.setEditable(false);
			txtpnNumero.setBackground(UIManager.getColor("Desktop.background"));
			txtpnNumero.setBounds(566, 169, 130, 21);
			contentPane.add(txtpnNumero);
			
			txtHolaaltura = new JTextField();
			Integer alt = usr.getAltura();
			txtHolaaltura.setText(alt.toString());
			txtHolaaltura.setColumns(10);
			txtHolaaltura.setBounds(566, 202, 147, 26);
			contentPane.add(txtHolaaltura);
			
			txtHolacp = new JTextField();
			Integer cp = usr.getCp();
			txtHolacp.setText(cp.toString());
			txtHolacp.setColumns(10);
			txtHolacp.setBounds(320, 205, 147, 26);
			contentPane.add(txtHolacp);
			
			JTextPane txtpnCodigoPostal = new JTextPane();
			txtpnCodigoPostal.setText("Codigo postal");
			txtpnCodigoPostal.setEditable(false);
			txtpnCodigoPostal.setBackground(UIManager.getColor("Desktop.background"));
			txtpnCodigoPostal.setBounds(320, 183, 130, 21);
			contentPane.add(txtpnCodigoPostal);
			
			txtHolatelefono = new JTextField();
			txtHolatelefono.setText(usr.getCellphone());
			txtHolatelefono.setColumns(10);
			txtHolatelefono.setBounds(320, 283, 147, 26);
			contentPane.add(txtHolatelefono);
			
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
		
		public boolean isValidEmailAddress(String email) {
	        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
	        java.util.regex.Matcher m = p.matcher(email);
	        return m.matches();
	 }
}


