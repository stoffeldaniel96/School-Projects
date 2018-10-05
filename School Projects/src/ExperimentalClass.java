import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ExperimentalClass {  
     
    private static int click = 0;
    static ArrayList<Point> pointStore = new ArrayList<Point>();
    public static void main(String[] args) throws Exception {  
        JFrame f = new JFrame("Draw a red line");  
        f.setSize(300, 300);  
        f.setLocation(300, 300);  
        f.setResizable(false);  
   
        JPanel p = new JPanel() {  
            Point pointStart = null;  
            Point pointEnd = null;  
            {  
                addMouseListener(new MouseAdapter() {  
                    public void mousePressed(MouseEvent e) {  
                        pointStart = e.getPoint(); 
   
                    }  
   
                    public void mouseReleased(MouseEvent e) {  
                       if(click==0){
                           click++;
                           pointStore.add(e.getPoint());
                           
                       }
                       else{
                          pointEnd = e.getPoint(); 
                          pointStart=pointStore.get(0);
                          pointStore.remove(0);
                          click=0;
                           
                       }
   
                    }  
                });  
                addMouseMotionListener(new MouseMotionAdapter() {  
                    public void mouseMoved(MouseEvent e) {  
                        pointEnd = e.getPoint();  
                    }  
   
                    public void mouseDragged(MouseEvent e) {  
                        pointEnd = e.getPoint();  
                        repaint();  
                    }  
                });  
            }  
   
            public void paint(Graphics g) {  
                super.paint(g);  
                if (pointStart != null) {  
                    g.setColor(Color.red);  
                    g.drawLine(pointStart.x, pointStart.y, pointEnd.x,  
                            pointEnd.y);  
   
                }  
            }  
        };  
        f.add(p);  
        f.setVisible(true);  
   
    }  
}
