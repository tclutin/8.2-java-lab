package org.example.tc.module.image;

import org.example.tc.module.Contract;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class ImageConverter implements Contract {
    @Override
    public boolean CheckFormat(String filePath) {
        return filePath.endsWith(".jpg");
    }

    @Override
    public String GetDescription() {
        return "Convert a image to a png";
    }

    @Override
    public void Execute(String filePath) {
        File inputFile = new File(filePath);
        try {
            BufferedImage inputImage = ImageIO.read(inputFile);

            String outputFilePath = "converted_" + inputFile.getName().replaceAll(".jpg", "") + ".png";
            File outputFile = new File(outputFilePath);

            ImageIO.write(inputImage, "png", outputFile);

            System.out.println("Image converted to PNG successfully. New image saved at: " + outputFilePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
