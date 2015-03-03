import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class HumanDogGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtDogname;
	private JTextField txtInfo;
	private JTextField txtError;

	private Human human;
	public Dog dog;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HumanDogGUI frame = new HumanDogGUI();
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
	public HumanDogGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHumansAndDogs = new JLabel("Humans and Dogs");
		lblHumansAndDogs.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblHumansAndDogs.setHorizontalAlignment(SwingConstants.CENTER);
		lblHumansAndDogs.setBounds(106, 11, 242, 38);
		contentPane.add(lblHumansAndDogs);
		
		txtName = new JTextField();
		txtName.setText("HumanName");
		txtName.setBounds(225, 61, 134, 28);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtDogname = new JTextField();
		txtDogname.setText("DogName");
		txtDogname.setBounds(225, 92, 134, 28);
		contentPane.add(txtDogname);
		txtDogname.setColumns(10);
		
		JButton btnNewHuman = new JButton("New Human");
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtName.getText().length() > 2){
					human = new Human(txtName.getText());
				} else {
					txtError.setText("Too few letters!");
				}
			}
		});
		btnNewHuman.setBounds(96, 61, 117, 29);
		contentPane.add(btnNewHuman);
		
		JButton btnBuyDog = new JButton("Buy Dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(human != null){
					dog = new Dog(txtDogname.getText());
					human.buyDog(dog);
				} else {
					txtError.setText("No owner");
				}
			}
		});
		btnBuyDog.setBounds(96, 93, 117, 29);
		contentPane.add(btnBuyDog);
		
		JPanel panel = new JPanel();
		panel.setBounds(41, 164, 365, 49);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		txtInfo = new JTextField();
		txtInfo.setText("Info");
		panel.add(txtInfo, BorderLayout.CENTER);
		txtInfo.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(40, 220, 366, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		txtError = new JTextField();
		txtError.setText("Error messages");
		panel_1.add(txtError, BorderLayout.CENTER);
		txtError.setColumns(10);
		
		JButton btnPrintInfo = new JButton("Print Info");
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(human != null){
					txtInfo.setText(human.getInfo());
				}
			}
		});
		btnPrintInfo.setBounds(160, 132, 117, 29);
		contentPane.add(btnPrintInfo);
	}
}
