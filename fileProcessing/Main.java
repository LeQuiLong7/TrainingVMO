package fileProcessing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // Each time FileReader reads a character, it directly accesses the disk drive to read that character
        // Each time BufferReader reads a character, it reads the data from the memory buffer.
        // When data is not available in the buffer, it accesses the disk drive and loads a chunk of data into the buffer

        // try with resources in java will close the resources specified in () after finishing the block
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
