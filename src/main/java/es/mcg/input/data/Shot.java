package es.mcg.input.data;

public class Shot {
    private Boolean one_on_one;
    private Double statsbomb_xg;
    private Double[] end_location;
    private String key_pass_id;
    private Boolean first_time;
    private Outcome outcome;
    private Type type;
    private BodyPart bodyPart;
    private Technique technique;
    private FreezeFrame freeze_frame;

    public Shot()
    {
        this.one_on_one = false;
        this.statsbomb_xg = 0.0;
        this.end_location = null;
        this.key_pass_id = "";
        this.first_time = false;
    }

    public Boolean getOne_on_one() {
        return one_on_one;
    }

    public void setOne_on_one(Boolean one_on_one) {
        this.one_on_one = one_on_one;
    }

    public Double getStatsbomb_xg() {
        return statsbomb_xg;
    }

    public void setStatsbomb_xg(Double statsbomb_xg) {
        this.statsbomb_xg = statsbomb_xg;
    }

    public Double[] getEnd_location() {
        return end_location;
    }

    public void setEnd_location(Double[] end_location) {
        this.end_location = end_location;
    }

    public String getKey_pass_id() {
        return key_pass_id;
    }

    public void setKey_pass_id(String key_pass_id) {
        this.key_pass_id = key_pass_id;
    }

    public Boolean getFirst_time() {
        return first_time;
    }

    public void setFirst_time(Boolean first_time) {
        this.first_time = first_time;
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

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    public Technique getTechnique() {
        return technique;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }

    public FreezeFrame getFreeze_frame() {
        return freeze_frame;
    }

    public void setFreeze_frame(FreezeFrame freeze_frame) {
        this.freeze_frame = freeze_frame;
    }
}
