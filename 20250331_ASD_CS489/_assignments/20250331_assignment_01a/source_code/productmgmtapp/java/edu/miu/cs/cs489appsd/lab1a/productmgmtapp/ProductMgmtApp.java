package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductMgmtApp  {

    public static void main(String[] args) {

        // 1. Add data to projects
        List<Product> products = new ArrayList<>();

        products.add(new Product(3128874119L, "Banana", LocalDate.parse("2023-01-24"), 124, 0.55));
        products.add(new Product(2927458265L, "Apple", LocalDate.parse("2022-12-09"), 18, 1.09));
        products.add(new Product(9189927460L, "Carrot", LocalDate.parse("2023-03-31"), 89, 2.99));

        // 2. Print products to console
        printProducts(products);
    }

    public static void printProducts(List<Product> products){
        // Sort to descending order using price
        products.sort(Comparator.comparingDouble(Product::getUnitPrice).reversed());

        // Print to: JSON, XML, CSV
        printProductsAsJSON(products);
        printSeparator();
        printProductsAsXML(products);
        printSeparator();
        printProductsAsCSV(products);
    }

    private static void printProductsAsCSV(List<Product> products) {
        System.out.println("Printed in Comma-separated Values(CSV) format");
        for (Product product : products) {
            System.out.println(product.toCSV());
        }
    }

    private static void printProductsAsJSON(List<Product> products) {
        // 1. Create the json string
        StringBuilder sb = new StringBuilder();

        sb.append("[\n");
        for (Product product : products) {
            sb.append("\t").append(product.toJSON()).append(",\n");
        }

        sb.append("]");

        // 2. print the json
        System.out.println("Printed in JSON format");
        System.out.println(sb.toString());

    }

    private static void printProductsAsXML(List<Product> products){
        // 1. Create the XML string
        StringBuilder sb = new StringBuilder();

        sb.append("<?xml version=\"1.0\"?>\n")
        .append("<products>\n");

        for (Product product : products) {
            sb.append("\t").append(product.toXML()).append("\n");
        }

        sb.append("</products>\n");

        // 2. print the json
        System.out.println("Printed in XML format");
        System.out.println(sb.toString());
    }

    private  static void printSeparator(){
        System.out.println("--------------------------------------------------------");
    }

}
