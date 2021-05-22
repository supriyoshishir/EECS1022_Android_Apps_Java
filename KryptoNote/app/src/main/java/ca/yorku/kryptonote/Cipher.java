// Student Name: Supriyo Ghosh
// Student ID#: 215318728
// Lab D4 is done individually
// https://youtu.be/Qw_0-hKNpjI

package ca.yorku.kryptonote;

public class Cipher {
    private String key;
    public static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Cipher (String k)
    {
        this.key = k;
    }

    private String makePad(String note)
    {
        String pad = this.key;
        for (; pad.length() < note.length(); )
        {
            pad += this.key;
        }
        return pad;
    }

    public String encrypt(String note)
    {
        String pad = makePad(note);
        String result = "";
        for (int i = 0; i < note.length(); i++)
        {
            String c = note.substring(i, i + 1);
            int position = ALPHABET.indexOf(c);
            int shift = Integer.parseInt(pad.substring(i, i + 1));
            int newPosition = (position + shift) % ALPHABET.length();
            result = result + ALPHABET.substring(newPosition, newPosition + 1);
        }
        return result;
    }

    public String decrypt(String note)
    {
        String pad = makePad(note);
        String result = "";
        for (int i = 0; i < note.length(); i++)
        {
            String c = note.substring(i, i + 1);
            int position = ALPHABET.indexOf(c);
            int shift = Integer.parseInt(pad.substring(i, i + 1));
            int newPosition = (position - shift);
            if (newPosition < 0)
            {
                newPosition = ALPHABET.length() + newPosition;
            }
            result = result + ALPHABET.substring(newPosition, newPosition + 1);
        }
        return result;
    }

    /*
    public static void main(String[] args)
    {
        String testKey = "2121";
        Cipher testModel = new Cipher(testKey);
        String testNote = "ABCDEF";
        String encryptedNote = testModel.encrypt(testNote);
        String decryptedNote = testModel.decrypt(encryptedNote);
        System.out.println(encryptedNote);
        System.out.println(decryptedNote);
    }
     */
}
