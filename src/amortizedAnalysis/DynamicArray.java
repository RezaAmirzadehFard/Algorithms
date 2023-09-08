package amortizedAnalysis;



public class DynamicArray {
    private String[] data;
    private int size = 0;
    private int max = 0;

    public String[] getData(){
        return data;
    }

    public DynamicArray(int initialSize){
        this.data = new String[initialSize];
    }

    public void add(String data){
        if(this.data.length == this.max){
            String[] newData = new String[this.max * 2];
            for(int i = 0; i < this.size; i++){
                newData[i] = this.data[i];
            }

        }
    }

    public int delete(int index){
        return 0;
    }

    public static void main(String[] args){
        DynamicArray da = new DynamicArray(2);
        da.add("a");
        da.add("b");
        System.out.println(da.data.length);

        for (int i = 0; i < da.data.length; i++) {
            System.out.println(da.data[i]);
        }


    }
}
