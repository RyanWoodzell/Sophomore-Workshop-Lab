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

### Main:
We can refactor this code by incorporating a new method that prints the user options and a new method that will ask for user input. Rather than printing multiple options every time the while loop re-runs, we can instead put the user options in a method and just call the method. This will make the code within the while loop easier to read and more concise. Additionally, we can apply a similar change for the scanner class where we gather the user input whenever a method is called. This will also make the code easier to read and more concise.

### fileMovement:
One way to refactor this class is by modifying the addArticle. One change we can make to this method is to separate it into two methods including addArticle and moveArticle. This would decrease coupling making it easier for us to update our program in the future. Currently, the addArticle method is used for both, which can be confusing when reading/debugging our code. A different way to change the method is by removing duplicate code. Currently, we utilize the checkIfFolderExists method multiple times within the addArticle method. Instead, we can reorder the code to move the checkIfFolderExists method before the if/else if statements so we only have to call it once.

### basicStatistics:
One way to refactor this class is by updating the methods that used for loops. Instead of using for loops, we can incorporate streams which is a cleaner and easier-to-maintain alternative to for loops. An additional change we can make to this class is modifying the if/else if block used to determine the sentiment of the article. This code is very redundant so rather than printing "Sentiment analysis. The article is mostly SENTIMENT. ", we can instead make a singular method to analyze and print the sentiment for us. 

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
- Prompts the user to choose between analyzing articles, creating a new topic, adding an article, or exiting the program. 


### readFile Class
Our readFile class uses several methods to read the text file and clean its content by removing punctuation and stop words. This prepares our text for further analysis.

Key Features: Reads a txt file and converts it into String or ArrayList.

Key Methods: 
- ```readAndClean(String filePath)```: Reads the file at the specified path, cleans the text, and removes stop words. Returns the cleaned content as an ```ArrayList<String>```.    
- ```getStopWordsFromFile()```: Reads stop words from a predefined file ```(stopwords.txt)``` and stores them in an ```ArrayList<String>```.  
- ```removeStopWords()```: Filters the cleaned content by removing any words found in the stop words list.  
- ```getTxt(String filePath)```: Reads the full content of a file into a string.

### basicStatistics Class
Our basicStatistics Class analyzes the words from the articles and provides statistics on the word frequency and unique word count.

Key Features: Gathers various basic statistics on each selected txt file. 

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







