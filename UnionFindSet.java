import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public static class UnionFindSet{
        Map<String,String> set;
        public UnionFindSet(){
            set=new HashMap<String,String>();
        }
        
        public void add(String name){
            if(set.get(name)==null){
                set.put(name,name);
            }
        }
        
        public void union(String name1, String name2){
            String node1=find(name1);
            String node2=find(name2);
            if(node1.equals(node2)){
                return;
            }
            set.put(node1,node2);
        }
        
        public String find(String p){
            if(!p.equals(set.get(p))){
                set.put(p,find(set.get(p)));
            }
            return set.get(p);
        }
        
        public boolean connected(String name1, String name2){
            return find(name1).equals(find(name2));
        }
    }
    public static void main(String argv[]){
        int linenum;
        UnionFindSet ufs;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            ufs=new UnionFindSet();
            linenum=in.nextInt();
            for(int i=0;i<linenum;i++){
                int oper=in.nextInt();
                String name1=in.next();
                String name2=in.next();
                ufs.add(name1);
                ufs.add(name2);
                switch(oper){
                    case 0:
                        ufs.union(name1,name2);
                        break;
                    case 1:
                        if(ufs.connected(name1,name2)){
                            System.out.println("yes");
                        }else{
                            System.out.println("no");
                        }
                }
            }
        }
    }
}