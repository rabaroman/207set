package com.softserve.edu;


import java.util.ArrayList;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Execute {
    
    public static void main(String args[]){
        String filename = "my.xml";
        List <String> listQuery = new ArrayList<>();
        Repository repository = new Repository();
        listQuery.add(repository.getQuerry1());
        listQuery.add(repository.getQuerry2());
        listQuery.add(repository.getQuerry3());
        listQuery.add(repository.getQuerry4());
        listQuery.add(repository.getQuerry5());
        listQuery.add(repository.getQuerry6());
        listQuery.add(repository.getQuerry7());
        listQuery.add(repository.getQuerry8());
        listQuery.add(repository.getQuerry9());
        listQuery.add(repository.getQuerry10());
        listQuery.add(repository.getQuerry11());
        listQuery.add(repository.getQuerry12());
        listQuery.add(repository.getQuerry13());
        listQuery.add(repository.getQuerry14());
        listQuery.add(repository.getQuerry15());
        listQuery.add(repository.getQuerry16());
        listQuery.add(repository.getQuerry17());
        listQuery.add(repository.getQuerry18());
        listQuery.add(repository.getQuerry19());
        listQuery.add(repository.getQuerry20());
        listQuery.add(repository.getQuerry21());
        listQuery.add(repository.getQuerry22());
        listQuery.add(repository.getQuerry23());
        listQuery.add(repository.getQuerry24());
        listQuery.add(repository.getQuerry25());
        listQuery.add(repository.getQuerry26());
        listQuery.add(repository.getQuerry27());
        listQuery.add(repository.getQuerry28());
        
        Parser parser1 = new Parser();
        for(String list:listQuery){
            try {
                parser1.outputXpathQuery(parser1.parseXmlXpath(filename, list), list);

            } catch (SAXParseException err) {
                System.out.println ("** Parsing error" + ", line " + err.getLineNumber () + ", uri " + err.getSystemId ());
                System.out.println(" " + err.getMessage ());
            } catch (SAXException e) {
                Exception x = e.getException ();
                ((x == null) ? e : x).printStackTrace ();
            } catch (Throwable t) {
                t.printStackTrace ();
            }
            
            
        }
    }

}

