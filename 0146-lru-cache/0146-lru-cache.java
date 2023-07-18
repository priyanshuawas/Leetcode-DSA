public class LRUCache {

    private int capacity;
    private Map<Integer, Node> map;
    private List<Node> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        list.remove(node);
        list.add(0, node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.remove(node);
        } else if (list.size() == capacity) {
            Node node = list.remove(list.size() - 1);
            map.remove(node.key);
        }

        Node newNode = new Node(key, value);
        list.add(0, newNode);
        map.put(key, newNode);
    }

    private class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
