package com.company;

import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {


        for(int i = 1; i<=100; i++){
            if(i%15==0)System.out.print("FizzBuzz");
            else if(i%3==0)System.out.print("Fizz");
            else if(i%5==0)System.out.print("Buzz");
            else System.out.print(i);
            System.out.print("==");
        }
	// write your code here
        GreetingService greetService1 = message -> System.out.println("Hello " + message);
        System.out.println(greetService1);

        List<Integer> list = Arrays.asList(1, 4, 3, 2, 5, 6, 9, 8, 7);

        int max = list.stream().max(Integer::compareTo).get();
        int maxInt = list.stream()
                .max(Integer::compareTo)
                .get();
        int minInt = list.stream()
                .min(Integer::compareTo)
                .get();

        // Predicate<Integer> predicate = n -> true
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true

        System.out.println("输出所有数据:");

        // 传递参数 n
        eval(list, n->true);

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n%2 为 0 test 方法返回 true

        System.out.println("输出所有偶数:");
        eval(list, n-> n%2 == 0 );
        list.stream().filter( n -> n % 2 == 0).forEach(System.out::println);


        // Predicate<Integer> predicate2 = n -> n > 3
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n 大于 3 test 方法返回 true

        System.out.println("输出大于 3 的所有数字:");
        eval(list, n-> n > 3 );
        list.stream().filter( n -> n > 3).forEach(System.out::println);

        Runnable noArguments = () -> System.out.println("Hello World");
        System.out.println(noArguments);

        ActionListener oneArgument = event -> System.out.println("button clicked");
        System.out.println(oneArgument);

        Runnable multiStatement = () -> {
            System.out.print("Hello");
            System.out.println(" World");
        };
        System.out.println(multiStatement);

        String[] input = {"fgh", "ijk"};
        //this wont change original input
        Arrays.stream(input).map(s -> s.toUpperCase()).forEach(System.out::println);
        for(String s : input){
            System.out.println("Input" + s);
        }

        //this will change the original input
        Arrays.stream(input).map(s ->s.toUpperCase()).collect(Collectors.toList()).toArray(input);
        for(String s : input){
            System.out.println("Input: " + s);
        }

        String[] as = {"a", "b", "hello"};
        Stream.of(as)
                .map(string -> string.toUpperCase())
                .collect(toList()).forEach(System.out::println);
        for(String s : as){
            System.out.println("as: " + s);
        }

        String[] stringlist = {"abc", "def"};
        List<String> collect = Arrays.stream(stringlist).map(s -> s.toUpperCase()).collect(toList());

        System.out.println(collect);

        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());
        System.out.println(together);

        List<Integer> list1 = new ArrayList<>();
        list1.add(3);list1.add(1);list1.add(5);list1.add(8);list1.add(10);
        List<Integer> sortedList = list1.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
        System.out.println(sortedList);



        //java8 stream api

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        Random random = new Random();
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        System.out.println("使用 Java 8: ");
        System.out.println("列表: " +strings);

        long count = strings.stream().filter(string->string.isEmpty()).count();
        System.out.println("空字符串数量为: " + count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("字符串长度为 3 的数量为: " + count);

        List<String> filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选后的列表: " + filtered);

        String mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        List<Integer> squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);
        System.out.println("列表: " +integers);

        IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
        System.out.println("随机数: ");

        random.ints().limit(10).sorted().forEach(System.out::println);

        // 并行处理
        count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串的数量为: " + count);
    }


    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list) {

            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

}
