package pl.futurecollars.invoicing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.db.memory.InMemoryDatabase;
import pl.futurecollars.invoicing.model.Company;
import pl.futurecollars.invoicing.model.Invoice;
import pl.futurecollars.invoicing.model.InvoiceEntry;
import pl.futurecollars.invoicing.model.Vat;
import pl.futurecollars.invoicing.service.InvoiceService;
import pl.futurecollars.invoicing.utils.FilesService;
import pl.futurecollars.invoicing.utils.JsonService;

@SpringBootApplication
public class App {

    public static void main(String[] args)  {
        SpringApplication.run(App.class, args);
    }
       /* Database db = new InMemoryDatabase();
        FilesService filesService = new FilesService();
        JsonService jsonService = new JsonService();

        InvoiceService service = new InvoiceService(db);

        Company buyer = new Company("5213861303, ", "ul. Bukowinska 24d/7 02-703 Warszawa, Polska", "iCode Trust Sp. z o.o");
        Company seller = new Company("552-168-66-00", "32-005 Niepolomice, Nagietkowa 19", "Piotr Kolacz Development");

        List<InvoiceEntry> products =
            List.of(new InvoiceEntry("Programming course", BigDecimal.valueOf(10000), BigDecimal.valueOf(2300), Vat.VAT_23));

        Invoice invoice = new Invoice(LocalDate.now(), buyer, seller, products);

        final int id = service.save(invoice);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.writeValue(new File("invoices.json"), invoice);
        objectMapper.readValue(new File("invoices.json"), Invoice.class);

        System.out.println(id);

        service.getById(id).ifPresent(System.out::println);

        System.out.println(service.getAll());

        service.delete(id);
    }*/

}

