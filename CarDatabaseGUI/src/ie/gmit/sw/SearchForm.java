package ie.gmit.sw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class SearchForm {

	private JFrame frame;
	private JTextField textMake;
	private JTextField textModel;
	private JTextField textReg;
	private String make;
	private String model;
	private String reg;
	private String colour;
	private String price;
	private String description;
	private JTable table;

	/**
	 * Launch the Form.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchForm window = new SearchForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the form.
	 */
	public SearchForm() {
		initialize();
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
		
		JLabel lblSearchCar = new JLabel("Search for a Car");
		lblSearchCar.setBounds(0, 0, 684, 36);
		lblSearchCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchCar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblSearchCar.setBackground(Color.WHITE);
		frame.getContentPane().add(lblSearchCar);
		
		JLabel lblSearchBy = new JLabel("Search By:");
		lblSearchBy.setBounds(172, 33, 87, 24);
		lblSearchBy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(lblSearchBy);
		
		JLabel lblMake = new JLabel("Make:");
		lblMake.setBounds(172, 73, 41, 14);
		frame.getContentPane().add(lblMake);
		
		textMake = new JTextField();
		textMake.setBounds(223, 70, 86, 20);
		frame.getContentPane().add(textMake);
		textMake.setColumns(10);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(169, 98, 44, 14);
		frame.getContentPane().add(lblModel);
		
		textModel = new JTextField();
		textModel.setBounds(223, 95, 86, 20);
		frame.getContentPane().add(textModel);
		textModel.setColumns(10);
		
		JLabel lblRegister = new JLabel("Reg:");
		lblRegister.setBounds(179, 123, 34, 14);
		frame.getContentPane().add(lblRegister);
		
		textReg = new JTextField();
		textReg.setBounds(223, 120, 86, 20);
		frame.getContentPane().add(textReg);
		textReg.setColumns(10);
		
		//button to Search by make
		JButton btnMake = new JButton("Search");
		btnMake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Search for car by Make
				searchMakeClick();
			}
		});
		btnMake.setBounds(331, 69, 89, 23);
		frame.getContentPane().add(btnMake);
		
		//button to Search by model
		JButton btnModel = new JButton("Search");
		btnModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchModelClick();
			}
		});
		btnModel.setBounds(331, 94, 89, 23);
		frame.getContentPane().add(btnModel);
		
		//button to Search by Reg
		JButton btnReg = new JButton("Search");
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchRegClick();
			}
		});
		btnReg.setBounds(331, 119, 89, 23);
		frame.getContentPane().add(btnReg);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(47, 150, 600, 200);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	/**
	 * Makes form visible
	 */
	public void open() {
		frame.setVisible(true);	
	}
	
	/**
	 * Adds data to table by Make
	 */
	
	public void searchMakeClick(){
		SearchCar sc = new SearchCar();	
		ResultSet rs=null;
		//try to get Result set
		try {
			rs = sc.searchMake(textMake.getText());
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(frame,"Unable to get result set");
		}

		//Setup for table
		table.setModel(new DefaultTableModel());
		
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		
		m.getDataVector().removeAllElements();		
		m.addColumn("Make");
        m.addColumn("Model");
        m.addColumn("Reg");
        m.addColumn("Colour");
        m.addColumn("Price");
        m.addColumn("Description");
        JTable table = new JTable(m);
        //add data to table
		try {
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
			JOptionPane.showMessageDialog(frame,"Unable to populate table");
		}
	
	}//end searchMakeClick
	
	/**
	 * Adds data to table by Model
	 */
	
	public void searchModelClick(){	
		SearchCar sc = new SearchCar();	
		ResultSet rs=null;
		//try to get result set
		try {
			rs = sc.searchModel(textModel.getText());
		} catch (SQLException e1) {
			//cannot get result set
			JOptionPane.showMessageDialog(frame,"Unable to get result set");
		}
		//Setup for table
		table.setModel(new DefaultTableModel());	
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		m.getDataVector().removeAllElements();	
		m.addColumn("Make");
	    m.addColumn("Model");
	    m.addColumn("Reg");
	    m.addColumn("Colour");
	    m.addColumn("Price");
	    m.addColumn("Description");
	    JTable table = new JTable(m);
	    //add data to table
		try {
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
			JOptionPane.showMessageDialog(frame,"Unable to populate table");
		}
		
	}//endSearchModelClick
	
	/**
	 * Adds data to table by Reg
	 */
	public void searchRegClick(){
		SearchCar sc = new SearchCar();	
		ResultSet rs=null;
		//Try to get result set
		try {
			rs = sc.searchReg(textReg.getText());
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(frame,"Unable to get result set");
		}
		//setup for table
		table.setModel(new DefaultTableModel());
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		m.getDataVector().removeAllElements();
		m.addColumn("Make");
	    m.addColumn("Model");
	    m.addColumn("Reg");
	    m.addColumn("Colour");
	    m.addColumn("Price");
	    m.addColumn("Description");
	    JTable table = new JTable(m);
	    //Addd data to table
		try {
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
			JOptionPane.showMessageDialog(frame,"Unable to populate table");
		}
	
	}//end SearchRegClick
	
}//endSearchForm