package generic;


// generic class
// when we create an instance of this class, we specify the actual type of T then everything defined as T will become that type
public class SearchResult<T>{

    private T[] data;
    private long timeTaken;

    public SearchResult(T[] data, long timeTaken) {
        this.data = data;
        this.timeTaken = timeTaken;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }
}
