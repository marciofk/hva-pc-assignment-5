package nl.hva.pc.common;

public class Message {
    private String content;
    public Message(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public String toString() {
        return content;
    }
}
