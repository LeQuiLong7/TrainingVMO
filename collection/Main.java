package collection;

import java.util.*;

public class Main {
    static List<Person> getPersonList() {
        Person p1 = new Person(1, "Alice");
        Person p2 = new Person(3, "Bob");
        Person p3 = new Person(2, "John");
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        return personList;
    }

    public static void main(String[] args) {

        List<Person> personList = getPersonList();

        traverseLists(personList);
        hashSetAndLinkedHashSet(personList);
        collectionsMethod(personList);
    }

    static void traverseLists(List<Person> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // or
        for(Person p : list) {
            System.out.println(p);
        }
        // or
        for(var p : list) {
            System.out.println(p);
        }
        // or
        list.forEach(System.out::println);
    }


    private static void hashSetAndLinkedHashSet(List<Person> personList) {
        // create a collection with data of other collection
        // hash set use hash function to calculate the index number for each object
        // if two objects have the same index but are different(o1.equals(o2) == false),
        // they will be linked together using linked list,
        // if two objects are equal, only one object will be stored
        Set<Person> personSet = new HashSet<>(personList);
        personSet.forEach(System.out::println);

        // when accessing an object inside a set,
        // the index number will be calculated using the hash function like when inserting an object into a set
        // so the time complexity is O(1)
        personSet.contains(personList.getFirst());

        // linked hash set is like a hash set but with another linked list to maintain the insertion order
        // when an object gets inserted into a linked hash set, the object will be stored in a hash table like a normal hash set
        // but a pointer pointing to that object will be created and linked to the end of a linked list to maintain the insertion order
        Set<Person> personLikedHashSet = new LinkedHashSet<>(personList);
        personLikedHashSet.forEach(System.out::println);
    }


    // the Collection interface is at the root of the collection hierarchy.
    // It defines the behaviors that all implementation must have
    // each implementation can have its own ways of implementing those behaviours
    static void collectionsMethod(Collection<Person> collection) {

        // add elements to a collection
        collection.add(new Person(5, ""));
        collection.addAll(Collections.emptyList());

        // remove elements to a collection
        collection.remove(new Person(5, ""));
        collection.removeAll(Collections.emptyList());
        collection.removeIf(s -> s.getId() == -1);


        // check the size of the collection
        collection.isEmpty();
        collection.size();

        // check if the collection contains elements
        collection.contains(new Person(1, ""));
        collection.containsAll(Collections.emptyList());

        // loop through the collection
        collection.iterator();

        // clear the collection
        collection.clear();

        // convert the collection into an array
        collection.toArray();

    }

    static void comparableInterface(List<Person> collection) {


        // comparable interface is a functional interface
        // so we can implement it using lambda expression
        Collections.sort(collection, (p1, p2) -> p1.getId() - p2.getId());
        Collections.sort(collection, Comparator.comparingInt(Person::getId));
        Collections.sort(collection, Comparator.comparing(Person::getName));

        // if not specify the comparator, it will use the compare to method of the object
        // so the object must implement the Comparable interface
        // use custom comparable for better flexibility
        Collections.sort(collection);
        // sort in reverse order
        Collections.sort(collection, Comparator.reverseOrder());

    }

    static void hashMapLinkedHashMapAndTreeMap(List<Person> personList) {
        // hash map and linked hash map are exactly like hash set and linked hash set
        // hash set and linked hash set are implemented using a Hash map
        hashSetAndLinkedHashSet(personList);



        // tree map is a red black tree so all element will be sorted
        Map<Integer, Person> personMap = new TreeMap<>();

        personList.forEach(p -> personMap.put(p.getId(), p));










    }




}
