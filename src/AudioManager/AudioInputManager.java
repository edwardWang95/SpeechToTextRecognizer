package AudioManager;

import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Get audio input and break down the audio based on changes in db.
 *
 *
 * TODO:
 * -add handler for silence in audio file --> check link in Jarvis bookmark folder
 *
 * Created by edwardwang on 3/30/16.
 */
public class AudioInputManager {
    public static AudioInputManager instance = new AudioInputManager();

    private static final int BUFFER_LENGTH = 1084;

    private File audioFile;

    //AudioFile Format
    private AudioFileFormat fileFormat;
    private AudioFormat audioFormat;

    private AudioInputStream inputStream;
    private ByteArrayOutputStream outputStream;
    private int bufferSize;
    private byte[] memoryBuffer;
    private byte[] audioByteArray;


    private AudioInputManager(){}

    private void setAudioFile(File audioFile) throws IOException, UnsupportedAudioFileException {
        this.audioFile = audioFile;
        createAudioFileByteArray();
    }

    private byte[] getAudioByteArray(){
        return audioByteArray;
    }

    /**
     * Write the memory buffer of the audioInputStream to the byteArrayOutputStream.
     * @return byte array of entire audio file
     * @throws IOException
     * @throws UnsupportedAudioFileException
     */
    private void createAudioFileByteArray() throws IOException, UnsupportedAudioFileException {
        if(audioFile != null){
            getFileFormat();
            setupStreams();
            writeMemoryBufferToOutputStream();
            audioByteArray = outputStream.toByteArray();
        }
    }

    /**
     * Gets the file format of the given audio file.
     * @throws IOException
     * @throws UnsupportedAudioFileException
     */
    private void getFileFormat() throws IOException, UnsupportedAudioFileException {
        fileFormat = AudioSystem.getAudioFileFormat(audioFile);
        audioFormat = fileFormat.getFormat();
    }

    /**
     * Setup the audioInputStreams and outputStream
     * @throws IOException
     * @throws UnsupportedAudioFileException
     */
    private void setupStreams() throws IOException, UnsupportedAudioFileException {
        inputStream = AudioSystem.getAudioInputStream(audioFile);
        outputStream = new ByteArrayOutputStream();
        bufferSize = BUFFER_LENGTH * audioFormat.getFrameSize();    //Get memory buffer size from given audio format
        memoryBuffer = new byte[bufferSize];
    }

    /**
     * Writes the audio input stream memory buffer to an output stream.
     * @throws IOException
     */
    private void writeMemoryBufferToOutputStream() throws IOException {
        int bytesRead = 0;
        while(bytesRead != -1){
            bytesRead = inputStream.read(memoryBuffer);
            outputStream.write(memoryBuffer, 0, bytesRead);
        }
    }

}
