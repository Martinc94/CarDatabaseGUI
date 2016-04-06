package ie.gmit.sw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{166, 511, 0};
		gridBagLayout.rowHeights = new int[]{36, 24, 22, 22, 22, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblSearchCar = new JLabel("Search for a Car");
		lblSearchCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchCar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblSearchCar.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblSearchCar = new GridBagConstraints();
		gbc_lblSearchCar.anchor = GridBagConstraints.NORTH;
		gbc_lblSearchCar.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSearchCar.insets = new Insets(0, 0, 5, 0);
		gbc_lblSearchCar.gridwidth = 2;
		gbc_lblSearchCar.gridx = 0;
		gbc_lblSearchCar.gridy = 0;
		frame.getContentPane().add(lblSearchCar, gbc_lblSearchCar);
		
		JLabel lblSearchBy = new JLabel("Search By:");
		lblSearchBy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblSearchBy = new GridBagConstraints();
		gbc_lblSearchBy.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblSearchBy.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchBy.gridx = 0;
		gbc_lblSearchBy.gridy = 1;
		frame.getContentPane().add(lblSearchBy, gbc_lblSearchBy);
		
		JLabel lblMake = new JLabel("Make:");
		GridBagConstraints gbc_lblMake = new GridBagConstraints();
		gbc_lblMake.insets = new Insets(0, 0, 5, 5);
		gbc_lblMake.gridx = 0;
		gbc_lblMake.gridy = 2;
		frame.getContentPane().add(lblMake, gbc_lblMake);
		
		textMake = new JTextField();
		GridBagConstraints gbc_textMake = new GridBagConstraints();
		gbc_textMake.anchor = GridBagConstraints.NORTHWEST;
		gbc_textMake.insets = new Insets(0, 0, 5, 0);
		gbc_textMake.gridx = 1;
		gbc_textMake.gridy = 2;
		frame.getContentPane().add(textMake, gbc_textMake);
		textMake.setColumns(10);
		
		JLabel lblModel = new JLabel("Model:");
		GridBagConstraints gbc_lblModel = new GridBagConstraints();
		gbc_lblModel.insets = new Insets(0, 0, 5, 5);
		gbc_lblModel.gridx = 0;
		gbc_lblModel.gridy = 3;
		frame.getContentPane().add(lblModel, gbc_lblModel);
		
		textModel = new JTextField();
		GridBagConstraints gbc_textModel = new GridBagConstraints();
		gbc_textModel.anchor = GridBagConstraints.NORTHWEST;
		gbc_textModel.insets = new Insets(0, 0, 5, 0);
		gbc_textModel.gridx = 1;
		gbc_textModel.gridy = 3;
		frame.getContentPane().add(textModel, gbc_textModel);
		textModel.setColumns(10);
		
		JLabel lblRegister = new JLabel("Register:");
		GridBagConstraints gbc_lblRegister = new GridBagConstraints();
		gbc_lblRegister.insets = new Insets(0, 0, 0, 5);
		gbc_lblRegister.gridx = 0;
		gbc_lblRegister.gridy = 4;
		frame.getContentPane().add(lblRegister, gbc_lblRegister);
		
		textReg = new JTextField();
		GridBagConstraints gbc_textReg = new GridBagConstraints();
		gbc_textReg.anchor = GridBagConstraints.NORTHWEST;
		gbc_textReg.gridx = 1;
		gbc_textReg.gridy = 4;
		frame.getContentPane().add(textReg, gbc_textReg);
		textReg.setColumns(10);
	}
	
	public void open() {
		frame.setVisible(true);
		
	}
}
