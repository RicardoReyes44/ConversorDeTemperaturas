import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;


public class Conversor extends JFrame implements ActionListener{
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	JLabel lbl1 = new JLabel("Convertir: ");
	JLabel lbl2 = new JLabel("A: ");
	JLabel lbl3 = new JLabel("=");
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField(3);
	
	String vectorEstados[] = {"*Centigrados", "*Fahrenheit", "*Kelvin", "*Rankine"};
	JComboBox <String> gradosEntrada = new JComboBox<String>(vectorEstados);
	JComboBox <String> gradosSalida = new JComboBox<String>(vectorEstados);
	
	Font fuente = new Font("Calibri", 1, 20);

	
	public Conversor() {
		
		getContentPane().setLayout(gbl);
		setTitle("Conversor de temperaturas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		lbl1.setForeground(Color.gray);
		lbl1.setHorizontalAlignment(JTextField.CENTER);
		lbl2.setForeground(Color.gray);
		txt1.setHorizontalAlignment(JTextField.CENTER);
		txt1.setOpaque(false);
		txt1.setFont(fuente);
		txt1.setPreferredSize(new Dimension(70, 25));
		txt2.setHorizontalAlignment(JTextField.CENTER);
		txt2.setOpaque(false);
		txt2.setFont(fuente);
		txt2.setEditable(false);

		// ------------------------------------------------
		
		alinear(0, 0, 1, 1, lbl1);

		alinear(1, 0, 1, 1, txt1);
		
		alinear(1, 1, 1, 1, gradosEntrada);
		
		alinear(0, 1, 1, 1, lbl2);
		
		alinear(2, 1, 1, 1, lbl3);
		
		alinear(3, 1, 1, 1, txt2);
		
		alinear(2, 0, 1, 1, gradosSalida);
		
		// ------------------------------------------------
		
		gradosEntrada.addActionListener(this);
		gradosSalida.addActionListener(this);
		
		pack();
		setLocationRelativeTo(null);
		
	}
	

	public void alinear(int x, int y, int width, int height, Component componente) {

		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = height;
		gbc.gridwidth = width;
		
		gbl.setConstraints(componente, gbc);
		add(componente);
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {

        if(arg0.getSource()==gradosEntrada || arg0.getSource()==gradosSalida) {
			
        	String opcion = (String)gradosEntrada.getSelectedItem();
        	String opcion2 = (String)gradosSalida.getSelectedItem();
        	
        	if(!opcion.equals(opcion2)) {
        	
        		convertir(opcion, opcion2);
        		
        	}else {
        		txt2.setText("x.X");
        	}
			
		}
			
	}
	
	
	public void convertir(String base, String conversion) {

		if(base.equals("*Centigrados")) {
			realizarOperacion(base, conversion);
		}else if(base.equals("*Fahrenheit")) {
			realizarOperacion(base, conversion);
		}else if(base.equals("*Kelvin")) {
			realizarOperacion(base, conversion);
		}else {
			realizarOperacion(base, conversion);
		}
		
	}


	public void realizarOperacion(String base, String conversion) {

		int grados;
		
        if(base.equals("*Centigrados")) {
			
        	
        	
		}else if(base.equals("*Fahrenheit")) {
			
			grados = (Integer.parseInt(txt1.getText())*(9/5))+32;
        	txt2.setText(String.valueOf(grados));
			
		}else if(base.equals("*Kelvin")) {
			
			
			
		}else if(base.equals("*Rankine")) {
			
			
			
		}
		
	}

}
