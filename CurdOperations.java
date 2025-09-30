import java.util.Scanner;
import java.util.HashMap;
import java.util.ArraysList;
class Database{
    private int emplyNo;
    private String empName;
    private float salary;
    Database(int emplyNo, String empName, float salary){
        this.emplyNo=emplyNo;
        this.empName=empName;
        this.salary=salary;
    }
    int getEmplyNo(){
        return emplyNo;
    }
    String getEmpName(){
        return empName;
    }
    float getSalary(){
        return salary;
    }
    void setEmpName(String empName){
        this.empName=empName;
    }
    void setSalary(float salary){
        this.salary=salary;
    }
    @Override
    public String toString(){
       // System.out.println("Employee Number: "+emplyNo+"\nEmployee Name: "+empName+"\n Employee Salary"+salary);
        //return "Database[Employee Number: "+emplyNo+"\nEmployee Name: "+empName+"\n Employee Salary"+salary+"]";
        //return "|"+"Employee Number: "+emplyNo+"|\tEmployee Name: "+empName+"|\tEmployee Salary"+salary+"|";
        return emplyNo+"\t"+empName+"\t"+salary;
    }
}
public class CurdOperations {
    public static void main(String[] args) {
        //ArrayList<Database> al=new ArrayList<Database>();
        HashMap<Integer,Database> hm=new HashMap<Integer,Database>();
        Scanner sc=new Scanner(System.in);
        Database ed1=new Database(2001,"Ramesh  ",120000.0f);
        Database ed2=new Database(2002,"Harsha  ", 150000.0f);
        Database ed3=new Database(2003,"Vaishnavi", 130000.0f);
        Database ed4=new Database(2004,"Bhargav " , 150000.0f);
        Database ed5 =new Database(2005,"Guru       ", 120000.0f);
        Database ed6=new Database(2006,"Dinesh  ", 130000.0f);
        Database ed7=new Database(2007,"Azeem   ", 140000.0f);
       for(int i=1;i<=7;i++){
        hm.put(ed1.getEmplyNo(),ed1);
        hm.put(ed2.getEmplyNo(),ed2);
        hm.put(ed3.getEmplyNo(),ed3);
        hm.put(ed4.getEmplyNo(),ed4);
        hm.put(ed5.getEmplyNo(),ed5);
        hm.put(ed6.getEmplyNo(),ed6);
        hm.put(ed7.getEmplyNo(),ed7);
       }
      int opt=0;
       while(opt!=7){
         System.out.println("Enter your option:\n1.Insert\n2.Read\n3.Update\n4.Delete\n5.Display All\n6.Find\n7.Exit");
       opt=sc.nextInt();
       switch (opt) {
        case 1->{
            
            System.out.println("Enter Employee Number:");
            int empNo=sc.nextInt();
            sc.nextLine();
            if(hm.containsKey(empNo)){
                System.out.println("Employee Number already exists. Please use a different number.");
                break;
            }
            System.out.println("Enter Employee Name:");
            String empName=sc.nextLine();
            System.out.println("Enter Employee Salary:");
            float empSal=sc.nextFloat();
            Database ed=new Database(empNo,empName,empSal);
            hm.put(ed.getEmplyNo(),ed); 
            System.out.println("Record Inserted Successfully");
        }
        case 2->{
            System.out.println("Enter Employee Number to Read:");
            int empNo=sc.nextInt();
            if(hm.containsKey(empNo)){
                System.out.println("Employee Details:");
                System.out.println("EmplyNo\tEmpName  \tSalary");
                System.out.println("-----------------------------------");
                System.out.println(hm.get(empNo));
            }
            else{
                System.out.println("Employee Number not found");
            }
        }
        case 3->{
            System.out.println("Enter Employee Number to Update:");
            int empNo=sc.nextInt();
            sc.nextLine();
            if(hm.containsKey(empNo)){
                Database ed=hm.get(empNo);
                System.out.println("Enter New Employee Name:");
                String empName=sc.nextLine();
                ed.setEmpName(empName);
                System.out.println("Enter New Employee Salary:");
                float empSal=sc.nextFloat();
                ed.setSalary(empSal);
                System.out.println("Record Updated Successfully");
            }
            else{
                System.out.println("Employee Number not found");
            }

        }
        case 4->{
            System.out.println("Enter Employee Number to Delete:");
            int empNo=sc.nextInt();
            if(hm.containsKey(empNo)){
                hm.remove(empNo);
                System.out.println("Record Deleted Successfully");
            }
            else{
                System.out.println("Employee Number not found");
            }
        }
        case 5->{
            System.out.println("Employee Details:");
            System.out.println("EmplyNo\tEmpName  \tSalary");
            System.out.println("-----------------------------------");
            for(Database ed:hm.values()){
                System.out.println(ed);
            }

        }
        case 6->{
            System.out.println("Enter Employee Number to Find:");
            int empNo=sc.nextInt();
            if(hm.containsKey(empNo)){
                System.out.println("Employee Details:");
                System.out.println("EmplyNo\tEmpName  \tSalary");
                System.out.println("-----------------------------------");
                System.out.println(hm.get(empNo));
            }
            else{
                System.out.println("Employee Number not found");
            }
        }
        case 7-> System.out.println("Exiting...");
       
        default-> System.out.println("Invalid Option");
       }

    }
    System.out.println("Thank you for using the Employee Management System.");
}
}



    

