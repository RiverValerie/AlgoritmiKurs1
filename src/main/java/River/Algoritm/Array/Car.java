package River.Algoritm.Array;

import java.time.LocalDate;

class Car {
    String sign;
    String mark;
    String owner;
    LocalDate dateLastRepair;
    LocalDate dateRepairTo;

    public Car(String sign, String mark, String owner, LocalDate dateLastRepair, LocalDate dateRepairTo) {
        this.sign = sign;
        this.mark = mark;
        this.owner = owner;
        this.dateLastRepair = dateLastRepair;
        this.dateRepairTo = dateRepairTo;
    }

    @Override
    public String toString() {
        return String.format("%-6s %-10s %-30s %-16tF %-18tF", sign, mark, owner, dateLastRepair, dateRepairTo);
    }
}
