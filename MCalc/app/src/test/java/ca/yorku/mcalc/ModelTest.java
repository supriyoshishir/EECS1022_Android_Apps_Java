// Student Name: Supriyo Ghosh
// Student ID#: 215318728
// Lab D2 is done individually
// https://youtu.be/P9beGKv4cyo

package ca.yorku.mcalc;

import org.junit.Assert;
import org.junit.Test;

public class ModelTest {
    @Test
    public void testPayment(){
        MortgageModel myModel;
        myModel = new MortgageModel("700000","25", "2.75");
        Assert.assertEquals("Test1", "$3,229.18", myModel.computePayment());

        myModel = new MortgageModel("300000","20", "4.5");
        Assert.assertEquals("Test2", "$3,000.00", myModel.computePayment());

        myModel = new MortgageModel("300000","20", "4.5");
        Assert.assertEquals("Test3", "$1,897.95", myModel.computePayment());
    }
}
