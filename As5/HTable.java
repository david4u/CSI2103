package As5;

class HTable {
	public Node[] table;

	// define this method
	public HTable() {
        this.table = new Node[997];
	}

	// define this method
	public boolean insert(String k, int p) {
		int idx = hash(k);
		for( Node x = table[idx]; x != null; x = x.next) {
			if(x.key == k) {
				return false;
			}
		}
		Node newnode = new Node();
		newnode.key = k;
		newnode.payload = p;
		newnode.next = table[idx];
		table[idx] = newnode;
		return true;
	}

	// define this method
	public boolean delete(String k) {
		Node del;
		int idx = hash(k);
		//if first one is the aim
		if (table[idx].key == k) {
			del = table[idx];
			table[idx] = del.next;
			del.next = null;
			return true;
		}
		Node prev = table[idx];
		for (Node x = table[idx+1]; x!= null; x = x.next) {
			if (k.equals(x.key)) {
				prev.next = x.next;
				x.next = null;
				return true;
			} else {prev = prev.next;}
		}
		return false;
	}

	// define this method
	public int query(String k) {
		int idx = hash(k);
		for ( Node x = table[idx]; x != null; x = x.next) {
			if (k.equals(x.key)) return x.payload;
		}
		return 0;
	}

	// define this method
	public boolean modify(String k, int p) {
		int idx = hash(k);
		for (Node x = table[idx]; x != null; x = x.next) {
			if (k.equals(x.key)) {
				x.payload = p;
				return true;
			}
		}
		return false;
	}

	// do NOT modify this method
	public static int hash(String k) {
		if (k == null)
			return 0;

		int ret = k.hashCode();
		if (ret < 0)
			ret = -ret;
		ret = ret % 997;
		return ret;
	}
}

class Node {
	public String key;
	public int payload;
	public Node next;
}