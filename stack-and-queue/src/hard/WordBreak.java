package hard;

import java.util.*;

/**
 * @Description: 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * @Author: lmwis
 * @Date 2020-11-01 13:21
 * @Version 1.0
 */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        wordBreak.doWordBreak("catsanddog",new ArrayList<String>(){{
            add("cat");
            add("cats");
            add("and");
            add("sand");
            add("dog");
        }}).forEach(System.out::println);
    }

    /**
     * 未完成 太难了放弃了
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> doWordBreak(String s, List<String> wordDict) {
        StringBuffer temp = new StringBuffer();
        StringBuffer res = new StringBuffer();
        List<String> list =new ArrayList<>();
        Map<String,List<Integer>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        boolean flag = true;
        while(flag){
            List<Integer> mapList =new ArrayList<>();
            for(char c : s.toCharArray()){
                temp.append(c);
                if(wordDict.contains(temp.toString())){
                    if(set.contains(temp.toString())){
                        continue;
                    }
                    set.add(temp.toString());
                    mapList.add(wordDict.indexOf(temp.toString()));
                    res.append(temp);
                    res.append(" ");
                    temp = new StringBuffer();
                }else{
                    int length =  temp.length();
                    if(length==s.toCharArray().length || (!temp.toString().isEmpty()&&temp.charAt(temp.length()-1)==s.toCharArray()[s.length()-1])){
                        flag = false;
                    }
                }
            }
            map.put(res.toString(),mapList);
            list.add(res.toString());
            res = new StringBuffer();
        }
        return list;
    }

    /**
     * 官方版本
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
            if (index == length) {
                wordBreaks.add(new LinkedList<String>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }
}
