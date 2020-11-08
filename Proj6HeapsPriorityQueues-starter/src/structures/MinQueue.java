package structures;

import comparators.ReverseIntegerComparator;

import java.util.Comparator;
import java.util.Iterator;

public class MinQueue<V> implements PriorityQueue<Integer, V> {
  // TODO: Implement all abstract methods from PriorityQueue.
  private final ReverseIntegerComparator comparator = new ReverseIntegerComparator();
  private StudentArrayHeap<Integer, V> heap;

  public void minQueue(){
    heap = new StudentArrayHeap<>(comparator);
  }

  public PriorityQueue<Integer, V> enqueue(Integer priority, V val){
    if(priority == null || val == null){
      throw new NullPointerException("priority or val is null");
    }
    heap.add(priority, val);
    return this;
    
  }
  public V dequeue(){
    if(isEmpty()){
      throw new IllegalStateException("heap is empty");
    }
    return heap.remove();
  }
  public V peek(){
    if(isEmpty()){
      throw new IllegalStateException("cannot be peeked isEmpty true");
    }
    return heap.peek();
  }
  public int size(){
    return heap.size();
  }
  public boolean isEmpty(){
    return heap.isEmpty();
  }
  public Comparator<Integer> getComparator(){
    return this.comparator;
  }
  public Iterator<Entry<Integer, V>> iterator(){
    return heap.asList().iterator();

  }
}
