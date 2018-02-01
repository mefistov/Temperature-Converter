package Temperature_Convertor;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;


	public class View extends JFrame{
				
			private JTextField input         = new JTextField (10);
			private JTextField solution      = new JTextField(20);
			private JLabel label             = new JLabel("First Number: ");
			private JButton btn              = new JButton("Result");
		
			private String [] operations     = {"Choose a conversion method", "Celsius to Fahrenheit, Kelvin",
					                            "Fahrenheit to Celsius, Kelvin", "Kelvin to Celsius, Fahrenheit"};
			private JComboBox operationsList = new JComboBox(operations);
			
			View(){
				JPanel calcPanel = new JPanel();
				
				this.setLayout(new FlowLayout());
				this.setTitle("Temperature Converter");
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setSize(800,100);
				
				operationsList.setSelectedIndex(0);
				
				calcPanel.add(label);
				calcPanel.add(input);
				calcPanel.add(operationsList);
				calcPanel.add(btn);
				calcPanel.add(solution);
				
				this.add(calcPanel);
			}
			
			public JComboBox getOperationsList(){
				return operationsList;
			}
			
			public int getFirstNumber(){
				return Integer.parseInt(input.getText());
			}
			
			public int getCalcSolution(){
				return Integer.parseInt(solution.getText());
			}
			
			public void setCalcSolution(String solution){
				this.solution.setText(solution);
				
			}
			
		
			void addButtonListener(ActionListener listenerForButton){
					btn.addActionListener(listenerForButton);
			}
			
			void addCalculationListener(ActionListener listenerForCalcButton){
					operationsList.addActionListener(listenerForCalcButton);
			}
			
			void displayErrorMessage(String errorMessage){
					JOptionPane. showMessageDialog(this, errorMessage);
			}
	}