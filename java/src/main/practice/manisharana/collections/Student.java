package main.practice.manisharana.collections;

class Student {
    private Integer id;
    private String name;

    Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode called");
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals called :" + this);
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "[" + id + "," + name + "]";
    }
}