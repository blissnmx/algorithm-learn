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
        dfs(s,0 ,s.length(), path,res);
        return res;
    }

    private static void dfs(String s, int begin ,int len , Deque<String> path, List<String> res) {

        if(path.size() == 4){
            res.add(path.stream().map(t->t+".").collect(Collectors.joining()));
            return ;
        }
        for (int i = begin; i < begin+3; i++) {
            System.out.println(path);

            //剩余位数%（4-path.size()) >0 结束
          /*  if(((s.length()-(i+1)) / (4-path.size())) >3){
                break;
            }*/
            if(begin +i >s.length()){break;}
            //判断是否是正确的ip位数
            if(checkIpFormat(s,begin, i+1)){
                path.addLast(s.substring(begin,i+1));
                int yushu = (len -(i+1)) % (4-path.size());
                int chushu = (len-(i+1)) / (4-path.size());
                boolean flag = (yushu>0 || chushu > (4-path.size())) ? true :false;
                if(flag){
                    path.removeLast();
                    continue;
                }
                dfs(s,begin+1 ,len, path,res);
                path.removeLast();
            }
        }

    }
    private static boolean checkIpFormat(String s , int begin , int end ){
        String str = s.substring(begin, end );
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
