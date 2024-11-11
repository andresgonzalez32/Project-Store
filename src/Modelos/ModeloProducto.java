/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author andre
 */
public class ModeloProducto {

    private String name;
    private String image;
    private String category;
    private int amount;
    private int id;
    private double price;
    private static Set<Integer> idsGenerados = new HashSet<>();
    private static Random random = new Random();

    public ModeloProducto(String name, String image, String category, int amount, double price) {
        this.name = name;
        this.image = image;
        this.category = category;
        this.amount = amount;
        this.id = generarId();
        this.price = price;
    }

    // Sobrecarga del constructor para aceptar un ID directamente
    public ModeloProducto(String name, String image, String category, int amount, double price, int id) {
        this.name = name;
        this.image = image;
        this.category = category;
        this.amount = amount;
        this.price = price;
        this.id = id; // Utilizar el ID proporcionado
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        // Formato simple para guardar en archivo
        return name + "," + image + "," + category + "," + amount + "," + price + "," + id;
    }

    public static ModeloProducto fromString(String linea) {
        // Separar por comas y convertir valores numéricos
        String[] datos = linea.split(",");
        return new ModeloProducto(
                datos[0].trim(),
                datos[1].trim(),
                datos[2].trim(),
                Integer.parseInt(datos[3].trim()),
                Double.parseDouble(datos[4].trim()),
                Integer.parseInt(datos[5].trim())
        );
    }

    private int generarId() {
        int nuevoId;
        do {
            nuevoId = random.nextInt(100000); // Genera un número aleatorio entre 0 y 99999
        } while (idsGenerados.contains(nuevoId)); // Verifica si el ID ya ha sido generado
        idsGenerados.add(nuevoId); // Agrega el ID al conjunto
        return nuevoId;
    }

}
