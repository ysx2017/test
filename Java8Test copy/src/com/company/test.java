package com.company;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class test {

    @Test
    public void test1(){
        List<String> collected = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())
                .collect(toList());
        Assert.assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
    }
}
