/**
 * 
 */
package demo;

import java.util.Scanner;

/**
 * @author DELL
 *
 */
public class EmployeeSalaryCalculator {
	
	private static String SALARIED_EMPLOYEE = "Salaried";
	
	private static String HOURLY_EMPLOYEE = "Hourly  ";
	
	private static String NOT_APPLICABLE = "N/A";
		
	private String employeeType; 
	
	private double workHours;
	

	/**
	 * @return the employeeType
	 */
	public String getEmployeeType() {
		return employeeType;
	}

	/**
	 * @param employeeType the employeeType to set
	 */
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	/**
	 * @return the workHours
	 */
	public double getWorkHours() {
		return workHours;
	}

	/**
	 * @param workHours the workHours to set
	 */
	public void setWorkHours(double workHours) {
		this.workHours = workHours;
	}
	
	public static double calculateWeeklyPay(String empType, double noOfHours, double rate){
		
		double overtimeHours = 0.0;
		double weeklyPay = 0.0;
		double overtimeRate = 0.0;
		
		if(empType.equalsIgnoreCase(EmployeeSalaryCalculator.HOURLY_EMPLOYEE)){
			if(noOfHours > 40){
			overtimeHours = noOfHours - 40;
			overtimeRate = rate * 2;
			weeklyPay = (40 * rate)+( overtimeHours * overtimeRate );
			}else{
				weeklyPay = noOfHours * rate;
			}
		}else if (empType.equalsIgnoreCase(EmployeeSalaryCalculator.SALARIED_EMPLOYEE)) {
			weeklyPay = rate * 40;
		}
		
		return weeklyPay;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[][] employeeReport = new String[1][5];
		
		String name = null;
		String type = null;
		double hours = 0.0;
		double weeklySalary =0.0;
		double rate = 0.0;
		double weeklyamount = 0.0;
		boolean rewarded = false;
		
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<employeeReport.length; i++){
			System.out.println("Name: ");
			employeeReport[i][0] = scanner.next();
			System.out.println("Status: ");
			employeeReport[i][1] = scanner.next();
			if(employeeReport[i][1].equalsIgnoreCase(EmployeeSalaryCalculator.SALARIED_EMPLOYEE)){
				employeeReport[i][1] = EmployeeSalaryCalculator.SALARIED_EMPLOYEE;
				employeeReport[i][2] = EmployeeSalaryCalculator.NOT_APPLICABLE;
				
				System.out.println("Weekly Salary: ");
				employeeReport[i][4] = scanner.next();
				weeklySalary = Double.parseDouble(employeeReport[i][4]);
				employeeReport[i][3] = String.valueOf(weeklySalary/40.0);
				System.out.println("Rewarded Salaried Employee? Y/N:");
				rewarded = scanner.next().equalsIgnoreCase("Y")? true: false;
				if(rewarded){
					weeklySalary+= (.10* weeklySalary);
					employeeReport[i][4] = String.valueOf(weeklySalary).concat("*");
				}
				
			}else{
				employeeReport[i][1] = EmployeeSalaryCalculator.HOURLY_EMPLOYEE;
				System.out.println("Hours: ");
				hours = scanner.nextDouble();
				System.out.println("Rate: ");
				rate = scanner.nextDouble();
				employeeReport[i][2] = String.valueOf(hours);
				employeeReport[i][3] = String.valueOf(rate);
				employeeReport[i][4] = String.valueOf(calculateWeeklyPay(employeeReport[i][1], hours , rate));
			}
			
		}
		/*System.out.println("Employee_Name: ");
		name = scanner.next();
		System.out.println("Status: ");
		type = scanner.next();
		if(type.equalsIgnoreCase(EmployeeSalaryCalculator.SALARIED_EMPLOYEE)){
			type = EmployeeSalaryCalculator.SALARIED_EMPLOYEE;
			System.out.println("Weekly Salary: ");
			weeklySalary = scanner.nextDouble();
			rate = weeklySalary/8.0;
			weeklyamount = weeklySalary;
		}else{
			type = EmployeeSalaryCalculator.HOURLY_EMPLOYEE;
			System.out.println("Hours: ");
			hours = Double.parseDouble(scanner.next());
			System.out.println("Rate: ");
			rate = Double.parseDouble(scanner.next());
			weeklySalary = calculateWeeklyPay(type, hours, rate);
			weeklyamount = weeklySalary;
		}*/
		
		System.out.println("====================================================================================================");
		System.out.print("Name");
		System.out.print("\t \t"+"Status  ");
		System.out.print("\t \t"+"Hours");
		System.out.print("\t \t"+"Rate");
		System.out.println("\t \t"+"Weekly Pay Amount");
		
		for(int i =0; i<employeeReport.length; i++){
			for(int j =0; j<employeeReport[i].length; j++){
				if(j==0){
					System.out.print(employeeReport[i][j].toString());
				}else if(j == (employeeReport[i].length-1)){
					System.out.println("\t \t"+employeeReport[i][j].toString());
				}else{
					System.out.print("\t \t"+employeeReport[i][j].toString());
				}
				
				
			}
		}
//		System.out.print(name);
//		System.out.print("\t \t"+ type);
//		if(type.equalsIgnoreCase(EmployeeSalaryCalculator.SALARIED_EMPLOYEE)){
//			System.out.print("\t"+"N/A");
//		}else{
//			System.out.print("\t \t"+ hours);
//		}
//		System.out.print("\t \t"+ rate);
//		System.out.println("\t \t" + weeklyamount);
			
		
		System.out.println("====================================================================================================");
		if(rewarded)
			System.out.println("*A 10% bonus is awarded");
		scanner.close();
	}

}
