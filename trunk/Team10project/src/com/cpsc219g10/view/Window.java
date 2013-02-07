package com.cpsc219g10.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class Window extends JFrame{

	private JMenuBar menu = null;
	private JMenu file = null;
	private JMenuItem newgame = null;
	private JMenuItem score = null;
	private JMenuItem quit = null;
	private JMenu about = null;
	private JMenuItem about2 = null;
	private JMenuItem rules = null;
	private JPanel conteneur = new JPanel();
	private Dimension size;
	
	public Window(){
		this.setTitle("Battleship Game");
	    this.setSize(900, 600);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    
	    this.size = new Dimension(this.getWidth(), this.getHeight());
	    
	    menu = new JMenuBar();

	    file = new JMenu("File");
	    file.setMnemonic('f');
	    
	    newgame = new JMenuItem("New");
	    newgame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
	                                                  InputEvent.CTRL_MASK));
	    newgame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				conteneur.removeAll();
				//GamePanel gp = new GamePanel(size, model);
				//model.addObserver(gp);
				//conteneur.add(gp.getPanel(), BorderLayout.CENTER);
				//conteneur.revalidate();
				//initModel();
			}	    	
	    });
	    
	    score = new JMenuItem("Score");
	    score.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
	                                                KeyEvent.CTRL_MASK));
    score.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			conteneur.removeAll();
			
		}
    });

	    quit = new JMenuItem("Quitter");
	    quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
	                                                  KeyEvent.CTRL_MASK));
	    quit.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		System.exit(0);
	    	}
	    });

	    file.add(newgame);
	    file.add(score);
	    file.addSeparator();
	    file.add(quit);

	    about = new JMenu("� about");
	    about.setMnemonic('o');
	    

	    rules = new JMenuItem("Rules of the game");
	    rules.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				conteneur.removeAll();
				conteneur.add(new RulesPanel(size).getPanel(), BorderLayout.CENTER);
				conteneur.revalidate();
				//model.reset();
			}	    	
	    });

	    about2 = new JMenuItem("   ?   ");
	    about2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		JOptionPane.showMessageDialog(null,
							    		          "Creator : Remy\nLicence : Freeware\nCopyright : remy@gvr.re",
							    		          "Informations", JOptionPane.NO_OPTION);
	    		conteneur.removeAll();
	    		conteneur.add(new HomePanel(size).getPanel());
	    		conteneur.revalidate();
	    		//model.reset();
	    	}
	    });

	    about.add(rules);
	    about.add(about2);

	    menu.add(file);
	    menu.add(about);
	    
	    this.conteneur.setPreferredSize(this.size);
	    this.conteneur.setBackground(Color.white);
	    this.conteneur.add(new HomePanel(this.size).getPanel());
	    this.setContentPane(this.conteneur);
	    
	    this.setJMenuBar(menu);
	    
	    
	}
}
