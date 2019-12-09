package serialCarType;

import java.io.Serializable;

public class CarType implements Serializable {  // класс должен реализовывать интерфейс Serializable

    private int power;
    private String brand;
    private String [] options;


    public CarType(int power, String brand, String[] options){
        this.power=power;
        this.brand=brand;
        this.options= options;
    }

    public int getPower(){
        return power;
    }
    public String getBrand() {
        return brand;
    }
    public String getOptions(){
        String optionList="";
        for (int i=0; i<options.length;i++){
            optionList+=options[i]+"";
        }
        return optionList;
    }
    public String toString() {
        return brand;
    }
}


