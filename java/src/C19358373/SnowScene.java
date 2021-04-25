package C19358373;

public class SnowScene {
    KimVisual kt;

    public SnowScene(KimVisual kt)
    {
        this.kt = kt;
    }


    public void render(){

        float h = kt.height / 2;
        float w = kt.width / 2;

        //Tree
        kt.stroke(245,150,200);
        //trunk
        kt.line(40, kt.height - 100, 40, h);

        //Branches
        kt.line(-100, h - 100, 40, h);
        kt.line(-10, h - 100, 40, h);
        kt.line(20, h - 100, 40, h);
        kt.line(60, h - 100, 40, h);
        kt.line(100, h - 100, 40, h);
        kt.line(140, h - 40, 40, h);

        //floor Color
        kt.noStroke();
        kt.fill(209);
        kt.rect(0, kt.height - 100, kt.width, 100);
        kt.fill(255);
        kt.rect(w, kt.height - 100, kt.width, 100);

    }
}
