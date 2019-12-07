package com.example.wakeandgame;

public class QuestionLibrary {

    private String mQuestionsMath [] = {
            "What is the next prime number after 7?",
            "What is the square root of 144?",
            "What is the result of 3 squared?",
            "What is a polygon with 7 sides called?",
            "What does the roman numeral 'C' represent?"
    };

    private String mQuestionsVG [] = {
            "What year was the Playstation 1 released in North America?",
            "What is the name of the final course in all of the 'Mario Cart' games?",
            "What video game studio makes the 'God of War' games?",
            "What video game included the first 'Easter Egg'?",
            "The first Pokemon video game appeared on what console?"
    };

    private String mChoicesMath [][] = {
            {"8", "9", "10", "11"},
            {"16", "14", "12", "10"},
            {"8", "6", "9", "5"},
            {"hexagon", "pentagon", "heptagon", "octagon"},
            {"10", "50", "100", "200"}
    };

    private String mChoicesVG [][] = {
            {"1994", "1995", "1996", "1997"},
            {"Toad's Turnpike", "Peach Beach", "Rainbow Road", "Moonview Highway"},
            {"Sucker Punch", "Naughty Dog", "Insomniac", "Santa Monica"},
            {"Adventure", "Golden Eye", "Spyro", "Pong"},
            {"NES", "Gameboy", "Nintendo 64", "Gamecube"}
    };

    private String mCorrectMath [] = {
            "11", "12", "6", "heptagon", "100"
    };

    private String mCorrectVG [] = {
            "1995", "Rainbow Road", "Santa Monica", "Adventure", "Gameboy"
    };

    public String getQuestionVG(int a) {
        String question = mQuestionsVG[a];
        return question;
    }

    public String getChoice1VG(int a) {
        String choice1 = mChoicesVG[a][0];
        return choice1;
    }

    public String getChoice2VG(int a) {
        String choice2 = mChoicesVG[a][1];
        return choice2;
    }

    public String getChoice3VG(int a) {
        String choice3 = mChoicesVG[a][2];
        return choice3;
    }

    public String getChoice4VG(int a) {
        String choice4 = mChoicesVG[a][3];
        return choice4;
    }

    public String getCorrectVG(int a) {
        String answer = mCorrectVG[a];
        return answer;
    }

    public String getQuestionMath(int a) {
        String question = mQuestionsMath[a];
        return question;
    }

    public String getChoice1Math(int a) {
        String choice1 = mChoicesMath[a][0];
        return choice1;
    }

    public String getChoice2Math(int a) {
        String choice2 = mChoicesMath[a][1];
        return choice2;
    }

    public String getChoice3Math(int a) {
        String choice3 = mChoicesMath[a][2];
        return choice3;
    }

    public String getChoice4Math(int a) {
        String choice4 = mChoicesMath[a][3];
        return choice4;
    }

    public String getCorrectMath(int a) {
        String answer = mCorrectMath[a];
        return answer;
    }
}
