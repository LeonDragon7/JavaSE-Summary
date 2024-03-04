package com.oop.centre.petshop.domain;

public class PetShop {
    private String shopName;
    private Pet pet;

    public PetShop(String shopName, Pet pet) {
        this.shopName = shopName;
        this.pet = pet;
    }

    public PetShop(String shopName) {
        this.shopName = shopName;
    }

    public String getName() {
        return shopName;
    }

    public void setName(String shopName) {
        this.shopName = shopName;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }


    @Override
    public String toString() {
        return "shopName = " + shopName + ",petName = " + pet.getName()
                + ",age = " + pet.getAge();
    }
}
