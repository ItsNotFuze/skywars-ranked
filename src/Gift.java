import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Gift {
	public int x,y;
	public Image img;
	public boolean isActive;
	Timer updater;
	
	public Gift(Image img){
		updater = new Timer(70, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				downIt();
				
			}
		});
		this.img = img;
		isActive = false;
	}
	
	public void start(){
		updater.start();
		y = 0;
		x = (int)(Math.random()*700);
		
		isActive = true;
	}

	private void downIt() {
		
	if(isActive) y+=6;
	if((y+80)>=470) 
	updater.stop();
	}
	
	public void draw(Graphics gr){
		if(isActive) gr.drawImage(img, x, y, 80, 80, null);
	}
}
