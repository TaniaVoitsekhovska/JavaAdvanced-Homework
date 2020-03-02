package homework1;

import org.apache.log4j.Logger;

public class MySalary {

    private static final Logger log = Logger.getLogger(MySalary.class);

    public double getSalary(double hourPayment, int hoursToWorkPerMonth, int hoursOfDisease) {

        log.info(String.format("Calling getSalary method with parameters  hourPayment = %.2f, hoursToWorkPerMonth= %d," +
                " hoursOfDisease = %d", hourPayment, hoursToWorkPerMonth, hoursOfDisease));
        if (hourPayment < 0) {
            log.error("hourPayment can't be negative, trowing IllegalArgumentException");
            throw new IllegalArgumentException("hourPayment can't be negative!");
        }
        if (hoursToWorkPerMonth < 0) {
            log.error("hoursToWorkPerMonth can't be negative, trowing IllegalArgumentException");
            throw new IllegalArgumentException("hoursToWorkPerMonth can't be negative!");
        }
        if (hoursOfDisease < 0) {
            log.error("hoursOfDisease can't be negative, trowing IllegalArgumentException");
            throw new IllegalArgumentException("hoursOfDisease can't be negative!");
        }
        double salaryToReceive = (hoursToWorkPerMonth - hoursOfDisease) * hourPayment;
        return salaryToReceive;
    }

    public double payTaxes(double salary, double taxeRate) {
        log.info(String.format("Calling payTaxes method with parameters salary= %.2f," +
                " taxeRate = %.2f", salary, taxeRate));
        if (salary < 0) {
            log.error("Salary can't be negative, trowing IllegalArgumentException");
            throw new IllegalArgumentException("Salary can't be negative!");
        }
        if (taxeRate < 0) {
            log.error("taxeRate can't be negative, trowing IllegalArgumentException");
            throw new IllegalArgumentException("taxeRate can't be negative!");
        }
        double taxesToPay = salary * taxeRate / 100;
        return taxesToPay;
    }

    public double salaryToPay(double salary, double taxes) {
        log.debug(String.format("Calling salaryToPay method with parameters salary= %.2f," +
                " taxes = %.2f", salary, taxes));

        if (taxes > salary) {
            log.error("Value of taxes can't be more then salary, trowing IllegalArgumentException");
            throw new IllegalArgumentException("Value of taxes can't be more then salary");
        }
        return salary - taxes;
    }
}
