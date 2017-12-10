package Graphics;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.Product;

import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ModifyProducts extends JFrame {

	private JPanel contentPane;
	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public ModifyProducts() {
		setBackground(UIManager.getColor("Desktop.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnParaModificarUn = new JTextPane();
		txtpnParaModificarUn.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtpnParaModificarUn.setEditable(false);
		txtpnParaModificarUn.setText("Para modificar un producto seleccione la fila correspondiente");
		txtpnParaModificarUn.setBounds(70, 12, 486, 33);
		contentPane.add(txtpnParaModificarUn);
		
		String[] columnNames = {"Nombre",
                "Descripcion", "Foto",
                "Precio", "Stock", "Categoria"
               	};
		Object[][] data = new Object[Window.products.size()][6] ;
		int i =0;
		
		for(Product p: Window.products) {
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
			data[i][4] = p.getStock();
			data[i][5] = p.getCategory();
			i++;
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 57, 576, 494);
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
					ModifySelectedProduct msp = new ModifySelectedProduct(myP);
					msp.setVisible(true);
					msp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setVisible(false);
					dispose();
				}
			}
		});
		
		
	}
	
	
}
