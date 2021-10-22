package Question2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> quiz;  // a list collect all the questions
    private final int capacity = 25;   // set the upmost number amount of questions in the quiz
    private int n = 0; // record the amount of questions already in the quiz

    public Quiz(){
        // create new list
        quiz = new ArrayList<>();

    }

    // add questions to quiz
    public void add(Question q){
        // if the number of questions is below the capacity, add the question
        if(n < capacity) {
            quiz.add(q);
            n++;
        }
        // if the quiz has been full, print warning
        else System.out.println("too much questions!");
    }

    public void giveQuiz(){
        int correct_num = 0; // amount of questions that are correct
        int total_num = 0; // amount of total questions
        // create a stream to support input
        Scanner ans = new Scanner(System.in);
        // traverse the questions in the list
        for(Question q : quiz){
            total_num++;
            // extract question
            System.out.println(q.getQuestion());
            // read the input answer
            String line = ans.nextLine().trim();
            // compare the answer with real value, output the outcome
            // record the amount that is correct;
            if(q.answerCorrect(line)) correct_num++;
            System.out.println();
        }
        System.out.println();
        System.out.println("Result: ");
        System.out.println("Correct: "+ correct_num+", Total: "+total_num);
        System.out.println();
    }

    // overload another method that appoints the complexity
    public void giveQuiz(int low, int high){
        int correct_num = 0; // amount of questions that are correct
        int total_num = 0; // amount of total questions
        Scanner ans = new Scanner(System.in);
        for(Question q : quiz){
            // if meet the question too easy or too hard, skip the question
            if(q.getComplexity() < low || q.getComplexity() > high) continue;
            total_num++;
            // extract question
            System.out.println(q.getQuestion());
            // read the input answer
            String line = ans.nextLine().trim();
            // compare the answer with real value, output the outcome
            // System.out.println(q.answerCorrect(line));
            // record the amount that is correct;
            if(q.answerCorrect(line)) correct_num++;
            System.out.println();
        }
        System.out.println();
        System.out.println("Result: ");
        System.out.println("Correct: "+ correct_num+", Total: "+total_num);
        System.out.println();
    }


}
