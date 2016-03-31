package FileHander;

import java.io.File;

/**
 * File Singleton class
 * If not existing beforehand, creates a file to outputs the given topology and weights of a all existing neural networks.
 * This class also handles the storage of words it learns.
 *
 * Created by edwardwang on 3/31/16.
 */
public class FileHandler {
    public static FileHandler instance = new FileHandler();

    private File file;

    private FileHandler(){

    }

    private void updateFile(){

    }
}
