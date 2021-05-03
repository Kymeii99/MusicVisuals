package C19358373;

public class Airplane {
    

    KimVisual kt;

    public Airplane(KimVisual kt)
    {
        this.kt = kt;
    }

    int x = 0;
    boolean flicker=true;

    public void render()
    {
        //Changing Background color to beat
        kt.background(300 * (kt.getAmplitude()));
        
        kt.noStroke();
        kt.fill(255);

        /* Drawing the plane*/
        //body and wings of the plane
        kt.ellipse(100+x, kt.height / 3, 100, 30);
        kt.ellipse(100+x, kt.height / 3, 20, 75);

        //fin of the plane
        kt.beginShape();
            kt.vertex(20 + x, (kt.height / 3) - 20);
            kt.vertex(60 + x, (kt.height / 3) - 20);
            kt.vertex(60 + x, (kt.height / 3 )+ 10) ;
            kt.vertex(20 + x,(kt.height / 3) - 20);
        kt.endShape();
        
        //passenger windows
        kt.fill(150);;
        kt.rect(70+x, (kt.height / 3) - 3, 10, 10);
        kt.rect(90+x, (kt.height / 3) - 3, 10, 10);
        kt.rect(110+x, (kt.height / 3) - 3, 10, 10);

        //front window
        kt.fill(87);
        kt.arc(126+x, (kt.height / 3) + 5, 50, - 35, 0, kt.HALF_PI);
        

        /*Drawing the Building with flickering lights*/
        float Halfh = kt.height / 2;
        int windowNum = 3;

        //building 1
        kt.rect(0,Halfh,150,kt.height);

        //building 2
        kt.fill(50);
        kt.rect(155,Halfh + 80,150,kt.height);
        
        int count = 0;
        for ( int i = 0 ; i < windowNum ; i++)
        {
            kt.fill(0);
            kt.rect(165, (Halfh + 90) + count ,50,50);
            kt.rect(245 ,(Halfh + 90) + count,50,50);
            count+=80;
        }

        //building 3
        kt.fill(87);
        kt.rect(310,Halfh + 50,150,kt.height);

        //building 4
        kt.fill(50);
        kt.rect(465,Halfh + 10,150,kt.height);
        int count1 = 0;
        for ( int i = 0 ; i < windowNum ; i++)
        {
            kt.fill(0);
            kt.rect(475, (Halfh + 20) + count1 ,50,50);
            kt.rect(555 ,(Halfh + 20) + count1,50,50);
            count1+=80;
        }

        //building 5
        kt.fill(87);
        kt.rect(620,Halfh + 80,150,kt.height);

        //building 6
        kt.fill(50);
        kt.rect(775,Halfh + 20,150,kt.height);
        int count2 = 0;
        for ( int i = 0 ; i < windowNum ; i++)
        {
           kt.fill(0);
           kt.rect(785, (Halfh + 30) + count2 ,50,50);
           count2+=80;
        }

        //flickering windows
        kt.fill(0);
        if(kt.frameCount % 30 == 0) {
            if(flicker)
                kt.fill(0);
            else
                kt.fill(255);
            flicker = !flicker;
        }
        
        //building 1 - flickering lights
        int count3 = 0;
        for ( int i = 0 ; i < windowNum ; i++)
        {
            kt.rect(10, (Halfh + 20) + count3 ,50,50);
            kt.rect(90 ,(Halfh + 20) + count3,50,50);
            count3+=80;
        }


        //building 3 - flickering lights
        int count4 = 0;
        for ( int i = 0 ; i < windowNum ; i++)
        {
            kt.rect(320, (Halfh + 60) + count4 ,50,50);
            kt.rect(400 ,(Halfh + 60) + count4,50,50);
            count4+=80;
        }

        //building 5 - flickering lights
        int count5 = 0;
        for ( int i = 0 ; i < windowNum ; i++)
        {
            kt.rect(630, (Halfh + 90) + count5 ,50,50);
            kt.rect(710 ,(Halfh + 90) + count5,50,50);
            count5+=80;
        }

        //Moon
        kt.fill(255);
        kt.ellipse( 40 , 70, 50 + (kt.getSmoothedAmplitude() * 500), 50 +  (kt.getSmoothedAmplitude() * 500));
        kt.noFill();

        //moving the plane
        x = x + 1;

        if ( x > kt.width)
        {
            x = 0;
        }
        if( x < 0)
        {
            x = kt.width;
        }
    }
}
