package com.okwy.algoplayground.Strings;

public class CaesarCipher {

    public static String caesarCypherEncryptor(String str, int key) {
        char[] stringArray = str.toCharArray();
        int keyMod = key % 26;
        for(int i = 0; i < stringArray.length; i++){
            if(stringArray[i] > 96 && stringArray[i] <= 122) {
                int newLetter = stringArray[i] + keyMod;
                stringArray[i] = newLetter <= 122 ? (char) newLetter : (char) (96 + newLetter % 122);
            }else if(stringArray[i] > 64 && stringArray[i] <= 90){
                int newLetter = stringArray[i] + key;
                stringArray[i] = newLetter <= 90 ? (char) newLetter : (char) (64 + (newLetter % 90));
            }
        }

        return new String(stringArray);
    }

    public static void main(String[] args) {
        String test = "hello there";
        System.out.println(">>>>Decrypted String>>>>>>>>" + test);
        System.out.println(">>>>Encrypted String>>>>>>>>" + caesarCypherEncryptor(test, 2));
    }

}
