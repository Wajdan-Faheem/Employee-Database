package InheritancePackage;
import java.util.*;
public class MyHashTable {
    // ATTRIBUTES

    // buckets is an array of ArrayList.  Each item in an ArrayList is a EmployeeInfo
    // object holding a reference value pointing to a student.
    public ArrayList<EmployeeInfo>[] buckets;

    // CONSTRUCTOR

    public MyHashTable(int howManyBuckets) {
        // Construct the hash table (open hashing/closed addressing) as an array of howManyBuckets ArrayLists.

        // Instantiate buckets as an array to have an ArrayList as each element of the array.
        buckets = new ArrayList[howManyBuckets];

        // For each element in the array, instantiate its ArrayList.
        for (int i = 0; i < howManyBuckets; i++) {
            buckets[i] = new ArrayList();  // Instantiate the ArrayList for bucket i.
        }
    }


    // METHODS

    public int calcBucket(int employeeNumber) {
        return (employeeNumber % buckets.length);
    }

    public void addToTable(EmployeeInfo theEmployee) {
        buckets[calcBucket(theEmployee.employeeNumber)].add(theEmployee);
        // Add the student referenced by theEmployee to the hash table.
    }

    public EmployeeInfo removeFromTable(int employeeNumber) {
        EmployeeInfo temp = getFromTable(employeeNumber);
        buckets[calcBucket(employeeNumber)].remove(getFromTable(employeeNumber));
        return temp;
    }
    public void clear(){
        for (int i = 0; i < buckets.length;i++){
            for (int c = 0;c < buckets[i].size();c++){
                buckets[i].remove(c);
            }
    }
    }
    public EmployeeInfo getFromTable(int employeeNumber) {
        // Return the reference value for that student, return null if student isn't in the table.
        EmployeeInfo temp = null;
        for (EmployeeInfo info: buckets[calcBucket(employeeNumber)]) {
            if (info.employeeNumber == employeeNumber) {
                temp = info;
                break;
            }
        }
        return temp;
    }

    public boolean isInTable ( int employeeNumber){
        boolean temp = false;
        if (getFromTable(employeeNumber)!=null){
            temp = true;
        }
        return temp; // Return true if that student is in the hash table, false otherwise.
    }
    
    public void editInTable(int eN){
        
    }

    //New method to visualize the data structure
    public void display(){
        System.out.println("<Displaying all lists>");
        for(int i = 0; i < buckets.length; i++){
            if(buckets[i].size() > 0) {
                System.out.println("Bucket[" + i + "]: ");
                for (int c = 0; c < buckets[i].size(); c++) {
                  System.out.println(buckets[i].get(c) + " ");
                }
            }
            else{
                System.out.println("Bucket[" + i + "]: \nNothing");
            }
        }
        System.out.println();
    }

}