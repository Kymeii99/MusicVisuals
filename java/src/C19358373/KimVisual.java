package C19358373;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class KimVisual extends Visual{
   
    CircleCube c;
    Planet p;
    Stars s;
    Airplane a;
    BridgeScene b;
    menu m;

    boolean start = false;

    public void settings()
    {
        size(800, 500, P3D);
    }

    public void setup()
    {
        colorMode(HSB);
        surface.setResizable(true);
        startMinim();

        // Call loadAudio to load an audio file to process 
        loadAudio("java/data/RAS.mp3");
        //startListening(); 

        c = new CircleCube(this);
        p = new Planet(this);
        s = new Stars(this);
        a = new Airplane(this);
        b = new BridgeScene(this);
        m = new menu(this);
    }

    int input = 0;

    public void keyPressed()
    {
        if (key >= '1' && key <= '4') {
            input = key - '0';
        }

        if (key == ' ')
        {
            if(ap.isPlaying()){
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
            start = true;
            input = 1;
        }
    }

    public void draw()
    {   
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();   

        if (start == false)
        {
           m.render(); 
           s.render();
        }
        else {
            switch(input)
            {
                case 1:
                {
                    c.render();
                    break;
                }
                case 2:
                {
                    p.render();
                    s.render();
                    break;
                }
                case 3:
                {
                    a.render();
                    s.render();
                    break;
                }
                case 4:
                {
                    b.render();
                    break;
                }
            }
        }
    }
}
