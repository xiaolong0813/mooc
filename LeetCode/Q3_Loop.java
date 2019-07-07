import java.util.ArrayList;

public class Q3_Loop {

    public int lengthOfLongestSubstring(String s) {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char start = s.charAt(i);

            StringBuilder substr = new StringBuilder();
            substr.append(start);

            for (int j = i + 1; j < s.length(); j++){
                 if(!substr.toString().contains(s.substring(j, j + 1)))
                     substr.append(s.charAt(j));
                 else
                     break;
            }

            list.add(substr.toString());
        }

        System.out.println(list.toString());

        int max = 0;
        for (String str : list) {
            if (str.length() > max)
                max = str.length();
        }

        return max;
    }

    public static void main(String[] args) {

        Q3_Loop q = new Q3_Loop();

//        System.out.println("sfs".substring(1,2));

        System.out.println(q.lengthOfLongestSubstring("pwwkew"));
    }
}
