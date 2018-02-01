package Temperature_Convertor;

import java.text.DecimalFormat;

public class Model {
private double value1;
private double value2;
DecimalFormat df = new DecimalFormat("#.00");
public String celcToFahrKelv(double input) {
	value1 = (input * 5 / 9) +32;
	value2 = input + 273.15;
	String type1 = "F: ";
	String type2 = "K: ";
	String answerFormat = type1 + df.format(value1) + "," +type2 +  df.format(value2);
	return "{" + answerFormat +"}";
}
public String fahrToCelcKelv(double input) {
	value1 = (input - 32) * 5 / 9;
	value2 = (input + 459.67) * 5 / 9;
	String type1 = "C: ";
	String type2 = "K: ";
	String answerFormat = type1 + df.format(value1) + "," +type2 +  df.format(value2);
	return "{" + answerFormat +"}";
}
public String kelvToCelcFahr(double input) {
	value1 = input - 273.15;
	value2 = (input * 9 / 5) - 459.67;
	String type1 = "C: ";
	String type2 = "F: ";
	String answerFormat = type1 + df.format(value1) + "," +type2 +  df.format(value2);
	return "{" + answerFormat +"}";
}

}
