package Question3;

import java.util.ArrayList;
import java.util.List;

public class NewString implements Comparable<NewString>{
    // use character array to store data
    private final char[] chars;

    // constructor of NewString
    public NewString(NewString ns){
        // transfer NewString into a char array
        char[] ch = ns.toChars();
        int n = ch.length;
        // initialize chars and copy the element in ch into chars
        chars = new char[n];
        for(int i = 0; i < n; i++){
            chars[i] = ch[i];
        }
    }

    // constructor of char[] and the beginning point
    public NewString(char[] c, int begin){
        chars = new char[c.length - begin];
        // copy the value in the c whose index is bigger than i
        for(int i = 0; i < chars.length; i++){
            chars[i] = c[begin+i];
        }
    }

    public NewString(char[] c){
        int begin = 0;
        chars = new char[c.length - begin];
        // copy the value in the c whose index is bigger than i
        for(int i = 0; i < chars.length; i++){
            chars[i] = c[begin+i];
        }
    }




    // compare with a NewString, similar to the String
    public int compare(NewString s){
        // ch is the array version of s
        char[] ch = s.toChars();
        int len_s = ch.length;
        // n is the shorter length of ch or chars
        int n = Math.min(ch.length, chars.length);
        // compare the overlap parts
        for(int i = 0; i < n; i++){
            // if we find a point that chars is bigger than 1, return 1, otherwise return -1
            if(chars[i] > ch[i]) return 1;
            else if(chars[i] < ch[i]) return -1;
        }
        // if the overlap part is the same, we would compare the next part. the shorter one is less than the longer one
        if(chars.length > len_s) return 1;
        else if(chars.length < len_s) return -1;
        return 0;
    }


    // create a new NewString that copy the part after begin point
    // use the method of private constructor
    public NewString substring(int begin){
        return new NewString(chars, begin);
    }


    // transfer a NewString data type to a char array
    public char[] toChars(){
        return chars;
    }

    // copy the chars and transfer each character to uppercase
    public NewString toUpperCase(){
        char[] ch = new char[chars.length];
        // traverse the chars array
        for(int i = 0; i < ch.length; i++){
            // if the character is in lower case, turn it to be upper case, otherwise copy it
            ch[i] = chars[i] >= 'a' && chars[i] <= 'z' ? (char)(chars[i]-32) : chars[i];
        }
        // transfer the char[] ch to the type of NewString and return it
        return new NewString(ch, 0);
    }

    // transfer the boolean type to NewString type
    public static NewString valueOf(boolean b){
        // create and return a NewString constructed by String version of b
        char[] a = {'t','r','u','e'};
        char[] c = {'f','a','l','s','e'};
        if(b) return new NewString(new NewString(a,0));
        else return new NewString(c,0);
    }

    @Override
    public int compareTo(NewString s){
        char[] ch = s.toChars();
        int len_s = ch.length;
        int n = Math.min(ch.length, chars.length);
        for(int i = 0; i < n; i++){
            if(chars[i] > ch[i]) return 1;
            else if(chars[i] < ch[i]) return -1;
        }
        if(chars.length > len_s) return 1;
        else if(chars.length < len_s) return -1;
        return 0;
    }

    @Override
    // override the toString() method to help demonstrate NewString class
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(char c : chars){
            s.append(c);
        }
        return s.toString();
    }


}
