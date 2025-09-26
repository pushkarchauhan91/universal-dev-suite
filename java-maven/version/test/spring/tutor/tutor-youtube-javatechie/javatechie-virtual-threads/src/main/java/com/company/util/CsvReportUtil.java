package com.company.util;

import com.company.entity.Customer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvReportUtil {

    public static void writeCustomersToCsv(String region, List<Customer> customers) throws IOException {
        Path path = Paths.get("reports", "javatechie-virtual-threads", region + "_report.csv");
        Files.createDirectories(path.getParent());

        try (BufferedWriter writer = Files.newBufferedWriter(path);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                     .withHeader("ID", "Name", "Email", "Gender", "Region"))) {

            for (Customer customer : customers) {
                csvPrinter.printRecord(customer.getId(), customer.getName(), customer.getEmail(), customer.getGender(), customer.getRegion());
            }
        }
    }
}