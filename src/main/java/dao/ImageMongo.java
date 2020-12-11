/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.*;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSFile;
import com.mongodb.gridfs.GridFSInputFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author samoy
 */
public class ImageMongo {

    //METODO PARA INSERTAR
    public ObjectId upload(String filePath, String fileName) {

        ObjectId fileId = null;
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://SA:1234@cluster0.izu6r.mongodb.net/test?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");

        try (MongoClient mongoClient = new MongoClient(uri)) {
            MongoDatabase database = mongoClient.getDatabase("BdAvanzadas");
            MongoCollection<Document> collection = database.getCollection("Articulo");

// Create a gridFSBucket
            //GridFSBucket gridBucket = GridFSBuckets.create(database);
            GridFSBucket gridBucket = GridFSBuckets.create(database);
            //gridBucket.

            InputStream inStream = new FileInputStream(new File(filePath));

// Create some customize options for the details that describes
// the uploaded image
            GridFSUploadOptions uploadOptions = new GridFSUploadOptions().chunkSizeBytes(1024).metadata(new Document("type", "image").append("content_type", "image/png"));

            fileId = gridBucket.uploadFromStream(fileName, inStream, uploadOptions);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileId;
    }

    //METODO PARA BUSCAR (NO SE USA)
    public void find(String name) {
        System.out.println("Calling find...");
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://SA:1234@cluster0.izu6r.mongodb.net/test?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000"));

        try {
            MongoDatabase database = mongoClient.getDatabase("BdAvanzadas");
            GridFSBucket gridBucket = GridFSBuckets.create(database);

            com.mongodb.client.gridfs.model.GridFSFile gridFSFile = gridBucket.find(eq("filename", name)).first();
            System.out.println("File Name:- " + gridFSFile.getFilename());
            System.out.println("Meta Data:- " + gridFSFile.getMetadata());
            //System.out.println("Meta Data:- " + gridFSFile.);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mongoClient.close();
        }
    }

    //METODO PARA DESCARGAR
    public void download(String fileName) {
        System.out.println("Calling download...");
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://SA:1234@cluster0.izu6r.mongodb.net/test?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000"));

        try {
            MongoDatabase database = mongoClient.getDatabase("BdAvanzadas");
            GridFSBucket gridBucket = GridFSBuckets.create(database);

            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\samoy\\Desktop\\TEC\\Semestre VI\\Bases Avanzadas\\Proyecto#3\\" + fileName + ".jpg");
            gridBucket.downloadToStream(fileName, fileOutputStream);
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mongoClient.close();
        }
    }

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) throws IOException {

        ObjectId lol = new ObjectId();

        ImageMongo lol2 = new ImageMongo();
        //lol2.upload("C:\\Users\\samoy\\Desktop\\TEC\\cr7.png", "loll");

        //lol2.find("cr7");
        //ObjectId some_name = upload();
        lol2.download("cr7");
    }
    */
}
