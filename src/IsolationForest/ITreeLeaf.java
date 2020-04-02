package IsolationForest;

public class ITreeLeaf extends ITree {
    int size;

    public ITreeLeaf(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
