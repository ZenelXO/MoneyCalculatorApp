package currency;

public class Currency {
    private String key;
    private String name;
    private String symbol;

    public Currency(String key, String name, String symbol) {
        this.key = key;
        this.name = name;
        this.symbol = symbol;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
