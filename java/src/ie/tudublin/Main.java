package ie.tudublin;

import C19358373.KimVisual;
import example.MyVisual;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());		
	}

	public void KTVisuals()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new KimVisual());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.KTVisuals();			
	}
}