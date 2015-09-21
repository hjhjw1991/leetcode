// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    int peek;
    boolean hasNext;
    Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if(iter.hasNext()){
            peek = iter.next();
            hasNext = true;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int ret = peek;
        if(iter.hasNext()){
            peek = iter.next();
        }else{
            hasNext = false;
        }
        return ret;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
}