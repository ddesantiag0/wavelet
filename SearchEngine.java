import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;
    ArrayList<e> = 
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Search Engine", num);
        } else if (url.getPath().equals("/add")) {
            num += 1;
            return String.format("Number incremented!");
        } else {
            System.out.println("Search Engine " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("")) {
                    num += Integer.parseInt(parameters[1]);
                    return String.format("", parameters[1], num);
                }
            }
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Invalid Web Link, please try again");
            return;
        }
        else{
            for(int i = 0; i < args.length; i++){
                
            }
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
