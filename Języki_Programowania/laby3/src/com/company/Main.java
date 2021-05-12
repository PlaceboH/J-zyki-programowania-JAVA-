package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel(50, 100);




        InfoHotel info = new InfoHotel();
        info.infoClients(hotel);
        info.infoRoom(hotel);

    }
}
