package ie.gmit.sw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class ListForm {

	private JFrame frame;
	private JTable table;
	private String make;
	private String model;
	private String reg;
	private String colour;
	private String price;
	private String description;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListForm window = new ListForm();
					window.frame.setVisible(true);
					//ListCars lc = new ListCars();

					//ResultSet rs = lc.getAllCars();
					
					
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
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
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblListAllCars = new JLabel("List all Cars");
		lblListAllCars.setHorizontalAlignment(SwingConstants.CENTER);
		lblListAllCars.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblListAllCars.setBackground(Color.WHITE);
		lblListAllCars.setBounds(0, 0, 682, 36);
		frame.getContentPane().add(lblListAllCars);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setBounds(12, 88, 658, 352);
		frame.getContentPane().add(table);
		
	}
	
	public void open() {
		frame.setVisible(true);
	}
	
	private void fillTable(){
		ListCars lc = new ListCars();	
		ResultSet rs;
		try {
				rs = lc.getAllCars();
			
				DefaultTableModel m = (DefaultTableModel) table.getModel();
				m.addColumn("Make");
		        m.addColumn("Model");
		        m.addColumn("Reg");
		        m.addColumn("Colour");
		        m.addColumn("Price");
		        m.addColumn("Description");
		        JTable table = new JTable(m);
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
				e.printStackTrace();
			}
	
	
	}//end fillTable
}
