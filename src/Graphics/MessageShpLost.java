package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.User;

import javax.swing.UIManager;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MessageShpLost extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public MessageShpLost(User usr) {
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 180);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnAlModificarSus = new JTextPane();
		//txtpnAlModificarSus.setDropMode(DropMode.ON);
		txtpnAlModificarSus.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtpnAlModificarSus.setEditable(false);
		txtpnAlModificarSus.setText("Al modificar sus datos se perderan los elementos en su carrito.");
		txtpnAlModificarSus.setAlignmentX(CENTER_ALIGNMENT);
		txtpnAlModificarSus.setBounds(99, 12, 337, 48);
		contentPane.add(txtpnAlModificarSus);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MessageShpLost.class.getResource("/com/sun/java/swing/plaf/windows/icons/Inform.gif")));
		label.setBounds(23, 12, 58, 58);
		contentPane.add(label);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditUser eu = new EditUser(usr);
				eu.setVisible(true);
				eu.setResizable(false);
				eu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);
				dispose();
			}
		});
		btnContinuar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnContinuar.setBounds(49, 72, 170, 44);
		contentPane.add(btnContinuar);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.setBounds(251, 72, 162, 44);
		contentPane.add(btnNewButton);
	}

}
