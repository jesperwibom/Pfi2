
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class DigitalClockGUI extends JFrame {
	
	private JPanel clockPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	
	private JTextArea clockDisplay = new JTextArea();
	
	private JLabel lblHours = new JLabel("Hours:");
	private JTextArea txtHours = new JTextArea("HH");
	private JLabel lblMinutes = new JLabel("Minutes:");
	private JTextArea txtMinutes = new JTextArea("MM");
	private JButton btnSetAlarm = new JButton("Set alarm");
	private JButton btnCancelAlarm = new JButton("Cancel alarm");
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				DigitalClockGUI digitalClockGUI = new DigitalClockGUI();
				digitalClockGUI.setVisible(true);
			}
		});
	}
	
	
	public DigitalClockGUI(){
		initGUI();
	}
	
	
	private void initGUI(){
		
		ClockLogic clockLogic = new ClockLogic(this);
		
		setTitle("Digital Alarm Clock");
		setIconImage(Toolkit.getDefaultToolkit().getImage("http://simpleicon.com/wp-content/uploads/clock-time-1.png"));
		setLocation(100,100);
		setSize(400,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().add(clockPanel, BorderLayout.CENTER);
		
		clockPanel.setLayout(new BorderLayout());
		clockPanel.add(buttonPanel, BorderLayout.SOUTH);
		clockPanel.add(clockDisplay, BorderLayout.CENTER);
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(lblHours);
		buttonPanel.add(txtHours);
		buttonPanel.add(lblMinutes);
		buttonPanel.add(txtMinutes);
		buttonPanel.add(btnSetAlarm);
		buttonPanel.add(btnCancelAlarm);
		
		btnSetAlarm.setToolTipText("Activates the alarm");
		btnCancelAlarm.setToolTipText("Cancels the alarm");
		txtHours.setToolTipText("Sets the timer to entered number of hours");
		txtMinutes.setToolTipText("Sets the timer to entered number of minutes");
		
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		btnCancelAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
	
	
	public void setTimeOnLabel(String time){
		
	}
	
	
	public void alarm(boolean activate){
		
	}

}
