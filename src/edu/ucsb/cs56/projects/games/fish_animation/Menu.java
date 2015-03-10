package edu.ucsb.cs56.projects.games.fish_animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.net.*;

/**
   Implements a GUI that allows the user to choose diffculty,
   find instructions, or exit the menu.

   @author Casey Barbello
   @author Daryl Pham
   @author Jenna Cryan
   @author Josephine Vo
   @author Felicia Truong
   @author Jazarie Thach
   @version for CS56, Winter 14, UCSB
*/

class Menu implements ActionListener {
    JButton Play, Instruction, Exit, Character, Selection, Jessica, Martha, Teresa, Resume, Easy, Medium, Hard, Back, Menu;
    JFrame frame, instruct;
    int type;
    JTextArea text;
    JLabel textLabel;
	int sharkType;    
	
    public static void main (String[] args) {
	Menu menu = new Menu();
	menu.makegui();
    }
    
    /**
       Main GUI interface for the first section of the Menu.  
       Allows for user to select exit, play, or instruction.
    */
    public void makegui () {
	frame = new JFrame();
	frame.setSize(800, 600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//Adds the different buttons to the menu
	Play = new JButton("Play Game");
	Instruction = new JButton("Instructions");
	Exit = new JButton("Exit");
	
	//Sets the size of the buttons
	Play.setPreferredSize(new Dimension(200, 75));
	Instruction.setPreferredSize(new Dimension(200, 75));
	Exit.setPreferredSize(new Dimension(200, 75));
	
	//Adds the action listeners to the buttons
	Play.addActionListener(this);
	Instruction.addActionListener(this);
	Exit.addActionListener(this);
	URL bgURL = getClass().getResource("/resources/mainbg.png");
   	ImageIcon bgIM = new ImageIcon(new ImageIcon(bgURL).getImage());
   	JLabel label = new JLabel(bgIM);
   	frame.setContentPane(label);
   	frame.setLayout(new GridBagLayout());
   	
	//Sets up the layout of the GUI
	frame.getContentPane().add(Play);
	frame.getContentPane().add(Instruction);
	frame.getContentPane().add(Exit);
	frame.setSize(800, 600);
	frame.setVisible(true);
    }
    
    public void setCharacter () {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    URL jessicaURL = getClass().getResource("/resources/1.png");
	ImageIcon jessicaIM = new ImageIcon(new ImageIcon(jessicaURL).getImage());
    
    URL marthaURL = getClass().getResource("/resources/2.png");
	ImageIcon marthaIM = new ImageIcon(new ImageIcon(marthaURL).getImage());
	
	URL teresaURL = getClass().getResource("/resources/3.png");
	ImageIcon teresaIM = new ImageIcon(new ImageIcon(teresaURL).getImage());
	
	Jessica = new JButton();
	Martha = new JButton();
	Teresa = new JButton();
	
	Jessica.setIcon(jessicaIM);
	Martha.setIcon(marthaIM);
	Teresa.setIcon(teresaIM);
	
	Jessica.setText("Jessica");
	Martha.setText("Martha");
	Teresa.setText("Teresa");
	Jessica.setPreferredSize(new Dimension(225, 250));
	Martha.setPreferredSize(new Dimension(225, 250));
	Teresa.setPreferredSize(new Dimension(225, 250));
	
	Jessica.addActionListener(this);
	Martha.addActionListener(this);
	Teresa.addActionListener(this);
	
	Jessica.setHorizontalTextPosition(JButton.CENTER);
	Martha.setHorizontalTextPosition(JButton.CENTER);
	Teresa.setHorizontalTextPosition(JButton.CENTER);
	
	Jessica.setVerticalTextPosition(JButton.BOTTOM);
	Martha.setVerticalTextPosition(JButton.BOTTOM);
	Teresa.setVerticalTextPosition(JButton.BOTTOM);
	
	Jessica.setFont(new Font("Corsiva Hebrew", Font.BOLD, 20));
	Martha.setFont(new Font("Corsiva Hebrew", Font.BOLD, 20));
	Teresa.setFont(new Font("Corsiva Hebrew", Font.BOLD, 20));
    frame.getContentPane().add(Jessica);
    frame.getContentPane().add(Martha);
    frame.getContentPane().add(Teresa);
    frame.setSize(800, 600);
	frame.setVisible(true);
    }
    /**
       GUI section that allows for user to select difficulty level
     */
    public void setDifficulty () {

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//JPanel panel = new JPanel();
	//frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
	//frame.setLayout(new BorderLayout());
	
	//Adds the different difficulty buttons
	Selection = new JButton("Back");
	Easy = new JButton("Easy");
	Medium = new JButton("Medium");
	Hard = new JButton("Hard");
	Resume = new JButton("Resume Game");
	
	//Sets the size of the buttons
	frame.getContentPane().add(Selection);
	frame.getContentPane().add(Easy);
	frame.getContentPane().add(Medium);
	frame.getContentPane().add(Hard);
	frame.getContentPane().add(Resume);
	
	//Gives the buttons actionlisteners
	Selection.addActionListener(this);
	Easy.addActionListener(this);
	Medium.addActionListener(this);
	Hard.addActionListener(this);
	Resume.addActionListener(this);

	//Puts the buttons onto the frame in BorderLayout format
	frame.getContentPane().add(Selection);
	frame.getContentPane().add(Easy);
	frame.getContentPane().add(Medium);
	frame.getContentPane().add(Hard);
	frame.getContentPane().add(Resume);
	frame.setSize(800, 600);
	frame.setVisible(true);
    }
    
    /**
       GUI that shows the user how to play the game.  Provides
       instructions and a description of the game overall.
    */
    public void HowToPlay() {
	
	//Creates new frame for the new menu that will pop up
	instruct = new JFrame();
	instruct.setSize(300, 300);
	
	//Creates text label for instructions
	textLabel = new JLabel();
	textLabel.setText("<html><p>Hello! The goal of the game is to eat as many fish as you can. "
			  + "There's no time limit, but watch out! Jellyfish are out to get you! "
			  + "If you eat the jellyfish, you'll lose points! "
			  + "If you get too many negative points, you lose :( "
			  + "To eat the fish, click on the shark and hold down the mouse button to move your shark's mouth to the fish. "
			  + "There are three different difficulties, so test your skills on all of them! Good eating!</p></html>");

	//Adds button to the instruction popup
	Back = new JButton("Menu");
	
	//Adds action listener to the button to go back to the mainmenu
	Back.addActionListener(this);
	Back.setPreferredSize(new Dimension(150, 75));
	
	//Adds the layout for the button and the textArea
	instruct.getContentPane().add(textLabel);
	instruct.getContentPane().add(Back);
	instruct.setVisible(true);
    }
    
    
    /** 
	Method that takes in Mouse actions and converts them into
	actions that the program will perform. The actions performed 
	will occur when any of the buttons are pressed.  
    */
    
    public void actionPerformed(ActionEvent event) {
	if(event.getSource() == Easy) {
	    frame.setVisible(false);
	    FishAnimationEnvironment f = new FishAnimationEnvironment(3, sharkType, false);
	}
	if(event.getSource() == Medium) {
	    frame.setVisible(false);
	    FishAnimationEnvironment f = new FishAnimationEnvironment(7, sharkType, false);
	}
	if(event.getSource() == Hard) {
	    frame.setVisible(false);
	    FishAnimationEnvironment f = new FishAnimationEnvironment(14, sharkType, false);
	}
	if(event.getSource() == Resume) {
	    frame.setVisible(false);
	    FishAnimationEnvironment f = new FishAnimationEnvironment(0, sharkType, true);
	}
	if(event.getSource() == Play) {
	    frame.remove(Play);
	    frame.remove(Instruction);
	    frame.remove(Exit);
	    setCharacter();
	    
	}
	if(event.getSource() == Exit) {
	    System.exit(0);
	}
	if(event.getSource() == Instruction) {
	    frame.remove(Play);
	    frame.remove(Instruction);
	    frame.remove(Exit);
	    frame.setVisible(false);
	    HowToPlay();
	}
	if(event.getSource() == Back) {
	    instruct.remove(Back);
	    instruct.remove(textLabel);
	    instruct.setVisible(false);
	    makegui();
	}
	if(event.getSource() == Selection) {
	    frame.remove(Selection);
	    frame.remove(Easy);
	    frame.remove(Medium);
	    frame.remove(Hard);
	    frame.remove(Resume);
	    frame.setVisible(false);
	    setCharacter();
	}
	if(event.getSource() == Character) {
	   	frame.remove(Jessica);
		frame.remove(Martha);
		frame.remove(Teresa);
		frame.setVisible(false);
	   	setCharacter();
	}
	if(event.getSource() == Jessica){
		frame.remove(Jessica);
		frame.remove(Martha);
		frame.remove(Teresa);
		frame.setVisible(false);
		sharkType = 1;
		setDifficulty();
    }
    if(event.getSource() == Martha){
		frame.remove(Jessica);
		frame.remove(Martha);
		frame.remove(Teresa);
		frame.setVisible(false);
		sharkType = 2;
		setDifficulty();
    }
    if(event.getSource() == Teresa){
		frame.remove(Jessica);
		frame.remove(Martha);
		frame.remove(Teresa);
		frame.setVisible(false);
		sharkType = 3;
		setDifficulty();
    }
}
}

