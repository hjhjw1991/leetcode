public class Solution {
    // 本解不断进行了排序，时间上表现并不好，考虑有没有更优解
    // 本解的时间复杂度：
    // 设平均字符串长度m, 字符串数量n
    // 对所有字符串按字典序排序：O(n log n)
    // 对每个字符串排序O(m log m)
    // 比较和存储O(1)
    // 获取结果O(n)
    // 总共O(n log n + n*m log m) => O(n(log n + m log m))
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        if(strs==null||strs.length==0)return res;
        char[] anagram;
        Arrays.sort(strs);// 字典序排列字符串
        List<String> list;
        for(String s:strs){
            anagram = s.toCharArray();
            Arrays.sort(anagram);
            String a = String.valueOf(anagram);// 排序每个字符串
            if(map.containsKey(a)){
                map.get(a).add(s);
            }else{
                list = new ArrayList<String>();
                list.add(s);
                map.put(a, list);
            }
        }
        for(String key:map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}