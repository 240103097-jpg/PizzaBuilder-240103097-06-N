interface Pizza {
    String getDescription();
    double getCost();
}
class PlainPizza implements Pizza {
    public String getDescription() {
        return "Plain Dough & Sauce"; }
    public double getCost() {
        return 5.0; }
}
abstract class ToppingDecorator implements Pizza {
    protected final Pizza pizza;
    protected ToppingDecorator(Pizza pizza) {
        this.pizza = pizza; }
    public String getDescription() {
        return pizza.getDescription() + ", " + toppingName(); }
    public double getCost() {
        return pizza.getCost() + toppingCost(); }
    protected abstract String toppingName();
    protected abstract double toppingCost();
}
class Cheese extends ToppingDecorator {
    Cheese(Pizza pizza) { super(pizza); }
    protected String toppingName() {
        return "Cheese"; }
    protected double toppingCost() {
        return 2.0; }
}
class Olives extends ToppingDecorator {
    Olives(Pizza pizza) { super(pizza); }
    protected String toppingName() {
        return "Olives"; }
    protected double toppingCost() {
        return 1.0; }
}
class Pineapple extends ToppingDecorator {
    Pineapple(Pizza pizza) { super(pizza); }
    protected String toppingName() {
        return "Pineapple"; }
    protected double toppingCost() {
        return 1.5; }
}
public class PizzaBuilder {
    public static void main(String[] args) {
        Pizza pizza = new Pineapple(new Olives(new Cheese(new PlainPizza())));
        System.out.println("Description: " + pizza.getDescription());
        System.out.printf("Total cost:  $%.2f%n", pizza.getCost());
        Pizza extraCheese = new Cheese(new Cheese(new Olives(new PlainPizza())));
        System.out.println("\nDescription: " + extraCheese.getDescription());
        System.out.printf("Total cost:  $%.2f%n", extraCheese.getCost());
    }
}