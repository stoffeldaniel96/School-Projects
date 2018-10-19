/*=============================================================================
 |   Project:  Bresenham Line Algorithm
 |    Author(s):  Daniel Stoffel
 | 
 |       Course:  CS 3600
 |   Instructor:  Dr. Carter
 |     Due Date:  4/17/2018
 |
 |  Description:  Simulates scalable Bresenham Line Drawing Algorithm
 |
 |     Language:  Java
 |
 | Deficiencies:  Columns and Rows are currently limited to preset input as time constraints and applet problems made it hard to achieve.
 *===========================================================================*/
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Bresenham 
{
	static int width;
	static int height;
	static int cols;
	static int rows;
	private static int click = 0;
	static ArrayList<Point> pointStore = new ArrayList<Point>();
	static Point pointStart = null;  
    	static Point pointEnd = null;  
   	 static Point temppointStart = null;   
   	 static boolean rLock;
    	
    	static class displayPanel extends JPanel {
        public displayPanel() {
        	rows = 40;
            cols = 40;
        	setPreferredSize(new Dimension(800, 800));
        	 
             {  
                 addMouseListener(new MouseAdapter() 
                 {  
                     public void mousePressed(MouseEvent e) 
                     {  
                         pointStart = e.getPoint();
                         temppointStart = e.getPoint();
                         System.out.println("Started Line");
                         rLock = false;
                         System.out.println("Locked");
                     }  
    
                     public void mouseReleased(MouseEvent e) 
                     {  
                        if(click==0)
                        {
                            click++;
                            pointStore.add(e.getPoint());   
                        }
                        else{
                           pointEnd = e.getPoint(); 
                           pointStart=pointStore.get(0);
                           pointStore.remove(0);
                           click=0;
                        }
                        System.out.println("Ended Line");
                        rLock = true;
                        System.out.println("Unlocked");
                        repaint();
                     }  
                 });  
                 addMouseMotionListener(new MouseMotionAdapter() 
                 {  
                     public void mouseMoved(MouseEvent e) 
                     {  
                         pointEnd = e.getPoint();  
                     }  
    
                     public void mouseDragged(MouseEvent e) 
                     {  
                         pointEnd = e.getPoint();  
                         repaint();  
                     }  
                 });  
             }  
        }

        @Override
        protected void paintComponent(final Graphics g) 
        {
            //intializes jFrame appearance and sets background
        	super.paintComponent(g);
            int w = getWidth();
            int h = getHeight();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, w, h);
            g.setColor(Color.BLACK);
           
            //Draws Grid 
            int i;
            width = getSize().width;
            height = getSize().height;
            //Draws Rows
            int rowHt = height / (rows);
            for (i = 0; i < rows; i++)
              g.drawLine(0, i * rowHt, width, i * rowHt);

            //Draws Columns
            int rowWid = width / (cols);
            for (i = 0; i < cols; i++)
            	g.drawLine(i * rowWid, 0, i * rowWid, height);
            //Draws Green Guideline
            if (pointStart != null)
            {  
                g.setColor(Color.GREEN);  
                g.drawLine(temppointStart.x, temppointStart.y, pointEnd.x, pointEnd.y);     
            }
            
            //Draws Bresenham Line
            if (click == 0 & rLock == true)
            {
            	g.setColor(Color.RED);  
	            drawLine(g,temppointStart.x, temppointStart.y, pointEnd.x, pointEnd.y, width/cols, height/rows);
            }
            else if (click != 0 & rLock == true)
            {
            	 g.setColor(Color.RED);  
 	            drawLine(g,pointStart.x, pointStart.y, pointEnd.x, pointEnd.y, width/cols, height/rows);
            }
        }
    }
    
    // main method
    public static void main(String[] argv) 
    {
    	SwingUtilities.invokeLater(() -> { showTest(); }); //java wanted to do this automatically
    }
    
    //Establishes jFrame for jPanel grid and line drawing.
    static void showTest() 
    {
        JFrame frame = new JFrame("Bresenham Line Algorithm Program by Daniel Stoffel");
        JComponent test = new displayPanel();
        test.setFocusable(true);
        frame.setLayout(new BorderLayout());
        frame.add(test, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
   
    //Bresenham Algorithm as implemented in Java. Pulled partially from Differed Difference Algorithm as well as other online resources. 
    public static void drawLine(Graphics g, int x0, int y0, int x1, int y1, int widthScale, int heightScale) 
    {
        //calculates simulated pixel size according to relative window pixels.
    	int scaledX0 = x0 / widthScale;
        int scaledY0 = y0 / heightScale;
        int scaledX1 = x1 / widthScale;
        int scaledY1 = y1 / heightScale;
        int dx = scaledX1 - scaledX0;
        int dy = scaledY1 - scaledY0;
        int stepX = Integer.signum(dx);
        int stepY = Integer.signum(dy);
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        int dx2 = dx << 1;
        int dy2 = dy << 1;
        int x = scaledX0;
        int y = scaledY0;
        int error;
        if (dx >= dy) //calculates slope error
        {
            error = dy2 - dx;
            do {
                plot(g, x, y, widthScale, heightScale); //plots line according to slope error and calculated scales.
                if (error > 0)
                {
                    y += stepY;
                    error -= dx2;
                }
                error += dy2;
                x += stepX;
            } while (x != scaledX1);
        } 
        else 
        {
            error = dx2 - dy;
            do 
            {
                plot(g, x, y, widthScale, heightScale);
                if (error > 0) 
                {
                    x += stepX;
                    error -= dy2;
                }
                error += dx2;
                y += stepY;
            } while (y != scaledY1);
        }
    }

    //plots out individual pixels according to window scale and block size.
    static void plot(Graphics g, int x, int y, int widthScale, int heightScale) 
    {
        int x0 = x * widthScale;
        int y0 = y * heightScale;
        int w = widthScale;
        int h = heightScale;
        g.fillRect(x0, y0, w, h);
    }

}
