# Milestone 1

For Milestone 1, we had to create a software application that processes an article, removes the stop words, calculates basic statistics, and ranks words by frequencies. We had to find three different articles for two different news topics, for a total of six articles.

## Group Members

Erin Goodling, Ryan Woodzell, and Jack Callanan: Computer Science majors at Fairfield University

## Classes

### Main Class 
In our Main class, we called our ```readFile``` class and ```basicStatistics``` class. These two classes allow our Main class to read the file, remove stop words, calculate basic statistics, and rank words by frequency.

### readFile Class
Our readFile class uses several methods to read the text file and clean its content by removing punctuation and stop words.

#### readFile methods

```readAndClean(String filePath)```: Reads the file at the specified path, cleans the text, and removes stop words. Returns the cleaned content as an ```ArrayList<String>```.  

```readInstanceFile(String filePath)```: Reads the content of the file, cleans it by removing non-alphanumeric characters, and stores the words in an ```ArrayList<String>```.  

```getStopWordsFromFile()```: Reads stop words from a predefined file ```(stopwords.txt)``` and stores them in an ```ArrayList<String>```.  

```removeStopWords()```: Filters the cleaned content by removing any words found in the stop words list.  

```getStopWords()```: Returns the list of stop words.  

```getFile()```: Returns the original content of the file as an ```ArrayList<String>```.  

```getCleanedFile()```: Returns the cleaned content as an ```ArrayList<String>```. 

### basicStatistics Class
Our basicStatistics Class analyzes the words from the articles and provides statistics on the word frequency and unique word count.

#### basicStatistics methods
```basicStatistics(ArrayList<String> withStopWords, ArrayList<String> withoutStopWords)```: Constructor that initializes the object with two lists: one containing all words (including stop words) and the other containing only the cleaned words.  

```readStatistics()```: Prints basic statistics, including the total word count before and after removing stop words, the count of unique words, and the frequency ranking of words.  

```uniqueWords(ArrayList<String> words)```: Calculates and sets the number of unique words in the cleaned list by converting it to a set.  

```listToArray(ArrayList<String> words)```: Converts an ```ArrayList<String>``` to a ```String[] array```.  

```countStringOccurrences(String[] arr)```: Counts occurrences of each word in the provided string array, storing the results in a map and sorting the words by frequency.  

## UML



