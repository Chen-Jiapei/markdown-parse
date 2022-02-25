import static org.junit.Assert.*;
import org.junit.*; //importing junit test

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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

    @Test
    public void testSnippet1() throws IOException {
        Path file = Path.of("Snippet1.md");
        String contents = Files.readString(file);
        List<String> expected = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet2() throws IOException {
        Path file = Path.of("Snippet2.md");
        String contents = Files.readString(file);

        List<String> expected = List.of("b.com", "a.com(())", "example.com");
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet3() throws IOException {
        Path file = Path.of("Snippet3.md");
        String contents = Files.readString(file);

        List<String> expected = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }
}

