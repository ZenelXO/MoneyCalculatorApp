package currency;

import java.io.*;
import java.util.*;

public class FileLoader {
    private final File file;

    public FileLoader(File file) {
        this.file = file;
    }

    public List<Currency> loadAll() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<Currency> result = new ArrayList<>();
            while(true){
                String lines = reader.readLine();
                if(lines == null){break;}
                result.add(toCurrency(lines));
            }
            return result;
        } catch (FileNotFoundException e) {
            return Collections.emptyList();
        }
    }

    private Currency toCurrency(String line) {
        String[] words = line.split("\t");
        return new Currency(words[0], words[1], words.length == 2 ? "" : words[2]);
    }
}