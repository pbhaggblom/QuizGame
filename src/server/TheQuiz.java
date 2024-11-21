package server;

import java.util.ArrayList;
import java.util.List;

public class TheQuiz {

    Questions [] christmasQuestions = {
            new Questions ("In which of these countries do they celebrate Christmas on the 24th of December?", new String[]{"Sweden", "United Kingdom", "Ireland", "France"}, "0"),
            new Questions("What's Santa Clause called in Sweden?", new String[]{"Julnisse", "Julgubbe", "Jultome", "Julbocken"}, "2")};

    Questions[] animalsQuestions = {
            new Questions ("What's the latin name for spider?", new String[]{"Longleggius", "Spididoo", "Araneau", "Zeuzus"}, "2"),
            new Questions ("What’s the first thing a caterpillar usually eats after it’s born?", new String[]{"Grass", "Its own eggshell", "Bark", "Leaves"}, "1")};

    Questions[] nutritionQuestions = {
            new Questions ("Which vitamin is called thiamine?", new String [] {"B1", "B5", "B12", "B8"}, "0"),
            new Questions("What is the main source to vitamin D?", new String[] {"Peppers", "Cucumber", "Sunlight", "Oats"}, "2")};

    List<Questions[]> allQuestions = List.of(christmasQuestions, animalsQuestions, nutritionQuestions);

    QuizCategory[] categories = {
            new QuizCategory("Christmas", christmasQuestions),
            new QuizCategory("Animals", animalsQuestions),
            new QuizCategory("Nutrition", nutritionQuestions)};

    List<QuizCategory> quizCategories = List.of(categories);

    public List<String> categories() {
        List<String> categoryNames = new ArrayList<>();
        int i = 1;
        for (QuizCategory category :quizCategories) {
            categoryNames.add(i + "." + category.getCategoryName());
            i++;
        }
        return categoryNames;

        }
    }
