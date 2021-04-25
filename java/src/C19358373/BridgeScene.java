package C19358373;

public class BridgeScene {
    KimVisual kt;

    public BridgeScene(KimVisual kt)
    {
        this.kt = kt;
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
        kt.circle(halfW,140 + (kt.smothedAmplitude * 70),103 + (kt.smothedAmplitude * 70));


        //The Rays of the sun, gradient effect
        kt.fill(255,15);
        kt.noStroke();
        kt.circle(halfW,140 + (kt.smothedAmplitude * 70),113 + (kt.smothedAmplitude * 70));

        int sunrays = 0;
        
        for (int i = 0 ; i <= 3 ; i++)
        {
            kt.fill(255,15);
            kt.noStroke();
            kt.circle(halfW,140 + (kt.smothedAmplitude * 70),123 + sunrays + (kt.smothedAmplitude * 70));
            sunrays += 10;
        }
        
        //Moutains
        kt.fill(102,86,53);
        kt.noStroke();
        kt.triangle(0, halfH + 100 , 0, halfH - 100, halfW, halfH + 100);
        kt.triangle(kt.width, halfH + 100 , kt.width, halfH - 100, halfW - 60, halfH + 100);
        
        //Water
        kt.fill(0,119,182);
        kt.rect(0, halfH + 100 - (kt.smothedAmplitude * 100), kt.width , 200 );
        
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

        //car
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
        kt.fill(255, 150);
        kt.rect(0, halfH, kt.width, 2);

        //Flooring of bridge
        kt.fill(0);
        kt.rect(0, halfH + 50, kt.width, 10); 
        
        //Line from the right and left of the bridge
        kt.stroke(0);
        kt.strokeWeight(2);
        kt.line(0, halfH, 40, halfH + 50);

        kt.stroke(0);
        kt.strokeWeight(2);
        kt.line(kt.width, halfH, kt.width - 40, halfH + 50);


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
