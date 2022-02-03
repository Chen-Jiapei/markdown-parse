import static org.junit.Assert.*;
import org.junit.*; //importing junit test

public class MarkdownParseTest { //defining a class
    @Test //marks the start of test
    public void addition() { // method definition
        assertEquals(2, 1 + 1); //testing 1 + 1 = 2 or not.
    }

    @Test
    public void getLinksTest() {
        String testLink1 = "[Link1](Link1.com)";
        assertEquals("Link1.com", MarkdownParse.getLinks(testLink1).get(0));
    }
}

