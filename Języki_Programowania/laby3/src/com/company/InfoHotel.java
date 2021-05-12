package com.company;

import java.util.LinkedList;

public class InfoHotel {


    public void infoRoom(Hotel hotel) {
         LinkedList<Room> rooms =  hotel.getAllRooms();
         for(Room i : rooms){
             System.out.println( "nr pokoju: " + i.getNr());
             System.out.println( "price: " + i.getPrice());
             System.out.println( "Wolnych miejc: " + i.getIleMiejsc() + " z "  + i.getMaxMiejsc() );
         }
    }

    public void infoClients(Hotel hotel) {

        LinkedList<Room> rooms = hotel.getAllRooms();
        for(Room i : rooms){
            System.out.println( " _______Nr pokoju: " + i.getNr() + "________");
            LinkedList<Client> clients =  i.getClients();
            for (Client j : clients){
                System.out.println( "First name: " + j.getFirstName());
                System.out.println( "Second name: " + j.getSecondName());
                System.out.println( "Age: " + j.getAge());
            }
        }



    }

}
