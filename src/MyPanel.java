import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import javax.imageio.*;


public class MyPanel extends JPanel {

	public int x=0, y=0;
	private Image bg, catcher, img, lose;
	private Timer tmDraw, tmUpdate;
	
	private int dif;
	private Gift[] gifts;
	
	public MyPanel(int dif){
		gifts = new Gift[7];
		this.dif = dif;
		
		try {
			bg = ImageIO.read(new File("img\\bg.png"));
			catcher = ImageIO.read(new File("img\\catcher.png"));
			lose = ImageIO.read(new File("img\\lose.png"));
			
			for(int i = 0; i < 7; i++){
				gifts[i] = new Gift(ImageIO.read(new File("img\\p"+i+".png")));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		tmUpdate = new Timer(1500, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updStart();
			}
		});
		
		tmUpdate.start();
		
		tmDraw = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				repaint();
				
			}
		});
		
		tmDraw.start();
		
	}
	
	private void updStart() {
		int giftCount = 0;
		for(int i = 0; i<7; i++){
			if(!gifts[i].isActive && giftCount < dif){
				gifts[i].start();
				break;
			}else{
				giftCount++;
			}
		}
	}

	public void paintComponent(Graphics gr){
		gr.drawImage(bg, 0, 0, 800, 600, null);
		gr.drawImage(catcher, x, 465, 100, 100,null);
		
		for(int i = 0; i < 7; i++){
			gifts[i].draw(gr);
			if(gifts[i].isActive){
				if(gifts[i].y + 100 >= 470){
					if(Math.abs(gifts[i].x - x) > 75){
						gr.drawImage(lose, 200, 100, 400, 400, null);
						tmDraw.stop();
						tmUpdate.stop();
						break;
					} else {
						gifts[i].isActive = false;
					}
				}
			}
		}
	}
}
