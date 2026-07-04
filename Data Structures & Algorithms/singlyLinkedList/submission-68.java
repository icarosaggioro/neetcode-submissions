class LinkedList {

    private class Node {

        final int payload;

        Node next = null;
        
        public Node(int p, Node n) {
            payload = p;
            next = n;
        }

    }

    private Node _head = null;

    private Node _tail = null;

    private int _size = 0;

    public LinkedList() {
    }

    public int get(int index) {
        if (((index + 1) < 1) 
         || ((index + 1) > _size)) {
            return -1;
        }

        Node localN = _head;
        for (int i = 1; i <= index; i++) {
            localN = localN.next;
        }

        return localN.payload;
    }

    public void insertHead(int val) {
        Node newHead = new Node(val, _head);
        if (_size == 0) {
            _tail = newHead;
        }
        _head = newHead;
        _size++;
    }

    public void insertTail(int val) {
        Node newTail = new Node(val, null);
        if (_size == 0) {
            _head = newTail;
        } else {
            _tail.next = newTail;
        }
        _tail = newTail;
        _size++;
    }

    public boolean remove(int index) {
        if (((index + 1) < 1) 
         || ((index + 1) > _size)) {
            return false;
        }
        
        if (_size == 1) {
            _head = null;
            _tail = null;
            _size--;
        } else if (index == 0) {
            Node toBeRemoved = _head;
            _head = toBeRemoved.next;
            _size--;
        } else {
            Node previousNode = _getPreviousIth(index);
            Node toBeRemoved = previousNode.next;
            previousNode.next = toBeRemoved.next;
            if (toBeRemoved.next == null) {
                _tail = previousNode;
            }
            _size--;
        }

        return true;

    }

    private final Node _getPreviousIth(int index) {
        Node localN = _head;
        for (int i = 1; i < index; i++) {
            localN = localN.next;
        }

        return localN;
    }

    public ArrayList<Integer> getValues() {
        List<Integer> tmpR = new ArrayList<>(_size);

        Node localN = _head;
        for (int i = 0; i < _size; i++) {
            tmpR.add(localN.payload);
            localN = localN.next;
        }

        return (ArrayList)tmpR;
    }

}
