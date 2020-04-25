package in.hp.java.interviewproblems;

import java.util.*;
import java.util.stream.Collectors;

public class SalesmanBookProblem {
    public static void main(String[] args) {
        System.out.println(findMinNoOfBooks(Arrays.asList(1,1,1,2,2,2,3,4,3), 10));
    }

    static List<Integer> findMinNoOfBooks(List<Integer> books, int booksCanBeRemoved) {
        if (books.size() <= booksCanBeRemoved)
            return books;

        Map<Integer, Integer> mappedBooks = new HashMap<>();

        for (int i = 0; i < books.size(); i++) {
            int key = books.get(i);
            if (mappedBooks.containsKey(key)) {
                mappedBooks.replace(key, mappedBooks.get(key).intValue() + 1);
            } else {
                mappedBooks.put(key, 1);
            }
        }

        LinkedHashMap<Integer, Integer> sortedMap = mappedBooks.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (m1, m2) -> m1, LinkedHashMap::new));

        ArrayList<Integer> keys = new ArrayList<>(sortedMap.keySet());
        int i = 0;
        while (booksCanBeRemoved > 0 && i < keys.size()) {
            int key = keys.get(i);
            int value = sortedMap.get(key);
            if ((value - booksCanBeRemoved) > 0) {
                sortedMap.replace(key, value - booksCanBeRemoved);
                booksCanBeRemoved -= value;
            } else {
                sortedMap.replace(key, value - (value - 1));
                booksCanBeRemoved -= value - 1;
            }
            i++;
        }

        List<Integer> result = new ArrayList<>();
        sortedMap.keySet().stream().forEach(x -> {
            for (int j = 0; j < sortedMap.get(x); j++) {
                result.add(x);
            }
        });

        if (booksCanBeRemoved > 0)
            return result.subList(0, result.size() - booksCanBeRemoved);

        return result;
    }
}
