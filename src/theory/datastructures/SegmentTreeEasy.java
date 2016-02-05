package theory.datastructures;

import java.util.HashMap;
import java.util.Scanner;

//Woohoo! My OWN segment tree. 
public class SegmentTreeEasy {
    private int[] tree;
    private int N;// min leaf nodes required
    private int L;// leaves

    public int get(int p) {
        if (p > N) {
            return -1;
        }
        p += L;// position to leaf
        int ans = tree[p];
        while (p > 0) {
            // subtract only from the left child of parent,
            // otherwise we don't give a fuck
            if (p % 2 == 1)
                ans += tree[--p];
            p /= 2;
        }
        return ans;
    }

    public void set(int p, int val) {
        p += L;
        while (p > 0) {
            tree[p] += val;
            p /= 2;
        }
    }

    public void print() {
        int l = 1;
        int i = 1;
        // 0 based indices for leaves
        while (l <= L) {
            for (int k = 0; k < l; k++, i++) {
                System.out.print(tree[i] + " ");
            }
            l *= 2;
            System.out.println("");
        }
    }

    public SegmentTreeEasy(int n) {
        int k = 1;
        while (k < n)
            k *= 2;
        k *= 2;
        tree = new int[k];
        N = k;
        L = k / 2;
    }


    HashMap<Integer,Integer> map;

    public static void main(String args[]) {
        Scanner ss = new Scanner(System.in);
        int N = ss.nextInt();
        SegmentTreeEasy tree = new SegmentTreeEasy(N);
        // L will be the number of leaves we'll have which is ciel(log(n))
        // L-1 internal nodes
        for (int i = 0; i < N; i++)
            tree.set(i, ss.nextInt());
        tree.print();
        System.out.println(tree.get(4));

    }

}
