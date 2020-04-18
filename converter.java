//FADI SHEHADEH

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class converter extends JFrame implements ActionListener, MouseListener  {

	
	private JTextField euros;
	private JTextField dollars;
	private JTextField conv;
	private JButton boutton;
	private JLabel labdirect;
	private SpinnerModel model;
	private JSpinner spinner;
	
	double taux=1;
	
	

		public converter() {
		
		this.setTitle("Convertisseur");
		
	    this.setSize(300,130);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	   
	    
	    //Constructions du panel principal
	    JPanel container = new JPanel(); 
	    container.setLayout(new BorderLayout());
	    this.setContentPane(container);
	    
	    JPanel  devises = new JPanel();
	    
	    //Contructions du formulaire
	    euros = new JTextField();    //boite ecriture euros
	    dollars = new JTextField();  //boite ecriture dollars
	    
	    
	    JLabel labeuros = new JLabel("  €");      //titre euros
	    JLabel labdollars = new JLabel("$");     //titre dollars
	    labdirect = new JLabel(" <=> ");    // Tetxe fleche
	    
	    //Etalage
	    euros.setColumns(6); 
        dollars.setColumns(6);
	    
	    //Ajout au Jpanel 
	    devises.add(euros);
	    devises.add(labeuros);
	    devises.add(labdirect);
	    devises.add(dollars);
	    devises.add(labdollars);
		
	    //Ajout du JPanel dans le haut de la fenetre
	    container.add(devises,BorderLayout.NORTH);
	    
	    //Construction des différents affichage et parametres
	    JPanel  conversion = new JPanel();
	    JLabel TAUX = new  JLabel("TAUX : 1 € ");
	    JLabel egalite = new  JLabel("    =   ");
	    model = new SpinnerNumberModel(1,0.50,2,0.1);
	    spinner = new JSpinner(model);
	    conv = new JTextField("1.0");
	    JLabel labdollarsbis = new JLabel("$");
	    
	    conv.setColumns(6);
	    
	    conversion.add(TAUX);
	    conversion.add(egalite);
	    conversion.add(spinner);
	    conversion.add(labdollarsbis);
	    
	    container.add(conversion, BorderLayout.CENTER); // Ajout de la partie taux dans le milieu du panel
	    
	    
	    JButton  boutton = new JButton("QUITTER");  //Cr"ation du boutton quitter
	    
	    container.add(boutton,BorderLayout.SOUTH); // Ajout du boutton dans le bas du panel
	    
	    
	    
	    this.setVisible(true); //Contenu visible
	
	    
	    //Ajout de listeners
	    euros.addActionListener(this);
	    dollars.addActionListener(this);
	    boutton.addMouseListener(this);
	    conv.addActionListener(this);
	    
	    
	    
	    //Ajout ChangeListener sur le spinner
	    
	    this.spinner.addChangeListener( new ChangeListener() {
	    	public void stateChanged(ChangeEvent e) {
	    		
	    		double valeur=Math.round((double) spinner.getValue()*100.0)/100.0;
	    		setTaux(valeur );
	    	}
	    });
	    
	   
		}
	    
	
		
	
	public void setTaux( double t) {taux=t;}
	
	
	
	
	// ACTION EVENT + CONVERSION
	
	
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		JOptionPane d = new JOptionPane();
		
		double valeur = 0;
		
	
		
		if (source.equals(euros) ){
			
			 try {valeur = Double.parseDouble(euros.getText());}
			 catch (NumberFormatException e) {JOptionPane.showMessageDialog(null,"Valeur en euros incorrecte, entrez un nombre");}
			 valeur=Math.round(valeur*100.0)/100.0;
			 dollars.setText(String.valueOf(valeur*taux));
			
			this.labdirect.setText(" =>");}
			
		
		
		if (source.equals(dollars) ){
			
			try {valeur = Double.parseDouble(dollars.getText());}
			 catch (NumberFormatException e) {JOptionPane.showMessageDialog(null,"Valeur en dollars incorrecte, entrez un nombre");}
			 valeur=Math.round((valeur/taux)*100.0)/100.0;
			 euros.setText(String.valueOf(valeur));
			
			this.labdirect.setText("<=");}
			
			
		if (source.equals(conv)) { //conv
			
			try {valeur = Double.parseDouble(conv.getText());}
			catch (NumberFormatException e){JOptionPane.showMessageDialog(null,"Valeur du taux incorrecte, entrez un nombre");}
			setTaux(valeur);
			conv.setText(String.valueOf(valeur));}
		
		
		
	}
		
	
	
	
	
	
	
	
	//MOUSE EVENT
	public void mouseClicked(MouseEvent e) {System.exit(0);}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
}




