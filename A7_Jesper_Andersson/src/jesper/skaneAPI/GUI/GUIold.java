package jesper.skaneAPI.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIold extends JFrame {

	private JPanel contentPane;

	//Nedan hämtat från nils
	
	//Thread t1 = new rThread(this);
	
	GUIold g = this;
	int x = 1;
	
	JTextArea lArea = new JTextArea();
	JTextArea tArea = new JTextArea();
	JTextArea dArea = new JTextArea();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIold frame = new GUIold();
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
	public GUIold() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 287, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 450, 305);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLinje = new JLabel("Linje");
		lblLinje.setFont(new Font("Avenir Next", Font.BOLD, 13));
		lblLinje.setBounds(6, 6, 31, 16);
		lblLinje.setForeground(Color.ORANGE);
		panel.add(lblLinje);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setForeground(Color.ORANGE);
		lblDestination.setFont(new Font("Avenir Next", Font.BOLD, 13));
		lblDestination.setBounds(49, 6, 73, 16);
		panel.add(lblDestination);
		
		JLabel lblAvgr = new JLabel("Avgår");
		lblAvgr.setForeground(Color.ORANGE);
		lblAvgr.setFont(new Font("Avenir Next", Font.BOLD, 13));
		lblAvgr.setBounds(235, 6, 42, 16);
		panel.add(lblAvgr);
		
		tArea.setBackground(Color.LIGHT_GRAY);
		tArea.setBounds(236, 22, 41, 238);
		panel.add(tArea);
		tArea.setEditable(false);
		
		dArea.setBackground(Color.LIGHT_GRAY);
		dArea.setBounds(49, 22, 175, 238);
		panel.add(dArea);
		dArea.setEditable(false);
		lArea.setText("5\n5\n5\n5\n5");
		
		lArea.setBackground(Color.LIGHT_GRAY);
		lArea.setBounds(6, 22, 31, 238);
		panel.add(lArea);
		lArea.setEditable(false);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lArea.setText(null);
				dArea.setText(null);
				tArea.setText(null);
				/*
				Thread tx = new rThread(g);
				tx.start();
				*/
				x++;

			}
		});
		btnRefresh.setFont(new Font("Avenir Next", Font.PLAIN, 13));
		btnRefresh.setBounds(88, 272, 117, 29);
		panel.add(btnRefresh);
	}

}
