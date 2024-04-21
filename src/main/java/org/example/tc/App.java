package org.example.tc;

import org.example.tc.module.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication(scanBasePackages = "org.example.tc")
public class App {

    private static List<Contract> modules;

    @Autowired
    public App(List<Contract> modules)
    {
        App.modules = modules;
    }


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        var scanner = new Scanner(System.in);
        System.out.print("Enter path to file: ");
        String filePath = scanner.nextLine();


        System.out.println(filePath);
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        var allModules = new ArrayList<Contract>();
        for (var module : modules) {
            if (module.CheckFormat(filePath)) {
                allModules.add(module);
            }
        }

        System.out.println("All functions of modules:");
        for (int i = 0; i < allModules.size(); i++) {
            System.out.println(i + " " + allModules.get(i).GetDescription());
        }

        System.out.print("Enter needed function:");
        allModules.get(scanner.nextInt()).Execute(filePath);
    }

    public static void Scan(String[] args) {

    }

}
