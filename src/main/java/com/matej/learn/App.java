package com.matej.learn;

import java.util.*;
import java.util.function.*;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static String reverse(String input) {
        if (input == null)
        {
            return input;
        }

        String output = "";

        for(int i = input.length() - 1; i >= 0; i--) {
            output = output + input.charAt(i);
        }
        return output;
    }

    public static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
        }


    public static void pickName(final List<String> names, final String startingLetter) {
        String foundName = null;

        for(String name: names) {
            if(name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }

        System.out.println(String.format("A name starting with %s:", startingLetter));

        if (foundName != null) {
            System.out.println(foundName);
        } else {
            System.out.println("No name found");
        }
    }

    public static void pickNameElegant(final List<String> names, final String startingLetter) {
        final Optional<String> foundName = 
        names.stream().filter(name -> name.startsWith(startingLetter))
        .findFirst();

        System.out.println(String.format("A name starting with %s: %s", startingLetter, 
            foundName.orElse("No name found")));

        // Alternative approach
        // foundName.ifPresent(name -> System.out.println("Hello " + name));
    }


    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");

        final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

        final Predicate<String> startsWithN = name -> name.startsWith("N");

        final Function<String, Predicate<String>> startsWithLetter =
            letter -> name -> name.startsWith(letter);

        final long countFriendsWithN = 
            friends.stream()
            .filter(startsWithLetter.apply("N")).count();

        final long countFriendsWithB =
            friends.stream()
            .filter(startsWithLetter.apply("B")).count();

        final long countEditorsWithN =
            editors.stream()
            .filter(startsWithN)
            .count();

        final long countComradesWithN =
            comrades.stream()
            .filter(startsWithN)
            .count();

        //System.out.println(countFriendsWithB);
        pickNameElegant(friends, "N");
        pickNameElegant(friends, "Z");

        System.out.println("Total number of characters in all names: " + 
            friends.stream()
            .mapToInt(name -> name.length())
            .sum());

        final Optional<String> aLongName = 
            friends.stream()
            .reduce((name1, name2) -> 
            name1.length() >= name2.length() ? name1 : name2);

        aLongName.ifPresent(name -> System.out.println(String.format("A longest name: %s", name)));

        for(String name: friends) {
            System.out.print(name + ", ");
        }

        System.out.println();

        for(int i = 0; i < friends.size() - 1; i++) {
            System.out.print(friends.get(i) + ", ");
        }

        if (friends.size() > 0)
            System.out.println(friends.get(friends.size() - 1));

        System.out.println(String.join(", ", friends));

        
    }
}
