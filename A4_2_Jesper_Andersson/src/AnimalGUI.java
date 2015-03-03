import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class AnimalGUI extends JFrame {

	private JPanel contentPane;
	private static ArrayList<Animal> animals = new ArrayList<Animal>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		createAnimals();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalGUI frame = new AnimalGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void createAnimals() {
		animals.add(new Cat("Lynx",5,9));
		animals.add(new Dog("FidosDoggus",3,true,"Byrackan"));
		animals.add(new Snake("Slinke-Slang",true));
		animals.add(new Dog("Vargus-Kargus",3,false,"Luffsen"));
		animals.add(new Snake("OrmusFulus",false));
		animals.add(new Cat("Kisse-Missen",4,2));
	}

	/**
	 * Create the frame.
	 */
	public AnimalGUI() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblAnimallist = new JLabel("Animal list");
		contentPane.add(lblAnimallist, BorderLayout.NORTH);
		
		JTextArea txtrSet = new JTextArea();
		contentPane.add(txtrSet, BorderLayout.CENTER);
		
		txtrSet.setText(writeAnimalInfo());
		
	}
	
	public String writeAnimalInfo(){
		String allInfo = "";
		for(int i = 0; i < animals.size(); i++){
			allInfo += animals.get(i).getInfo()+"\n";
		}
		return allInfo;
	}
}
