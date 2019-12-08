package com.example.wakeandgame;

public class QuestionLibrary {

    private String mQuestionsMath [] = {
            "What is the next prime number after 7?",
            "What is the square root of 144?",
            "What is the result of 3 squared?",
            "What is a polygon with 7 sides called?",
            "What does the roman numeral 'C' represent?",
            "What is the first step in the Order of Operations?",
            "How many pounds are in a ton?",
            "What is the smallest prime number?",
            "Which of these causes passengers to fall back when a bus moves suddenly?",
            "What is the next number in the Fibonacci Sequence: 0, 1, 1, 2, 3, 5, 8, 13, __?"
    };

    private String mQuestionsVG [] = {
            "What year was the Playstation 1 released in North America?",
            "What is the name of the final course in all of the 'Mario Cart' games?",
            "What video game studio makes the 'God of War' games?",
            "What video game included the first 'Easter Egg'?",
            "The first Pokemon video game appeared on what console?",
            "What does Mario jump on after completing a level?",
            "Who is the creator of the Metal Gear series?",
            "What video game console was the first to use Blueray discs?",
            "Black Ops is a subtitle of which video game franchise?",
            "Resident Evil 4 was released in which year?"
    };

    private String mQuestionsCoding [] = {
            "java.util.Collections is a what?",
            "Which allows the storage of a null key and null values?",
            "Which of the following is a valid way to instantiate an array in java?",
            "Which of the following is not a primitive data type?",
            "Which is not an unchecked exception?",
            "What was Java originally called?",
            "Which company was behind creating Java?",
            "What is the name of the inventor of Java?",
            "What does AWT stand for?",
            "Which of the following is a Java keyword?"
    };

    private String mQuestionsMovies [] = {
            "Which war movie won the Academy Award for Best Picture in 2010?",
            "What was the name of the second Indiana Jones movie?",
            "Which year were the Oscars first presented?",
            "What is the name of the Hobbit played by Elijah Wood in the Lord of the Rings movies?",
            "Which actress plays Katniss Everdeen in the Hunger Games movies?",
            "What year was the first Star Wars movie released?",
            "Which Tom Hanks movie won the Academy Award for Best Picture in 1994?",
            "Who played Jack Dawson in the movie Titanic?",
            "Who directed the Dark Knight trilogy?",
            "Which actor played Red in The Shawshank Redemption?"
    };

    private String mChoicesMath [][] = {
            {"8", "9", "10", "11"},
            {"16", "14", "12", "10"},
            {"8", "6", "9", "5"},
            {"hexagon", "pentagon", "heptagon", "octagon"},
            {"10", "50", "100", "200"},
            {"Exponents", "Multiplication", "Parenthesis", "Division"},
            {"500", "1000", "1500", "2000"},
            {"1", "2", "3", "4"},
            {"Speed", "Motion", "Thrust", "Inertia"},
            {"15", "18", "21", "25"}
    };

    private String mChoicesVG [][] = {
            {"1994", "1995", "1996", "1997"},
            {"Toad's Turnpike", "Peach Beach", "Rainbow Road", "Moonview Highway"},
            {"Sucker Punch", "Naughty Dog", "Insomniac", "Santa Monica"},
            {"Adventure", "Golden Eye", "Spyro", "Pong"},
            {"NES", "Gameboy", "Nintendo 64", "Gamecube"},
            {"Flag Pole", "Mushroom", "Pipe", "Luigi"},
            {"Shigeru Miyamoto", "Hideo Kojima", "Gabe Newell", "Yoji Shinkawa"},
            {"Xbox 360", "PS4", "Xbox One", "PS3"},
            {"Destiny", "Call of Duty", "Halo", "Battlefield"},
            {"2005", "2006", "2007", "2008"}
    };

    private String mChoicesCoding [][] = {
            {"Class", "Interface", "Object", "None of the above"},
            {"HashTable", "HashMap", "ArrayList", "Set"},
            {"int myArray [] = {1, 3, 5};", "int myArray [][] = {1, 2, 3, 4};", "int [] myArray = {5, 4, 3};", "int [] myArray = {\"1\", \"2\", \"3\"}"},
            {"int", "char", "String", "float"},
            {"RuntimeException", "ClassCastException", "NullPointerException", "IOException"},
            {"Spruce", "Oak", "Latte", "Tea"},
            {"Microsoft", "Borland", "Apple", "Sun Microsystems"},
            {"Bill Gates", "James Gosling", "Bjarne Stoustroup", "Dennis Ritchie"},
            {"Abstract Widget Transfer", "Apple-Windows Technology", "Abstract Window Toolkit", "All Windows Titles"},
            {"repeat", "final", "elseif", "select"}
    };

    private String mChoicesMovies [][] = {
            {"Avatar", "Up", "The Hurt Locker", "The Blind Side"},
            {"Raiders of the Lost Arc", "The Last Crusade", "Kingdom of the Crystal Skull", "The Temple of Doom"},
            {"1928", "1929", "1930", "1931"},
            {"Frodo", "Sam", "Smeagol", "Bilbo"},
            {"Jennifer Aniston", "Jennifer Garner", "Jennifer Lawrence", "Jennifer Lopez"},
            {"1976", "1977", "1978", "1979"},
            {"Cast Away", "Saving Private Ryan", "The Green Mile", "Forrest Gump"},
            {"Leonardo DiCaprio", "Matt Damon", "Matthew McConaughey", "Leonardo Da Vinci"},
            {"Christian Bale", "Christopher Nolan", "Heath Ledger", "Gary Oldman"},
            {"Samuel L Jackson", "Morgan Freeman", "Jamie Foxx", "Tim Robbins"}
    };

    private String mCorrectMath [] = {
            "11", "12", "6", "heptagon", "100",
            "Parenthesis", "2000", "2", "Inertia", "21"
    };

    private String mCorrectVG [] = {
            "1995", "Rainbow Road", "Santa Monica", "Adventure", "Gameboy",
            "Flag Pole", "Hideo Kojima", "PS3", "Call of Duty", "2005"
    };

    private String mCorrectCoding [] = {
            "Class", "HashMap", "int myArray [] = {1, 3, 5};", "String", "IOException",
            "Oak", "Sun Microsystems", "James Gosling", "Abstract Window Toolkit", "final"
    };

    private String mCorrectMovies [] = {
            "The Hurt Locker", "The Temple of Doom", "1929", "Frodo", "Jennifer Lawrence",
            "1977", "Forrest Gump", "Leonardo DiCaprio", "Christopher Nolan", "Morgan Freeman"
    };

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

    public int getLastMath() {
        int last = mQuestionsMath.length;
        return last;
    }

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

    public int getLastVG() {
        int last = mQuestionsVG.length;
        return last;
    }

    public String getQuestionCoding(int a) {
        String question = mQuestionsCoding[a];
        return question;
    }

    public String getChoice1Coding(int a) {
        String choice1 = mChoicesCoding[a][0];
        return choice1;
    }

    public String getChoice2Coding(int a) {
        String choice2 = mChoicesCoding[a][1];
        return choice2;
    }

    public String getChoice3Coding(int a) {
        String choice3 = mChoicesCoding[a][2];
        return choice3;
    }

    public String getChoice4Coding(int a) {
        String choice4 = mChoicesCoding[a][3];
        return choice4;
    }

    public String getCorrectCoding(int a) {
        String answer = mCorrectCoding[a];
        return answer;
    }

    public int getLastCoding() {
        int last = mQuestionsCoding.length;
        return last;
    }

    public String getQuestionMovies(int a) {
        String question = mQuestionsMovies[a];
        return question;
    }

    public String getChoice1Movies(int a) {
        String choice1 = mChoicesMovies[a][0];
        return choice1;
    }

    public String getChoice2Movies(int a) {
        String choice2 = mChoicesMovies[a][1];
        return choice2;
    }

    public String getChoice3Movies(int a) {
        String choice3 = mChoicesMovies[a][2];
        return choice3;
    }

    public String getChoice4Movies(int a) {
        String choice4 = mChoicesMovies[a][3];
        return choice4;
    }

    public String getCorrectMovies(int a) {
        String answer = mCorrectMovies[a];
        return answer;
    }

    public int getLastMovies() {
        int last = mQuestionsMovies.length;
        return last;
    }
}
