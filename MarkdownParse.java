// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        System.out.println(markdown.length());
        markdown.replace(" ", "");
        markdown.replace("\n", "");
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {

            int nextOpenBracket = markdown.indexOf("[", currentIndex);

            if (nextOpenBracket == -1) {
                break;
            }

            int nextCloseBracketAndOpenParen = markdown.indexOf("](", nextOpenBracket);

            if (nextCloseBracketAndOpenParen == -1) {
                currentIndex = nextOpenBracket + 1;
                continue;
            }

            int closeParen = markdown.indexOf(")", nextCloseBracketAndOpenParen);

            if (closeParen == -1) {
                break;
            }

            System.out.println(currentIndex);
            System.out.println(markdown.indexOf("[", currentIndex));
            if (markdown.indexOf("[", currentIndex) == 0 ||
                !markdown.substring(nextOpenBracket - 1, nextOpenBracket).equals("!") ||
                    !markdown.substring(nextOpenBracket - 1, nextOpenBracket).equals("'")){
                toReturn.add(markdown.substring(nextCloseBracketAndOpenParen + 2, closeParen));
                System.out.println(toReturn);
            }

            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}