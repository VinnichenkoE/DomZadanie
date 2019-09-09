package homework_lesson5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task5 {
    public static void main(String[] args) {
        String str = "Мама мыла раму!";
        char[] chars = new char[str.length()];
        chars = str.toCharArray();
        Map<Character, Integer> vocabulary = new HashMap();
        for (int i=0;i<chars.length;i++) {
            int count = 1;
            for (int j = 0; j<chars.length;j++){
                if (i==j){
                    continue;
                }
                if (chars[i]==chars[j]){
                    count+=1;
                }

            }
            vocabulary.put(chars[i],count);
        }
        for (char a : vocabulary.keySet()) {
            System.out.println(a + ":" + vocabulary.get(a));
        }
    }
}
