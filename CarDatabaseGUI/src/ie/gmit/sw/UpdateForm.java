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

public class UpdateForm {

	private JFrame frame;
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
					UpdateForm window = new UpdateForm();
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
	public UpdateForm() {
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
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setBounds(0, 0, 684, 36);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblUpdate.setBackground(Color.WHITE);
		frame.getContentPane().add(lblUpdate);
		
		JLabel lblSearchBy = new JLabel("Search By:");
		lblSearchBy.setBounds(172, 33, 87, 24);
		lblSearchBy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(lblSearchBy);
		
		JLabel lblRegister = new JLabel("Reg:");
		lblRegister.setBounds(182, 70, 34, 14);
		frame.getContentPane().add(lblRegister);
		
		textReg = new JTextField();
		textReg.setBounds(227, 70, 86, 20);
		frame.getContentPane().add(textReg);
		textReg.setColumns(10);
		
		JButton btnReg = new JButton("Search");
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchRegClick();
			}
		});
		btnReg.setBounds(333, 70, 89, 23);
		frame.getContentPane().add(btnReg);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(46, 97, 600, 200);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(162, 341, 97, 25);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(410, 341, 97, 25);
		frame.getContentPane().add(btnDelete);
	}
	
	public void open() {
		frame.setVisible(true);
		
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
