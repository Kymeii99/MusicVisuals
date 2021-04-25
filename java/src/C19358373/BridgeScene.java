package C19358373;

public class BridgeScene {
    KimVisual kt;

    public BridgeScene(KimVisual kt)
    {
        this.kt = kt;
    }
    
    int x = 0;

    public void render()
    {
        float halfW = kt.width / 2;
        float halfH = kt.height / 2;
        int car = 20;
        int windows = -5;
        //Sky Color
        kt.background(255,155,162);
        
        //The Sun
        kt.fill(255);
        kt.noStroke();
        kt.circle(halfW,140 + (kt.smothedAmplitude * 50),103 + (kt.smothedAmplitude * 50));

        //The Rays of the sun, gradient effect
        kt.fill(255,15);
        kt.noStroke();
        kt.circle(halfW,140 + (kt.smothedAmplitude * 50),113 + (kt.smothedAmplitude * 50));

        int sunrays = 0;
        
        for (int i = 0 ; i <= 3 ; i++)
        {
            kt.fill(255,15);
            kt.noStroke();
            kt.circle(halfW,140 + (kt.smothedAmplitude * 50),123 + sunrays + (kt.smothedAmplitude * 50));
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
    }
}
