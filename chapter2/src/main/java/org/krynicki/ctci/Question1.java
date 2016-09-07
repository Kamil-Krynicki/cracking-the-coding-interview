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

        Node runner1 = root;
        Node runner2;

        while(runner1!=null){
            runner2 = runner1;
            while(runner2.next!=null){
                if(runner2.next.equals(runner1)) {
                    runner2.next = runner2.next.next;
                }
                else{
                    runner2 = runner2.next;
                }
            }
            runner1 = runner1.next;
        }

        return root;
    }
}
