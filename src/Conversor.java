import javax.swing.*;
import java.awt.*;


public class Conversor extends JFrame{
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	JLabel lbl1 = new JLabel("Convertir: ");
	JLabel lbl2 = new JLabel("A: ");
	JLabel lbl3 = new JLabel("=");
	JTextField txt1 = new JTextField(3);
	
	Font fuente = new Font("Calibri", 1, 20);

	
	public Conversor() {
		
		getContentPane().setLayout(gbl);
		setTitle("Conversor de temperaturas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		lbl1.setForeground(Color.gray);
		lbl2.setForeground(Color.gray);
		txt1.setOpaque(false);
		txt1.setFont(fuente);

		// ------------------------------------------------
		
		alinear(0, 0, 1, 1, lbl1);

		alinear(1, 0, 1, 1, txt1);
		
		alinear(0, 1, 1, 1, lbl2);
		
		// ------------------------------------------------
		
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

}
