


//Класс Postamat (постамат) содержит в себе массив ячеек и должен иметь три метода:

import java.util.Arrays;

public class Postamat {

    private final PostCell[] cells;

    public Postamat(PostCell[] arrCell) {
        this.cells = arrCell;
    }

    //метод для загрузки посылки в постамат.
    //кладёт посылку в ячейку, если она подходит. В ответ возвращает индекс посылки
    // в массиве ячеек, что позволяет получить посылку по индексу.
    public Integer putShipment(Shipment shipment) {
        for (int cellNumber = 0; cellNumber < cells.length; cellNumber++) {
            PostCell cell = cells[cellNumber];
            if (cell.canAcceptShipment(shipment)) {
                boolean isPutSucces = cell.putShipment(shipment);
                if (isPutSucces) {
                    System.out.println("Посылка заложена в ячейку " + cellNumber);
                }
                return cellNumber;
            }
        }
        System.out.println("Не удалось разместить, нет подходящей ячейки");
        return null;
    }


    //метод для получения посылки по индексу ячейки.
    public Shipment getShipment(int numberOfCell) {
        if (numberOfCell < 0 || numberOfCell > cells.length) {
            System.out.println("Ячейка с таким номером не найдена");
        }
        return cells[numberOfCell].extractShipment();
    }

    //метод для получения суммы всех загруженных посылок по весу.
    public double weightAllShipments() {
        double sumaryWeigh = 0;
        for (PostCell cell : cells) {
            if (cell.hasShipment()) {
                sumaryWeigh += cell.getShipment().weight();
            }
        }
        return sumaryWeigh;
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
