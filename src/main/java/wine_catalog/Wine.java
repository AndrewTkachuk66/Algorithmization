package wine_catalog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;

/**
 Написать класс каталога вин. Информация о вине содержит поля: название, страна, дата разлива. По каждому виду вина должна быть возможность
 расчёта его выдержки в полных годах. Класс должен формировать каталог и выводить его содержимое, включая срок выдержки, на стандартное устроиство
 */
public class Wine {
    public static List<Wine> wines = new ArrayList<>();
    private String wineName;
    private String country;
    private String dateOfSpill;
    String currentDate = new SimpleDateFormat("yyyy").format(new Date());
    int[]endurances;
    int wineSize = 7;
    public Wine(){
        endurances = new int[wineSize];
    }

    public Wine(String wineName, String country, String dateOfSpill) {
        this.wineName = wineName;
        this.country = country;
        this.dateOfSpill = dateOfSpill;
        endurances = new int[wineSize];
    }

    @Override
    public String toString() {
        return " name-" + wineName + "," +
                " country-" + country + "," +
                " date of spill-" + dateOfSpill + "," +
                "\n";
    }

    public  List<Wine> makeCatalog(){
       wines.add(new Wine("Omar Khayyam","France","1988"));
       wines.add(new Wine("Shabo Reserve","France","1999"));
       wines.add(new Wine("Shabo Classsic","France","2013"));
       wines.add(new Wine("Shabo Classsic Rose","France","2010"));
       wines.add(new Wine("Shabo Classsic Cabarnet","France","2015"));
       wines.add(new Wine("Omar Khayyam","Italy","1980"));
       wines.add(new Wine("Omar Khayyam Shiraz","Italy","1985"));
       return wines;
   }

    public  void countEnduranceAndPrintCatalog() {
        for (int i = 0; i < wines.size(); i++) {
            Wine wine1 =  wines.get(i);
            String date = wine1.dateOfSpill;
            endurances[i] = Integer.parseInt(currentDate) - Integer.parseInt(date) ;
            System.out.print(wine1);
            System.out.println(" Endurance of wine is " + endurances[i] + " years" +"\n"  + "--------------------------------------------");
        }
    }

    public static void main(String[] args) {
        Wine wine = new Wine();
        wine.makeCatalog();
        wine.countEnduranceAndPrintCatalog();
    }
}
