package org.example;

import org.example.model.StringAttribute;
import org.example.service.ReaderService;
import org.example.service.WriterService;
import org.example.service.processor.QueryProcessor;

import static org.example.constant.FileConstant.*;

public class Main {

    private static final WriterService WRITER_SERVICE = new WriterService(OUTPUT_DESTINATION);
    private static final ReaderService READER_SERVICE = new ReaderService(INPUT_DESTINATION);
    private static final QueryProcessor QUERY_PROCESSOR = QueryProcessor.getInstance();

    public static void main(String[] args) {
        while (READER_SERVICE.ready()) {
            String line = READER_SERVICE.read();
            if (line.length() != 0) {
                QUERY_PROCESSOR.processLength(line);
            }

            if (READER_SERVICE.ready()) {
                String inputLine = READER_SERVICE.read();
                if (inputLine.length() != 0) {
                    QUERY_PROCESSOR.processString(inputLine);
                }
            }

            if (READER_SERVICE.ready()) {
                String queriesLine = READER_SERVICE.read();
                if (queriesLine.length() != 0) {
                    QUERY_PROCESSOR.processQueries(queriesLine);
                }
            }
        }

        QUERY_PROCESSOR.process(WRITER_SERVICE);

        WRITER_SERVICE.close();
        READER_SERVICE.close();
    }
}