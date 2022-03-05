/*
* File Name: Main.java
* Author: Aseef Ali Hasan
* Date: August 8, 2021
* Description:
* This is a program is a multiple choice quiz
* It features multiplication questions
* The user must find the product of each equation for 10 questions
* Displays quiz through a GUI
* Displays number of correct, incorrect, percent correct and feedback
*/

//Import classes used for the GUI
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.Random;
import java.awt.event.ActionEvent;

class Main {
  //Class variables
  //All the elements needed to build GUI 
  static JFrame frmMain;

  static JLabel lblTitle;

  static JLabel lblQuestion;
  static JLabel lblAnswer;
  static JLabel lblCorrect;
  static JLabel lblIncorrect;
  static JLabel lblPercentage;
  static JLabel lblFeedback;

  static JTextField txtAnswer;

  static JTextArea txtQuestion;
  static JTextArea txtCorrect;
  static JTextArea txtIncorrect;
  static JTextArea txtPercentage;
  static JTextArea txtFeedback;

  static JButton btnSubmit;

  //frame dimensions 
  static final int FRAME_X = 10;
  static final int FRAME_Y = 10;
  static final int FRAME_WIDTH = 500;
  static final int FRAME_HEIGHT = 500;

  //title dimensions 
  static final int TITLE_X = 175;
  static final int TITLE_Y = 0;
  static final int TITLE_WIDTH = 300;
  static final int TITLE_HEIGHT = 20;
  
  //answer label dimensions
  static final int ANSWER_X = 20;
  static final int ANSWER_Y = 230;
  static final int ANSWER_WIDTH = 150;
  static final int ANSWER_HEIGHT = 30;

  //answer text field dimensions
  static final int ANSWER_TEXT_X = 100;
  static final int ANSWER_TEXT_Y = 230;
  static final int ANSWER_TEXT_WIDTH = 130;
  static final int ANSWER_TEXT_HEIGHT = 30; 

  //question label dimensions
  static final int QUESTION_X = 20;
  static final int QUESTION_Y = 20;
  static final int QUESTION_WIDTH = 150;
  static final int QUESTION_HEIGHT = 30; 

  //question text field dimensions 
  static final int QUESTION_TEXT_X = 100;
  static final int QUESTION_TEXT_Y = 20;
  static final int QUESTION_TEXT_WIDTH = 300;
  static final int QUESTION_TEXT_HEIGHT = 200;
  
  //correct answer amount label dimensions 
  static final int CORRECT_X = 20;
  static final int CORRECT_Y = 270;
  static final int CORRECT_WIDTH = 150;
  static final int CORRECT_HEIGHT = 45;

  //correct answer amount text area dimensions 
  static final int CORRECT_TEXT_X = 200;
  static final int CORRECT_TEXT_Y = 270;
  static final int CORRECT_TEXT_WIDTH = 100;
  static final int CORRECT_TEXT_HEIGHT = 30;
  
  //incorrect answer amount label dimensions
  static final int INCORRECT_X = 20;
  static final int INCORRECT_Y = 320;
  static final int INCORRECT_WIDTH = 150;
  static final int INCORRECT_HEIGHT = 45;

  //incorrect answer amount text area dimensions 
  static final int INCORRECT_TEXT_X = 200;
  static final int INCORRECT_TEXT_Y = 320;
  static final int INCORRECT_TEXT_WIDTH = 100;
  static final int INCORRECT_TEXT_HEIGHT = 30;

  //percent correct label dimensions 
  static final int PERCENT_X = 20;
  static final int PERCENT_Y = 370;
  static final int PERCENT_WIDTH = 150;
  static final int PERCENT_HEIGHT = 30;
  
  //percent incorrect text area dimensions 
  static final int PERCENT_TEXT_X = 200;
  static final int PERCENT_TEXT_Y = 370;
  static final int PERCENT_TEXT_WIDTH = 100;
  static final int PERCENT_TEXT_HEIGHT = 30;

  //feedback label dimensions 
  static final int FEEDBACK_X = 20;
  static final int FEEDBACK_Y = 420;
  static final int FEEDBACK_WIDTH = 150;
  static final int FEEDBACK_HEIGHT = 30;
  
  //feedback text area dimensions 
  static final int FEEDBACK_TEXT_X = 200;
  static final int FEEDBACK_TEXT_Y = 420;
  static final int FEEDBACK_TEXT_WIDTH = 110;
  static final int FEEDBACK_TEXT_HEIGHT = 30;

  //submit button dimensions 
  static final int SUBMIT_X = 300;
  static final int SUBMIT_Y = 230;
  static final int SUBMIT_WIDTH = 130;
  static final int SUBMIT_HEIGHT = 30;

  //to store user's choice
  static String userChoice;
  //to store correct answers
  static String correctChoice;
  //to store random numbers
  //to store correct solution to question
  static double numA, numB, correctSol;
  //to store three incorrect options
  static double incorrectOne, incorrectTwo, incorrectThree;
  //for program to determine if answer is true or false
  static boolean correctAnswer;
  //to store amount of correct answers
  static int correctAnswers;
  //to store amount of incorrect answers
  static int incorrectAnswers;
  //to store amount percentage of correct answers
  static double percCorrect;
  
  //to store question text
  static String questionText;
  //to store string value of correct answers
  static String correctNum;
  //to store string value of incorrect answers
  static String incorrectNum;
  //to store string value of percentage of correct answers
  static String percentage;
  //to store feedback written to user
  static String feedback;
  
  //to store amount of questions done every time
  //a new question is given
  static int maxQuestions;
  
  static Random generator; //to generate coefficients
  
  //limit for random numbers generated for 
  //easy questions
  static final int UPPER_LIMIT = 10;
  //limit for random numbers generated for 
  //hard questions 
  static final int RANDOM_LIMIT = 100;
  //message for user when quiz is complete
  static final String QUIZ_END = "The quiz is complete.";

  public static void main(String[] args) {
    //Part one
    /*
    * Initialize all GUI elements and place them in the form
    */
    //setting up the main frame
    frmMain = new JFrame("Multiple Choice Quiz");
    frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmMain.setVisible(true);
    frmMain.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
    //allows for specific element locations
    frmMain.setLayout(null);

    //Setting title position and adding it to the frame
    lblTitle = new JLabel("Aseef's Multiplication Quiz");
    lblTitle.setBounds(TITLE_X, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT);
    frmMain.add(lblTitle);

    //add answer label and text field
    lblAnswer = new JLabel("Answer:");
    lblAnswer.setBounds(ANSWER_X, ANSWER_Y, ANSWER_WIDTH, ANSWER_HEIGHT);
    frmMain.add(lblAnswer);
    txtAnswer = new JTextField();
    txtAnswer.setBounds(ANSWER_TEXT_X, ANSWER_TEXT_Y, ANSWER_TEXT_WIDTH, ANSWER_TEXT_HEIGHT);
    frmMain.add(txtAnswer);

    //add number of correct answers label
    //add text field
    lblCorrect = new JLabel("<html>Number of questions answered correctly:");
    lblCorrect.setBounds(CORRECT_X, CORRECT_Y, CORRECT_WIDTH, CORRECT_HEIGHT);
    frmMain.add(lblCorrect);
    txtCorrect = new JTextArea(correctNum);
    txtCorrect.setBounds(CORRECT_TEXT_X, CORRECT_TEXT_Y, CORRECT_TEXT_WIDTH, CORRECT_TEXT_HEIGHT);
    txtCorrect.setEditable(false); 
    frmMain.add(txtCorrect);

    //add number of incorrect answers label
    //and text field
    lblIncorrect = new JLabel("<html>Number of questions answered incorrectly:");
    lblIncorrect.setBounds(INCORRECT_X, INCORRECT_Y, INCORRECT_WIDTH, INCORRECT_HEIGHT);
    frmMain.add(lblIncorrect);
    txtIncorrect = new JTextArea(incorrectNum);
    txtIncorrect.setBounds(INCORRECT_TEXT_X, INCORRECT_TEXT_Y, INCORRECT_TEXT_WIDTH, INCORRECT_TEXT_HEIGHT);
    txtIncorrect.setEditable(false); 
    frmMain.add(txtIncorrect);

    //add percent of correct answers label
    //and text field
    lblPercentage = new JLabel("<html>Percentage of correct answers:");
    lblPercentage.setBounds(PERCENT_X, PERCENT_Y, PERCENT_WIDTH, PERCENT_HEIGHT);
    frmMain.add(lblPercentage);
    txtPercentage = new JTextArea(percentage);
    txtPercentage.setBounds(PERCENT_TEXT_X, PERCENT_TEXT_Y, PERCENT_TEXT_WIDTH, PERCENT_TEXT_HEIGHT);
    txtPercentage.setEditable(false);
    frmMain.add(txtPercentage);
    
    //add feedback label and text field
    lblFeedback = new JLabel("Feedback:");
    lblFeedback.setBounds(FEEDBACK_X, FEEDBACK_Y, FEEDBACK_WIDTH, FEEDBACK_HEIGHT);
    frmMain.add(lblFeedback);
    txtFeedback = new JTextArea();
    txtFeedback.setBounds(FEEDBACK_TEXT_X, FEEDBACK_TEXT_Y, FEEDBACK_TEXT_WIDTH, FEEDBACK_TEXT_HEIGHT);
    txtFeedback.setEditable(false);
    frmMain.add(txtFeedback);
    
    //add submit button
    btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(SUBMIT_X, SUBMIT_Y, SUBMIT_WIDTH, SUBMIT_HEIGHT);
    frmMain.add(btnSubmit);
    
    //initializing counters and other variables 
    maxQuestions = 0;
    correctAnswers = 0;
    incorrectAnswers = 0;
    generator = new Random();
    
    //generate random numbers to multiply 
    numA = generator.nextInt(UPPER_LIMIT);
    numB = generator.nextInt(UPPER_LIMIT); 
    
    //generate correct answer and round to one decimal
    correctSol = (numA * numB);
    correctSol = correctSol * 100;
    correctSol = Math.round(correctSol);
    correctSol = correctSol / 100;
    
    //generate some sort of random incorrect choices for the MC question
    incorrectOne = -correctSol;
    incorrectTwo = correctSol + 1;
    incorrectThree = correctSol - 1;
    
    //prepare the question text
    // \n is used for going to next line
    questionText = "What is the solution of the following equation:"
            + "\n" + numA + " * " + numB + " = ?"
            + "\nFind the product"
            + "\nEnter one of the choices (A, B, C, D)"
            + "\nA:  " + incorrectOne + "\nB:  " + correctSol
            + "\nC:  " + incorrectTwo + "\nD:  " + incorrectThree;
    correctChoice = "B"; //assign the proper letter to correct choice
    
    //add question label and text area
    lblQuestion = new JLabel("Question:");
    lblQuestion.setBounds(QUESTION_X, QUESTION_Y, QUESTION_WIDTH, QUESTION_HEIGHT);
    frmMain.add(lblQuestion);
    txtQuestion = new JTextArea(questionText);
    txtQuestion.setBounds(QUESTION_TEXT_X, QUESTION_TEXT_Y, QUESTION_TEXT_WIDTH, QUESTION_TEXT_HEIGHT);
    frmMain.add(txtQuestion);
    
    //add submit button action element
    btnSubmit.addActionListener((ActionEvent e) -> {
      //add one question completed to the counter
    	maxQuestions = maxQuestions + 1;
      //check the answer
    	userChoice = txtAnswer.getText();
    	correctAnswer = userChoice.toUpperCase().equals(correctChoice);
    	if (correctAnswer) 
    	{
    		//generate more difficult question
        //generates larger random number
    		numA = generator.nextInt(RANDOM_LIMIT);
    		numB = generator.nextInt(UPPER_LIMIT);
          //generate correct answer to one decimal place
    	    correctSol = (numA * numB);
    	    correctSol = correctSol * 100;
    	    correctSol = Math.round(correctSol);
    	    correctSol = correctSol / 100;
          //generate some sort of random incorrect 
          //choices for the MC question
          //generates two large randon incorrect choices
    	    incorrectOne = correctSol + 1;
    	    incorrectTwo = generator.nextInt(RANDOM_LIMIT);
    	    incorrectThree = generator.nextInt(RANDOM_LIMIT);

            //prepare the question text 
            // \n is used for going to next line
            questionText = "What is the solution of the following equation:"
                    + "\n" + numA + " * " + numB + " = ?"
                    + "\nFind the product"
                    + "\nEnter one of the choices (A, B, C, D)"
                    + "\nA:  " + incorrectOne + "\nB:  " + incorrectTwo
                    + "\nC:  " + correctSol + "\nD:  " + incorrectThree;
            correctChoice = "C"; //assign the proper letter to correct choice
            
            //adds one one correct answer counter
            correctAnswers++;
            
            //gives feedback to user
            feedback = "Answer was " + correctAnswer;
            
            //calculates percentage of correct answers
            //to one decimal place
            percCorrect = ((double)correctAnswers/(double)maxQuestions) * 100;
            percCorrect = percCorrect * 100;
            percCorrect = Math.round(percCorrect);
            percCorrect = percCorrect / 100;
            
            //sets the text areas to appropriate values
            //converts integers to strings
            txtQuestion.setText(questionText);
            txtCorrect.setText(String.valueOf(correctAnswers));
            txtFeedback.setText(String.valueOf(feedback));
            txtPercentage.setText(String.valueOf(percCorrect) + "%");
    	}
    	else 
    	{   
          //generate same difficulty question
    	    numA = generator.nextInt(UPPER_LIMIT);
    	    numB = generator.nextInt(UPPER_LIMIT);
          //generate correct answer to one decimal place
    	    correctSol = (numA * numB);
    	    correctSol = correctSol * 100;
    	    correctSol = Math.round(correctSol);
    	    correctSol = correctSol / 100;
          //generate some sort of random incorrect 
          //choices for the MC question
          //through predefined changes 
    	    incorrectOne = -correctSol;
    	    incorrectTwo = correctSol + 1;
    	    incorrectThree = correctSol - 1;

            //prepare question text
            // \n is used for going to next line
            questionText = "What is the solution of the following equation:"
                    + "\n" + numA + " * " + numB + " = ?"
                    + "\nFind the product"
                    + "\nEnter one of the choices (A, B, C, D)"
                    + "\nA:  " + correctSol + "\nB:  " + incorrectOne
                    + "\nC:  " + incorrectTwo + "\nD:  " + incorrectThree;
            correctChoice = "A"; //assign the proper letter to correct choice
            
            //add one to incorrect answer counter
            incorrectAnswers++;
            
            //give feedback to user
            feedback = "Answer was " + correctAnswer;
            
            //calculates percentage of correct answers
            //to one decimal place
            percCorrect = ((double)correctAnswers/(double)maxQuestions) * 100;
            percCorrect = percCorrect * 100;
            percCorrect = Math.round(percCorrect);
            percCorrect = percCorrect / 100;
            
            //sets the text areas to appropriate values
            //converts integers to strings
            txtIncorrect.setText(questionText);
            txtIncorrect.setText(String.valueOf(incorrectAnswers));
            txtFeedback.setText(String.valueOf(feedback));
            txtPercentage.setText(String.valueOf(percCorrect) + "%");
        }//END OF IF ELSE BLOCK

        //checks if 10 questions are completed
        if (correctAnswers + incorrectAnswers >= 10)
        {
          //QUIZ IS COMPLETE
          //gives final feedback to user
        	txtQuestion.setText(QUIZ_END + "\nYour mark is " + String.valueOf(percCorrect) + "%." +
            "\nYou got " + String.valueOf(correctAnswers) + " questions correct." + "\nYou got " 
            + String.valueOf(incorrectAnswers) + " questions incorrect.");
        	txtAnswer.setText("");
        	txtCorrect.setText("");
        	txtIncorrect.setText("");
        	txtPercentage.setText("");
        }
        else
        {
          //reset elements in the form
          //change the question
        	txtQuestion.setText(questionText);
        	txtAnswer.setText("");
        }
     }); //end of action listener for the button 
  } //end of main method
} //end of class method 