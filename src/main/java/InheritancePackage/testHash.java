package InheritancePackage;

public class testHash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyHashTable theHT = new MyHashTable(10);  // Use 10 buckets for this hash table.
		
		
		EmployeeInfo removedEmployee;
		
		FTE someFTE;
		PTE somePTE;
		
		FTE removedFTE;
		PTE removedPTE;
		

		someFTE = new FTE(123456, "Bugs", "Bunny", "0", "0", 0.25, 60000.00);
		theHT.addToTable(someFTE);
		theHT.display();
		somePTE = new PTE(111111, "Daffy", "Duck", "0", "3", 0.15, 5.0, 10.0, 15.0);
		theHT.addToTable(somePTE);
		theHT.display();
		removedEmployee = theHT.removeFromTable(123456);
		if (removedEmployee != null) {
			System.out.println("Emp number of removed employee is " + Integer.toString(removedEmployee.employeeNumber));
			System.out.println("Annual salary of removed employee is " + Double.toString(removedEmployee.annualSalary));
			if (removedEmployee instanceof FTE) {
				removedFTE = (FTE) removedEmployee;
				System.out.println("Emp number of removed employee is " + Integer.toString(removedFTE.employeeNumber));
				System.out.println("Annual salary of removed employee is " + Double.toString(removedFTE.annualSalary));
			}
			if (removedEmployee instanceof PTE) {
				System.out.println("Removed employee is part time");				
			}
		}
		else {
			System.out.println("Could not find that employee in the table!");
		}
                someFTE = new FTE(24, "Bugs", "Bunny", "0", "0", 0.25, 60000.00);
		theHT.addToTable(someFTE);
		theHT.display();
                
                someFTE = new FTE(56, "Bugs", "Bunny", "0", "0", 0.25, 60000.00);
		theHT.addToTable(someFTE);
		theHT.display();
                
                someFTE = new FTE(78, "Bugs", "Bunny", "0", "0", 0.25, 60000.00);
		theHT.addToTable(someFTE);
		theHT.display();
                
		theHT.clear();
                theHT.display();
	}  // end main

}