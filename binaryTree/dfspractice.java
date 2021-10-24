import java.util.*;
import java.lang.*;


public class dfspractice {
    

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

    public static boolean dfs(List<List<Integer>> graph , int target , int source , int nodes){
        boolean[] vis = new boolean[nodes];

        Stack<Integer> q = new Stack<>();
        
        q.add(source);
        vis[source] = true;
        
        while (!q.isEmpty()) {
            int current = q.pop();
           
            if(current == target ){
                return true;
            }

            for (Integer neighbors : graph.get(current)) {
                
                if(vis[neighbors] == true){
                    continue;
                }else{
                    q.push(neighbors);
                    vis[neighbors] = true;
                }
                
            }
        }

        return false;
        
    }

    public static boolean dfsrecursive(List<List<Integer>> graph , int target , int source ,   boolean[] vis){

            for (Integer neighbors : graph.get(source)) {
                
                if(!vis[neighbors]){
                    vis[neighbors] = true;
                    boolean isConnected = dfsrecursive(graph, target, neighbors,vis);

                    if(isConnected) return true;
                }
            }
        return false;
        
    }
}
