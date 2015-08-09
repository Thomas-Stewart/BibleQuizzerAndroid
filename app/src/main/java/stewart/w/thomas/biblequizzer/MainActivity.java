package stewart.w.thomas.biblequizzer;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;


public class MainActivity extends Activity {

    public final static String TAG = MainActivity.class.getSimpleName();
    private String verseText = "";
    int score = 0;

    String answer = "w";
    Button choiceAButton;
    Button choiceBButton;
    Button choiceCButton;
    Button choiceDButton;
    TextView verseView;
    TextView messageView;
    TextView scoreView;

    Random rand = new Random();
    String titleAnswer,badTitle1,badTitle2,badTitle3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        choiceAButton = (Button) findViewById(R.id.choiceButtonA);
        choiceBButton = (Button) findViewById(R.id.choiceButtonB);
        choiceCButton = (Button) findViewById(R.id.choiceButtonC);
        choiceDButton = (Button) findViewById(R.id.choiceButtonD);
        verseView = (TextView) findViewById(R.id.verseView);
        messageView = (TextView) findViewById(R.id.messageView);
        scoreView = (TextView) findViewById(R.id.scoreView);

            //URLReader bibleBook = new URLReader(titleAnswer,1);
            try{
                getBibleData();
            } catch (Exception e){
                Log.e(TAG,"VERSE TEXT IS EMPTY",e);
            }
            if(verseText == ""){
                System.out.println("VERSE TEXT IS EMPTY");
            }
//            int temp = bibleBook.verses.size() - 1 +1;
//            int randVerse;
//            if (temp == 0)
//                randVerse = 1;
//            else
//                randVerse= rand.nextInt(temp)+1;

//                System.out.println("***************************************");
//                System.out.println("Where does the following verse belong?");
//                System.out.println("");
//                System.out.println("\""+bibleBook.verses.get(randVerse)+"\"");
            messageView.setText("***************************************\n" +
                    "Where does the following verse belong?\n\n" +
                    "***************************************");
//            verseView.setText("\""+bibleBook.verses.get(randVerse)+"\"");

    }

    private void startTrivia(final int randChoice) {

        //System.out.println("***************************************");

        choiceAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = "A";
                checkAnswer(randChoice);
            }
        });
        choiceBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = "B";
                checkAnswer(randChoice);
            }
        });
        choiceCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = "C";
                checkAnswer(randChoice);
            }
        });
        choiceDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = "D";
                checkAnswer(randChoice);

            }
        });




//            bibleBook.verses.clear();
//            bibleBook.Book = "";

    }

    private void checkAnswer(int randChoice) {

        score++;

        if ((answer.equals("A")) &&
                randChoice == 1){
            // System.out.println("Congratulations! You're basically a saint.");
            Toast.makeText(getApplicationContext(), "Correct!",
                    Toast.LENGTH_SHORT).show();
        }
        else if ((answer.equals("B")) &&
                randChoice == 2){
            //System.out.println("Congratulations! You're basically a saint.");
            Toast.makeText(getApplicationContext(), "Correct!",
                    Toast.LENGTH_SHORT).show();
        }
        else if ((answer.equals("C")) &&
                randChoice == 3){
            //System.out.println("Congratulations! You're basically a saint.");
            Toast.makeText(getApplicationContext(), "Correct!",
                    Toast.LENGTH_SHORT).show();
        }
        else if ((answer.equals("D")) &&
                randChoice == 4){
            //System.out.println("Congratulations! You're basically a saint.");
            Toast.makeText(getApplicationContext(), "Correct!",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            // System.out.println("Bummer dude. Go read your Bible.");
            //System.out.println("The correct answer was: " + titleAnswer);
            Toast.makeText(getApplicationContext(), "Bummer!\nThe correct answer was: " + titleAnswer,
                    Toast.LENGTH_SHORT).show();
            score--;
        }

        // System.out.println("Loading next question...");
        Toast.makeText(getApplicationContext(), "Loading next question...",
                Toast.LENGTH_SHORT).show();

        getBibleData();
    }

    private String getBibleData() {

        String passageURL = "http://labs.bible.org/api/?passage=random&type=json";

        if (isNetworkAvailable()) {


            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(passageURL)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("FAILURE");
                        }
                    });
                }

                @Override
                public void onResponse(Response response) throws IOException {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("RESPONSE");
                        }
                    });
                    try {
                        String jsonData = response.body().string();
                        Log.v(TAG, jsonData);
                        System.out.println("JSONDATA");
                        System.out.println(jsonData);
                        jsonData = jsonData.substring(1,jsonData.length()-1);
                        System.out.println(jsonData);
                        if (response.isSuccessful()) {
                            //mCurrentWeather = getCurrentDetails(jsonData);
                            JSONObject passage = new JSONObject(jsonData);
                            verseText = passage.getString("text");
                            titleAnswer = passage.getString("bookname");

                            do{
                                badTitle1= BookInfo.getRandBook();
                                badTitle2= BookInfo.getRandBook();
                                badTitle3= BookInfo.getRandBook();
                            }while(titleAnswer.equals(badTitle1) || titleAnswer.equals(badTitle2) ||
                                    titleAnswer.equals(badTitle3) || badTitle1.equals(badTitle2) ||
                                    badTitle1.equals(badTitle3) ||  badTitle2.equals(badTitle3));

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //updateDisplay();
                                    verseView.setText(verseText);
                                    scoreView.setText("Score: "+ Integer.toString(score*10));

                                    int randChoice = rand.nextInt(4-1+1)+1;
                                    switch (randChoice){
                                        case 1:
//                        System.out.println("\nA. " + bibleBook.Book);
//                        System.out.println("B. " + badTitle1);
//                        System.out.println("C. " + badTitle2);
//                        System.out.println("D. " + badTitle3);
                                            choiceAButton.setText(titleAnswer);
                                            choiceBButton.setText(badTitle1);
                                            choiceCButton.setText(badTitle2);
                                            choiceDButton.setText(badTitle3);

                                            break;
                                        case 2:
//                        System.out.println("\nA. " + badTitle1);
//                        System.out.println("B. " + bibleBook.Book);
//                        System.out.println("C. " + badTitle2);
//                        System.out.println("D. " + badTitle3);
                                            choiceAButton.setText(badTitle1);
                                            choiceBButton.setText(titleAnswer);
                                            choiceCButton.setText(badTitle2);
                                            choiceDButton.setText(badTitle3);
                                            break;
                                        case 3:
//                        System.out.println("\nA. " + badTitle1);
//                        System.out.println("B. " + badTitle2);
//                        System.out.println("C. " + bibleBook.Book);
//                        System.out.println("D. " + badTitle3);
                                            choiceAButton.setText(badTitle1);
                                            choiceBButton.setText(badTitle2);
                                            choiceCButton.setText(titleAnswer);
                                            choiceDButton.setText(badTitle3);
                                            break;
                                        case 4:
//                        System.out.println("\nA. "+ badTitle1);
//                        System.out.println("B. " + badTitle2);
//                        System.out.println("C. " + badTitle3);
//                        System.out.println("D. "  + bibleBook.Book);
                                            choiceAButton.setText(badTitle1);
                                            choiceBButton.setText(badTitle2);
                                            choiceCButton.setText(badTitle3);
                                            choiceDButton.setText(titleAnswer);
                                            break;
                                    }
                                    startTrivia(randChoice);
                                }
                            });
                        } else {
                            //alertUserAboutError();
                        }
                    } catch (IOException e) {
                        Log.e(TAG, "Exception caught: ", e);
                    } catch (JSONException j) {
                        Log.e(TAG, "Exception caught: ", j);
                    }
                }
            });
        } else {
            Toast.makeText(this, "Network Unavailable", Toast.LENGTH_LONG).show();
        }
        return verseText;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }
        return isAvailable;
    }

}
