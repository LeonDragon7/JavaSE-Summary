package com.oop.centre.petshop.service;

import com.oop.centre.petshop.domain.Dog;
import com.oop.centre.petshop.domain.PetCageInterface;
import com.oop.centre.petshop.domain.PetShop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PetShopService implements PetCageInterface {

    private List<PetShop> list = new ArrayList<>();
    private List<Double> buyPrice = new ArrayList<>();
    private List<Double> sellPrice = new ArrayList<>();
    private List<PetShop> sellRecord = new ArrayList<>();
    int len;
    @Override
    public void BuyPet(PetShop petShop, double price) {
        list.add(petShop);
        buyPrice.add(price);
        len++;
        System.out.println("买进宠物成功！");
    }

    @Override
    public void SellPet(Dog dog, double price) {
        if(len == 0){
            System.out.println("已售罄");
            return;
        }
        /*
        for (PetShop p : list) {
            //报错重写equals方法 在pet
            if(!p.getPet().equals(petShop.getPet())){
                System.out.println("太贵了，销售宠物失败！");
                break;
            }
            list.remove(len - 1);
            petShop.setSellPrice(price);
            len--;
            System.out.println("销售宠物成功!");
        }
        代码中存在一个常见的并发修改异常问题。在Java中，当你尝试在迭代集合的同时修改集合（例如添加或删除元素）时，通常会抛出ConcurrentModificationException。
        代码中，你正在遍历list集合，同时在循环中尝试删除元素，这就是问题的根源。

        这段代码使用Iterator的next()方法来获取当前元素，并使用remove()方法来删除元素，这样就可以在遍历集合的同时安全地修改集合。
         */
        PetShop p;
        Iterator<PetShop> iterator = list.iterator();
        while (iterator.hasNext()) {
            p =  iterator.next();
            if(!p.getPet().equals(dog)){
                System.out.println("太贵了，销售宠物失败！");
                break;
            }
            sellRecord.add(p);
            iterator.remove(); // 使用 Iterator 的 remove 方法来安全地删除元素
            sellPrice.add(price);
            len--;
            System.out.println("销售宠物成功!");
        }
    }

    @Override
    public void ShowPet() {
        Iterator<PetShop> iterator = list.iterator();
        while (iterator.hasNext()) {
            PetShop next =  iterator.next();
            System.out.println(next);
        }
    }

    @Override
    public void Statics() {
        if(sellRecord.size() == 0){
            return;
        }
        double buySum = 0;
        for (double sum : buyPrice) {
            buySum += sum;
        }

        double sellSum = 0;
        for (double sum : sellPrice) {
            sellSum += sum;
        }

        int i = 0;
        for (PetShop petShop : sellRecord) {
            System.out.println(petShop + ",BuyPrice = " + buyPrice.get(i) + ",SellPrice = " + sellPrice.get(i));
            i++;
        }
        System.out.println("allProfit = " + (sellSum - buySum));
    }
}
