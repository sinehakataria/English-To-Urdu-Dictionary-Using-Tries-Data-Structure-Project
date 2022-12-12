/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semester.project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.BorderFactory;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JPopupMenu;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import java.awt.Insets;
import java.awt.*;
import java.awt.Canvas;
import java.awt.Panel;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.*;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import org.apache.commons.lang3.*;
import javax.swing.JFormattedTextField;
import java.awt.ComponentOrientation;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;;


public class UserInterface {
	public Tries loadDict()
	{
		BufferedReader br ;
		Tries t = new Tries() ;
		try
		{
			InputStreamReader isr = new InputStreamReader(new FileInputStream("DictionaryData.txt" ), "UTF-8");
			br = new BufferedReader(isr) ;
			String line = br.readLine() ;
			
			while(line != null)
			{
				line = org.apache.commons.lang3.StringEscapeUtils.unescapeJava(line);

				String token[] =  line.split("^\\S+") ;
				String token1[] = line.split("\\W+") ;
				if(token.length>=2 && token1.length >= 1) 
				{
					String row[] = {token1[0] , token[1]} ;
					t.insert(token1[0] , token[1]);
					model.addRow(row);
				}  
				
				line = br.readLine() ;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return t ;
	}
        private JLabel msg;
	private JFrame HomeFrame;
        private JFrame frame;
	private JTextField SearchText;
	private Tries dict ;
	private JTable table_1;
	private DefaultTableModel model;
	private JLabel autoRes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.HomeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
		dict = loadDict() ;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HomeFrame = new JFrame();
		HomeFrame.setResizable(false);
		HomeFrame.getContentPane().setBackground(Color.black);
		SearchText = new JTextField();
                SearchText.setPreferredSize(new Dimension(50,27));
                //Container c = HomeFrame.getContentPane();
                HomeFrame.setLayout(new FlowLayout());
                JButton SearchButton = new JButton("Search");
                SearchButton.setPreferredSize(new Dimension(90,29));
		JPanel SerchButton = new JPanel();
		SerchButton.setBackground(SystemColor.activeCaptionBorder);
		msg  = new JLabel("English  To Urdu Dictionary",JLabel.CENTER);
                msg.setBounds(200,35,200, 200);
                msg.setFont(new Font("Serif", Font.PLAIN, 30));
                msg.setHorizontalTextPosition(SwingConstants.CENTER);
                //SearchButton.setBounds(350,100,100,25);
                JTextPane resultText = new JTextPane();
		resultText.setEditable(false);
//		resultText.setBackground(Color.gray);
//		resultText.setForeground(SystemColor.textHighlightText);
		resultText.setFont(new Font("Gadugi", Font.PLAIN, 18));
		resultText.setText("");
                resultText.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));
                autoRes = new JLabel();
		autoRes.setText("Type Something");
                JPanel p0 = new JPanel(new FlowLayout());
                p0.add(msg);
                p0.setBackground(Color.gray);
		JPanel p = new JPanel(new FlowLayout());
               p.setPreferredSize(new Dimension(100,50));
                p.add(SearchText);   p.add(SearchButton);
                p.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));
                p.setBackground(Color.YELLOW);
                JPanel p2 = new JPanel(new FlowLayout());
                  p2.setBackground(Color.WHITE);
                //p2.setPreferredSize(new Dimension(100,500));
                  p2.setPreferredSize(new Dimension(600,250));
                  resultText.setBounds(50,100,67,45);
                p2.add(autoRes);p2.add(resultText);
                JPanel pf = new JPanel(new BorderLayout(50,50));
                pf.setBackground(Color.black);
                pf.add(p0,BorderLayout.NORTH);
                pf.add(p,BorderLayout.CENTER);
                pf.add(p2,BorderLayout.SOUTH);
//                JLabel footer  = new JLabel();
//                footer.setText("Sineha Kataria");
//                footer.setPreferredSize(new Dimension(100,500));
                //pf.add(p2,BorderLayout.NORTH);
//                c.add(p,BorderLayout.CENTER);
//                c.add(SearchButton,BorderLayout.EAST);
//                c.add(autoRes,BorderLayout.SOUTH);
//               c.add(resultText);
               //HomeFrame.setLayout(new FlowLayout());
               HomeFrame.add(pf);
       
                //HomeFrame.add(p);  
		
		
		

		table_1 = new JTable();
		table_1.setIntercellSpacing(new Dimension(20, 300));
		table_1.setGridColor(new Color(51, 102, 102));
		
		table_1.setForeground(new Color(51, 102, 102));
		table_1.setFont(new Font("Arial Unicode MS", Font.BOLD, 13));
		table_1.setEnabled(false);
		table_1.setBackground(new Color(45, 102, 102));
		model = new DefaultTableModel() ;
		Object[] column = {} ;
		Object[] row = new Object[0];
		//model.setColumnIdentifiers(column);
		table_1.setModel(model);
		//scrollPane.setViewportView(table_1);
		table_1.setVisible(false);
		
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String find = SearchText.getText() ;
				resultText.setText(dict.search(find));
			}
		});
		SearchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				SearchButton.setBackground(new Color(49, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				SearchButton.setBackground(new Color(255, 51, 51));
			}
		});
		SearchButton.setToolTipText("Search a word\r\n");
		SearchButton.setBackground(new Color(255, 51, 51));
		SearchButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		
		SearchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				MyList a = dict.autoComplete(SearchText.getText()) ;
				autoRes.setText(a.toString());
			}
		});
		SearchText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String find = SearchText.getText() ;
				resultText.setText(dict.search(find));
			}
		});
		SearchText.setFont(new Font("Tahoma", Font.BOLD, 14));
		SearchText.setColumns(10);
		
		
		
		//HomeFrame.getContentPane().setLayout(groupLayout);
		HomeFrame.setBackground(new Color(255, 0, 0));
		HomeFrame.setTitle("English to Urdu Dictonary by Sineha Kataria");
		HomeFrame.setBounds(100, 100, 746, 596);
		HomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSeparator TopMenue = new JSeparator();
		TopMenue.setOrientation(SwingConstants.VERTICAL);
		TopMenue.setForeground(new Color(255, 0, 0));
		TopMenue.setBackground(new Color(255, 0, 0));
		//menuBar.add(TopMenue);
		// Exit Button click to Exit
		
		
		JButton exit = new JButton("    Exit  ");
		exit.addActionListener(new ActionListener() // interface ActionListener implementation(Action when button pressed)
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0); // Exit the program with exit code 0.
			}
		});
		// Mouse enter and exit effect
		exit.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseEntered(MouseEvent e) // mouse enter 
			{
				exit.setBackground(new Color(255, 51, 51));
			}
			@Override
			public void mouseExited(MouseEvent e) // mouse exit
			{
				exit.setBackground(SystemColor.textHighlight);
			}
		});
		exit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		exit.setBackground(SystemColor.textHighlight);
		exit.setForeground(new Color(0, 51, 102));
		exit.setToolTipText("Click this to exit\r\n");
	}
}
