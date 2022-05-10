public class StockProgram {
    public static void main(String[] args) {
        Inventory myInventory = new Inventory();

        myInventory.readInData("inventory.txt");

        myInventory.sortByPrice("ascending");

        myInventory.componentWithMostStock("any");

        myInventory.numOfTypeOfTransistors("npn");

        myInventory.totalResistance();

        myInventory.itemsWithPriceAbove(10);
    }
}
