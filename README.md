# Milestone 1

In Milestone 1, we created a software application that processes an article, removes the stop words, calculates basic statistics, and ranks words by frequencies. We found three different articles for two different news topics, for a total of six articles.

# Milestone 2
 
In Milestone 2, we implemented heuristics that address the following questions: 
1. Which article used the richest vocabulary?
2. What is the list of words that were repeated the most per each article?
3. Which one expressed a "positive attitude" vs a "negative attitude"?

# Milestone 3

In Milestone 3, we added the fileMovement class, allowing the user to create new topics and add their own articles into our program. They can eithe transfer an article from their computer, or type it right into the terminal. We also updated the user interface to be more practical for the user.

## Refactoring

--
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


### FileReaderEJR class
Our FileReaderEJR class manages the user interface and handles the selection of articles and analysis options.

Key Features: 

- Reads articles from Olympics and Election topics.
- Provides options for performing various analyses.
- Allows the user to specify how many top words they want to see or which article they want to analyze for sentiment.

Key Methods: 
- ```run()```: this runs the analytical part of our program. It reads the files and produces user selected data.
- ```analyzeArticles(String folderPath, ArrayList fileNames)```: Takes the gathered arrayList of filepaths, and analyzes each article in the list
- ```checkIfFolderExists(String folderName)```: Checks if the user input for foldername is valid and exists.

  
### fileMovement Class
Our fileMovement class amnages file movement for creating new topcis and adding/creating new articles. 

Key features: Moves and creates files for the user to analyze new articles.

Key Methods
- ```createFolder()```: Creates a folder(new topic) for the user to input new articles
- ```moveFile(String desiredPath)```: Moves a file from the desired filepath into the desired folder
- ```addArticle(String desiredPath)```: Gives the user the option to move an article from their device or to input a text article by hand in the terminal.
- ```createTxtFile(String articlePath, Scanner scanner)```: Allows the user to input an article manually. It records each line in the terminal until the user inputs a line with just "exit"
- ```checkIfFolderExists(String folderName)```: Checks if desired folder exists already, returns a boolean. 








## UML


![image](https://github.com/user-attachments/assets/c44c5bc9-ffc7-48d3-be2e-59d4596f8081)



## Example Run

![image](https://github.com/user-attachments/assets/8585528a-350f-4835-9843-1e1cefd57e70)

![image](https://github.com/user-attachments/assets/76a6f73a-ff7e-425a-8940-5a4923ee7915)







