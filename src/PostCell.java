
//Класс PostCell (ячейка постамата) имеет значения «Габарит ячейки»,
// «Статус ячейки» («Работает» — WORK или «На обслуживании» — AT_MAINTENANCE) и «Посылка»

public class PostCell {
    private Dimensions cellSize;
    private StatusOfCell statusOfCell;
    private Shipment shipment;

    public PostCell(Dimensions cellSize) {
        this.cellSize = cellSize;
        this.statusOfCell = StatusOfCell.WORK;
//        this.shipment = shipment;
    }


    public Shipment getShipment() {
        return shipment;
    }


    @Override
    public String toString() {
        return "PostCell{" +
                "cellSize=" + cellSize +
                ", statusOfCell=" + statusOfCell +
                ", shipment=" + shipment +
                '}';
    }

    //проверяет, есть ли посылка в ячейке
    public boolean hasShipment() {
        return shipment != null;
    }

    //Проверяет, можно ли положить посылку в ячейку (положить посылку в ячейку можно,
    // если ячейка пустая, ячейка в рабочем статусе и габариты ячейки подходят для посылки)
    public boolean canAcceptShipment(Shipment shipment) {
        return !hasShipment() &&
                this.statusOfCell == StatusOfCell.WORK &&
                this.cellSize.canHold(shipment.shipmentSize());
    }


    public boolean putShipment(Shipment shipment) {
        if (!canAcceptShipment(shipment)) {
            System.out.println("Невозможно разместить в ячейке" + this);
            return false;
        }
        this.shipment = shipment;
        return true;
    }

    // извлекает посылку из ячейки либо возвращает null, если ячейка пуста.
    public Shipment extractShipment() {
        Shipment extractedShipment = this.shipment;
        this.shipment = null;
        return extractedShipment;
    }

    //переводит ячейку в режим обслуживания (можно, только если ячейка пуста)
    public void turnMaintenanceMode() {
        if (!hasShipment()) {
            statusOfCell = StatusOfCell.AT_MAINTENANCE;
            System.out.println("Ячейка переведена на обслуживание");
        }

    }
    //переводит ячейку обратно в рабочий режим.
    public void turnWorkingMode() {
        if (statusOfCell == StatusOfCell.AT_MAINTENANCE) {
            statusOfCell = StatusOfCell.WORK;
            System.out.println("Ячейка переведена рабочее состояние");
        }


    }
}
