package C19358373;

import processing.core.PApplet;

public class Planet {
    KimVisual kt;
    float cy = 0;

    public Planet(KimVisual kt)
    {
        this.kt = kt;
        cy = this.kt.height / 2;
    }

    float reverse = 0;
    float reverse1 = 0;
    float angle = 0;
    float noiseScale = 0.02f;

    public void render(){
        kt.lights();
        kt.strokeWeight(1);
        float c = PApplet.map(kt.amplitude, 0, 1 , 0 , 255);
        kt.stroke(c,255,255);
        kt.noFill();

        angle += 0.007f;
        reverse -= 0.001f;
        float s = 40 + ( 100 * kt.smothedAmplitude * 8);
       
        kt.pushMatrix();
            //planet - rotate
            kt.translate(kt.width / 2, kt.height / 2);
            kt.rotateY(angle);
            kt.rotateX(angle);
            kt.sphere(s);

            //the rings around the planet
            int numCircles = 5;
            for (int i = 0 ; i < numCircles; i++)
            {
                kt.ellipse(0 , 0 ,  100 * i + (kt.smothedAmplitude * 1200), 100 * i + (kt.smothedAmplitude * 1200));
            }

            kt.stroke(255);
            kt.noFill();
            kt.ellipse(kt.width / 2 , kt.height / 2  ,  50  + (kt.smothedAmplitude * 500), 50  + (kt.smothedAmplitude * 500));
            kt.ellipse(-kt.width / 2  , kt.height / 2  ,  50  + (kt.smothedAmplitude * 500), 50  + (kt.smothedAmplitude * 500));
            kt.ellipse(-kt.width / 2  , -kt.height / 2  ,  50  + (kt.smothedAmplitude * 500), 50  + (kt.smothedAmplitude * 500));
            kt.ellipse(kt.width / 2  , -kt.height / 2  ,  50  + (kt.smothedAmplitude * 500), 50  + (kt.smothedAmplitude * 500));
    
            kt.ellipse(kt.width / 2 , kt.height / 2  ,  25  + (kt.smothedAmplitude * 500), 25  + (kt.smothedAmplitude * 500));
            kt.ellipse(-kt.width / 2  , kt.height / 2  ,  25  + (kt.smothedAmplitude * 500), 25  + (kt.smothedAmplitude * 500));
            kt.ellipse(-kt.width / 2  , -kt.height / 2  ,  25  + (kt.smothedAmplitude * 500), 25  + (kt.smothedAmplitude * 500));
            kt.ellipse(kt.width / 2  , -kt.height / 2  ,  25  + (kt.smothedAmplitude * 500), 25  + (kt.smothedAmplitude * 500));
        kt.popMatrix();

        kt.pushMatrix();
            kt.rotateY(reverse);
            kt.rotateX(reverse);
            
            kt.stroke(255);
            kt.noFill();
            kt.ellipse(kt.width / 2 , kt.height / 2  ,  25  + (kt.smothedAmplitude * 500), 25  + (kt.smothedAmplitude * 500));
            kt.ellipse(-kt.width / 2  , kt.height / 2  ,  25  + (kt.smothedAmplitude * 500), 25  + (kt.smothedAmplitude * 500));
            kt.ellipse(-kt.width / 2  , -kt.height / 2  ,  25  + (kt.smothedAmplitude * 500), 25  + (kt.smothedAmplitude * 500));
            kt.ellipse(kt.width / 2  , -kt.height / 2  ,  25  + (kt.smothedAmplitude * 500), 25  + (kt.smothedAmplitude * 500));

            kt.ellipse(kt.width / 2 , kt.height / 2  ,  50  + (kt.smothedAmplitude * 500), 50  + (kt.smothedAmplitude * 500));
            kt.ellipse(-kt.width / 2  , kt.height / 2  ,  50  + (kt.smothedAmplitude * 500), 50  + (kt.smothedAmplitude * 500));
            kt.ellipse(-kt.width / 2  , -kt.height / 2  ,  50  + (kt.smothedAmplitude * 500), 50  + (kt.smothedAmplitude * 500));
            kt.ellipse(kt.width / 2  , -kt.height / 2  ,  50  + (kt.smothedAmplitude * 500), 50  + (kt.smothedAmplitude * 500));
            
            //other sphere
            float p = PApplet.map(kt.amplitude, 0, 1 , 0 , 255);
            kt.stroke(p,200,200);
            kt.noFill();
            kt.sphere(s);
        kt.popMatrix();
    }
}
