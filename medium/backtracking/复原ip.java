package medium.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class 复原ip {

    public static  List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length()<4 || s.length()>12){return res ;}

        Deque<String> path = new LinkedList<>();

        dfs(s,1 , path,res);
        return res;
    }

    private static void dfs(String s, int begin, Deque<String> path, List<String> res) {
        int remainLength = s.length() - begin ;
        //剩余位数%（4-path.size()) >0 结束
        if((remainLength / (4-path.size())) >3){
            return ;
        }
        if(path.size() == 4){
            res.add(path.stream().map(t->t+".").collect(Collectors.joining()));
            return ;
        }
        for (int i = begin; i <= begin+3; i++) {
            if(begin +i >s.length()){break;}
            //判断是否是正确的ip位数
            if(checkIpFormat(s,begin , begin+i)){
                path.addLast(s.substring(begin,i+1));

                dfs(s,begin+i , path,res);
                path.removeLast();
            }
        }

    }
    private static boolean checkIpFormat(String s , int begin , int end ){
        String str = s.substring(begin, end + 1);
        if(str.length()> 1 && str.startsWith("0")){
            return false;
        }
        int v = Integer.parseInt(str);
        if(v > 255){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = restoreIpAddresses(s);
        System.out.println(res);
    }
}
