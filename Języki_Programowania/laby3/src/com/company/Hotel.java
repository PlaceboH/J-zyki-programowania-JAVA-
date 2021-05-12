package com.company;

import java.security.PublicKey;
import java.util.LinkedList;

public class Hotel {
    private int maxClient;
    private int countRoom;
    private int countClients;
    private LinkedList<Room> allRooms = new LinkedList<Room>();
    private LinkedList<Client> allClients = new LinkedList<Client>();

    public int getMaxClient(){
        return maxClient;
    }
    public int getCountRoom(){
        return countRoom;
    }
    public int getCountClients(){
        return countClients;
    }
    public LinkedList<Room> getAllRooms(){
        return allRooms;
    }
    public LinkedList<Client> getAllClients(){
        return allClients;
    }

    Hotel(){
        countClients = 0;
        countRoom = 0;
        maxClient = 0;
    }

    Hotel(int countRoom, int maxClient){

        for(int i = 0; i < countRoom; i++){
            allRooms.add(new Room());
        }
        this.countRoom = countRoom;
        this.countClients = 0;
        this.maxClient = maxClient;
    }

    public void addClient(Client client){
        if(countClients < maxClient && client.getAge() > 17) {
            allClients.add(client);
            countClients++;
            for(Room i : allRooms){
                if(i.getIleMiejsc() > 0){
                    i.addClient(client);
                    break;
                }
            }
        }
    }

    public void addRoom(int price, int ileMiejsc){
        allRooms.add(new Room(ileMiejsc, price));
        countRoom++;
    }








}
