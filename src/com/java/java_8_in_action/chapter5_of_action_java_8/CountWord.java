package com.java.java_8_in_action.chapter5_of_action_java_8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by cdc on 2018/4/21.
 */
public class CountWord {

    public static void main(String[] args) {
        List<String> uniqueWords;
        try(Stream<String> lines =
                    Files.lines(Paths.get("D:\\cdc.txt"), Charset.defaultCharset())) {

            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split("")))
                    .distinct()
                    .filter(s -> !s.contains(" "))
                    .collect(toList());
            System.out.println(uniqueWords);
            System.out.println(uniqueWords.size());
        }catch (IOException e){
            e.printStackTrace();
        }

        Stream.iterate(new int[]{0,1},t -> new int[]{t[1],t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println(t[0] + "," + t[1] +" "));
    }
}
