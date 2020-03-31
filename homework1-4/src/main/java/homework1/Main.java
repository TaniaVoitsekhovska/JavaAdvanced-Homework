package homework1;


import org.apache.log4j.PropertyConfigurator;

public class Main {

    public static void main(String[] args) {

        PropertyConfigurator.configure("log4j.properties");

        MySalary mySalary = new MySalary();

        mySalary.getSalary(22.50, 120,20);
        try{
            mySalary.getSalary(22.50, -120,20);
        } catch (Exception ex){
            System.out.println(ex);
        }

        mySalary.payTaxes(5000,1000);
        try {
            mySalary.payTaxes(5000,-1000);
        }catch (Exception ex){
            System.out.println(ex);
        }

        mySalary.salaryToPay(15000,2500);
        try {
            mySalary.salaryToPay(5000,10000);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
