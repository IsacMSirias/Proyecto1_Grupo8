import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;



public class VentanaJuego  extends JFrame implements Runnable{

    private final Canvas canvas;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    private static int aps = 0;
    private static int fps = 0;


    ImageIcon imageIcon = new ImageIcon("Sprites/IconMath.png");

    VentanaJuego(){

        setIconImage(imageIcon.getImage());
        setSize(500, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setFocusable(true);
        setLocationRelativeTo(null);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(500,600));
        canvas.setMaximumSize(new Dimension(500,600));
        canvas.setMinimumSize(new Dimension(500,600));
        canvas.setFocusable(true);

        add(canvas);
    }

    private void ActualizarPantalla(){
        aps ++;
    }

    private void draw(){

        fps ++;

        bs = canvas.getBufferStrategy();

        if (bs == null){

            canvas.createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //----------------
        g.setColor(Color.white);
        g.fillRect(0,0,500,600);

        //----------------
        g.dispose();
        bs.show();


    }



    @Override
    public void run() {

        final int NPS = 1000000000;
        final byte APSObj = 60;
        final double NSAct = NPS/APSObj;

        long refAct = System.nanoTime();
        long contador = System.nanoTime();


        double Time;
        double delta = 0;



        while(running) {
            final long inicio = System.nanoTime();
            Time = inicio - refAct;
            refAct = inicio;
            delta += Time / NSAct;

            while (delta <= 1) {
                ActualizarPantalla();
                delta--;
            }
            draw();

            if (System.nanoTime() - contador > NPS){
                aps = 0;
                fps = 0;

                contador = System.nanoTime();

            }


        }
    }


    void start(){

        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private void  stop () {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
