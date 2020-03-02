package homework1;

import homework1.MySalary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class MySalaryTest {

    private MySalary mySalary;

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        protected void failed(Throwable e, org.junit.runner.Description description) {
            System.out.println("FAILED--> " + description.getMethodName());
        }


        protected void succeeded(org.junit.runner.Description description) {
            System.out.println("SUCCEED--> " + description.getMethodName());
        }
    };

    @Before
    public void beforeTest() {
        mySalary = new MySalary();
    }

    @Test
    public void getSalaryTest() {
        double salary = mySalary.getSalary(53.10, 166, 40);
        double expectedSalary = 6690.60;

        Assert.assertEquals(expectedSalary, salary, 0.01);
    }

    @Test
    public void getTaxesValueToPayTest() {
        double taxes = mySalary.payTaxes(6690.60, 40.53);
        double expectedTaxes = 2711.70;

        Assert.assertEquals(expectedTaxes, taxes, 0.01);
    }

    @Test
    public void salaryToReceiveTest() {
        double salaryToReceive = mySalary.salaryToPay(6690.60, 2711.70);
        double expectedSalaryToReceive = 3978.90;

        Assert.assertEquals(expectedSalaryToReceive, salaryToReceive, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void salaryToReceiveExceptionTest() {
        double salaryToReceive = mySalary.salaryToPay(6690.60, 7711.70);
        double expectedSalaryToReceive = 3978.90;

        Assert.assertEquals(expectedSalaryToReceive, salaryToReceive, 0.01);
    }


}
