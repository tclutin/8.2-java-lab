package org.example.tc.module.text;

import org.example.tc.module.Contract;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class LinesCounter implements Contract {
    @Override
    public boolean CheckFormat(String filePath) {
        return filePath.endsWith(".txt");
    }

    @Override
    public String GetDescription() {
        return "Counts lines";
    }

    @Override
    public void Execute(String filePath) {
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Counts of lines - " + reader.lines().count());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
