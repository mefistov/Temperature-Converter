package Temperature_Convertor;

public class Main {
	
		public static void main(String[] args) {
				
				View theView             = new View(); 
				Model theModel           = new Model();
				Controller CController = new Controller(theView, theModel);
				
				theView.setVisible(true);
				
				

		}
}
