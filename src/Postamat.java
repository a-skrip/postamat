import java.math.BigDecimal;
import java.util.Arrays;

public class Postamat {

    private final PostCell[] cells;

    public Postamat(PostCell[] arrCell) {
        this.cells = arrCell;
    }

    public Integer putShipment(Shipment shipment) {
        for (int cellNumber = 0; cellNumber < cells.length; cellNumber++) {
            PostCell cell = cells[cellNumber];
            if (cell.canAcceptShipment(shipment)) {
                boolean isPutSuccess = cell.putShipment(shipment);
                if (isPutSuccess) {
                    System.out.println("Посылка " + shipment.description() + " заложена в ячейку " + cellNumber);
                }
                return cellNumber;
            }
        }
        System.out.println("Не удалось разместить посылку " + shipment.description() + ", нет подходящей ячейки");
        return null;
    }

    public Shipment getShipment(int numberOfCell) {
        if (numberOfCell < 0 || numberOfCell > cells.length) {
            System.out.println("Ячейка с таким номером не найдена");
        }
        return cells[numberOfCell].extractShipment();
    }

    public BigDecimal weightAllShipments() {
        BigDecimal weightAll = BigDecimal.valueOf(0);
        for (PostCell cell : cells) {
            if (cell.hasShipment()) {
                weightAll = weightAll.add(cell.getShipmentWeight());
            }
        }
        System.out.print("Вес всех отправлений: ");
        return weightAll;
    }

    @Override
    public String toString() {
        return "Postamat{" +
                "cells=" + Arrays.toString(cells) +
                '}';
    }

    public void print() {
        for (int numOfCell = 0; numOfCell < cells.length; numOfCell++) {
            PostCell cell = cells[numOfCell];
//            System.out.println("------------");
            System.out.print("#" + numOfCell + " - " + cell.hasShipment() + " / ");

        }
        System.out.println();
    }
}
