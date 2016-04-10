package ie.gmit.sw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
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
	 * Launch the application.
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
	 * Create the application.
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
		
		JButton btnMake = new JButton("Search");
		btnMake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Search for car by Make
				searchMakeClick();
			}
		});
		btnMake.setBounds(331, 69, 89, 23);
		frame.getContentPane().add(btnMake);
		
		JButton btnModel = new JButton("Search");
		btnModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchModelClick();
			}
		});
		btnModel.setBounds(331, 94, 89, 23);
		frame.getContentPane().add(btnModel);
		
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
	
	public void open() {
		frame.setVisible(true);
		
	}
	
	public void searchMakeClick(){
		
		SearchCar sc = new SearchCar();
			
		ResultSet rs =sc.searchMake(textMake.getText());

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
			    //System.out.println("Added "+make+ model+reg+colour+price+description);
			    //System.out.println("adding");
			}
		} catch (SQLException e) {
			System.out.println("unable to populate table" );
			//e.printStackTrace();
		}
		
	
	}

public void searchModelClick(){
	
	SearchCar sc = new SearchCar();
		
	ResultSet rs =sc.searchModel(textModel.getText());

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
		    //System.out.println("Added "+make+ model+reg+colour+price+description);
		    //System.out.println("adding");
		}
	} catch (SQLException e) {
		System.out.println("unable to populate table" );
		//e.printStackTrace();
	}
	
}

public void searchRegClick(){
	
	SearchCar sc = new SearchCar();
		
	ResultSet rs =sc.searchReg(textReg.getText());

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
		System.out.println("unable to populate table" );
		//e.printStackTrace();
	}

}
}//endSearchForm
