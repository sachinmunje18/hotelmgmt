package com.unionFind;

class UnionFind {
	private int[] parent;
	private int[] rank;

	public UnionFind(int n) {
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	public int find(int u) {
		if (parent[u] != u) {
			parent[u] = find(parent[u]);
		}
		return parent[u];
	}

	public void union(int u, int v) {
		int rootU = find(u);
		int rootV = find(v);

		if (rootU != rootV) {
			if (rank[rootU] > rank[rootV]) {
				parent[rootV] = rootU;
			} else if (rank[rootU] < rank[rootV]) {
				parent[rootU] = rootV;
			} else {
				parent[rootV] = rootU;
				rank[rootU]++;
			}
		}
	}
}

public class CycleDetection {

	public static boolean hasCycle(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);

		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];

			int rootU = uf.find(u);
			int rootV = uf.find(v);

			if (rootU == rootV) {
				return true; // Cycle detected
			}

			uf.union(u, v);
		}

		return false; // No cycle detected
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };

		boolean hasCycle = hasCycle(n, edges);
		System.out.println("Graph has cycle: " + hasCycle);
	}
}
