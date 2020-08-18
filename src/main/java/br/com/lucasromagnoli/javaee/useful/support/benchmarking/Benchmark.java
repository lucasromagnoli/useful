package br.com.lucasromagnoli.javaee.useful.support.benchmarking;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class Benchmark {
    private static String MESSAGE = "%s has executed in %dms";
    private static HashMap<String, LocalTime> datasMap = new HashMap<>();

    public static void start(String name) {
        datasMap.put(name, LocalTime.now());
    }

    public static void end(String name) {
        if (datasMap.containsKey(name)) {
            long timeLapse = datasMap.get(name).until(LocalTime.now(), ChronoUnit.MILLIS);
            System.out.println(String.format(MESSAGE, name, timeLapse));
            datasMap.remove(name);
        }
    }
}
