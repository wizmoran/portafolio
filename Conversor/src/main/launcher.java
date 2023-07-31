package main;
import java.awt.EventQueue;

import javax.crypto.KeyGenerator;

import gui.*;

@SuppressWarnings("unused")
public class launcher {

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinLauncher frame = new WinLauncher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
		
		
		
		
		//KeyGenerator kg = KeyGenerator();
		
		Currency currency1 = new Currency("USD");
		Currency currency2 = new Currency("MXN");
		
		/*
		double amount = 1.0;
		double total = currency1.convert(amount, currency2);
		
		System.out.println(amount + " " + currency1.getName() + " = " + total + " " + currency2.getName());
		*/
		
		
	}

}
