package day02;

public class Day02RemoveA {
    //write  a  method which removes "A" from a String, if "A" is found in first 2 characters.
    //All characters will be in upper case
    // AABCD-->BCD, ABC --> BC, AA-->""

    public String deleteAifItIsInFirstTwoChars(String str){
        //check the length
        if(str.length()<=2) return str.replaceAll("A", "");

        //if it is longer than 2
        String firstTwoChars = str.substring(0, 2);
        String charsAfterFirstTwo = str.substring(2);

        return firstTwoChars.replaceAll("A", "") + charsAfterFirstTwo;
    }

    //there is no runner for this.. but we will test this
}
