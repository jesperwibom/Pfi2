
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DigitalClockGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel clockPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	
	private JPanel clockDisplay = new JPanel();
	private JLabel timeHours = new JLabel("00");
	private JLabel timeMinutes = new JLabel("00");
	
	private JLabel lblHours = new JLabel("Hours:");
	private JTextArea txtHours = new JTextArea("HH");
	private JLabel lblMinutes = new JLabel("Minutes:");
	private JTextArea txtMinutes = new JTextArea("MM");
	private JButton btnSetAlarm = new JButton("Set alarm");
	private JButton btnCancelAlarm = new JButton("Cancel alarm");
	
	ClockLogic clockLogic;
	
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
		
		clockLogic = new ClockLogic(this);
		
		setTitle("Digital Alarm Clock");
		setIconImage(Toolkit.getDefaultToolkit().getImage("http://simpleicon.com/wp-content/uploads/clock-time-1.png"));
		setLocation(100,100);
		setSize(400,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().add(clockPanel, BorderLayout.CENTER);
		
		clockPanel.setLayout(new BorderLayout());
		clockPanel.add(clockDisplay, BorderLayout.CENTER);
		clockPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		clockDisplay.setBackground(new Color(190,170,100));
		
		clockDisplay.setLayout(new FlowLayout());
		clockDisplay.add(timeHours);
		clockDisplay.add(timeMinutes);
		timeHours.setFont(new Font("Myriad Pro Light", Font.PLAIN, 60));
		timeMinutes.setFont(new Font("Myriad Pro Light", Font.PLAIN, 60));
		
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
				int hours = Integer.parseInt(txtHours.getText().substring(0, 2));
				int minutes = Integer.parseInt(txtMinutes.getText().substring(0, 2));
				clockLogic.setAlarm(hours, minutes);
			}
		});
		btnCancelAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				clockLogic.clearAlarm();
			}
		});
	}
	
	
	public void setTimeOnLabel(int hour, int minute, int second){
		timeHours.setText(format(hour));
		timeMinutes.setText(format(minute));
		if(clockLogic.alarmSet){
			clockDisplay.setBackground(new Color(240,140,100));
		} else {
			clockDisplay.setBackground(new Color(190,170,100));
		}
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
	
	public void alarmSet(int hours, int minutes){
		//toggle alarm off if on?
		//set alarm if off
	}
	
	public void clearAlarm(){
		
	}

}
