import javax.swing.*;
import java.awt.*;


public class Conversor extends JFrame{
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();

	
	public Conversor() {
		
		getContentPane().setLayout(gbl);
		setTitle("Conversor de temperaturas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		pack();
		setLocationRelativeTo(null);
		
	}

}
