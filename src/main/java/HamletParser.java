import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public void replaceNames(){
        Pattern horatio = Pattern.compile("HORATIO", Pattern.CASE_INSENSITIVE);
        Pattern hamlet = Pattern.compile("HAMLET", Pattern.CASE_INSENSITIVE);

        Matcher text = hamlet.matcher(hamletData);
        hamletData = text.replaceAll("Leon");

        text = horatio.matcher(hamletData);
        hamletData = text.replaceAll("Tariq");
    }


    public String getHamletData(){
        return hamletData;
    }

}
