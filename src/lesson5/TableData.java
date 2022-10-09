package lesson5;

public class TableData {
    private final Integer value1;
    private final Integer value2;
    private final Integer value3;

    public TableData(Integer value1, Integer value2, Integer value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public Integer getValue1() {
        return value1;
    }

    public Integer getValue2() {
        return value2;
    }

    public Integer getValue3() {
        return value3;
    }

    @Override
    public String toString() {
        return "TableData{" +
                "Value1=" + value1 +
                ", Value2=" + value2 +
                ", Value3=" + value3 +
                '}';
    }
}
