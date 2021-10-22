package Question3;

public class NewString_test {
    public static void main(String[] args){
        char[] s = {'c','m','u','a'};
        NewString ns = new NewString(s);
        // show NewString
        System.out.println("show NewString");
        System.out.println(ns);
        System.out.println();

        // NewString(NewString ns)
        NewString ns_new = new NewString(ns);
        System.out.println("NewString(NewString)");
        System.out.println(ns);
        System.out.println();

        // show compare
        char[] s1 = {'c','m','u','a'};
        char[] s2 = {'a','m','u','c','d'};
        char[] s3 = {'z','u','m'};

        NewString ns1 = new NewString(s1);
        NewString ns2 = new NewString(s2);
        NewString ns3 = new NewString(s3);

        System.out.println("compare NewString");
        System.out.println(ns.compare(ns1));
        System.out.println(ns.compare(ns2));
        System.out.println(ns.compare(ns3));
        System.out.println();


        // substring
        System.out.println("substring");
        System.out.println(ns.substring(1));
        System.out.println();

        // toChars
        System.out.println("toChars");
        char[] ch = ns.toChars();
        for(char c : ch)
            System.out.print(c + " ");
        System.out.println();
        System.out.println();

        // toUpperCase
        System.out.println("toUpperCase");
        System.out.println(ns.toUpperCase());
        System.out.println();

        // valueOf
        System.out.println("valueOf(true)");
        NewString newstr = NewString.valueOf(true);
        System.out.println(newstr);



    }


}
