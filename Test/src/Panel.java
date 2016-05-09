import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Panel extends JFrame implements ChangeListener{
	JLabel banner;
	JColorChooser tcc;
	
	public Panel() {

		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel drawPanel = new JPanel(); // new Canvas()
		
        banner = new JLabel("Welcome to the Color Zone!", JLabel.CENTER);
        banner.setForeground(Color.yellow);
        banner.setBackground(Color.blue);
        banner.setOpaque(true);
        banner.setFont(new Font("SansSerif", Font.BOLD, 24));
        banner.setPreferredSize(new Dimension(100, 65));
        
        tcc = new JColorChooser(banner.getForeground());
        tcc.getSelectionModel().addChangeListener(this);
        tcc.setBorder(BorderFactory.createTitledBorder("Choose Text Color"));

		
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EtchedBorder());
		panel.add(banner, BorderLayout.NORTH);
		panel.add(buttonPanel, BorderLayout.WEST);
		panel.add(drawPanel, BorderLayout.CENTER);
		panel.add(tcc, BorderLayout.PAGE_END);
		 
		drawPanel.setBorder(new EtchedBorder());
		buttonPanel.setBorder(new EtchedBorder());
		buttonPanel.setLayout(new GridLayout(10, 1));
		
		JButton ellipseButton = new JButton("Ellipses");
		JButton rectangleButton = new JButton("Rectangle");
		JButton lineButton = new JButton("Line");
		
		ActionListener ellipseListener = new AddEllipseListener();
		ActionListener rectangleListener = new AddRectangleListener();
		ActionListener lineListener = new AddLineListener();
		
		ellipseButton.addActionListener(ellipseListener);
		rectangleButton.addActionListener(rectangleListener);
		lineButton.addActionListener(lineListener);
		
		buttonPanel.add(ellipseButton);
		buttonPanel.add(rectangleButton);
		buttonPanel.add(lineButton);
		
		
		frame.add(panel);
		frame.setSize(1000, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	

	

	class AddEllipseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Select Shape
			//Activate mouse coordinate
		}
	}
	
	class AddRectangleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Select Shape
			//Activate mouse coordinate
		}
	}
	
	class AddLineListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Select Shape
			//Activate mouse coordinate
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		Color newColor = tcc.getColor();
        banner.setForeground(newColor);
	}
	
	

}
