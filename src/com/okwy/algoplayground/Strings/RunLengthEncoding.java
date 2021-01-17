package com.okwy.algoplayground.Strings;

public class RunLengthEncoding {

    private static String runLengthEncoding(String string){
        //Time: O(n), Space: O(n)
        StringBuilder encodedString = new StringBuilder();
        int stringRunner = 1;

        for(int i = 1; i < string.length(); i++){
            char currentChar = string.charAt(i);
            char previousChar = string.charAt(i-1);

            if(currentChar != previousChar || stringRunner >= 9){
                encodedString.append(stringRunner);
                encodedString.append(previousChar);
                stringRunner = 0;
            }

            stringRunner += 1;
        }


        //handle the last character
        encodedString.append(stringRunner);
        encodedString.append(string.charAt(string.length()-1));


        return encodedString.toString();
    }

    public static void main(String[] args) {
        String sampleString = "AAACCBBBBNNLLL";
        System.out.println(">>>>>Run Length Encoding>>>>");
        System.out.println("Sample string: " + sampleString);
        System.out.println("Encoded String: " + runLengthEncoding(sampleString));

    }
}
