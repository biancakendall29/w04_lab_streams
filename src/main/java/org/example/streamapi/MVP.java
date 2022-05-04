package org.example.streamapi;

import org.example.streamapi.model.User;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MVP {

    /*
        Convert a List<String> to an object stream and for each element -> System,out.println.
     */

    public void printNames(List<String> names) {
        names.stream().forEach(System.out::println);
    }

    /*
        Given a List<Integers>, return a List<Integer> with event numbers.
     */
    public List<Integer> returnEvenNumbers(List<Integer> numbers) {
        List<Integer> evenNumbers = numbers
                .stream()
                .filter(number -> (number%2)==0)
                .toList();
        return evenNumbers;
    }

    /*
        Given an int [], double the value of each int and return an int [].
    */
    public int[] doubleInts(int[] numbers) {
        //int[] doubleInts = Arrays.stream(numbers.)
        int[] doubleInts = Arrays.stream(numbers)
                .map(i -> i*2)
                .toArray();
        return doubleInts;
    }

    /*
        Given a String, return a List<String>, all caps.
     */
    public List<String> splitToAllCapsList(String input) {
        List<String> allCaps = Arrays.stream(input.toUpperCase().split("")).toList();
        // Arrays.stream(input.split("")).map(str -> str.toUpperCase()).collect(Collectors.toList());
        return allCaps;
    }

    /*
    Given a list of animals:
     - filter the ones that start with a given letter
     - return sorted List<String>, all caps.
    */
    public List<String> filterByFirstLetterAndOrder(List<String> list, String letter) {
        List<String> sorted = list
                .stream()
                .filter(s -> s.toCharArray()[0] == letter.toCharArray()[0]) // can also use s -> s.startsWith(letter)
                // can also use s -> s.substring(0, 1).equals(letter). substring cuts out a portion of your string, from start position to end position
                .sorted()
                .map(String::toUpperCase)
                .toList();
        return sorted;
    }

    /*
        Given a list of words, return elements that:
         - are shorter than the given number and
         - start with a given letter.
    */
    public List<String> filterWords(List<String> words, int maxLength, String firstLetter) {
        List<String> sorted = words
                .stream()
                .filter(s -> s.toCharArray()[0] == firstLetter.toCharArray()[0] && s.length() < maxLength)
                .toList(); // rather use .collect(Collectors.toList()) as it is modifiable. toList() is unmodifiable/read only
        return sorted;
    }
}