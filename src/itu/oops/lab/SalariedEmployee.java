/**
 * 
 */
package itu.oops.lab;

/**
 * @author FNU Manita
 * Professor Victor Yu
 * This class will create a blueprint of salaried employee 
 *
 */
public class SalariedEmployee extends Employee {
	
	//static constant for salaried
	public static String SALARIED_EMPLOYEE = "Salaried";
	
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
	// data field rewarded
	private boolean rewarded;

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
	 * @return the rewarded
	 */
	public boolean isRewarded() {
		return rewarded;
	}

	/**
	 * @param rewarded the rewarded to set
	 */
	public void setRewarded(boolean rewarded) {
		this.rewarded = rewarded;
	}

	/**
	 * Default Constructor
	 */
	public SalariedEmployee() {
		this.employeeType = SALARIED_EMPLOYEE;
	}
	
	/**
	 * @param weeklySalary, commission
	 * @return double Returns weekly salary 
	 * This method will return weekly pay amount for salaried employee
	 */
	public double calculateWeeklySalary(double weeklySalary, double commission){
		
		//formula for calculating weekly salary if bonus is provided
		if(commission>=0){
			weeklySalary+= ((commission/ 100.0)* weeklySalary);
		}
		return weeklySalary;
		
	}

}
