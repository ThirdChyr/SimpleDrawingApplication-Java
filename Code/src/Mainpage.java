import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Mainpage extends JFrame implements ActionListener{
//first varible
    public JLabel pic_background,Star_icon,choosepic;
    
    public Icon stopsound;
    public Font inmain,startgame,choosefont,smallfont;
    public JButton musesound,start,quit;
    public JPanel ms,qu,realbg,musicbg,choosebg;
    public Color white,kodlightgray,inbox,green;
    public Dimension iconms;
    public File sound;
    public Clip clip;
    public AudioInputStream maintrack;
    public float set = (float) 0.5;
    public int count =2;
//second page
   public JPanel button,foradd;
   public JButton pic1,pic2,pic3,back;
   public Icon p1,p2,p3; 
//Third page
  public Canvas paint = new Canvas(1920,1080);
  public JPanel foradd2,musicbg2;
  public Image imagebg,imagebg2,imagebg3;
  public JLabel clicktostart;
  public JButton saveas,colorpic,resetcolor;
  public JFileChooser fileChooser;
  public FileNameExtensionFilter filter;
  public File filename;
//Sound sound1 = new Sound();
    Mainpage() throws UnsupportedAudioFileException, IOException,LineUnavailableException,AWTException
    {
      // First setting
      choosefont = new Font("NICE SUGAR",Font.BOLD,100); 
      iconms = new Dimension(50,50);
      white = new Color(255, 255, 255);
      inbox = new Color(59, 200, 230);
      kodlightgray = new Color(128, 128, 128);
      green =new Color(123, 174, 43);
      startgame = new Font("NICE SUGAR",Font.BOLD,60); 
      inmain = new Font("Glossy sheen",Font.BOLD,120);
      smallfont = new Font("NICE SUGAR",Font.BOLD,30); 

//make sound
      sound = new File("sound/maintheme.wav");
       maintrack = AudioSystem.getAudioInputStream(sound);
       clip = AudioSystem.getClip();
       clip.open(maintrack);
       clip.start();

//background setting
      ImageIcon mainpage = new ImageIcon("Pic/Background.jpg");

      Image img = mainpage.getImage();
      Image temp = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
      mainpage = new ImageIcon(temp);
    
      pic_background = new JLabel("",mainpage,JLabel.CENTER);
      pic_background.setBounds(0,0,1920,1080);
       
//Jlabel zone 
      Star_icon = new JLabel("Welcome to WoopLat",SwingConstants.CENTER);
      Star_icon.setPreferredSize(new Dimension(1920,500));
      Star_icon.setForeground(new Color(123, 174, 43));
      Star_icon.setFont(inmain);
      
// Jbutton zone

      stopsound = new ImageIcon("Pic/emote/nos.png");
      musesound = new JButton(stopsound);
      musesound.setPreferredSize(iconms);
      musesound.setBorderPainted(false);
      musesound.setFocusPainted(true);
      musesound.setOpaque(false);
      musesound.setContentAreaFilled(false);
      musesound.addActionListener(this);
      
      start = new JButton("Start game");
      start.setFocusPainted(false);
     start.setPreferredSize(new Dimension(500,120));
      start.setFocusable(false);
      start.setBorderPainted(false);
      start.setFont(startgame);
      start.setForeground(inbox);
      
      start.addActionListener(this);

      quit = new JButton("Quit");
      quit.setFocusPainted(false);
      quit.setPreferredSize(new Dimension(200,120));
      quit.setFocusable(false);
      quit.setBorderPainted(false);
      quit.setFont(startgame);
      quit.setForeground(inbox);
      quit.addActionListener(this);
 
// Jpanel zone
 
  musicbg =new JPanel();
  musicbg.setPreferredSize(new Dimension(1920,50));
  musicbg.setOpaque(false);
  musicbg.setLayout(new FlowLayout(FlowLayout.RIGHT,20,5));
  musicbg.setBounds(0,0,1920,1030);
  musicbg.add(musesound);

  realbg = new JPanel();
  realbg.setPreferredSize(new Dimension(1920,1040));
  realbg.setOpaque(false);
  realbg.setBounds(0,0,1920,1080);

      qu = new JPanel();
      qu.setPreferredSize(new Dimension(1920,100));
      qu.setOpaque(false);
      qu.setBackground(white);
      qu.setVisible(true);
      qu.add(quit);

      realbg.add(Star_icon);
      realbg.add(start);
      realbg.add(qu);
      
  pic_background.add(musicbg);
  pic_background.add(realbg);
   this.add(pic_background);
        

        this.setTitle("Wooplat Game");
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        this.setSize(1920,1080);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(white);
        this.setBackground(white);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource() == start)
      {
// Setting 2
        realbg.setVisible(false);
        pic_background.remove(realbg);
         
// page2 JLabel zone 2
        choosepic = new JLabel("NEW Game?",SwingConstants.CENTER);
        choosepic.setPreferredSize(new Dimension(1920,400));
        choosepic.setFont(choosefont);
        choosepic.setForeground(green);

//page2 JButtonzone 2
      pic1 = new JButton("New page");
      pic1.setFont(startgame);
      pic1.setForeground(green);
      pic1.setPreferredSize(new Dimension(600,100));
      pic1.setFocusable(false);
      pic1.setBorderPainted(false);
      pic1.addActionListener(this);

      back = new JButton("back?");
     back.setFocusPainted(false);
     back.setPreferredSize(new Dimension(400,100));
     back.setFocusable(false);
     back.setBorderPainted(false);
     back.setFont(startgame);
     back.setForeground(inbox);
     back.addActionListener(this);

// page2 Jpanel zone 2
      choosebg = new JPanel();
      choosebg.setPreferredSize(new Dimension(1920,1040));
      choosebg.setOpaque(false);
      choosebg.setBounds(0,0,1920,1080);
   
      foradd = new JPanel();
      foradd.setPreferredSize(new Dimension(1920,210));
      foradd.setBounds(0,0,1920,700);
      foradd.setLayout(new FlowLayout(FlowLayout.CENTER,100,0));
      foradd.setOpaque(false);

//Adding zone 2
      foradd.add(pic1);
    
// real interface 2
      choosebg.add(choosepic);
      choosebg.add(foradd);
      choosebg.add(back);

// dont touch them 2

      pic_background.add(choosebg); 
      }
      else if(e.getSource() == musesound)
      {
        if(count%2 == 0)
        {
          clip.start();
          count++;
        }
        else
        {
          clip.stop();
          count++;
        }
      }
      else if(e.getSource() == back)
      {
        choosebg.setVisible(false);
        realbg.setVisible(true);
        pic_background.add(realbg);
      }
      else if(e.getSource() == quit)
      {
       System.exit(0);
      }
//Set background 3
      else if(e.getSource() == pic1)
      {
//Set background3
          imagebg =Toolkit.getDefaultToolkit().getImage("Pic/Button/npic1.jpg");
        this.setContentPane(new JPanel() {
          @Override
          public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagebg, 500, 200, null);
          }
        });
//set JButton 3

colorpic = new JButton("     ");
colorpic.setFocusable(false);
colorpic.setFont(smallfont);
colorpic.setForeground(null);
colorpic.setBackground(new Color(0, 0,0));
colorpic.setBorderPainted(false);
colorpic.addActionListener(this);

resetcolor = new JButton("Reset");
resetcolor.setFont(smallfont);
resetcolor.setForeground(green);
resetcolor.setFocusable(false);
resetcolor.setBorderPainted(false);
resetcolor.addActionListener(this);

saveas = new JButton("Save and Quit");
saveas.setFont(smallfont);
saveas.setForeground(green);
saveas.setBorderPainted(false);
saveas.addActionListener(this);
saveas.setFocusable(false);

//set music icon3
   musicbg2 =new JPanel();
  musicbg2.setPreferredSize(new Dimension(1920,60));
  musicbg2.setOpaque(false);
  musicbg2.setLayout(new FlowLayout(FlowLayout.RIGHT,20,5));
  musicbg2.setBounds(0,0,1920,1030);
  
 
  musicbg2.add(colorpic);
  musicbg2.add(resetcolor);
  musicbg.add(saveas);
  musicbg2.add(saveas);
  musicbg2.add(musesound);
  
//set JLabel3
      clicktostart = new JLabel("Show you WadRup at WoopLat");
      clicktostart.setFont(startgame);
      clicktostart.setForeground(green);

    

//set Jpanel3
       foradd2 = new JPanel();
       foradd2.setPreferredSize(new Dimension(1920,90));
       foradd2.setBounds(0,0,1920,700);
       foradd2.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
       foradd2.setBackground(green);
       foradd2.setOpaque(false);
       foradd2.add(clicktostart);
//dont touch them3

       
        this.add(musicbg2);
        this.add(foradd2);
        this.add(paint);
        this.setVisible(true);
       choosebg.setVisible(false);
      }
      else if(e.getSource() == saveas)
      {
        try {
          
          BufferedImage screenshot = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_BGR);
          Graphics2D g2d = screenshot.createGraphics();
          this.paint(g2d);
          
          fileChooser = new JFileChooser();
          fileChooser.setDialogTitle("Save pic As....");
          fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
          filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
          fileChooser.setFileFilter(filter);
          
          
          int userSelection = fileChooser.showSaveDialog(null);
          if (userSelection == JFileChooser.APPROVE_OPTION) {
              File shot = fileChooser.getSelectedFile();
              ImageIO.write(screenshot, "jpg", shot);
              System.exit(0);
          }
      } catch (Exception e1) {
          e1.printStackTrace();
      }
      }
      else if(e.getSource() ==colorpic)
      {
        Color c = JColorChooser.showDialog(null, "Select a color ", Color.black);
        colorpic.setBackground(c);
        paint.setColor(c);
      }
      else if(e.getSource() == resetcolor)
      {
        paint.reset();
      }

    }
}
