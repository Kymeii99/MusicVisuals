package C19358373;

public class SnowFall {
    
    KimVisual kt;
    private float height;
    private float width;

    public SnowFall(KimVisual kt,float width, float height)
    {
        this.kt = kt;
        this.width = width;
        this.height = height;

    }
    
    void draw() {

        float x = kt.random(width);
        float y = kt.random(height);
        float r = kt.random(10);

        kt.fill(255);
        kt.ellipse(x, y, r, r);
        y++;

        if ( y > kt.height)
        {
            y = 0;
            x = kt.random(kt.width);
        }
    }
}
