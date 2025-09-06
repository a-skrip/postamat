import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        PostCell[] postCells = new PostCell[5];
        postCells[0] = new PostCell(
                new Dimensions(BigDecimal.valueOf(10), BigDecimal.valueOf(10), BigDecimal.valueOf(20)));
        postCells[1] = new PostCell(
                new Dimensions(BigDecimal.valueOf(20), BigDecimal.valueOf(20), BigDecimal.valueOf(20)));
        postCells[2] = new PostCell(
                new Dimensions(BigDecimal.valueOf(20), BigDecimal.valueOf(20), BigDecimal.valueOf(20)));
        postCells[3] = new PostCell(
                new Dimensions(BigDecimal.valueOf(20), BigDecimal.valueOf(20), BigDecimal.valueOf(20)));
        postCells[4] = new PostCell(
                new Dimensions(BigDecimal.valueOf(101), BigDecimal.valueOf(50), BigDecimal.valueOf(50)));

        Shipment shipment0 = new Shipment(
                new Dimensions(BigDecimal.valueOf(10), BigDecimal.valueOf(10), BigDecimal.valueOf(20)),
                BigDecimal.valueOf(20), "#0");
        Shipment shipment1 = new Shipment(
                new Dimensions(BigDecimal.valueOf(20), BigDecimal.valueOf(20), BigDecimal.valueOf(20)),
                BigDecimal.valueOf(30), "#1");
        Shipment shipment2 = new Shipment(
                new Dimensions(BigDecimal.valueOf(19), BigDecimal.valueOf(19), BigDecimal.valueOf(19)),
                BigDecimal.valueOf(40), "#2");
        Shipment shipment3 = new Shipment(
                new Dimensions(BigDecimal.valueOf(101), BigDecimal.valueOf(10), BigDecimal.valueOf(10)),
                BigDecimal.valueOf(30), "#3");
        Shipment shipment4 = new Shipment(
                new Dimensions(BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(50)),
                BigDecimal.valueOf(20), "#4");

        Postamat postamat = new Postamat(postCells);
        postamat.putShipment(shipment0);
        postamat.putShipment(shipment1);
        postamat.putShipment(shipment2);
        postamat.putShipment(shipment3);
        postamat.putShipment(shipment4);

        System.out.println(postamat.weightAllShipments());
        postamat.print();
        postamat.getShipment(0);
        postamat.getShipment(1);
        postamat.getShipment(2);
        postamat.getShipment(4);
        postamat.print();

    }
}
