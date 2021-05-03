package C19358373;

import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class menu {
    KimVisual kt;

    public menu(KimVisual kt)
    {
        this.kt = kt;
    }

    public void render()
    {
        kt.background(0);

        String title = "Welcome!";
        String subtitle = "Press space to start/restart:";
        String notice = "Please start before Pressing!";
        String key1 = "Press 1: Circle Cube";
        String key2 = "Press 2: Planet";
        String key3 = "Press 3: Airplane";
        String key4 = "Press 4: Bridge Scenery";

        kt.textAlign(PApplet.CENTER,PApplet.CENTER);
        kt.textSize(30);
        kt.fill(PApplet.map(kt.getAmplitude(), 0, 1, 0, 255), 255, 255);
        kt.text(title, kt.width / 2, kt.height / 2 - 100);
        kt.textSize(25);
        kt.text(subtitle, kt.width / 2, kt.height / 2 - 30);
        
        kt.textSize(20);
        kt.fill(255);
        kt.text(notice, kt.width / 2, kt.height / 2 + 10);
        kt.text(key1, kt.width / 2, kt.height / 2 + 40);
        kt.text(key2, kt.width / 2, kt.height / 2 + 70);
        kt.text(key3, kt.width / 2, kt.height / 2 + 100);
        kt.text(key4, kt.width / 2, kt.height / 2 + 130);
    }
}
