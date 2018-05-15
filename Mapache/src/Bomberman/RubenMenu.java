package Bomberman;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class RubenMenu {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RubenMenu window = new RubenMenu();
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
	public RubenMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnEmpezar = new JButton("EMPEZAR");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("saludos a pablo sobrado");
				Bomberman.pwr=Integer.parseInt(textField.getText());
				BombermanOO.jugar();
				frame.dispose();
			}
		});
		btnEmpezar.setBounds(154, 155, 89, 23);
		frame.getContentPane().add(btnEmpezar);
		
		JLabel lblBomberman = new JLabel("BOMBERMAN");
		lblBomberman.setBounds(165, 11, 166, 103);
		frame.getContentPane().add(lblBomberman);
		
		JLabel lblPwr = new JLabel("PWR");
		lblPwr.setBounds(97, 123, 46, 14);
		frame.getContentPane().add(lblPwr);
		
		textField = new JTextField();
		textField.setBounds(154, 120, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
