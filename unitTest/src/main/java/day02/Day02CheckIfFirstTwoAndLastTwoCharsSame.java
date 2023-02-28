package day02;

public class Day02CheckIfFirstTwoAndLastTwoCharsSame {
    //method to compare first and last two characters are the same
    //BABA -->true
    //AAA --> true

    //we have to handle these two
    //AA -->true
    //A -->false

    //** suggestions
    public boolean checkIfFirstTwoAndLastTwoCharsSame(String str){
        if(str.length()<=1) return false;
        if(str.length()==2) return true;
        String firstTwoChars = str.substring(0, 2);
        String lastTwoChar = str.substring(str.length()-2);

        return  firstTwoChars.equals(lastTwoChar);
    }
}
