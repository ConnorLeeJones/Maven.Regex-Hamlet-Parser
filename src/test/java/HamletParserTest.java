import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        Assert.assertFalse(hamletText.contains("Leon"));
        Assert.assertTrue(hamletText.contains("HAMLET"));

        hamletParser.replaceNames();
        this.hamletText = hamletParser.getHamletData();

        Assert.assertTrue(hamletText.contains("Leon"));
        Assert.assertFalse(hamletText.contains("HAMLET"));
        Assert.assertFalse(hamletText.contains("Hamlet"));

    }

    @Test
    public void testChangeHoratioToTariq() {
        Assert.assertFalse(hamletText.contains("Tariq"));
        Assert.assertTrue(hamletText.contains("HORATIO"));


        hamletParser.replaceNames();
        this.hamletText = hamletParser.getHamletData();

        Assert.assertTrue(hamletText.contains("Tariq"));
        Assert.assertFalse(hamletText.contains("HORATIO"));
        Assert.assertFalse(hamletText.contains("Horatio"));

    }

    @Test
    public void testFindHoratio() {
        Assert.assertTrue(hamletText.contains("Horatio"));
        Assert.assertTrue(hamletText.contains("HORATIO"));
    }

    @Test
    public void testFindHamlet() {
        Assert.assertTrue(hamletText.contains("Hamlet"));
        Assert.assertTrue(hamletText.contains("HAMLET"));
    }

    @Test
    public void testDontFindHoratio() {
        hamletParser.replaceNames();
        this.hamletText = hamletParser.getHamletData();

        Assert.assertFalse(hamletText.contains("Horatio"));
        Assert.assertFalse(hamletText.contains("HORATIO"));
    }

    @Test
    public void testDontFindHamlet() {
        hamletParser.replaceNames();
        this.hamletText = hamletParser.getHamletData();

        Assert.assertFalse(hamletText.contains("Hamlet"));
        Assert.assertFalse(hamletText.contains("HAMLET"));
    }

    @Test
    public void testFindLeon() {
        hamletParser.replaceNames();
        this.hamletText = hamletParser.getHamletData();

        Assert.assertTrue(hamletText.contains("Leon"));
    }

    @Test
    public void testFindTariq() {
        hamletParser.replaceNames();
        this.hamletText = hamletParser.getHamletData();

        Assert.assertTrue(hamletText.contains("Tariq"));
    }

    @Test
    public void countTestHamletToLeon() {
        Pattern hamlet = Pattern.compile("HAMLET", Pattern.CASE_INSENSITIVE);
        Matcher text = hamlet.matcher(hamletText);

        Integer countHam = 0;
        while (text.find()){
            countHam++;
        }

        hamletParser.replaceNames();
        this.hamletText = hamletParser.getHamletData();

        Pattern leon = Pattern.compile("Leon");
        text = leon.matcher(hamletText);

        Integer countLeon = 0;
        while (text.find()){
            countLeon++;
        }
        Assert.assertEquals(countHam, countLeon);
    }

    @Test
    public void countTestHoratioToTariq() {
        Pattern horatio = Pattern.compile("HORATIO", Pattern.CASE_INSENSITIVE);
        Matcher text = horatio.matcher(hamletText);

        Integer countHoratio = 0;
        while (text.find()){
            countHoratio++;
        }

        hamletParser.replaceNames();
        this.hamletText = hamletParser.getHamletData();

        Pattern tariq = Pattern.compile("Tariq");
        text = tariq.matcher(hamletText);

        Integer countTariq = 0;
        while (text.find()){
            countTariq++;
        }

        Assert.assertEquals(countHoratio, countTariq);
    }

    @Test
    public void testFindHoratioWithMatcher() {
        Pattern horatio = Pattern.compile("HORATIO", Pattern.CASE_INSENSITIVE);
        Matcher text = horatio.matcher(hamletText);

        Assert.assertTrue(text.find());
    }

    @Test
    public void testDontFindHoratioWithMatcher() {
        hamletParser.replaceNames();
        this.hamletText = hamletParser.getHamletData();

        Pattern horatio = Pattern.compile("HORATIO", Pattern.CASE_INSENSITIVE);
        Matcher text = horatio.matcher(hamletText);

        Assert.assertFalse(text.find());
    }


    @Test
    public void testFindHamletWithMatcher() {
        Pattern hamlet = Pattern.compile("HAMLET", Pattern.CASE_INSENSITIVE);
        Matcher text = hamlet.matcher(hamletText);

        Assert.assertTrue(text.find());
    }

    @Test
    public void testDontFindHamletWithMatcher() {
        hamletParser.replaceNames();
        this.hamletText = hamletParser.getHamletData();

        Pattern hamlet = Pattern.compile("HAMLET", Pattern.CASE_INSENSITIVE);
        Matcher text = hamlet.matcher(hamletText);

        Assert.assertFalse(text.find());
    }



    @Test
    public void testDontFindLeonWithMatcher() {
        Pattern leon = Pattern.compile("Leon");
        Matcher text = leon.matcher(hamletText);

        Assert.assertFalse(text.find());
    }

    @Test
    public void testFindLeonWithMatcher() {
        hamletParser.replaceNames();
        this.hamletText = hamletParser.getHamletData();

        Pattern leon = Pattern.compile("Leon");
        Matcher text = leon.matcher(hamletText);

        Assert.assertTrue(text.find());
    }


    @Test
    public void testDontFindTariqWithMatcher() {
        Pattern tariq = Pattern.compile("Tariq", Pattern.CASE_INSENSITIVE);
        Matcher text = tariq.matcher(hamletText);

        Assert.assertFalse(text.find());
    }

    @Test
    public void testFindTariqWithMatcher() {
        hamletParser.replaceNames();
        this.hamletText = hamletParser.getHamletData();

        Pattern tariq = Pattern.compile("Tariq", Pattern.CASE_INSENSITIVE);
        Matcher text = tariq.matcher(hamletText);

        Assert.assertTrue(text.find());
    }




}