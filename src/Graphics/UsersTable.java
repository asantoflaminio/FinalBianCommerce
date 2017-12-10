package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.User;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class UsersTable extends JFrame {

	private JPanel contentPane;
	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public UsersTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[] columnNames = {"Nombre",
                "DNI",
                "Correo",
               	};
		Object[][] data = new Object[Window.users.size()][3] ;
		int i =0;
		
		for(User u: Window.users) {
			data[i][0] = u.getName();
			data[i][1] = u.getDni();	
			data[i][2] = u.getMail();
			i++;
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 35, 426, 416);
		contentPane.add(scrollPane);

		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);

	}
}
