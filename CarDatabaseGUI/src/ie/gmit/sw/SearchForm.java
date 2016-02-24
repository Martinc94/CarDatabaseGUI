package ie.gmit.sw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class SearchForm {

	private JFrame frame;
	private JTextField textMake;
	private JTextField textModel;
	private JTextField textReg;

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
		lblSearchCar.setBounds(0, 0, 682, 36);
		lblSearchCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchCar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblSearchCar.setBackground(Color.WHITE);
		frame.getContentPane().add(lblSearchCar);
		
		textMake = new JTextField();
		textMake.setBounds(171, 97, 116, 22);
		frame.getContentPane().add(textMake);
		textMake.setColumns(10);
		
		JLabel lblMake = new JLabel("Make:");
		lblMake.setBounds(77, 100, 56, 16);
		frame.getContentPane().add(lblMake);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(77, 143, 56, 16);
		frame.getContentPane().add(lblModel);
		
		JLabel lblRegister = new JLabel("Register:");
		lblRegister.setBounds(77, 186, 56, 16);
		frame.getContentPane().add(lblRegister);
		
		textModel = new JTextField();
		textModel.setBounds(171, 140, 116, 22);
		frame.getContentPane().add(textModel);
		textModel.setColumns(10);
		
		textReg = new JTextField();
		textReg.setBounds(171, 183, 116, 22);
		frame.getContentPane().add(textReg);
		textReg.setColumns(10);
		
		JLabel lblSearchBy = new JLabel("Search By:");
		lblSearchBy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSearchBy.setBounds(79, 62, 87, 24);
		frame.getContentPane().add(lblSearchBy);
	}
	
	public void open() {
		frame.setVisible(true);
		
	}
}
