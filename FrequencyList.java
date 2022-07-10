// I am the sole author of the work in this repository.
import structure5.*;
import java.util.Random;

/**
* A FrequencyList stores a set of characters each of which has
* an associated integer frequency
*/

public class FrequencyList {

private Vector<Association<String, Integer>> freqList;

  /** Construct an empty FrequencyList */
  public FrequencyList() {

    freqList = new Vector<Association<String, Integer>>();

  }

  /**
  * If ch is in the FrequencyList, increment it's associated frequency
  * Otherwise add ch to FrequencyList with frequency 1
  * @param ch is the String to add to the FrequencyList
  */
  public void add(String ch) {

    // Build an association with key
    Association<String, Integer> freqInfo = new Association<String, Integer>(ch, 1);

    // Search for key in table
    int location = freqList.indexOf(freqInfo);

    // If found, update it's frequency
    if (location > -1) {

      freqInfo = freqList.get(location);
      freqInfo.setValue(freqInfo.getValue() + 1);

    // Otherwise, add the association to frequency list
    } else {
      freqList.add(freqInfo);
    }

  }

  /**
  * Selects a character from this FrequencyList
  * @return a character from the FrequencyList with probabality equal to its relative frequency
  */
  public char choose() {

    String charFreq = "";

    // Iterate over frequency list
    for (int i = 0; i < freqList.size(); i++) {

      // Get association and add occurences of character to charFreq
      Association<String, Integer> info = freqList.get(i);
      charFreq += (info.getKey().repeat(info.getValue()));

    }
    // Generate a random int from zero to length of charFreq
    Random rand = new Random();
    int probability = rand.nextInt(charFreq.length());

    // Return the randomly selected char
    return charFreq.charAt(probability);

  }

  /** Produce a string representation of the FrequencyList
   * @return a String representing the FrequencyList
   */
  public String toString() {

    String s = "[ ";

    for (Association<String, Integer> a : freqList) {
      s += "'" + a.getKey()
        + "' = "
        + a.getValue() + " ";
    }
    return s + "]";
  }

  // Used to test FrequencyList class
  public static void main(String[] args) {


  }

}
