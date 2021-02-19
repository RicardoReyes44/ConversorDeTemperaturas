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
	JFormattedTextField txt1;
	JTextField txt2 = new JTextField(5);
	
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
		
		MaskFormatter mascara;
		try {
			mascara = new MaskFormatter("####");
			txt1 = new JFormattedTextField(mascara);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

		// ------------------------------------------------
		
		alinear(0, 0, 1, 1, lbl1);

		alinear(1, 0, 1, 1, txt1);
		
		alinear(1, 1, 1, 1, gradosSalida);
		
		alinear(0, 1, 1, 1, lbl2);
		
		alinear(2, 1, 1, 1, lbl3);
		
		alinear(3, 1, 1, 1, txt2);
		
		alinear(2, 0, 1, 1, gradosEntrada);
		
		// ------------------------------------------------
		
		gradosEntrada.addActionListener(this);
		gradosSalida.addActionListener(this);
		
		txt1.setFocusLostBehavior(JFormattedTextField.COMMIT);
		
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
		
		String texto = txt1.getText();
		
		if(arg0.getSource()==gradosEntrada && !texto.equals("    ")
	        || arg0.getSource()==gradosSalida && !texto.equals("    ")) {
			
			texto=texto.replace(" ", "");
			
	       	String opcion = (String)gradosEntrada.getSelectedItem();
	       	String opcion2 = (String)gradosSalida.getSelectedItem();
	        	
	        if(!opcion.equals(opcion2)) {
	        	
	       		convertir(opcion, opcion2, texto);
	        		
	       	}else {
	       		txt2.setText("x.X");
	       	}
				
		}
			
	}
	
	
	public void convertir(String base, String conversion, String texto) {
		
		double grados;
		
		if(base.equals("*Centigrados")) {
			
			if(conversion.equals("*Fahrenheit")) {
				
				grados = (Integer.parseInt(texto)*9/5)+32;
	        	txt2.setText(String.valueOf(grados));
				
			}else if(conversion.equals("*Kelvin")) {
				
				grados = (Integer.parseInt(texto)+273.15);
	        	txt2.setText(String.valueOf(grados));
				
			}else {
				
				grados = (Integer.parseInt(texto)*9/5+491.67);
	        	txt2.setText(String.valueOf(grados));
				
			}
			
		}else if(base.equals("*Fahrenheit")) {
            
            if(conversion.equals("*Centigrados")) {
				
				grados = (Integer.parseInt(texto)-32) * 5/9;
	        	txt2.setText(String.valueOf(grados));
				
			}else if(conversion.equals("*Kelvin")) {
				
				grados = (Integer.parseInt(texto)-32) * 5/9 + 273.15;
	        	txt2.setText(String.valueOf(grados));
				
			}else {
				
				grados = Integer.parseInt(texto)+459.67;
	        	txt2.setText(String.valueOf(grados));
				
			}
			
		}else if(base.equals("*Kelvin")) {
			
            if(conversion.equals("*Fahrenheit")) {
				
				grados = (Integer.parseInt(texto)- 273.15) * 9/5 + 32;
	        	txt2.setText(String.valueOf(grados));
				
			}else if(conversion.equals("*Rankine")) {
				
				grados = Integer.parseInt(texto)*1.8;
	        	txt2.setText(String.valueOf(grados));
				
			}else {
				
				grados = Integer.parseInt(texto)-273.15;
	        	txt2.setText(String.valueOf(grados));
				
			}
			
		}else {
			
            if(conversion.equals("*Fahrenheit")) {
				
				grados = Integer.parseInt(texto) - 459.67;
	        	txt2.setText(String.valueOf(grados));
				
			}else if(conversion.equals("*Kelvin")) {
				
				grados = Integer.parseInt(texto) * 5/9;
	        	txt2.setText(String.valueOf(grados));
				
			}else {
				
				grados = (Integer.parseInt(texto) - 491.67) * 5/9;
	        	txt2.setText(String.valueOf(grados));
				
			}
			
		}
		
	}

}
