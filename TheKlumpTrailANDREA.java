// Andrea Ecarma 
//  Presents The Klump Trail

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

class Scenario { // For the scenes
	private String scene;
	private String[] options = new String[4];
	
	public String getScene() {
		return scene;
	}
	public void setScene(String scene) {
		this.scene = scene;
	}
	
	public String[] getOptions() {
		return options;
	}
	public String getOptions(int a) {
		return options[a];
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	
	
	// getOptions(getScene(), 2)
	
	public Scenario(String scene, String[] options) { // Constructor
		setScene(scene);
		setOptions(options);
	}
	
	public String[] UpdateScenario(String a, String[] b) {
        if (a == "Intro") {
            b[0] = "AC/DC tank top, really short jorts, and flip flops";
            b[1] = "AC/DC t-shirt, jeans, and sneakers";
            b[2] = "His usual office clothes and shoes";
            b[3] = "";    
        }
        else if (a == "Situation2") {
        	 b[0] = "Grab some leftover pizza and Red Bull";
             b[1] = "Decide to stop by McD on the way to the venue";
             b[2] = "Skip breakfast because he wants a good spot";
             b[3] = "";   
        }
        else if (a == "Situation3") {
        	 b[0] = "Join in on the mosh pit";
             b[1] = "Ignore the mosh pit and continue to rock up front";
             b[2] = "Out of fear, call the police";
             b[3] = "";   
        }
        else if (a == "Situation3") {
       	 	b[0] = "Buys food for himself";
            b[1] = "Buy food for the whole family";
            b[2] = "He changes his mind after hearing that the ice cream machine is broken and they won’t let him fix it";
            b[3] = "";   
       }
		return b;
    }
    
    public void ChangeScene() {
    	if (getScene() == "Intro") {
    		setScene("Situation2");
    	} else if (getScene() == "Situation2") {
    		setScene("Situation3");
    	} else if (getScene() == "Situation3") {
    		setScene("Situation3");
    	}
        // setScene
        options = UpdateScenario(getScene(), options);
    }
}

/* class Button { // For the buttons
	private String buttonName;
	
	public String getButtonName() {
		return buttonName;
	}
	public void setButton(String buttonName) {
		this.buttonName = buttonName;
	}
	public Button(String buttonName) {
		setButton(buttonName);
	}
}
*/

class KlumpPanel extends JPanel { // Panel
	private String message;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font f = new Font("Helvetica",Font.PLAIN,22);
		g.setFont(f);
	}
	
}


class KlumpFrame extends JFrame implements ActionListener { // Frame
	private KlumpPanel kpan;
	private Component story;
	
	public void configureMenu() {
		JMenuBar bar = new JMenuBar(); // Create the Main menu bar
		JMenu mnuFile = new JMenu("File"); // Create the File tab

		JMenuItem miExit = new JMenuItem("Exit"); // Exit button within File tab
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // How a user will exit a program
			}
		});	
		mnuFile.add(miExit);
		bar.add(mnuFile);
		setJMenuBar(bar);
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
	
	public void configureUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,500,500);
		setTitle("The Klump Trail");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		//c.add(kpan,BorderLayout.CENTER);
		String[] test = new String[4];
		Scenario situation = new Scenario("Intro", test);
		situation.setScene("Intro");
		situation.UpdateScenario(situation.getScene(), situation.getOptions());
		
		// Set Panel areas and place them
		JPanel panRight = new JPanel(new GridLayout(3,1));
		JPanel panCenter = new JPanel();
		JPanel panSouth = new JPanel(new FlowLayout());
		c.add(panRight, BorderLayout.EAST);
		c.add(panCenter, BorderLayout.CENTER);
		c.add(panSouth, BorderLayout.SOUTH);
		panSouth.setLayout(new BorderLayout());
		panSouth.setPreferredSize(new Dimension(300,150));
		
		JLabel lblStory = new JLabel();
		lblStory.setText("The year is 2020 and summer vacation has just started.\n "
				+ "Despite that, Dr. Klump has woken up at 7:00 am and exclaimed \n"
				+ "“I can’t wait to go to this ACDC concert at 10 in the morning!\n "
				+ "I wonder what I should wear?”");
		
		
		// Declare your buttons
		JButton btnOPT1 = new JButton();
		btnOPT1.setText(situation.getOptions(0));
		
		btnOPT1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				situation.ChangeScene();
				System.out.println(situation.getScene());
				situation.UpdateScenario(situation.getScene(), situation.getOptions());
				btnOPT1.setText(situation.getOptions(0));
				repaint();
			}
		});
		
		JButton btnOPT2 = new JButton();
		btnOPT2.setText(situation.getOptions(1));
		btnOPT2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				situation.ChangeScene();
				System.out.println(situation.getScene());
				situation.UpdateScenario(situation.getScene(), situation.getOptions());
				btnOPT2.setText(situation.getOptions(1));
				repaint();
			}
		});
		
		JButton btnOPT3 = new JButton();
		btnOPT3.setText(situation.getOptions(2));
		btnOPT3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				situation.ChangeScene();
				System.out.println(situation.getScene());
				situation.UpdateScenario(situation.getScene(), situation.getOptions());
				btnOPT3.setText(situation.getOptions(2));
				repaint();
			}
		});
		
		/*
		btnOPT1.setText("Option 1"); //TEMP NAME
		btnOPT2.setText("Option 2"); //TEMP NAME
		btnOPT3.setText("Option 3"); //TEMP NAME
		*/
		
		panRight.add(btnOPT1);
		panRight.add(btnOPT2);
		panRight.add(btnOPT3);
		
		panSouth.add(lblStory);
		configureMenu();
	}
	
	public KlumpFrame() {
		configureUI();
	}
}

public class TheKlumpTrailANDREA {
	public static void main(String[] args) {
		/*
		String[] test = new String[4];
		Scenario situation = new Scenario("Intro", test);
		situation.setScene("Intro");
		situation.UpdateScenario(situation.getScene(), situation.getOptions());
		*/
		KlumpFrame kfrm = new KlumpFrame();
		kfrm.setVisible(true);
	}
}
