import java.util.*;
import java.lang.*;


public class bfspractice {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> graph = new ArrayList<>();

        int nodes = sc.nextInt();

        for(int i = 0 ; i < nodes ; i++){
            graph.add(i , new ArrayList<>());
        }

        for (int i = 0; i < nodes; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            graph.get(n).add(m);
            graph.get(m).add(n);
        }
    }

    public static boolean bfs(List<List<Integer>> graph , int target , int source , int nodes){
        boolean[] vis = new boolean[nodes];

        Queue<Integer> q = new LinkedList<>();
        
        q.add(source);
        vis[source] = true;
        
        while (!q.isEmpty()) {
            int current = q.poll();
           
            if(current == target ){
                return true;
            }

            for (Integer neighbors : graph.get(current)) {
                
                if(vis[neighbors] == true){
                    continue;
                }else{
                    q.add(neighbors);
                    vis[neighbors] = true;
                }
                
            }
        }

        return false;
        
    }
}
