package de.etc.lambda;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Original list:");
        getDevelopers().forEach(System.out::println);
        Aufgabe_2_1_1();
        Aufgabe_2_1_2_lambda();
    }

    private static void Aufgabe_2_1_1() {
        printSeparator("Aufgabe 2.1.1");

        // 2.1.1.a
        System.out.println("--- Sorted after alter:");
        List<Developer> devsA = getDevelopers();
        Collections.sort(devsA, (dev1, dev2) -> Integer.compare(dev1.getAlter(), dev2.getAlter()));
        System.out.println(devsA);

        // 2.1.1.b Sortiert die Liste nach dem Namen (mit Ausgabe) – benutzt dabei NICHT die
        //Klasse Collections
        List<Developer> devsB = getDevelopers();
        System.out.println("--- Sorted insertion:");
        insertionSort(devsB, true);
        System.out.println(devsB);

        // 2.1.1.c
        System.out.println("--- Sorted after name:");
        List<Developer> devsC = getDevelopers();
        devsC.sort(Comparator.comparing(Developer::getName));
        System.out.println(devsC);

        // 2.1.1.d
        System.out.println("--- Print without for/while:");
        devsC.forEach(System.out::println);
    }

    private static void Aufgabe_2_1_2_lambda() {
        printSeparator("Aufgabe 2.1.2");
        List<Developer> devs = getDevelopers();

        // Set extra data
        List<List<String>> projectsRaw= Arrays.asList(
                Arrays.asList("Project1", "Project2", "Project3", "Project4", "Project5"),
                Arrays.asList("Project2", "Project3", "Project4"),
                Arrays.asList("Project3", "Project4", "Project5"),
                Arrays.asList("Project4")
        );
        for (int i = 0; i<4; i++) {
            devs.get(i).setProjects(projectsRaw.get(i));
        }

        // • groupingBy: who is working on project 3
        Map<Integer, List<Developer>> groupDevByNumProjects = devs.stream()
                        .collect(Collectors.groupingBy(dev -> dev.getProjects().size()));
        System.out.println("Group dev by number of active projects:");
        groupDevByNumProjects.forEach((k, v) -> System.out.println(k + ": " + v));
        Map<Integer, List<Developer>> groupDevByNameLength = devs.stream()
                .collect(Collectors.groupingBy(dev -> dev.getName().length()));
        System.out.println("Group dev by name length:");
        groupDevByNameLength.forEach((k, v) -> System.out.println(k + ": " + v));
        printSeparator();

        //• map: get report of dev - number of project
        List<String[]> numPersonProjects = devs.stream()
                .map(dev -> new String[] {dev.getName(), String.valueOf(dev.getProjects().size())}).toList();
        System.out.println("Who is working on how many projects: ");
        numPersonProjects.forEach(pp -> System.out.println(pp[0] + ": " + pp[1]));
        printSeparator();

        //• filter: get list of dev with more than 3 projects
        int threshold = 3;
        List<Developer> busyDevs = devs.stream()
            .filter(dev -> dev.getProjects().size() >= threshold)
            .toList();
        List<Developer> lazyDevs = devs.stream()
                .filter(dev -> dev.getProjects().size() < threshold)
                .toList();
        System.out.println("- Busy devs with min " + threshold + " projects: ");
        busyDevs.forEach(dev -> System.out.println(dev.getName() + ", working on " + dev.getProjects()));
        System.out.println("- Lazy devs with less than " + threshold + " projects: ");
        lazyDevs.forEach(dev -> System.out.println(dev.getName() + ", working on " + dev.getProjects()));
        printSeparator();

        //• toSet: get all active projects
        //• flatMap,
        Set<String> activeProjects = devs.stream()
                .flatMap(developer -> developer.getProjects().stream())
                .collect(Collectors.toSet());
        System.out.println("Active projects in team: " + activeProjects.stream().sorted().toList());
        printSeparator();
    }

    private static List<Developer> getDevelopers() {
        List<Developer> result = new ArrayList<Developer>();
        result.add(new Developer("daniel", new BigDecimal("70000" ), 33));
        result.add(new Developer("dennis", new BigDecimal("80000" ), 20));
        result.add(new Developer("phillip",new BigDecimal("100000"), 10));
        result.add(new Developer("ich", new BigDecimal("170000"), 55));
        return result;
    }

    public static void insertionSort(List<Developer> listDevs, boolean setDescending) {
        if (listDevs == null || listDevs.size() < 2) return;
        int direction = 1;
        if (setDescending)
            direction = -1;
        Developer[] devs = listDevs.toArray(new Developer[0]);
        int n = devs.length;

        for (int i = 1; i < n; ++i) {
            Developer key = devs[i];
            String keyName = key.getName();
            int j = i - 1;

            while (j >= 0) {
                boolean shouldSwap = direction * devs[j].getName().compareTo(keyName) > 0;
                if (shouldSwap) {
                    devs[j + 1] = devs[j];
                    j = j - 1;
                } else {
                    break;
                }
            }
            devs[j + 1] = key;
        }

        for (int k = 0; k < n; k++) {
            listDevs.set(k, devs[k]);
        }
    }

    private static void printSeparator() {
        System.out.println("-----------------------");
    }
    private static void printSeparator(String title) {
        System.out.println("--------------------  " + title + "  --------------------");
    }
}