// I am the sole author of the work in this repository.
import structure5.*;

/**
* A Table holds a collection of strings, each of which has an
* associated FrequencyList
*/
public class Table {

private Vector<Association<String, FrequencyList>> table;

  /** Construct an empty table */
  public Table() {

    table = new Vector<Association<String, FrequencyList>>();

  }

  /**
  * Updates the table as follows
  * If key already exists in the table, update its FrequencyList
  * by adding value to it
  * Otherwise, create a FrequencyList for key and add value to it
  * @param key is the desired k-letter sequence
  * @param value is the character to add to the FrequencyList of key
  */
  public void add(String key, char value) {

    // Convert value to String
    String val = ((Character)value).toString();

    // Build an association with key and value
    FrequencyList freqList = new FrequencyList();
    freqList.add(val);
    Association<String, FrequencyList> charInfo = new Association<String, FrequencyList>(key, freqList);

    // Search for key in table
    int location = table.indexOf(charInfo);

    // If found, update it's frequency
    if (location > -1) {

      charInfo = table.get(location);
      charInfo.getValue().add(val);

    // Otherwise, add the assocation to table
    } else {

      table.add(charInfo);

    }
  }

  /**
  * If key is in the table, return one of the characters from
  * its FrequencyList with probability equal to its relative frequency
  * Otherwise, determine a reasonable value to return
  * @param key is the k-letter sequence whose frequencies we want to use
  * @return a character selected from the corresponding FrequencyList
  */
  public char choose(String key) {

    // Build an association with key
    Association<String, FrequencyList> charInfo = new Association<String, FrequencyList>(key, null);

    // Search for association in table
    int location = table.indexOf(charInfo);

    // If found, return it's frequency list
    if (location > -1) {

      return table.get(location).getValue().choose();

    // Otherwise, return empty char
    }
    return '\0';
  }

  /** Produce a string representation of the Table
  * @return a String representing this Table
  */
  public String toString() {

    String s = "[ ";

    for (Association<String, FrequencyList> a : table) {
      s += "'"  + a.getKey()
        + "' = "
        + a.getValue() + " ";
    }
    return s + "]";
  }

  // Used to test Table class
  public static void main(String[] args) {


  }

}
