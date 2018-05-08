import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		String result = JOptionPane.showInputDialog(null, "Enter 1-7:", "Dif", 1);	
		
		int dif = Integer.parseInt(result);
		
		if(dif >= 1 && dif <= 7){
			new MyFrame(dif);
		} else {
			new MyFrame(7);
		}
	}

}


