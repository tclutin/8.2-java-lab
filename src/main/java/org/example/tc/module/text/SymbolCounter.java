package org.example.tc.module.text;

import org.example.tc.module.Contract;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SymbolCounter implements Contract {
    @Override
    public boolean CheckFormat(String filePath) {
        return filePath.endsWith(".txt");
    }

    @Override
    public String GetDescription() {
        return "Frequency of occurrence of each character";
    }

    @Override
    public void Execute(String filePath) {
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Map<Character, Integer> map = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                    } else {
                        map.put(c, 1);
                    }
                }
            }
            for (var entry : map.entrySet()) {
                System.out.println("Symbol - " + entry.getKey()+" freq - " + entry.getValue() + " times");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
