package com.dy.wind;

import com.dy.wind.entity.DyFeedbackOrder;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DemoTest {
    @Test
    public void test() {
        LocalDate of = LocalDate.of(2023, 12, 31);
        LocalDate now = LocalDate.now();
        System.out.println("距离" + now.until(of, ChronoUnit.DAYS) + "天");
        String fore = "sdhfuiasj";
        String[] split = fore.split("");
        fore.replaceAll(" ", "");
        for (String c : split) {
            System.out.println(c);
        }
        int length = split.length;
        System.out.println("长度 = " + length);


        List<DyFeedbackOrder> list = new ArrayList<DyFeedbackOrder>();

        List<DyFeedbackOrder> order = list.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() ->
                                new TreeSet<>(Comparator.comparing(DyFeedbackOrder::getAlarmNumber))), ArrayList::new
                )
        );


    }
}
