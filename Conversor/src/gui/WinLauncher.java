package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Currency;
import main.Unit;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class WinLauncher extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private String[] units = new String[] {"Currency", "Distance", "Mass", "Temperature", "Linear speed", "Angular speed"};
 	
	private String[] currencies = new String[] {"(USD) United States Dollar","(MXN) Mexican Peso","(YPN) Japanese Yen", "(COP) Colombian Peso"};
	private String[] distances = new String[] {"[m] Meter","[km] Kilometer" ,"Foot","Inch","Mile"};

	
	public WinLauncher() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel<String>(units));
		comboBox.setBounds(166, 40, 243, 41);
		contentPane.add(comboBox);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
				int option = comboBox.getSelectedIndex();
				String type="";
							
				switch(option) {
				case 0:
					type = "CURRENCY";
				break;
				case 1:
					type = "DISTANCE";
				break;	
				case 2:
					type = "MASS";
				break;	
				case 3:
					type = "TEMPERATURE";
				break;	
				case 4:
					type = "LINEAR_SPEED";
				break;	
				case 5:
					type = "ANGULAR_SPEED";
				break;
				default:
					type = "CURRENCY";
				} 
			
				WinConversor winConversor = new WinConversor(type);
				winConversor.setVisible(true);
				dispose();
			}
			
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setMaximumSize(new Dimension(60, 25));
		btnNext.setBounds(350, 149, 107, 41);
		contentPane.add(btnNext);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(233, 149, 107, 41);
		contentPane.add(btnExit);
		
		JLabel lblConversion = new JLabel("Conversion");
		lblConversion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConversion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConversion.setBounds(40, 35, 116, 46);
		contentPane.add(lblConversion);
		
		
	}

}
