package Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamPrgms {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1, 1, 2, 6, 2, 3);
        //use distinct to have the duplicates removed
        list.stream().distinct().forEach(System.out::print);
        System.out.println();
        //sorting the list
        list.stream().sorted().forEach(System.out::print);
        System.out.println();
        //sorting in reverse order
        list.stream().sorted(Collections.reverseOrder()).forEach(System.out::print);
        System.out.println();
        //filter
        list.stream().filter(x -> x % 2 == 0).forEach(System.out::print);
        System.out.println();
        //map
        list.stream().map(x->x*x).forEach(System.out::print);
    }
}
