package org.example.tc.module.mp3;

import org.example.tc.module.Contract;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class TrackMetadataFinder implements Contract {
    @Override
    public boolean CheckFormat(String filePath) {
        return filePath.endsWith(".mp3");
    }

    @Override
    public String GetDescription() {
        return "get a metadata of mp3";
    }

    @Override
    public void Execute(String filePath) {
        File file = new File(filePath);
        try {
            AudioFile track = AudioFileIO.read(file);
            Tag tag = track.getTag();

            System.out.println("File: " + file.getName());
            System.out.println("Title: " + tag.getFirst(FieldKey.TITLE));
            System.out.println("Artist: " + tag.getFirst(FieldKey.ARTIST));
            System.out.println("Album: " + tag.getFirst(FieldKey.ALBUM));
            System.out.println("Duration: " + track.getAudioHeader().getTrackLength() + " seconds");
            System.out.println("------------------------------------------------------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
