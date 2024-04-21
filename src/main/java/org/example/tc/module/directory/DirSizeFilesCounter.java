package org.example.tc.module.directory;

import org.example.tc.module.Contract;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DirSizeFilesCounter implements Contract {
    @Override
    public boolean CheckFormat(String filePath) {
        return new File(filePath).isDirectory();
    }

    @Override
    public String GetDescription() {
        return "Print the total size of files in the directory";
    }

    @Override
    public void Execute(String filePath) {
        File directory = new File(filePath);
        File[] files = directory.listFiles();
        long size = 0;
        if (files != null) {
            for (File file : files) {
                if(file.isFile()) {
                    size += file.length();
                }
            }
        }
        System.out.println("Size is " + size);
    }
}
