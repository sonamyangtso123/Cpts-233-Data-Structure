/*
 *  Assignment: Implementing Percolates
 *
 *  [this file]: Main Heap class
 *   Heaps Microassignment
 * 
 *  Contributors:
 *    Aaron S. Crandall <acrandal@wsu.edu>, 2019
 * 
 *  Copyright:
 *   For academic use only under the Creative Commons
 *   Attribution-NonCommercial-NoDerivatives 4.0 International License
 *   http://creativecommons.org/licenses/by-nc-nd/4.0
 */

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>>
{
    private ArrayList<AnyType> data = new ArrayList<>();
    private Integer currentSize = 0;
    private static final int DEFAULT_CAPACITY = 10;

    // Default constructor reserves 10 items worth of space
    public BinaryHeap () {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap (int reserve_size) {
        ensureHeapSize(reserve_size);
        currentSize = 0;
    }

    // Array initializer-based constructor
    //  Added every item in items to heap
    public BinaryHeap( AnyType [ ] items ) {
        this();             // Call default constructor
        for (AnyType item : items) {
            insert(item);
        }
    }

    // Quick hack of a print out of the heap's data
    public void dump() {
        for (AnyType val : data) {
            System.out.print(val + ", ");
        }
    }

    // Returns a SHALLOW COPY of the data arraylist
    public ArrayList<AnyType> getData() {
        ArrayList<AnyType> newData = new ArrayList<>();
        for (AnyType item : data) {
            if( item != null) {
                newData.add(item);
            }
        }
        return newData;
    }

    // Expands the heap's internal sized ArrayList
    public void ensureHeapSize(int newSize) {
        data.ensureCapacity(newSize);    // Prevent excessive copying while we're adding
        while (data.size() < newSize) {
            data.add(null);
        }
    }

    public AnyType findMin() {
        if( isEmpty( ) ) {
            throw new IndexOutOfBoundsException( );
        }
        return data.get(0);
    }

    public boolean isEmpty() {
        return (currentSize <= 0);
    }

    public void makeEmpty() {
        while( !isEmpty() ) {
            deleteMin();
        }
    }

    public int size() {
        return currentSize;
    }

    public AnyType deleteMin() {
        if( isEmpty( ) ) {
            throw new IndexOutOfBoundsException( );
        }

        AnyType minItem = findMin( );
        data.set(0, data.get(--currentSize));
        data.set(currentSize, null);
        //percolateDown( 0 );

        return minItem;
    }

    // ********************************************************************* //
    //  Microassignment Section: Implement percolations
    // ********************************************************************* //
   public void insert(AnyType x) 
    {
        if(currentSize >=data.size())
        {
            currentSize=currentSize*2;
            ensureHeapSize(currentSize);

        }

        if(currentSize == 0)
        {

            data.add(currentSize,x);
            currentSize++;

        }
        else{
            int posi = currentSize -1;

            while(data.get(posi/2).compareTo(x)>0)
            {

                data.set(posi+1, data.get(posi/2));
                posi = posi/2;

            }
            data.set(posi-1,x);
            currentSize++;
        }

        
    }

    // MA TODO: Write some kind of heap/percolate insert function
    private void percolateDown( int hole )
    {

        while ((hole +1 )*2 <= currentSize){
            int i = hole;
            int leftChild= i*2 +1;
            int rightChild = i*2 + 2;
            AnyType temp = data.get(i);

            if(temp.compareTo(data.get(leftChild))<0){
                break;
            }

        
            if (data.get(rightChild)!=null && data.get(leftChild).compareTo(data.get(rightChild))>0)
            {

                data.set(i, data.get(rightChild));
                data.set(rightChild, temp);
                i = rightChild;
            }

            else
            {

                data.set(i, data.get(leftChild));
                data.set(leftChild,temp);
                i= leftChild;
            }

        }
        	
    }
}

