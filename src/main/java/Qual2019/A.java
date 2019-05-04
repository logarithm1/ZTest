package Qual2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class A {


    private final Scanner in;

    private A() {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    }

    public static void main(String[] args) throws IOException {
        A s = new A();
        s.solve();
    }

    private void process(int caseNum) {

        String s = ns();
        List<Character> s1 = new ArrayList<>();
        List<Character> s2 = new ArrayList<>();

        s.chars().forEach(new IntConsumer() {
            public void accept(int q) {
                if (q - '0' == 4) {
                    s1.add('3');
                    s2.add('1');
                } else {
                    s1.add((char) q);
                    s2.add('0');
                }
            }
        });

        String r1 = s1.stream().map(String::valueOf).collect(Collectors.joining());
        String r2 = s2.stream().map(String::valueOf).collect(Collectors.joining());

        // test
        output(caseNum, r1.replaceFirst("^0+(?!$)", "") + " " + r2.replaceFirst("^0+(?!$)", "")
        );
    }

    private String ns() {
        return in.next();
    }


    private void solve() {

        int numCases = in.nextInt();
        for (int i = 1; i <= numCases; i++) {
            process(i);
        }
        in.close();
    }


    private void output(int caseNum, String string) {
        System.out.println("Case #" + caseNum + ": " + string);
    }


}
