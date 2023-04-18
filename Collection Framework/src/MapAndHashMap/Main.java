package MapAndHashMap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,String> country = new HashMap<>();

        country.put("TR", "Türkiye");
        country.put("TR", "TürkiyeYeni");
        country.put("GR", "Almanya");
        country.put("EN", "İngiltere");

        //System.out.println(country.get("TR"));
        //country.remove("EN");
        //country.clear();
        //System.out.println(country.size());

        for (String countryKey : country.keySet()){
            System.out.println(countryKey);
        }
        System.out.println("------------");

        for (String countryValue : country.values()){
            System.out.println(countryValue);
        }
    }
}
