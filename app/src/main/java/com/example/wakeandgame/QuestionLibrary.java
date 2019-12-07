package com.example.wakeandgame;

public class QuestionLibrary {

    private String mQuestions [] = {
            "What is the next prime number after 7?",
            "What is the square root of 144?",
            "What is the result of 3 squared?",
            "What is a polygon with 7 sides called?",
            "What does the roman numeral 'C' represent?"
    };

    private String mChoices [][] = {
            {"8", "9", "10", "11"},
            {"16", "14", "12", "10"},
            {"8", "6", "9", "5"},
            {"hexagon", "pentagon", "heptagon", "octagon"},
            {"10", "50", "100", "200"}
    };

    private String mCorrect [] = {
            "11", "12", "6", "heptagon", "100"
    };

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice1 = mChoices[a][0];
        return choice1;
    }

    public String getChoice2(int a) {
        String choice2 = mChoices[a][1];
        return choice2;
    }

    public String getChoice3(int a) {
        String choice3 = mChoices[a][2];
        return choice3;
    }

    public String getChoice4(int a) {
        String choice4 = mChoices[a][3];
        return choice4;
    }

    public String getCorrect(int a) {
        String answer = mCorrect[a];
        return answer;
    }
}
