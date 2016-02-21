package theory;

import java.util.*;

public class Practice {
    TrieNode root;
    ArrayList<String> ret;

    private class TrieNode {
        HashMap<Character, TrieNode> nodes;
        int prefixCount;
        char val;

        public TrieNode(char x) {
            val = x;
            nodes = new HashMap<>();
            prefixCount = 0;
        }

    }

    public void add(String word) {
        int p = 0;
        TrieNode curr = root;
        while (p < word.length()) {
            char x = word.charAt(p);
            if (!curr.nodes.containsKey(x)) {
                curr.nodes.put(x, new TrieNode(x));
            }
            curr = curr.nodes.get(x);
            p++;
            curr.prefixCount++;
        }
    }

    public void search(String word) {
        TrieNode curr = root;
        int p = 0;
        while (p < word.length()) {
            char x = word.charAt(p);
            curr = curr.nodes.get(x);
            p++;
            if (curr.prefixCount == 1) {
                ret.add(word.substring(0, p));
                break;
            }
        }
    }

    public int divide(int dividend, int divisor) {
        if(divisor==0)
            return Integer.MAX_VALUE;
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        if(dividend==0)
            return 0;
        boolean neg=false;
        if((!(dividend<0&&divisor<0))&&(dividend<0||divisor<0))
            neg=true;
        long temp=dividend;
        temp=Math.abs(temp);
        long isor=divisor;
        isor=Math.abs(isor);
        long quotient=0;
        long rem=0;
        int i=-1;
        while(temp>0){
            i++;
            temp>>=1;
        }
        if(i==-1)
            return 0;
        long div=dividend;
        div=Math.abs(div);
        System.out.println(Long.toBinaryString(div)+" "+Long.toBinaryString(isor));
        while(i>-1){
            long dd=(rem<<1)|((div&(1<<i))==0L?0L:1L);
            System.out.println("Curr dividend "+Long.toBinaryString(dd)+"("+dd+ ")");
            if(dd>=isor){
                rem=dd-isor;
                quotient=(quotient<<1)|1;
            }else{
                rem=dd;
                quotient<<=1;
            }
            System.out.println("     rem "+Long.toBinaryString(rem) +"("+rem+ ")"+"   quo : "+ Long.toBinaryString(quotient)+"("+quotient+ ")");
            i--;
        }
        if(neg){
            quotient=~quotient+1;
        }
        return (int)quotient;

    }


    public int longestValidSubString(final String brackets){
        Stack<Character> stack=new Stack<>();
        Stack<Integer> positions=new Stack<>();
        int max=0;
        for(int i=0;i<brackets.length();i++){
            char x=brackets.charAt(i);
            if(x==')'&&!stack.isEmpty()&&stack.peek()=='('){
                stack.pop();
                max=Math.max(i-positions.pop()+1,max);
                continue;
            }
            stack.push(x);
            positions.push(i);
        }
        return max;
    }

    public int expEval(final String exp){
        int res=0;
        Stack<Character> stack=new Stack<Character>();
        int pos=0;
        while(pos<exp.length()&&!stack.isEmpty()){
            char x=exp.charAt(pos);
            if(x==')'){

            }
        }
        return res;
    }


    public static void main(String args[]) {
        Scanner ss = new Scanner(System.in);
        String a = "asdasd";
        //System.out.println(Integer.MIN_VALUE);
//        for (long i = 0; i < 20; i++) {
//            System.out.println((long) Math.pow(2L, i));
//        }
        StringBuilder sb=new StringBuilder();
boolean s=true;
        s=!s;
        int q=1;
        q<<=1;
        System.out.println(new Practice().longestValidSubString("((())(((()()()()())"));

    }
}
