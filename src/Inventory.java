import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static java.util.Comparator.comparing;

public class Inventory extends StockItem {

    ArrayList<StockItem> itemList = new ArrayList<>();

    public void readInData(String fileName) {
        try {

            File inputFile = new File(fileName);
            Scanner sc = new Scanner(inputFile);
            sc.useDelimiter("\n");
            Scanner lineScan;
            String componentType, stockCode, extraInfo;
            int itemsInStock;
            double price;
            while (sc.hasNext()) {
                lineScan = new Scanner(sc.next());
                lineScan.useDelimiter(",");
                componentType = lineScan.next().trim();
                stockCode = lineScan.next().trim();
                itemsInStock = Integer.parseInt(lineScan.next().trim());
                price = Double.parseDouble(lineScan.next().trim());
                if (lineScan.hasNext()) {
                    extraInfo = lineScan.next();
                    this.itemList.add(new StockItem(componentType, stockCode, itemsInStock, price, extraInfo));

                } else {
                    this.itemList.add(new StockItem(componentType, stockCode, itemsInStock, price));
                }

            }
        }catch (Exception e){
            System.out.println("Couldn't read in data.");
        }
    }

        public void sortByPrice(String order)
        {
            if (order.equalsIgnoreCase("ascending"))
            {
                itemList.sort(Comparator.comparingDouble(StockItem::getPrice));
            }else if (order.equalsIgnoreCase("descending"))
            {
                itemList.sort((first, second) -> Double.compare(second.getPrice(), first.getPrice()));
            }else
                {
                System.out.println("Please pass argument: \"ascending\" or \"descending\".");
            }

            for (StockItem item : itemList){
                System.out.println(item);
            }

        }


        public void componentWithMostStock(String type) {
            if (type.equalsIgnoreCase("any")) {
                StockItem mostStock = itemList.stream().max(comparing(StockItem::getItemsInStock)).get();
                System.out.println(mostStock);
            } else if (type.equalsIgnoreCase("resistor")) {
                ArrayList<StockItem> resistorsOnly = new ArrayList<>();
                for (StockItem item : itemList) {
                    if (item.getComponentType().equalsIgnoreCase("resistor")) {
                        resistorsOnly.add(item);
                    }
                }
                StockItem mostStock = resistorsOnly.stream().max(comparing(StockItem::getItemsInStock)).get();
                System.out.println(mostStock);
            } else if (type.equalsIgnoreCase("capacitor"))
            {
                ArrayList<StockItem> capacitorsOnly = new ArrayList<>();
                for (StockItem item : itemList) {
                    if (item.getComponentType().equalsIgnoreCase("capacitor")) {
                        capacitorsOnly.add(item);
                    }
                }
                StockItem mostStock = capacitorsOnly.stream().max(comparing(StockItem::getItemsInStock)).get();
                System.out.println(mostStock);
            }else if (type.equalsIgnoreCase("diode"))
            {
                ArrayList<StockItem> diodesOnly = new ArrayList<>();
                for (StockItem item : itemList) {
                    if (item.getComponentType().equalsIgnoreCase("diode")) {
                        diodesOnly.add(item);
                    }
                }
                StockItem mostStock = diodesOnly.stream().max(comparing(StockItem::getItemsInStock)).get();
                System.out.println(mostStock);
            }else if (type.equalsIgnoreCase("transistor"))
            {
                ArrayList<StockItem> transistorsOnly = new ArrayList<>();
                for (StockItem item : itemList) {
                    if (item.getComponentType().equalsIgnoreCase("transistor")) {
                        transistorsOnly.add(item);
                    }
                }
                StockItem mostStock = transistorsOnly.stream().max(comparing(StockItem::getItemsInStock)).get();
                System.out.println(mostStock);
            }else if (type.equalsIgnoreCase("IC"))
            {
                ArrayList<StockItem> icsOnly = new ArrayList<>();
                for (StockItem item : itemList) {
                    if (item.getComponentType().equalsIgnoreCase("IC")) {
                        icsOnly.add(item);
                        System.out.println(item);
                    }
                }
                StockItem mostStock = icsOnly.stream().max(comparing(StockItem::getItemsInStock)).get();
                System.out.println(mostStock);
            }else {
                System.out.println("Please enter one of: any, resistor, capacitor, diodes, transistor, ic");
            }
        }

        public void numOfTypeOfTransistors(String type)
        {
            int total = 0;
            for (StockItem item : itemList){
                if (item.getExtraInfo().trim().equalsIgnoreCase(type)) {
                    total += 1;
                }
            }
            System.out.println("There is - "+ total + " " + type.toUpperCase() + " - transistors in stock");
        }


        public void totalResistance()
        {
            double total = 0;
            for (StockItem item : itemList){
                if (item.getComponentType().equalsIgnoreCase("resistor")){
                    double resistance = Double.parseDouble(item.getExtraInfo());
                    total = total + resistance;
                }
            }
            System.out.println(total);
        }


        public void itemsWithPriceAbove(double price )
        {
            int total = 0;
            for (StockItem item : itemList){
                if (item.getPrice() >= price){
                    total += 1;
                }
            }
            System.out.println(total);
        }
}
