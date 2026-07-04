class LinkedList {

    private class Node {

        int id = System.identityHashCode(this);
        
        int payload;

        Node next = null;
        
        public Node(int p, Node n) {
            payload = p;
            next = n;
        }

        public String toString() {
            StringBuffer r = new StringBuffer();
            r.append("[Node: ");
            r.append(this.id);
            r.append(" Payload: ");
            r.append(payload);
            r.append(" Next: ");
            r.append(next== null ? "NULL" : next.id);
            r.append("]");
            return r.toString();
        }

    }

    private Node _head = null;

    private Node _tail = null;

    private int _size = 0;

    public LinkedList() {
    }

    public int get(int index) {
        System.out.printf("--- GET - I: %d\n", index);

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
        System.out.printf("--- INSERTHEAD - V: %d, Array: %s\n", val, getValues());

        Node newHead = new Node(val, _head);
        if (_size == 0) {
            _head = newHead;
            _tail = newHead;
        } else {
            _head = newHead;
        }
        _size++;
    }

    public void insertTail(int val) {
        System.out.printf("--- INSERTTAIL - V: %d, Array: %s\n", val, getValues());

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
        System.out.printf("--- REMOVE - I: %d, Array: %s\n", index, getValues());

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
