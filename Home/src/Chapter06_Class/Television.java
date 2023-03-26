package Chapter06_Class;

public class Television {
	static String company = "MyCompany";
	static String model = "LCD";
	static String info;
	
	static {
		info = company + "-" + model;
	}
}
