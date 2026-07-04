class DynamicArray {

    private int[] _cargo;

    private int _capacity;

    private int _lastElem = -1;

    public DynamicArray(int capacity) {
        this._capacity = capacity;
        this._cargo = new int[_capacity];
    }

    public int get(int i) {
        return _cargo[i];
    }

    public void set(int i, int n) {
        this._cargo[i] = n;
    }

    public void pushback(int n) {
        if ((_lastElem + 1) < _capacity) {
            this._cargo[++_lastElem] = n;
        } else {
            this.resize();
            this.pushback(n);
        }
    }

    public int popback() {
        return get(_lastElem--);
    }

    private void resize() {
        int tmpNewCapacity = _capacity * 2;
        int[] tmpNewCargo = new int[tmpNewCapacity];
        System.arraycopy(_cargo, 0, tmpNewCargo, 0, _capacity);
        _cargo = tmpNewCargo;
        _capacity = tmpNewCapacity;
    }

    public int getSize() {
        return this._lastElem + 1;
    }

    public int getCapacity() {
        return this._capacity;
    }
}
