package C19358373;

public class BridgeScene {
    KimVisual kt;

    public BridgeScene(KimVisual kt)
    {
        this.kt = kt;
    }
    
    public void render()
    {
        float halfW = kt.width / 2;
        float halfH = kt.height / 2;
        //Sky Color
        kt.background(255,155,162);
        
        //The Sun
        kt.fill(255);
        kt.noStroke();
        kt.circle(halfW,140,103);

        //The Rays of the sun, gradient effect
        kt.fill(255,15);
        kt.noStroke();
        kt.circle(halfW,140,113);

        int sunrays = 0;
        
        for (int i = 0 ; i <= 3 ; i++)
        {
            kt.fill(255,15);
            kt.noStroke();
            kt.circle(halfW,140,123 + sunrays);
            sunrays += 10;
        }

        //Water
        kt.fill(0,119,182);
        kt.rect(0, halfH + 100, kt.width, 200);

        //Bridge
        kt.fill(255, 150);
        kt.rect(0, halfH, kt.width, 2);

        //Flooring of bridge
        kt.fill(0);
        kt.rect(0, halfH + 50, kt.width, 10);    

    }
}
