package AlgoExSolutions.Medium.ValidIPAddresses;

import java.util.*;

/**
 * * Valid IP Addresses
 */
class Program {
  private boolean isValidPart(String part) {
    int partAsInt = Integer.valueOf(part);
    if (partAsInt > 255) return false;

    return part.length() == ("" + partAsInt).length();
  }

  public ArrayList<String> validIPAddresses(String string) {
    // Write your code here.
    ArrayList<String> validIPs = new ArrayList<>();
    String[] addressParts = new String[4];

    for (int i = 1; i < Math.min(string.length(), 4); ++i) {
      addressParts[0] = string.substring(0, i);

      if (!isValidPart(addressParts[0])) continue;

      for (int j = i + 1; j < i + Math.min(string.length() - i, 4); ++j) {
        addressParts[1] = string.substring(i, j);

        if (!isValidPart(addressParts[1])) continue;

        for (int k = j + 1; k < j + Math.min(string.length() - j, 4); ++k) {
          addressParts[2] = string.substring(j, k);
          addressParts[3] = string.substring(k);

          if (isValidPart(addressParts[2]) && isValidPart(addressParts[3]))
            validIPs.add(String.join(".", addressParts));
        }
      }
    }

    return validIPs;
  }
}
