package entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class BookInfo {
    @PrimaryKey //该字段是主键，不能重复
    @NonNull
    private  String name;
    private String author;
    private String press;
    private double price;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAthor(){
        return this.author;
    }

    public void setPress(String press){
        this.press = press;
    }
    public String getPress(){
        return this.press;
    }

    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return this.price;
    }
}
