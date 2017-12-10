package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.Product;
import Model.ShoppingCart;
import Model.User;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShoppingCartFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public ShoppingCartFrame(User usr, ShoppingCart shp) {
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image card = new ImageIcon(this.getClass().getResource("/creditcard.png")).getImage();
		Image transf = new ImageIcon(this.getClass().getResource("/bank.png")).getImage();
		
		String[] columnNames = {"Nombre",
                "Imagen",
                "Precio"
               	};
		Object[][] data = new Object[shp.getProducts().keySet().size()][3] ;
		
			
		int i =0;
		
		for(Product p: shp.getProducts().keySet()) {
			data[i][0] = p.getName();
			if(this.getClass().getResource(p.getPhotoPath()) == null) {
				Image img = new ImageIcon(this.getClass().getResource("/noimage.jpeg")).getImage();
				data[i][1] = new ImageIcon(img);
				
			}else {
				Image img = new ImageIcon(this.getClass().getResource(p.getPhotoPath())).getImage();
				data[i][1] = new ImageIcon(img);
			}
			data[i][2] = p.getPrice();
			i++;
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 0, 426, 216);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
		    @Override
		    public Class<?> getColumnClass(int column) {
		        switch(column) {
		            case 0: return String.class;
		            case 1: return ImageIcon.class;
		            case 2: return Integer.class;
		            default: return Object.class;
		        }
		    }
		    
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		
		table = new JTable(model);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        for (int row = 0; row < table.getRowCount(); row++)
	    {
	        int rowHeight = table.getRowHeight();

	        for (int column = 0; column < table.getColumnCount(); column++)
	        {
	        	/*if(!table.getComponentAt(row, column).getClass().equals(ImageIcon.class)) {
	        		table.getColumnModel().getColumn(column).setCellRenderer( centerRenderer );
	        	}*/
	        	
	            Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
	            rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
	        }

	        table.setRowHeight(row, rowHeight);
	    }
        
        scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);
		
		double subtotal = 0;
		for(Product p: shp.getProducts().keySet()) {
			subtotal = subtotal + p.getPrice()*shp.getProducts().get(p);
		}
		JTextPane txtpnSubtotal = new JTextPane();
		txtpnSubtotal.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtpnSubtotal.setForeground(new Color(255, 0, 0));
		txtpnSubtotal.setText("Subtotal: " + subtotal);
		txtpnSubtotal.setBounds(37, 162, 88, 21);
		contentPane.add(txtpnSubtotal);
		
		JTextPane txtpnSeleccioneM = new JTextPane();
		txtpnSeleccioneM.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtpnSeleccioneM.setText("Seleccione método de pago");
		txtpnSeleccioneM.setBounds(122, 195, 205, 21);
		contentPane.add(txtpnSeleccioneM);
		
		JButton btnNewButton = new JButton("Tarjeta de debito/credito");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardMethod cdm = new CardMethod(usr, shp);
				cdm.setVisible(true);
				cdm.setResizable(false);
				cdm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 11));
		btnNewButton.setBackground(UIManager.getColor("Desktop.background"));
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBounds(12, 218, 195, 113);
		Image carro = new ImageIcon(this.getClass().getResource("/creditcard.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(carro));
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Transferencia bancaria");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TransferMethod tm = new TransferMethod(usr, shp);
				tm.setVisible(true);
				tm.setResizable(false);
				tm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);
				dispose();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 11));
		button.setBackground(UIManager.getColor("Desktop.background"));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setBounds(243, 218, 195, 113);
		Image bank = new ImageIcon(this.getClass().getResource("/bank.png")).getImage();
		button.setIcon(new ImageIcon(bank));
		contentPane.add(button);
		
		JButton button_1 = new JButton("Efectivo");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CashMethod cm = new CashMethod(usr, shp);
				cm.setVisible(true);
				cm.setResizable(false);
				cm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);
				dispose();
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 11));
		button_1.setBackground(UIManager.getColor("Desktop.background"));
		button_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setBounds(132, 338, 195, 113);
		Image cash = new ImageIcon(this.getClass().getResource("/cash2.png")).getImage();
		button_1.setIcon(new ImageIcon(cash));
		contentPane.add(button_1);
		Image ok = new ImageIcon(this.getClass().getResource("/oks.png")).getImage();
	}
	

}
