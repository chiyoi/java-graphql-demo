package moe.neko03.demo.cosmos;

import com.azure.cosmos.CosmosClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.azure.cosmos.CosmosClient;

@Configuration
public class Config {

    private final String databaseName = "ToDoList";
    private final String containerName = "Items";

    @Bean
    public CosmosClient cosmosClient() {
        return new CosmosClientBuilder()
                .endpoint(AccountSettings.HOST)
                .key(AccountSettings.KEY)
                .buildClient();
    }
}
