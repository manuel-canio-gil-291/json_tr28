package es.mcg.input.data;

public class Clearance {
    private Boolean head, left_foot, right_foot;
    private BodyPart bodyPart;
    private Boolean aerial_won;

    public Clearance()
    {
        this.head = false;
        this.left_foot = false;
        this.right_foot = false;
        this.aerial_won = false;
    }

    public Boolean getHead() {
        return head;
    }

    public void setHead(Boolean head) {
        this.head = head;
    }

    public Boolean getLeft_foot() {
        return left_foot;
    }

    public void setLeft_foot(Boolean left_foot) {
        this.left_foot = left_foot;
    }

    public Boolean getRight_foot() {
        return right_foot;
    }

    public void setRight_foot(Boolean right_foot) {
        this.right_foot = right_foot;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    public Boolean getAerial_won() {
        return aerial_won;
    }

    public void setAerial_won(Boolean aerial_won) {
        this.aerial_won = aerial_won;
    }
    
}
