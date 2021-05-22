// Student Name: Supriyo Ghosh
// Student ID#: 215318728
// Lab D5 is done individually
// https://youtu.be/bF01Xbz1Nn8

package ca.yorku.caps;

import java.util.List;
import java.util.Map;
import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game {

    public CountryDB db;

    public Game() {
        this.db = new CountryDB();
    }

    public String qa() {
        List<String> capitals = db.getCapitals();
        System.out.println(capitals.size());
        int n = capitals.size();
        int index = (int) (n * Math.random());
        String c = capitals.get(index);
        System.out.println(c);

        Map<String, Country> data = db.getData();
        System.out.println(data.size());
        Country ref = data.get(c);
        System.out.println(ref.toString());

        String question;
        if (Math.random() < 0.5) {
            question = ref.getCapital() + " is the capital of?\n" + ref.getName();
        }
        else {
            question = "What is the capital of " + ref.getName() + "?\n" + ref.getCapital();
        }
        return question;
    }

/*    public static void main(String[] args) {
        Game myModel = new Game();
        System.out.println(myModel.qa());
    }*/
}