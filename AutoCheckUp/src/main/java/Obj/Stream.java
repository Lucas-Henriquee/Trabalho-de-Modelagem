package Obj;

import java.io.*;

/*
 * Classe utilizada para salvar e carregar objetos de arquivos
 */
public class Stream {

    /**
     * Salva objeto em arquivo.
     * @param obj - objeto a ser salvo.
     * @param path - caminho do salvamento.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void save(Object obj, String path) throws IOException, FileNotFoundException {

            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream stream = new ObjectOutputStream(file);
    
            stream.writeObject(obj);
            stream.close();
    }

    /**
     * Carrega um objeto do arquivo.
     * @param path - caminho do arquivo.
     * @return  obj - Objeto carregado do arquivo.
    */
    public static Object load(String path)
     throws FileNotFoundException, IOException, ClassNotFoundException
     {
        Object obj = null;

        InputStream file = new FileInputStream(path);
        ObjectInputStream stream = new ObjectInputStream(file);

        obj = stream.readObject();
        stream.close();

        return obj;
    }
}
