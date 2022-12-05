package es.mcg.input.data;

public class PossessionTeam {
    private Integer id;
    private String name;

    public PossessionTeam()
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
