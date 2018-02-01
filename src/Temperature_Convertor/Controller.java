package Temperature_Convertor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class Controller {
	
	private View     theView;
	private Model    theModel;
	private String   operation;
	
	public Controller(View theView, Model theModel){
		
			this.theView     = theView;
			this.theModel    = theModel;
			this.theView.addCalculationListener(new CalculateListener());
			this.theView.addButtonListener(new ButtonListener());
	}
		
	class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			CalculateListener obj = new CalculateListener();
			double input = 0;
			
			String action = e.getActionCommand();
			if(action.equals("Result")){
				try{
							input = theView.getFirstNumber();
							
							switch(operation){
					
								case "Celsius to Fahrenheit, Kelvin" :
									theView.setCalcSolution(theModel.celcToFahrKelv(input));
									break;
								case "Fahrenheit to Celsius, Kelvin" :
									theView.setCalcSolution(theModel.fahrToCelcKelv(input));
									break;
								case "Kelvin to Celsius, Fahrenheit" :
									theView.setCalcSolution(theModel.kelvToCelcFahr(input));
									break;
							}
					}
					catch(Exception ex){
						theView.displayErrorMessage("Error! Insert an appropriate value, or choose operation!");
					}
			}
			
		}
	}
	
	class CalculateListener implements ActionListener{
		ButtonListener obj = new ButtonListener();
		
		public void actionPerformed(ActionEvent e) {			
			if(e.getSource() == theView.getOperationsList() ){
					JComboBox cb = (JComboBox)e.getSource();
					 operation = (String)cb.getSelectedItem();
					obj.actionPerformed(e);
			}
		}
		
	}
	
}