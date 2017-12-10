package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.User;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class RemoveUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public RemoveUser() {
		setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnIngreseMailDel = new JTextPane();
		txtpnIngreseMailDel.setEditable(false);
		txtpnIngreseMailDel.setBackground(UIManager.getColor("Desktop.background"));
		txtpnIngreseMailDel.setFont(new Font("Carlito", Font.BOLD, 16));
		txtpnIngreseMailDel.setText("Ingrese mail del usuario a eliminar");
		txtpnIngreseMailDel.setBounds(107, 29, 295, 32);
		contentPane.add(txtpnIngreseMailDel);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField.setBounds(80, 86, 307, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean found = false;
				for(User u: Window.users) {
					if(u.getMail().equals(textField.getText())) {
						Window.users.remove(u);
						found = true;
					}
				}
				if(found == false) {
					JOptionPane.showMessageDialog(new JFrame(), "No se encontro ningun usuario con esa direccion", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						Window.writeUsers();
					} catch (FileNotFoundException | UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					setVisible(false);
					dispose();
				}
			}
		});
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 18));
		btnEliminar.setBounds(137, 175, 188, 63);
		contentPane.add(btnEliminar);
	}
}
