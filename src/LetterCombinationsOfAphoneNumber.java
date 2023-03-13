import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAphoneNumber {

    public static void main(String[] args) {
        List<String> res = new Solution().letterCombinations("23");
        System.out.println(res);
    }

    static class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return new ArrayList<>();
            }

            Map<String, String[]> letterMap = getLetterMap();
            int len = 1;
            for (int i = 2; i <= digits.length(); i++) {
                len *= i;
            }

            List<String> strings = null;

            for (int i = 0; i < digits.length(); i++) {
                String k = String.valueOf(digits.charAt(i));
                strings = appendString(letterMap.get(k), i, len, strings);
            }

            return strings;
        }

        private static Map<String, String[]> getLetterMap() {
            Map<String, String[]> letterMap = new HashMap<>();
            int min = 2;

            char i = 'a';
            while (i <= 'z') {
                int len;
                if (min == 7 || min == 9) {
                    len = 4;
                } else {
                    len = 3;
                }

                String[] strs = letterMap.computeIfAbsent(String.valueOf(min), k -> new String[len]);

                for (char j = i; j < i + len; j++) {
                    strs[j - i] = Character.toString(j);
                }

                i += len;
                min++;
            }

            return letterMap;
        }

        private List<String> appendString(String[] strs, int cur, int len, List<String> stringList) {
            List<String> results = new ArrayList<>();
            if (stringList == null) {
                for (String str : strs) {
                    results.add(str);
                }
            } else {
                for (String strings : stringList) {
                    for (String str : strs) {
                        results.add(strings + str);
                    }
                }
            }
            return results;
        }

//        private List<String[]> appendString(String[] strs, int cur, int len, List<String[]> stringList) {
//            List<String[]> results = new ArrayList<>();
//            if (stringList == null){
//                for (String str : strs) {
//                    String[] strings = new String[len];
//                    strings[cur] = str;
//                    results.add(strings);
//                }
//            } else {
//                for (String[] strings : stringList) {
//                    String[] clone = strings.clone();
//                    for (String str : strs) {
//                        clone[cur] = str;
//                        results.add(clone);
//                    }
//                }
//            }
//            return results;
//        }
    }
}
