package stewart.w.thomas.biblequizzer;

/**
 * Created by rogerhull on 5/3/15.
 */
import java.util.Random;
public class BookInfo {

    public static String getRandBook(){
        String book="";

        Random rand = new Random();
        int bookNum = rand.nextInt(66 - 1 + 1) + 1;

        switch (bookNum){
            case 1:
                book = "Genesis";
                break;
            case 2:
                book = "Exodus";
                break;
            case 3:
                book = "Leviticus";
                break;
            case 4:
                book = "Numbers";
                break;
            case 5:
                book = "Deuteronomy";
                break;
            case 6:
                book = "Joshua";
                break;
            case 7:
                book = "Judges";
                break;
            case 8:
                book = "Ruth";
                break;
            case 9:
                book = "1 Samuel";
                break;
            case 10:
                book = "2 Samuel";
                break;
            case 11:
                book = "1 Kings";
            case 12:
                book = "2 Kings";
                break;
            case 13:
                book = "1 Chronicles";
                break;
            case 14:
                book = "2 Chronicles";
                break;
            case 15:
                book = "Ezra";
                break;
            case 16:
                book = "Nehemiah";
                break;
            case 17:
                book = "Esther";
                break;
            case 18:
                book = "Job";
                break;
            case 19:
                book = "Psalms";
                break;
            case 20:
                book = "Proverbs";
                break;
            case 21:
                book = "Ecclesiastes";
                break;
            case 22:
                book = "Song Of Solomon";
                break;
            case 23:
                book = "Isaiah";
                break;
            case 24:
                book = "Jeremiah";
                break;
            case 25:
                book = "Lamentations";
                break;
            case 26:
                book = "Ezekiel";
                break;
            case 27:
                book = "Daniel";
                break;
            case 28:
                book = "Hosea";
                break;
            case 29:
                book = "Joel";
                break;
            case 30:
                book = "Amos";
                break;
            case 31:
                book = "Obadiah";
                break;
            case 32:
                book = "Jonah";
                break;
            case 33:
                book = "Micah";
                break;
            case 34:
                book = "Nahum";
                break;
            case 35:
                book = "Habakkuk";
                break;
            case 36:
                book = "Zephaniah";
                break;
            case 37:
                book = "Haggai";
                break;
            case 38:
                book = "Zechariah";
                break;
            case 39:
                book = "Malachi";
                break;
            case 41:
                book = "Matthew";
                break;
            case 42:
                book = "Mark";
                break;
            case 43:
                book = "Luke";
                break;
            case 44:
                book = "John";
                break;
            case 45:
                book = "Acts";
                break;
            case 46:
                book = "Romans";
                break;
            case 47:
                book = "1 Corinthians";
                break;
            case 48:
                book = "2 Corinthians";
                break;
            case 49:
                book = "Galatians";
                break;
            case 50:
                book = "Ephesians";
                break;
            case 51:
                book = "Philippians";
                break;
            case 52:
                book = "Colossians";
                break;
            case 53:
                book = "1 Thessalonians";
                break;
            case 54:
                book = "2 Thessalonians";
                break;
            case 55:
                book = "1 Timothy";
                break;
            case 56:
                book = "2 Timothy";
                break;
            case 57:
                book = "Titus";
                break;
            case 58:
                book = "Philemon";
                break;
            case 59:
                book = "Hebrews";
                break;
            case 60:
                book = "James";
                break;
            case 61:
                book = "1 Peter";
                break;
            case 62:
                book = "2 Peter";
                break;
            case 63:
                book = "1 John";
                break;
            case 64:
                book = "2 John";
                break;
            case 65:
                book = "3 John";
                break;
            case 66:
                book = "Revelation";
                break;

            default:
                book = "error";
                break;
        }
        return book;
    }
}
