package org.example.tc.module.text;

import org.example.tc.module.Contract;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class UpperPrinter implements Contract {
    @Override
    public boolean CheckFormat(String filePath) {
        return filePath.endsWith(".txt");
    }

    @Override
    public String GetDescription() {
        return "Outputs the contents to the Uppercase";
    }

    @Override
    public void Execute(String filePath) {
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line.toUpperCase());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
