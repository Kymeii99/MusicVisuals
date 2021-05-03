package C19358373;

import processing.core.PApplet;

public class BridgeScene {
    KimVisual kt;
    float cy;

    public BridgeScene(KimVisual kt)
    {
        this.kt = kt;
        cy = this.kt.height / 2;
    }
    
    int x = 0;
    int cloudLeft = 300;
    int cloudRight = 470;
    int boat =  0;

    public void render()
    {
        float halfW = kt.width / 2;
        float halfH = kt.height / 2;
        int car = 20;
        int windows = -5;


        //Sky Color
        kt.background(255,155,162);
        
        //Clouds
        kt.noStroke();
        kt.fill(209);

        //left cloud
        kt.ellipse(cloudLeft, 170, 126, 97);
        kt.ellipse(cloudLeft + 62, 170, 70, 60);
        kt.ellipse(cloudLeft - 62, 170, 70, 60);
        
        //right cloud
        kt.ellipse(cloudRight, 100, 126, 97);
        kt.ellipse(cloudRight + 62, 100, 70, 60);
        kt.ellipse(cloudRight - 62, 100, 70, 60);


        //The Sun
        kt.fill(255);
        kt.noStroke();
        kt.circle(halfW,halfH + (kt.getSmoothedAmplitude() * 70),200 + (kt.getSmoothedAmplitude() * 70));


        //The Rays of the sun, gradient effect
        kt.fill(255,15);
        kt.noStroke();
        kt.circle(halfW,halfH + (kt.getSmoothedAmplitude() * 70),213 + (kt.getSmoothedAmplitude() * 70));

        int sunrays = 0;
        
        for (int i = 0 ; i <= 3 ; i++)
        {
            kt.fill(255,15);
            kt.noStroke();
            kt.circle(halfW,halfH + (kt.getSmoothedAmplitude() * 70),223 + sunrays + (kt.getSmoothedAmplitude() * 70));
            sunrays += 10;
        }
        
        //Bands behind the bridge
        float gap = kt.width / (float) kt.getBands().length;
        kt.noStroke();
        for(int i = 0 ; i < kt.getBands().length ; i ++)
        {
            kt.fill(PApplet.map(i, 0, kt.getBands().length, 255, 0), 155,162);
            kt.rect(i * gap, kt.height/2 + 50, gap,-kt.getSmoothedBands()[i] * 0.5f); 
        }

        //Moutains
        kt.fill(102,86,53);
        kt.noStroke();
        kt.triangle(0, halfH + 100 , 0, halfH - 100, halfW, halfH + 100);
        kt.triangle(kt.width, halfH + 100 , kt.width, halfH - 100, halfW - 60, halfH + 100);
        
        //Water
        kt.fill(0,119,182);
        kt.rect(0, halfH + 100 - (kt.getSmoothedAmplitude() * 100), kt.width , 200 );
        
        //Boat
        kt.fill(270,160,170);
        kt.rect(kt.width - 200 + boat, halfH + 150, 90, 40);
        kt.rect(kt.width - 190 + boat, halfH + 130, 70, 40);

        //The edges of the boat
        kt.triangle(kt.width - 250+ boat, halfH + 150, kt.width - 200+ boat, halfH + 150, kt.width - 200+ boat, halfH + 190);
        kt.triangle(kt.width - 60+ boat, halfH + 150, kt.width - 200+ boat, halfH + 150, kt.width - 110+ boat, halfH + 190);

        //Boat Windows
        kt.fill(0,119,182);
        kt.rect(kt.width -180+ boat, halfH + 135, 20, 10);
        kt.rect(kt.width -150+ boat, halfH + 135, 20, 10);

        //Bubbles from boat
        kt.fill(255);
        kt.ellipse(kt.width - 70 + (boat), kt.height - 70, 10 + (kt.getSmoothedAmplitude() * 30), 10+ (kt.getSmoothedAmplitude() * 30));
        kt.ellipse(kt.width - 50 + (boat), kt.height - 80, 15 + (kt.getSmoothedAmplitude() * 30), 15+ (kt.getSmoothedAmplitude() * 30));
        kt.ellipse(kt.width - 30 + (boat), kt.height - 90, 19+ (kt.getSmoothedAmplitude() * 30), 19+ (kt.getSmoothedAmplitude() * 30));

        //Cars
        kt.fill(0, 150);
        for ( int i = 0; i <= 4 ; i++)
        {

            kt.rect(x - car, halfH + 30, 40, 20);
            car += 100;
        }
        
        kt.fill(167);
        for ( int i = 0; i <= 4 ; i++)
        {
            kt.rect(x - windows, halfH + 35, 10, 10);
            windows+= 100;
        }


        //Bridge
        kt.fill(167);
        kt.rect(0, halfH, kt.width, 2);

        //Flooring of bridge
        kt.fill(0);
        kt.rect(0, halfH + 50, kt.width, 10); 
        
        //Line from the right and left of the bridge
        kt.stroke(0);
        kt.strokeWeight(2);
        int boatLine1 = 0;
        for (int i = 0; i <= 7 ; i++)
        {
           kt.line(0 + boatLine1, halfH, 40 + boatLine1, halfH + 50);
           boatLine1+=100;
        }
        

        kt.stroke(0);
        kt.strokeWeight(2);
        int boatLine2 = 0;
        for (int i = 0; i<= 7 ; i++)
        {
            kt.line(800 - boatLine2, halfH, 760 - boatLine2, halfH + 50);
            boatLine2+=100;
        }


        // Moving the cars
        x = x + 1;
        if ( x >= kt.width + 500)
        {
            x = 0;
        }

        //Checking Clouds movement
        cloudLeft= cloudLeft - 1;
        cloudRight= cloudRight + 1;

        if(cloudRight >= kt.width + 300)
        {
            cloudRight = 470;
        }
        if(cloudLeft <= -330)
        {
            cloudLeft = 300;
        }

        //Moving Boat
        boat = boat - 1;
        if ( boat <= -kt.width)
        {
            boat = 150;
        }
    }
}
