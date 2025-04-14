package planning.domain.model;

public class Topic {
    private String topic;
    private String source;

    public Topic(String topic, String source) {
        this.topic = topic;
        this.source = source;
    }

    public String toString(){
        return "Topic: " + topic + "\nSource: " + source;
    }

    public String getTopic() {
        return topic;
    }

    public String getSource() {
        return source;
    }

}
