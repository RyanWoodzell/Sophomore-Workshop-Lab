package fileReader.src;
import java.util.*;

public class basicStatistics {
    ArrayList<String> withStopWords;
    ArrayList<String> withoutStopWords;
    int uniquewords;
    String[] cleanedArray;
    int[] cleanedArrayIndex;
    Map<String, Integer> stringCountMap = new HashMap<>();

    //Constructor for statistics reader

    public basicStatistics(ArrayList<String> withStopWords, ArrayList<String> withoutStopWords) {

        this.withStopWords = withStopWords;
        this.withoutStopWords = withoutStopWords;

        countStringOccurrences(listToArray(withoutStopWords));
        /*for (Map.Entry<String, Integer> entry : stringCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/
    }

    //Print out the basicStatistics of the file

    public void readStatistics() {
        System.out.println("The number of words in the article before removing stopwords is " + withStopWords.size());
        System.out.println("The number of words in the article after removing stopwords is " + withoutStopWords.size());
        uniqueWords(withoutStopWords);
        System.out.println("The number of unique words in the article is " + uniquewords);
    }

    //Count the unique words of file

    public void uniqueWords(ArrayList<String> words){
        Object[] object = words.toArray();
        for (int i = 0; i < object.length; i++) {
            object[i] = object[i].toString().toLowerCase();
        }
        Set result = new HashSet(Arrays.asList(object));
        uniquewords = result.size();
    }

    //Count how many words repeat.
    //Takes in array of words and length of array
    //need to debug countFreq
    public  void countFreq(String[] arr, int n) {
        boolean[] visited = new boolean[n];
        int[] Freq = new int[n];

        Arrays.fill(visited, false);

        // Traverse through array elements and
        // count frequencies

        for (int i = 0; i < n; i++) {

            // Skip this element if already processed

            if (visited[i])
                continue;

            // Count frequency

            int count = 1;

            for (int j = 0; j < n; j++) {
                if (arr[i].equalsIgnoreCase(arr[j])){
                    visited[j] = true;
                    count++;
                }

                //Add count to indexArray, which records how many instances of a certain string
                Freq[j] = count;
            }

        }


        //create cleanedArray

        this.cleanedArray = arr;
        this.cleanedArrayIndex = Freq;

        //Sort the arrays by frequency they occur in article.
        bubbleSort(cleanedArray.length);
    }

    //Convert the arrayList to a string array for the frequency counter

    public String[] listToArray(ArrayList<String> words){
        String[] str = new String[words.size()];

        for (int i = 0; i < words.size(); i++) {
            str[i] = words.get(i);
        }
        return(str);

    }

    //bubble sort the arrays in countFreq

    public void bubbleSort(int n) {
        int i, j, temp;
        String temp2;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (cleanedArrayIndex[j] > cleanedArrayIndex[j + 1]) {

                    // Swap cleanedArrayIndex[j] and cleanedArrayIndex[j+1]

                    temp = cleanedArrayIndex[j];
                    cleanedArrayIndex[j] = cleanedArrayIndex[j + 1];
                    cleanedArrayIndex[j + 1] = temp;
                    swapped = true;

                    //Swap cleanedArray[j] and cleanedArray[j+1

                    temp2 = cleanedArray[j];
                    cleanedArray[j] = cleanedArray[j + 1];
                    cleanedArray[j + 1] = temp2;

                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
   /* public void frequencyCounters(String[] arr){
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(String str: arr){
            Integer count = map.get(str);
            if(count==null){
                map.put(str,1);
            }else{
                map.put(str,++count);
            }
        }
        Set<String> keySet = map.keySet();
        for(String key: keySet){
            System.out.println(STR."\{key}:\{map.get(key)}");
        }
    }*/
   public void  countStringOccurrences(String[] arr) {
       // HashMap to store the string as key and its occurrence count as value
       //Map<String, Integer> stringCountMap = new HashMap<>();

       // Loop through the array
       for (String str : arr) {
           // If the string is already in the map, increment its count
           if (stringCountMap.containsKey(str)) {
               stringCountMap.put(str, stringCountMap.get(str) + 1);
           } else {
               // Otherwise, add it to the map with an initial count of 1
               stringCountMap.put(str, 1);
           }
       }

   }
}
