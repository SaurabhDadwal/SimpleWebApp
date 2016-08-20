package itu.oops.lab;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author FNU Manita
 * Professor Victor Yu
 * This class will create a simple employee pay calculator
 * for salaried employees, rewarded and hourly employee.
 * It will display the records of the employee in tabular fashion.
 *
 */
public class EmployeePayCalculator {

	/**
	 * @param args
	 * This method is the starting point of the program and args will be the input from user
	 */

	public static void main(String[] args) {
		double weeklySalary =0.0;
		double rate = 0.0;
		boolean rewarded = false;
		boolean allRecordsValid = true;
		//Object to scan the input entered by user
		Scanner scanner = new Scanner(System.in);
		
		//Prompt the user for no of employees to be recorded and displayed
		System.out.print("Please enter the number of employees:");
		int employeeNo = scanner.nextInt();
		
		//create an employee array with size of employee no 
		ArrayList<Employee> employeeList =new ArrayList<Employee>();
		for(int i =0; i<employeeNo; i++){
			
			//prompt user to provide name of the employee
			System.out.print("Please provide the employee name: ");
			String firstName = scanner.nextLine();
			String lastName = scanner.nextLine();
			String fullName = firstName.concat(lastName);
			
			//prompt user to provide type of the employee
			System.out.print("Please provide the employee type: ");
			String type = scanner.nextLine();
			if (validateType(type)) {
				//check the employee is salaried employee
				if(type.equalsIgnoreCase("SALARIED")){
					SalariedEmployee salariedEmployee = new SalariedEmployee();
					//salariedEmployee.setEmployeeType(Employee.SALARIED_EMPLOYEE);
					salariedEmployee.setEmpName(fullName);
					
					//prompt user to provide salary
					System.out.print("Please provide Salary: ");
					String salary = scanner.next();
					if(validateInput(salary)){
						
						weeklySalary = Double.parseDouble(salary);
						rate = weeklySalary/40.0;
						
						//prompt user to check if employee has been rewarded
						System.out.print("Bonus given to the Employee? Y/N: ");
						rewarded = scanner.next().equalsIgnoreCase("Y")? true: false;
						
						//if employee has bonus, need to know the percentage of bonus
						if(rewarded){
							salariedEmployee.setRewarded(rewarded);
							//prompt user for bonus percentage
							System.out.print("Please enter bonus % : ");
							double bonus = scanner.nextDouble();
							
							//calculate the weekly salary depending on the bonus
							weeklySalary = salariedEmployee.calculateWeeklySalary(weeklySalary, bonus);
						}
						//set the rate in the employee object
						salariedEmployee.setRate(rate);
						//set the salary in the employee object
						salariedEmployee.setWeeklySalary(weeklySalary);
						employeeList.add(salariedEmployee);
						System.out.println();
					} else {
						//salary type is not valid
						allRecordsValid = false;
					}
					
				} else if (type.equalsIgnoreCase("hourly")) {
					HourlyEmployee hourlyEmployee = new HourlyEmployee();
					//hourlyEmployee.setEmployeeType(Employee.HOURLY_EMPLOYEE);
					hourlyEmployee.setEmpName(fullName);
					//prompt for the number of hours employee worked
					System.out.print("Please provide the no of Hours worked: ");
					String hours = scanner.next();
					if(validateInput(hours)){
						//set the working hours
						hourlyEmployee.setWorkHours(Double.parseDouble(hours));
						//prompt for the per hour rate
						System.out.print("Please provide the per hour rate: ");
						String hourlyRate = scanner.next();
						System.out.println();
						if (validateInput(hourlyRate)){
							
							rate = Double.parseDouble(hourlyRate);
							
							//calculate the weekly salary of hourly employee depending on the no of hours worked and per hour rate
							weeklySalary = hourlyEmployee.calculateWeeklySalary(hourlyEmployee.getEmployeeType(), hourlyEmployee.getWorkHours(), rate);
							//set the rate and salary in the employee object
							hourlyEmployee.setRate(rate);
							//set the salary in the employee object
							hourlyEmployee.setWeeklySalary(weeklySalary);
							employeeList.add(hourlyEmployee);
						} else {
							//invalid hourly rate
							allRecordsValid = false;
						}
						
					} else {
						//invalid work hours
						allRecordsValid = false;
					}
					
				} else if (type.equalsIgnoreCase("Commissioned")) {
					CommissionedEmployee commissionEmployee = new CommissionedEmployee();
					//commissionEmployee.setEmployeeType(Employee.COMMISSIONED_EMPLOYEE);
					commissionEmployee.setEmpName(fullName);
					
					//prompt user to provide salary
					System.out.print("Please provide Weekly Sales Amount: ");
					String salesAmount = scanner.next();
					if(validateInput(salesAmount)){
						
						weeklySalary = Double.parseDouble(salesAmount);
						weeklySalary = commissionEmployee.calculateWeeklySalary(weeklySalary);
						
						commissionEmployee.setRate(0.0);
						//set the salary in the employee object
						commissionEmployee.setWeeklySalary(weeklySalary);
						employeeList.add(commissionEmployee);
						System.out.println();
					} else {
						//salary type is not valid
						allRecordsValid = false;
					}
					
					
				}
				
			} else {
				//employee type is not valid
				allRecordsValid = false;
			}
			
		}
		if (allRecordsValid) {
			//call to method to display the employee records if all records are valid
			displayEmployeeRecord(employeeList);
		}
		scanner.close();

	}
	
	/**
	 * @return nothing 
	 * This method  print the employee records in the proper format
	 */
	public static void displayEmployeeRecord(ArrayList<Employee> employees){
		boolean bonusGiven = false;
		
		//format for record display header
		System.out.println("=================================================================================");
		System.out.print("Name    ");
		System.out.print("\t \t "+"Status  ");
		System.out.print("\t "+"Hours");
		System.out.print("\t "+"Rate");
		System.out.println("\t "+"Weekly Pay Amount");
		System.out.println("=================================================================================");
		DecimalFormat df = new DecimalFormat("#.##");
		/*
		 * Iterating over the employee records and display the following details:
		 * Employee name, status, hours, rate and weekly pay amount
		 */
		for(int i =0; i<employees.size(); i++){
			
			//display employee name
			System.out.print(((Employee)employees.get(i)).getEmpName());
			//display status of the employee
			System.out.print("\t \t"+((Employee)employees.get(i)).getEmployeeType());
			//display N/A for salaried employees and hours for hourly employees
			System.out.print("\t "+((((Employee)employees.get(i)).getEmployeeType()==null||((Employee)employees.get(i)).getEmployeeType().equalsIgnoreCase("Salaried")||(employees.get(i).getEmployeeType().equalsIgnoreCase("Commissioned")))?"N/A":((Employee)employees.get(i)).getWorkHours()));
			//display hourly rate of the employee
			System.out.print("\t "+"$"+Double.valueOf(df.format(((Employee)employees.get(i)).getRate())));
			if(((Employee)employees.get(i)).isRewarded()){
				bonusGiven = true;
			}
			// display the weekly Pay amount including overtime and bonus given to employee
			
			System.out.println("\t "+"$"+Double.valueOf(df.format(((Employee)employees.get(i)).getWeeklySalary()))+(((Employee)employees.get(i)).isRewarded()?"*":""));
		}
		
		System.out.println("=================================================================================");
		//if bonus is given to any of the employee, provide the information about the percentage of bonus
		if(bonusGiven)
			System.out.println("*A 10% bonus is awarded");
		
	}
	
	/**
	 * @param String input
	 * @return boolean 
	 * This method check if the employee type is valid or not
	 */
	public static boolean validateType(String input){
		
		if(input.equalsIgnoreCase("Salaried")||input.equalsIgnoreCase("Hourly")||input.equalsIgnoreCase("Commissioned")){
			return true;
		}else{
			System.out.println("Invalid employee Type. Please provide the valid type.");
		}
		return false;
	}
	
	/**
	 * @param String input
	 * @return boolean 
	 * This method check if salary or hours or rate is valid or not
	 */
	public static boolean validateInput(String input){
	
		Pattern pattern = Pattern.compile("\\d+(\\.[0-9][0-9]?)?");
		Matcher checkMatcher = pattern.matcher(String.valueOf((input)));
		boolean find = checkMatcher.matches();
		
		if(find){
			return true;
		}else{
			System.out.println("Invalid Input. Please provide valid detail i.e. Valid Number Format. Values taken up to two decimal places");
		}
		return false;
	}


}
