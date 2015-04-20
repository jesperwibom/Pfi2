package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStation = new JLabel("Ubåtshallen");
		lblStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblStation.setFont(new Font("Helvetica Neue", Font.PLAIN, 28));
		lblStation.setForeground(Color.WHITE);
		lblStation.setBounds(6, 10, 288, 28);
		contentPane.add(lblStation);
		
		JLabel lblLinje = new JLabel("Linje");
		lblLinje.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblLinje.setForeground(Color.WHITE);
		lblLinje.setBounds(16, 46, 41, 16);
		contentPane.add(lblLinje);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblDestination.setForeground(Color.WHITE);
		lblDestination.setBounds(60, 46, 142, 16);
		contentPane.add(lblDestination);
		
		JLabel lblAvgar = new JLabel("Avgår");
		lblAvgar.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblAvgar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAvgar.setForeground(Color.WHITE);
		lblAvgar.setBounds(234, 46, 50, 16);
		contentPane.add(lblAvgar);
		
		JTextArea txtLinje = new JTextArea();
		txtLinje.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		txtLinje.setEditable(false);
		txtLinje.setForeground(new Color(255, 153, 0));
		txtLinje.setText("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16");
		txtLinje.setBackground(Color.BLACK);
		txtLinje.setBounds(26, 69, 18, 280);
		contentPane.add(txtLinje);
		
		JTextArea txtDestination = new JTextArea();
		txtDestination.setText("Ön\nRosengård\nCentralen\nCentralen");
		txtDestination.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		txtDestination.setForeground(new Color(255, 153, 0));
		txtDestination.setBackground(new Color(0, 0, 0));
		txtDestination.setBounds(60, 69, 170, 280);
		contentPane.add(txtDestination);
		
		JTextArea txtAvgar = new JTextArea();
		txtAvgar.setText("1 min\n5 min\n10:12\n23:30");
		txtAvgar.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		txtAvgar.setForeground(new Color(255, 153, 0));
		txtAvgar.setBackground(new Color(0, 0, 0));
		txtAvgar.setBounds(242, 69, 44, 280);
		contentPane.add(txtAvgar);
	}
}
