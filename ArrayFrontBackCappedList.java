import java.util.Arrays;
public class ArrayFrontBackCappedList<T> implements FrontBackCappedListInterface<T> 
{
	private T[] list;
	private int numberOfElements;
	
    public ArrayFrontBackCappedList() {
        this(10);
    }

    public ArrayFrontBackCappedList(int desiredCapacity) {
            @SuppressWarnings("unchecked")
            T[] tempList = (T[]) new Object[desiredCapacity];
            list = tempList;
            numberOfElements = 0;
    }

    public boolean addBack(T newEntry) {
        if (this.isFull())
            return false;
        
        this.list[this.numberOfElements] = newEntry;
        this.numberOfElements++;
        return true;
    }

    public boolean addFront(T newEntry) {
        if (this.isFull())
            return false;

        T prev = this.list[0];
        for (int i = 1; i <= this.numberOfElements; i++) {
            T temp = this.list[i];
            this.list[i] = prev;
            prev = temp;
        }
        this.list[0] = newEntry;
        numberOfElements++;
        return true;
    }

    public boolean contains(T anEntry) {
        if (!this.isEmpty()) {
            for (int i = 0; i < numberOfElements; i++) {
                if (list[i].equals(anEntry)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int lastIndexOf(T anEntry) {
        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[numberOfElements];
        int index = 0;
        for (int i = numberOfElements - 1; i >= 0; i--) {
            tempList[index] = this.list[i];
            index++;
        }
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].equals(anEntry))
                return numberOfElements - 1 - i;
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < numberOfElements; i++) {
            list[i] = null;
        }
        numberOfElements = 0;
    }

    public boolean isFull() {
        return this.numberOfElements == this.list.length;
    }
    public String toString() {
    	@SuppressWarnings("unchecked")
    	T[] temp= (T[])new Object[numberOfElements];
    	for(int i=0;i<numberOfElements;i++) {
    		temp[i]=list[i];
    	}
        return "size: "+numberOfElements+
                "; capacity: "+list.length+
                "; List contents: "+Arrays.toString(temp);
    }

    public T removeFront() {
        if(!this.isEmpty()) {
            T temp = this.list[0];
            for(int i=0;i<this.numberOfElements-1;i++) {
                this.list[i]=this.list[i+1];
            }
            this.list[numberOfElements-1]=null;
            numberOfElements--;
            return temp;
        }
        else
            return null;
    }

    public T removeBack() {
        if(!this.isEmpty()) {
            T temp = this.list[numberOfElements-1];
            this.list[numberOfElements-1]=null;
            numberOfElements--;
            return temp;
        }
        else
            return null;
    }

    public int indexOf(T object) {
        for(int i=0;i<numberOfElements;i++) {
            if(this.list[i].equals(object))
                return i;
        }
        return -1;
    }

    public T getEntry(int givenPosition) {
        if(isEmpty()
                ||(givenPosition>=numberOfElements||givenPosition<0))
            return null;
        else {
            return this.list[givenPosition];
        }
    }

    public boolean isEmpty() {
        if(numberOfElements==0)
            return true;
        else
            return false;
    }
    public int size() {
        return numberOfElements;
    }
}
