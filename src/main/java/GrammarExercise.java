import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        Scanner reader = new Scanner(System.in);
        String firstWordList = reader.nextLine();
        String secondWordList = reader.nextLine();

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行
        System.out.println(result);

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        List<String> firststrings = Arrays.asList(firstWordList.split("\\,"));
        List<String> secondstrings = Arrays.asList(secondWordList.split("\\,"));
        long isWord = firststrings.stream().filter(string -> string.matches("[a-zA-Z]+")).count();
        isWord += secondstrings.stream().filter(string -> string.matches("[a-zA-Z]+")).count();
        if (isWord < (firststrings.size()+secondstrings.size())) {
            throw new RuntimeException("input not");
        }
        List<String> upperFirstList = firststrings.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> upperSecondList = secondstrings.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> intersection = upperFirstList.stream().filter(t->upperSecondList.contains(t)).distinct().sorted().collect(Collectors.toList());
        intersection = intersection.stream().map(g->g.replace(""," ")).map(t->t.substring(1,t.length() - 1)).collect(Collectors.toList());
        return intersection;
    }
}
