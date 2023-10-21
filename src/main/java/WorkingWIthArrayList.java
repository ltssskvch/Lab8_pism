import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkingWIthArrayList {
    private ArrayList<String> arrayList;

    public WorkingWIthArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public WorkingWIthArrayList(String filePath){
        initializeListFromTextFile(filePath);
    }

    public ArrayList getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public void addElement(String string){
        arrayList.add(string);
    }

    public void deleteElement(int position){
        if (position>=0 && position<arrayList.size()){
            arrayList.remove(position);
        }
    }

    public void deleteElement(String string){
        arrayList.remove(string);
    }

    public void saveArrayListToXML(String xmlFilePath) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(ArrayList.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.marshal(arrayList, new File(xmlFilePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void reverseAllStrings() {
        for (int i = 0; i < arrayList.size(); i++) {
            String original = arrayList.get(i);
            String reversed = new StringBuilder(original).reverse().toString();
            arrayList.set(i, reversed);
        }
    }

    public Map<Character, Integer> getCharacterStatistics() {
        Map<Character, Integer> statistics = new HashMap<>();

        for (String str : arrayList) {
            for (char c : str.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    statistics.put(c, statistics.getOrDefault(c, 0) + 1);
                }
            }
        }

        return statistics;
    }

    public ArrayList<String> findSubstring(String substring) {
        ArrayList<String> result = new ArrayList<>();

        for (String str : arrayList) {
            if (str.contains(substring)) {
                result.add(str);
            }
        }

        return result;
    }

    public void initializeListFromTextFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                arrayList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, List<String>> countAndSortStringLengths() {
        Map<Integer, List<String>> lengthToStringsMap = new HashMap<>();

        for (String str : arrayList) {
            int length = str.length();
            lengthToStringsMap
                    .computeIfAbsent(length, k -> new ArrayList<>())
                    .add(str);
        }

        List<Integer> sortedLengths = lengthToStringsMap.keySet().stream()
                .sorted()
                .collect(Collectors.toList());

        Map<Integer, List<String>> sortedMap = new HashMap<>();
        for (int length : sortedLengths) {
            sortedMap.put(length, lengthToStringsMap.get(length));
        }

        return sortedMap;
    }


}
