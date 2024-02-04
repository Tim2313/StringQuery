package org.example.service.operations;

import org.example.model.StringAttribute;

import static org.example.constant.TypeOfData.*;

public class StringQueryOperations {

    private static StringQueryOperations instance;

    public char getCharAt(StringAttribute stringAttribute) {
        String line = stringAttribute.getInputString();
        int charPosition = stringAttribute.getK();
        if (charPosition >= 0 && charPosition < line.length()) {
            // Получаем символ по индексу
            return line.charAt(charPosition);
        } else {
            // Если индекс находится за пределами строки, можно вернуть какое-то значение по умолчанию или бросить исключение
            throw new IndexOutOfBoundsException("Индекс находится за пределами строки");
        }
    }

    public String getSubstring(StringAttribute stringAttribute) {
        int l = stringAttribute.getL();
        int r = stringAttribute.getR();

        String line = stringAttribute.getInputString();

        return line.substring(l, r);
    }

    public int countChar(StringAttribute stringAttribute) {
        String substring = getSubstring(stringAttribute);
        char targetSymbol = getCharAt(stringAttribute);

        char otherSymbol = (targetSymbol == 'A') ? 'B' : 'A';

        int k = stringAttribute.getK();

        int targetOccurrences = countOccurrences(substring, targetSymbol);
        if (targetOccurrences < k) {
            return -1; // No match found
        }

        return findPositionOfOtherSymbol(substring, otherSymbol, k);
    }

    private int countOccurrences(String substring, char targetSymbol) {
        int occurrenceCount = 0;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == targetSymbol) {
                occurrenceCount++;
            }
        }
        return occurrenceCount;
    }

    private int findPositionOfOtherSymbol(String substring, char otherSymbol, int targetOccurrences) {
        int occurrenceCount = 0;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == otherSymbol) {
                occurrenceCount++;
                if (occurrenceCount == targetOccurrences) {
                    return i + 1; // 1-based index
                }
            }
        }
        return -1; // No match found
    }


    public static StringQueryOperations getInstance() {
        if (instance == null) {
            instance = new StringQueryOperations();
        }
        return instance;
    }
}
