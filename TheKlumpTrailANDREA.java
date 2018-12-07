
/*
                        The Klump Trail
Created by Brendan Cagampang, Andrea Ecarma, Edgar Flores, and Mike Palermo.

These were the tasks assigned:
Brendan - Situation 3
Andrea - Situation 4
Edgar - Situation 2
Mike - Siatuation 1

The purpose of this project is to make Dr. Klump either laugh or cry. That is all.

This is a clicking game, so the user just needs to click Next and sometimes select an option.

*/

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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

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
        // JButton accepts HTML formatting, so I used it here so the button doesn't stretch out too far
        if (a == "Intro") {
            b[0] = "AC/DC tank top, really short jorts, and flip flops";
            b[1] = "AC/DC t-shirt, jeans, and sneakers";
            b[2] = "His usual office clothes and shoes";
            b[3] = "<html>The year is 2020 and summer vacation has just started. Despite that, Dr. Klump has"
                    + "woken up at 7:00 am and exclaimed \" I can't wait to go to this ACDC concert at 10"
                    + "in the morning! I wonder what I should wear?\" </html>"; 
        }
        else if (a == "Situation2") {
            b[0] = "Grab some leftover pizza and Red Bull";
            b[1] = "Decide to stop by McD on the way to the venue";
            b[2] = "Skip breakfast because he wants a good spot";
            b[3] = "<html>"
                    + "Dr. Klump gets dressed, takes a look in the mirror, and says to himself"
                    + "\"Wow, who's that stud in the mirror? Oh wait, THAT'S ME! EHEHEHE!\""
                    + "His wife, who's sitting up in bed watching him laugh to himself, just stares at him, "
                    + "probably wondering why heâ€™s always like this. Dr. Klump notices this in the mirror, "
                    + "turns around, stares at his wife for a good minute with no expression and without saying "
                    + "a word, and walks out of the room." 
                    + "He gets to the empty living room and sees that it's already 8:00 and that "
                    + "it takes about an hour and a half to get to the venue. \" Aw shit son, I gotta "
                    + "get going soon if I want a good place in line!" + 
                    "</html>";   
        }
        else if (a == "Situation3") {
            b[0] = "Join in on the mosh pit";
            b[1] = "Ignore the mosh pit and continue to rock up front";
            b[2] = "Out of fear, call the police";
            b[3] = "<html>Dr. Klump has now arrived at the venue and is very excited! He waits in line, head-banging to the music in his head. " 
                    +  "Dr. Klump gets in with a bunch of millennials and soaks in the environment. Expensive beer and food, cover band playing "
                    + "their set, and no one enjoying the current music. He sits patiently in the corner of the venue waiting for the \"best\" band"
                    + "on Earth to come on stage. He passes the time by playing Candy Crush on his phone." 
                    + "Suddenly, the sound cuts off and the voice of Angus Young fills the air. \"HEY FUCKERS, ARE YOU READY TO THUNDERSTUCK?!?!?!\" "
                    + "Klump gets up and screams at the top of his lungs \"FUCK YEAH!!! THUNDERRRR!\" He runs up to the front of the crowd and has "
                    + "a great time with his fellow millennials. "
                    + "A mosh pit starts forming behind Dr. Klump. </html>";   
        }
        else if (a == "Situation4") {
            b[0] = "Buys food for himself";
            b[1] = "Buy food for the whole family";
            b[2] = "<html><center>He changes his mind after hearing that the ice cream <br />"
                    + "machine is broken and they won't let him fix it</center></html>";
            
            // TEMP ENDING FOR NOOOOOOOOOOOOOOOOOOOW
            b[3] = "<html>The time is now 10 pm and the concert has finally ended.<br />" 
                    + "Dr. Klump heads back to his car after an amazing night.<br />" 
                    + "He gets in his car and heads through the McDonalds drive thru.<br />" 
                    + "The guy working the drive thru tells him Klump that the ice cream machine is broken."
                    + "\"Oh, is that the case? I'm an Electrical Engineer and a software GOD. Let me come in and fix "
                    + "that shit for you guys.\" \"m sorry sir, we can't let you do that.\" \"NO, I WANT MY ICE CREAM!\""
                    + " \"I'm so sorry sir, I'm gonna have to ask you to leave this drive thru.\" \"You know what, FINE. "
                    + "I make ice cream better than this junk anyway. I'm outtie.\" Dr. Klump leaves the drive thru and, on "
                    + "his way out, sees Andrea, a college dropout, sitting on the curb in the parking lot. Dr. Klump "
                    + "decides to park and go talk to her. â€œHey Drea, how you doing? I heard you dropped out 2 years ago.â€?  "
                    + "Oh, I'm doing alright, just out here starving. Hey, I give people tattoos now as my job. How about "
                    + "I give you a tattoo of whatever you want and you pay me by getting me some food?\" \"Sure, sounds good. "
                    + "I want an AC/DC on my face. AC on my right cheek, the slash across my nose, and DC on the left.\""
                    + " \"Uhhhhh are you sure?\" \"Yeah, I just saw them live today and I'm feeling really good.\" "
                    + " ...\"Alright, if you say so.\" Andrea pulls out her rusty tattoo kit, which includes expired ink, "
                    + "and gets to work. Dr. Klump doesn't notice because it's dimly lit. After the tattoo is finished, "
                    + "he heads inside McDonalds to see the masterpiece in the bathroom. When he looks in the mirror, "
                    + "he sees the disgusting job that has just been done on his face. \"Oh GAWD! It's... It's...\" "
                    + "He proceeds to cry and succumbs to depression, gets tetanus, and septic shock. He dies on the spot. END</html>";
        } else if (a == "Situation5") {
              b[0] = "Thanks";
              b[1] = "for";
              b[2] = "PLAYINGGGGGG :D :D :D :D";
              // Thanks for playing!!
              b[3] = "<html>Thanks for playing The Klump Trail. This was created by Brendan Cagampang, Andrea Ecarma, Edgar Flores, and Mike Palermo. <br />"
                    + "sry u dieded :c </html>";
        }
        return b;
        }
    
    public void ChangeScene() {
        if (getScene() == "Intro") {
            setScene("Situation2");
        } else if (getScene() == "Situation2") {
            setScene("Situation3");
        } else if (getScene() == "Situation3") {
            setScene("Situation4");
        } else if (getScene() == "Situation4") {
            setScene("Situation5");
        }
        // setScene
        
        UpdateScenario(getScene(), options);
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
    private Scenario situation;

    public void configureMenu() {
        JMenuBar bar = new JMenuBar(); // Create the Main menu bar
        JMenu mnuFile = new JMenu("File"); // Create the File tab

        JMenuItem miExit = new JMenuItem("Exit"); // Exit button within File tab
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // How user will exit a program
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
        setBounds(50,50,1000,1000);
        setTitle("The Klump Trail");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        String[] test = new String[4];
        situation = new Scenario("Intro", test);
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
        panSouth.setPreferredSize(new Dimension(300,250));
        
        // Declare a label for the Dialogue
        JLabel lblStory = new JLabel();
        lblStory.setText(situation.getOptions(3));

        // Declare your buttons
        JButton btn1 = new JButton();
        JButton btn2 = new JButton();
        JButton btn3 = new JButton();
        btn1.setText(situation.getOptions(0));

        btn1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        situation.ChangeScene();
                        System.out.println(situation.getScene());
                        situation.UpdateScenario(situation.getScene(), situation.getOptions());
                        btn1.setText(situation.getOptions(0));
                        btn2.setText(situation.getOptions(1));
                        btn3.setText(situation.getOptions(2));
                        lblStory.setText(situation.getOptions(3));
                        repaint();
                }
        });

        btn2.setText(situation.getOptions(1));
        btn2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        situation.ChangeScene();
                        System.out.println(situation.getScene());
                        situation.UpdateScenario(situation.getScene(), situation.getOptions());
                        btn1.setText(situation.getOptions(0));
                        btn2.setText(situation.getOptions(1));
                        btn3.setText(situation.getOptions(2));
                        lblStory.setText(situation.getOptions(3));
                        repaint();
                }
        });

        btn3.setText(situation.getOptions(2));
        btn3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        situation.ChangeScene();
                        System.out.println(situation.getScene());
                        situation.UpdateScenario(situation.getScene(), situation.getOptions());
                        btn1.setText(situation.getOptions(0));
                        btn2.setText(situation.getOptions(1));
                        btn3.setText(situation.getOptions(2));
                        lblStory.setText(situation.getOptions(3));
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

class ScenarioIOController {  // controller class for "write points to file" use case
	private Scenario situation;
	
	public boolean writePointsToTextFile(ArrayList<Scenario> scenarios, String fname) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(
				new FileWriter(new File(fname))));
			for (Scenario s : scenarios) {
				pw.println(s);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
		public ArrayList<Scenario> readPointsFromTextFile(String fname) {
			try {
				Scanner sc = new Scanner(new File(fname));
				ArrayList<Scenario> scenarios= new ArrayList<Scenario>();
				String line;
				String[] parts;
				while (sc.hasNextLine()) {
					line = sc.nextLine();
					line = line.trim();
					parts = line.split(" ");
					scenarios.add(new Scenario(parts[0], parts));
				}
				sc.close();
				return scenarios;
			} catch (Exception ex) {
				return null;
			}
		}

	}


public class TheKlumpTrailANDREA implements Serializable {
    public static void main(String[] args) {
        KlumpFrame kfrm = new KlumpFrame();
        ArrayList<Scenario> scenarios = new ArrayList<Scenario>();
        kfrm.configureMenu();
        kfrm.configureUI();
        kfrm.setVisible(true);
        ScenarioIOController sioc = new ScenarioIOController();
        sioc.writePointsToTextFile(scenarios,"situation.txt");
    }
}

