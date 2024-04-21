package org.example.tc.module.mp3;

import org.example.tc.module.Contract;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class TrackAuthorFinder implements Contract {
    @Override
    public boolean CheckFormat(String filePath) {
        return filePath.endsWith(".mp3");
    }

    @Override
    public String GetDescription() {
        return "Get a author of mp3";
    }

    @Override
    public void Execute(String filePath) {
        File file = new File(filePath);
        try {
            AudioFile track = AudioFileIO.read(file);

            System.out.println("Author - " + track.getTag().getFirst(FieldKey.ARTIST));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
