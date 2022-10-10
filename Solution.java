import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Solution {

    public static void main(String[] args) {
        int i, j, num = 50, sum = 0, n;
        int[] a = {4, 2, 1, 4, 5, 6};
        HashMap<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> ans = null;
        for (i = 0; i < a.length; i++) {
            HashMap<Integer, ArrayList<Integer>> m1 = new HashMap<Integer, ArrayList<Integer>>();
            if (m.containsKey(num - a[i])) {
                ans = m.get(num - a[i]);
                ans.add(i);
                break;
            } else {
                ArrayList<Integer> an = new ArrayList<Integer>();
                an.add(i);
                m1.put(a[i], an);
                for (Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
                    int newKey = a[i] + entry.getKey();
                    if (newKey <= num) {
                        ArrayList<Integer> list = entry.getValue();
                        ArrayList<Integer> listNew = new ArrayList<Integer>();
                        listNew.addAll(list);
                        listNew.add(i);
                        m1.put(newKey, listNew);
                    }
                }
            }
            m.putAll(m1);
        }
        System.out.println("Ans: " + ans);
    }
}

