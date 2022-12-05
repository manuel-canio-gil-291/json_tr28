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
}
