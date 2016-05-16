import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Panel extends JFrame implements ChangeListener{
	JLabel banner;
	JColorChooser tcc;
	
	Canvas drawPanel;
	
	JRadioButton ellipseButton;
	JRadioButton rectangleButton;
	JRadioButton lineButton;
	
	JTextField topLeftX;
	JTextField topLeftY;
	JTextField bottomRightX;
	JTextField bottomRightY;
	JTextField saveField;
	
	public static void main(String[] args) {
		Panel drawUI = new Panel();
	}
	
	public Panel() {
//UI Update
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel coordinatePanel = new JPanel();
		JPanel tccPanel = new JPanel();
		drawPanel = new Canvas();
		
		//JLabel coordinateLabel = new JLabel("Coordinate Input");
		JLabel TXLabel = new JLabel("Top Left X");
		JLabel TYLabel = new JLabel("Top Left Y");
		JLabel BXLabel = new JLabel("Bottom Right X");
		JLabel BYLabel = new JLabel("Bottom Right Y");
		topLeftX = new JTextField();
		topLeftY = new JTextField();
		bottomRightX = new JTextField();
		bottomRightY = new JTextField();
		
        banner = new JLabel("Welcome to the Color Zone!", JLabel.CENTER);
        banner.setForeground(Color.yellow);
        banner.setBackground(Color.blue);
        banner.setOpaque(true);
        banner.setFont(new Font("SansSerif", Font.BOLD, 24));
        banner.setPreferredSize(new Dimension(100, 40));
        
        tcc = new JColorChooser(banner.getForeground());
        tcc.getSelectionModel().addChangeListener(this);
        tcc.setBorder(BorderFactory.createTitledBorder("Choose Text Color"));
        tcc.setColor(Color.BLACK);
        tccPanel.add(tcc);
        tccPanel.setSize(200, 100);


		panel.setLayout(new BorderLayout());
		panel.setBorder(new EtchedBorder());
		panel.add(banner, BorderLayout.NORTH);
		panel.add(buttonPanel, BorderLayout.WEST);
		panel.add(drawPanel, BorderLayout.CENTER);
		panel.add(tccPanel, BorderLayout.PAGE_END);
		 
		drawPanel.setBorder(new EtchedBorder());
		MouseListener mouseListener = new MouseClickListener();
		MouseMotionListener mouseMotionListener = new MouseDragListener();
		drawPanel.addMouseListener(mouseListener);
		drawPanel.addMouseMotionListener(mouseMotionListener);
		buttonPanel.setBorder(new EtchedBorder());
		buttonPanel.setLayout(new GridLayout(14, 1));

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
		
		ellipseButton = new JRadioButton("Ellipses");
		rectangleButton = new JRadioButton("Rectangle");
		lineButton = new JRadioButton("Line");
		lineButton.setSelected(true);
		ButtonGroup radioGroup = new ButtonGroup();
		JButton addShape = new JButton("Add Shape");
		JButton undoShape = new JButton("Undo");
		JButton redoShape = new JButton("Redo");
		JButton clearShape = new JButton("Clear All");
		JButton save = new JButton("Save");
		saveField = new JTextField();
		saveField.setText("untitled.dat");
		JButton load = new JButton("Load");
		
		ActionListener addShapeListener = new AddShapeListener();
		ActionListener undoShapeListener = new UndoShapeListener();
		ActionListener redoShapeListener = new RedoShapeListener();
		ActionListener clearShapeListener = new ClearShapeListener();
		ActionListener saveListener = new SaveListener();
		ActionListener loadListener = new LoadListener();
		
		addShape.addActionListener(addShapeListener);
		undoShape.addActionListener(undoShapeListener);
		redoShape.addActionListener(redoShapeListener);
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
		buttonPanel.add(redoShape);
		buttonPanel.add(clearShape);
		buttonPanel.add(save);
		buttonPanel.add(saveField);
		buttonPanel.add(load);
			
		frame.add(panel);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void addShape() {
		if (ellipseButton.isSelected()) {
			System.out.println("Button clicked");
			drawPanel.addShape(new Ellipse(
					Integer.parseInt(topLeftX.getText()),
					Integer.parseInt(topLeftY.getText()),
					Integer.parseInt(bottomRightX.getText()),
					Integer.parseInt(bottomRightY.getText()),
					tcc.getColor()
			));
			drawPanel.repaint();
		} else if (rectangleButton.isSelected()) {
			System.out.println("Button clicked");
			drawPanel.addShape(new Rectangle(
					Integer.parseInt(topLeftX.getText()),
					Integer.parseInt(topLeftY.getText()),
					Integer.parseInt(bottomRightX.getText()),
					Integer.parseInt(bottomRightY.getText()),
					tcc.getColor()
			));
			drawPanel.repaint();
		} else if (lineButton.isSelected()) {
			System.out.println("Button clicked");
			drawPanel.addShape(new Line(
					Integer.parseInt(topLeftX.getText()),
					Integer.parseInt(topLeftY.getText()),
					Integer.parseInt(bottomRightX.getText()),
					Integer.parseInt(bottomRightY.getText()),
					tcc.getColor()
			));
			drawPanel.repaint();
		}
	}

	
	class AddShapeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			addShape();
		}
	}
	
	class UndoShapeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			drawPanel.removeLastShape();
			drawPanel.repaint();
		}
	}
	
	class RedoShapeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			drawPanel.redoLastShape();
			drawPanel.repaint();
		}
	}
	
	class ClearShapeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			drawPanel.clearShapes();
			drawPanel.repaint();
		}
	}
	
	class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			drawPanel.save(saveField.getText());
		}
	}
	
	class LoadListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			drawPanel.load(saveField.getText());
			drawPanel.repaint();
		}
	} 
	
	class MouseClickListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			topLeftX.setText(Integer.toString(e.getPoint().x));
			topLeftY.setText(Integer.toString(e.getPoint().y));
			bottomRightX.setText(Integer.toString(e.getPoint().x));
			bottomRightY.setText(Integer.toString(e.getPoint().y));
			addShape();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class MouseDragListener implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			drawPanel.removeLastShape();
			int topX = Integer.parseInt(topLeftX.getText());
			int topY = Integer.parseInt(topLeftY.getText());
			int bottomX = e.getPoint().x;
			int bottomY = e.getPoint().y;
			if (lineButton.isSelected()) {
				bottomRightX.setText(Integer.toString(bottomX));
				bottomRightY.setText(Integer.toString(bottomY));
				addShape();
				return;
			}

			java.awt.Rectangle r = new java.awt.Rectangle();
			r.setFrameFromDiagonal(new Point(topX, topY), new Point(bottomX, bottomY));
			topLeftX.setText(Integer.toString((int) r.getX()));
			topLeftY.setText(Integer.toString((int) r.getY()));
			bottomRightX.setText(Integer.toString((int) (r.getX() + r.getWidth())));
			bottomRightY.setText(Integer.toString((int) (r.getY() + r.getHeight())));
			addShape();
			topLeftX.setText(Integer.toString(topX));
			topLeftY.setText(Integer.toString(topY));
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		Color newColor = tcc.getColor();
        banner.setForeground(newColor);
	}
	
	

}