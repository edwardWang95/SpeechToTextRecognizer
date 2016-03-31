import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Get audio input and break down the audio based on changes in db.
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
    private ByteArrayOutputStream outpuStream;
    private int bufferSize;
    private byte[] memoryBuffer;


    private AudioInputManager(){}

    /**
     * Write the memory buffer of the audioInputStream to the byteArrayOutputStream.
     * @return byte array of entire audio file
     * @throws IOException
     * @throws UnsupportedAudioFileException
     */
    private byte[] getAudioFileByteArray(File audioFile) throws IOException, UnsupportedAudioFileException {
        this.audioFile = audioFile;
        getFileFormat();
        setupStreams();
        writeMemoryBufferToOutputStream();
        return outpuStream.toByteArray();
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
        outpuStream = new ByteArrayOutputStream();
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
            outpuStream.write(memoryBuffer, 0, bytesRead);
        }
    }

}
