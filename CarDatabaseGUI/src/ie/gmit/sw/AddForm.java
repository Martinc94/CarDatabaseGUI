package ie.gmit.sw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AddForm {

	private JFrame frame;
	private JTextField textRegYear;
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
	private JLabel lblMessage;
	
	private String make;
	private String model;
	private String reg;
	private String colour;
	private String price;
	private String description;
	private File picture;
	
	private String regYr;
	private String regCo;
	private String regNum;
	
	boolean validDouble;
	private JTextField textRegCounty;
	private JTextField textRegNum;

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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{163, 30, 30, 32, 53, 35, 170, 133, 0};
		gridBagLayout.rowHeights = new int[]{36, 58, 22, 22, 22, 22, 22, 22, 39, 25, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblAddACar = new JLabel("Add a Car");
		lblAddACar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddACar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblAddACar.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblAddACar = new GridBagConstraints();
		gbc_lblAddACar.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAddACar.insets = new Insets(0, 0, 5, 0);
		gbc_lblAddACar.gridwidth = 8;
		gbc_lblAddACar.gridx = 0;
		gbc_lblAddACar.gridy = 0;
		frame.getContentPane().add(lblAddACar, gbc_lblAddACar);
		
		JLabel lblRegister = new JLabel("Register:");
		GridBagConstraints gbc_lblRegister = new GridBagConstraints();
		gbc_lblRegister.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegister.gridx = 0;
		gbc_lblRegister.gridy = 2;
		frame.getContentPane().add(lblRegister, gbc_lblRegister);
		
		textRegYear = new JTextField();
		textRegYear.setColumns(10);
		GridBagConstraints gbc_textRegYear = new GridBagConstraints();
		gbc_textRegYear.anchor = GridBagConstraints.NORTH;
		gbc_textRegYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRegYear.insets = new Insets(0, 0, 5, 5);
		gbc_textRegYear.gridx = 1;
		gbc_textRegYear.gridy = 2;
		frame.getContentPane().add(textRegYear, gbc_textRegYear);
		
		textRegCounty = new JTextField();
		textRegCounty.setColumns(10);
		GridBagConstraints gbc_textRegCounty = new GridBagConstraints();
		gbc_textRegCounty.anchor = GridBagConstraints.NORTH;
		gbc_textRegCounty.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRegCounty.insets = new Insets(0, 0, 5, 5);
		gbc_textRegCounty.gridx = 2;
		gbc_textRegCounty.gridy = 2;
		frame.getContentPane().add(textRegCounty, gbc_textRegCounty);
		
		textRegNum = new JTextField();
		textRegNum.setColumns(10);
		GridBagConstraints gbc_textRegNum = new GridBagConstraints();
		gbc_textRegNum.anchor = GridBagConstraints.NORTH;
		gbc_textRegNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRegNum.insets = new Insets(0, 0, 5, 5);
		gbc_textRegNum.gridx = 3;
		gbc_textRegNum.gridy = 2;
		frame.getContentPane().add(textRegNum, gbc_textRegNum);
		
		lblErrorReg = new JLabel("");
		lblErrorReg.setEnabled(true);
		GridBagConstraints gbc_lblErrorReg = new GridBagConstraints();
		gbc_lblErrorReg.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblErrorReg.insets = new Insets(0, 0, 5, 0);
		gbc_lblErrorReg.gridwidth = 3;
		gbc_lblErrorReg.gridx = 5;
		gbc_lblErrorReg.gridy = 2;
		frame.getContentPane().add(lblErrorReg, gbc_lblErrorReg);
		
		JLabel lblMake = new JLabel("Make:");
		GridBagConstraints gbc_lblMake = new GridBagConstraints();
		gbc_lblMake.insets = new Insets(0, 0, 5, 5);
		gbc_lblMake.gridx = 0;
		gbc_lblMake.gridy = 3;
		frame.getContentPane().add(lblMake, gbc_lblMake);
		
		textMake = new JTextField();
		textMake.setColumns(10);
		GridBagConstraints gbc_textMake = new GridBagConstraints();
		gbc_textMake.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMake.insets = new Insets(0, 0, 5, 5);
		gbc_textMake.gridwidth = 3;
		gbc_textMake.gridx = 1;
		gbc_textMake.gridy = 3;
		frame.getContentPane().add(textMake, gbc_textMake);
		
		lblErrorMake = new JLabel("");
		lblErrorMake.setEnabled(true);
		GridBagConstraints gbc_lblErrorMake = new GridBagConstraints();
		gbc_lblErrorMake.fill = GridBagConstraints.BOTH;
		gbc_lblErrorMake.insets = new Insets(0, 0, 5, 0);
		gbc_lblErrorMake.gridwidth = 3;
		gbc_lblErrorMake.gridx = 5;
		gbc_lblErrorMake.gridy = 3;
		frame.getContentPane().add(lblErrorMake, gbc_lblErrorMake);
		
		JLabel lblModel = new JLabel("Model:");
		GridBagConstraints gbc_lblModel = new GridBagConstraints();
		gbc_lblModel.insets = new Insets(0, 0, 5, 5);
		gbc_lblModel.gridx = 0;
		gbc_lblModel.gridy = 4;
		frame.getContentPane().add(lblModel, gbc_lblModel);
		
		textModel = new JTextField();
		textModel.setColumns(10);
		GridBagConstraints gbc_textModel = new GridBagConstraints();
		gbc_textModel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textModel.insets = new Insets(0, 0, 5, 5);
		gbc_textModel.gridwidth = 3;
		gbc_textModel.gridx = 1;
		gbc_textModel.gridy = 4;
		frame.getContentPane().add(textModel, gbc_textModel);
		
		lblErrorModel = new JLabel("");
		lblErrorModel.setEnabled(true);
		GridBagConstraints gbc_lblErrorModel = new GridBagConstraints();
		gbc_lblErrorModel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblErrorModel.insets = new Insets(0, 0, 5, 0);
		gbc_lblErrorModel.gridwidth = 3;
		gbc_lblErrorModel.gridx = 5;
		gbc_lblErrorModel.gridy = 4;
		frame.getContentPane().add(lblErrorModel, gbc_lblErrorModel);
		
		JLabel lblColour = new JLabel("Colour:");
		GridBagConstraints gbc_lblColour = new GridBagConstraints();
		gbc_lblColour.insets = new Insets(0, 0, 5, 5);
		gbc_lblColour.gridx = 0;
		gbc_lblColour.gridy = 5;
		frame.getContentPane().add(lblColour, gbc_lblColour);
		
		textColour = new JTextField();
		textColour.setColumns(10);
		GridBagConstraints gbc_textColour = new GridBagConstraints();
		gbc_textColour.fill = GridBagConstraints.HORIZONTAL;
		gbc_textColour.anchor = GridBagConstraints.NORTH;
		gbc_textColour.insets = new Insets(0, 0, 5, 5);
		gbc_textColour.gridwidth = 3;
		gbc_textColour.gridx = 1;
		gbc_textColour.gridy = 5;
		frame.getContentPane().add(textColour, gbc_textColour);
		
		lblErrorColour = new JLabel("");
		lblErrorColour.setEnabled(true);
		GridBagConstraints gbc_lblErrorColour = new GridBagConstraints();
		gbc_lblErrorColour.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblErrorColour.insets = new Insets(0, 0, 5, 0);
		gbc_lblErrorColour.gridwidth = 3;
		gbc_lblErrorColour.gridx = 5;
		gbc_lblErrorColour.gridy = 5;
		frame.getContentPane().add(lblErrorColour, gbc_lblErrorColour);
		
		JLabel lblPrice = new JLabel("Price:");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 6;
		frame.getContentPane().add(lblPrice, gbc_lblPrice);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		GridBagConstraints gbc_textPrice = new GridBagConstraints();
		gbc_textPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPrice.anchor = GridBagConstraints.NORTH;
		gbc_textPrice.insets = new Insets(0, 0, 5, 5);
		gbc_textPrice.gridwidth = 3;
		gbc_textPrice.gridx = 1;
		gbc_textPrice.gridy = 6;
		frame.getContentPane().add(textPrice, gbc_textPrice);
		
		lblErrorPrice = new JLabel("");
		lblErrorPrice.setEnabled(true);
		GridBagConstraints gbc_lblErrorPrice = new GridBagConstraints();
		gbc_lblErrorPrice.fill = GridBagConstraints.BOTH;
		gbc_lblErrorPrice.insets = new Insets(0, 0, 5, 0);
		gbc_lblErrorPrice.gridwidth = 3;
		gbc_lblErrorPrice.gridx = 5;
		gbc_lblErrorPrice.gridy = 6;
		frame.getContentPane().add(lblErrorPrice, gbc_lblErrorPrice);
		
		JLabel lblDescription = new JLabel("Description: ");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 7;
		frame.getContentPane().add(lblDescription, gbc_lblDescription);
		
		textDesc = new JTextField();
		textDesc.setColumns(10);
		GridBagConstraints gbc_textDesc = new GridBagConstraints();
		gbc_textDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDesc.anchor = GridBagConstraints.NORTH;
		gbc_textDesc.insets = new Insets(0, 0, 5, 5);
		gbc_textDesc.gridwidth = 3;
		gbc_textDesc.gridx = 1;
		gbc_textDesc.gridy = 7;
		frame.getContentPane().add(textDesc, gbc_textDesc);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//submit button
				  make=textMake.getText();
				  model=textModel.getText();
				  regYr=textRegYear.getText();
				  regCo=textRegCounty.getText().toUpperCase();
				  regNum=textRegNum.getText();
				  colour=textColour.getText();
				  price = textPrice.getText();
				  description=textDesc.getText();
				  
				  addCar(make,model,reg,colour,price,description);			
			}
		});
		
		lblErrorDesc = new JLabel("");
		lblErrorDesc.setEnabled(true);
		GridBagConstraints gbc_lblErrorDesc = new GridBagConstraints();
		gbc_lblErrorDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblErrorDesc.insets = new Insets(0, 0, 5, 0);
		gbc_lblErrorDesc.gridwidth = 3;
		gbc_lblErrorDesc.gridx = 5;
		gbc_lblErrorDesc.gridy = 7;
		frame.getContentPane().add(lblErrorDesc, gbc_lblErrorDesc);
		
		lblMessage = new JLabel("");
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMessage.insets = new Insets(0, 0, 0, 5);
		gbc_lblMessage.gridwidth = 6;
		gbc_lblMessage.gridx = 0;
		gbc_lblMessage.gridy = 9;
		frame.getContentPane().add(lblMessage, gbc_lblMessage);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridx = 7;
		gbc_btnSubmit.gridy = 9;
		frame.getContentPane().add(btnSubmit, gbc_btnSubmit);
	}//end Initialise

	public void open() {
		frame.setVisible(true);	
	}
	
	private void addCar(String make,String model,String reg,String colour,String price,String description){
		boolean valid=false;
		boolean validCar;
		boolean validReg;
		
		reg=concatReg(regYr, regCo, regNum);			
		validReg=ValidateReg(regYr, regCo, regNum);
		validCar =validateCar( make, model, reg, colour, price, description);
		
		if(validCar&validReg)
			valid=true;
				
		if (valid == true){
			//System.out.println(valid);
			btnSubmit.setEnabled(false);
			double Price2 = Double.parseDouble(price);
			//add to database
			Car c =new Car(make, model, reg, colour, Price2, description);
			boolean success=c.addToDB(make, model, reg, colour, price, description);
			if (success){
				lblMessage.setText("Car Added Sucessful");
				JOptionPane.showMessageDialog(frame,"Car Added Sucessful");				
			}
			else{
				lblMessage.setText("Unable To add car to database");
				JOptionPane.showMessageDialog(frame,"Unable To add car to database");
				btnSubmit.setEnabled(true);
			}
		
		}
		
	}//end addCar
	
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
		
		/*if(reg.length()==0){
			lblErrorReg.setText("Please enter Registration");
			valid=false;
			
			//exit
		}
		else{
			lblErrorReg.setText("");
		}*/
		
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

	private boolean ValidCo(String str){
		boolean validCo=false;
			//regular expression to make sure String has only (A-Z)
			if (str.matches("[A-Z]+$")) {
				// str consists entirely of letters
				validCo=true;
				//System.out.println(str);
			}
		
		//System.out.println(validInt);
		return validCo;
		
	}

	private boolean convertToInt(String str){
		boolean validInt=true;
		try {
			int i = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			System.out.println("Error converting");
			validInt=false;
		}
		//System.out.println(validInt);
		return validInt;
		
	}
	
	private String concatReg(String yr,String co,String num) {
		String reg="";
		reg = yr+"-"+co+"-"+num;
		//System.out.println(reg);	
		return reg;
	}
	
	private Boolean ValidateReg(String yr,String co,String num) {
		Boolean validReg=true;
		if(yr.length()>3||yr.length()==0||convertToInt(yr)==false){
			 validReg=false;
		}
		
		if(co.length()>2||co.length()==0||ValidCo(co)==false){
			 validReg=false;
		}
		
		if(num.length()==0||convertToInt(num)==false){
			 validReg=false;
		}
		
		if(validReg==false){
			lblErrorReg.setText("Please enter Vaild Registration");
		}
		else{
			lblErrorReg.setText("");
		}
		return validReg;	
	}
}
