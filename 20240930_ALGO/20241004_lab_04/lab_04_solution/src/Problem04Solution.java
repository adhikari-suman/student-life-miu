import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {

    public Node previous;
    public Node next;
    public final int value;
    public final int key;

    public Node(Node previous, Node next, int key, int value) {
        this.previous = previous;
        this.next = next;
        this.value = value;
        this.key = key;
    }

    public Node(int key, int value) {
        this.value = value;
        this.key = key;
    }

    public String toString(){
        return "(key: "+key+", value:"+ value+")";
    }

}

class MyLinkedList {

    private Node head;
    private Node tail;

    public MyLinkedList(){
        head = null;
        tail = null;
    }


    Node addFirst(Integer key, Integer value) {
        if (head == null){
            head = new Node(key, value);
            tail = head;
        } else {
            Node node = new Node(key, value);
            node.next = head;
            head.previous = node;
            head = node;

        }

        return head;
    }

    Node addLast(Integer key, Integer value) {
        if (head == null){
            head = new Node(key, value);
            tail = head;
        } else {
            Node node = new Node(key, value);
            tail.next = node;
            node.previous = tail;
            tail = node;
        }

        return  tail;
    }

    Node removeFirst() {
        if (head == null){
            return head;
        } else if (head == tail){
            Node node = head;
            head = null;
            tail = null;

            return node;

        } else {
            Node node = head;
            head = head.next;
            head.previous = null;

            return node;
        }
    }

    Node removeLast(){
        if (head == null){
            return head;
        } else if(head == tail){
            Node node = head;
            head = null;
            tail = null;

            return node;
        } else {
            Node node = tail;

            tail = tail.previous;
            tail.next.previous = null;
            tail.next = null;


            return node;
        }
    }

    void removeNode(Node node){
        if (head == node){
            removeFirst();
        } else if (tail == node){
            removeLast();
        } else {

            if (node.previous != null){
                node.previous.next = node.next;
            }

            if (node.next != null){
                node.next.previous = node.previous;
            }
        }
    }

    Node getHead(){
        return head;
    }

    Node getTail(){
        return tail;
    }

    @Override
    public String toString() {
        List<String> strings = new ArrayList<>();
        Node         current = head;

        while (current != null){

            strings.add(String.format("(key: %d, value: %d)", current.key, current.value));

            current = current.next;
        }

        return  String.join("<->", strings);
    }

}


class LRUCache {

    final int capacity;
    Map<Integer, Node> store;
    MyLinkedList       list;

    public LRUCache(int capacity) {
        store         = new HashMap<>();
        list          = new MyLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        System.out.printf("%nBefore get(%d) list: %s keyset: %s%n", key, list, store.keySet());

        if (store.containsKey(key)) {
            Node node = store.get(key);

            list.removeNode(node);

            list.addLast(node.key, node.value);

            System.out.printf("%nAfter get(%d) list: %s keyset:%s%n", key, list, store.keySet());

            return node.value;
        }


        System.out.printf("%nAfter get(%d) list: %s keyset: %s%n", key, list, store.keySet());
        return -1;
    }

    public void put(int key, int value) {
        System.out.printf("%nBefore put(%d,%d) list: %s, keyset: %s%n", key, value, list, store.keySet());

        if(store.containsKey(key)){
            Node node = store.get(key);
            list.removeNode(node);
            store.remove(key);
        } else if (store.size() == capacity) {
            System.out.println(list.getHead());
            System.out.println(list.getTail());

            int existingKey = list.removeFirst().key;

            store.remove(existingKey);
        }

        Node tail = list.addLast(key, value);
        store.put(key, tail);

        System.out.printf("%nAfter put(%d,%d) list: %s, keyset: %s%n", key, value, list, store.keySet());
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
