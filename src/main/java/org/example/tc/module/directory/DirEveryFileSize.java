package org.example.tc.module.directory;

import org.example.tc.module.Contract;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DirEveryFileSize implements Contract {
    @Override
    public boolean CheckFormat(String filePath) {
        return new File(filePath).isDirectory();
    }

    @Override
    public String GetDescription() {
        return "Outputs the file size and name";
    }


    @Override
    public void Execute(String filePath) {
        File directory = new File(filePath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if(file.isFile()) {
                    System.out.println(file.getName() + " " + file.length() + " bytes");
                }
            }
        }
    }
}
