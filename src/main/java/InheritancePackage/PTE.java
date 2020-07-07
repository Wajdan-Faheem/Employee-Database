package InheritancePackage;

public class PTE extends EmployeeInfo {
	
	double hourlyWage;
	double hoursPerWeek;
	double weeksPerYear;
	public PTE(int eN, String fN, String lN, String eG, String wL, double dR, double hW,double hPW, double wPY) {
		super(eN, fN, lN, eG, wL, dR);
		hourlyWage = hW;
		hoursPerWeek = hPW;
		weeksPerYear = wPY;
	}
	public double calcAnnualNetIncome(){
		return ((hourlyWage*hoursPerWeek)*weeksPerYear)*(1-deductionRate);
}
}