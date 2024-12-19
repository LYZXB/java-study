package part_03;

import java.util.HashMap;
import java.util.Map;

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

    public String getGradesString(){
        if(gradesMap == null || gradesMap.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Float> entry:gradesMap.entrySet()){
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(", ");
        }
        return sb.toString();
    }

    public void setGradesMap(HashMap<String, Float> gradesMap) {
        this.gradesMap = gradesMap;
    }
}
