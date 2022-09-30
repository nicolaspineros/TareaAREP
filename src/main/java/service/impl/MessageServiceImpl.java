package service.impl;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.Message;
import org.bson.Document;
import service.MessageService;

public class MessageServiceImpl implements MessageService {

    private MongoClient mongoClient;
    private final String URL = "mongodb+srv://nico:1234@tareaarep.b6yh2la.mongodb.net/?retryWrites=true&w=majority";


    public MessageServiceImpl() {
        ConnectionString connectionString = new ConnectionString(URL);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        this.mongoClient = (MongoClient) MongoClients.create(settings);
    }

    @Override
    public void addMessage(Message message) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("tareaarep");
        MongoCollection<Document> collection = mongoDatabase.getCollection("messages");
        Document document = addMessageDocument(message);
        collection.insertOne(document);
    }

    private Document addMessageDocument(Message message) {
        Document document = new Document();
        document.put("id",message.getId());
        document.put("content",message.getContent());
        document.put("creationDate",message.getCreationDate());
        return document;
    }

}
