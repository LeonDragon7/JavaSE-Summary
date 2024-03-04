package com.oop.centre.petshop.domain;

public class Pet{
    private String petName;
    private int age;

    public Pet(String petName, int age) {
        this.petName = petName;
        this.age = age;
    }

    public String getName() {
        return petName;
    }

    public void setName(String petName) {
        this.petName = petName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof Pet){
            Pet pet = (Pet)obj;
            return this.getName().equals(pet.getName()) && this.getAge() == pet.getAge();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petName='" + petName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
