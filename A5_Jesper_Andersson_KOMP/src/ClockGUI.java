import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ClockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtAlarmHour;
	ClockLogic clockLogic;
	private JLabel lblTime;
	private JLabel lblAlarmTime;
	private JLabel lblAlarmSet;
	private JTextField txtAlarmMin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClockGUI frame = new ClockGUI();
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
	public ClockGUI() {
		
		clockLogic = new ClockLogic(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 170);
		setMinimumSize(new Dimension(430,170));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel clockPanel = new JPanel();
		clockPanel.setBounds(6, 6, 418, 96);
		contentPane.add(clockPanel);
		clockPanel.setLayout(null);
		
		lblTime = new JLabel("HH:MM");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Lucida Grande", Font.PLAIN, 77));
		lblTime.setBounds(70, 6, 270, 84);
		clockPanel.add(lblTime);
		
		lblAlarmSet = new JLabel("Alarm:");
		lblAlarmSet.setBounds(345, 47, 67, 16);
		clockPanel.add(lblAlarmSet);
		
		
		lblAlarmTime = new JLabel("HH:MM");
		lblAlarmTime.setBounds(345, 64, 67, 16);
		clockPanel.add(lblAlarmTime);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(6, 104, 418, 38);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JLabel lblAlarm = new JLabel("Alarm time:");
		lblAlarm.setBounds(6, 11, 73, 16);
		buttonPanel.add(lblAlarm);
		
		txtAlarmHour = new JTextField();
		txtAlarmHour.setHorizontalAlignment(SwingConstants.LEFT);
		txtAlarmHour.setBounds(84, 5, 39, 28);
		txtAlarmHour.setText("HH");
		buttonPanel.add(txtAlarmHour);
		txtAlarmHour.setColumns(10);
		
		JButton btnSetAlarm = new JButton("Set alarm");
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hours = Integer.parseInt(txtAlarmHour.getText().substring(0, 2));
				int minutes = Integer.parseInt(txtAlarmMin.getText().substring(0, 2));
				clockLogic.setAlarm(hours, minutes);
			}
		});
		btnSetAlarm.setBounds(194, 6, 102, 29);
		buttonPanel.add(btnSetAlarm);
		
		JButton btnCancelAlarm = new JButton("Cancel alarm");
		btnCancelAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clockLogic.clearAlarm();
			}
		});
		btnCancelAlarm.setBounds(295, 6, 117, 29);
		buttonPanel.add(btnCancelAlarm);
		
		btnSetAlarm.setToolTipText("Activates the alarm");
		btnCancelAlarm.setToolTipText("Cancels the alarm");
		txtAlarmHour.setToolTipText("Sets the alarm to run at the set time");
		
		txtAlarmMin = new JTextField();
		txtAlarmMin.setToolTipText("Sets the alarm to run at the set time");
		txtAlarmMin.setText("MM");
		txtAlarmMin.setHorizontalAlignment(SwingConstants.LEFT);
		txtAlarmMin.setColumns(10);
		txtAlarmMin.setBounds(121, 5, 39, 28);
		buttonPanel.add(txtAlarmMin);
		
	}
	
	public void setTimeOnLabel(int hour, int minute, int second){
		lblTime.setText(format(hour)+":"+format(minute));
		lblAlarmTime.setText(format(clockLogic.alarmHour)+":"+format(clockLogic.alarmMinute));
		lblAlarmSet.setVisible(clockLogic.alarmSet);
		lblAlarmTime.setVisible(clockLogic.alarmSet);
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
}
