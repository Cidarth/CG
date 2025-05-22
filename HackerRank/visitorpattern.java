package HackerRank;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int sum=0;
    public int getResult() {
          //implement this
        return sum;
    }

    public void visitNode(TreeNode node) {
          //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
          //implement this
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long product = 1;
    private final int MOD = 1000000007;
    
    public int getResult() {
          //implement this
        return (int) product;
    }
    
    private void check(Tree tree) {
        if (tree.getColor() == Color.RED) {
            product = (product * tree.getValue()) % MOD;
        }
    }

    public void visitNode(TreeNode node) {
        check(node);
          //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        check(leaf);
          //implement this
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthNonLeafSum = 0;
    private int greenLeafSum = 0;
    
    public int getResult() {
          //implement this
        return Math.abs(evenDepthNonLeafSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthNonLeafSum += node.getValue();
        }
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
        //implement this
    }
}

public class visitorpattern {
    
    private static int[] values;
    private static Color[] colors;
    private static Map<Integer, List<Integer>> edges = new HashMap<>();
  
    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        colors = new Color[n];
        for (int i = 0; i < n; i++) {
            int color = sc.nextInt();
            colors[i] = (color == 0) ? Color.RED : Color.GREEN;
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            edges.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        return buildTree(1, 0, new HashSet<>());
    }

    private static Tree buildTree(int nodeId, int depth, Set<Integer> visited) {
        visited.add(nodeId);

        List<Integer> children = edges.get(nodeId);
        boolean isLeaf = true;

        TreeNode node = new TreeNode(values[nodeId - 1], colors[nodeId - 1], depth);

        if (children != null) {
            for (int childId : children) {
                if (!visited.contains(childId)) {
                    isLeaf = false;
                    node.addChild(buildTree(childId, depth + 1, visited));
                }
            }
        }

        if (isLeaf) {
            return new TreeLeaf(values[nodeId - 1], colors[nodeId - 1], depth);
        }

        return node;
    }


    public static void main(String[] args) {
          Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
          ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
          FancyVisitor vis3 = new FancyVisitor();

          root.accept(vis1);
          root.accept(vis2);
          root.accept(vis3);

          int res1 = vis1.getResult();
          int res2 = vis2.getResult();
          int res3 = vis3.getResult();

          System.out.println(res1);
         System.out.println(res2);
        System.out.println(res3);
    }
}

