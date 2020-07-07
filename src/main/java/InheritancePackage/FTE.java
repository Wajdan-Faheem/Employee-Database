package InheritancePackage;

public class FTE extends EmployeeInfo {
        public double annualSalary; 
	public double annualNetIncome;
	public FTE(int eN, String fN, String lN, String eG, String wL,double dR, double aS) {
		super(eN, fN, lN, eG, wL, dR);
                annualSalary = aS;
	}
public double calcAnnualNetIncome(){
	return annualSalary*(1-deductionRate);
}
}
