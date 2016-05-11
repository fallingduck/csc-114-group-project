import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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
		JPanel coordinatePanel = new JPanel();
		Canvas drawPanel = new Canvas();
		
		//JLabel coordinateLabel = new JLabel("Coordinate Input");
		JLabel TXLabel = new JLabel("Top Left X");
		JLabel TYLabel = new JLabel("Top Left Y");
		JLabel BXLabel = new JLabel("Bottom Right X");
		JLabel BYLabel = new JLabel("Bottom Right Y");
		JTextField topLeftX = new JTextField();
		JTextField topLeftY = new JTextField();
		JTextField bottomRightX = new JTextField();
		JTextField bottomRightY = new JTextField();
		
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

		coordinatePanel.setLayout(new GridLayout(2, 4));
		//coordinatePanel.add(coordinateLabel);
		coordinatePanel.add(TXLabel);
		coordinatePanel.add(topLeftX);
		coordinatePanel.add(TYLabel);
		coordinatePanel.add(topLeftY);
		coordinatePanel.add(BXLabel);
		coordinatePanel.add(bottomRightX);
		coordinatePanel.add(BYLabel);
		coordinatePanel.add(bottomRightY);
		
		JRadioButton ellipseButton = new JRadioButton("Ellipses");
		JRadioButton rectangleButton = new JRadioButton("Rectangle");
		JRadioButton lineButton = new JRadioButton("Line");
		ButtonGroup radioGroup = new ButtonGroup();
		JButton addShape = new JButton("Add Shape");
		JButton undoShape = new JButton("Undo");
		JButton clearShape = new JButton("Clear All");
		JButton save = new JButton("Save");
		JButton load = new JButton("Load");
		
		ActionListener ellipseListener = new AddEllipseListener();
		ActionListener rectangleListener = new AddRectangleListener();
		ActionListener lineListener = new AddLineListener();
		ActionListener addShapeListener = new AddShapeListener();
		ActionListener undoShapeListener = new UndoShapeListener();
		ActionListener clearShapeListener = new ClearShapeListener();
		ActionListener saveListener = new SaveListener();
		ActionListener loadListener = new LoadListener();
		
		ellipseButton.addActionListener(ellipseListener);
		rectangleButton.addActionListener(rectangleListener);
		lineButton.addActionListener(lineListener);
		addShape.addActionListener(addShapeListener);
		undoShape.addActionListener(undoShapeListener);
		clearShape.addActionListener(clearShapeListener);
		save.addActionListener(saveListener);
		load.addActionListener(loadListener);
		
		radioGroup.add(ellipseButton);
		radioGroup.add(rectangleButton);
		radioGroup.add(lineButton);
		
		buttonPanel.add(ellipseButton);
		buttonPanel.add(rectangleButton);
		buttonPanel.add(lineButton);
		buttonPanel.add(coordinatePanel);
		buttonPanel.add(addShape);
		buttonPanel.add(undoShape);
		buttonPanel.add(clearShape);
		buttonPanel.add(save);
		buttonPanel.add(load);
		
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
	
	class AddShapeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Select Shape
			//Activate mouse coordinate
		}
	}
	
	class UndoShapeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Select Shape
			//Activate mouse coordinate
		}
	}
	
	class ClearShapeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Select Shape
			//Activate mouse coordinate
		}
	}
	
	class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Select Shape
			//Activate mouse coordinate
		}
	}
	
	class LoadListener implements ActionListener{

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