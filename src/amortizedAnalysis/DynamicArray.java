package amortizedAnalysis;


import java.util.Arrays;

public class DynamicArray {
    private String[] data;
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
            for(int i = 0; i < this.max; i++){
                newData[i] = this.data[i];
            }
            this.data = newData;
        }
        this.data[max++] = data;
    }

    public static void main(String[] args){
        DynamicArray da = new DynamicArray(1);
        da.add("a");
        System.out.println(da.data.length);
        System.out.println(Arrays.toString(da.getData()));
        da.add("b");
        System.out.println(da.data.length);
        System.out.println(Arrays.toString(da.getData()));
        da.add("c");
        System.out.println(da.data.length);
        System.out.println(Arrays.toString(da.getData()));
    }
}
