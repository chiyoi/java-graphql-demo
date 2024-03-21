package moe.neko03.demo.item;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;

@Repository
public interface ItemRepository extends CosmosRepository<Item, String> {

    Item findByIdAndText(String id, String text);

    @Query(value = "SELECT * FROM c")
    List<Item> getAll();

}
