// Andrea Ecarma 
//  Presents The Klump Trail

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
        else if (a == "Situation 2") {
            b[0] = "Grab some leftover pizza and Red Bull";
            b[1] = "Decide to stop by McD on the way to the venue";
            b[2] = "Skip breakfast because he wants a good spot";
            b[3] = "";   
        }
        else if (a == "Situation 3") {
            b[0] = "Join in on the mosh pit";
            b[1] = "Ignore the mosh pit and continue to rock up front";
            b[2] = "Out of fear, call the police";
            b[3] = "";   
        }
        else if (a == "Situation 4") {
            b[0] = "Buys food for himself";
            b[1] = "Buy food for the whole family";
            // JButton accepts HTML formatting, so I used it here so the button doesn't stretch out too far
            b[2] = "<html><center>He changes his mind after hearing that the ice cream<br />"
                    + "machine is broken and they won't let him fix it</center></html>";
            b[3] = "";
        }
        return b;
    }
    
    public void ChangeScene() {
    	if (getScene() == "Intro") {
            setScene("Situation 2");
    	} else if (getScene() == "Situation 2") {
            setScene("Situation 3");
    	} else if (getScene() == "Situation 3") {
            setScene("Situation 4");
    	}
        // setScene
        options = UpdateScenario(getScene(), options);
    }
}

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
            setBounds(100,100,1000,1000);
            setTitle("The Klump Trail");
            Container c = getContentPane();
            c.setLayout(new BorderLayout());
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
            JButton btn1 = new JButton();
            btn1.setText(situation.getOptions(0));	
            btn1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    situation.ChangeScene();
                    System.out.println(situation.getScene());
                    situation.UpdateScenario(situation.getScene(), situation.getOptions());
                    btn1.setText(situation.getOptions(0));
                    repaint();
		}
            });
		
            JButton btn2 = new JButton();
            btn2.setText(situation.getOptions(1));
            btn2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    situation.ChangeScene();
                    System.out.println(situation.getScene());
                    situation.UpdateScenario(situation.getScene(), situation.getOptions());
                    btn2.setText(situation.getOptions(1));
                    repaint();
		}
            });
		
            JButton btn3 = new JButton();
            btn3.setText(situation.getOptions(2));
            btn3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    situation.ChangeScene();
                    System.out.println(situation.getScene());
                    situation.UpdateScenario(situation.getScene(), situation.getOptions());
                    btn3.setText(situation.getOptions(2));
                    repaint();
		}
            });
            panRight.add(btn1);
            panRight.add(btn2);
            panRight.add(btn3);
            panSouth.add(lblStory);
            configureMenu();
	}
	public KlumpFrame() {
            configureUI();
	}
}

public class TheKlumpTrailANDREA {
	public static void main(String[] args) {
		KlumpFrame kfrm = new KlumpFrame();
		kfrm.setVisible(true);
	}
}
