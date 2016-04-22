package ie.gmit.sw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ScrollPaneConstants;

public class ListForm {

	private JFrame frame;
	private String make;
	private String model;
	private String reg;
	private String colour;
	private String price;
	private String description;
	private JTable resultsTable;

	/**
	 * Launch the Form.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListForm window = new ListForm();
					window.frame.setVisible(true);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Form.
	 */
	public ListForm() {
		initialize();
		fillTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{682, 0};
		gridBagLayout.rowHeights = new int[]{36, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblListAllCars = new JLabel("List all Cars");
		lblListAllCars.setHorizontalAlignment(SwingConstants.CENTER);
		lblListAllCars.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblListAllCars.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblListAllCars = new GridBagConstraints();
		gbc_lblListAllCars.insets = new Insets(0, 0, 5, 0);
		gbc_lblListAllCars.anchor = GridBagConstraints.NORTH;
		gbc_lblListAllCars.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblListAllCars.gridx = 0;
		gbc_lblListAllCars.gridy = 0;
		frame.getContentPane().add(lblListAllCars, gbc_lblListAllCars);
		
		//adds a scroll bar to table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		resultsTable = new JTable();
		resultsTable.setForeground(Color.BLACK);
		resultsTable.setBackground(Color.WHITE);
		scrollPane.setViewportView(resultsTable);
		resultsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	public void open() {
		frame.setVisible(true);
	}
	
	private void fillTable(){
		ListCars lc = new ListCars();	
		ResultSet rs;
		//try to get result set
		try {
				rs = lc.getAllCars();		
				DefaultTableModel m = (DefaultTableModel) resultsTable.getModel();
				rs = lc.getAllCars();
				m.addColumn("Make");
		        m.addColumn("Model");
		        m.addColumn("Reg");
		        m.addColumn("Colour");
		        m.addColumn("Price");
		        m.addColumn("Description");
		        JTable table = new JTable(m);
		        //try to add data to table
				while(rs.next())
				{ 			
				     make = rs.getString("make");
					 model = rs.getString("model");
					 reg = rs.getString("reg");
					 colour = rs.getString("colour");
					 price = rs.getString("price");
					 description = rs.getString("description");
		
				    // This will add row from the DB as the last row in the JTable. 
				    m.insertRow(table.getRowCount(), new Object[] {make, model,reg,colour,price,description});
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(frame,"Unable to get information from database");	
			}
	}//end fillTable
}//end Listform