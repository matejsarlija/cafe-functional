package com.matej.learn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.matej.learn.AssetUtil;

import javax.sql.rowset.spi.SyncResolver;

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

    public static void listTheHardWay() {
        List<File> files = new ArrayList<>();

        File[] filesInCurrentDir = new File(".").listFiles();

        for(File file : filesInCurrentDir) {
            File[] filesInSubDir = file.listFiles();
            if (filesInSubDir != null) {
                files.addAll(Arrays.asList(filesInSubDir));
            } else {
                files.add(file);
            }
        }

        System.out.println("Count: " + files.size());;
    }

    public static void betterWay() {
        List<File> files = 
            Stream.of(new File(".").listFiles())
            .flatMap(file -> file.listFiles() == null ?
            Stream.of(file) : Stream.of(file.listFiles()))
            .collect(Collectors.toList());

        System.out.println("Count: " + files.size());
            
    }
    
    /* Reverse an array in-place. This method is destructive.*/
    public static void reverseIn(int[] A) {
        int temp;

        for (int i = 0, j = A.length-1; i <= j; i++, j--) {
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    /** The largest value in array A, or null if A is empty. */
    public static Comparable max(Comparable[] A) {
        if (A.length == 0) return null;

        Comparable result;
        result = A[0];

        for (int i = 1; i < A.length; i +=1) {
            if (result.compareTo(A[i]) < 0) {
                result = A[i];
            }
        }

        return result;
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
        
        try {
            Files.list(Paths.get(".")).filter(Files::isRegularFile).forEach(System.out::println);

        } catch (IOException ex) {
            System.err.println(ex);
        }

        try {
            Files.newDirectoryStream(Paths.get("/home/oxi/Projects"), path -> path.toString().endsWith(".java"))
            .forEach(System.out::println);
        } catch (IOException ex) {
            System.err.println(ex);
        }

        final File[] files = new File(".").listFiles(File::isAbsolute);
        
        listTheHardWay();
        betterWay();

        final List<Asset> assets = Arrays.asList(
        new Asset(Asset.AssetType.BOND, 1000),
        new Asset(Asset.AssetType.BOND, 2000),
        new Asset(Asset.AssetType.STOCK, 3000),
        new Asset(Asset.AssetType.STOCK, 4000)
        );

        System.out.println("Total of all assets: " + AssetUtil.totalAssetValues(assets, asset -> true));

        System.out.println("Total of all bonds: " + 
        AssetUtil.totalAssetValues(assets, asset -> asset.getType() == Asset.AssetType.BOND));
        
        System.out.println("Total of all stocks: " + 
        AssetUtil.totalAssetValues(assets, asset -> asset.getType() == Asset.AssetType.STOCK));

        String matej = new String("matej");
        System.out.println(matej.substring(1,matej.length()));

        String command = "cancel";

        switch(command) {
            case "connect":
                System.out.println("Connecting");
            case "cancel":
                System.out.println("Cancelling");
            case "disconnect":
                System.out.println("Disconnecting");
            default:
                System.out.println("Error!");
        }

        Block ob1 = new Block(10, 2, 5);
        Block ob2 = new Block(10, 2, 5);
        Block ob3 = new Block(4, 5, 5);

        System.out.println("ob1 has the same dimensions as ob2: " + ob1.sameBlock(ob2));
        System.out.println("ob1 has the same dimensions as ob3: " + ob1.sameBlock(ob3));
        System.out.println("ob1 has the same volume as ob3: " + ob1.sameVolume(ob3));

        Sumation s1 = new Sumation(5);
        Sumation s2 = new Sumation(s1);

        System.out.println("s1.sum: " + s1.sum);
        System.out.println("s2.sum: " + s2.sum);

        System.out.println("Codepoint for A is " + ((char) 0));

        int[] arr = {1, 2, 3, 4, 5};
        App.reverseIn(arr);
        for (int x: arr) {
            System.out.print(x);
        }

        Test testA = new Test(1);
        Test testB = new Test(2);

        System.out.println("Variable in class testA: " + testA.a);
        System.out.println("Variable in class testB: " + testB.a);

        testA.change(testB);
        
        System.out.println("Variable in class testA after exchange with testB: " + testA.a);
        System.out.println("Variable in class testB after exchange with testA: " + testB.a);

        int[] numbers = {4, 8, 16, 32, 64, 128, 256, 512};
        int[] denumbers = {2, 0, 4, 4, 0, 8};

        try {
            System.out.println("Before throw");
            throw new ArithmeticException();
        } catch (ArithmeticException exc) {
            System.out.println("Caught the exception.");
        }
        System.out.println("After try / catch block.");
        
    }
}
