package com.java.java_8_in_action.chapter5_of_action_java_8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Created by cdc on 2018/4/21.
 */
public class TraderToTransaction {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //1.
        System.out.println("找出2011年发生的所有交易，并按交易额排序（从低到高）。");
        List<Transaction>  tr2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println( tr2011);

        //2.
        System.out.println("交易员都在哪些不同的城市工作过？");
        List<String> city = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println(city);

        //3.
        System.out.println(" 查找所有来自于剑桥的交易员，并按姓名排序。");
        List<Trader> trader = transactions.stream()
                .map(t -> t.getTrader())
                .distinct()
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(comparing(t -> t.getName()))
                .collect(toList());
        System.out.println(trader);

        //4.
        System.out.println("有没有交易员是在米兰工作的？");
        /*Optional<Trader> isMilan = transactions.stream()
                .map(t -> t.getTrader())
                .filter(t -> t.getCity().equals("Milan"))
                .findAny();
        System.out.println(isMilan);*/

        boolean milanBased = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        //5
        System.out.println("打印生活在剑桥的交易员的所有交易额");
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .forEach(System.out::println);

        //6
        System.out.println("所有交易中，最高的交易额是多少");
        Optional<Integer> maxValue = transactions.stream()
                .map(t -> t.getValue())
                .reduce(Integer::max);
        System.out.println(maxValue.get());

        //7
        System.out.println("找到交易额最小的交易");
        Optional<Integer> minValue = transactions.stream()
                .map(t -> t.getValue())
                .reduce(Integer::min);
        System.out.println(minValue.get());
        //or 更好的办法
        transactions.stream().min(comparing(Transaction::getValue));

    }
}
