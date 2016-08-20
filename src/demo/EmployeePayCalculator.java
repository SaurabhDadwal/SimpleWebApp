/**
 * 
 */
package demo;

import itu.oops.lab.Employee;

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
		Employee[] employeearray =new Employee[employeeNo];
		for(int i =0; i<employeearray.length; i++){
			employeearray[i] = new Employee();
			
			//prompt user to provide name of the employee
			System.out.print("Please provide the employee name: ");
			String firstName = scanner.nextLine();
			String lastName = scanner.nextLine();
			employeearray[i].setEmpName(firstName+lastName);
			
			//prompt user to provide type of the employee
			System.out.print("Please provide the employee type: ");
			String type = scanner.nextLine();
			if (validateType(type)) {
				employeearray[i].setEmployeeType(type);
				//check the employee is salaried employee 
				if(type.equalsIgnoreCase(Employee.SALARIED_EMPLOYEE)|| type.equalsIgnoreCase("CommissionBasedEmployee")){
					
					employeearray[i].setEmployeeType(Employee.SALARIED_EMPLOYEE);
					
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
							employeearray[i].setRewarded(rewarded);
							//prompt user for bonus percentage
							System.out.print("Please enter bonus % : ");
							double bonus = scanner.nextDouble();
							//calculate the weekly salary depending on the bonus
							weeklySalary = employeearray[i].calculateWeeklySalary(weeklySalary, bonus);
						}
						
					}else{
						allRecordsValid = false;
					}
					
				}else if (type.equalsIgnoreCase("hourly")) {
					
					employeearray[i].setEmployeeType(Employee.HOURLY_EMPLOYEE);
					
					//prompt for the number of hours employee worked
					System.out.print("Please provide the no of Hours worked: ");
					String hours = scanner.next();
					
					if (validateInput(hours)) {
						employeearray[i].setWorkHours(Double.parseDouble(hours));
						//prompt for the per hour rate
						System.out.print("Please provide the per hour rate: ");
						String hourlyRate = scanner.next();
							if (validateInput(hourlyRate)){
								rate = Double.parseDouble(hourlyRate);
								//calculate the weekly salary of hourly employee depending on the no of hours worked and per hour rate
								weeklySalary = employeearray[i].calculateWeeklySalary(employeearray[i].getEmployeeType(), employeearray[i].getWorkHours(), rate);
							} else{
								//invalid hourly rate
								allRecordsValid = false;
							}
												
					} else {
						//invalid work hours
						allRecordsValid = false;
					}
					
				}
				//set the rate and salary in the employee object
				employeearray[i].setRate(rate);
				employeearray[i].setWeeklySalary(weeklySalary);
				
			}else {
				//invalid employee type
				allRecordsValid = false;
			}
			
	}
		if (allRecordsValid) {
			//call to method to display the employee records if all records are valid
			displayEmployeeRecord(employeearray);
		}
		scanner.close();
		
	}
	
	/**
	 * @return nothing 
	 * This method  print the employee records in the proper format
	 */
	public static void displayEmployeeRecord(Employee[] employees){
		boolean bonusGiven = false;
		
		//format for record display header
		System.out.println("=================================================================================");
		System.out.print("Name   ");
		System.out.print("\t \t "+"Status  ");
		System.out.print("\t "+"Hours");
		System.out.print("\t "+"Rate");
		System.out.println("\t "+"Weekly Pay Amount");
		System.out.println("=================================================================================");
		
		/*
		 * Iterating over the employee records and display the following details:
		 * Employee name, status, hours, rate and weekly pay amount
		 */
		for(int i =0; i<employees.length; i++){
			//display employee name
			System.out.print(employees[i].getEmpName());
			//display status of the employee
			System.out.print("\t \t"+employees[i].getEmployeeType());
			//display N/A for salaried employees and hours for hourly employees
			System.out.print("\t "+((employees[i].getEmployeeType()==null||employees[i].getEmployeeType().equalsIgnoreCase("Salaried"))?"N/A":employees[i].getWorkHours()));
			//display hourly rate of the employee
			System.out.print("\t "+"$"+employees[i].getRate());
			if(employees[i].isRewarded()){
				bonusGiven = true;
			}
			// display the weekly Pay amount including overtime and bonus given to employee
			System.out.println("\t "+"$"+employees[i].getWeeklySalary()+(employees[i].isRewarded()?"*":""));
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
		
		if(input.equalsIgnoreCase("Salaried")||input.equalsIgnoreCase("Hourly")){
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
	
		Pattern pattern = Pattern.compile("\\d+");
		Matcher checkMatcher = pattern.matcher(String.valueOf((input)));
		boolean find = checkMatcher.matches();
		
		if(find){
			return true;
		}else{
			System.out.println("Invalid Input. Please provide valid detail i.e. Valid Number Format. ");
		}
		return false;
	}

}
