package com.java.java_8_in_action.chapter7_of_action_java_8;

import java.math.BigDecimal;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by cdc on 2018/4/23.
 */
public class MySpliterator {
    public static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            }else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }
        return counter;
    }

    class WordCounter {
        private  int counter;
        private final boolean lastSpace;

        public WordCounter(int counter, boolean lastSpace) {
            this.counter = counter;
            this.lastSpace = lastSpace;
        }

        public WordCounter accumulater(Character c) {
            if (Character.isWhitespace(c)) {
                return lastSpace ? this : new WordCounter(counter, true);
            } else {
                return lastSpace ? new WordCounter(counter++,false):this;
            }
        }

        public WordCounter combine(WordCounter wordCounter) {
            return new WordCounter(counter + wordCounter.counter,wordCounter.lastSpace);
        }

        public int getCounter() {
            return counter;
        }
    }
    public static void main(String[] args) {
        final String SENTENCE = " Nel mezzo del cammin di nostra vita " +
                "mi ritrovai in una selva oscura" +
                " ché la dritta via era smarrita ";
        System.out.println("Found" + MySpliterator.countWordsIteratively(SENTENCE) + " words");

        Stream<Character> stream = IntStream.range(0,SENTENCE.length())
                .mapToObj(SENTENCE::charAt);

        for(int i=0;i<3;i++){
            System.out.println("外层for循环"+i);
            for(int j=0;j<4;j++){
                if(j==1)
                    //continue;
            // if(j==2)
             break;
                System.out.println("内层循环"+j);
            }
        }

        int a = 1;
        int b = 2;
        if (a == 1) {
            if (b == 2) {
                System.out.println("b==2");
                //break;
                //return;
            }

            System.out.println("a==1");
        }

        BigDecimal ad = new BigDecimal(1.0000);
        BigDecimal ad1 = new BigDecimal("-0.8444");
        System.out.println("---" + ad1);
        BigDecimal ad2 = ad1.multiply(new BigDecimal(100)).setScale(2);
        System.out.println("++++" + ad2);
        System.out.println(ad2 + "%");

    }
}
