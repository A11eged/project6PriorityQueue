package structures;

import java.util.Comparator;
import java.util.Iterator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {

	public StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
	}

	@Override
	public int getLeftChildOf(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		return (2 * index) + 1;
	}

	@Override
	public int getRightChildOf(int index) {
		if(index < 0) {
			throw new IndexOutOfBoundsException("Index is out of Bounds");
		}
		return (2 * index) + 2;
	}

	@Override
	public int getParentOf(int index) {
		if(index < 1) {
			throw new IndexOutOfBoundsException("Index is out of Bounds");
		}
		return (index - 1) / 2;
	}

	@Override
	protected void bubbleUp(int index) {
		int i = index;
		int p = (index - 1) / 2; // parent
		while((i >= 0) && getComparator().compare(heap.get(i).getPriority(), heap.get(p).getPriority()) > 0) {
			this.swap(i, p);
			i = p;
			p = (i - 1) / 2;
		}

	}

	@Override
	protected void bubbleDown(int index) {
		int i = index;
		int bigboi = i;
		while(i < size()/2) {
			int left = getLeftChildOf(i);
			int right = getRightChildOf(i);
			if(right < size() && getComparator().compare(heap.get(left).getPriority(), heap.get(right).getPriority()) < 0) {
				bigboi = right;
			}
			else {
				bigboi = left;
			}
			
			if(getComparator().compare(heap.get(i).getPriority(), heap.get(bigboi).getPriority()) >= 0) {
				break;
			}
			
			this.swap(i, bigboi);
			i = bigboi;
		}

	}

}
