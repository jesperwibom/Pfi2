
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class DigitalClockGUI extends JFrame implements ActionListener{
	
	private JPanel clockPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	
	private JTextArea clockDisplay = new JTextArea();
	
	private JLabel lblHours = new JLabel("Hours:");
	private JTextArea txtHours = new JTextArea("HH");
	private JLabel lblMinutes = new JLabel("Minutes:");
	private JTextArea txtMinutes = new JTextArea("MM");
	private JButton btnSetAlarm = new JButton("Set alarm");
	private JButton btnCancelAlarm = new JButton("Cancel alarm");
	
	private ClockLogic clockLogic;
	
	public static void main(String[] args) {
		DigitalClockGUI digitalClockGUI = new DigitalClockGUI();
		digitalClockGUI.setLocation(20, 20);
		digitalClockGUI.setSize(500,200);
		digitalClockGUI.setVisible(true);
	}
	
	public DigitalClockGUI(){
		
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
		
		btnSetAlarm.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == btnSetAlarm){
			
		} else if (e.getSource() == btnCancelAlarm){
			
		}
	}
	
	public void setTimeOnLabel(String time){
		
	}
	
	public void alarm(boolean activate){
		
	}

}
