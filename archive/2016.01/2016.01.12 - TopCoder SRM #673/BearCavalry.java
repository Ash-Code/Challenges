package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BearCavalry {

    private int binarySearch(int warrior, int limit, ArrayList<Integer> list){
        if(warrior*list.get(0)>=limit)
            return -1;
        int hi=list.size();
        int lo=0;
        while(hi-lo>1){
            int mid=lo+(hi-lo)/2;
            if(warrior*list.get(mid)<limit)
                lo=mid;
            else
                hi=mid;
        }
        //System.out.println("----"+warrior+" "+limit+" "+lo);
        return lo;
    }

    public int countAssignments(int[] warriors, int[] horses) {
        int n = warriors.length;
        ArrayList<Integer> w = new ArrayList<Integer>();
        for (int i = 1; i < n; i++)
            w.add(warriors[i]);
        Collections.sort(w,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        long answer=0;
        outer:for (int i = 0; i < n; i++) {
            int limit = warriors[0] * horses[i];
            ArrayList<Integer> h = new ArrayList<Integer>();
            for (int j = 0; j < n; j++)
                if (j == i)
                    continue;
                else
                    h.add(horses[j]);
            Collections.sort(h);
            long tempans=1;
            for(int j=0;j<w.size();j++){
                int res=binarySearch(w.get(j),limit,h)+1;
                if(res<0)
                    continue outer;
                res-=j;
                tempans*=res;
                tempans%=1000000007;
            }
            //System.out.println(horses[i]+" "+limit+" "+tempans);
            answer+=tempans;
            answer%=1000000007;

        }

        return (int)answer;
    }
}
