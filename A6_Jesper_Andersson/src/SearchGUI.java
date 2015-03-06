import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JScrollPane;


public class SearchGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	JTextArea txtrResult = new JTextArea();
	JTextArea txtrResult_1 = new JTextArea();
	private JTextField txtFrom;
	private JTextField txtTo;
	
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
		setBounds(100, 100, 450, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 165);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setText("SearchStation");
		txtSearch.setBounds(76, 6, 134, 28);
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Station> foundStations = new ArrayList<Station>();
				txtrResult.setText("");
				if(txtSearch != null){
					startThread(txtSearch.getText());
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
		txtrResult.setBounds(6, 37, 426, 122);
		panel.add(txtrResult);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 178, 438, 140);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtFrom = new JTextField();
		txtFrom.setText("From");
		txtFrom.setBounds(6, 6, 134, 28);
		panel_1.add(txtFrom);
		txtFrom.setColumns(10);
		
		txtTo = new JTextField();
		txtTo.setText("To");
		txtTo.setBounds(152, 6, 134, 28);
		panel_1.add(txtTo);
		txtTo.setColumns(10);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrResult_1.setText("");
				Journeys journeys;
				if(txtFrom != null && txtTo != null){
					String searchURL = Constants.getURL(txtFrom.getText(),txtTo.getText(),1);
					journeys = Parser.getJourneys(searchURL);
					for (Journey j : journeys.getJourneys()) {
						txtrResult_1.append(j.getStartStation()+" -> "+j.getEndStation()+"\n");
						String dep = format(j.getDepDateTime().get(Calendar.HOUR_OF_DAY))+":"+format(j.getDepDateTime().get(Calendar.MINUTE));
						String arr = format(j.getArrDateTime().get(Calendar.HOUR_OF_DAY))+":"+format(j.getArrDateTime().get(Calendar.MINUTE));
						txtrResult_1.append("Avgår: "+dep+" -> Anländer: "+arr);
					}
				}
			}
		});
		btnSearch_1.setBounds(298, 7, 117, 29);
		panel_1.add(btnSearch_1);
		
		txtrResult_1.setText("Result");
		txtrResult_1.setBounds(6, 36, 426, 99);
		panel_1.add(txtrResult_1);
		
	}
	
	private String format(int time){
		String strTime;
		if (time < 10){
			strTime = "0"+String.valueOf(time);
		} else {
			strTime = String.valueOf(time);
		}
		return strTime;
	}
	
	private void startThread(String search){
		txtrResult.setText("...");
		Thread thread = new SearchThread(search);
		thread.start();
	}
	
	private void startThread(String from, String to){
		txtrResult_1.setText("...");
		Thread thread = new SearchThread(from, to);
		thread.start();
	}
	
	private void setStationText(){
		
	}
	
	private void setJourneyText(){
		
	}
	
}
