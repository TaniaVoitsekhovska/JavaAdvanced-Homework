public class MySalary {

    public double getSalary(double hourPayment, int hoursToWorkPerMonth, int hoursOfDisease) {
        double salaryToReceive = (hoursToWorkPerMonth - hoursOfDisease) * hourPayment;
        return salaryToReceive;
    }

    public double payTaxes(double salary, double taxeRate) {
        double taxesToPay = salary * taxeRate / 100;
        return taxesToPay;
    }

    public double salaryToPay(double salary, double taxes) {
        if (taxes > salary) {
            throw new IllegalArgumentException("Value of taxes can't be more then salary");
        }
        return salary - taxes;
    }


}
