package Question2;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class QuizTime {
    public static void main(String[] args){

        // test add questions
        Quiz quiz1 = new Quiz();
        for(int i = 0; i < 26; i++){
            Question q = new Question(i + "+" + i + "= ?", 2*i+"");
            q.setComplexity(i);
            quiz1.add(q);
        }

        // test giveQuiz method
        Quiz quiz2 = new Quiz();
        for(int i = 1; i < 5; i++){
            Question q = new Question(i + "+" + i + "= ?", 2*i+"");
            q.setComplexity(i);
            quiz2.add(q);
        }
        System.out.println(" Enter 1 for random quiz, 2 for customized quiz, 0 to quit:2");
        Scanner ans = new Scanner(System.in);
        String line = ans.nextLine().trim();
        if(line.equals("1")) quiz2.giveQuiz();
        if(line.equals("2")) {
            System.out.println("Minimum Complexity: ");
            int min = Integer.parseInt(ans.nextLine().trim());
            System.out.println("Maximum Complexity: ");
            int max = Integer.parseInt(ans.nextLine().trim());
            quiz2.giveQuiz(min,max);
        }







    }
}
