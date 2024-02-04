package org.example.service.processor;

import org.example.model.StringAttribute;
import org.example.service.WriterService;
import org.example.service.operations.StringQueryOperations;

public class QueryProcessor {

    private static final StringQueryOperations STRING_QUERY_OPERATIONS = StringQueryOperations.getInstance();
    private static final StringAttribute attr = new StringAttribute();
    private static QueryProcessor instance;

    public void processLength(String line) {
        String[] parts = line.split(" ");
        attr.setLength(Integer.parseInt(parts[0]));
        attr.setNumberOfQueries(Integer.parseInt(parts[1]));

        System.out.println(attr.getLength());
        System.out.println(attr.getNumberOfQueries());
    }

    public void processString(String line) {
        attr.setInputString(line);
        System.out.println(attr.getInputString());
    }

    public void processQueries(String line) {
        String[] parts = line.split(" ");
        attr.setL(Integer.parseInt(parts[0]));
        attr.setR(Integer.parseInt(parts[1]));
        attr.setK(Integer.parseInt(parts[2]));
    }

    public void process(WriterService writerService) {
        // Передача объекта attr в метод для корректной обработки каждого запроса
        String result = String.valueOf(STRING_QUERY_OPERATIONS.countChar(attr));
        writerService.write(result);
    }


    public static QueryProcessor getInstance() {
        if (instance == null) {
            instance = new QueryProcessor();
        }
        return instance;
    }
}
