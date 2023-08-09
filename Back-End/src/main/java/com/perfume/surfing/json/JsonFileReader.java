package com.perfume.surfing.json;
import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileReader {

    public static void main(String[] args) {
        String jsonFilePath = "/Users/kjwoooo/kjwproject/perfume_project/Perfume_json/perfume_json.json";
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<PerfumeForm> perfumes = mapper.readValue(new File(jsonFilePath), new TypeReference<List<PerfumeForm>>() {});

            for (PerfumeForm perfume : perfumes) {
                System.out.println("brand = " + perfume.getBrand());
                System.out.println("name = " + perfume.getName());
                System.out.println("top_nt = " + perfume.getTop_nt());
                System.out.println("mid_nt = " + perfume.getMid_nt());
                System.out.println("base_nt = " + perfume.getBase_nt());
                System.out.println("single_nt = " + perfume.getSingle_nt());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
