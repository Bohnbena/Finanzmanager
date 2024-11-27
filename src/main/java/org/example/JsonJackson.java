package org.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class JsonJackson {
    ObjectMapper objectMapper = new ObjectMapper();
    ArrayList<String> Liste = new ArrayList<String>();

   public void objectojson(ArrayList<?> list,String Flag)
   {
      File file = new File("temp");
       if (Flag.equals("Einahme"))
       {
            file = new File("Einahme" + ".json");
       }else
       {
            file = new File("Ausgabe" + ".json");
       }

       try {
           objectMapper.writeValue(file,list);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

   public Object listtoobject(String flag)
   {
       Liste = leselisteaus(flag);
       if(flag.equals("Einahme"))
       {
           Einahmen einahmen  = new Einahmen();
           einahmen.setEinahmenListe(Liste);
           return einahmen;
       }else
       {
           Ausgaben ausgaben = new Ausgaben();
           ausgaben.setEinahmenListe(Liste);
           return ausgaben;
       }
   }

   public ArrayList<String> leselisteaus (String flag)
   {
       String pfadname;
       if(flag.equals("Einahme"))
       {
           pfadname = "Einahme";
       }
       else{
           pfadname = "Ausgabe";
       }

       File file = new File(pfadname + ".json");
       try {
       return Liste = objectMapper.readValue(file, new TypeReference<ArrayList<String>>() {});
       } catch (IOException e) {
           return new ArrayList<>();
       }
   }
}
