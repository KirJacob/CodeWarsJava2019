package cw7_maximum_diff;

import org.junit.Assert;
import org.junit.Test;

import static cw7_maximum_diff.MaxDiffLength.mxdiflg;

public class KataTest {

    @Test
    public void test() {
        System.out.println("mxdiflg Fixed Tests");
        String[] s1 = new String[]{"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] s2 = new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};
        Assert.assertEquals(13, mxdiflg(s1, s2)); // 13
    }

    @Test
    public void test01(){
        String[] s1 = new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"};
        String[] s2 = new String[]{"bbbaaayddqbbrrrv"};
        Assert.assertEquals(10, mxdiflg(s1, s2)); // 13
    }
}
