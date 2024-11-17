import java.awt.Color;

public class Colorpoint {
    private Color color;
    private int x,y;
    public Colorpoint(int x,int y,Color color)
    {
         this.x = x;
         this.y = y;
         this.color = color;
    }
   
    public Color getColor()
    {
        return color;
    }
    public int getx()
    {
        return x;
    }
    public int gety()
    {
        return y;
    }
}

