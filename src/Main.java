public class Main {
    public static void main(String[] args) {

        //В методе main создайте несколько ячеек и постамат на их основе.
        // Далее создайте несколько посылок, которые помещаются в постамат, и несколько посылок, которые не помещаются.
        // Проверьте, что постамат в итоге всех операций содержит нужное количество посылок. Извлеките все посылки.
        PostCell[] postCells = new PostCell[5];
        postCells[0] = new PostCell(new Dimensions(10, 20, 30));
        postCells[1] = new PostCell(new Dimensions(10, 20, 30));
        postCells[2] = new PostCell(new Dimensions(50, 120, 60));
        postCells[3] = new PostCell(new Dimensions(10, 20, 30));
        postCells[4] = new PostCell(new Dimensions(10, 20, 30));

        Shipment shipment0 = new Shipment(new Dimensions(40, 19, 29), 21, "#0");
        Shipment shipment1 = new Shipment(new Dimensions(9, 111, 29), 21, "#1");
        Shipment shipment2 = new Shipment(new Dimensions(9, 19, 54), 21, "#2");
        Shipment shipment3 = new Shipment(new Dimensions(9, 19, 29), 21, "#3");
        Shipment shipment4 = new Shipment(new Dimensions(9, 19, 29), 21, "#4");

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
        postamat.print();

    }
}
