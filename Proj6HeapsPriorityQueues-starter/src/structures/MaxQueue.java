package structures;

import comparators.IntegerComparator;

import java.util.Comparator;
import java.util.Iterator;

public class MaxQueue<V> implements PriorityQueue<Integer, V> {
  // TODO: Implement all abstract methods from PriorityQueue.
  private final IntegerComparator comparator = new IntegerComparator();
  private StudentArrayHeap<Integer, V> heap;

  public void maxQueue() {
      heap = new StudentArrayHeap<>(comparator);
  }
  @Override
  public PriorityQueue<Integer, V> enqueue(Integer priority, V val){
    if(priority == null || val == null){
      throw new NullPointerException("priority or val null");
    }
    heap.add(priority, val);
    return this;
  }
  @Override
  public V dequeue(){
    if(heap.isEmpty()){
      throw new IllegalStateException("Heap is empty");
    }
    return heap.remove();
  }
  @Override
  public V peek(){
    if(heap.isEmpty()){
      throw new IllegalStateException("Empty heap");
    }
    return(heap.peek());
  }
  @Override
  public int size(){
    return heap.size();
  }
  @Override
  public boolean isEmpty(){
    return heap.isEmpty();
  }
  @Override
  public Comparator<Integer> getComparator(){
    return this.comparator;
  }
  @Override
  public Iterator<Entry<Integer, V>> iterator(){
    return heap.asList().iterator();
  }
}
