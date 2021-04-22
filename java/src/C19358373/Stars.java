package C19358373;

public class Stars {
    

    KimVisual kt;

    public Stars(KimVisual kt)
    {
        this.kt = kt;
    }

    public void render()
    {
        int stars = 100;

        kt.stroke(255);

        //generate random stars around the screen with random
        for(int i = 0; i < stars; i++)
        {
            kt.point(kt.random(kt.width), kt.random(kt.height), kt.random(kt.width/2));
        }
    }
}
