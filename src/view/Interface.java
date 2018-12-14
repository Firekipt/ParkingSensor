package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Server.Server;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Interface(Server server) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtValeur = new JTextPane();
		txtValeur.setBounds(271, 111, 62, 22);
		contentPane.add(txtValeur);
		
		// requete 1
		JButton btnPlace1 = new JButton("Place 1");
		btnPlace1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtValeur.setText(server.getDataSns1());
			}
		});
		btnPlace1.setBounds(37, 53, 97, 25);
		contentPane.add(btnPlace1);
		
		
		JButton btnPlace2 = new JButton("Place 2");
		btnPlace2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtValeur.setText(server.getDataSns2());
			}
		});
		btnPlace2.setBounds(37, 111, 97, 25);
		contentPane.add(btnPlace2);
		
		JButton btnPlace3 = new JButton("Place 3");
		btnPlace3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtValeur.setText(server.getDataSns3());
			}
		});
		btnPlace3.setBounds(37, 169, 97, 25);
		contentPane.add(btnPlace3);
		
		
		
		JLabel lblValeur = new JLabel("Valeur :");
		lblValeur.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblValeur.setBounds(205, 114, 62, 16);
		contentPane.add(lblValeur);
	}
}
