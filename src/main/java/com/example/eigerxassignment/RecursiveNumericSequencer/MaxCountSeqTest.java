package com.example.eigerxassignment.RecursiveNumericSequencer;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class MaxCountSeqTest {
 private MaxCountSeq maxCountSeq = new MaxCountSeq();

    @Test
    public void test1(){
        String input = createInputForTest(
                List.of(1, 5, 42, -376, 5, 19, 5, 3, 42, 2, 0));
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        maxCountSeq.printMaxCountSeq();
        assertEquals("(42;2)", baos.toString());
    }

    private String createInputForTest(List<Integer> numbers){
        StringBuilder stringBuilder = new StringBuilder();
        numbers.forEach(num -> {
            stringBuilder.append(num);
            if(num != 0)
                stringBuilder.append(System.lineSeparator());
        });
        return stringBuilder.toString();
    }
}
