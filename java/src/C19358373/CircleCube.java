package C19358373;
import processing.core.PApplet;

public class CircleCube {
    
    KimVisual kt;

    public CircleCube(KimVisual kt)
    {
        this.kt = kt;
    }

    float angle = 0;
    float angle2 = 0;
    
    public void render() {
        kt.background(0);
        int numCircles = 12;
        int Mwidth = 140;

        float c = PApplet.map(kt.amplitude, 0, 1 , 0 , 255);
        //circles
        for ( int i = 0 ; i < numCircles ; i++)
        {
            kt.stroke(c * i, 255, 255);
            kt.strokeWeight(2);
            kt.noFill();
            kt.ellipse(kt.width / 2 , kt.height / 2 ,  Mwidth + (kt.smothedAmplitude * 500), Mwidth + (kt.smothedAmplitude * 500));
            Mwidth += 70;
        }

        kt.lights();
        kt.strokeWeight(2);
        kt.stroke(c, 255, 255);
        kt.noFill();

        angle += 0.01f;
        angle2 -= 0.02f;
        float s = 40 + ( 100 * kt.smothedAmplitude * 10);
        float s1 = 20 + ( 100 * kt.smothedAmplitude * 10);
        kt.translate(kt.width / 2, kt.height / 2);

        //cubes
        kt.rotateY(angle);
        kt.rotateX(angle);
        kt.box(s);
        
        kt.rotateY(angle2);
        kt.rotateX(angle2);
        kt.box(s1);
    }
}
