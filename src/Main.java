public class Main {
    public static void main(String[] args){
        int[] a = {1,2,41};
        int[] b = {6};
        a = b;
        for (int elment :
                a) {
            System.out.println(elment);
        }
        System.out.println(a.length);;
    }
}
