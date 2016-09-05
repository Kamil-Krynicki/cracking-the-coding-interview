package org.krynicki.ctci;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by K on 2016-09-01.
 */
public class Question1 {

    //simplistic O(n) solution, using sets. No tests, but looks solid!
    public Node removeDups(Node root){
        if(root==null) return null;

        Set<Node> buffer = new HashSet<Node>();

        Node runner = root;

        buffer.add(root);

        while(runner.next!=null){
            if(!buffer.contains(runner.next)) {
                buffer.add(runner.next);
                runner = runner.next;
            }
            else {
                runner.next = runner.next.next;
            }
        }

        return root;
    }

    //simplistic O(n) solution, using sets. No tests, but looks solid!
    public Node removeDupsNoData(Node root){
        if(root==null) return null;

        Set<Node> buffer = new HashSet<Node>();

        Node runner = root;

        buffer.add(root);

        while(runner.next!=null){
            if(!buffer.contains(runner.next)) {
                buffer.add(runner.next);
                runner = runner.next;
            }
            else {
                runner.next = runner.next.next;
            }
        }

        return root;
    }
}
