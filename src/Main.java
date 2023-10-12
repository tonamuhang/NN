import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        ICommonInterface nn = new XORNeruralNet(2, 4, 1, 0.01, 0, 0);
    
        nn.train(null, 0);
    }
}
