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
import java.io.File;
import java.awt.event.ActionEvent;

public class AddForm {

	private JFrame frame;
	private JTextField textReg;
	private JTextField textMake;
	private JTextField textModel;
	private JTextField textColour;
	private JTextField textPrice;
	private JTextField textDesc;
	private JButton btnSubmit;
	
	private JLabel lblErrorMake;
	private JLabel lblErrorModel;
	private JLabel lblErrorReg;
	private JLabel lblErrorColour;
	private JLabel lblErrorPrice;
	private JLabel lblErrorDesc;
	
	private String make;
	private String model;
	private String reg;
	private String colour;
	private String price;
	private String description;
	private File picture;
	
	boolean validDouble;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddForm window = new AddForm();
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
	public AddForm() {
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
		
		JLabel lblAddACar = new JLabel("Add a Car");
		lblAddACar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddACar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblAddACar.setBackground(Color.WHITE);
		lblAddACar.setBounds(0, 0, 682, 36);
		frame.getContentPane().add(lblAddACar);
		
		JLabel lblMake = new JLabel("Make:");
		lblMake.setBounds(77, 140, 56, 16);
		frame.getContentPane().add(lblMake);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(77, 183, 56, 16);
		frame.getContentPane().add(lblModel);
		
		JLabel lblRegister = new JLabel("Register:");
		lblRegister.setBounds(77, 97, 56, 16);
		frame.getContentPane().add(lblRegister);
		
		textReg = new JTextField();
		textReg.setColumns(10);
		textReg.setBounds(175, 94, 116, 22);
		frame.getContentPane().add(textReg);
		
		textMake = new JTextField();
		textMake.setColumns(10);
		textMake.setBounds(175, 137, 116, 22);
		frame.getContentPane().add(textMake);
		
		textModel = new JTextField();
		textModel.setColumns(10);
		textModel.setBounds(175, 180, 116, 22);
		frame.getContentPane().add(textModel);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//submit button
				  make=textMake.getText();
				  model=textModel.getText();
				  reg=textReg.getText();
				  colour=textColour.getText();
				  price = textPrice.getText();
				  //double price2 = Double.parseDouble(price);
				  //price=textPrice.;
				  description=textDesc.getText();
				  
				addCar(make,model,reg,colour,price,description);
				
			}
		});
		btnSubmit.setBounds(549, 380, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		textColour = new JTextField();
		textColour.setColumns(10);
		textColour.setBounds(175, 225, 116, 22);
		frame.getContentPane().add(textColour);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(175, 272, 116, 22);
		frame.getContentPane().add(textPrice);
		
		textDesc = new JTextField();
		textDesc.setColumns(10);
		textDesc.setBounds(175, 319, 116, 22);
		frame.getContentPane().add(textDesc);
		
		JLabel lblColour = new JLabel("Colour:");
		lblColour.setBounds(77, 228, 56, 16);
		frame.getContentPane().add(lblColour);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(77, 275, 56, 16);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(77, 322, 86, 16);
		frame.getContentPane().add(lblDescription);
		
		lblErrorMake = new JLabel("");
		lblErrorMake.setEnabled(true);
		lblErrorMake.setBounds(344, 140, 302, 16);
		frame.getContentPane().add(lblErrorMake);
		
		lblErrorReg = new JLabel("");
		lblErrorReg.setEnabled(true);
		lblErrorReg.setBounds(344, 97, 302, 16);
		frame.getContentPane().add(lblErrorReg);
		
		lblErrorModel = new JLabel("");
		lblErrorModel.setEnabled(true);
		lblErrorModel.setBounds(344, 183, 302, 16);
		frame.getContentPane().add(lblErrorModel);
		
		lblErrorColour = new JLabel("");
		lblErrorColour.setEnabled(true);
		lblErrorColour.setBounds(344, 231, 302, 16);
		frame.getContentPane().add(lblErrorColour);
		
		lblErrorPrice = new JLabel("");
		lblErrorPrice.setEnabled(true);
		lblErrorPrice.setBounds(344, 275, 302, 16);
		frame.getContentPane().add(lblErrorPrice);
		
		lblErrorDesc = new JLabel("");
		lblErrorDesc.setEnabled(true);
		lblErrorDesc.setBounds(344, 322, 302, 16);
		frame.getContentPane().add(lblErrorDesc);
	}

	public void open() {
		frame.setVisible(true);
		
	}
	
	private void addCar(String make,String model,String reg,String colour,String price,String description){
		//System.out.println(this.make +" "+this.model);
		boolean valid;
		valid =validateCar( make, model, reg, colour, price, description);
		
		
		
		if (valid == true){
			//System.out.println(valid);
			btnSubmit.setEnabled(false);
			double Price2 = Double.parseDouble(price);
			//add to database
			//Car c =new Car(make, model, reg, colour, Price2, description);
			//return message if successful
			//close window
		}
		
	}
	
	private boolean validateCar(String make,String model,String reg,String colour,String price,String description){
		boolean valid=true;
		if(make.length()==0){
			lblErrorMake.setText("Please enter Make");
			valid=false;
			//exit
		}
		else{
			lblErrorMake.setText("");
		}
		
		
		if(model.length()==0){
			lblErrorModel.setText("Please enter Model");
			valid=false;
			//exit
		}
		else{
			lblErrorModel.setText("");
			
		}
		
		if(reg.length()==0){
			lblErrorReg.setText("Please enter Registration");
			valid=false;
			
			//exit
		}
		else{
			lblErrorReg.setText("");
		}
		
		if(colour.length()==0){
			lblErrorColour.setText("Please enter Colour");
			valid=false;
			
			//exit
		}
		else{
			lblErrorColour.setText("");
		}
		
		validDouble=false;
		
		if(price!=""){
			validDouble =convertToDouble(price);
		}
		if(validDouble==false){
			lblErrorPrice.setText("Please enter Price");
			valid=false;
			//exit
		}
		else{
			lblErrorPrice.setText("");
		}
		
		if(description.length()==0){
			lblErrorDesc.setText("Please enter Description");
			valid=false;
			//exit
		}
		else{
			lblErrorDesc.setText("");
		}
		return valid;
		
	}//end validateCar

	private boolean convertToDouble(String price) {
		boolean validDouble=true;
		try {
			double doub = Double.parseDouble(price);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			//System.out.println("Error converting");
			validDouble=false;
		}
		return validDouble;
		
	}
	

		
	

   
	
}
