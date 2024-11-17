import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private final static int Stroke = 8;
    private ArrayList<ArrayList<Colorpoint>> allPaths;
    private ArrayList<Colorpoint> currentPath;
    private Color color;
    private int canvasWidth, canvasHeight;
    private int x, y;

    public Canvas(int targetWidth, int targetHeight){
        super();
        setPreferredSize(new Dimension(targetWidth, targetHeight));
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // init vars
         allPaths = new ArrayList<>(25);
        canvasWidth = targetWidth;
        canvasHeight = targetHeight;

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                x = e.getX();
                y = e.getY();

              
                Graphics g = getGraphics();
                g.setColor(color);
                g.fillRect(x, y, Stroke, Stroke);
                g.dispose();

               
                currentPath = new ArrayList<>(25);
                currentPath.add(new Colorpoint(x, y, color));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                allPaths.add(currentPath);
                currentPath = null;
            }

            @Override
            public void mouseDragged(MouseEvent e) {
               
                x = e.getX();
                y = e.getY();

                Graphics2D Grap2D = (Graphics2D) getGraphics();
                Grap2D.setColor(color);
                if(!currentPath.isEmpty()){
                    Colorpoint prevPoint = currentPath.get(currentPath.size() - 1);
                    Grap2D.setStroke(new BasicStroke(Stroke));
                    Grap2D.drawLine(prevPoint.getx(), prevPoint.gety(), x, y);
                }
                Grap2D.dispose();

                Colorpoint nextPoint = new Colorpoint(e.getX(), e.getY(), color);
                currentPath.add(nextPoint);            }
        };

        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void reset(){
        allPaths = new ArrayList<>(25);
        currentPath = null;

        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D DLine = (Graphics2D) g;

       
        for(ArrayList<Colorpoint> path : allPaths){
            Colorpoint from = null;
            for(Colorpoint point : path){
                DLine.setColor(point.getColor());

                
                if(path.size() == 1){
                    DLine.fillRect(point.getx(), point.gety(), Stroke, Stroke);
                }

                if(from != null){
                    DLine.setStroke(new BasicStroke(Stroke));
                    DLine.drawLine(from.getx(), from.gety(), point.getx(), point.gety());
                }
                from = point;
            }
        }
    }
}
