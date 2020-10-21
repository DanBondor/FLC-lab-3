package com.company;

public class LinkedList {
    static class Node{
        String val;
        Node next;

        public Node(String val){
            this.val = val;
            this.next = null;
        }
    }

    private Node head;

    public Node getFirst(){
        return this.head;
    }

    /**
     * inserts the value in the list
     * if the list is empty, then the value will become the first element
     * if the list isn't empty, the value will be added at the end
     * @param val the value that we wish to add in the list
     */
    public void insert(String val){
        Node new_node = new Node(val);

        if(head == null)
            head = new_node;
        else{
            Node el = this.head;
            while (el.next != null)
                el = el.next;

            el.next = new_node;
        }
    }
    /**
     * finds the node which contains the given value
     * @param val the value we are searhing for
     * @return null if the value wasn't found in the linked list,or the node which contains the value if the value was found
     */
    public Node find(String val)
    {

        Node first = this.head;

        while (first != null){
            if (val.equals(first.val))
                return first;
            first = first.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node first = this.head;
        s.append(first.val);

        while (first.next != null){
            first = first.next;
            s.append("->").append(first.val);
        }

        return s.toString();
    }
}
