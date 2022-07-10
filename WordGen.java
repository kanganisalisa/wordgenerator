// I am the sole author of the work in this repository.
import java.util.Scanner;

/**
* WordGen uses Table and FrequencyList to output a k-level analysis
* text based on a user-inputted text
*/
public class WordGen {

  /** Reads input text from user
  * @return a String of the input text
  */
  private static String readText() {

    Scanner in = new Scanner(System.in);
    StringBuffer textBuffer = new StringBuffer();
    while (in.hasNextLine()) {
        String line = in.nextLine();
        textBuffer.append(line);
        textBuffer.append("\n");
    }
    String text = textBuffer.toString();
    return text;

  }

  /** Processes the input text by creating the associated table
  * @param text is the input text
  * @param table is table object associated with text
  * @param k is the level of analysis
  */
  private static void processText(String text, Table table, int k) {

    // Iterates over user-inputted text
    for (int i = 0; i < text.length() - k; i++) {

      // Add String key of length k and char value to table
      table.add(text.substring(i, i + k), text.charAt(i + k));

    }

  }

  /** Processes the input text by creating the associated table
  * @param text is the input text
  * @param table is table object associated with text
  * @param k is the level of analysis
  * @param len is the length of the output string
  */
  private static void generateText(String text, Table table, int k, int len) {

    String newStr;
    String lastK = text.substring(text.length() - k, text.length());

    // Start output text with first k characters of input text and print
    String outputText = text.substring(0, k);
    System.out.print(outputText);

    // Until output text reaches desired length
    while (outputText.length() < len) {

      newStr = outputText.substring(outputText.length() - k, outputText.length());

      // If reach last k characters
      if (newStr.equals(lastK)) {

        // Add first k characters to output text
        outputText += text.substring(0, k);

      }
      // Otherwise, get and print chosen character based on relative frequency
      newStr = outputText.substring(outputText.length() - k, outputText.length());

      char chosen = table.choose(newStr);

      System.out.print(chosen);

      // Add chosen character to output text
      outputText += chosen + "";

    }
    System.out.println();

  }

  /**
  * Main method takes user-inputted k and text, calls the methods to
  * read, process, and generate the output text
  */
  public static void main(String[] args) {

    if (args.length == 0) {

      // no args, so print usage line and do nothing else
      System.out.println("Usage: java WordGen ");

    } else {

      // convert first argument to k
      int k = Integer.parseInt(args[0]);

      Table table = new Table();

      // Read the input text
      String text = readText();

      // Build the table
      processText(text, table, k);

      // Print out a randomly generated String
      generateText(text, table, k, 200);

    }
  }

}
