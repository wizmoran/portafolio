package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.AngularSpeed;
import main.Conversor;
import main.Currency;
import main.Distance;
import main.LinearSpeed;
import main.Mass;
import main.Temperature;
import main.Unit;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class WinConversor extends JFrame {

	private JPanel contentPane;
	private JTextField txtInput;
	private JTextField txtOutput;
	

/*
 * Constructor of class
 */

	public WinConversor(String type) {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<Unit> units1 = new JComboBox<>();
		units1.setBounds(34, 98, 152, 22);
		units1.setModel(new DefaultComboBoxModel<Unit>(getArray(type)));
		contentPane.add(units1);
		
		JComboBox<Unit> units2 = new JComboBox<>();
		units2.setBounds(233, 98, 152, 22);
		units2.setModel(new DefaultComboBoxModel<Unit>(getArray(type)));
		contentPane.add(units2);
		
		units1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				convert(units1, units2);
			}
		});
		units2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				convert(units1, units2);
			}
		});
		
		txtInput = new JTextField();
		txtInput.setHorizontalAlignment(SwingConstants.RIGHT);
		txtInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				int key = e.getKeyChar();
				boolean allowedCharacter = key >=48 && key <=57 || key == 45 || key == 46; //Only allows  -> 0 1 2 3 4 5 6 7 8 9 . - <-
				if (!allowedCharacter) {
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				convert(units1, units2);
			}
		});
		txtInput.setBounds(34, 60, 152, 39);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		txtOutput = new JTextField();
		txtOutput.setHorizontalAlignment(SwingConstants.LEFT);
		txtOutput.setEditable(false);
		txtOutput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				e.consume();	
			}
		});
		txtOutput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtOutput.setColumns(10);
		txtOutput.setBounds(233, 60, 152, 39);
		contentPane.add(txtOutput);
		
		JLabel lblEquals = new JLabel("=");
		lblEquals.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquals.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEquals.setBounds(196, 65, 27, 25);
		contentPane.add(lblEquals);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinLauncher winLauncher = new WinLauncher();
				winLauncher.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(305, 201, 107, 39);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(188, 201, 107, 39);
		contentPane.add(btnExit);
		
		JLabel lblType = new JLabel("Enter value to convert:");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblType.setBounds(10, 29, 176, 22);
		contentPane.add(lblType);
		
		
	}

	
/*
 * Returns an array of Units depending on its type-argument
 */
	private Unit[] getArray(String type){
		
		
		Unit[] array = null;
		switch(type) {
		case "CURRENCY":
			array = new Unit[] {
					new Currency("USD"),
					new Currency("MXN"),
					new Currency("EUR"),
					new Currency("JPY"),
					new Currency("GBP"),
					new Currency("KRW"),
					new Currency("COP"),
					new Currency("ARS")
					};
		
		break;
			
		case "DISTANCE":
			array = new Unit[] {
					new Distance("m"),
					new Distance("km"),
					new Distance("in"),
					new Distance("ft"),
					new Distance("mi"),
					new Distance("cm"),
					new Distance("mm")
					};
		break;
		
		case "TEMPERATURE":
			array = new Unit[] {
					new Temperature("K"),
					new Temperature("R"),
					new Temperature("°C"),
					new Temperature("°F")
					};
		break;
		
		case "MASS":
			array = new Unit[] {
					new Mass("kg"),
					new Mass("g"),
					new Mass("mg"),
					new Mass("t"),
					new Mass("lb"),
					new Mass("oz"),
					new Mass("dr"),
					new Mass("gr"),
					new Mass("cwt")
					};
		break;
		

		case "LINEAR_SPEED":
			array = new Unit[] {
					new LinearSpeed("m/s"),
					new LinearSpeed("km/h"),
					new LinearSpeed("mi/h"),
					new LinearSpeed("ft/s"),
					new LinearSpeed("knot")
					};
		break;
		case "ANGULAR_SPEED":
			array = new Unit[] {
					new AngularSpeed("rad/s"),
					new AngularSpeed("rpm")
					};
		break;

		default:
		
		}
		return array;
	}
	
	private void convert(JComboBox<Unit> comboBox1, JComboBox<Unit> comboBox2) {
		
		if(txtInput.getText().isBlank()) {
			return;
		}
		Unit unit1 = (Unit) comboBox1.getSelectedItem();
		Unit unit2 = (Unit) comboBox2.getSelectedItem();
		double quantity = 0; 
		
		try {
			quantity = Double.valueOf(txtInput.getText());
			Conversor conversor = new Conversor();
			DecimalFormat result = new DecimalFormat("0.00");
			String stringResult = result.format(conversor.convert(unit1, unit2, quantity));
			txtOutput.setText(stringResult);
			
		}
		catch(Exception ex) {
			System.out.println("Only numbers allowed");
			ex.printStackTrace();
			if(txtInput.getText().charAt(0)!='-') {
				txtInput.setText("");
			}
			txtOutput.setText("");
		}
	}
}
