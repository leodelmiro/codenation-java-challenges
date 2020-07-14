package br.com.codenation;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StatisticUtil {

    public static int average(int[] elements) {
        return (int) Math.round(Arrays.stream(elements).average().getAsDouble()
        );
    }

    public static int mode(int[] elements) {
        int mostFrequencyNumber = 0;
        int modeValue = 0;
        List<Integer> elementsList = new ArrayList<>();
        for (Integer element: elements){
            elementsList.add(element);
        }

        for (int element : elements) {
            int frequencyNumber = Collections.frequency(elementsList, element);
            if (frequencyNumber >= mostFrequencyNumber) {
                mostFrequencyNumber = frequencyNumber;
                modeValue = element;
            }
        }
        return modeValue;
    }

    public static int median(int[] elements) {
        int[] sortedElements = Arrays.stream(elements).sorted().toArray();
        int medianValue;
        if (elements.length % 2 == 0) {
            int arrayCenter1 = elements.length / 2;
            int arrayCenter2 = arrayCenter1 - 1;
            medianValue = (sortedElements[arrayCenter1] + sortedElements[arrayCenter2]) / 2;
            return Math.round(medianValue);
        } else {
            int arrayCenter = (elements.length / 2);
            medianValue = sortedElements[arrayCenter];
            return Math.round(medianValue);
        }
    }
}