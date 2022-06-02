public class Clear {

    public Clear(){}
    public void clear() {
        try {
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
