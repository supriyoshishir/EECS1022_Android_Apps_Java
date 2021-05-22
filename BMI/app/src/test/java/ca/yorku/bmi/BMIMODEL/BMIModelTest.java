// Student Name: Supriyo Ghosh
// Student ID#: 215318728
// Lab D1 done individually.

package ca.yorku.bmi.BMIMODEL;

import org.junit.Test;
import ca.roumani.i2c.Utility;

public class BMIModelTest
{
    @Test
    public void getBMITest()
    {
        double w, h;
        System.out.println("Testing BMI.getBMI: ");
        w = 90; h = 1.8;
        System.out.println(w + "," + h);
        System.out.println(BMIModel.getBMI(w, h));

        System.out.println(Utility.repeat(30, '-'));

        w = 85; h = 0.5 + 2.5 * Math.random();
        System.out.println(w + "," + h);
        System.out.println(BMIModel.getBMI(w, h));
    }

    @Test
    public void toDoubleTest()
    {
        String s = "135790";
        System.out.println(s);
        System.out.println(BMIModel.toDouble(s));

        System.out.println(Utility.repeat(30, '-'));

        s = "8642.20";
        System.out.println(s);
        System.out.println(BMIModel.toDouble(s));
    }

    @Test
    public void formatBMITest()
    {
        double bmi = 225.25;
        System.out.println(bmi);
        System.out.println(BMIModel.formatBMI(bmi));

        System.out.println(Utility.repeat(30, '-'));

        bmi = 2468.135;
        System.out.println(bmi);
        System.out.println(BMIModel.formatBMI(bmi));
    }
}