package moe.neko03.demo;

import java.util.Iterator;

import com.azure.cosmos.models.PartitionKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import moe.neko03.demo.item.Item;
import moe.neko03.demo.item.ItemRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    private ItemRepository repository;

    public DemoApplication(ItemRepository itemRepository) {
        repository = itemRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    public void run(String... var1) {

        logger.info("======== Start CommandLineRunner ========");
        final Item testItem1 = new Item("1", "item-1");
        final Item testItem2 = new Item("2", "item-2");
        final Item testItem3 = new Item("3", "item-3");

        logger.info("Using sync repository.");
        logger.info("---- CRUD: D");
        repository.deleteAll();

        logger.info("---- CURD: C");
        logger.info("Saving item: {}", testItem1);
        repository.save(testItem1);
        logger.info("Saving item: {}", testItem2);
        repository.save(testItem2);
        logger.info("Saving item: {}", testItem3);
        repository.save(testItem3);

        logger.info("---- CRUD: R");
        logger.info("Point read: {}",
                repository.findById(testItem1.getId(), new PartitionKey(testItem1.getPartition())).get());
        logger.info("Query: {}",
                repository.findByIdAndText(testItem1.getId(), testItem1.getText()));

        Iterator<Item> usersIterator = repository.getAll().iterator();
        logger.info("All:");
        while (usersIterator.hasNext())
            logger.info("Item: {}", usersIterator.next());
        logger.info("======== End CommandLineRunner ========");
    }
}
