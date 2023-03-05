package com.example.lab8;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {


    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        CustomList list = new CustomList(null, new ArrayList<>());
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * Test if the list has a provided city by checking if it exists in the list after adding
     * it to the list. Before adding the city to the list, the method should indicate it is
     * not in the list
     */
    @Test
    public void hasCityTest() {
        CustomList list = new CustomList(null, new ArrayList<>());
        City city = new City("Estevan", "SK");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * Test to see if a city is successfully deleted from the list of cities
     */
    @Test
    public void deleteTest() {
        CustomList list = new CustomList(null, new ArrayList<>());
        assertEquals(0, list.getCount());
        City city = new City("Estevan", "SK");
        City city2 = new City("Calgary", "AB");
        City city3 = new City("Fredericton", "NB");
        list.addCity(city);
        list.addCity(city2);
        list.addCity(city3);
        assertEquals(3, list.getCount());
        list.delete(city);
        assertEquals(2, list.getCount());
        list.delete(city3);
        assertEquals(1, list.getCount());
        list.delete(city2);
        assertEquals(0, list.getCount());
    }

}
