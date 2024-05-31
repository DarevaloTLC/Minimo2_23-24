package edu.upc.dsa.kebabsimulator_android.models;


import java.util.List;

public class FAQ {
    private String id;//Identificador de la FAQ
    private String f;//Pregunta
    private List<String> q;//Respuestas
    public FAQ(){}

    public void setQ(List<String> q) {
        this.q = q;
    }

    public String getF() {
        return f;
    }

    public List<String> getQ() {
        return q;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FAQ(String id, String f) {
        this.id = id;
        this.f = f;
    }

    public void addQ(String q) {
        this.q.add(q);
    }


}
