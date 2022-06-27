package com.algoexpert;

import java.util.*;

public class ValidIPAddresses {
    public static void main(String[] args) {
        System.out.println(validIPAddresses("1921680"));
    }
    /*Valid IP Addresses
QN8.You're given a string of length 12 or smaller,containing only digits.Write a function that returns all the possible IP addresses that can be created by inserting three dot(.)s in the string.
An IP address is a sequence of four positive integers that are separated by.s,where each individual integer is within the range 0-255,inclusive.
An IP address isn't valid if any of the individual integers contains leading 0s.For example,"192.168.0.1"is a valid IP address,but"192.168.00.1" and"192.168.0.01"aren't,because they contain"00"and 01. respectively.Another example of a valid IP address is"99.1.1.10":conversely, "991.1.1.0"isn't valid,because"991"is greater than 255.
Your function should return the IP addresses in string format and in no particular order.If no valid IP addresses can be created from the string,your function should return an empty list.
Note:check out our Systems Design Fundamentals on Systems Expert to learn more about IP addresses!
Sample Input
 string="1921680"
 Sample Output
  [
    "1.9.216.80",
    "1.92.16.80",
    "1.92.168.0",
    "19.2.16.80",
    "19.2.168.0",
    "19.21.6.80",
    "19.21.68.0",
    "19.216.8.0",
    "192.1.6.80",
    "192.1.68.0",
    "192.16.8.0"
  ]
  // The IP addresses could be ordered differently.
 */
//    HINT
    /*Each IP address is comprised of four parts; try finding one valid part at a time and then combining sets of four valid parts to create one valid IP address.

Go through all possible combinations of valid IP-address parts. You'll do this by generating a valid first part, then generating all valid second parts given the first part, then finally all valid third and fourth parts given first and second parts. If you find a set of four valid parts, then simply combine them together and add that IP address to some final array. You can start by creating all the possible first parts of an IP address; these will be substrings of the main string that start at the first character and that have lengths
 1, 2 and 3.

*/

    //0(1)time|0(1)space
    public static ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> ipAddressesFound = new ArrayList<String>();
        for (int i = 1; i < Math.min((int) string.length(), 4); i++) {
            String[] currentIPAddressParts = new String[]{"", "", "", ""};
            currentIPAddressParts[0] = string.substring(0, i);
            if (!isValidPart(currentIPAddressParts[0])) {
                continue;
            }
            for (int j = i + 1; j < i + Math.min((int) string.length() - i, 4); j++) {
                currentIPAddressParts[1] = string.substring(i, j);
                if (!isValidPart(currentIPAddressParts[1])) {
                    continue;
                }
                for (int k = j + 1; k < j + Math.min((int) string.length() - j, 4); k++) {
                    currentIPAddressParts[2] = string.substring(j, k);
                    currentIPAddressParts[3] = string.substring(k);

                    if (isValidPart(currentIPAddressParts[2]) && isValidPart(currentIPAddressParts[3])) {
                        ipAddressesFound.add(join(currentIPAddressParts));
                    }
                }
            }
        }
        return ipAddressesFound;


    }

    public static boolean isValidPart(String string) {
        int stringAsInt = Integer.parseInt(string);
        if (stringAsInt > 255) {
            return false;
        }
        return string.length() == Integer.toString(stringAsInt).length();// check for leading 0
    }

    public static String join(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
            if (i < strings.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

}
