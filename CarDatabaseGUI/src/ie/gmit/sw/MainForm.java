package ie.gmit.sw;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MainForm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
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
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.RED);
		frame.setForeground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{260, 260, 260, 0};
		gridBagLayout.rowHeights = new int[]{151, 151, 151, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		frame.getContentPane().add(label, gbc_label);
		
		JLabel lblCarManagementSoftware = new JLabel("Car Management");
		lblCarManagementSoftware.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarManagementSoftware.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblCarManagementSoftware.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCarManagementSoftware = new GridBagConstraints();
		gbc_lblCarManagementSoftware.fill = GridBagConstraints.BOTH;
		gbc_lblCarManagementSoftware.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarManagementSoftware.gridx = 1;
		gbc_lblCarManagementSoftware.gridy = 0;
		frame.getContentPane().add(lblCarManagementSoftware, gbc_lblCarManagementSoftware);
		
		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		frame.getContentPane().add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.BOTH;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		frame.getContentPane().add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.BOTH;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 1;
		frame.getContentPane().add(label_3, gbc_label_3);
		
		JButton btnSearch = new JButton("Search for Car");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchForm search = new SearchForm();
				search.open();
			}
		});
		
		JLabel label_4 = new JLabel("");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.BOTH;
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 2;
		gbc_label_4.gridy = 1;
		frame.getContentPane().add(label_4, gbc_label_4);
		
		JButton btnAdd = new JButton("Add Car");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddForm add = new AddForm();
				add.open();
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 2;
		frame.getContentPane().add(btnAdd, gbc_btnAdd);
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 2;
		frame.getContentPane().add(btnSearch, gbc_btnSearch);
		
		JButton btnListAllCars = new JButton("List All Cars");
		btnListAllCars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListForm list = new ListForm();
				list.open();
			}
		});
		GridBagConstraints gbc_btnListAllCars = new GridBagConstraints();
		gbc_btnListAllCars.gridx = 2;
		gbc_btnListAllCars.gridy = 2;
		frame.getContentPane().add(btnListAllCars, gbc_btnListAllCars);
	}
}
