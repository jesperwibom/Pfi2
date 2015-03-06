import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;


public class SearchGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	JTextArea txtrResult = new JTextArea();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchGUI frame = new SearchGUI();
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
	public SearchGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 160);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setBounds(76, 6, 134, 28);
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Station> foundStations = new ArrayList<Station>();
				if(txtSearch != null){
					txtrResult.setText("");
					foundStations.addAll(Parser.getStationsFromURL(txtSearch.getText()));
				}
				for(Station s: foundStations){
					String lat = String.valueOf(s.getLatitude());
					String lon = String.valueOf(s.getLongitude());
					txtrResult.append("#"+s.getStationNbr()+" "+s.getStationName()+": lat: "+lat+" lon: "+lon+"\n");
				}
			}
		});
		btnSearch.setBounds(222, 7, 117, 29);
		panel.add(btnSearch);
		
		
		txtrResult.setText("Result");
		txtrResult.setBounds(6, 37, 426, 117);
		panel.add(txtrResult);
		
	}
}
