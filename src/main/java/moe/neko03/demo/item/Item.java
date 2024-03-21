package moe.neko03.demo.item;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "Items")
public class Item {

    private String id;
    @PartitionKey
    private Integer partition;
    private String text;
    private boolean completed;

    public Item() {
        // If you do not want to create a default constructor,
        // use annotation @JsonCreator and @JsonProperty in the full args constructor
    }

    public Item(String id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("(%s) %s: %s", completed ? "O" : " ", id, text);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPartition() {
        return partition;
    }

    public void setPartition(Integer partition) {
        this.partition = partition;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
