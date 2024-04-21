package org.example.tc.module.image;

import org.example.tc.module.Contract;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class ImageSizeCounter implements Contract {
    @Override
    public boolean CheckFormat(String filePath) {
        return filePath.endsWith(".jpg");
    }

    @Override
    public String GetDescription() {
        return "Get a image size.";
    }

    @Override
    public void Execute(String filePath) {
        File file = new File(filePath);
        try {
            BufferedImage image = ImageIO.read(file);
            System.out.println("Width: " + image.getWidth());
            System.out.println("Height: " + image.getHeight());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
