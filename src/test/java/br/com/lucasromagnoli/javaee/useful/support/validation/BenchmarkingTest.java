package br.com.lucasromagnoli.javaee.useful.support.validation;

import br.com.lucasromagnoli.javaee.useful.support.benchmarking.Benchmark;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BenchmarkingTest {

    @Test
    public void arrayVsArrayListPerfomance() {
        Integer[] array = new Integer[9876543];
        List<Integer> list = new ArrayList<>();

        // Array
        System.out.println("Populate array with 9876543 indexes");
        Benchmark.start("array");
        for (int index = 0; index < array.length; index++) {
            array[index] = index;
        }
        Benchmark.end("array");
        System.out.println("Getting a single value of index 285");
        Benchmark.start("array[935154]");
        int arrayValue = array[935154];
        Benchmark.end("array[935154]");

        // List
        System.out.println("Populate a list with 9876543 size");
        Benchmark.start("list");
        for (int index = 0; index < 9876543; index++) {
            list.add(index);
        }
        Benchmark.end("list");
        System.out.println("Getting a single value of index 9876543");
        Benchmark.start("list.get(935154)");
        int listValue = list.get(935154);
        Benchmark.end("list.get(935154)");
    }
}
