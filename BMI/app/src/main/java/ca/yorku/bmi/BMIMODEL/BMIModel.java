// Student Name: Supriyo Ghosh
// Student ID#: 215318728
// Lab D1 done individually
// https://youtu.be/Uj5MADIajRA

package ca.yorku.bmi.BMIMODEL;

public class BMIModel
{
    public static double toDouble(String s)
    {
        return Double.parseDouble(s);
    }
    public static double getBMI(double weight, double height)
    {
        double result = weight / (height * height);
        return result;
    }
    public static String formatBMI(double bmi)
    {
        return String.format("%.1f", bmi);
    }
}
