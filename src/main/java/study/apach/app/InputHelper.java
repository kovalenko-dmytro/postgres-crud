package study.apach.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
}
