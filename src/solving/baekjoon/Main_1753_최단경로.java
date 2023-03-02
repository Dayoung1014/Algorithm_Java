package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
 * 다익스트라
 * 
 * 주어진 시작점에서 다른 모든 정점으로 최단 경로를 구하는 
 * */


public class Main_1753_최단경로 {
	
	static class Node {
		int e, c;

		public Node(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		} 
		
	}

	static int V, E;
	static int[] dist;
	static boolean[] v;
	static ArrayList<Node>[] adj;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] =0;
		
		v = new boolean[V+1];
		
		adj = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); //시작 
			int v = Integer.parseInt(st.nextToken()); //끝
			int w = Integer.parseInt(st.nextToken()); //가중치
			adj[u].add(new Node(v,w));
		}
		
		for (int i = 0; i < V+1; i++) { 
			 int minIdx = -1; 
			 int minD = Integer.MAX_VALUE;
			 
			 for (int j = 0; j < V+1; j++) {
				 if(minD > dist[j] && !v[j]) {
					 minD = dist[j];
					 minIdx = j;
				 }
			}
			 
			 if(minIdx==-1) break; //연결되지 않았다면
			 v[minIdx] = true; //연결됐다면 true
			 
			 for(Node next : adj[minIdx]) { // 도착하는 곳들에서 
				 if(!v[next.e] && dist[next.e] > dist[minIdx]+next.c) { 
					 dist[next.e] = dist[minIdx]+next.c;
				 }
			 }
		}
		
		for(int i=1; i<V+1; i++) {
			if(dist[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}

}
