package Graphics;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.Product;
import Model.ShoppingCart;

public class SearchTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	

	/**
	 * Create the frame.
	 */
	public SearchTable(String search, ShoppingCart shp) {
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		HashSet<Product> productsHere = new HashSet<Product>();
		
		
		
		for(Product p: Window.products) {
			if(p.getName().toUpperCase().contains(search.toUpperCase()) || p.getDescription().toUpperCase().contains(search.toUpperCase()) ) {
				productsHere.add(p);
			}
		}
		
		String[] columnNames = {"Nombre",
                "Descripcion",
                "Imagen", "Precio",
               	};
		Object[][] data = new Object[productsHere.size()][4] ;
		int i =0;
		
		for(Product p: productsHere) {
			data[i][0] = p.getName();
			data[i][1] = p.getDescription()	;
			if(this.getClass().getResource(p.getPhotoPath()) == null) {
				Image img = new ImageIcon(this.getClass().getResource("/noimage.jpeg")).getImage();
				data[i][2] = new ImageIcon(img);
				
			}else {
				Image img = new ImageIcon(this.getClass().getResource(p.getPhotoPath())).getImage();
				data[i][2] = new ImageIcon(img);
			}
			data[i][3] = p.getPrice();
			i++;
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 139, 750, 424);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
		    @Override
		    public Class<?> getColumnClass(int column) {
		        switch(column) {
		            case 0:
		            case 1: return Integer.class;
		            case 2: return ImageIcon.class;
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
        
		
		
		ListSelectionModel selModel = table.getSelectionModel();
		selModel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!selModel.isSelectionEmpty()) {
					int selectedRow = selModel.getMinSelectionIndex();
					String nameProd = (String) data[selectedRow][0];
					Product myP = new Product();
					for(Product p: Window.products) {
						if(p.getName().equals(nameProd)) {
							myP= p;
						}
					}
					if(myP.getStock() > 0) {
						AddToCartFrame addTo = new AddToCartFrame(myP, shp);
						addTo.setVisible(true);
						addTo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						/*setVisible(false);
						dispose();*/
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Articulo sin stock", "Error", JOptionPane.ERROR_MESSAGE);
					}
					selModel.clearSelection();
					
				}
			}
		});
				
		
		
		JTextPane txtpnSeleccioneLosProductos = new JTextPane();
		txtpnSeleccioneLosProductos.setEditable(false);
		txtpnSeleccioneLosProductos.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtpnSeleccioneLosProductos.setText("Seleccione los productos que desea agregar a su carrito");
		txtpnSeleccioneLosProductos.setBounds(12, 12, 584, 21);
		contentPane.add(txtpnSeleccioneLosProductos);
		
		JTextPane txtpnParaSalirDe = new JTextPane();
		txtpnParaSalirDe.setEditable(false);
		txtpnParaSalirDe.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtpnParaSalirDe.setText("Para salir de esta categoria cierre la ventana");
		txtpnParaSalirDe.setBounds(12, 45, 438, 21);
		contentPane.add(txtpnParaSalirDe);
		
		JTextPane txtpnProductosQueCoinciden = new JTextPane();
		txtpnProductosQueCoinciden.setText("Productos que coinciden con su busqueda: " + productsHere.size());
		txtpnProductosQueCoinciden.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtpnProductosQueCoinciden.setEditable(false);
		txtpnProductosQueCoinciden.setBounds(12, 78, 438, 21);
		contentPane.add(txtpnProductosQueCoinciden);
		
		
		
		
	}

}
