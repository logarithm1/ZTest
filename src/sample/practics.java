package sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import sample.practics.Graph.Edge;

public class practics {

	Scanner in;
	BufferedWriter out = new BufferedWriter(new FileWriter("prob.out"));;

	public practics() throws IOException {
		 in = new Scanner(new File("prob.in"));
	}

	public static void main(String[] args) throws IOException {
		
		Double d = Math.pow(10, -323);
		System.out.println(d);
		practics s = new practics();
		//s.solve();
		
		//s.intrapolate();
		//s.dijik();
		//s.unfin();
		//s.cycledirected();
		//s.orderdirected();
		
		//s.linkedadd();
		//s.linkedmerge();
		
		
		//s.bitcountdiffsum();

		//s.dynlongsubseq();
		//s.dynlongasc();
		
		
		// heap();
		// quick();
		// mergeSort();
		//s.mergeLinked();
		//s.seartre();
		//s.arrangeRepeated();
		
		//s.level();
		s.levelheight();
	}
	
	private void levelheight() {
		Node t1=makeTree(10,100,200);
		Node t2=makeTree(20,300,400);
		Node r=new Node(0);
		r.left=t1;
		r.right=t2;
		t1.left.left=new Node(1000);
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(r);
		queue.add(null);
		int height=0;
		while(!queue.isEmpty()) {
			Node n = queue.remove();
			if(n==null) {
				height++;
				if(!queue.isEmpty()) {
					queue.add(null);
				}
			} else {
				if(n.left==null && n.right==null) {
					System.out.println("height: "+height);
					break;
				} 
				if(n.left !=null) {
					queue.add(n.left);
				}
				if(n.right !=null) {
					queue.add(n.right);
				}
				
			}
			
		}
	}

	private void level() {
		Node t1=makeTree(10,100,200);
		Node t2=makeTree(20,300,400);
		Node r=new Node(0);
		r.left=t1;
		r.right=t2;
		t1.left.left=new Node(1000);
		
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		
		Node out = new Node(r.val);
		int level=0;
		Queue<Node> parent = new LinkedList<Node>();
		parent.add(out);
		Node parentNode=null;
		while(!q1.isEmpty() || !q2.isEmpty()) {
			int parentindex=0;
			if(!q1.isEmpty()) {
				while(!q1.isEmpty()) {
					Node node=q1.remove();
					if(parentindex%2==0) {
						parentNode=parent.remove();
						parentNode.left=new Node(node.val);
					}
					else {
						parentNode.right=new Node(node.val);
					}
					parentindex++;
					q2.add(node.left);
					q2.add(node.right);
				}
			} else {
				while(!q2.isEmpty()) {
					Node node=q2.remove();
					if(parentindex%2==0) {
						parentNode=parent.remove();
						parentNode.left=new Node(node.val);
					}
					else {
						parentNode.right=new Node(node.val);
					}
					parentindex++;
					q1.add(node.left);
					q1.add(node.right);
				}
			}
		}
		
	}
	private Node makeTree(int rt, int l, int r) {
		Node root=new Node(rt);
		root.left=new Node(l);
		root.right=new Node(r);
		return root;
	}

	private void bitcountdiffsum() {
		int[]  a = new int[]{1,2,3,32093};
		
		int even = Integer.parseInt("101010101010101010101010101010", 2); 
		int odds = Integer.parseInt("1010101010101010101010101010101", 2); 
		
		even=0xAAAAAAAA;
		odds=0x55555555;
		System.out.println(Integer.toBinaryString(odds));
		System.out.println(Integer.toBinaryString(even));
		
		for(int x:a) {
			System.out.println("Input- "+ Integer.toBinaryString(x));
			int oddbits=(x&odds) <<1;
			int evenbits=(x&even) >> 1;
			//System.out.println(Integer.toBinaryString(x&odds));
			//System.out.println(Integer.toBinaryString(x&even));
			
			System.out.println("reverse   " + Integer.toBinaryString(oddbits|evenbits));
		}
		
	}
	
	private void dynlongasc() {
		// TODO Auto-generated method stub
		
		int[] list = new int[] {1, 20, 11, 21, 22, 23,24,2, 3, 4, 5};
		
		int count = longascrec(list,0, -1);
		System.out.println("count: " + count);
	}

	private int longascrec(int[] list, int index, int prevVal) {
		
		if(index>=list.length) return 0;

		if(list[index]>prevVal) {
			int a = 1+longascrec(list, index+1, list[index]);
			int b = longascrec(list, index+1, prevVal);

			return Math.max(a, b);
		} else {
			return longascrec(list, index+1, prevVal);
		}
	}

	private void dynlongsubseq() {
		
		String s1 = "abcpppppppq";
		String s2 = "aqcpppb";
		
		int count = subseqrec(s1.toCharArray(),s2.toCharArray(), 0,0);
		System.out.println("count: " + count);	
		
	}

	private int subseqrec(char[] s1, char[] s2, int s1ind, int s2ind) {
		
		if(s1ind>=s1.length) return 0;
		if(s2ind>=s2.length) return 0;
		if(s1[s1ind]==s2[s2ind]) {
			return subseqrec(s1, s2, s1ind+1, s2ind+1) + 1;
		} else {
			int a=subseqrec(s1, s2, s1ind, s2ind+1);
			int b=subseqrec(s1, s2, s1ind+1, s2ind);
			return Math.max(a, b);
		}
	}

	private void linkedadd() {
		Node list1 = new Node(5);
		Node list2 = new Node(5);
		
		list1.next(new Node(2)).next(new Node(3)).next(new Node(3));
		list2.next(new Node(3)).next(new Node(4));
		
		java.util.LinkedList<Node> stack1 = new java.util.LinkedList<Node>();
		java.util.LinkedList<Node> stack2 = new java.util.LinkedList<Node>();
		buildstk(list1, stack1);
		buildstk(list2, stack2);
		
		int carry=0;
		Node result = null;
		Node prev=null;
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			int v1 = stack1.pop().val;
			int v2 = stack2.pop().val;
			
			Node newnode=new Node((v1+v2+carry)%10);
			carry=(v1+v2+carry)/10;
			newnode.next=result;
			result=newnode;
		}
		
		while(!stack1.isEmpty()) {
			int v1 = stack1.pop().val;
			Node newnode=new Node(v1+carry%10);
			carry=(v1+carry)/10;
			newnode.next=result;
			result=newnode;
		}
		
		while(!stack2.isEmpty()) {
			int v1 = stack2.pop().val;
			Node newnode=new Node(v1+carry%10);
			carry=(v1+carry)/10;
			newnode.next=result;
			result=newnode;
		}
		
		if(carry>0 ) {
			Node newnode=new Node(carry);
			newnode.next=result;
			result=newnode;
		}
		
		System.out.println(result.val);
		while(result.next !=null) {
			System.out.println(result.next.val);
			result=result.next;
		}

	}

	private void linkedmerge() {
		Node list = new Node(5);
		
		list.next(new Node(1)).next(new Node(7)).next(new Node(2)).next(new Node(4)).next(new Node(8)).next(new Node(0)).next(new Node(9));

		
		Node sorted=merges(list); 
		
		while(sorted !=null) {
			System.out.println(sorted.val);
			sorted=sorted.next;
		}

	}
	private Node merges(Node list) {
		System.out.println("list - "+list);
		if(list ==null || list.next ==null) {
			return list;
		}

		Node list1=list;
		
		Node list2=split(list);
		System.out.println("part1 - "+list + " part2: " + list2);
	
		
		list1=merges(list1);
		list2=merges(list2);
		Node result = merge(list1,list2);
		return result;

		
	}

	private Node split(Node list) {
		
		if(list==null) return null;
		Node slow=list;
		Node fast=list;
		Node prev=list;
		while(true) {

			prev=slow;
			slow=slow.next;
			
			if(fast.next==null || fast.next.next==null) {
				break;
			}
			fast=fast.next.next;
		}
		prev.next=null;
		return slow;
	}

	private void buildstk(Node list1, java.util.LinkedList<Node> stack1) {
		stack1.push(list1);
		while(list1.next !=null) {
			stack1.push(list1.next);
			list1=list1.next;
		}
	}

	private void orderdirected() {
		int N=6;
		Graph g = new Graph();
		boolean[] vis = new boolean[N];
		java.util.LinkedList<Integer> ordered = new java.util.LinkedList<Integer>();
		for(int i=0; i<N; i++ ) {
			if(!vis[i]) {
				
				traverse(i, g, ordered, vis);
				
			}
		}
		
		while(!ordered.isEmpty()) {
			System.out.print(ordered.poll() + " ");
		}
		
	}

	private void traverse(int node, Graph g, java.util.LinkedList<Integer> ordered, boolean[] vis) {
		List<Edge> childs = g.edges.get(node);
		
		if(childs !=null) {
			for(Edge edge:childs) {
				if(!vis[edge.en]) {
					traverse(edge.en,  g,  ordered, vis);
				}
			}
		}
		vis[node]=true;
		ordered.push(node);
		
	}

	private void cycledirected() {
		int N=6;
		Graph g = new Graph();
		boolean[] vis = new boolean[N];
		for(int i=0; i<N; i++ ) {
			if(!vis[i]) {
				
				
				boolean res = dfscycle(g, i, vis );
				
				if(res) {
					System.out.println("true");
					return;
				}
				
			}
		}
		
		System.out.println("false");

	}

	private boolean dfscycle(Graph g, int node, boolean[] vis) {

		vis[node]=true;
		List<Edge> childs = g.edges.get(node);
		
		for(Edge edge:childs) {
			if(vis[edge.en]) {
				return true;
			} else {
				boolean res = dfscycle(g, edge.en, vis);
				if(res) return res;
			}
		}
		return false;
		
	}

	private void unfin() {
		Graph g = new Graph();
		
		int[] par = new int[6];
		for(int i=0; i<par.length; i++) {
			par[i]=-1;
		}
		
		for(int i=0; i<6; i++) {
			List<Edge> edges = g.edges.get(i);
			
			if(edges !=null)
			for(Edge edge:edges) {
				int set1=find(par, i);
				int set2=find(par, edge.en);
				
				if(set1==set2) {
					System.out.println("loop : " + Arrays.toString( par));
					//[2, 4, 1, -1, 3]
					// 0, 1, 2, 3,  4

					return;
				} else {
					join(set1, set2, par);
				}
			}
		}
		
		
		System.out.println("no loop : " + Arrays.toString( par));

	}

	private void join(int set1, int set2, int[] par) {
		par[set1]=set2;
		
	}

	private int find(int[] par, int i) {
		
		while(par[i] !=-1) {
			i=par[i];
		}
		return i;
	}

	class Graph {
		int N=4;
		Map<Integer, List<Edge>> edges = new HashMap<Integer, List<Edge>>();


		public Graph() {
			//with cycle
//			edges.put(0,Arrays.asList(new Edge[] {new Edge(10,0,2), new Edge(3,0,1)}));
//			edges.put(1,Arrays.asList(new Edge[] {new Edge(5,1,4), new Edge(15,1,3)}));
//			edges.put(2,Arrays.asList(new Edge[] {new Edge(5,2,5)}));
			
			//without
			edges.put(0,Arrays.asList(new Edge[] {new Edge(10,0,2), new Edge(3,0,1)}));
			edges.put(1,Arrays.asList(new Edge[] {new Edge(5,1,4), new Edge(15,1,3)}));
			edges.put(2,Arrays.asList(new Edge[] {new Edge(5,2,4)}));
		}
		
		class Edge {
			public int wt;
			public int st;
			public int en;
			
			Edge(int wt, int st, int en) {
				this.wt=wt;
				this.st=st;
				this.en=en;
			}
		}
	}
	
	class Distance implements Comparable<Distance> {
		public int node;
		public int distance;
		public Distance(int node, int distance) {
			this.node=node;
			this.distance=distance;
		}
		@Override
		public int compareTo(Distance o) {
			return this.distance-o.distance;
		}
		
	}
	private void dijik() {
		int start=0;
		Graph g = new Graph();
		PriorityQueue<Distance> inprogress = new PriorityQueue<Distance>();
		List<Distance> done = new ArrayList<Distance>();
		boolean[] donebool = new boolean[g.N];
		
		inprogress.add(new Distance(start, 0));
		while(!inprogress.isEmpty()) {
			Distance d = inprogress.poll();
			
			if(donebool[d.node]) continue;
			done.add(d);
			donebool[d.node]=true;

			List<Edge> edges = g.edges.get(d.node);
			if(edges!=null)
			for(Edge edge:edges) {
				if(!donebool[edge.en]) {
					inprogress.add(new Distance(edge.en, edge.wt+d.distance));
				}
			}
		}
		
		for(Distance donei:done) {
			System.out.println("To N: " + donei.node + " dist: " + donei.distance);
		}
		
		
	}

	private void intrapolate() {
		
		int[] input = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
		
		int low=0;
		int high=input.length-1;
		int x = 20;
		while(high>low) {
			
			int mid=(x-input[low])*(high-low)/(input[high]-input[low]);
			
			if(input[mid]==x) {
				System.out.println("mid : " + mid);
				return;
			}
			if(input[mid]>x) {
				high=mid-1;
			} else {
				low=mid+1;
			}
			
		}
		
		
	}

	private void arrangeRepeated() {
		String input = "aaabbb";
		// aaabbbccc
		//abababccc
		//abacabcbcb
		// aaaabbcc  -- ababacacbc
		// a 4, b -2, c-2
		// a 10 b 8 c 8  d 4 
		
		
		
		char[] c = input.toCharArray();
		int[] counts = new int[26];
		Queue<Counts> mylist = new PriorityQueue<practics.Counts>();
		
		mylist.add(new Counts(20, 'a'));
		mylist.add(new Counts(10, 'b'));
		mylist.add(new Counts(5, 'c'));
		mylist.add(new Counts(5, 'd'));
				
		String out="";
		while(mylist.size()>1) {
			Counts o1=mylist.poll();
			Counts o2=mylist.poll();
			
			out+= o1.c+""+o2.c;

			o1.count--;
			o2.count--;
			if(o1.count>0) {
				mylist.add( o1);
			}
			if(o2.count>0) {
				mylist.add(o2);
			}
			
		}
		
		if(!mylist.isEmpty()) {
			out+=mylist.poll().c;
		}
		
		System.out.println(out);
	}
	
	class Counts implements Comparable<Counts>{
		public char c;
		public int count;
		Counts(int count, char c) {
			this.c=c;
			this.count=count;
		}
		@Override
		public int compareTo(Counts o) {
			return o.count-count;
		}
	}

	private void seartre() {
		Integer[] elem = new Integer[] { 201,
										4,            5, 
									656,   56,      44, 434, 
								9999, 1,  200,98 ,3,4    ,5,6   };
		
		java.util.LinkedList<Node> queue = new java.util.LinkedList<Node>();
		Node head=new Node(elem[0]);
		queue.add(head);

		for (int i=1; i< elem.length; i++) {
			Node parent = queue.peekFirst();
			Node newnode=new Node(elem[i]);
			queue.add(newnode);

			if(parent.left==null) {
				parent.left = newnode;
			} else {
				parent.right=newnode;
				queue.removeFirst();
			}
		}
		
		List<Integer> result = new ArrayList<Integer>();
		//dfs(head,result);
		bfs(head, result);
		System.out.println("Result: " + Arrays.toString(result.toArray()));
	}

	private void dfs(Node head, List<Integer> result) {
		if(head !=null) {
			dfs(head.left, result);
			dfs(head.right, result);
			result.add(head.val);
		}
	}
	
	private void bfs(Node head, List<Integer> result) {
		
		java.util.LinkedList<Node> nodeStack = new java.util.LinkedList<practics.Node>();
		if(head !=null) {
			
			nodeStack.add(head);
			while (!nodeStack.isEmpty()) {
				Node node = nodeStack.pop();
				result.add(node.val);
				if(node.left !=null)
				nodeStack.add(node.left);
				if(node.right !=null)
				nodeStack.add(node.right);
			}
			
			
		}
	}

	private void mergeLinked() {

		LinkedListL l = new LinkedListL();
		Integer[] elem = new Integer[] { 201, 4, 5, 656, 56, 44, 434, 9999, 1,
				200 };

		for (Integer value : elem) {
			l.add(value);
		}

		System.out.println("Merge I-" + l.toString());


		int len = l.length;

		int start = 0;
		int end = len - 1;
		Node list1=l.head;
		Node list2=divide(list1);
		
		l.head=mergelist(list1,list2); //
		// start to mid and mid+1 to end.

		// mergeList(input, start,mid(start, end),end); // start to mid and
		// mid+1 to end.

		System.out.println("Merge OO-" + l.toString());

	}

	private Node mergelist(Node list1, Node list2) {
		
		Node merged = new Node(-1);
		Node mergedStart=merged;
		while(list1 !=null && list2 !=null) {
			
			if(list1.val > list2.val) {
				merged.next=list1;
				merged=merged.next;
				list1=list1.next;
			} else {
				merged.next=list2;
				merged=merged.next;
				list2=list2.next;
			}
		}
		if(list1!=null) {
			merged.next=list1;
		}
		if(list2!=null) {
			merged.next=list2;
		}
		return mergedStart.next;

	}
	/**
	 * @param list1
	 * @param list2
	 * @return
	 */
	private  Node merge(Node list1, Node list2) {

		if(list1.next!=null) {
			list1=merge(list1, divide(list1));
		}

		if(list2 !=null & list2.next!=null) {
			list2=merge(list2, divide(list2));
		}
		
		Node head=new Node(0);
		Node merged=head;
		
		while(list1 !=null || list2 !=null) {
			
			if(list2==null) {
				merged.next=list1;
				merged=merged.next;
				list1=list1.next;
			} else
			if(list1==null) {
				merged.next=list2;
				merged=merged.next;
				list2=list2.next;
			} else if(list1.val > list2.val) {
				merged.next=list1;
				merged=merged.next;
				list1=list1.next;
			} else {
				merged.next=list2;
				merged=merged.next;
				list2=list2.next;
			}
		}
		

		return head.next;

	}
	private Node divide(Node list1) {
		Node start=list1;
		int len =0;
		while(start!=null) {
			len++;
			start=start.next;
		}
		start=list1;
		for(int i=1; i<len/2; i++) {
			start=start.next;
		}
		Node list2=start.next;
		start.next=null;
		return list2;
	}

	private class Node {
		public Integer val;
		public Node next;
		public Node left;
		public Node right;

		public Node(Integer val) {
			this.val = val;
		}

		public Node next(Node next) {
			this.next = next;
			return next;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String str = val.toString();
			Node tmp=next;
			while(tmp!=null) {
				str+=tmp.val;
				tmp=tmp.next;
			}
			return str;
		}
	}

	private class LinkedListL {
		public Node head;
		public Node tail;
		public int length = 0;

		public void add(int value) {
			length++;
			if (head == null) {
				head = new Node(value);
				tail = head;
			} else {
				Node prev = tail;
				tail = new Node(value);
				prev.next = tail;
			}
		}

		public String toString() {
			String res = "";
			Node start = head;

			while (start != null) {
				res += ", " + start.val;
				start = start.next;
			}
			return res;
		}
	}

	private static void heap() {
		int[] elem = new int[] { 1, 4, 5, 6, 7, 9, 4, 24, 54, 2, 5, 6, 34, 5,
				3, 656, 34, 4, 56, 44, 434, 4, 9999, 1, 200 };
		// System.out.println(Arrays.toString(elem));

		int[] heap = new int[elem.length];

		heapify(elem, heap);
		System.out.println("Heap: " + Arrays.toString(heap));
		int len = heap.length;
		for (int i = 0; i < len; i++) {
			swap(heap, 0, len - 1 - i);
			System.out.println("Swap " + Arrays.toString(heap));
			siftdown(heap, 0, len - i - 1);
			System.out.println("Sift " + Arrays.toString(heap));

		}
		System.out.println(Arrays.toString(heap));
	}

	private static void mergeSort() {
		Integer[] elem = new Integer[] { 201, 4, 5, 656, 56, 44, 434, 9999, 1,
				200 };
		System.out.println("Merge I-" + Arrays.toString(elem));

		// List<Integer> input=new LinkedList<Integer>(Arrays.asList(elem));

		int len = elem.length;

		int start = 0;
		int end = len - 1;

		// int[] to=merge(elem, start,mid(start, end),end, elem.clone()); //
		// start to mid and mid+1 to end.

		// mergeList(input, start,mid(start, end),end); // start to mid and
		// mid+1 to end.

		// System.out.println("Merge-" + input);

	}

	private static int mid(int start, int end) {
		return (end + start) / 2;
	}

	private static void mergeList(List<Integer> from, int start, int mid,
			int end) {

		if (start == end)
			return;

		int start2 = mid + 1;

		if (mid - start > 0) {
			mergeList(from, start, mid(start, mid), mid);
		}
		if (end - start2 > 0) {
			mergeList(from, start2, mid(start2, end), end);
		}

		int left = start;
		int right = start2;

		// only for clarity, can use same array buffer

		for (int i = start; i <= end; i++) {

			// if(right > end) {
			// to[i]=from[left];
			// left++;
			// } else if (left > mid) {
			// to[i]=from[right];
			// right++;
			// } else if(from[left]>from[right]) {
			// to[i]=from[left];
			// left++;
			// } else {
			// to[i]=from[right];
			// right++;
			// }
		}

		// return to;

	}
	


	private static int[] merge(int[] from, int start, int mid, int end, int[] to) {

		if (start == end)
			return to;

		int start2 = mid + 1;

		if (mid - start > 0) {
			merge(to, start, mid(start, mid), mid, from);
		}
		if (end - start2 > 0) {
			merge(to, start2, mid(start2, end), end, from);
		}

		int left = start;
		int right = start2;

		// only for clarity, can use same array buffer
		int[] merged = new int[end - start + 1];

		for (int i = start; i <= end; i++) {

			if (right > end) {
				to[i] = from[left];
				left++;
			} else if (left > mid) {
				to[i] = from[right];
				right++;
			} else if (from[left] > from[right]) {
				to[i] = from[left];
				left++;
			} else {
				to[i] = from[right];
				right++;
			}
		}

		return to;

	}

	private static void quick() {
		int[] elem = new int[] { 201, 4, 5, 656, 56, 44, 434, 9999, 1, 200 };
		System.out.println("QuickI-" + Arrays.toString(elem));

		int len = elem.length;
		int low = 0;
		int high = len - 1;
		// partition(elem, low, high);
		quicksort(elem, low, high);
		System.out.println("Quick1-" + Arrays.toString(elem));

	}

	private static void partition(int[] elem, int low, int high) {
		int left = low;
		int right = high;
		int input = elem[high];
		if (high > low) {
			while (high != low) {
				if (elem[low] > elem[high]) {
					swap(elem, high, high - 1);
					if (low + 1 != high)
						swap(elem, high, low);
					high--;
				} else {
					low++;
				}
			}
			System.out.println("Quickn-" + input + Arrays.toString(elem));
			partition(elem, left, high - 1);
			partition(elem, high + 1, right);

		}

	}

	private static void quicksort(int[] A, int lo, int hi) {
		if (lo < hi) {
			int p = partition1(A, lo, hi);
			quicksort(A, lo, p - 1);
			quicksort(A, p + 1, hi);

		}

	}

	private static int partition1(int[] A, int lo, int hi) {
		int pivot = A[hi];
		int i = lo; // place for swapping
		for (int j = lo; j <= hi - 1; j++) {
			if (A[j] <= pivot) {
				swap(A, i, j);
				i = i + 1;
			}
		}
		swap(A, i, hi);

		return i;

	}

	private static void siftdown(int[] heap, int root, int length) {
		int child1 = 2 * root + 1;
		int child2 = child1 + 1;

		if (child1 < length) {
			if (child2 < length) {
				if (heap[child2] > heap[child1]) {

					if (heap[root] < heap[child2]) {
						swap(heap, root, child2);
						siftdown(heap, child2, length);
					}
				} else {
					if (heap[root] < heap[child1]) {
						swap(heap, root, child1);
						siftdown(heap, child1, length);
					}
				}
			} else {
				if (heap[root] < heap[child1]) {
					swap(heap, root, child1);
					siftdown(heap, child1, length);
				}
			}

		}

	}

	private static void swap(int[] heap, int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;

	}

	private static void heapify(int[] elem, int[] heap) {
		heap[0] = elem[0];
		for (int i = 1; i < elem.length;) {

			heap[i] = elem[i];
			siftup(heap, i);

			// System.out.println(Arrays.toString(heap));

			i++;
		}
	}

	private static void siftup(int[] heap, int root) {
		int parent;
		if (root % 2 == 0) {
			parent = (root - 2) / 2;
		} else {
			parent = (root - 1) / 2;
		}
		if (parent >= 0) {
			if (heap[parent] < heap[root]) {
				int temp = heap[parent];
				heap[parent] = heap[root];
				heap[root] = temp;
				siftup(heap, parent);
			}
		}

	}

	public void solve() throws IOException {

		int numCases = in.nextInt();
		

		for (int i = 1; i <= numCases; i++) {
			goodluck(i);
		}

		out.close();
		in.close();

		System.out.println("************** Complete ******************");

	}

	private void runCase(int caseNum) throws IOException {

		int length = in.nextInt();
		int target = in.nextInt();
		float[] yes = new float[length];
		float[] no = new float[length];

		for (int i = 0; i < length; i++) {
			yes[i] = in.nextInt();
		}

		Arrays.sort(yes);

		for (int i = 0; i < length; i++) {
			no[i] = 1 - yes[i];
		}

		float[][] probab = new float[length + 1][length + 1];
		probab[0][0] = 1;

		probab[1][0] = no[0];
		probab[1][1] = yes[0];

		for (int i = 2; i <= length; i++) {

			for (int j = 0; j <= i; j++) {

				if (j == 0)
					probab[i][j] = probab[i][j - 1] * no[i - 1];

				if (j % 2 == 0)
					probab[i][j] = probab[i - 1][j] * yes[i - 1];

				else
					probab[i][j] = probab[i - 1][j] * no[i - 1];

			}
		}

		String K = in.next();

		String out = "";
		for (char c : K.toCharArray()) {

			if (out.equals("")) {
				out += c;
				continue;
			}

			if (out.charAt(0) <= c)
				out = c + out;
			else
				out = out + c;

		}

		output(caseNum, out);

	}

	private void goodluck(int caseNum) throws IOException {

		
		int R = in.nextInt();
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		

		for (int i = 0; i < R; i++) {
			
			
			
			int[] products = new int[K];
			Set<Integer> results = new HashSet<Integer>();
			for (int j = 0; j < K; j++) {
				products[j] = in.nextInt();
			}
			for (int j = 0; j < K; j++) {
				processNumber(products[j], results);
				if(results.size()==3) {
					break;
				}
			}
			
			
			if(results.size() == 2 && results.contains(4)) {
				results.remove(4);
				results.add(2);
				results.add(20);
			}
			
			
			String outp="";
			Iterator<Integer> iter = results.iterator();
			for(int x=0;x<3;x++) {
				if(iter.hasNext()) {
					int num=iter.next();
					if(num%10==0) {
						num/=10;
					}
					if(num%10==0) {
						num/=10;
					}
					outp+= num;
				} else {
					outp+= 2;
				}
			}
			output(outp);

		}


	}

	private void processNumber(int number, Set<Integer> results) {
		int three=0;
		int five=0;
		
		if(number % 5 ==0) {
			results.add(5);
			number=number/5;
		}
		if(number % 5 ==0) {
			results.add(50);
			number=number/5;
		}
		if(number % 5 ==0) {
			results.add(500);
			return;
		}

		if(number % 3 ==0) {
			results.add(3);
			number=number/3;
		}
		if(number % 3 ==0) {
			results.add(30);
			number=number/3;
		}
		if(number % 3 ==0) {
			results.add(300);
		}
		
		if(number % 2 ==0 && number % 4 !=0) {
			results.add(2);
			return;
		}
		if(number % 4 ==0) {
			results.add(4);
			number=number/4;

		}
		if(number % 4 ==0) {
			results.add(40);
			number=number/4;

		}
		if(number % 4 ==0) {
			results.add(400);
		}
	}

	final List<Character> s = Arrays.asList('1', '2', '3', '4', '5', '6', '7',
			'8', '9', '0');

	private String answer(Integer c) {

		String res = "";
		for (int i = 1; i <= c; i++) {
			res = res + i + " ";
		}
		return res;
	}

	public <T> List<T> intersection(List<T> list1, List<T> list2) {
		List<T> list = new ArrayList<T>();

		for (T t : list1) {
			if (list2.contains(t)) {
				list.add(t);
			}
		}

		return list;
	}

	ArrayList<Integer> keysOut;
	int stars = 0;
	int levplayed = 0;
	String result;

	public void output(int caseNum, int string) throws IOException {
		out.write("Case #" + caseNum + ": " + string + "\n");
	}

	public void output(int caseNum, String string) throws IOException {
		out.write("Case #" + caseNum + ": " + string + "\n");
	}
	public void output(String string) throws IOException {
		out.write( string + "\n");
	}

	private void tidy(int caseNum) throws IOException {

		long N = in.nextLong();
		long K = in.nextLong();
		
		int level=-1;
		long total= 0L;
		long prevtotal=0;
		while(total<K) {
			level++;
			prevtotal=total;
			total+=Math.pow(2, level);
		}
		
		
		long balanceOnLevel = K-prevtotal;

		//long extras = (long) ((N-Math.pow(2, level)) % Math.pow(2, level+1));
		
		double maxvacantonlevel = N-total; // include total assuming all rooms are occupied in current level
		if(maxvacantonlevel<0) maxvacantonlevel=0;
		double partitions = Math.pow(2, level+1);
		
		double fraction = (maxvacantonlevel%partitions)/partitions;
		
		long minvacant = (long) Math.floor(maxvacantonlevel/partitions);
		
		if(fraction == 0.5 ) {
			output(caseNum,(minvacant+1) + " " + minvacant);
			
		} else if(fraction == 0.0 ) {
			output(caseNum,(minvacant) + " " + minvacant);

		} else if(fraction < 0.5) {
			
			//long extras = (long) (maxvacantonlevel- minvacant*partitions);
			long extras = (long) (maxvacantonlevel%partitions);
			if(balanceOnLevel<=extras) {
				output(caseNum,(minvacant+1) + " " + minvacant);
			} else {
				output(caseNum,(minvacant) + " " + minvacant);
			}
			
			
		} else {
			//long lesses = (long) (partitions - (vacantsum- minvacant*partitions));
			long lesses = (long) (partitions - maxvacantonlevel % partitions);
			long extras = (long) (partitions/2 - lesses);
			if(balanceOnLevel <= extras) {
				output(caseNum,(minvacant+1) + " " + (minvacant+1));
			} else {
				output(caseNum,(minvacant+1) + " " + minvacant);
			}
			
		}
			
				
		
		

	}
}
