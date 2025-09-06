import java.math.BigDecimal;

public class PostCell {
    private final Dimensions dimensions;
    private StatusOfCell statusOfCell;
    private Shipment shipment;

    public PostCell(Dimensions cellSize) {
        this.dimensions = cellSize;
        this.statusOfCell = StatusOfCell.WORK;
    }

    //TODO простой геттер, использую в постамате для получения веса
    public BigDecimal getShipmentWeight() {
        return shipment.weight();
    }

    public boolean hasShipment() {
        return shipment != null;
    }

    public boolean canAcceptShipment(Shipment shipment) {
        return !hasShipment() &&
                this.statusOfCell == StatusOfCell.WORK &&
                this.dimensions.canHold(shipment.shipmentSize());
    }

    public boolean putShipment(Shipment shipment) {
        if (!canAcceptShipment(shipment)) {
            return false;
        }
        this.shipment = shipment;
        return true;
    }

    public Shipment extractShipment() {
        Shipment extractedShipment = this.shipment;
        this.shipment = null;
        return extractedShipment;
    }

    public void turnMaintenanceMode() {
        if (!hasShipment()) {
            statusOfCell = StatusOfCell.AT_MAINTENANCE;
            System.out.println("Ячейка переведена на обслуживание");
        }

    }

    public void turnWorkingMode() {
        if (statusOfCell == StatusOfCell.AT_MAINTENANCE) {
            statusOfCell = StatusOfCell.WORK;
            System.out.println("Ячейка переведена рабочее состояние");
        }
    }

    @Override
    public String toString() {
        return "PostCell{" +
                "cellSize=" + dimensions +
                ", statusOfCell=" + statusOfCell +
                ", shipment=" + shipment +
                '}';
    }
}
