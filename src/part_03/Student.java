package part_03;

import java.util.HashMap;

public class Student {
    private String name;
    private HashMap<String, Float> gradesMap;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public HashMap<String, Float> getGradesMap() {
        return gradesMap;
    }

    public void setGradesMap(HashMap<String, Float> gradesMap) {
        this.gradesMap = gradesMap;
    }
}
