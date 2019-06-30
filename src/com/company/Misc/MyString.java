package com.company.Misc;

import com.company.Misc.Exceptions.CommaExpectedException;

public class MyString {
    public static int cleanSpaces(String str, int index) {
        while (index < str.length()) {
            switch (str.charAt(index)) {
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    index++;
                    break;
                default:
                    return index;
            }
        }
        return -1;
    }

    public static double nextDoubleString(String input, int i) {
        StringBuilder str = new StringBuilder();
        if (i < input.length() && input.charAt(i) == '-') {
            str.append(input.charAt(i));
            i++;
        }
        while (i < input.length()) {
            switch (input.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '.':
                    str.append(input.charAt(i));
                    i++;
                    break;
                default:
                    return Double.valueOf(str.toString());
            }
        }
        return Double.valueOf(str.toString());
    }

    public static int nextDoubleIndex(String input, int i) {
        StringBuilder str = new StringBuilder();
        if (i < input.length() && input.charAt(i) == '-') {
            str.append(input.charAt(i));
            i++;
        }
        while (i < input.length()) {
            switch (input.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '.':
                    str.append(input.charAt(i));
                    i++;
                    break;
                default:
                    return i;
            }
        }
        return i;
    }

    public static int cleanCommaAndSpaces(String input, int i) {
        i = cleanSpaces(input, i);
        if (input.charAt(i) != ',') {
            throw new CommaExpectedException();
        }
        i = cleanSpaces(input, i + 1);
        return i;
    }
}
