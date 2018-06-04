import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.BorderLayout;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class Main {
	private JFrame frame;
	
	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the application.
	public Main() {
		initialize();
	}

	//Presentation deceleration of GUI elements.
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 200, 116);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//FileBrowse Action Listener
		JButton btnFileBrowse = new JButton("File Browse");
		frame.getContentPane().add(btnFileBrowse);

		JButton btnSolve = new JButton("Solve Maze");
		btnSolve.setEnabled(false);
		
		//Call solve class with btnSolve actionlistener
		btnSolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				solveClass.solve();	
			}
		});
		frame.getContentPane().add(btnSolve);
		
		//File calling from Filechooser
		btnFileBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openFile myobj = new openFile();			
				try {
					myobj.pick_me();	
				} catch(Exception e) {
					e.printStackTrace();
				}
				btnSolve.setEnabled(true);
			}

		});
	}



}


