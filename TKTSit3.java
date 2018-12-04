/*
                        The Klump Trail
Created by Brendan Cagampang, Andrea Ecarma, Edgar Flores, and Mike Palermo.

These were the tasks assigned:
Brendan - Situation 3
Andrea - 
Edgar - 
Mike - Siatuation 1

The purpose of this project is to make Dr. Klump either laugh or cry. That is all.

This is a clicking game, so the user just needs to click Next and sometimes select an option.


*/

package tktsit3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Sit3 {
    private String sit3Text;
    public String getSit3Text() {
        return sit3Text;
    }
    public void setSit3Text(String sit3Text) {
        this.sit3Text = sit3Text;
    }
    public void paintComponent(Graphics g) {
        paintComponent(g);
        g.drawString(sit3Text, 100, 100);
    }
    public Sit3(String sit3Text) {
        setSit3Text(sit3Text);
    }
}
class SitPan3 extends JPanel {
    public SitPan3() {};
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font f = new Font("Helvetica", Font.PLAIN,22);
        g.setFont(f);
        g.drawString("Dr. Klump has now arrived at the venue and is very excited!",200,200);
    }
}

class KlumpFrame extends JFrame implements ActionListener{
    private Sit3 sit3Text;
    
    public void actionPerformed(ActionEvent e) {
        e.getSource();
    }
    public void configureMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnuFile.add(miExit);
        JMenuItem miNG = new JMenuItem("New Game");
        mnuFile.add(miNG);
        bar.add(mnuFile);
        setJMenuBar(bar);
        
    }
    public void configureUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(10,10,1000,1000);
        setTitle("The Klump Trail v0.1");
        configureMenu();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panRight = new JPanel(new GridLayout(3,1));
        JPanel panSouth = new JPanel(new FlowLayout());
        JPanel panCenter = new JPanel();
        JButton btn3_1 = new JButton();
        JButton btn3_2 = new JButton();
        JButton btn3_3 = new JButton();
        btn3_1.setText("Join the mosh pit");
        btn3_2.setText("Ignore the mosh pit");
        btn3_3.setText("Call the police");
        panRight.add(btn3_1);
        panRight.add(btn3_2);
        panRight.add(btn3_3);
        c.add(panRight, BorderLayout.EAST);
        c.add(panSouth, BorderLayout.SOUTH);
        c.add(panCenter, BorderLayout.CENTER);
        SitPan3 sp3 = new SitPan3();
        c.add(sp3, BorderLayout.SOUTH);
        sp3.setPreferredSize(new Dimension(300,150));
        
        btn3_1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        sit3Text.setSit3Text(String.format(
                                "�LET�S FUCKING GOOOOOO� exclaims Dr. Klump, as "
                                        + "he flails his arms and legs around, hitting "
                                        + "various people, even knocking some out cold.",
                                null));
                        btn3_2.setEnabled(false);
                        btn3_3.setEnabled(false);
                        repaint();
                    }
                }
        );
        btn3_2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        sit3Text.setSit3Text(String.format(
                                "Dr. Klump ignores the youngsters and continues to rock on"
                                        + " at the front of the stage. Angus Young sees him"
                                        + " up front enjoying their set, so he shines a light"
                                        + " on him, points, and says �YOU! You don�t have much"
                                        + " time left, so get up here and join us!� Not knowing"
                                        + " whether to be happy or sad about that statement, he "
                                        + "gets on stage and spends the rest of the day with the band.",
                                null));
                        btn3_1.setEnabled(false);
                        btn3_3.setEnabled(false);
                        repaint();
                    }
                }
        );
        btn3_3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        sit3Text.setSit3Text(String.format(
                                "�Dr. Klump fears for his life and decides to call the police. �There�s a "
                                        + "mosh pit starting up and I�m scared. Please stop them!� One of "
                                        + "the teens in the mosh pit sees this and yells �HE�S CALLING THE "
                                        + "COPS, GET HIS ASS!� The pit gathers around Klump, waits for the"
                                        + " drop, and then tramples him to death. END",
                                null));
                        btn3_1.setEnabled(false);
                        btn3_2.setEnabled(false);
                        repaint();
                    }
                }
        );
        
    }
    public KlumpFrame() {
        configureUI();
    }
}

// MAIN CODE - MAIN CODE - MAIN CODE - MAIN CODE - MAIN CODE - MAIN CODE - MAIN CODE - MAIN CODE - MAIN CODE - MAIN CODE
public class TKTSit3 {
    public static void main(String[] args) {
        KlumpFrame kfrm = new KlumpFrame();
        kfrm.setVisible(true);
    }
}
