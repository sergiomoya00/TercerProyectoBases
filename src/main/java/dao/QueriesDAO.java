/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Item;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.unwind;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author HP ZBOOK 15 G3 i7
 */
public class QueriesDAO {

    public QueriesDAO() {
    }

    public void insertProduct(String name, String brand, int price, List<String> sport, String limitedEdition, int availableItems, String image, String type) {
        //Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://SA:1234@cluster0.izu6r.mongodb.net/test?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");

        try (MongoClient mongoClient = new MongoClient(uri)) {
            MongoDatabase database = mongoClient.getDatabase("BdAvanzadas");
            MongoCollection<Document> collection = database.getCollection("Articulo");

            Random rand = new Random();
            List<Document> listd = new ArrayList<>();
            List<Document> liste = new ArrayList<>();
            Document student = new Document("_id", new ObjectId());
            student.append("nombre", name)
                    .append("marca", brand)
                    .append("precio", price)
                    .append("edicionLimitada", limitedEdition)
                    .append("unidadesDisponibles", availableItems)
                    .append("tipo", type);

            for (int i = 0; i < sport.size(); i++) {
                Document[] d = new Document[100];
                d[i] = new Document("nombre", sport.get(i));
                listd.add(d[i]);

            }
            student.append("deportes", listd);
            collection.insertOne(student);

        }
    }

    public void insertPromo(String name, String description, String product, String type, String regist, String begin, String end) {
        //Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://SA:1234@cluster0.izu6r.mongodb.net/test?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");

        try (MongoClient mongoClient = new MongoClient(uri)) {
            MongoDatabase database = mongoClient.getDatabase("BdAvanzadas");
            MongoCollection<Document> collection = database.getCollection("Promocion");

            Random rand = new Random();
            List<Document> listd = new ArrayList<>();
            List<Document> liste = new ArrayList<>();
            Document student = new Document("_id", new ObjectId());
            student.append("nombre", name)
                    .append("descripcion", description)
                    .append("producto", product)
                    .append("tipo", type)
                    .append("registro", regist)
                    .append("FechaI", begin)
                    .append("FechaF", end);

            collection.insertOne(student);

        }
    }

    public void insertPromo(String name, String description, String product, String type, int regist, Date begin, Date end) {
        //Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://SA:1234@cluster0.izu6r.mongodb.net/test?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");

        try (MongoClient mongoClient = new MongoClient(uri)) {
            MongoDatabase database = mongoClient.getDatabase("BdAvanzadas");
            MongoCollection<Document> collection = database.getCollection("Promocion");

            Random rand = new Random();
            List<Document> listd = new ArrayList<>();
            List<Document> liste = new ArrayList<>();
            Document student = new Document("_id", new ObjectId());
            student.append("nombre", name)
                    .append("descripcion", description)
                    .append("producto", product)
                    .append("tipo", type)
                    .append("registro", regist)
                    .append("FechaI", begin)
                    .append("FechaF", end);

            collection.insertOne(student);

        }
    }

    public List getAllProducts() {

        List listTotal = new ArrayList<>();

        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://SA:1234@cluster0.izu6r.mongodb.net/test?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");

        try (MongoClient mongoClient = new MongoClient(uri)) {
            MongoDatabase database = mongoClient.getDatabase("BdAvanzadas");
            MongoCollection<Document> collection = database.getCollection("Articulo");

            MongoCursor cu = collection.find().projection(fields(include("nombre"), excludeId())).cursor();
            MongoCursor<Document> cur = collection.find().projection(fields(include("nombre"), excludeId())).iterator();

            while (cur.hasNext()) {

                Document temp_person_doc = cur.next();

                String houseNo = temp_person_doc.getString("nombre");
                listTotal.add(houseNo);

            }

        }
        return listTotal;
    }

    public List<Item> getProductByName(String product) {

        List<Item> listTotal = new ArrayList<>();
        int count = 0;
        String sport = "";

        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://SA:1234@cluster0.izu6r.mongodb.net/test?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");

        try (MongoClient mongoClient = new MongoClient(uri)) {
            MongoDatabase database = mongoClient.getDatabase("BdAvanzadas");
            MongoCollection<Document> collection = database.getCollection("Articulo");
            MongoCursor<Document> cursor = null;
            cursor = collection.find(and(Document.parse("{\"nombre\": \"" + product + "\"}"))).projection(fields(include("nombre"), include("marca"), include("precio"), include("edicionLimitada"), include("unidadesDisponibles"), include("tipo"), include("deportes"), excludeId())).iterator();

            //FindIterable<Document> iterable = collection.find(Document.parse("{\"nombre\": \"" + name + "\"}"));
            while (cursor.hasNext()) {

                Document temp_person_doc = cursor.next();
                String houseNo = temp_person_doc.getString("nombre");
                Integer price = temp_person_doc.getInteger("precio");
                Integer available = temp_person_doc.getInteger("unidadesDisponibles");
                String marca = temp_person_doc.getString("marca");
                String edition = temp_person_doc.getString("edicionLimitada");
                String tipo = temp_person_doc.getString("tipo");
                java.util.List sports = (java.util.List) temp_person_doc.get("deportes");
                Item[] item = new Item[100];
                item[count] = new Item();
                item[count].setName(houseNo);
                item[count].setPrice(price);
                item[count].setAvailableItems(available);
                item[count].setBrand(marca);
                item[count].setLimitedEdition(edition);
                item[count].setType(tipo);
                List<String> atributosS = new ArrayList<>();

                while (sports.isEmpty() == false) {

                    int i = 0;
                    Document nombreIdioma = (Document) sports.get(i);
                    String nomIdio = nombreIdioma.getString("nombre");
                    atributosS.add(nomIdio);
                    sports.remove(sports.get(i));
                    i++;
                }

                for (int i = 0; i < atributosS.size(); i++) {
                    sport = atributosS.get(i) + "," + sport;
                    item[count].setDepor(sport);
                }

                listTotal.add(item[count]);
                count++;
                sport = "";
            }

        }
        return listTotal;
    }

    //Modificar cantidad de producto
    public void updateProductQuantity(String name, int quantity) {

        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://SA:1234@cluster0.izu6r.mongodb.net/test?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");

        try (MongoClient mongoClient = new MongoClient(uri)) {
            MongoDatabase database = mongoClient.getDatabase("BdAvanzadas");
            MongoCollection<Document> collection = database.getCollection("Articulo");
            MongoCursor<Document> cursor = collection.find(and(Document.parse("{\"nombre\": \"" + name + "\"}"))).projection(fields(include("unidadesDisponibles"), excludeId())).iterator();

            BasicDBObject query = new BasicDBObject();
            query.put("nombre", name);
            
            Integer available = cursor.next().getInteger("unidadesDisponibles");
            BasicDBObject newDocument = new BasicDBObject();
            query.put("nombre", name);
            newDocument.put("unidadesDisponibles", available - quantity);

            BasicDBObject updateObject = new BasicDBObject();
            updateObject.put("$set", newDocument);

            collection.updateOne(query, updateObject);
        }
    }

    //CONSULTAS USUARIOS GENERICAS (PARA ENCONTRAR IDIOMAS POR EL NOMBRE)
    //Idiomas que puede enseñar
    //CONSULTAS USUARIOS GENERICAS (PARA ENCONTRAR IDIOMAS POR EL NOMBRE)
    //Idiomas que puede enseñar
    //CONSULTAS USUARIOS GENERICAS (PARA ENCONTRAR IDIOMAS POR EL NOMBRE)
    //Idiomas que puede enseñar
    public List<String> getELanguageNames(String name) {

        List<String> listTotal = new ArrayList<>();

        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://SA:1234@cluster0.izu6r.mongodb.net/test");

        try (MongoClient mongoClient = new MongoClient(uri)) {
            MongoDatabase database = mongoClient.getDatabase("BdAvanzadas");
            MongoCollection<Document> collection = database.getCollection("Usuario");

            MongoCursor cu = collection.find().projection(fields(include("nombre"), include("pais"), include("idiomasE"), excludeId())).cursor();
            MongoCursor<Document> cur = collection.find().projection(fields(include("nombre"), include("pais"), include("idiomasE"), excludeId())).iterator();
            MongoCursor<Document> cursor = collection.find(Document.parse("{\"nombre\": \"" + name + "\"}")).projection(fields(include("nombre"), include("pais"), include("idiomasE"), excludeId())).iterator();

            //FindIterable<Document> iterable = collection.find(Document.parse("{\"nombre\": \"" + name + "\"}"));
            while (cursor.hasNext()) {

                Document temp_person_doc = cursor.next();

                java.util.List lan = (java.util.List) temp_person_doc.get("idiomasE");
                List<String> atributos = new ArrayList<>();

                while (lan.isEmpty() == false) {

                    int i = 0;

                    Document nombreIdioma = (Document) lan.get(i);
                    String nomIdio = nombreIdioma.getString("nombre");

                    lan.remove(lan.get(i));
                    i++;
                    atributos.add(nomIdio);

                }

                for (int i = 0; i < atributos.size(); i++) {
                    listTotal.add(atributos.get(i));
                }

            }

        }
        return listTotal;
    }

    //Idiomas que esta interesado
    //Idiomas que esta interesado
    public List<String> getILanguageNames(String name) {

        List<String> listTotal = new ArrayList<>();

        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://SA:1234@cluster0.izu6r.mongodb.net/test");

        try (MongoClient mongoClient = new MongoClient(uri)) {
            MongoDatabase database = mongoClient.getDatabase("BdAvanzadas");
            MongoCollection<Document> collection = database.getCollection("Usuario");

            MongoCursor cu = collection.find().projection(fields(include("nombre"), include("pais"), include("idiomasI"), excludeId())).cursor();
            MongoCursor<Document> cur = collection.find().projection(fields(include("nombre"), include("pais"), include("idiomasI"), excludeId())).iterator();
            MongoCursor<Document> cursor = collection.find(Document.parse("{\"nombre\": \"" + name + "\"}")).projection(fields(include("nombre"), include("pais"), include("idiomasI"), excludeId())).iterator();

            //FindIterable<Document> iterable = collection.find(Document.parse("{\"nombre\": \"" + name + "\"}"));
            while (cursor.hasNext()) {

                Document temp_person_doc = cursor.next();

                java.util.List lan = (java.util.List) temp_person_doc.get("idiomasI");
                List<String> atributos = new ArrayList<>();

                while (lan.isEmpty() == false) {

                    int i = 0;

                    Document nombreIdioma = (Document) lan.get(i);
                    String nomIdio = nombreIdioma.getString("nombre");

                    lan.remove(lan.get(i));
                    i++;
                    atributos.add(nomIdio);

                }

                for (int i = 0; i < atributos.size(); i++) {
                    listTotal.add(atributos.get(i));
                }

            }

        }
        return listTotal;
    }

    //CONSULTA USUARIO #1
    //Buscar a otros interesados en practicar uno o más de los idiomas que la
    //persona P puede enseñar. 
}
