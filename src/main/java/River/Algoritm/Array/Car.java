package River.Algoritm.Array;

import java.util.Date;

class Car {
    String sign;
    String mark;
    String owner;
    Date dateLastRepair;
    Date dateRepairTo;

    public Car(String sign, String mark, String owner, Date dateLastRepair, Date dateRepairTo) {
        this.sign = sign;
        this.mark = mark;
        this.owner = owner;
        this.dateLastRepair = dateLastRepair;
        this.dateRepairTo = dateRepairTo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "sign='" + sign + '\'' +
                ", mark='" + mark + '\'' +
                ", owner='" + owner + '\'' +
                ", dateLastRepair=" + dateLastRepair +
                ", dateRepairTo=" + dateRepairTo +
                '}' + '\n';
    }
}
