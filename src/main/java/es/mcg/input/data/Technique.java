package es.mcg.input.data;

public class Technique {
    private Integer id;
    private String name;

    public Technique()
    {
        this.id = 0;
        this.name = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
