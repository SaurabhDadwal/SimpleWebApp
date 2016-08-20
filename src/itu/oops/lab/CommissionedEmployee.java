/**
 * 
 */
package itu.oops.lab;
/**
 * @author FNU Manita
 * Professor Victor Yu
 * This class will create a blueprint of Commission Based employee 
 *
 */
public class CommissionedEmployee extends Employee {
	
	//static constant for commissioned 
	public static String COMMISSIONED_EMPLOYEE = "Commissioned";
	//static constant for base amount
	private static double WEEKLY_BASE_AMT = 500.0;
	//static constant for commission
	private static double COMM_AMT = 10.0;
	
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
	 * default constructor
	 */
	public CommissionedEmployee() {
		this.employeeType = COMMISSIONED_EMPLOYEE;
		
	}
	
	/**
	 * @param weeklySalary, commission
	 * @return double Returns weekly salary 
	 * This method will return weekly pay amount for commissioned employee
	 */
	public double calculateWeeklySalary(double weeklySales){
		
		double weeklySalary = 0;
		//formula for calculating weekly salary if bonus is provided
		if(weeklySalary>=0){
			weeklySalary = WEEKLY_BASE_AMT + ((COMM_AMT/ 100.0)* weeklySales);
		}else{
			weeklySalary = WEEKLY_BASE_AMT;
		}
		return weeklySalary;
		
	}

}
