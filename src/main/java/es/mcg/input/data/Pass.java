package es.mcg.input.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pass {
    private Recipient recipient;
    private Double length, angle;
    private Height height;
    private Double[] end_location;
    @JsonProperty(value = "switch")
    private Boolean switchParam;
    private Boolean no_touch;
    private Boolean cross;
    private Boolean cut_back;
    private String assisted_shot_id;
    private Boolean shot_assist;
    private Outcome outcome;
    private Type type;
    private Boolean through_ball;
    private Boolean inswinging, outswinging;
    private Technique technique;
    private BodyPart body_part;
    private Boolean aerial_won;

    public Pass()
    {
        this.length = 0.0;
        this.angle = 0.0;
        this.end_location = null;
        this.switchParam = false;
        this.no_touch = false;
        this.cross = false;
        this.cut_back = false;
        this.assisted_shot_id = "";
        this.shot_assist = false;
        this.through_ball = false;
        this.inswinging = false;
        this.outswinging = false;
        this.aerial_won = false;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Double[] getEnd_location() {
        return end_location;
    }

    public void setEnd_location(Double[] end_location) {
        this.end_location = end_location;
    }

    public Boolean getSwitchParam() {
        return switchParam;
    }

    public void setSwitchParam(Boolean switchParam) {
        this.switchParam = switchParam;
    }

    public Boolean getNo_touch() {
        return no_touch;
    }

    public void setNo_touch(Boolean no_touch) {
        this.no_touch = no_touch;
    }

    public Boolean getCross() {
        return cross;
    }

    public void setCross(Boolean cross) {
        this.cross = cross;
    }

    public Boolean getCut_back() {
        return cut_back;
    }

    public void setCut_back(Boolean cut_back) {
        this.cut_back = cut_back;
    }

    public String getAssisted_shot_id() {
        return assisted_shot_id;
    }

    public void setAssisted_shot_id(String assisted_shot_id) {
        this.assisted_shot_id = assisted_shot_id;
    }

    public Boolean getShot_assist() {
        return shot_assist;
    }

    public void setShot_assist(Boolean shot_assist) {
        this.shot_assist = shot_assist;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Boolean getThrough_ball() {
        return through_ball;
    }

    public void setThrough_ball(Boolean through_ball) {
        this.through_ball = through_ball;
    }

    public Boolean getInswinging() {
        return inswinging;
    }

    public void setInswinging(Boolean inswinging) {
        this.inswinging = inswinging;
    }

    public Boolean getOutswinging() {
        return outswinging;
    }

    public void setOutswinging(Boolean outswinging) {
        this.outswinging = outswinging;
    }

    public Technique getTechnique() {
        return technique;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }

    public BodyPart getBody_part() {
        return body_part;
    }

    public void setBody_part(BodyPart body_part) {
        this.body_part = body_part;
    }

    public Boolean getAerial_won() {
        return aerial_won;
    }

    public void setAerial_won(Boolean aerial_won) {
        this.aerial_won = aerial_won;
    }
}
