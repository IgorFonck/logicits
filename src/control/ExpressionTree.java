/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author https://www.sanfoundry.com/java-program-construct-expression-tree-infix-expression/
 */

//This is a java program to construct Expression Tree using Infix Expression
import java.io.*;
 
class Node {
    public char data;
    public Node leftChild;
    public Node rightChild;
 
    public Node(char x) {
        data = x;
    }
 
    public void displayNode() {
        System.out.print(data);
    }
    
    @Override
    public String toString() {
        return data+"";
    }

}
 
class Stack1 {
    private Node[] a;
    private int    top, m;
 
    public Stack1(int max) {
        m = max;
        a = new Node[m];
        top = -1;
    }
 
    public void push(Node key) {
        a[++top] = key;
    }
 
    public Node pop() {
        return (a[top--]);
    }
 
    public boolean isEmpty() {
        return (top == -1);
    }
}
 
class Stack2 {
    private char[] a;
    private int    top, m;
 
    public Stack2(int max) {
        m = max;
        a = new char[m];
        top = -1;
    }
 
    public void push(char key) {
        a[++top] = key;
    }
 
    public char pop() {
        return (a[top--]);
    }
 
    public boolean isEmpty() {
        return (top == -1);
    }
}
 
class Conversion
{
    private Stack2 s;
    private String input;
    private String output = "";
 
    public Conversion(String str) {
        input = str;
        s = new Stack2(str.length());
    }
 
    public String inToPost() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '>':
                    gotOperator(ch, 1);
                    break;
                case '+':
                    gotOperator(ch, 2);
                    break;
                case '*':
                    gotOperator(ch, 3);
                    break;
                case '~':
                case '(':
                    s.push(ch);
                    break;
                case ')':
                    gotParenthesis();
                    break;
                default:
                    output = output + ch;
            }
        }
        while (!s.isEmpty())
            output = output + s.pop();
        return output;
    }
 
    private void gotOperator(char opThis, int prec1) {
        while (!s.isEmpty()) {
            char opTop = s.pop();
            if (opTop == '(') {
                s.push(opTop);
                break;
            }
            else {
                int prec2;
                if (opTop == '>')
                    prec2 = 1;
                else if(opTop == '+')
                    prec2 = 2;
                else
                    prec2 = 3;
                if (prec2 < prec1) {
                    s.push(opTop);
                    break;
                }
                else
                    output = output + opTop;
            }
        }
        s.push(opThis);
    }
 
    private void gotParenthesis() {
        while (!s.isEmpty()) {
            char ch = s.pop();
            if (ch == '(')
                break;
            else
                output = output + ch;
        }
    }
}
 
class Tree {
    private Node root;
 
    public Tree() {
        root = null;
    }
 
    public void insert(String s) {
        Conversion c = new Conversion(s);
        s = c.inToPost();
        System.out.println("Postfix: " + s);
        Stack1 stk = new Stack1(s.length());
        s = s + "#";
        int i = 0;
        char symbol = s.charAt(i);
        Node newNode, nullNode;
        while (symbol != '#') {
            if (symbol >= '0' && symbol <= '9' || symbol >= 'A'
                    && symbol <= 'Z' || symbol >= 'a' && symbol <= 'z') {
                newNode = new Node(symbol);
                stk.push(newNode);
                System.out.println("Pushed: " + newNode);
            } 
            else if (symbol == '>' || symbol == '+' || symbol == '*') {
                Node ptr1 = stk.pop();
                Node ptr2 = stk.pop();
                System.out.println("POPPED 1: " + ptr1);
                System.out.println("POPPED 2: " + ptr2);
                newNode = new Node(symbol);
                newNode.leftChild = ptr2;
                newNode.rightChild = ptr1;
                stk.push(newNode);
            } 
            else if (symbol == '~') {
                Node ptr1 = stk.pop();
                nullNode = new Node('$');
                newNode = new Node(symbol);
                //stk.push(newNode);
                newNode.rightChild = ptr1;
                newNode.leftChild = nullNode;
                stk.push(newNode);
                //((a+(b*c))+d)
            }
            symbol = s.charAt(++i);
        }
        root = stk.pop();
    }
 
    public void traverse(int type) {
        switch (type) {
            case 2:
                System.out.print("Inorder Traversal:-     ");
                inOrder(root);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
  
    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            boolean printParenthesis;
            printParenthesis = localRoot.leftChild != null;
            
            if(printParenthesis)
                System.out.print("(");
            
            inOrder(localRoot.leftChild);
            localRoot.displayNode();
            inOrder(localRoot.rightChild);
            
            if(printParenthesis)
                System.out.print(")");
        }
    }
    
    public Node getRoot() {
        return root;
    }
 
}
 
public class ExpressionTree {
    public static void main(String args[]) throws IOException {
        String ch = "y";
        DataInputStream inp = new DataInputStream(System.in);
        
        while (ch.equals("y")) {
            Tree t1 = new Tree();
            System.out.println("Enter the Expression");
            String a = inp.readLine();
            t1.insert(a);
            t1.traverse(2);
            System.out.println("");
            System.out.print("Enter y to continue ");
            ch = inp.readLine();
        }
    }

    // Método público para transformar a String em árvore
    // Retorna o símbolo da raiz
    public static String parseString(String expr) {
        Tree t1 = new Tree();
        expr = parseFormat(expr);
        t1.insert(expr);
        t1.traverse(2);
        return t1.getRoot().toString();
    }
    
    // Traduz os caracteres do exercício para o formato lido no parser
    private static String parseFormat(String in) {
        String out = in.replace("\u2192", ">");
        out = out.replace("\u2227", "*");
        out = out.replace("\u2228", "+");
        out = out.replace("<html>", "");
        return out;
    }
}