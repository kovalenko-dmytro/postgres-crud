package study.apach.app;

import study.apach.model.entities.Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputHelper {

    public String getOperation(String prompt) {
        System.out.println(prompt);
        String input = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = reader.readLine().toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public Map<String, Object> getInputData() {

        Map<String, Object> inputData = new HashMap<>();

        String input;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a book title: ");
            input = reader.readLine();
            inputData.put("title", input);

            System.out.println("Enter a book author: ");
            input = reader.readLine();
            inputData.put("author", input);

            System.out.println("Enter a book cost: ");
            input = reader.readLine();
            inputData.put("cost", input);

            System.out.println("Enter a book category: ");
            input = reader.readLine();
            inputData.put("category", input);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputData;
    }
}
