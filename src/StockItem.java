public class StockItem {

    private final String componentType;
    private final String stockCode;
    private final int itemsInStock;
    private final double price;
    private final String extraInfo;

    public StockItem(String componentType, String stockCode, int itemsInStock, double price){
        this.componentType = componentType;
        this.stockCode = stockCode;
        this.itemsInStock = itemsInStock;
        this.price = price;
        this.extraInfo = "N/A";
    }

    public StockItem(String componentType, String stockCode, int itemsInStock, double price, String extraInfo){
        this.componentType = componentType;
        this.stockCode = stockCode;
        this.itemsInStock = itemsInStock;
        this.price = price;
        this.extraInfo = extraInfo;
    }

    public StockItem(){
        this.componentType = "no type";
        this.stockCode = "N/A";
        this.itemsInStock = 0;
        this.price = 0;
        this.extraInfo = "N/A";

    }

    @Override
    public String toString() {
        return componentType + ", " + stockCode + ", " + itemsInStock + ", " + price + ", " + extraInfo;
    }


    public String getComponentType(){
        return componentType;
    }


    public int getItemsInStock(){
        return itemsInStock;
    }

    public double getPrice(){
        return price;
    }

    public String getExtraInfo(){
        return extraInfo;
    }

}
