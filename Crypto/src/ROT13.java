import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

import java.util.HashMap;
import java.util.Map;



public class ROT13 {
   Character cf=' ';
   Character cs =' ';


    ROT13(Character cs, Character cf) {
        this.cs=cs;
        this.cf=cf;
    }

    ROT13() {

        this.cs=' ';
        this.cf =' ';

    }


    public String crypt(String text)  {

        return encrypt(text);
    }

    public String encrypt(String text) {
        String result = "";

        char[] chArr = text.toLowerCase().toCharArray();

        for (char ch : chArr) {
            if ((ch == ' ') || (ch == '?') || (ch == '!')) {

                result += ch;
            } else

                result += getChar(ch).charValue();



        }
        return result.substring(0, 1).toUpperCase() + result.substring(1);
    }




    public String decrypt(String text) {
        return encrypt(text);
    }

    public static String rotate(String s, Character c) {


       if ((s.charAt(0) =='A') && (c == 'A')) {

           return s;
       }
           StringBuilder sb = new StringBuilder();
           for (int i = (s.length() / 2); i < s.length(); i++) {
               sb.append(s.charAt(i));
           }
           for (int j = 0; j < s.length() / 2; j++) {
               sb.append(s.charAt(j));
           }
           return sb.toString();



    }

    public Character getChar(Character ch) {

        Map<Character, Character> mymap = new HashMap();

        for (int i = 97; i < 122; i++) {

            if (i < 110) {

                mymap.put((char) i, (char) (i + 13));
            } else {

                mymap.put((char) i, (char) (i - 13));


            }


        }
        return mymap.get(ch);


    }
}
