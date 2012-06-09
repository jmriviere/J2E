import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class Morpion extends Applet implements ActionListener , MouseMotionListener
{
    private int numJoueur;

    private void param(){
        sizeX=getSize().width;
        sizeY=getSize().height;
        scaleX=sizeX/3;
        scaleY=(sizeY-30)/3;
    }
    public void paint(Graphics gr){
        /*
           this.boutons00.setBounds(new Rectangle(10, 30, 30, 20));
           this.boutons01.setBounds(new Rectangle(10+scaleX, 30, 30, 20));
           this.boutons02.setBounds(new Rectangle(10+scaleX*2, 30, 30, 20));
           this.boutons10.setBounds(new Rectangle(10, 30+scaleY, 30, 20));
           this.boutons11.setBounds(new Rectangle(10+scaleX, 30+scaleY, 30, 20));
           this.boutons12.setBounds(new Rectangle(10+scaleX*2, 30+scaleY, 30, 20));
           this.boutons20.setBounds(new Rectangle(10, 30+scaleY*2, 30, 20));
           this.boutons21.setBounds(new Rectangle(10+scaleX, 30+scaleY*2, 30, 20));
           this.boutons22.setBounds(new Rectangle(10+scaleX*2, 30+scaleY*2,30, 20));
           */
        this.boutonreload.setBounds(new Rectangle(300, 5, 70, 20));
        //this.boutonswitch.setBounds(new Rectangle(380, 5, 50, 20));
        int i, j, r;
        gr.setColor(Color.white);
        gr.fillRect(0,0,sizeX,sizeY);
        gr.setColor(Color.black);
        for (i=0;i<=3;i++){
            gr.drawLine( 0, 20+i*scaleY,
                    3*scaleX, 20+i*scaleY);
            gr.drawLine( i*scaleX, 20,
                    i*scaleX, 20+3*scaleY);
        }
        
        for (i=0;i<3;i++){
            for (j=0;j<3;j++){
                if (focus[i][j] && map[i][j]==0 && state){
                    gr.setColor(Color.blue);
                    gr.drawLine( (i)*scaleX+10, 10+(j+1)*scaleY,
                            (i+1)*scaleX-10, 30+(j)*scaleY);
                    gr.drawLine( (i)*scaleX+10, 30+(j)*scaleY,
                            (i+1)*scaleX-10, 10+(j+1)*scaleY);
                }else if (map[i][j]==1){
                    gr.setColor(Color.blue);
                    for (r=0;r<3;r++){
                        gr.drawLine( (i)*scaleX, 20+(j+1)*scaleY+r,
                                (i+1)*scaleX, 20+(j)*scaleY+r);
                        gr.drawLine( (i)*scaleX, 20+(j)*scaleY+r,
                                (i+1)*scaleX, 20+(j+1)*scaleY+r);
                    }
                }else if (map[i][j]==2){
                    gr.setColor(Color.red);
                    gr.fillOval( i*scaleX, 20+j*scaleY, scaleX, scaleY);
                    gr.setColor(Color.white);
                    gr.fillOval( i*scaleX+5, 25+j*scaleY, scaleX-10, scaleY-10);
                }
            }
        }
        gr.setColor(Color.black);
        gr.drawString(stateStr , 20, 10);
        gr.drawString(scoreW+" à "+scoreL , 20, sizeY);
    }
    
    public void newgame(){
        stateStr="A vous de jouer";
        int i,j;
        for (i=0;i<3;i++){
            for (j=0;j<3;j++){
                map[i][j]=0;
                focus[i][j]=false;
            }
        }
        state=false;
        if (!Iplay) oponent();
        state=true;
    }

    private boolean win(int k){
        int i,j;
        for (i=0;i<3;i++){
            if (
                    (map[i][0]==k &&
                     map[i][1]==k &&
                     map[i][2]==k )
                    ||
                    (map[0][i]==k &&
                     map[1][i]==k &&
                     map[2][i]==k )
               )
                return true;
        }
        //if (map[1][1]==k && ( (map[0][0]==k && map[2][2]==k ) || (map[0][2]==k && map[2][0]==k ) ) )
        if (map[1][1]==k && map[0][0]==k && map[2][2]==k ) return true;
        if (map[1][1]==k && map[0][2]==k && map[2][0]==k ) return true;
        return false;
    }

    private boolean win(){
        return win(1);
    }
    
    private boolean lose(){
        return win(2);
    }
    
    private boolean matchnul(){
        int i,j;
        for (i=0;i<3;i++){
            for (j=0;j<3;j++){
                if (map[i][j]==0)
                    return false;
            }
        }
        return true;
    }
    
    private void play(int x, int y){
        if (map[x][y]==0){
            map[x][y]=this.numJoueur;
            sendMove(x * 3 + y);
            state=false;
            if (!win()){
                if (matchnul()){
                    stateStr="partie nulle !";
                    scoreW++;
                    scoreL++;
                }else{
                    oponent();
                    if (lose()){
                        stateStr="t'as perdu !";
                        scoreL+=2;
                    }else if (matchnul()){
                        stateStr="partie nulle !";
                        scoreW++;
                        scoreL++;
                    }else{
                        state=true;
                    }
                }
            }else{
                stateStr="t'as gagné !";
                scoreW+=2;
            }
            repaint();
        }
    }

    private void oponent(){
        int coupI, coupJ;
        int i = getMove();
        coupI = i/3;
        coupJ = i - 3*coupI;
        map[coupI][coupJ]= (this.numJoueur == 1) ? 2 : 1;
    }

    private int minimax(int couleur){
        if (lose()) return 100;
        if (win()) return -100;
        if (matchnul()) return 0;
        int score=1, i, j;
        int max;
        if (couleur==1){
            max=10;
        }else{
            max=-10;
        }
        for (i=0;i<3;i++){
            for (j=0;j<3;j++){
                if (map[i][j]==0){
                    map[i][j]=couleur;
                    if (couleur==1){
                        score=minimax(2);
                        if (score<=max) max=score;
                    }else if (couleur==2){
                        score=minimax(1);
                        if (max<=score) max=score;
                    }
                    map[i][j]=0;
                    //if (max*max==100) return max;
                }
            }
        }
        return max;
    }

    public void init(){
        param();
        this.numJoueur = Integer.parseInt(getParameter("numeroJoueur"));
        Iplay=(numJoueur == 1);
        scoreL=0;
        scoreW=0;
        /*
           this.boutons00.addActionListener(this);
           this.boutons01.addActionListener(this);
           this.boutons02.addActionListener(this);
           this.boutons10.addActionListener(this);
           this.boutons11.addActionListener(this);
           this.boutons12.addActionListener(this);
           this.boutons20.addActionListener(this);
           this.boutons21.addActionListener(this);
           this.boutons22.addActionListener(this);*/
        this.boutonreload.addActionListener(this);
        //this.boutonswitch.addActionListener(this);
        /*
           this.add(this.boutons00, null);
           this.add(this.boutons01, null);
           this.add(this.boutons02, null);
           this.add(this.boutons10, null);
           this.add(this.boutons11, null);
           this.add(this.boutons12, null);
           this.add(this.boutons20, null);
           this.add(this.boutons21, null);
           this.add(this.boutons22, null);*/
        this.add(this.boutonreload, null);
        //this.add(this.boutonswitch, null);
        map=new int[3][3];
        focus=new boolean[3][3];
        stateStr="A vous de jouer";
        newgame();
        this.addMouseMotionListener(this);
        this.addMouseListener(
                new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        Morpion.this.mouseClicked(e);
                    }
                }
                );
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        //if (source == this.boutonreload) newgame();
        //else if (source == this.boutonswitch) gameSwitch();
        /*else if (state){
          if (source == this.boutons00) play(0, 0);
          else if (source == this.boutons01) play(1, 0);
          else if (source == this.boutons02) play(2, 0);
          else if (source == this.boutons10) play(0, 1);
          else if (source == this.boutons11) play(1, 1);
          else if (source == this.boutons12) play(2, 1);
          else if (source == this.boutons20) play(0, 2);
          else if (source == this.boutons21) play(1, 2);
          else if (source == this.boutons22) play(2, 2);
          }*/
        repaint();
    }

    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY()-20;
        int i, j;
        x=(int)(x/scaleX);
        y=(int)(y/scaleY);
        boolean Boolch=false;
        if (x>=0 && x<3 && y<3 && y>=0 && !focus[x][y] && map[x][y]==0){
            for (i=0;i<3;i++){
                for (j=0;j<3;j++){
                    focus[i][j]=false;
                }
            }
            focus[x][y]=true;
            Boolch=true;
        }
        if (Boolch){
            repaint();
        }
    }

    public void mouseDragged(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY()-20;
        x=(int)(x/scaleX);
        y=(int)(y/scaleY);
        if (state && x>=0 && x<3 && y<3 && y>=0){
            play(x, y);
        }
    }

    Button boutonreload=new Button("New Game");
    //Button boutonswitch=new Button("Switch");
    /*Button boutons00=new Button("play");
      Button boutons01=new Button("play");
      Button boutons02=new Button("play");
      Button boutons10=new Button("play");
      Button boutons11=new Button("play");
      Button boutons12=new Button("play");
      Button boutons20=new Button("play");
      Button boutons21=new Button("play");
      Button boutons22=new Button("play");*/
    private String stateStr;
    private boolean Iplay;
    private boolean state;
    private int scaleX, scaleY, sizeX, sizeY, scoreL, scoreW;
    public int map[][];
    public boolean focus[][];

    /**
     * Connection à la servlet.
     */
    private synchronized URLConnection getServletConnection(String params)
        throws MalformedURLException, IOException {

        URL urlServlet = new URL("http://localhost:8080/JEE/MorpionServlet" + "?" + params);
        URLConnection con = urlServlet.openConnection();
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setUseCaches(false);
        con.setRequestProperty("Content-Type", "application/x-java-serialized-object");
        return con;
    }

    /**
     * Envoi le coup joue à la servlet.
     */
    private void sendMove(int i) {
        try {
            String coup = Integer.toString(i);
            byte[] buf = coup.getBytes();
            stateStr = coup;
            // send data to the servlet
            URLConnection con = getServletConnection("coup=jeu");
            OutputStream outstream = con.getOutputStream();
            outstream.write(buf);
            outstream.flush();
            outstream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 
    /**
     * Recupère un coup joue.
     */
    private int getMove() {
        int res = -1;
        try {
            byte[] buf = new byte[32];
            int len = 0;
            // send data to the servlet
            URLConnection con = getServletConnection("coup=attente");
            InputStream instr = con.getInputStream();
            while (res < 0 && 9 < res) {
                len = instr.read(buf);
                //String coupJoue = new String(Arrays.copyOfRange(buf, 0, len - 1));
                String coupJoue = new String(buf);
                res = Integer.parseInt(coupJoue);
            }
            instr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }
} 
