import java.util.*;

public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
//        System.out.println(new Solution().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
//        System.out.println(new Solution().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
//        System.out.println(new Solution().findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
//        System.out.println(new Solution().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
        System.out.println(new Solution().findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"}));

    }

    static class Solution {

        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> results = new ArrayList<>();
            int len = words.length;
            int wordLength = words[0].length();
            int totalLength = len * wordLength;

            Map<String, Integer> wordMap = new HashMap<>();
            for (String word : words) {
                wordMap.putIfAbsent(word, wordMap.size());
            }

            int[] counts = new int[wordMap.size()];
            for (String word : words) {
                counts[wordMap.get(word)]++;
            }

            for (int i = 0; i <= s.length() - totalLength; i++) {
                int[] tempCounts = new int[wordMap.size()];
                int j = i;
                for (; j < i + totalLength; j += wordLength) {
                    String substring = s.substring(j, j + wordLength);
                    Integer k = wordMap.get(substring);

                    if (k != null) {
                        if (++tempCounts[k] > counts[k]) {
                            break;
                        }
                    } else {
                        break;
                    }
                }

                if (j == i + totalLength) {
                    results.add(i);
                }
            }

            return results;
        }

        private void addResult(String s, List<String> wordList, int len, int wordLength, int index, List<Integer> results) {
            String substring = s.substring(0, wordLength);
            if (wordList.contains(substring)) {
                wordList.remove(substring);
                if (wordList.isEmpty()) {
                    results.add(index);
                    return;
                }

                addResult(s.substring(wordLength), wordList, len, wordLength, index, results);
            }
        }
    }

    static class Solution2 {

        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> results = new ArrayList<>();
            int len = words.length;
            int wordLength = words[0].length();
            int totalLength = len * wordLength;

            List<String> wordList = new ArrayList<>(Arrays.asList(words));

            for (int i = 0; i + totalLength <= s.length(); i++) {
                addResult(s.substring(i), new ArrayList<>(wordList), len, wordLength, i, results);
            }


            return results;
        }

        private void addResult(String s, List<String> wordList, int len, int wordLength, int index, List<Integer> results) {
            String substring = s.substring(0, wordLength);
            if (wordList.contains(substring)) {
                wordList.remove(substring);
                if (wordList.isEmpty()) {
                    results.add(index);
                    return;
                }

                addResult(s.substring(wordLength), wordList, len, wordLength, index, results);
            }
        }
    }

    static class Solution1 {

        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> results = new ArrayList<>();
            int len = words.length;
            int wordLength = words[0].length();

            Map<String, Integer> wordsIndexMap = new HashMap<>();
            for (String word : words) {
                wordsIndexMap.put(word, wordsIndexMap.computeIfAbsent(word, k -> 0) + 1);
            }

            Map<Integer, Map<String, Integer>> matchCountMap = new HashMap<>();
            for (int i = 0; i < s.length(); i += wordLength) {
                String substring = s.substring(i, i + wordLength);

                Integer wordIndex = wordsIndexMap.get(substring);
                if (wordIndex != null) {
                    matchCountMap.computeIfAbsent(i, k -> new HashMap<>());

                    Set<Integer> removeKeys = new HashSet<>();
                    for (Integer index : matchCountMap.keySet()) {
                        Map<String, Integer> countMap = matchCountMap.get(index);
                        int substringCount = countMap.computeIfAbsent(substring, k -> 0) + 1;

                        if (substringCount > wordsIndexMap.get(substring)) {
                            removeKeys.add(index);
                        } else {
                            countMap.put(substring, substringCount);

                            if (countMap.values().stream().mapToInt(Integer::new).sum() == len) {
                                results.add(index);
                                removeKeys.add(index);
                            }
                        }
                    }

                    if (removeKeys.size() > 0) {
                        for (Integer removeKey : removeKeys) {
                            matchCountMap.remove(removeKey);
                        }
                    }
                } else {
                    matchCountMap.clear();
                }
            }

            return results;
        }
    }
}
