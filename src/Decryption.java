public class Decryption {
    
    private String oldCode;
    private String type;

    public String getOldCode() {
        return oldCode;
    }

    public void setOldCode(String oldCode) {
        this.oldCode = oldCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Decryption{" +
                "oldCode='" + oldCode + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
