package org.example.tc.module.image;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import org.example.tc.module.Contract;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class ImageMetadataFinder implements Contract {
    @Override
    public boolean CheckFormat(String filePath) {
        return filePath.endsWith(".jpg");
    }

    @Override
    public String GetDescription() {
        return "Get a metadata of image";
    }

    @Override
    public void Execute(String filePath) {
        File file = new File(filePath);
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            Iterable<Directory> directories = metadata.getDirectories();

            for (Directory directory : directories) {
                System.out.println("Directory: " + directory.getName());
                for (var tag : directory.getTags()) {
                    System.out.println("Tag: " + tag.getTagName() + " - " + tag.getDescription());
                }
            }
        } catch (ImageProcessingException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
