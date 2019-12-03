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
        
    
     
        if(currentSize < data.size())
        {
        
			data.add(currentSize,x);

			

			while(data.get(currentSize).compareTo(data.get(currentSize/2)) < 0)
			{
				//swap elements
				AnyType temp = data.get(currentSize/2);
				data.set(currentSize/2, data.get(currentSize));
				data.set(currentSize, temp);

				
            }
        }

		
        else
        {
        
			return;
        }
    
    }


	

        

    private void percolateDown( int hole )
    {
        if(currentSize <data.size())
        {
            AnyType temp = data.get(hole);
            int i = hole;
            while((temp.compareTo(data.get(i*2))>0)||(temp.compareTo(data.get(i*2 +1))>0))
            {
                if ((temp.compareTo(data.get(i))>0))
                {
                   
                 AnyType x = data.get(i);
                data.set(i, data.get(i*2));
                data.set(i*2, x);
                }
                else
                {
                    
                 AnyType x = data.get(i);
                data.set(i, data.get(i*2+1));
                data.set(i*2+1,x);
                }
            }

        }	
    }
}

