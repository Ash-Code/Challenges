package tasks;

import java.util.Arrays;

public class ListeningSongs {
    public int listen(int[] durations1, int[] durations2, int time, int T) {
        time*=60;
        Arrays.sort(durations1);
        Arrays.sort(durations2);
        int c1=0;
        if(T>durations1.length||T>durations2.length)
            return -1;
        for(int i=0;i<T;i++){
            c1+=durations1[i];
        }
        for(int i=0;i<T;i++){
            c1+=durations2[i];
        }
        if(c1>time)
            return -1;
        int p1=T;
        int p2=T;
        int c=2*T;
        while(true){
            if(p1>=durations1.length&&p2>=durations2.length)
                break;
            int v1=p1>=durations1.length?Integer.MAX_VALUE:durations1[p1];
            int v2=p2>=durations2.length?Integer.MAX_VALUE:durations2[p2];
            if(v1<v2){
                if(c1+v1>time)
                    break;
                c1+=v1;
                p1++;
                c+=1;
            }else{
                if(c1+v2>time)
                    break;
                c1+=v2;
                p2++;
                c+=1;
            }
        }
        return c;
    }
}
