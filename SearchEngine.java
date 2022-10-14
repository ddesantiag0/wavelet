import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> words = new ArrayList<String>();
    ArrayList<String> lookup = new ArrayList<String>();

    public String handleRequest(URI url) {

        words.clear();
        lookup.clear();
        
        if (url.getPath().equals("/")) {
            return String.format("Search Engine");
            
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    words.add(parameters[1]);
                    return String.format("Added: %s", parameters[1]);
                }
            }
            if (url.getPath().contains("/search")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    for (int i = 0; i < words.size(); i++) {
                        if (words.get(i).contains(parameters[1])) {
                            lookup.add(words.get(i));
                        }
                    }
                    return String.format(Arrays.toString(lookup.toArray()));

                }
            }
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number, try any number between 1024 to 49151");
            return;
        }
        
        int val = Integer.parseInt(args[0]);

        Server.start(val, new Handler());
    }
}