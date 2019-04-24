package flowers;

import java.util.*;

/*Каждый цветок в цветочном магазине характеризуется названием, ценой за единицу и количеством. Список названий – фиксирован. Написать программу формирования букета,
цена которого будет максимальной, не превышающей указанное значение. При неоднозначности ответа вывести все возможные варианты.
Дополнительно:
 общее количество цветков в букете должно быть нечетным;
 количество наименований цветков в букете должно быть максимальным.*/
public class Flower {
   private String nameOfFlower;
   private int amountOfFlower;
    private int budget = 2000;
    private int pricePerFlower;
    private int priceOfBouquet;
    private int count;

    List<Flower> bouquet = new ArrayList<>();
    static List<Flower> flowerShop = new ArrayList<>();
    public Flower(){};

    public int getPricePerFlower() {
        return pricePerFlower;
    }

    public Flower(String nameOfFlower, int amountOfFlower, int pricePerFlower) {
        this.nameOfFlower = nameOfFlower;
        this.amountOfFlower = amountOfFlower;
        this.pricePerFlower = pricePerFlower;
    }

    @Override
    public String toString() {
        return
                "nameOfFlower='" + nameOfFlower + '\'' +
                ", amountOfFlower=" + amountOfFlower +
                ", pricePerFlower=" + pricePerFlower + "\n";
    }

    public List<Flower> makeAssortment(){
        flowerShop.add(new Flower("Violet", 50, 20));
        flowerShop.add(new Flower("Rose", 60, 50));
        flowerShop.add(new Flower("Clove", 50, 40));
        flowerShop.add(new Flower("Tulip", 50, 100));
        flowerShop.add(new Flower("Chrysanthemum", 50, 10));
        flowerShop.add(new Flower("Chamomile", 100, 5));

        return flowerShop;
    }

    public static Comparator<Flower> flowerComparator = new Comparator<Flower>() {
        @Override
        public int compare(Flower flower1, Flower flower2) {
            int price1 = flower1.getPricePerFlower();
            int price2 = flower2.getPricePerFlower();
            return price1 - price2;
        }
    };

    public void sortPrices(){
        Collections.sort(flowerShop,Flower.flowerComparator);
        //System.out.println(flowerShop);
    }

    public List<Flower> makeBouque(){
        Flower currentFlower = null;
        count = 0;
        priceOfBouquet = 0;
        while (budget > 0){
            for (int i = 0; i < flowerShop.size() ; i++) {
                if (budget <= 0)break;
                currentFlower = flowerShop.get(i);
                if(budget >= currentFlower.getPricePerFlower()) {
                    bouquet.add(currentFlower);
                    count++;
                    budget = budget - currentFlower.getPricePerFlower();
                    priceOfBouquet = priceOfBouquet + currentFlower.getPricePerFlower();
                }
            }
        }
        if (count%2==0)
        {
            bouquet.remove(currentFlower);
            count--;
            budget = budget + currentFlower.getPricePerFlower();
            priceOfBouquet = priceOfBouquet - currentFlower.getPricePerFlower();

        }
        return bouquet;
    }

    public void soutResult(){
        System.out.println(bouquet);
        System.out.println("Flowers in bouquet: " + count);
        System.out.println("Price of bouquet: " + priceOfBouquet);
        System.out.println("Rest:" + budget);
    }
    public static void main(String[] args) {
        Flower flower = new Flower();
        flower.makeAssortment();
        //System.out.println(flower.flowerShop);
        flower.sortPrices();
        flower.makeBouque();
        System.out.println("My bouquet:");
        flower.soutResult();
    }
}
