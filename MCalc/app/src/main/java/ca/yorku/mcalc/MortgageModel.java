// Student Name: Supriyo Ghosh
// Student ID#: 215318728
// Lab D2 is done individually
// https://youtu.be/P9beGKv4cyo

package ca.yorku.mcalc;

public class MortgageModel {

    public double P;
    public int n;
    public double r;

    public MortgageModel(String p, String a, String i) {
        this.P = Double.parseDouble(p);
        this.n = Integer.parseInt(a);
        this.r = Double.parseDouble(i);
    }

    public String computePayment() {
        double P = this.P;
        int n = (this.n * 12);
        double r = (this.r / (12 * 100));
        double formula = (r * P) / (1 - Math.pow((1 + r), -n));
        String result = String.format("$" + "%,.2f", formula);
        return result;
    }
}