package assignment;


import javax.swing.SwingUtilities;
import assignment.InvertedIndex;


public class GUI {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
		Window exe = new Window(new InvertedIndex());
		exe.setVisible(true);
		
			
	

		
}
});
	}
}


