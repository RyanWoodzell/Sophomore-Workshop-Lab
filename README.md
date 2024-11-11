# Milestone 2

In Milestone 1, we created a software application that processes an article, removes the stop words, calculates basic statistics, and ranks words by frequencies. We found three different articles for two different news topics, for a total of six articles. In Milestone 2, we implemented heuristics that address the following questions: 
1. Which article used the richest vocabulary?
2. What is the list of words that were repeated the most per each article?
3. Which one expressed a "positive attitude" vs a "negative attitude"?

## Group Members

Erin Goodling, Ryan Woodzell, and Jack Callanan: Computer Science majors at Fairfield University

## Installation

**Stanford CoreNLP:** We used Stanford CoreNLP for our sentiment analysis. To run the sentiment analysis, you need to download the Stanford CoreNLP library. 
- [Download Stanford CoreNLP](https://stanfordnlp.github.io/CoreNLP/)

## Classes

### Main Class 
Our Main class is the entry point for our program. It initializes the user interface and prompts the user to select which articles to analyze and what type of analysis to run. 

Key Features: 
- Prompts the user to chose between articles on the Olympics or Presidential Election.
- Provides options for performing an analysis, such as richest vocabulary, top word frequency ranking, or sentiment analysis.


### readFile Class
Our readFile class uses several methods to read the text file and clean its content by removing punctuation and stop words. This prepares our text for further analysis.

Key Methods: 
- ```readAndClean(String filePath)```: Reads the file at the specified path, cleans the text, and removes stop words. Returns the cleaned content as an ```ArrayList<String>```.    
- ```getStopWordsFromFile()```: Reads stop words from a predefined file ```(stopwords.txt)``` and stores them in an ```ArrayList<String>```.  
- ```removeStopWords()```: Filters the cleaned content by removing any words found in the stop words list.  
- ```getTxt(String filePath)```: Reads the full content of a file into a string.

### basicStatistics Class
Our basicStatistics Class analyzes the words from the articles and provides statistics on the word frequency and unique word count.

Key Methods: 
- ```basicStatistics(ArrayList<String> withStopWords, ArrayList<String> withoutStopWords)```: Constructor that initializes the object with two lists: one containing all words (including stop words) and the other containing only the cleaned words.  

- ```readStatistics()```: Prints basic statistics, including the total word count before and after removing stop words, the count of unique words, and the frequency ranking of words.  

- ```uniqueWords(ArrayList<String> words)```: Calculates and sets the number of unique words in the cleaned list by converting it to a set.  

- ```listToArray(ArrayList<String> words)```: Converts an ```ArrayList<String>``` to a ```String[] array```.  

- ```countStringOccurrences(String[] arr)```: Counts occurrences of each word in the provided string array, storing the results in a map and sorting the words by frequency.

- ```top words(int x)```: Displays the ```x``` most frequent words

- ```sentimentAnalysis(String text)```: Analyzes the sentiment of the text ranging from positive, neutral, or negative using Stanford CoreNLP.


## FileReaderEJR class
Our FileReaderEJR class manages the user interface and handles the selection of articles and analysis options.

Key Features: 

- Reads articles from Olympics and Election topics.
- Provides options for performing various analyses.
- Allows the user to specify how many top words they want to see or which article they want to analyze for sentiment.

Key Methods: 

- ```run```: The main method that initiates the user interface, reads the articles, and performs analysis based on user input.



## UML


![Screenshot 2024-11-06 200826](https://github.com/user-attachments/assets/7cfef989-f80b-4ee5-b779-26a680c4e6fa)



