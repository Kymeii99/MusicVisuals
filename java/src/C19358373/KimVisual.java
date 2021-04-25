package C19358373;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class KimVisual extends Visual{
   
    CircleCube c;
    Planet p;
    Stars s;
    Airplane a;
    BridgeScene b;

    /*Removed*/
    // SnowScene scene;
    // ArrayList<SnowFall> snow = new ArrayList<SnowFall>();

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

        // for ( int i = 0; i < 10; i++)
        // {
        //     snow.add(new SnowFall(this, width, height));
        // }
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
        }
    }

    public void draw()
    {
        background(0);
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

        switch(input)
        {
            //waveform
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
                // for (SnowFall snow : snow)
                // {
                //     snow.draw();
                // }
                // scene.render();
                b.render();
                break;
            }
        }
        
    }
}
