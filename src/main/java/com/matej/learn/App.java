package com.matej.learn;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    private static void printChar(int aChar) {
        System.out.println((char) aChar);
    }

    public static void printPeople (final String message, final List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }

    public static int boolToInt(Boolean b) {
        return Boolean.compare(b, false);
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

        final String str = "w00t";

        str.chars()
        .forEach(System.out::println);

        str.chars()
        .forEach(App::printChar);

        str.chars()
        .mapToObj(ch -> Character.valueOf((char) ch))
        .forEach(System.out::println);

        // People part


        final List<Person> people = Arrays.asList(
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Amy", 21),
            new Person("Jane", 21),
            new Person("Greg", 35)
        );


        Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);

        Comparator<Person> compareDescending = compareAscending.reversed();

        List<Person> ascendingAge =
        people.stream().sorted(compareAscending)
        .collect(Collectors.toList());

        List<Person> descendingAge =
        people.stream().sorted(compareDescending)
        .collect(Collectors.toList());

        printPeople("Sorted in ascending order by age: ", ascendingAge);

        // Sort people by name
        printPeople("Sorted in ascending order by name", 
        people.stream()
        .sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
        .collect(Collectors.toList()));

        final Function<Person, String> byName = person -> person.getName();
        final Function<Person, Integer> byAge = person -> person.getAge();
        
        // Print people in sorted order based on both age and name
        printPeople("Sorted in ascending order by [age] and [name]", people.stream()
        .sorted(Comparator.comparing(byAge).thenComparing(byName)).collect(Collectors.toList()));

        // Youngest person
        // feels like I'm learning linq here
        people.stream()
        .min(Person::ageDifference)
        .ifPresent(youngest -> System.out.println("Youngest p is : " + youngest));


        // Older than 20
        List<Person> olderThan20 = new ArrayList<>();

        people.stream()
        .filter(person -> person.getAge() > 20)
        .forEach(person -> olderThan20.add(person));

        System.out.println("Printing people older than 20: " + olderThan20);

        List<Person> olderThan20Alt = 
        people.stream().filter(person -> person.getAge() > 20)
        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println("Printing people older than 20 [collected via collect()] " + olderThan20Alt);
        System.out.println("One\nTwo\nThree");

        Vehicle minivan = new Vehicle();

        int range;

        // assign to fields in minivan
        minivan.passengers = 7;
        //minivan.fuelcap = 16;
        //minivan.mpg = 21;

        // compute range of a full tank of gas
        minivan.range();

    }
}
