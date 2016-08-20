/**
 * 
 */
package itu.oops.lab;

/**
 * @author FNU Manita
 * Professor Victor Yu
 * This class will create a blueprint of hourly employee 
 *
 */
public class HourlyEmployee extends Employee {
	
	//static constant for hourly
	public static String HOURLY_EMPLOYEE = "Hourly  ";
	
	// data field Name
	private String empName;
	// data field employeeType
	private String employeeType; 
	// data field workHours
	private double workHours;
	// data field rate
	private double rate;
	// data field weeklySalary
	private double weeklySalary;
	

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}



	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}



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



	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}



	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}



	/**
	 * @return the weeklySalary
	 */
	public double getWeeklySalary() {
		return weeklySalary;
	}



	/**
	 * @param weeklySalary the weeklySalary to set
	 */
	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}


	/**
	 * 
	 */
	public HourlyEmployee() {
		this.employeeType = HOURLY_EMPLOYEE;
	}
	
	
	/**
	 * @param empType, noOfHours, rate
	 * @return double Returns weekly salary 
	 * This method will return weekly pay amount for hourly employee
	 */
	public double calculateWeeklySalary(String empType, double noOfHours, double rate){
		double overtimeHours = 0.0;
		double weeklyPay = 0.0;
		double overtimeRate = 0.0;
		
		if(empType.equalsIgnoreCase(HOURLY_EMPLOYEE)){
			if(noOfHours > 40){
				//calculate overTimeHours
				overtimeHours = noOfHours - 40;
				overtimeRate = rate * 2;
				// calculate weekly pay for overtime
				weeklyPay = (40 * rate)+( overtimeHours * overtimeRate );
			}else{
				//calculate weekly pay for no overtime
				weeklyPay = noOfHours * rate;
			}
		}
		return weeklyPay;
		
	}
	

}
