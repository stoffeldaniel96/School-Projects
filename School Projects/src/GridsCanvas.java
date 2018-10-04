import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GridsCanvas extends JPanel{
 
	int width, height;
	static int rows;
	int cols;
	static int row1;
	int X1;
	static int X2;
	int Y1;
	static int Y2;
	int count = 0;
	static boolean inputComplete;
  GridsCanvas(int r, int c) 
  {
	  setPreferredSize(new Dimension(800, 800));
	  rows = r;
	  cols = c;
	  
  }

  public void paint(Graphics g) 
  {
    int i;
    width = getSize().width;
    height = getSize().height;
    // draw the rows
    int rowHt = height / (rows);
    for (i = 0; i < rows; i++)
      g.drawLine(0, i * rowHt, width, i * rowHt);

    // draw the columns
    int rowWid = width / (cols);
    for (i = 0; i < cols; i++)
      g.drawLine(i * rowWid, 0, i * rowWid, height);
	g.setColor(Color.BLACK);
	g.drawLine (0,0, X2, Y2);
  }

  public static void main(String[] a) 
  {
	  JFrame frame = new JFrame("Bresenham Line Algorithm by Daniel & Branden");
	 
	  JComponent printGrid = new GridsCanvas(100, 100);  
      printGrid.setFocusable(true);
      printGrid.addMouseListener(new MouseAdapter() 
      {
          @Override
          public void mousePressed(MouseEvent e) 
          {
              X2 = e.getX();
              Y2 = e.getY();
              e.getComponent().repaint();
              System.out.println("Something happened");
          }
      });
      frame.setLayout(new BorderLayout());
      frame.add(printGrid, BorderLayout.CENTER);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
  }
}