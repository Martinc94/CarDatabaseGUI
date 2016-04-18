package ie.gmit.sw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateForm {

	private JFrame frame;
	private JTextField textReg;
	private String id;
	private String make;
	private String model;
	private String reg;
	private String colour;
	private String price;
	private String description;
	private JTextField txtId;
	private JTextField txtMake;
	private JTextField txtModel;
	private JTextField txtReg;
	private JTextField txtColour;
	private JTextField txtPrice;
	private JTextField txtDesc;
	private JButton btnUpdate;
	private JButton btnDelete;
	private Car c;

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
		
		JLabel lblSearchBy = new JLabel("Search By Reg:");
		lblSearchBy.setBounds(136, 33, 123, 24);
		lblSearchBy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(lblSearchBy);
		
		JLabel lblRegister = new JLabel("Enter Exact Reg:");
		lblRegister.setBounds(106, 70, 110, 14);
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
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//UPDATE
				
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(162, 341, 97, 25);
		frame.getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DELETE
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setBounds(410, 341, 97, 25);
		frame.getContentPane().add(btnDelete);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(10, 200, 86, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtMake = new JTextField();
		txtMake.setBounds(106, 200, 86, 20);
		frame.getContentPane().add(txtMake);
		txtMake.setColumns(10);
		
		txtModel = new JTextField();
		txtModel.setColumns(10);
		txtModel.setBounds(202, 200, 86, 20);
		frame.getContentPane().add(txtModel);
		
		txtReg = new JTextField();
		txtReg.setEditable(false);
		txtReg.setColumns(10);
		txtReg.setBounds(298, 200, 86, 20);
		frame.getContentPane().add(txtReg);
		
		txtColour = new JTextField();
		txtColour.setColumns(10);
		txtColour.setBounds(394, 200, 86, 20);
		frame.getContentPane().add(txtColour);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 172, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblMake = new JLabel("Make:");
		lblMake.setBounds(106, 172, 46, 14);
		frame.getContentPane().add(lblMake);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(202, 172, 46, 14);
		frame.getContentPane().add(lblModel);
		
		JLabel lblReg = new JLabel("Reg:");
		lblReg.setBounds(298, 172, 46, 14);
		frame.getContentPane().add(lblReg);
		
		JLabel lblColour = new JLabel("Colour:");
		lblColour.setBounds(394, 172, 46, 14);
		frame.getContentPane().add(lblColour);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(490, 200, 86, 20);
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(586, 200, 86, 20);
		frame.getContentPane().add(txtDesc);
		txtDesc.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(490, 172, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(586, 172, 71, 14);
		frame.getContentPane().add(lblDescription);
	}
	
	public void open() {
		frame.setVisible(true);
		
	}

public void searchRegClick(){
	SearchCar sc = new SearchCar();
	//create result set	
	ResultSet rs =sc.searchExactReg(textReg.getText());

	try {
		while(rs.next())
		{ 			
			 id = rs.getString("id");
		     make = rs.getString("make");
			 model = rs.getString("model");
			 reg = rs.getString("reg");
			 colour = rs.getString("colour");
			 price = rs.getString("price");
			 description = rs.getString("description");
			 
			 //Update textBoxes
			 txtId.setText(id);
			 txtMake.setText(make);
			 txtModel.setText(model);
			 txtReg.setText(reg);
			 txtColour.setText(colour);
			 txtPrice.setText(price);
			 txtDesc.setText(description);
			 
			 c = new Car(id,reg,make,model,colour,price,description);
			 
			 btnUpdate.setEnabled(true);
			 btnDelete.setEnabled(true);
			 
			 //c.UpdateToDB();
			 

		    // This will add row from the DB as the last row in the JTable. 
		    //m.insertRow(table.getRowCount(), new Object[] {make, model,reg,colour,price,description});
		  
		}
	} catch (SQLException e) {
		System.out.println("unable to populate table" );
		//e.printStackTrace();
	}

}
}//endSearchForm
